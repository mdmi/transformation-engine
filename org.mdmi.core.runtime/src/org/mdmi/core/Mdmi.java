/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;

import org.mdmi.core.engine.MdmiEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MDMI main entry point.
 *
 * @author goancea
 */
public final class Mdmi {

	/**
	 * Metadata about one MDMI map.
	 *
	 * @author goancea
	 */
	public static class MapInfo {
		public String mapName;

		public String mapFileName;

		// public String mapBuilderClassName;

		public String synSvcClassName;

		public String synSvcJarName;

		public String semSvcClassName;

		public String semSvcJarName;

		/**
		 * Default ctor.
		 */
		public MapInfo() {
		}

		/**
		 * Construct a new MapInfo from a map name and file name.
		 *
		 * @param mapName
		 *            The map name to use. It is used internally to identify a given map.
		 * @param mapFile
		 *            The file name to use.
		 */
		public MapInfo(String mapName, String mapFile) {
			this(mapName, mapFile, "org.mdmi.model.xmi.direct.reader.MapBuilderXMIDirect");
		}

		/**
		 * Construct a new instance using the given parameters.
		 *
		 * @param mapName
		 *            The map name to use. It is used internally to identify a given map.
		 * @param mapFile
		 *            The file name to use.
		 * @param mapBuilder
		 *            The builder class name to use for reading/resolving the map.
		 */
		public MapInfo(String mapName, String mapFile, String mapBuilder) {
			this.mapName = mapName;
			mapFileName = mapFile;
			// mapBuilderClassName = mapBuilder;
		}
	} // MdmiConfig$MapInfo

	public static String RUNTIMEVERSION = "MISSING";

	public static String RUNTIMEBUILD = "MISSING";

	private static Logger logger = LoggerFactory.getLogger(Mdmi.class);

	public static final String PARAM_MDMI_ROOT_DIR = "mdmi.root.dir";

	static private ThreadLocal<Mdmi> mdmiThreadLocal = new ThreadLocal<>() {

		/*
		 * (non-Javadoc)
		 *
		 * @see java.lang.ThreadLocal#initialValue()
		 */
		@Override
		protected Mdmi initialValue() {
			return new Mdmi();
		}

	};

	public static final Mdmi INSTANCE() {
		logger.trace("Call  public static final Mdmi INSTANCE() " + Thread.currentThread().getName());
		return mdmiThreadLocal.get();

	}

	private File m_rootDir;

	private MdmiResolver m_resolver;

	private MdmiEngine m_engine;

	private MdmiPreProcessors m_preProcessors = new MdmiPreProcessors();

	private MdmiPostProcessors m_postProcessors = new MdmiPostProcessors();

	private SourceSemanticModelProcessors sourceSemanticModelProcessors = new SourceSemanticModelProcessors();

	/**
	 * @return the sourceSemanticModelProcessors
	 */
	public SourceSemanticModelProcessors getSourceSemanticModelProcessors() {
		return sourceSemanticModelProcessors;
	}

	private TargetSemanticModelProcessors targetSemanticModelProcessors = new TargetSemanticModelProcessors();

	/**
	 * @return the targetSemanticModelProcessors
	 */
	public TargetSemanticModelProcessors getTargetSemanticModelProcessors() {
		return targetSemanticModelProcessors;
	}

	private HashMap<String, MapInfo> m_mapInfos = new HashMap<>();

	public HashMap<String, MapInfo> getMaps() {
		return m_mapInfos;
	}

	/**
	 * Initialize this runtime, by specifying the root folder where normally the mdmi config file resides.
	 *
	 * @param rootDir
	 *            The root folder where this runtime is initialized from.
	 */
	public void initialize(File rootDir) {
		if (rootDir == null || !rootDir.exists() || !rootDir.isDirectory()) {
			rootDir = getDefaultRootDir();
		}
		m_rootDir = rootDir;
		logger.debug("MDMI Runtime initialized from " + m_rootDir.getAbsolutePath());
	}

	/**
	 * Starts the runtime.
	 * This method will load the configuration data from the 'mdmi.config' file in the root folder,
	 * and then it will initialize and start the runtime.
	 */
	public void start() {
		startImpl();
		try {
			Properties prop = new Properties();

			InputStream xxx = getClass().getClassLoader().getResourceAsStream("version.properties");
			if (xxx != null) {
				prop.load(xxx);
				RUNTIMEVERSION = prop.getProperty("version");
				RUNTIMEBUILD = prop.getProperty("build.date");
				System.setProperty("mdmi.engine.version", RUNTIMEVERSION + " :: " + RUNTIMEBUILD);

			}

		} catch (IOException e) {

		}

		// getPreProcessors().addPreProcessor(new Deliminated2XML("CSV2XML", ","));
		// getPreProcessors().addPreProcessor(new HL7V2MessagePreProcessor());
		// getPreProcessors().addPreProcessor(new PreProcessorForFHIRJson());

		// getPostProcessors().addPostProcessor(new XML2Deliminated("XML2CSV", ","));
		// getPostProcessors().addPostProcessor(new XML2Deliminated("XML2PIPE", "\\|"));
		// getPostProcessors().addPostProcessor(new CDAPostProcessor());
		// getPostProcessors().addPostProcessor(new HL7V2MessagePostProcessor());
		// getPostProcessors().addPostProcessor(new SQLInsertPostProcessor());
		// getPostProcessors().addPostProcessor(new FHIRSTU3PostProcessorJson());
		// getPostProcessors().addPostProcessor(new FHIRR4PostProcessorJson());

	}

