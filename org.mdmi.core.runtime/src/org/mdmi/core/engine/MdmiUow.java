/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.eclipse.emf.common.util.EList;
import org.mdmi.Bag;
import org.mdmi.ConversionRule;
import org.mdmi.DTCStructured;
import org.mdmi.Field;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MDMIDatatype;
import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.mdmi.Node;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementBusinessRule;
import org.mdmi.SemanticElementRelationship;
import org.mdmi.SemanticElementType;
import org.mdmi.core.ElementValueSet;
import org.mdmi.core.IElementValue;
import org.mdmi.core.ISemanticParser;
import org.mdmi.core.ISyntacticParser;
import org.mdmi.core.ISyntaxNode;
import org.mdmi.core.Mdmi;
import org.mdmi.core.MdmiResolver;
import org.mdmi.core.MdmiTransferInfo;
import org.mdmi.core.engine.javascript.Utils;
import org.mdmi.core.engine.semanticprocessors.LogSemantic;
import org.mdmi.core.engine.semanticprocessors.LogSemantic.DIRECTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * MDMI Unit of Work. Will execute a transfer from the source to the target
 * messages, based on the given maps.
 *
 *
 */
public class MdmiUow implements Runnable {

	public static Logger logger = LoggerFactory.getLogger(MdmiUow.class);

	MdmiEngine owner;

	MdmiTransferInfo transferInfo;

	ISyntaxNode srcSyntaxModel;

	/**
	 * @return the srcSyntaxModel
	 */
	public ISyntaxNode getSrcSyntaxModel() {
		return srcSyntaxModel;
	}

	/**
	 * @param srcSyntaxModel
	 *            the srcSyntaxModel to set
	 */
	public void setSrcSyntaxModel(ISyntaxNode srcSyntaxModel) {
		this.srcSyntaxModel = srcSyntaxModel;
	}

	/**
	 * @return the trgSyntaxModel
	 */
	public ISyntaxNode getTrgSyntaxModel() {
		return trgSyntaxModel;
	}

	/**
	 * @param trgSyntaxModel
	 *            the trgSyntaxModel to set
	 */
	public void setTrgSyntaxModel(ISyntaxNode trgSyntaxModel) {
		this.trgSyntaxModel = trgSyntaxModel;
	}

	ElementValueSet srcSemanticModel;

	ISyntaxNode trgSyntaxModel;

	ElementValueSet trgSemanticModel;

	/**
	 * serializeSemanticModel is temporary approach to suppress serialize semantic model within web container
	 *
	 */
	static boolean serializeSemanticModel = false;

	public static boolean isSerializeSemanticModel() {
		return serializeSemanticModel;
	}

	public static void setSerializeSemanticModel(boolean serializeSemanticModel) {
		MdmiUow.serializeSemanticModel = serializeSemanticModel;
	}

	/**
	 * Construct a new unit of work instance with the given owner and transfer
	 * info.
	 *
	 * @param owner
	 *            The actual owner.
	 * @param transferInfo
	 *            The transfer info - data used to execute a transfer.
	 */
	MdmiUow(MdmiEngine owner, MdmiTransferInfo transferInfo) {
		this.owner = owner;
		this.transferInfo = transferInfo;

	}

	/**
	 * @param mdmiEngine
	 */
	public MdmiUow(MdmiEngine owner) {
		this.owner = owner;
	}

	public static boolean compareSourceAndTarget = false;

	@Override
	public void run() {

		try {

			StopWatch watch = new StopWatch();
			watch.start();
			logger.info("Execute preProcess " + Thread.currentThread().getName());
			preProcess();
			watch.split();
			logger.info("Split preProcess: " + watch.toSplitString());
			logger.info("Execute processInboundSourceMessage " + Thread.currentThread().getName());
			processInboundSourceMessage();
			watch.split();
			logger.info("Split processInboundSourceMessage: " + watch.toSplitString());

			logger.info("Execute processInboundTargetMessage " + Thread.currentThread().getName());
			processInboundTargetMessage();
			watch.split();
			logger.info("Split processInboundTargetMessage: " + watch.toSplitString());

			logger.info("Execute processSourceSemanticModel " + Thread.currentThread().getName());
			processSourceSemanticModel();
			watch.split();
			logger.info("Split processSourceSemanticModel: " + watch.toSplitString());

			logger.info("Execute processConversions " + Thread.currentThread().getName());
			processConversions();
			watch.split();
			logger.info("Split processConversions: " + watch.toSplitString());

			logger.trace("processTargetSemanticModelprocessTargetSemanticModelprocessTargetSemanticModel");
			processTargetSemanticModel();
			watch.split();
			logger.info("Split processConversions: " + watch.toSplitString());
			logger.info("Done processConversions " + Thread.currentThread().getName());

			logger.info("Execute processOutboundTargetMessage " + Thread.currentThread().getName());
			processOutboundTargetMessage();
			watch.split();
			logger.info("Split processOutboundTargetMessage: " + watch.toSplitString());

			logger.info("Execute postProcess " + Thread.currentThread().getName());
			postProcess();
			watch.split();
			logger.info("Split postProcess: " + watch.toSplitString());
			watch.stop();

			logger.info(Thread.currentThread().getName() + " Process Message in MILLISECONDS: " + watch.getTime());

		} catch (

		RuntimeException ex) {
			logger.error("Exception during transformation", ex);
		}
	}

	// 0. Call the pre-processors, if any
	void preProcess() {
		Mdmi.INSTANCE().getPreProcessors().preProcess(transferInfo);
	}

	// 1. Build the source syntax tree and semantic model
	void processInboundSourceMessage() {

		StopWatch watch = new StopWatch();
		watch.start();

		ISyntacticParser srcSynProv = getSyntaxProvider(transferInfo.getSourceMessageGroup());

		ISemanticParser srcSemProv = getSemanticProvider(transferInfo.getSourceMessageGroup());
		if (logger.isTraceEnabled()) {
			logger.trace(transferInfo.sourceMessage.getDataAsString());
		}

		watch.split();
		logger.info("getSyntaxProvider and getSemanticProvider : " + watch.toSplitString());

		srcSyntaxModel = srcSynProv.parse(transferInfo.sourceModel.getModel(), transferInfo.sourceMessage);

		watch.split();
		logger.info("parse : " + watch.toSplitString());

		if (logger.isTraceEnabled()) {
			try {
				Files.createDirectories(Paths.get("./logs"));

				Gson gson = new GsonBuilder().setPrettyPrinting().create();

				String json = gson.toJson(transferInfo.sourceMessage.getUnspecifiedNodes());
				Files.write(Paths.get("./logs/unspececified.json"), json.getBytes());
			} catch (IOException e) {
				logger.trace("Unable to log datatypes");
			}
		}

		if (logger.isTraceEnabled()) {
			try {
				Files.createDirectories(Paths.get("./logs"));

				Files.write(Paths.get("./logs/sourcesyntax.log"), srcSyntaxModel.toString().getBytes());

			} catch (IOException e) {
				logger.trace("Unable to log srcSyntaxModel");
			}
		}

		logger.debug("Source Syntax Model : \n" + srcSyntaxModel.toString());

		srcSemanticModel = new ElementValueSet();

		srcSemProv.buildSemanticModel(
			transferInfo.sourceModel.getModel(), srcSyntaxModel, srcSemanticModel, transferInfo.sourceProperties,
			transferInfo.sourceValues);

		watch.split();
		logger.info("buildSemanticModel : " + watch.toSplitString());

	}

	void logElementSet(ElementValueSet srcSemanticModel2) {

		logger.trace("Source Semantic Model ");
		for (IElementValue elementValue : srcSemanticModel2.getAllElementValues()) {
			XElementValue aaa = (org.mdmi.core.engine.XElementValue) elementValue;
			logXElementValue(aaa);
			if (aaa.getSemanticElement() != null && aaa.getSemanticElement().getSyntaxNode() != null) {
				if (aaa.getSemanticElement().getSyntaxNode().getParentNode() != null) {
					if (aaa.getSemanticElement().getSyntaxNode().getParentNode().getParentNode() == null) {
						logXElementValue(aaa);
					}
				}
			}
		}
	}

