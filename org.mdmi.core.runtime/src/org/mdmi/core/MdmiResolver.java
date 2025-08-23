/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.mdmi.core.Mdmi.MapInfo;
import org.mdmi.core.engine.SemanticParser;
import org.mdmi.core.engine.parsers.ml.MLSyntacticParser;
import org.mdmi.core.engine.postprocessors.IPostProcessor;
import org.mdmi.core.engine.preprocessors.IPreProcessor;
import org.mdmi.util.MDMIUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Resolver for MDMI maps, syntax and semantic parsers. It loads and parses the maps, and the parsers. This
 * implementation caches all message groups.
 */
public class MdmiResolver {

	private static Logger logger = LoggerFactory.getLogger(MdmiResolver.class);

	static protected HashMap<String, MI> themaps = new HashMap<>();

	public synchronized HashMap<String, MI> getMaps() {
		return themaps;
	}

	public static class Map {

		/**
		 * @param name
		 * @param display
		 */
		public Map(String name, String display) {
			super();
			this.name = name;
			this.display = display;
		}

		String name;

		String display;

		/**
		 * @return the family
		 */

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the display
		 */
		public String getDisplay() {
			return display;
		}

		/**
		 * @param display
		 *            the display to set
		 */
		public void setDisplay(String display) {
			this.display = display;
		}

	}

	public ArrayList<Map> getActiveMaps() {
		return getActiveMaps(null);
	}

	public ArrayList<Map> getActiveMaps(ArrayList<String> filter) {
		ArrayList<Map> maps = new ArrayList<>();

		maps.add(new Map("Mdmi.RUNTIMEVERSION", Mdmi.RUNTIMEVERSION));

		maps.add(new Map("Mdmi.RUNTIMEBUILD", Mdmi.RUNTIMEBUILD));

		for (String key : Mdmi.INSTANCE().getResolver().getMaps().keySet()) {
			if (filter == null || (filter != null && filter.contains(key))) {
				MI mi = Mdmi.INSTANCE().getResolver().getMaps().get(key);
				for (MessageModel mm : mi.messageGroup.getModels()) {
					if (mm.getDescription() != null) {
						maps.add(new Map(key, mm.getDescription()));
					} else {
						maps.add(new Map(key, key));
					}
				}
			}
		}
		return maps;

	}

	@SuppressWarnings("unchecked")
	public String getEngineConfigurations() {
		ArrayList<Object> configurations = new ArrayList<Object>();
		configurations.addAll(getActiveMaps());
		// TODO Fix issue with GSON serialization on processors
		// configurations.addAll(Mdmi.INSTANCE().getPreProcessors().getPreProcessors());
		// configurations.addAll(Mdmi.INSTANCE().getPostProcessors().getPostProcessors());
		for (IPreProcessor preprocessor : Mdmi.INSTANCE().getPreProcessors().getPreProcessors()) {
			configurations.add(preprocessor.getName());
		}
		for (IPostProcessor postprocessor : Mdmi.INSTANCE().getPostProcessors().getPostProcessors()) {
			configurations.add(postprocessor.getName());
		}
		Gson gsonBuilder = new GsonBuilder().create();
		return gsonBuilder.toJson(configurations);
	}

	/**
	 * Create a new instance and resolve the MDMI maps specified in the configuration file.
	 *
	 * @param config
	 *            Configuration data, used to locate the MDMI maps and providers.
	 */
	public MdmiResolver() {

	}

	static HashMap<String, List<MessageGroup>> loadedGroups = new HashMap<>();

	private InputStream createInputStreamfromURI(String uri) {

		File file = new File(uri);

		try {
			FileInputStream fileStream = new FileInputStream(file);
			return new BufferedInputStream(fileStream);
		} catch (FileNotFoundException exc) {
			throw new MdmiException(exc, "MapBuilder: file {0} not found!", file.getAbsolutePath());
		} catch (Throwable t) {
			throw new MdmiException(t, "MapBuilder: file {0} not found!", file.getAbsolutePath());
		}
	}