	/**
	 * Starts the runtime.
	 * This method will use the given configuration file, and then it will initialize and start the runtime.
	 *
	 * @param config
	 *            The configuration data to use.
	 */

	/**
	 * Starts the runtime.
	 * This method will use the given configuration file, and then it will initialize and start the runtime.
	 *
	 * @param config
	 *            The configuration data to use.
	 */
	private void startImpl() {

		m_resolver = new MdmiResolver();
		setM_engine(new MdmiEngine(this));
		getEngine().start();
	}

	/**
	 * Stop the runtime, unload all configuration.
	 */
	public void stop() {
		getEngine().stop();
		setM_engine(null);
		m_resolver = null;
		m_preProcessors = null;
		m_postProcessors = null;

	}

	/**
	 * Get the root folder from where the runtime is started.
	 *
	 * @return The root folder from where the runtime is started.
	 */
	public File rootDir() {
		return m_rootDir;
	}

	/**
	 * Get the configuration data for this instance.
	 * Note that if you modify this, it is recommended that you can stop() and start() to reset the runtime properly.
	 *
	 * @return The configuration data for this instance.
	 */

	/**
	 * Get the MDMI model resolver for this runtime instance.
	 *
	 * @return The MDMI model resolver for this runtime instance.
	 */
	public MdmiResolver getResolver() {
		return m_resolver;
	}

	/**
	 * Get the wrapper for the pre-processors.
	 *
	 * @return The wrapper for the pre-processors.
	 */
	public MdmiPreProcessors getPreProcessors() {
		return m_preProcessors;
	}

	/**
	 * Get the wrapper for the post-processors.
	 *
	 * @return The wrapper for the post-processors.
	 */
	public MdmiPostProcessors getPostProcessors() {
		return m_postProcessors;
	}

	/**
	 * Utility method to get a relative path to the root folder.
	 *
	 * @param relPath
	 *            The relative path (may be a file or folder).
	 * @return The File that wraps the relative path, can be used to get the absolute path.
	 */
	public File fileFromRelPath(String relPath) {
		return new File(m_rootDir, relPath);
	}

	/**
	 * Execute the specified transfer synchronously.
	 *
	 * @param transferInfo
	 *            The transfer to execute.
	 */
	public void executeTransfer(MdmiTransferInfo transferInfo) {
		logger.trace("Start executeTransfer(MdmiTransferInfo transferInfo)  " + Thread.currentThread().getName());
		exec(transferInfo, false);
		logger.trace("End executeTransfer(MdmiTransferInfo transferInfo)  " + Thread.currentThread().getName());
	}

	/**
	 * Execute the specified transfer synchronously.
	 *
	 * @param transferInfo
	 *            The transfer to execute.
	 */
	public void executeTransferAsync(MdmiTransferInfo transferInfo) {
		exec(transferInfo, true);
	}

	// public static IExpressionInterpreter getInterpreter(ConversionRule cr, XElementValue context, String name,
	// XValue value) {
	// String lang = cr.getRuleExpressionLanguage();
	// SemanticElement se = cr.getOwner();
	// if (null == lang || lang.length() <= 0) {
	// SemanticElementSet ses = se.getElementSet();
	// MessageModel mm = ses.getModel();
	// MessageGroup mg = mm.getGroup();
	// lang = mg.getDefaultRuleExprLang();
	// if (lang == null || lang.length() <= 0) {
	// throw new MdmiException(
	// "Language not set for conversion in semantic element {0} and no default set in model group {1}",
	// se.getName(), mg.getName());
	// }
	// }
	// return getInterpreter(lang, context, name, value);
	// }
	//
	// public static IExpressionInterpreter getInterpreter(DataRule dr, XElementValue context, String name, XValue value) {
	// String lang = dr.getRuleExpressionLanguage();
	// SemanticElement se = dr.getSemanticElement();
	// if (null == lang || lang.length() <= 0) {
	// SemanticElementSet ses = se.getElementSet();
	// MessageModel mm = ses.getModel();
	// MessageGroup mg = mm.getGroup();
	// lang = mg.getDefaultRuleExprLang();
	// if (lang == null || lang.length() <= 0) {
	// throw new MdmiException(
	// "Language not set for data rule in semantic element {0} and no default set in model group {1}",
	// se.getName(), mg.getName());
	// }
	// }
	// return getInterpreter(lang, context, name, value);
	// }
	//
	// public static IExpressionInterpreter getInterpreter(SemanticElementBusinessRule sebr, XElementValue context,
	// String name, XValue value) {
	// String lang = sebr.getRuleExpressionLanguage();
	// SemanticElement se = sebr.getSemanticElement();
	// if (null == lang || lang.length() <= 0) {
	// SemanticElementSet ses = se.getElementSet();
	// MessageModel mm = ses.getModel();
	// MessageGroup mg = mm.getGroup();
	// lang = mg.getDefaultRuleExprLang();
	// if (lang == null || lang.length() <= 0) {
	// throw new MdmiException(
	// "Language not set for business rule in semantic element {0} and no default set in model group {1}",
	// se.getName(), mg.getName());
	// }
	// }
	// return getInterpreter(lang, context, name, value);
	// }
	//
	// public static IExpressionInterpreter getInterpreter(SemanticElementRelationship ser, XElementValue context,
	// String name, XValue value) {
	// String lang = ser.getRuleExpressionLanguage();
	// SemanticElement se = ser.getContext();
	// if (null == lang || lang.length() <= 0) {
	// SemanticElementSet ses = se.getElementSet();
	// MessageModel mm = ses.getModel();
	// MessageGroup mg = mm.getGroup();
	// lang = mg.getDefaultRuleExprLang();
	// if (lang == null || lang.length() <= 0) {
	// throw new MdmiException(
	// "Language not set for business rule in semantic element {0} and no default set in model group {1}",
	// se.getName(), mg.getName());
	// }
	// }
	// return getInterpreter(lang, context, name, value);
	// }

