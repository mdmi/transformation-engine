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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * MDMI Unit of Work. Will execute a transfer from the source to the target
 * messages, based on the given maps.
 *
 * @author goancea
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
			// watch.split();
			// logger.trace("Split Time Elapsed in MILLISECONDS: " + watch.getSplitNanoTime());
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

		if (true || logger.isTraceEnabled()) {
			try {
				Files.createDirectories(Paths.get("./logs"));

				Gson gson = new GsonBuilder().setPrettyPrinting().create();

				String json = gson.toJson(transferInfo.sourceMessage.getUnspecifiedNodes());

				Files.write(Paths.get("./logs/unspececified.json"), json.getBytes());

				// // Write JSON to file
				// try (FileWriter writer = new FileWriter("people.json")) {
				// gson.toJson(people, writer);
				// System.out.println("JSON file created: people.json");
				// } catch (IOException e) {
				// e.printStackTrace();
				// }

				// Files.write(
				// Paths.get("./logs/" + messageGropu.getName() + "datatypemaps.js"), sb.toString().getBytes());
			} catch (IOException e) {
				logger.trace("Unable to log datatypes");
				// e.printStackTrace();
			}
		}
		// engine.eval(compile(sb.toString()));

		for (UnspecifiedNode unspecified : transferInfo.sourceMessage.getUnspecifiedNodes()) {

		}

		watch.split();
		logger.info("parse : " + watch.toSplitString());

		if (logger.isTraceEnabled()) {
			try {
				Files.createDirectories(Paths.get("./logs"));

				Files.write(Paths.get("./logs/sourcesyntax.log"), srcSyntaxModel.toString().getBytes());

			} catch (IOException e) {
				logger.trace("Unable to log srcSyntaxModel");
				// e.printStackTrace();
			}
		}

		logger.debug("Source Syntax Model : \n" + srcSyntaxModel.toString());

		srcSemanticModel = new ElementValueSet();

		srcSemProv.buildSemanticModel(
			transferInfo.sourceModel.getModel(), srcSyntaxModel, srcSemanticModel, transferInfo.sourceProperties,
			transferInfo.sourceValues);

		watch.split();
		logger.info("buildSemanticModel : " + watch.toSplitString());

		// if (logger.isTraceEnabled()) {
		// logElementSet(srcSemanticModel);
		// }
		// logger.debug("Source Semantic Model : \n" + srcSemanticModel.toString());

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
		// xElementValue.get

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

	void findTargetSemanticElements() {

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

	private static class Reference {

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

		// this.transferInfo
		if (sourceMessageGroup.getName().toUpperCase().startsWith("FHIR") &&
				targetMessageGroup.getName().toUpperCase().startsWith("CDA")) {
			return true;
		}
		return false;
	}

	void processConversions() {

		this.transferInfo.targetMessage.getUnspecifiedNodes().addAll(
			this.transferInfo.sourceMessage.getUnspecifiedNodes());

		StopWatch watch = new StopWatch();
		watch.start();

		// 3. execute the data conversions

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

		HashMap<IElementValue, ArrayList<IElementValue>> sourcetotarget = new HashMap<>();
		HashMap<IElementValue, IElementValue> targettosource = new HashMap<>();

		ConversionImpl impl = new ConversionImpl(sourcetotarget, targettosource, trgSemanticModel);

		impl.initializeDI(
			transferInfo.sourceModel.getGroup(), transferInfo.targetModel.getGroup(), transferInfo.sourceProperties,
			transferInfo.targetProperties);

		watch.split();
		logger.info("impl.initializeDI " + watch.getTime());

		boolean skipContainmentCheck = "SKIPCONTAINMENT".equals(transferInfo.targetModel.getGroup().getDescription());

		EList<SemanticElement> l = transferInfo.targetModel.getModel().getElementSet().getSemanticElements();

		HashMap<String, ArrayList<SemanticElement>> targetSementicElementsByBER = new HashMap<>();

		HashSet<String> targetSementicReferences = new HashSet<>();

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
					targetSementicElementsByBER.get(tme.getBusinessElement().getUniqueIdentifier()).add(
						targetSementicElement);
				}
			}

		}

		for (SemanticElement targetSementicElement : l) {

			for (ConversionRule tmo : targetSementicElement.getMapFromMdmi()) {
				if (!StringUtils.isEmpty(tmo.getRule()) && tmo.getRule().startsWith("REFERENCE:")) {
					targetSementicReferences.add(targetSementicElement.getName());
				}
			}

		}

		HashMap<String, Boolean> filtered = new HashMap<>();
		for (IElementValue sourceElementValue : whattotransfer) {

			// Create list of RI for the element

			for (ConversionRule tme : sourceElementValue.getSemanticElement().getMapToMdmi()) {

				if ((tme.getBusinessElement() == null) ||
						!targetSementicElementsByBER.containsKey(tme.getBusinessElement().getUniqueIdentifier())) {
					continue;
				}

				// Create list of target semantic elements based on the source RI
				for (SemanticElement targetSementicElement : targetSementicElementsByBER.get(
					tme.getBusinessElement().getUniqueIdentifier())) {

					if (sourceFilter) {
						if ("Container".equals(targetSementicElement.getDatatype().getName()) &&
								targetSementicElement.getRelationshipByName("QUALIFIER") != null) {
							String theKey = sourceElementValue.getUniqueId() + "_HASFILTERED_" +
									targetSementicElement.getUniqueId();

							if (!filtered.containsKey(theKey)) {
								filtered.put(theKey, filterSource(impl, sourceElementValue, targetSementicElement));
							}
							if (!filtered.get(theKey)) {
								continue;
							}
						} else {
							if (targetSementicElement.getParent() != null &&
									"Container".equals(targetSementicElement.getParent().getDatatype().getName()) &&
									targetSementicElement.getParent().getRelationshipByName("QUALIFIER") != null &&
									sourceElementValue.getParent() != null) {
								String theKey = sourceElementValue.getParent().getUniqueId() + "_HASFILTERED_" +
										targetSementicElement.getUniqueId();
								if (!filtered.containsKey(theKey)) {
									filtered.put(
										theKey, filterSource(
											impl, sourceElementValue.getParent(), targetSementicElement.getParent()));
								}

								if (!filtered.get(theKey)) {
									continue;
								}
							}

						}
					}

					for (ConversionRule tmo : targetSementicElement.getMapFromMdmi()) {

						/*
						 * Current caching not 100% correct
						 * need to return getMapFrom using business element
						 */
						if (!tme.getBusinessElement().getUniqueIdentifier().equals(
							tmo.getBusinessElement().getUniqueIdentifier())) {
							continue;
						}

						Stack<SemanticElement> mappedParentStack = new Stack<>();
						getMappedStack(targetSementicElement, mappedParentStack);

						boolean wholeStackMapped = true;

						if (!skipContainmentCheck) {
							while (!mappedParentStack.isEmpty()) {
								SemanticElement mp1 = mappedParentStack.pop();
								boolean isMP1Mapped = false;
								for (ConversionRule lll : mp1.getMapFromMdmi()) {
									if (matches.containsKey(lll.getBusinessElement().getUniqueIdentifier())) {
										isMP1Mapped = true;
										break;
									}
								}
								wholeStackMapped = isMP1Mapped;
								if (!wholeStackMapped) {
									break;
								}
							}
						}

						if (targetSementicReferences.contains(targetSementicElement.getName())) {
							boolean checkReferenceContainment = false;
							if (tmo.getRule() != null && tmo.getRule().startsWith("REFERENCE:")) {

								String[] referenceParameters = tmo.getRule().split(":");
								String containmentParameter = referenceParameters[1];
								IElementValue element = sourceElementValue.getParent();
								// if (containmentParameter.equals("OrganizationContainer")) {
								// checkReferenceContainment = true;
								// }

								// if ("Patient0988".equals(targetSementicElement.getName())) {
								// checkReferenceContainment = true;
								// }
								//
								// if ("Beneficiary333".equals(targetSementicElement.getName())) {
								// checkReferenceContainment = true;
								// }
								while (element != null && !checkReferenceContainment) {
									for (ConversionRule zzz : element.getSemanticElement().getMapToMdmi()) {

										if (containmentParameter.equals(zzz.getBusinessElement().getName())) {
											checkReferenceContainment = true;
										}
									}
									element = element.getParent();
								}

								if (!checkReferenceContainment) {

									final List<String> found = new ArrayList<String>();

									Consumer<? super IElementValue> go = new Consumer<IElementValue>() {

										@Override
										public void accept(IElementValue t) {

											if (t.getSemanticElement() != null) {
												for (ConversionRule zzz : t.getSemanticElement().getMapToMdmi()) {

													if (containmentParameter.equals(
														zzz.getBusinessElement().getName())) {
														found.add("found");
													}
												}
											}

											// TODO Auto-generated method stub

										}

									};
									whattotransfer.forEach(go);
									if (!found.isEmpty()) {
										checkReferenceContainment = true;
									}

									//
									// for (whattotransfer.) {
									//
									// }
									// // sourceElementValue.
									// // if (targetSementicElement.getParent() != null) {
									// // // if (srcSemanticModel.) {
									// // //
									// // // }
									// // }

								}
							}

							wholeStackMapped = false; // checkReferenceContainment;
						}

						if (wholeStackMapped) {

							logger.trace(
								" Creating target element " + targetSementicElement.getName() +
										" from source semantic element" +
										sourceElementValue.getSemanticElement().getName());

							XElementValue targetElementValue = new XElementValue(
								targetSementicElement, trgSemanticModel);

							try {
								@SuppressWarnings("deprecation")
								org.mdmi.core.engine.ConversionInvocation ci = new org.mdmi.core.engine.ConversionInvocation(
									targetSementicElement, tme.getBusinessElement(), tmo.getBusinessElement());
								impl.convert((XElementValue) sourceElementValue, ci, targetElementValue);

								targettosource.put(targetElementValue, sourceElementValue);

								if (!sourcetotarget.containsKey(sourceElementValue)) {
									sourcetotarget.put(sourceElementValue, new ArrayList<IElementValue>());
								}
								sourcetotarget.get(sourceElementValue).add(targetElementValue);

							} catch (Exception e) {
								logger.error("ERROR IN CONVERSION", e);
							}
						} else {
							logger.debug(
								sourceElementValue.getName() +
										" NOT TRANSFERRED, Semantic containment not established");
							if (logger.isDebugEnabled()) {
								Stack<SemanticElement> missingSemanticStack = new Stack<>();
								getMappedStack(targetSementicElement, missingSemanticStack);

								while (!missingSemanticStack.isEmpty()) {
									SemanticElement mp1 = missingSemanticStack.pop();
									logger.debug("Semantic Path " + mp1.getName());
									boolean isMP1Mapped = false;
									for (ConversionRule lll : mp1.getMapFromMdmi()) {
										if (matches.containsKey(lll.getBusinessElement().getUniqueIdentifier())) {
											isMP1Mapped = true;
											break;
										}
									}
									if (!isMP1Mapped) {
										logger.debug("MISSING ELEMENT " + mp1.getName());
										break;
									}
								}
							}

						}

					}
				}

			}

		}

		// for (String r : targetSementicReferences) {
		//
		// }

		// ArrayList<Reference> referencesToCreate = new ArrayList<>();
		// for (IElementValue x : trgSemanticModel.getAllElementValues()) {
		//
		// for (SemanticElement c : x.getSemanticElement().getChildren()) {
		//
		// for (ConversionRule toMessage : c.getMapFromMdmi()) {
		// if (toMessage.getRule() != null && toMessage.getRule().startsWith("REFERENCE:")) {
		//
		// String[] referenceParameters = toMessage.getRule().split(":");
		//
		// for (IElementValue again : trgSemanticModel.getAllElementValues()) {
		// for (SemanticElement againc : again.getSemanticElement().getChildren()) {
		//
		// for (ConversionRule toMessageAgain : againc.getMapFromMdmi()) {
		//
		// if (toMessageAgain.getBusinessElement() != null && referenceParameters[1].equals(
		// toMessageAgain.getBusinessElement().getName())) {
		//
		// for (ConversionRule xxx : c.getMapFromMdmi()) {
		// if (xxx.getBusinessElement() != null) {
		//
		// for (IElementValue sourceElement : srcSemanticModel.getAllElementValues()) {
		// for (ConversionRule toMdmi2 : sourceElement.getSemanticElement().getMapToMdmi()) {
		// if (toMdmi2.getBusinessElement().getUniqueIdentifier().equals(
		// xxx.getBusinessElement().getUniqueIdentifier())) {
		//
		// Reference ref = new Reference(x, sourceElement, c);
		// referencesToCreate.add(ref);
		//
		// }
		// }
		//
		// }
		// }
		//
		// }
		//
		// }
		//
		// }
		//
		// }
		// }
		//
		// }
		//
		// }
		// }
		//
		// }

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

		System.err.println("WTF trgValues " + trgValues.size());
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

		// ✅ 3. Now handle only REFERENCE rules once
		for (IElementValue trgVal : trgValues) {
			for (SemanticElement child : trgVal.getSemanticElement().getChildren()) {
				for (ConversionRule refRule : child.getMapFromMdmi()) {
					String ruleText = refRule.getRule();
					if (ruleText != null && ruleText.startsWith("xxxxREFERENCE:")) {

						String[] refParams = ruleText.split(":");
						if (refParams.length < 2)
							continue; // guard

						String referencedName = refParams[1];
						List<ConversionRule> matchingTargetRules = trgByBusinessName.get(referencedName);
						if (matchingTargetRules == null)
							continue;

						// For each matched target rule, find matching source rules
						for (ConversionRule matchedTarget : matchingTargetRules) {
							for (ConversionRule innerRule : child.getMapFromMdmi()) {
								if (innerRule.getBusinessElement() == null)
									continue;

								String beId = innerRule.getBusinessElement().getUniqueIdentifier();
								IElementValue matchingSrcVal = srcByBusinessId.get(beId);
								if (matchingSrcVal != null) {
									System.err.println("REFERENCE Element " + trgVal.getSemanticElement().getName());
									System.err.println("REFERENCE Child " + child.getName());
									referencesToCreate.add(new Reference(trgVal, matchingSrcVal, child));
								}
							}
						}
					}
				}
			}
		}

		System.err.println("WTF " + referencesToCreate.size());
		for (Reference r : referencesToCreate) {

			try {

				// @SuppressWarnings("deprecation")

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

						targettosource.put(targetElementValue, r.getSource());

						if (!sourcetotarget.containsKey(r.getSource())) {
							sourcetotarget.put(r.getSource(), new ArrayList<IElementValue>());
						}
						sourcetotarget.get(r.getSource()).add(targetElementValue);

					}
				}

			} catch (Exception e) {
				logger.error("ERROR IN CONVERSION", e);
			}
			// }
		}

		watch.split();
		logger.trace("what to transfer : " + watch.toSplitString());

		ArrayList<SemanticElement> singles = new ArrayList<>();

		for (SemanticElement semanticElement : transferInfo.targetModel.getModel().getElementSet().getSemanticElements()) {
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

		for (SemanticElement single : singles) {
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
								XElementValue singleElementValue = new XElementValue(single, trgSemanticModel);
								try {
									@SuppressWarnings("deprecation")
									org.mdmi.core.engine.ConversionInvocation ci = new org.mdmi.core.engine.ConversionInvocation(
										single, sourceRI, conversionRule.getBusinessElement());
									impl.convert((XElementValue) elementValue, ci, singleElementValue);

									List<IElementValue> foundElements = trgSemanticModel.getElementValuesByName(
										theSingleParent);

									for (IElementValue parentElementValue : foundElements) {
										parentElementValue.addChild(singleElementValue);
										singleElementValue.setParent(parentElementValue);
									}

								} catch (Exception e) {
									logger.error("ERROR IN CONVERSION", e);
								}

							}
						}

					}
				}
			}
		}

		watch.split();
		logger.trace("singles : " + watch.toSplitString());
		/*
		 * Loop over and set semantic containers
		 */

		// for (

		// IElementValue targetElementValue : targettosource.keySet()) {

		for (IElementValue targetElementValue : this.trgSemanticModel.getAllElementValues()) {
			if (targettosource.containsKey(targetElementValue)) {
				if (targetElementValue.getParent() == null) {
					if (targetElementValue.getSemanticElement().isMultipleInstances()) {
						IElementValue sourceElementValue = targettosource.get(targetElementValue);
						IElementValue sourceParent = sourceElementValue.getParent();

						while (sourceParent != null && !sourcetotarget.containsKey(sourceParent)) {
							sourceParent = sourceParent.getParent();
						}
						if (sourceParent != null && sourcetotarget.containsKey(sourceParent)) {
							for (IElementValue targetParent : sourcetotarget.get(sourceParent)) {

								if (targetParent.getSemanticElement().getRelationshipByName("QUALIFIER") != null) {
									for (SemanticElement child : targetParent.getSemanticElement().getChildren()) {

										if (targetElementValue.getSemanticElement().getUniqueId().equals(
											child.getUniqueId())) {
											targetParent.addChild(targetElementValue);
										}

									}

								} else {
									targetParent.addChild(targetElementValue);
								}

							}

						}

					}
				}
			}

		}

		for (Object o : impl.refereneces.keySet()) {
			XDataStruct xValue = (XDataStruct) o;
			XElementValue foo = impl.refereneces.get(o);
			IElementValue bar = sourcetotarget.get(impl.refereneces.get(o)).get(0);
			ArrayList<IElementValue> targets = sourcetotarget.get(impl.refereneces.get(o));
			for (IElementValue target : targets) {
				if ("Container".equals(target.getSemanticElement().getDatatype().getName())) {
					String guidValue = "urn:uuid:" + target.getUniqueId();
					xValue.setValueSafely("reference.value", guidValue);
				}
			}
		}

		ListIterator<IElementValue> iterator = trgSemanticModel.getAllElementValues().listIterator();

		while (iterator.hasNext()) {
			IElementValue targetElementValue = iterator.next();

			if (isBreakContainment(targetElementValue.getSemanticElement())) {
				if (targetElementValue.getParent() != null) {
					for (IElementValue child : targetElementValue.getChildren()) {
						if (isBreadCrumb(child.getSemanticElement())) {
							// logger.trace("isBreadCrumb 1 " + child.getSemanticElement().getName());
							for (SemanticElement child2 : targetElementValue.getParent().getSemanticElement().getChildren()) {
								if (isBreadCrumb(child2)) {
									// logger.trace("isBreadCrumb 2 " + child2.getName());
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
		logger.info("containers : " + watch.toSplitString());

		ArrayList<IElementValue> tobedeleted = new ArrayList<>();

		if (!sourceFilter) {

			for (IElementValue targetElementValue : targettosource.keySet()) {
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

		// for (
		//
		// String key : impl.sourceDatamapInterpreter.exceptions.keySet()) {
		// logger.error(key);
		// logger.error(impl.sourceDatamapInterpreter.exceptions.get(key).getMessage());
		// }
		//
		// for (
		//
		// String key : impl.targetDatamapInterpreter.exceptions.keySet()) {
		// logger.error(key);
		// logger.error(impl.targetDatamapInterpreter.exceptions.get(key).getMessage());
		// }

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
		// long ts = System.currentTimeMillis();

		StopWatch watch = new StopWatch();
		watch.start();

		trgSemProv.updateTargetSemanticModel(
			transferInfo.targetModel.getModel(), trgSemanticModel, trgSyntaxModel, transferInfo.targetProperties,
			transferInfo.targetValues);
		watch.split();
		logger.info("Split processOutboundTargetMessage updateTargetSemanticModel : " + watch.toSplitString());

		processTargetSemanticModel();
		watch.split();
		logger.info("Split processOutboundTargetMessage processTargetSemanticModel : " + watch.toSplitString());

		if (trgSyntaxModel != null) {
			trgSemProv.updateSyntacticModel(
				transferInfo.targetModel.getModel(), trgSemanticModel, trgSyntaxModel, transferInfo.targetProperties);
			watch.split();
			logger.info("Split processOutboundTargetMessage updateSyntacticModel : " + watch.toSplitString());

		} else {
			trgSyntaxModel = trgSemProv.createNewSyntacticModel(
				transferInfo.targetModel.getModel(), trgSemanticModel, transferInfo.targetProperties);
			watch.split();
			logger.info("Split processOutboundTargetMessage createNewSyntacticModel : " + watch.toSplitString());

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
		logger.info("Split processOutboundTargetMessage serialize : " + watch.toSplitString());

		//
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
		// for (MessageModel s : messageGroup.getModels()) {
		// return resolver().getSyntacticParser(messageGroup.getName(), s.getMessageModelName());
		// }
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
		// logger.trace(path);

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
		//
		// this.srcSemanticModel.clearCach();
		// this.trgSemanticModel.clearCach();
		// this.trgSemanticModel = null;
		// this.srcSemanticModel = null;

	}

} // MdmiUow
