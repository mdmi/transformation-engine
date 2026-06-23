/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MessageModel;
import org.mdmi.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Equivalence;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

/**
 * @author seanmuir
 *
 */
public class MdmiUtil {

	static boolean manyToOneContainers = true;

	static HashMap<String, HashSet<String>> manyToOneMatches = new HashMap<>();

	private static Logger logger = LoggerFactory.getLogger(MdmiUtil.class);

	public static ArrayList<MDMIBusinessElementReference> getElements(MessageModel srcMessageModel,
			MessageModel trgMessageModel, final List<String> elements) {

		ArrayList<MDMIBusinessElementReference> common = new ArrayList<>();

		Map<String, MDMIBusinessElementReference> left = srcMessageModel.getBusinessElementHashMap();

		Map<String, MDMIBusinessElementReference> right = trgMessageModel.getBusinessElementHashMap();

		Equivalence<MDMIBusinessElementReference> valueEquivalence = new Equivalence<>() {

			@Override
			protected boolean doEquivalent(MDMIBusinessElementReference a, MDMIBusinessElementReference b) {

				return a.getUniqueIdentifier().equals(b.getUniqueIdentifier());
			}

			@Override
			protected int doHash(MDMIBusinessElementReference t) {
				return t.getUniqueIdentifier().hashCode();
			}
		};

		MapDifference<String, MDMIBusinessElementReference> differences = Maps.difference(
			left, right, valueEquivalence);

		Predicate<MDMIBusinessElementReference> predicate = new Predicate<>() {

			@Override
			public boolean apply(MDMIBusinessElementReference input) {

				if (!elements.isEmpty()) {
					for (String element : elements) {
						if (input.getName().equalsIgnoreCase(element) ||
								input.getUniqueIdentifier().equalsIgnoreCase(element)) {
							logger.trace("SEER in filter " + input.getName() + "::" + input.getUniqueIdentifier());
							return true;
						}
					}

					return false;
				}
				return true;

			}
		};

		if (!srcMessageModel.equals(trgMessageModel)) {
			if (logger.isTraceEnabled()) {

				StringBuffer onlyinsourcelog = new StringBuffer();
				StringBuffer onlyinTargetlog = new StringBuffer();
				StringBuffer commonlog = new StringBuffer();

				for (MDMIBusinessElementReference mber : differences.entriesOnlyOnLeft().values()) {

					onlyinsourcelog.append(
						"SEER Elements : Only in source " + mber.getName() + " " + mber.getUniqueIdentifier()).append(
							System.lineSeparator());

				}
				for (MDMIBusinessElementReference mber : differences.entriesInCommon().values()) {

					commonlog.append(
						"SEER Elements : Common to both messages " + mber.getName() + " " +
								mber.getUniqueIdentifier()).append(System.lineSeparator());

				}
				for (MDMIBusinessElementReference mber : differences.entriesOnlyOnRight().values()) {
					onlyinTargetlog.append(
						"SEER Elements : Only in target " + mber.getName() + " " + mber.getUniqueIdentifier()).append(
							System.lineSeparator());
				}

				try {
					Files.createDirectories(Paths.get("./logs"));

					Files.write(Paths.get("./logs/OnlyInSource.log"), onlyinsourcelog.toString().getBytes());
					Files.write(Paths.get("./logs/Common.log"), commonlog.toString().getBytes());
					Files.write(Paths.get("./logs/OnlyTarget.log"), onlyinTargetlog.toString().getBytes());

				} catch (IOException e) {
					logger.trace("Unable to log datatypes");
				}

			}
			common.addAll(Collections2.filter(differences.entriesInCommon().values(), predicate));
		} else {

			for (MDMIBusinessElementReference mber : differences.entriesOnlyOnLeft().values()) {
				logger.trace("BOOM  in source " + mber.getName() + " " + mber.getUniqueIdentifier());

			}

			for (MDMIBusinessElementReference mber : differences.entriesInCommon().values()) {
				logger.trace(
					"SEER Elements : Common to both messages " + mber.getName() + " " + mber.getUniqueIdentifier());

			}

			for (MDMIBusinessElementReference mber : differences.entriesOnlyOnRight().values()) {
				logger.trace("BOOM in target " + mber.getName() + " " + mber.getUniqueIdentifier());

			}

			common.addAll(Collections2.filter(differences.entriesInCommon().values(), predicate));
		}

		logger.debug("Size of Common BE " + common.size());

		if (manyToOneContainers) {

		}

		return common;

	}

	/**
	 * Get the model path to the given node.
	 *
	 * @param node
	 *            The node.
	 * @return The path (XPath) to this node.
	 */
	public static String getNodePath(Node node) {
		Node parent = node.getParentNode();
		String name = node.getLocation();
		if (parent == null) {
			return name;
		}
		String p = getNodePath(parent);
		if (name.startsWith("@")) {
			return p + name;
		}
		return p + '/' + name;
	}

}