	public void resolve(InputStream inputStream) throws IOException {

		synchronized (themaps) {

			MessageGroup messageGroup = MDMIUtil.load(inputStream);

			// for (MessageGroup messageGroup : mgs) {
			logger.debug("Loaded message group " + messageGroup.getName());
			for (MessageModel messageModel : messageGroup.getModels()) {
				logger.debug("Loaded message model " + messageModel.getMessageModelName());
				MapInfo mapInfo = new MapInfo();
				mapInfo.mapName = createKey(messageGroup.getName(), messageModel.getMessageModelName());
				MI mi = new MI(mapInfo, messageGroup);
				themaps.put(createKey(messageGroup.getName(), messageModel.getMessageModelName()), mi);
			}
		}

	}

	/**
	 * Resolve (load and parse) the specified MDMI map.
	 *
	 * @param mapInfo
	 *            The map info structure containing map location information.
	 * @return The message groups in the given map, if it is valid.
	 */
	public void resolveOne(Mdmi.MapInfo mapInfo) {

		synchronized (themaps) {
			MessageGroup mg = MDMIUtil.load(mapInfo.mapFileName);
			MI mi = new MI(mapInfo, mg);
			logger.debug("Loaded message group " + mg.getName());

			for (MessageModel mm : mg.getModels()) {
				String s = createKey(mg.getName(), mm.getMessageModelName());
				logger.debug("Loaded message model " + s);
				themaps.put(s, mi);
			}
		}

	}

	public String createKey(String group, String model) {
		return group + "." + model;
	}

	/**
	 * Get the requested message model by group and message name.
	 *
	 * @param messageGroup
	 *            The message group name.
	 * @param messageModel
	 *            The message model name.
	 * @return The model if found, null otherwise.
	 */
	public MessageModel getModel(String messageGroup, String messageModel) {
		// if (messageGroup == null || messageModel == null) {
		// throw new IllegalArgumentException("Null argument");
		// }
		synchronized (themaps) {
			MI mi = themaps.get(createKey(messageGroup, messageModel));
			if (mi == null) {
				logger.error("cant find " + createKey(messageGroup, messageModel));
				return null;
			}
			return mi.messageGroup.getModel(messageModel);
		}
	}

	/**
	 * Get the requested message group by group name.
	 *
	 * @param messageGroup
	 *            The message group name.
	 * @return The message group if found, null otherwise.
	 */
	// public MessageGroup getMessageGroup(String messageGroup) {
	// if (messageGroup == null) {
	// throw new IllegalArgumentException("Null argument");
	// }
	// MI mi = m_maps.get(messageGroup);
	// if (mi == null) {
	// return null;
	// }
	// return mi.messageGroup;
	// }

	/**
	 * Get the message group for the specified MdmiValueSetsHandler.
	 *
	 * @param vsh
	 *            The value set handler.
	 * @return The message group if found, null otherwise.
	 */
	public MessageGroup getMessageGroup(MdmiValueSetsHandler vsh) {

		synchronized (themaps) {
			if (vsh == null) {
				throw new IllegalArgumentException("Null argument");
			}
			Collection<MI> c = themaps.values();
			for (Iterator<MI> it = c.iterator(); it.hasNext();) {
				MI mi = it.next();
				if (mi.valueSetsHandler == vsh) {
					return mi.messageGroup;
				}
			}
			return null;
		}
	}

	/**
	 * Get a list of all known message groups.
	 *
	 * @return A list of all known message groups.
	 */
	public Collection<MessageGroup> getMessageGroups() {
		synchronized (themaps) {
			ArrayList<MessageGroup> a = new ArrayList<>();
			Collection<MI> c = themaps.values();
			for (Iterator<MI> it = c.iterator(); it.hasNext();) {
				MI mi = it.next();
				a.add(mi.messageGroup);
			}
			return a;
		}
	}