	void logXElementValue(XElementValue xElementValue) {

		logger.trace("XElementValue " + xElementValue.getName());

		if ("Value918".equals(xElementValue.getName())) {
			logger.trace("xElementValue.getName()");
		}

		if (xElementValue.getSemanticElement() != null && xElementValue.getSemanticElement().getSyntaxNode() != null) {
			logger.trace("LOCATION " + xElementValue.getSemanticElement().getSyntaxNode().getLocation());
		}

		logXValue(xElementValue.getXValue());
		for (IElementValue children : xElementValue.getChildren()) {
			logXElementValue((XElementValue) children);
		}
	}

	void logXDataStruct(XDataStruct xDataStruct) {
		for (XValue value : xDataStruct.getXValues()) {
			logXValue(value);
		}
	}

	void logXValue(XValue xValue) {

		for (Object value : xValue.getValues()) {
			if (value instanceof XDataStruct) {
				logXDataStruct((XDataStruct) value);
			} else {
				logger.trace("VALUE IS " + value);
			}
		}

	}

	// 2. Build the target syntax tree and semantic model (if any)
	void processInboundTargetMessage() {

		StopWatch watch = new StopWatch();
		watch.start();

		trgSemanticModel = new ElementValueSet();
		transferInfo.targetMessage.getData();

		watch.split();
		logger.trace("Execute preProcess processInboundTargetMessage get data" + Thread.currentThread().getName());

		ISemanticParser trgSemProv = getSemanticProvider(transferInfo.getTargetMessageGroup());
		ISyntacticParser trgSynProv = getSyntaxProvider(transferInfo.getTargetMessageGroup());

		watch.split();
		logger.trace(
			"Execute preProcess processInboundTargetMessage getSemanticProvider" + Thread.currentThread().getName());

		transferInfo.targetModel.getModel().getSyntaxModel().getRoot();

		watch.split();
		logger.trace(
			"Execute preProcess processInboundTargetMessage transferInfo.targetModel.getModel().getSyntaxModel().getRoot()" +
					Thread.currentThread().getName());

		if (transferInfo.targetMessage.getData() != null) {
			trgSyntaxModel = trgSynProv.parse(transferInfo.targetModel.getModel(), transferInfo.targetMessage);
		} else {
			trgSyntaxModel = new YBag((Bag) transferInfo.targetModel.getModel().getSyntaxModel().getRoot(), null);
		}

		trgSemProv.buildSemanticModel(
			transferInfo.targetModel.getModel(), trgSyntaxModel, trgSemanticModel, transferInfo.targetProperties,
			transferInfo.targetValues);

		watch.split();
		logger.trace(
			"Execute preProcess processInboundTargetMessage buildSemanticModel" + Thread.currentThread().getName());

	}

	void getMappedStack(SemanticElement se, Stack<SemanticElement> mappedParentStack) {
		if (se != null) {
			if (se.getSemanticElementType().equals(SemanticElementType.NORMAL) && !(se.getMapFromMdmi().isEmpty())) {
				mappedParentStack.push(se);
			}

			if (se.equals(se.getParent())) {
				return;
			}
			getMappedStack(se.getParent(), mappedParentStack);
		}
		return;
	}

	SemanticElement getNormalContainer(SemanticElement se) {

		if (se.getSemanticElementType().equals(SemanticElementType.NORMAL)) {
			return se;
		} else {
			if (se.getParent() != null) {
				if (se.getParent() != null &&
						se.getParent().getSemanticElementType().equals(SemanticElementType.NORMAL)) {
					return se.getParent();
				} else {
					return getNormalContainer(se.getParent());
				}
			}
		}
		return null;

	}

	boolean hasTarget(MDMIBusinessElementReference e) {
		for (MDMIBusinessElementReference mber : transferInfo.targetElements) {
			if (mber.getUniqueIdentifier().equals(e.getUniqueIdentifier())) {
				return true;
			}
		}
		return false;
	}

	static ConversionRule getToBE(SemanticElement src, MDMIBusinessElementReference ber) {
		Collection<ConversionRule> toBEs = src.getMapFromMdmi();
		for (Iterator<ConversionRule> it = toBEs.iterator(); it.hasNext();) {
			ConversionRule t = it.next();
			if (t.getBusinessElement() == ber) {
				return t;
			}
		}
		return null;
	}

	static ConversionRule getToSE(SemanticElement trg, MDMIBusinessElementReference ber) {
		Collection<ConversionRule> toSEs = trg.getMapToMdmi();
		for (Iterator<ConversionRule> it = toSEs.iterator(); it.hasNext();) {
			ConversionRule t = it.next();
			if (t.getBusinessElement() == ber) {
				return t;
			}
		}
		return null;
	}

	boolean manyToOneContainers = true;

	public static class Reference {

		public IElementValue parent;

		public IElementValue source;

		public SemanticElement target;

		/**
		 * @param parent
		 * @param source
		 * @param target
		 */
		public Reference(IElementValue parent, IElementValue source, SemanticElement target) {
			super();
			this.parent = parent;
			this.source = source;
			this.target = target;
		}

		public IElementValue getParent() {
			return parent;
		}

		public void setParent(IElementValue parent) {
			this.parent = parent;
		}

		public IElementValue getSource() {
			return source;
		}

		public void setSource(IElementValue source) {
			this.source = source;
		}

		public SemanticElement getTarget() {
			return target;
		}

		public void setTarget(SemanticElement target) {
			this.target = target;
		}
	}

	static public boolean sourceFilter = false;

	HashMap<String, HashSet<String>> manyToOneMatches = new HashMap<>();

	/*
	 * isManyToOneGlobals is true when the source globals elements should only populate the target element as a set of values
	 * This is accomplished currently by setting the source multiple element to false - which needs to be where the element is under the container
	 * Else reverse mappings might not work
	 */

	private boolean isManyToOneGlobals(MessageGroup sourceMessageGroup, MessageGroup targetMessageGroup) {

		if (sourceMessageGroup.getName().toUpperCase().startsWith("FHIR") &&
				targetMessageGroup.getName().toUpperCase().startsWith("CDA")) {
			return true;
		}
		return false;
	}

	/**
	 * Ensures every existing parent-child XElementValue relationship follows the
	 * semantic hierarchy. Missing semantic elements are materialized between the
	 * current parent and child; the original child value is retained.
	 */
	private void fillInSemanticPathElements() {
		List<IElementValue> allValues = trgSemanticModel.getAllElementValues();
		if (allValues == null || allValues.isEmpty()) {
			return;
		}

		// Snapshot the original values: creating intermediate values can extend
		// the model's all-element-values list while this pass is running.
		List<IElementValue> originalValues = new ArrayList<>(allValues);
		ListIterator<IElementValue> resolutionIterator = allValues.listIterator(allValues.size());

		for (IElementValue childValue : originalValues) {
			if (childValue == null || childValue.getParent() == null || childValue.getSemanticElement() == null) {
				continue;
			}

			IElementValue parentValue = childValue.getParent();
			SemanticElement parentSemantic = parentValue.getSemanticElement();
			SemanticElement childSemantic = childValue.getSemanticElement();
			if (parentSemantic == null || isDirectSemanticChild(parentSemantic, childSemantic)) {
				continue;
			}

			List<SemanticElement> path = new ArrayList<>();
			if (!findSemanticPath(parentSemantic, childSemantic, path) || path.size() <= 2) {
				// The child is not below this semantic parent, or there are no
				// missing elements to insert.
				continue;
			}

			logger.trace("Filling semantic path between {} and {}", parentSemantic.getName(), childSemantic.getName());

			// Detach the child from its current runtime parent before rebuilding
			// the chain. The final node in the path is the existing child value.
			parentValue.removeChild(childValue);
			IElementValue currentValueParent = parentValue;

			for (int i = 1; i < path.size() - 1; i++) {
				SemanticElement intermediateSemantic = path.get(i);

				// Reuse an intermediate XElementValue that an earlier child caused
				// us to create under this same runtime parent. This preserves shared
				// semantic ancestors, e.g. A -> B -> C and A -> B -> D.
				IElementValue intermediateValue = findChildBySemanticUniqueId(
					currentValueParent, intermediateSemantic.getUniqueId());

				if (intermediateValue == null) {
					intermediateValue = new XElementValue(intermediateSemantic, trgSemanticModel, resolutionIterator);
					intermediateValue.setParent(currentValueParent);
					currentValueParent.addChild(intermediateValue);

					logger.trace(
						"Created missing semantic path element {} under {}", intermediateSemantic.getName(),
						currentValueParent.getSemanticElement() != null
								? currentValueParent.getSemanticElement().getName()
								: "<root>");
				} else {
					logger.trace(
						"Reusing semantic path element {} under {}", intermediateSemantic.getName(),
						currentValueParent.getSemanticElement() != null
								? currentValueParent.getSemanticElement().getName()
								: "<root>");
				}

				currentValueParent = intermediateValue;
			}

			childValue.setParent(currentValueParent);
			currentValueParent.addChild(childValue);
		}
	}