	// public static IExpressionInterpreter getInterpreter(String lang, XElementValue context, String name, XValue value) {
	// if (lang == null || lang.length() <= 0) {
	// throw new MdmiException("Language not set!");
	// }
	// if (lang.equalsIgnoreCase("js") || lang.equalsIgnoreCase("javascript")) {
	// return new JsAdapter(
	// context == null
	// ? null
	// : context.getOwner(),
	// name, value);
	// }
	// throw new MdmiException("Language {0} not supported!", lang);
	// }

	// call the engine to execute
	private void exec(MdmiTransferInfo transferInfo, boolean async) {
		try {
			logger.trace("exec(MdmiTransferInfo transferInfo, boolean async)  " + Thread.currentThread().getName());
			transferInfo.sourceModel.resolve();
			transferInfo.targetModel.resolve();
			// if (async) {
			// getEngine().executeTransferAsync(transferInfo);
			// } else {
			logger.trace("Start getEngine().executeTransfer(transferInfo)" + Thread.currentThread().getName());
			getEngine().executeTransfer(transferInfo);
			logger.trace("End getEngine().executeTransfer(transferInfo)" + Thread.currentThread().getName());
			// }
		} catch (MdmiException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MdmiException(
				ex, "Mdmi.exec() Unexpected exception for transformnation " + transferInfo.toString());
		}
	}

	private Mdmi() {
		init();
	}

	private void init() {
		this.start();
	}

	// load the configuration data.

	// get the default root folder, if none was specified
	private static File getDefaultRootDir() {
		String d = System.getProperties().getProperty(PARAM_MDMI_ROOT_DIR);
		if (d != null) {
			File f = new File(d);
			if (f.exists() && f.isDirectory()) {
				return f;
			}
		}
		d = System.getProperties().getProperty("user.dir");
		return new File(d);
	}

	/**
	 * @param mapInfo
	 */
	public void putMapInfo(MapInfo me) {
		m_mapInfos.put(me.mapName, me);

	}

	/**
	 * @return
	 */
	public Collection<MapInfo> getAllMapInfos() {
		return m_mapInfos.values();
	}

	/**
	 * @param s
	 * @return
	 */
	public MapInfo getMapInfoByFileName(String mapFileName) {
		for (MapInfo me : m_mapInfos.values()) {
			if (me.mapFileName.equals(mapFileName)) {
				return me;
			}
		}
		return null;
	}

	/**
	 * @param mapName
	 * @return
	 */
	public MapInfo getMapInfo(String mapName) {
		return m_mapInfos.get(mapName);
	}

	/**
	 * @param mapName
	 */
	public void removeMapInfo(String mapName) {
		m_mapInfos.remove(mapName);
	}

	/**
	 * @return the m_engine
	 */
	public MdmiEngine getEngine() {
		return m_engine;
	}

	/**
	 * @param m_engine
	 *            the m_engine to set
	 */
	public void setM_engine(MdmiEngine m_engine) {
		this.m_engine = m_engine;
	}

	/**
	 * @param sMod
	 * @param tMsg
	 * @param semchild
	 * @param bers
	 * @param location
	 */
	// public void executeTransfer(MdmiModelRef sMod, MdmiMessage tMsg, SemanticElement semanticContainer,
	// ArrayList<MDMIBusinessElementReference> bers, List<SemanticElement> semanticElements, String location) {
	// try {
	// getEngine().executeTransfer(sMod, tMsg, bers, semanticContainer, semanticElements, location);
	// } catch (MdmiException ex) {
	// throw ex;
	// } catch (Exception ex) {
	// throw new MdmiException(ex, "Mdmi.exec() Unexpected exception for transformnation ");
	// }
	//
	// }
} // Mdmi