	/**
	 * Get the syntax parser for the specified message group.
	 *
	 * @param messageGroup
	 *            The message group name to look for.
	 * @return The syntax parser for the specified group, or null if the group is not found.
	 */
	public ISyntacticParser getSyntacticParser(String messageGroup, String messageModel) {
		synchronized (themaps) {
			if (messageGroup == null) {
				throw new IllegalArgumentException("Null argument");
			}
			MI mi = themaps.get(createKey(messageGroup, messageModel));
			if (mi == null) {
				return null;
			}
			return mi.getSyntaxParser();
		}
	}

	/**
	 * Get the value sets handler for the specified message group.
	 *
	 * @param messageGroup
	 *            The message group name to look for.
	 * @return The enumeration converter for the specified message group, or null if the group is not found.
	 */
	public MdmiValueSetsHandler getValueSetsHandler(String messageGroup, String messageModel) {
		synchronized (themaps) {
			if (messageGroup == null) {
				throw new IllegalArgumentException("Null argument");
			}

			MI mi = themaps.get(createKey(messageGroup, messageModel));
			if (mi == null) {
				return null;
			}
			return mi.valueSetsHandler;
		}
	}

	/**
	 * Get the semantic parser for the specified message group.
	 *
	 * @param messageGroup
	 *            The message group name to look for.
	 * @param string
	 * @return The semantic parser for the specified group, or null if the group is not found.
	 */
	public ISemanticParser getSemanticParser(String messageGroup, String messageModel) {
		synchronized (themaps) {
			if (messageGroup == null) {
				throw new IllegalArgumentException("Null argument");
			}
			MI mi = themaps.get(createKey(messageGroup, messageModel));
			if (mi == null) {
				return null;
			}
			return mi.getSemanticParser();
		}
	}

	public final class MI {
		Mdmi.MapInfo mapInfo;

		public MessageGroup messageGroup;

		ISemanticParser semanticSvcProvider;

		MdmiValueSetsHandler valueSetsHandler;

		public String datatypemappings;

		public MI(Mdmi.MapInfo mapInfo, MessageGroup messageGroup) {
			this.mapInfo = mapInfo;
			this.messageGroup = messageGroup;
		}

		ISyntacticParser getSyntaxParser() {

			if (messageGroup != null) {
				if (messageGroup.getDefaultLocationExprLang() != null) {
					try {
						switch (messageGroup.getDefaultLocationExprLang()) {
							case "JSON":
								return new org.mdmi.core.engine.parsers.json.JsonSyntacticParser();
							case "HL7":
								return (ISyntacticParser) Class.forName(
									"org.openhealthtools.mdht.mdmiplugins.parsers.HL7Parser").getDeclaredConstructor().newInstance();
							case "QUERY":
								return (ISyntacticParser) Class.forName(
									"org.mdmi.engine.parsers.QuerySyntaxParser").getDeclaredConstructor().newInstance();
							case "ML":
								return new MLSyntacticParser();
							// (ISyntacticParser) Class.forName(
							// "org.mdmi.engine.parsers.MLSyntacticParser").newInstance();
							default:
								// TreeWalker tw;
								return new org.mdmi.core.engine.parser.xml.DOMSAXSyntacticParser(messageGroup.getName());
						}
					} catch (Exception e) {
						e.printStackTrace();

					}

				}

			}

			return new org.mdmi.core.engine.parser.xml.DOMSAXSyntacticParser(messageGroup.getName());

		}

		ISemanticParser getSemanticParser() {

			return new SemanticParser(messageGroup);

		}
	} // MdmiMapResolver$MT

	/**
	 * @param instance
	 */
	public void load(Mdmi instance) {
		Collection<Mdmi.MapInfo> mes = Mdmi.INSTANCE().getAllMapInfos();
		for (Iterator<Mdmi.MapInfo> iterator = mes.iterator(); iterator.hasNext();) {
			Mdmi.MapInfo me = iterator.next();
			resolveOne(me);
		}
	}
} // MdmiMapResolver