	/**
	 * Returns an existing runtime child whose semantic element has the requested
	 * unique ID. Only direct children are considered so the runtime hierarchy
	 * remains aligned with the semantic path.
	 */
	private IElementValue findChildBySemanticUniqueId(IElementValue parentValue, String semanticUniqueId) {
		if (parentValue == null || parentValue.getChildren() == null) {
			return null;
		}
		for (IElementValue childValue : parentValue.getChildren()) {
			if (childValue != null && childValue.getSemanticElement() != null &&
					Objects.equals(childValue.getSemanticElement().getUniqueId(), semanticUniqueId)) {
				return childValue;
			}
		}
		return null;
	}

	private boolean isDirectSemanticChild(SemanticElement parent, SemanticElement child) {
		if (parent == null || child == null || parent.getChildren() == null) {
			return false;
		}
		String childUniqueId = child.getUniqueId();
		for (SemanticElement semanticChild : parent.getChildren()) {
			if (semanticChild != null && Objects.equals(semanticChild.getUniqueId(), childUniqueId)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Finds a descendant path from parent to target, inclusive of both endpoints.
	 * Semantic unique IDs are used rather than Java object identity.
	 */
	private boolean findSemanticPath(SemanticElement parent, SemanticElement target, List<SemanticElement> path) {
		if (parent == null || target == null) {
			return false;
		}
		path.add(parent);
		if (Objects.equals(parent.getUniqueId(), target.getUniqueId())) {
			return true;
		}
		if (parent.getChildren() != null) {
			for (SemanticElement child : parent.getChildren()) {
				if (child == null) {
					continue;
				}
				if (findSemanticPath(child, target, path)) {
					return true;
				}
			}
		}
		path.remove(path.size() - 1);
		return false;
	}

	private boolean hasAncestorInWhatToTransfer(IElementValue element, Set<IElementValue> whattotransfer) {

		IElementValue parent = element.getParent();

		while (parent != null) {
			if (whattotransfer.contains(parent)) {
				return true;
			}

			parent = parent.getParent();
		}

		return false;
	}

	private void walkTransferElements(Set<IElementValue> whattotransfer,
			HashMap<String, ArrayList<SemanticElement>> targetSementicElementsByBER, ConversionImpl impl) {

		System.out.println("=== walkTransferElements START ===");

		if (whattotransfer == null || whattotransfer.isEmpty()) {
			System.out.println("No elements to transfer.");
			return;
		}

		System.out.println("Elements to transfer: " + whattotransfer.size());

		for (IElementValue element : whattotransfer) {

			if (element == null) {
				System.out.println("Skipping null transfer element.");
				continue;
			}

			IElementValue parent = element.getParent();

			System.out.println("\nChecking source element: " + element.getUniqueId());

			System.out.println(
				"Source parent: " + (parent != null
						? parent.getUniqueId()
						: "null"));

			if (element.getParent() == null || !hasAncestorInWhatToTransfer(element, whattotransfer)) {

				System.out.println(
					"Starting traversal at: " + element.getSemanticElement().getName() + " " + element.getUniqueId());

				walkElement(element, null, targetSementicElementsByBER, impl);

			} else {
				System.out.println("Skipping element; parent is also " + "in whattotransfer.");
			}
		}

		System.out.println("=== walkTransferElements END ===");
	}

	private void walkElement(IElementValue sourceElement, XElementValue targetParent,
			HashMap<String, ArrayList<SemanticElement>> targetSementicElementsByBER, ConversionImpl impl) {

		if (sourceElement == null) {
			System.out.println("walkElement: source element is null.");
			return;
		}

		SemanticElement sourceSemantic = sourceElement.getSemanticElement();

		if (sourceSemantic == null) {
			System.out.println("Source semantic element is null for " + sourceElement.getUniqueId());
			return;
		}

		System.out.println("\n----------------------------------------");
		System.out.println(
			"Source element: " + sourceSemantic.getName() + " [uniqueId=" + sourceElement.getUniqueId() + "]");

		System.out.println(
			"Target parent: " + (targetParent != null
					? targetParent.getUniqueId()
					: "null"));

		if (sourceSemantic.getMapToMdmi() == null || sourceSemantic.getMapToMdmi().isEmpty()) {
			System.out.println("No conversion rules for " + sourceSemantic.getName());

			if (sourceElement.getChildren() != null && !sourceElement.getChildren().isEmpty()) {

				// System.out.println(
				// "Processing " + sourceElement.getChildren().size() + " source children under target " +
				// targetElement.getUniqueId());

				for (IElementValue child : sourceElement.getChildren()) {
					System.out.println(
						"Recursing into child: " + (child != null
								? child.getUniqueId()
								: "null"));

					walkElement(child, targetParent, targetSementicElementsByBER, impl);
				}
			}

		} else {
			int ruleIndex = 0;

			for (ConversionRule tme : sourceSemantic.getMapToMdmi()) {

				ruleIndex++;

				System.out.println("\nProcessing conversion rule " + ruleIndex);

				if (tme == null || tme.getBusinessElement() == null) {
					System.out.println("Conversion rule or business element " + "is null; skipping.");
					continue;
				}

				String ber = tme.getBusinessElement().getUniqueIdentifier();

				System.out.println("Business element BER: " + tme.getBusinessElement().getName() + "[" + ber + "]");

				ArrayList<SemanticElement> targetSemanticElements = targetSementicElementsByBER.get(ber);

				if (targetSemanticElements == null || targetSemanticElements.isEmpty()) {
					System.out.println("No targets found for BER: " + ber);

					if (sourceElement.getChildren() != null && !sourceElement.getChildren().isEmpty()) {

						System.out.println(
							"Processing " + sourceElement.getChildren().size() + " source children under target " +
									targetParent.getUniqueId());

						for (IElementValue child : sourceElement.getChildren()) {
							System.out.println(
								"Recursing into child: " + (child != null
										? child.getUniqueId()
										: "null"));

							walkElement(child, targetParent, targetSementicElementsByBER, impl);

						}
					}
					continue;
				}

				System.out.println("Matching target semantic elements: " + targetSemanticElements.size());

				int targetIndex = 0;

				for (SemanticElement targetSemanticElement : targetSemanticElements) {

					targetIndex++;

					if (targetSemanticElement == null) {
						System.out.println("Target " + targetIndex + " is null; skipping.");
						continue;
					}

					System.out.println(
						"\nChecking target " + targetIndex + ": " + targetSemanticElement.getName() + " [uniqueId=" +
								targetSemanticElement.getUniqueId() + "]");

					// For non-Container targets, ensure that the target
					// belongs to the target parent's semantic hierarchy.
					if (targetParent != null && !"Container".equals(targetSemanticElement.getDatatype().getName())) {

						SemanticElement parentSemantic = targetParent.getSemanticElement();

						if (parentSemantic == null || !containsSemanticElement(parentSemantic, targetSemanticElement)) {

							System.out.println(
								"Skipping target " + targetSemanticElement.getName() +
										": it is not a descendant of target parent " + (parentSemantic != null
												? parentSemantic.getName()
												: "null"));

							continue;
						}

						System.out.println("Target is a descendant of " + parentSemantic.getName());
					} else if (targetParent == null) {
						System.out.println("No target parent; descendant " + "check is not applicable.");
					} else {
						System.out.println("Target is a Container; " + "descendant check is bypassed.");
					}

					// Create a new target XElementValue for this rule/target.
					XElementValue targetElement = createXElementValue(
						targetParent, sourceElement, targetSemanticElement, impl, tme);

					if (targetElement == null) {
						System.out.println("XElementValue creation failed.");
						continue;
					}

					System.out.println("Created target XElementValue: " + targetElement.getUniqueId());

					if (targetParent != null) {
						targetElement.setParent(targetParent);

						System.out.println("Set target parent: " + targetParent.getUniqueId());
					}

					// Process each source child independently under this
					// newly created target element.
					if (sourceElement.getChildren() != null && !sourceElement.getChildren().isEmpty()) {

						System.out.println(
							"Processing " + sourceElement.getChildren().size() + " source children under target " +
									targetElement.getUniqueId());

						for (IElementValue child : sourceElement.getChildren()) {
							System.out.println(
								"Recursing into child: " + (child != null
										? child.getUniqueId()
										: "null"));

							walkElement(child, targetElement, targetSementicElementsByBER, impl);
						}
					} else {
						System.out.println("No source children for " + sourceElement.getUniqueId());
					}
				}
			}
		}

		System.out.println("walkElement END: " + sourceElement.getUniqueId());
	}

	private boolean containsSemanticElement(SemanticElement parent, SemanticElement target) {

		if (parent == null || target == null) {
			return false;
		}

		System.out.println("Checking semantic hierarchy: parent=" + parent.getName() + ", target=" + target.getName());

		// Compare unique IDs rather than Java object references.
		if (parent.getUniqueId().equals(target.getUniqueId())) {
			System.out.println("Semantic element matched: " + target.getName());
			return true;
		}

		if (parent.getChildren() == null) {
			return false;
		}

		for (SemanticElement child : parent.getChildren()) {
			if (containsSemanticElement(child, target)) {
				return true;
			}
		}

		return false;
	}

	private XElementValue createXElementValue(IElementValue targetParent, IElementValue sourceElementValue,
			SemanticElement targetSemanticElement, ConversionImpl impl, ConversionRule tme) {

		System.out.println("createXElementValue START");
		System.out.println("Source element ID: " + sourceElementValue.getUniqueId());
		System.out.println("Target semantic element: " + targetSemanticElement.getName());
		XElementValue targetElementValue = new XElementValue(targetSemanticElement, trgSemanticModel);

		logger.trace(
			" Creating target element " + targetSemanticElement.getName() + " from source semantic element" +
					sourceElementValue.getSemanticElement().getName());

		try {
			@SuppressWarnings("deprecation")
			org.mdmi.core.engine.ConversionInvocation ci = new org.mdmi.core.engine.ConversionInvocation(
				targetSemanticElement, tme.getBusinessElement(), tme.getBusinessElement());
			impl.convert((XElementValue) sourceElementValue, ci, targetElementValue);
			if (targetParent != null) {
				targetElementValue.setParent(targetParent);
				targetParent.addChild(targetElementValue);
			}

			System.out.println("Created target element ID: " + targetElementValue.getUniqueId());
			System.out.println("createXElementValue END");

		} catch (

		Exception e) {
			logger.error("ERROR IN CONVERSION", e);
		}

		return targetElementValue;
	}

	private void printTargetSemanticElementsByBER(
			HashMap<String, ArrayList<SemanticElement>> targetSementicElementsByBER) {

		for (Map.Entry<String, ArrayList<SemanticElement>> entry : targetSementicElementsByBER.entrySet()) {

			String key = entry.getKey();
			ArrayList<SemanticElement> elements = entry.getValue();

			System.out.println("BER Key: " + key);

			if (elements != null) {
				for (SemanticElement element : elements) {
					System.out.println(
						"  Semantic Element: " + element.getName() + " [uniqueId=" + element.getUniqueId() + "]");
				}
			}
		}
	}

	private Set<SemanticElement> collectMatchingContainerBusinessElementIds(
			Set<MDMIBusinessElementReference> containerBusinessElements,
			HashMap<String, ArrayList<SemanticElement>> targetSementicElementsByBER) {

		Set<SemanticElement> matchingContainerElements = new LinkedHashSet<>();
		Set<String> processedContainerIds = new HashSet<>();

		for (MDMIBusinessElementReference businessElement : containerBusinessElements) {
			if (businessElement == null) {
				continue;
			}

			String uniqueId = businessElement.getUniqueIdentifier();

			ArrayList<SemanticElement> targetElements = targetSementicElementsByBER.get(uniqueId);

			if (targetElements == null) {
				continue;
			}

			for (SemanticElement targetElement : targetElements) {
				if (targetElement == null || targetElement.getDatatype() == null ||
						!"Container".equals(targetElement.getDatatype().getName())) {
					continue;
				}

				// Skip this container if an ancestor container was already processed.
				if (hasProcessedContainerAncestor(targetElement, processedContainerIds)) {
					continue;
				}

				String containerId = targetElement.getUniqueId();

				if (processedContainerIds.add(containerId)) {
					matchingContainerElements.add(targetElement);
				}
			}
		}

		return matchingContainerElements;
	}

	private boolean hasProcessedContainerAncestor(SemanticElement element, Set<String> processedContainerIds) {

		SemanticElement parent = element.getParent();

		while (parent != null) {
			if (parent.getDatatype() != null && "Container".equals(parent.getDatatype().getName()) &&
					processedContainerIds.contains(parent.getUniqueId())) {
				return true;
			}

			parent = parent.getParent();
		}

		return false;
	}

	private Set<MDMIBusinessElementReference> collectContainerBusinessElements(Set<IElementValue> whatToTransfer) {

		Set<MDMIBusinessElementReference> businessElements = new LinkedHashSet<>();

		for (IElementValue elementValue : whatToTransfer) {
			SemanticElement sourceElement = elementValue.getSemanticElement();

			if (sourceElement == null || sourceElement.getDatatype() == null ||
					!"Container".equals(sourceElement.getDatatype().getName())) {
				continue;
			}

			EList<ConversionRule> conversionRules = sourceElement.getMapToMdmi();

			if (conversionRules == null) {
				continue;
			}

			for (ConversionRule conversionRule : conversionRules) {
				if (conversionRule == null || conversionRule.getBusinessElement() == null) {
					continue;
				}

				businessElements.add(conversionRule.getBusinessElement());
			}
		}

		return businessElements;
	}

	private Set<SemanticElement> collectMatchingContainerBusinessElementIdsss(
			Set<MDMIBusinessElementReference> containerBusinessElements,
			HashMap<String, ArrayList<SemanticElement>> targetSementicElementsByBER) {

		Set<SemanticElement> matchingContainerElements = new LinkedHashSet<>();
		Set<String> processedContainerIds = new HashSet<>();

		for (MDMIBusinessElementReference businessElement : containerBusinessElements) {
			if (businessElement == null) {
				continue;
			}

			String uniqueId = businessElement.getUniqueIdentifier();

			ArrayList<SemanticElement> targetElements = targetSementicElementsByBER.get(uniqueId);

			if (targetElements == null) {
				continue;
			}

			for (SemanticElement targetElement : targetElements) {
				if (targetElement == null || targetElement.getDatatype() == null) {
					continue;
				}

				if (!"Container".equals(targetElement.getDatatype().getName())) {
					continue;
				}

				String containerId = targetElement.getUniqueId();

				if (processedContainerIds.add(containerId)) {
					matchingContainerElements.add(targetElement);
				}
			}
		}

		return matchingContainerElements;
	}

	private Set<SemanticElement> collectMatchingContainerBusinessElementIdsA(
			Set<MDMIBusinessElementReference> containerBusinessElements,
			HashMap<String, ArrayList<SemanticElement>> targetSementicElementsByBER) {

		Set<SemanticElement> matchingContainerElements = new LinkedHashSet<>();

		for (MDMIBusinessElementReference businessElement : containerBusinessElements) {
			if (businessElement == null) {
				continue;
			}

			String uniqueId = businessElement.getUniqueIdentifier();

			ArrayList<SemanticElement> targetElements = targetSementicElementsByBER.get(uniqueId);

			if (targetElements == null) {
				continue;
			}

			for (SemanticElement targetElement : targetElements) {
				if (targetElement == null || targetElement.getDatatype() == null) {
					continue;
				}

				if ("Container".equals(targetElement.getDatatype().getName())) {
					matchingContainerElements.add(targetElement);
				}
			}
		}

		return matchingContainerElements;
	}

	private HashMap<String, ArrayList<SemanticElement>> buildTargetSemanticElementsByBER(
			Set<SemanticElement> theTargetContainers) {

		HashMap<String, ArrayList<SemanticElement>> result = new HashMap<>();

		for (SemanticElement container : theTargetContainers) {
			// Always include the target container itself.
			collectTargetSemanticElementsByBER(container, result);
		}

		return result;
	}

	private void collectTargetSemanticElementsByBER(SemanticElement semanticElement,
			HashMap<String, ArrayList<SemanticElement>> result) {

		if (semanticElement == null) {
			return;
		}

		// Index the element using its target-side conversion rules.
		EList<ConversionRule> conversionRules = semanticElement.getMapFromMdmi();

		if (conversionRules != null) {
			for (ConversionRule conversionRule : conversionRules) {
				if (conversionRule == null || conversionRule.getBusinessElement() == null) {
					continue;
				}

				String uniqueId = conversionRule.getBusinessElement().getUniqueIdentifier();

				result.computeIfAbsent(uniqueId, key -> new ArrayList<>()).add(semanticElement);
			}
		}

		// Recursively index all descendants.
		for (SemanticElement child : semanticElement.getChildren()) {
			collectTargetSemanticElementsByBER(child, result);
		}
	}

	void processConversions() {

		this.transferInfo.targetMessage.getUnspecifiedNodes().addAll(
			this.transferInfo.sourceMessage.getUnspecifiedNodes());

		StopWatch watch = new StopWatch();
		watch.start();
		// Execute the data conversions.
		Set<IElementValue> whattotransfer = new LinkedHashSet<>();
		HashMap<String, MDMIBusinessElementReference> matches = new HashMap<>();
		for (IElementValue iev : srcSemanticModel.getAllElementValues()) {
			logger.trace("Source Semantic Element " + iev.getSemanticElement().getName());
			boolean isMatched = false;
			for (ConversionRule tme : iev.getSemanticElement().getMapToMdmi()) {
				if (hasTarget(tme.getBusinessElement())) {
					logger.debug("Matching Busines Element " + tme.getBusinessElement().getName());
					whattotransfer.add(iev);
					matches.put(tme.getBusinessElement().getUniqueIdentifier(), tme.getBusinessElement());
					isMatched = true;
				}
			}

			if (!isMatched && !iev.getSemanticElement().isMultipleInstances()) {
				logger.trace("LOOKING FOR PARENT FOR " + iev.getSemanticElement().getName());
				SemanticElementRelationship targetSemanticRelationship = iev.getSemanticElement().getRelationshipByName(
					"PARENTNODE");
				if (targetSemanticRelationship != null) {
					SemanticElement targetSemanticParent = targetSemanticRelationship.getRelatedSemanticElement();
					if (targetSemanticParent != null) {
						for (ConversionRule tme : targetSemanticParent.getMapToMdmi()) {
							if (hasTarget(tme.getBusinessElement())) {
								logger.trace("Matching SINGLE Busines Element " + tme.getBusinessElement().getName());
								whattotransfer.add(iev);
								matches.put(tme.getBusinessElement().getUniqueIdentifier(), tme.getBusinessElement());
								isMatched = true;
							}
						}
					}
				}
			}

		}

		watch.split();
		logger.info("match : " + watch.toSplitString());

		ConversionImpl impl = new ConversionImpl(trgSemanticModel);

		impl.initializeDI(
			transferInfo.sourceModel.getGroup(), transferInfo.targetModel.getGroup(), transferInfo.sourceProperties,
			transferInfo.targetProperties);

		watch.split();
		logger.info("impl.initializeDI " + watch.getTime());

		boolean skipContainmentCheck = "SKIPCONTAINMENT".equals(transferInfo.targetModel.getGroup().getDescription());

		EList<SemanticElement> l = transferInfo.targetModel.getModel().getElementSet().getSemanticElements();

		HashMap<String, ArrayList<SemanticElement>> targetSementicElementsByBER = new HashMap<>();

		HashSet<SemanticElement> targetSementicReferences = new HashSet<>();

		String foo = "";
		for (SemanticElement targetSementicElement : l) {
			if (!targetSementicElement.isMultipleInstances()) {
				continue;
			}
			for (ConversionRule tme : targetSementicElement.getMapFromMdmi()) {
				if (tme.getBusinessElement() != null) {
					if (!targetSementicElementsByBER.containsKey(tme.getBusinessElement().getUniqueIdentifier())) {
						targetSementicElementsByBER.put(
							tme.getBusinessElement().getUniqueIdentifier(), new ArrayList<SemanticElement>());

					}
					if ("RequestCategoryCode2000E".equals(targetSementicElement.getName())) {
						System.out.println("aaaa" + targetSementicElement.getUniqueId());
						foo = tme.getBusinessElement().getUniqueIdentifier();
						System.out.println(foo);
					}
					targetSementicElementsByBER.get(tme.getBusinessElement().getUniqueIdentifier()).add(
						targetSementicElement);
				}
			}

		}

		ArrayList<SemanticElement> wtfaaa = targetSementicElementsByBER.get(foo);

		for (SemanticElement targetSementicElement : l) {

			for (ConversionRule tmo : targetSementicElement.getMapFromMdmi()) {
				if (!StringUtils.isEmpty(tmo.getRule()) && tmo.getRule().startsWith("REFERENCE:")) {
					targetSementicReferences.add(targetSementicElement);
				}
			}

		}

		// printTargetSemanticElementsByBER(targetSementicElementsByBER);

		// findTargetSemanticElements(whattotransfer, l);

		// Set<IElementValue> whatToTransfer = new LinkedHashSet<>();

		EList<SemanticElement> targetSemanticElements = transferInfo.targetModel.getModel().getElementSet().getSemanticElements();

		Map<IElementValue, SemanticElement> targetContainers = new LinkedHashMap<>();

		for (IElementValue elementValue : whattotransfer) {

			SemanticElement sourceElement = elementValue.getSemanticElement();

			// Filter to Container datatype
			if (!"Container".equals(sourceElement.getDatatype().getName())) {
				continue;
			}

			EList<ConversionRule> sourceRules = sourceElement.getMapToMdmi();

			if (sourceRules == null) {
				continue;
			}

			for (ConversionRule sourceRule : sourceRules) {
				if (sourceRule == null || sourceRule.getBusinessElement() == null) {
					continue;
				}

				String sourceIdentifier = sourceRule.getBusinessElement().getUniqueIdentifier();

				for (SemanticElement targetElement : targetSemanticElements) {

					EList<ConversionRule> targetRules = targetElement.getMapFromMdmi();

					if (targetRules == null) {
						continue;
					}

					boolean matched = false;

					for (ConversionRule targetRule : targetRules) {
						if (targetRule == null || targetRule.getBusinessElement() == null) {
							continue;
						}

						String targetIdentifier = targetRule.getBusinessElement().getUniqueIdentifier();

						if (sourceIdentifier.equals(targetIdentifier)) {
							targetContainers.put(elementValue, targetElement);
							matched = true;
							break;
						}
					}

					if (matched) {
						break;
					}
				}

				if (targetContainers.containsKey(elementValue)) {
					break;
				}
			}
		}

		ArrayList<SemanticElement> wtfaaa1 = targetSementicElementsByBER.get(foo);

		Set<MDMIBusinessElementReference> sourceBusinessElements = collectContainerBusinessElements(whattotransfer);

		Set<SemanticElement> theTargetContainers = collectMatchingContainerBusinessElementIds(
			sourceBusinessElements, targetSementicElementsByBER);

		HashMap<String, ArrayList<SemanticElement>> thecollection = buildTargetSemanticElementsByBER(
			theTargetContainers);
		// targetSementicElementsByBER.size();

		ArrayList<SemanticElement> wtfaaa3 = targetSementicElementsByBER.get(foo);

		walkTransferElements(whattotransfer, thecollection, impl);

		// Insert target semantic elements that are missing between an existing
		// XElementValue parent and child. For example, if the semantic model says
		// A -> B -> C but the transfer created A -> C, create a B XElementValue
		// and repair the runtime tree to A -> B -> C.
		printElementTree(this.trgSemanticModel.getAllElementValues());
		fillInSemanticPathElements();

		printElementTree(this.trgSemanticModel.getAllElementValues());

		List<IElementValue> trgValues = trgSemanticModel.getAllElementValues();
		List<IElementValue> srcValues = srcSemanticModel.getAllElementValues();

		List<Reference> referencesToCreate = new ArrayList<>();

		// ✅ 1. Build quick lookup for source business elements by uniqueIdentifier
		Map<String, IElementValue> srcByBusinessId = new HashMap<>();
		for (IElementValue srcVal : srcValues) {
			for (ConversionRule toMdmi : srcVal.getSemanticElement().getMapToMdmi()) {
				if (toMdmi.getBusinessElement() != null) {
					srcByBusinessId.put(toMdmi.getBusinessElement().getUniqueIdentifier(), srcVal);
				}
			}
		}

		// ✅ 2. Build quick lookup for target ConversionRules by businessElement name
		Map<String, List<ConversionRule>> trgByBusinessName = new HashMap<>();
		for (IElementValue trgVal : trgValues) {
			for (SemanticElement child : trgVal.getSemanticElement().getChildren()) {
				for (ConversionRule rule : child.getMapFromMdmi()) {
					if (rule.getBusinessElement() != null) {
						trgByBusinessName.computeIfAbsent(
							rule.getBusinessElement().getName(), k -> new ArrayList<>()).add(rule);
					}
				}
			}
		}

		ReferenceBuildingVisitor visitor = new ReferenceBuildingVisitor(
			trgValues, new HashMap<IElementValue, IElementValue>(), referencesToCreate, logger);

		for (IElementValue trgVal : trgValues) {
			trgVal.accept(visitor);
		}

		Set<String> semanticReferences = referencesToCreate.stream().map(
			r -> r.target == null
					? null
					: r.target.getUniqueId()).filter(Objects::nonNull).collect(Collectors.toSet());

		for (Reference r : referencesToCreate) {
			try {
				for (ConversionRule tme : r.getSource().getSemanticElement().getMapToMdmi()) {
					for (ConversionRule tmo : r.getTarget().getMapToMdmi()) {
						if (!tme.getBusinessElement().getUniqueIdentifier().equals(
							tmo.getBusinessElement().getUniqueIdentifier())) {
							continue;
						}
						logger.trace("Create Reference Source Element" + r.getSource().getName());
						logger.trace("Create Reference Target Semantic Element " + r.getTarget().getName());
						logger.trace("Create Reference Parent " + r.getParent().getName());
						logger.trace("CREATING Reference TARGET ELEMENT " + r.getTarget().getName());
						XElementValue targetElementValue = new XElementValue(r.getTarget(), trgSemanticModel);
						targetElementValue.setParent(r.getParent());
						r.getParent().addChild(targetElementValue);
						org.mdmi.core.engine.ConversionInvocation ci = new org.mdmi.core.engine.ConversionInvocation(
							r.getTarget(), tme.getBusinessElement(), tmo.getBusinessElement());
						impl.convert((XElementValue) r.getSource(), ci, targetElementValue);
					}
				}

			} catch (Exception e) {
				logger.error("ERROR IN CONVERSION", e);
			}
		}

		watch.split();
		logger.trace("what to transfer : " + watch.toSplitString());

		ArrayList<SemanticElement> singles = new ArrayList<>();

		for (

		SemanticElement semanticElement : transferInfo.targetModel.getModel().getElementSet().getSemanticElements()) {
			if (!semanticElement.isMultipleInstances()) {
				singles.add(semanticElement);
			}
		}

		if (logger.isTraceEnabled()) {
			for (SemanticElement s : singles) {
				logger.info("SINGLE ELEMENTS : " + s.getName());
			}
		}

		/*
		 * Loop over semantic elements defined as single instance
		 * Check for semantic parent - currently no support or need to have root singleton
		 * If the single parent has content - populate the appropriate single instances per container
		 *
		 */

		for (

		SemanticElement single : singles) {
			SemanticElement theSingleParent = single.getParent();
			while (theSingleParent != null) {
				if (theSingleParent.getSemanticElementType().equals(SemanticElementType.NORMAL)) {
					break;
				} else {
					theSingleParent = theSingleParent.getParent();
				}

			}

			if (theSingleParent != null) {

				if (!trgSemanticModel.hasElementValuesByName(theSingleParent)) {
					continue;
				}

				List<IElementValue> values = trgSemanticModel.getElementValuesByName(theSingleParent);

				logger.trace("GETTING SINGLE ELEMENT PARENTS : " + theSingleParent.getName());
				logger.trace("GETTING SINGLE ELEMENT PARENTS : " + values);

				if (logger.isTraceEnabled()) {
					for (IElementValue v : values) {
						logger.trace("GETTING SINGLE ELEMENT PARENTS : " + v.getSemanticElement().getName());
					}
				}

				for (ConversionRule conversionRule : single.getMapToMdmi()) {
					for (IElementValue elementValue : whattotransfer) {

						ArrayList<MDMIBusinessElementReference> businessReference = new ArrayList<>();

						for (ConversionRule tme : elementValue.getSemanticElement().getMapToMdmi()) {
							businessReference.add(tme.getBusinessElement());
						}

						for (MDMIBusinessElementReference sourceRI : businessReference) {
							if (sourceRI.getUniqueIdentifier().equals(
								conversionRule.getBusinessElement().getUniqueIdentifier())) {

								logger.trace(
									"elementValueelementValueelementValueelementValue " +
											elementValue.getSemanticElement());

								// If isManyToOneGlobals - populate target only when it source is also global
								if (isManyToOneGlobals(
									this.transferInfo.getSourceMessageGroup(),
									this.transferInfo.getTargetMessageGroup()) &&
										elementValue.getSemanticElement().isMultipleInstances()) {
									continue;
								}

								logger.trace("SINGLE ELEMENT MATCHED : " + sourceRI.getName());
								logger.trace("SINGLE ELEMENT PARENT : " + single.getName());
								logger.trace(
									"SOURCE ELEMENT CONTAINER : " + elementValue.getSemanticElement().getName());

							}
						}

					}
				}
			}
		}

		watch.split();
		logger.trace("singles : " + watch.toSplitString());

		printElementTree(this.trgSemanticModel.getAllElementValues());

		printElementTree(this.trgSemanticModel.getAllElementValues());
		LogSemantic lg = new LogSemantic(DIRECTION.TO);
		lg.processSemanticModel(this.trgSemanticModel);

		ListIterator<IElementValue> iterator = trgSemanticModel.getAllElementValues().listIterator();

		while (iterator.hasNext()) {
			IElementValue targetElementValue = iterator.next();

			if (isBreakContainment(targetElementValue.getSemanticElement())) {
				if (targetElementValue.getParent() != null) {
					for (IElementValue child : targetElementValue.getChildren()) {
						if (isBreadCrumb(child.getSemanticElement())) {
							for (SemanticElement child2 : targetElementValue.getParent().getSemanticElement().getChildren()) {
								if (isBreadCrumb(child2)) {
									XElementValue idElementValue = new XElementValue(
										child2, trgSemanticModel, iterator);
									idElementValue.setValue(child.value());
									targetElementValue.getParent().addChild(idElementValue);
								}
							}
						}
					}
					targetElementValue.getParent().removeChild(targetElementValue);
					targetElementValue.setParent(null);
				}
			}
		}

		watch.split();
		logger.trace("containers : " + watch.toSplitString());

		ArrayList<IElementValue> tobedeleted = new ArrayList<>();

		if (!sourceFilter) {

			for (IElementValue targetElementValue : trgSemanticModel.getAllElementValues()) {
				SemanticElement se = targetElementValue.getSemanticElement();
				SemanticElementRelationship ser = se.getRelationshipByName("QUALIFIER");

				if (ser != null) {
					if (se.getDatatype() != null && se.getDatatype().getName().equals("Container")) {
						boolean hasFilterTarget = false;
						for (IElementValue child : targetElementValue.getChildren()) {
							if (child.getSemanticElement().getName().equals(
								ser.getRelatedSemanticElement().getName())) {
								String qualifierFunction = "is" + se.getName();
								impl.targetProperties.remove("VALUESET");
								hasFilterTarget = true;
								/*
								 * Use metamodel better - if description is no empty check for value set
								 */
								if (!StringUtils.isEmpty(ser.getDescription())) {

									if (Utils.mapOfTransforms.containsKey(ser.getDescription())) {
										qualifierFunction = "targetCheckFilter";
										impl.targetProperties.put(
											"VALUESET", Utils.mapOfTransforms.get(ser.getDescription()));
									} else {
										impl.targetProperties.put("VALUESET", Collections.EMPTY_SET);
									}

								} else {
									impl.targetProperties.put("VALUESET", Collections.EMPTY_SET);
								}
								if (!impl.targetDatamapInterpreter.execute(
									qualifierFunction, child, impl.targetProperties)) {
									tobedeleted.add(targetElementValue);
									tobedeleted.addAll(targetElementValue.getChildren());
								}
							}
						}
						if (!hasFilterTarget) {
							tobedeleted.add(targetElementValue);
							tobedeleted.addAll(targetElementValue.getChildren());
						}
					} else {
						if (ser != null && targetElementValue.getParent() != null &&
								targetElementValue.getParent().getChildren() != null) {
							for (IElementValue child : targetElementValue.getParent().getChildren()) {
								if (child.getSemanticElement().getName().equals(
									ser.getRelatedSemanticElement().getName())) {
									if (!impl.targetDatamapInterpreter.execute(
										"is" + se.getName(), child, impl.targetProperties)) {
										tobedeleted.add(targetElementValue);
									}

								}
							}
						}
					}
				}

			}

		}
		watch.split();
		logger.trace("QUALIFIER : " + watch.toSplitString());

		if (!sourceFilter) {
			for (IElementValue remove : tobedeleted) {
				trgSemanticModel.removeElementValue(remove);
				if (remove.getParent() != null) {
					remove.getParent().removeChild(remove);
				}
			}
		}

		watch.split();
		logger.trace("Done : " + watch.toSplitString());

	}

	boolean filterSource(ConversionImpl impl, IElementValue sourceElementContainer,
			SemanticElement targetSementicContainer) {

		SemanticElementRelationship ser = targetSementicContainer.getRelationshipByName("QUALIFIER");

		SemanticElement filterTarget = null;
		IElementValue sourceFilterValue = null;

		for (SemanticElement childTarget : targetSementicContainer.getChildren()) {

			if (childTarget.getName().equals(ser.getRelatedSemanticElement().getName())) {

				for (ConversionRule cc : childTarget.getMapFromMdmi()) {

					for (IElementValue xx : sourceElementContainer.getChildren()) {

						for (ConversionRule aaa : xx.getSemanticElement().getMapToMdmi()) {
							if (cc.getBusinessElement().getUniqueIdentifier().equals(
								aaa.getBusinessElement().getUniqueIdentifier())) {
								filterTarget = childTarget;
								sourceFilterValue = xx;
							}

						}

					}
				}
			}
		}

		if (filterTarget == null || sourceFilterValue == null) {
			return false;
		}

		if (Utils.mapOfTransforms.containsKey(ser.getDescription())) {

			XValue xvalue = (XValue) sourceFilterValue.getXValue();

			XDataStruct xvalue2 = (XDataStruct) xvalue.getValueByName("coding");

			XDataStruct xvalue3 = (XDataStruct) xvalue2.getValue("code");

			return Utils.mapOfTransforms.get(ser.getDescription()).containsKey(xvalue3.getValue("value"));

		}

		return false;

	}

	// 4. Build the target syntax tree from the target semantic model
	void processOutboundTargetMessage() {
		ISemanticParser trgSemProv = getSemanticProvider(transferInfo.getTargetMessageGroup());
		ISyntacticParser trgSynProv = getSyntaxProvider(transferInfo.getTargetMessageGroup());

		StopWatch watch = new StopWatch();
		watch.start();

		trgSemProv.updateTargetSemanticModel(
			transferInfo.targetModel.getModel(), trgSemanticModel, trgSyntaxModel, transferInfo.targetProperties,
			transferInfo.targetValues);
		watch.split();
		logger.trace("Split processOutboundTargetMessage updateTargetSemanticModel : " + watch.toSplitString());

		processTargetSemanticModel();
		watch.split();
		logger.trace("Split processOutboundTargetMessage processTargetSemanticModel : " + watch.toSplitString());

		if (trgSyntaxModel != null) {
			trgSemProv.updateSyntacticModel(
				transferInfo.targetModel.getModel(), trgSemanticModel, trgSyntaxModel, transferInfo.targetProperties);
			watch.split();
			logger.trace("Split processOutboundTargetMessage updateSyntacticModel : " + watch.toSplitString());

		} else {
			trgSyntaxModel = trgSemProv.createNewSyntacticModel(
				transferInfo.targetModel.getModel(), trgSemanticModel, transferInfo.targetProperties);
			watch.split();
			logger.trace("Split processOutboundTargetMessage createNewSyntacticModel : " + watch.toSplitString());

		}

		StringBuffer runtimeComment = new StringBuffer();

		/**
		 * @TODO
		 *       Temporary update to not add comments to FHIR targets
		 *
		 */
		if (System.getenv("RUNTIMECOMMENT") != null) {
			runtimeComment.append("Generated using MDMI " + Mdmi.RUNTIMEVERSION + "  " + Mdmi.RUNTIMEBUILD).append(
				System.getProperty("line.separator"));

			for (MessageModel messageModel : transferInfo.sourceModel.getModel().getGroup().getModels()) {
				runtimeComment.append(
					"Source Group : " + transferInfo.sourceModel.getModel().getGroup().getName()).append(
						System.getProperty("line.separator"));

				runtimeComment.append("Source Message : " + messageModel.getMessageModelName()).append(
					System.getProperty("line.separator"));

				runtimeComment.append("Source Version : " + messageModel.getDescription()).append(
					System.getProperty("line.separator"));

			}

			for (MessageModel messageModel : transferInfo.targetModel.getModel().getGroup().getModels()) {
				runtimeComment.append(
					"Target Group : " + transferInfo.targetModel.getModel().getGroup().getName()).append(
						System.getProperty("line.separator"));

				runtimeComment.append("Target Message : " + messageModel.getMessageModelName()).append(
					System.getProperty("line.separator"));

				runtimeComment.append("Target Version : " + messageModel.getDescription()).append(
					System.getProperty("line.separator"));

			}
		}

		trgSynProv.serialize(
			transferInfo.targetModel.getModel(), transferInfo.targetMessage, trgSyntaxModel, runtimeComment.toString());

		watch.split();
		logger.trace("Split processOutboundTargetMessage serialize : " + watch.toSplitString());

	}

	private boolean isBreadCrumb(SemanticElement semanticElement) {
		return checkRules(semanticElement, "BREADCRUMB");
	}

	private boolean isBreakContainment(SemanticElement semanticElement) {
		return checkRules(semanticElement, "BREAKCONTAINMENT");
	}

	private boolean checkRules(SemanticElement semanticElement, String ruleName) {
		if (semanticElement != null) {
			for (SemanticElementBusinessRule sebr : semanticElement.getBusinessRules()) {
				if (ruleName.equals(sebr.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	// 5. Call the post-processors, if any
	void postProcess() {

		Mdmi.INSTANCE().getPostProcessors().postProcess(transferInfo);

	}

	private MdmiResolver resolver() {
		return owner.getOwner().getResolver();
	}

	private ISyntacticParser getSyntaxProvider(MessageGroup messageGroup) {

		if (!messageGroup.getModels().isEmpty()) {
			return resolver().getSyntacticParser(
				messageGroup.getName(), messageGroup.getModels().get(0).getMessageModelName());
		}
		return null;

	}

	private ISemanticParser getSemanticProvider(MessageGroup messageGroup) {
		for (MessageModel s : messageGroup.getModels()) {
			return resolver().getSemanticParser(messageGroup.getName(), s.getMessageModelName());
		}
		return null;

	}

	@Override
	public String toString() {
		if (transferInfo == null) {
			return "MdmiUoW: data is not set!";
		}
		return transferInfo.toString();
	}

	/**
	 * @param trgSemanticModel2
	 * @param sMod
	 * @param tMsg
	 * @param bers
	 */

	public static class FieldAndPath {
		public String path;

		public Field field;

		/**
		 * @param path
		 * @param field
		 */
		public FieldAndPath(String path, Field field) {
			super();
			this.path = path;
			this.field = field;
		}
	}

	void collectFields(MDMIDatatype mdmiDatatype, String path, ArrayList<FieldAndPath> fields) {

		if (mdmiDatatype == null || mdmiDatatype.getFields() == null || (path != null && path.endsWith("extension"))) {
			return;
		}
		for (Field field : mdmiDatatype.getFields()) {
			if (field.getDatatype().isSimple()) {
				String fieldPath = (path != null
						? path + "."
						: "") + field.getName();
				fields.add(new FieldAndPath(fieldPath, field));
			} else {
				if (path == null || !path.contains(field.getName())) {
					collectFields(
						mdmiDatatype.getField(field.getName()).getDatatype(), (path != null
								? path + "."
								: "") + field.getName(),
						fields);
				}

			}
		}
	}

	void populateSourceSemanticModel(SemanticElement theSemanticElement, XElementValue parent,
			ArrayList<MDMIBusinessElementReference> bers, ArrayList<SemanticElement> created,
			ArrayList<String> singles) {
		XElementValue p = parent;
		MDMIBusinessElementReference theSEER = null;
		if (!theSemanticElement.getMapFromMdmi().isEmpty()) {

			boolean createSemanticElement = false;
			for (ConversionRule tbe : theSemanticElement.getMapFromMdmi()) {
				if (tbe.getBusinessElement() != null) {
					for (MDMIBusinessElementReference mber : bers) {
						if (mber.getUniqueIdentifier().equals(tbe.getBusinessElement().getUniqueIdentifier()) &&
								theSemanticElement.isMultipleInstances()) {
							createSemanticElement = true;
							theSEER = mber;
						}
					}

				}
			}

			if (!createSemanticElement && !theSemanticElement.isMultipleInstances()) {
				logger.trace("CHECKING SINGLE INSTANCE ELEMENT" + theSemanticElement.getName());
				SemanticElementRelationship targetSemanticRelationship = theSemanticElement.getRelationshipByName(
					"PARENTNODE");
				if (targetSemanticRelationship != null) {
					SemanticElement targetSemanticParent = targetSemanticRelationship.getRelatedSemanticElement();
					if (targetSemanticParent != null) {
						logger.trace("SINGLE INSTANCE PARENT IS" + targetSemanticParent.getName());
						for (ConversionRule tbe : targetSemanticParent.getMapFromMdmi()) {
							if (tbe.getBusinessElement() != null) {
								for (MDMIBusinessElementReference mber : bers) {
									if (!singles.contains(tbe.getBusinessElement().getUniqueIdentifier()) &&
											mber.getUniqueIdentifier().equals(
												tbe.getBusinessElement().getUniqueIdentifier())) {
										createSemanticElement = true;
										theSEER = mber;
										logger.trace("CREATED SINGLE INSTANCE " + theSemanticElement.getName());
										singles.add(tbe.getBusinessElement().getUniqueIdentifier());
									}
								}
							}
						}
					}
				}
			}

			if (createSemanticElement) {

				logger.trace(
					"Created Source Element " + theSemanticElement.getName() + " " +
							getFullPathForNode(theSemanticElement.getSyntaxNode()));

				created.add(theSemanticElement);
				XElementValue trg = new XElementValue(theSemanticElement, srcSemanticModel);
				if (parent != null) {
					parent.addChild(trg);
				}
				p = trg;
				if (trg.getXValue().getValues().size() == 0) {
					if ((trg.getXValue().getDatatype() instanceof DTCStructured)) {
						XDataStruct xs = new XDataStruct(trg.getXValue());

						ArrayList<FieldAndPath> values = new ArrayList<>();
						collectFields(xs.getDatatype(), null, values);
						for (FieldAndPath fieldAndPath : values) {
							switch (fieldAndPath.field.getDatatype().getName()) {
								case "Decimal":
									xs.setValueSafely(fieldAndPath.path, String.valueOf(1000));
									break;
								case "Integer":
									xs.setValueSafely(fieldAndPath.path, String.valueOf(1000));
									break;
								case "Boolean":
									xs.setValueSafely(fieldAndPath.path, "false");
									break;
								default:
									xs.setValueSafely(
										fieldAndPath.path,
										theSEER.getName() + "." + fieldAndPath.path + System.currentTimeMillis());
									break;
							}

						}
						trg.getXValue().addValue(xs);
					} else {
						trg.getXValue().addValue(
							(parent != null
									? parent.getName() + "."
									: "") + theSemanticElement.getName() + "." + theSEER.getName());
						if (trg.getXValue().getDatatype() == null) {
							logger.trace("errror");
						}
						if (trg.getXValue().getDatatype() != null) {
							logger.trace(trg.getXValue().getDatatype().getName());
						} else {
							logger.trace("datatype is null");
						}

					}
				}
			}

		}
		for (SemanticElement child : theSemanticElement.getChildren()) {
			populateSourceSemanticModel(child, p, bers, created, singles);
		}
	}

	/**
	 *
	 */
	private void processTargetSemanticModel() {
		logger.trace(
			"processTargetSemanticModelprocessTargetSemanticModelprocessTargetSemanticModelprocessTargetSemanticModel");
		Mdmi.INSTANCE().getTargetSemanticModelProcessors().targetSemanticModelProcessing(
			transferInfo, trgSemanticModel);
	}

	/**
	 *
	 */
	private void processSourceSemanticModel() {
		Mdmi.INSTANCE().getSourceSemanticModelProcessors().sourceSemanticProcessing(transferInfo, srcSemanticModel);
	}

	String getFullPathForNode(Node n) {
		if (n == null) {
			return "NULL SYNTAX NODE!!";
		}
		if (n.getParentNode() == null) {
			return n.getLocation();
		} else {
			return getFullPathForNode(n.getParentNode()) + "/" + n.getLocation();
		}
	}

	/**
	 *
	 */
	public void clean() {
		if (this.srcSemanticModel != null) {
			this.srcSemanticModel.getAllElementValues().clear();
		}

		if (this.trgSemanticModel != null) {
			this.trgSemanticModel.getAllElementValues().clear();
		}

		this.srcSyntaxModel = null;
		this.trgSyntaxModel = null;

	}

	public void printElementTree(List<IElementValue> elementValues) {
		Set<String> printedIds = new HashSet<>();

		for (IElementValue elementValue : elementValues) {
			if (elementValue.getParent() == null) {
				printElementTree(elementValue, 0, printedIds);
			}
		}

		// Verify that every element in the original list was printed
		for (IElementValue elementValue : elementValues) {
			String uniqueId = elementValue.getUniqueId();

			if (!printedIds.contains(uniqueId)) {
				System.out.println("NOT PRINTED: " + getSemanticName(elementValue) + " [uniqueId=" + uniqueId + "]");
			}
		}

		System.out.println("Total elements: " + elementValues.size());
		System.out.println("Printed elements: " + printedIds.size());
		System.out.println("All elements printed: " + (printedIds.size() == elementValues.size()));
	}

	private void printElementTree(IElementValue elementValue, int depth, Set<String> printedIds) {

		if (elementValue == null) {
			return;
		}

		String uniqueId = elementValue.getUniqueId();

		// Prevent duplicate printing and infinite recursion
		if (!printedIds.add(uniqueId)) {
			return;
		}

		String indent = "  ".repeat(depth);

		System.out.println(indent + getSemanticName(elementValue) + " [uniqueId=" + uniqueId + "]");

		if (elementValue.getChildren() != null) {
			for (IElementValue child : elementValue.getChildren()) {
				printElementTree(child, depth + 1, printedIds);
			}
		}
	}

	private String getSemanticName(IElementValue elementValue) {
		return elementValue.getSemanticElement() != null
				? elementValue.getSemanticElement().getName()
				: "null";
	}

} // MdmiUow
