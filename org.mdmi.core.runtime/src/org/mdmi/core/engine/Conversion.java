/*******************************************************************************
 * Copyright (c) 2012, 2017, 2018 MDIX Inc
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     MDIX Inc - initial API and implementation
 *
 * Author:
 *     Gabriel Oancea
 *
 *******************************************************************************/
package org.mdmi.core.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.mdmi.ConversionRule;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MDMIDomainDictionaryReference;
import org.mdmi.MessageModel;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementType;
import org.mdmi.core.IElementValue;
import org.mdmi.core.MdmiException;
import org.mdmi.core.MdmiTransferInfo;

/**
 * @deprecated
 *
 *
 *             Internal class, defines a conversion for a transfer request, within a unit of
 *             work.
 *
 * @author goancea
 */
@Deprecated
public class Conversion {
	MdmiUow m_owner;

	MdmiTransferInfo m_transferInfo;

	ArrayList<ConversionInfo> m_conversionInfos = new ArrayList<>();

	/**
	 * Construct an instance from the given unit of work.
	 *
	 * @param owner
	 *            The UoW owner.
	 */
	Conversion(MdmiUow owner) {
		if (owner == null || owner.transferInfo == null || owner.transferInfo.targetElements == null) {
			throw new IllegalArgumentException("Null or invalid argument!");
		}
		m_owner = owner;
		m_transferInfo = m_owner.transferInfo;

		ArrayList<MDMIBusinessElementReference> elements = m_transferInfo.targetElements;
		if (elements.size() <= 0) {
			return;
		}
		if (m_transferInfo.useDictionary) {
			initFromDictionaryElements(elements);
		} else {
			initFromTargetElements(elements);
		}
	}

	/**
	 * Construct a ConversionInfo for each element in the
	 * m_transferInfo.targetElements. The names in the
	 * m_transferInfo.targetElements are target BusinessElementRefecence names.
	 *
	 * @param elements
	 *            The elements to use, a list of strings.
	 */
	private void initFromDictionaryElements(ArrayList<MDMIBusinessElementReference> elements) {
		MessageModel trgModel = m_transferInfo.targetModel.getModel();
		MessageModel srcModel = m_transferInfo.sourceModel.getModel();

		MDMIDomainDictionaryReference trgDict = trgModel.getGroup().getDomainDictionary();
		MDMIDomainDictionaryReference srcDict = srcModel.getGroup().getDomainDictionary();

		for (int i = 0; i < elements.size(); i++) {
			MDMIBusinessElementReference name = elements.get(i);
			MDMIBusinessElementReference trgBER = trgDict.getBusinessElement(name);
			if (trgBER == null) {
				throw new MdmiException("Conversion: invalid target BER " + name);
			}

			String uid = trgBER.getUniqueIdentifier();
			MDMIBusinessElementReference srcBER = srcDict.getBusinessElementByUniqueID(uid);
			if (srcBER == null) {
				throw new MdmiException("Conversion: invalid source BER for unique ID " + uid);
			}

			ArrayList<SemanticElement> trgSes = getTargetSESforBER(trgModel, trgBER);
			if (trgSes.size() <= 0) {
				throw new MdmiException(
					"Conversion: invalid mapping, missing target SEs, target BER is " + trgBER.getName());
			}

			ArrayList<ConversionInfo> cis = new ArrayList<>();
			for (int j = 0; j < trgSes.size(); j++) {
				SemanticElement target = trgSes.get(j);
				ConversionInfo ci = new ConversionInfo(target, trgBER, srcBER);
				ArrayList<SemanticElement> srcSes = getSourceSESforBER(srcModel, srcBER);
				if (srcSes.size() <= 0) {
					break;
					// throw new MdmiException("Conversion: invalid mapping, missing source SEs, source BER is " + ci.srcBER.getName());
				}
				for (int k = 0; k < srcSes.size(); k++) {
					SemanticElement ses = srcSes.get(k);
					for (ConversionRule tme : ses.getMapFromMdmi()) {
						// Only add to the source if the business element match and the semantic elements match
						// Check to see if isomorphic - this is a kludge for ken
						if (trgModel.getGroup().getName().equals(srcModel.getGroup().getName())) {
							if (tme.getOwner().equals(target) && trgBER.getUniqueIdentifier().equals(
								tme.getBusinessElement().getUniqueIdentifier())) {
								ci.source.add(ses);
								break;
							}
						} else {
							if (trgBER.getUniqueIdentifier().equals(tme.getBusinessElement().getUniqueIdentifier())) {
								ci.source.add(ses);
								break;
							}
						}
					}
				}
				cis.add(ci);
			}
			m_conversionInfos.addAll(cis);
		}
	}

	/**
	 * Construct a ConversionInfo for each element in the
	 * m_transferInfo.targetElements. The names in the
	 * m_transferInfo.targetElements are target SemanticElement names.
	 *
	 * @param elements
	 *            The elements to use, a list of strings.
	 */
	private void initFromTargetElements(ArrayList<MDMIBusinessElementReference> elements) {
		MessageModel trgModel = m_transferInfo.targetModel.getModel();
		MessageModel srcModel = m_transferInfo.sourceModel.getModel();

		MDMIDomainDictionaryReference srcDict = srcModel.getGroup().getDomainDictionary();

		for (int i = 0; i < elements.size(); i++) {
			MDMIBusinessElementReference name = elements.get(i);
			SemanticElement target = trgModel.getElementSet().getSemanticElement(name);
			if (target == null) {
				throw new MdmiException("Conversion: invalid target SE " + name);
			}

			ArrayList<MDMIBusinessElementReference> trgBers = getTargetBERSforSE(trgModel, target);
			// JGK: I believe it is OK to have semantic elements that are not mapped to business elements
			if (trgBers.size() <= 0) {
				continue;
			}

			ArrayList<ConversionInfo> cis = new ArrayList<>();
			for (int j = 0; j < trgBers.size(); j++) {
				MDMIBusinessElementReference trgBER = trgBers.get(j);
				String uid = trgBER.getUniqueIdentifier();
				MDMIBusinessElementReference srcBER = srcDict.getBusinessElementByUniqueID(uid);
				if (srcBER == null) {
					throw new MdmiException("Conversion: invalid source BER element for unique ID " + uid);
				}
				ConversionInfo ci = new ConversionInfo(target, trgBER, srcBER);
				ArrayList<SemanticElement> srcSes = getSourceSESforBER(srcModel, srcBER);
				if (srcSes.size() <= 0) {
					throw new MdmiException("Conversion: no source SEs found, source BER is " + ci.srcBER.getName());
				}
				for (int k = 0; k < srcSes.size(); k++) {
					SemanticElement ses = srcSes.get(k);
					ci.source.add(ses);
				}
				cis.add(ci);
			}
			m_conversionInfos.addAll(cis);
		}
	}

	/**
	 * Execute all the conversions for this unit of work.
	 */
	void execute() {
		try {
			ConversionImpl impl = new ConversionImpl(null, null, null);
			impl.start(false);

			ArrayList<ConversionInfo> cis = getTopLevelCis();
			for (int i = 0; i < cis.size(); i++) {
				ConversionInfo ci = cis.get(i);

				for (int j = 0; j < ci.source.size(); j++) {
					boolean deleteOnNull = false;
					boolean generateParent = false;
					SemanticElement source = ci.source.get(j);
					List<IElementValue> srcs = m_owner.srcSemanticModel.getElementValuesByType(source);
					List<IElementValue> trgs = m_owner.trgSemanticModel.getElementValuesByType(ci.target);
					HashMap<String, XElementValue> relTrgs = new HashMap<>();
					boolean hasKey = source.hasValidKeyRelation();
					if (ci.target.isMultipleInstances()) {
						for (int k = 0; k < srcs.size(); k++) {
							XElementValue parentContainer = null;
							XElementValue src = (XElementValue) srcs.get(k);
							XElementValue trg = null;
							ArrayList<XElementValue> trgXes = new ArrayList<>();
							CWMM cwmm = null;

							if (hasKey && 0 < k) {
								// determine if there is another one with the same key
								if (null != src.getRelations() && null != src.getRelations().get(0) &&
										null != src.getRelations().get(0).getXValue()) {
									String keyValue = (String) src.getRelations().get(0).getXValue().getValue();
									trg = relTrgs.get(keyValue);
								}
							}

							if (null == trg && k < trgs.size()) {
								trg = (XElementValue) trgs.get(k);
								trgXes.add(trg);
							} else if (null == trg) {
								trg = new XElementValue(ci.target, m_owner.trgSemanticModel);
								if (0 < trgs.size()) {
									parentContainer = (XElementValue) trgs.get(0).getParent();
									generateTargetValue(trg, parentContainer);
									generateParent = true;
								}
								deleteOnNull = true;
								trgXes.add(trg);
								cwmm = getChildWithMultipleMaps(ci);
								if (null != cwmm) {
									for (int l = 1; l < cwmm.count; l++) {
										trg = new XElementValue(ci.target, m_owner.trgSemanticModel);
										if (0 < trgs.size()) {
											parentContainer = (XElementValue) trgs.get(0).getParent();
											generateTargetValue(trg, parentContainer);
											generateParent = true;
										}
										trgXes.add(trg);
									}
								}
							}
							if (null != cwmm) {
								boolean failed = false;
								for (int l = 1; l < trgXes.size(); l++) {
									trg = trgXes.get(l);
									if (!impl.convert(src, ci, trg)) {
										failed = true;
										if (deleteOnNull) {
											if (generateParent) {
												removeGeneratedTargetValue(trg, parentContainer);
											}
											m_owner.trgSemanticModel.removeElementValue(trg);
										}
									}
									if (!failed) {
										execute(src, ci, trgXes, cwmm);
									}
								}
							} else {
								if (impl.convert(src, ci, trg)) {
									execute(src, ci, trg);
									if (hasKey) {
										if (null != src.getRelations() && null != src.getRelations().get(0) &&
												null != src.getRelations().get(0).getXValue()) {
											String keyValue = (String) src.getRelations().get(0).getXValue().getValue();
											if (null == relTrgs.get(keyValue)) {
												relTrgs.put(keyValue, trg);
											}
										}
									}
								} else if (deleteOnNull) {
									if (generateParent) {
										removeGeneratedTargetValue(trg, parentContainer);
									}
									m_owner.trgSemanticModel.removeElementValue(trg);
								}
							}
						}
					} else {
						XElementValue trg = null;
						if (trgs.size() <= 0) {
							trg = new XElementValue(ci.target, m_owner.trgSemanticModel);
							deleteOnNull = true;
						} else {
							trg = (XElementValue) trgs.get(0);
						}
						boolean targetSet = false;
						for (int k = 0; k < srcs.size(); k++) {
							XElementValue src = (XElementValue) srcs.get(k);
							if (impl.convert(src, ci, trg)) {
								targetSet = true;
								execute(src, ci, trg);
							}
						}
						if (!targetSet && deleteOnNull) {
							m_owner.trgSemanticModel.removeElementValue(trg);
						}
					}
				}
			}
			impl.end();
		} catch (Exception e) {

			throw new MdmiException(e.getMessage());
		}
		// NOTE: this may have side effects! Added temporary.
		// Check for any empty Containers and remove them
		List<IElementValue> xevs = m_owner.trgSemanticModel.getAllElementValues();
		for (int i = xevs.size() - 1; 0 <= i; i--) {
			IElementValue xev = xevs.get(i);
			if (xev.getSemanticElement().getDatatype().getName().equals("Container")) {
				if (xev.getChildCount() <= 0) {
					m_owner.trgSemanticModel.removeElementValue(xev);
				}
			}
		}
	}

	HashMap<String, List<IElementValue>> globalSources = new HashMap<>();

	// Child With Multiple Maps
	private static class CWMM {
		public SemanticElement semanticElement;

		public int count;

		public CWMM(SemanticElement se, int cnt) {
			semanticElement = se;
			count = cnt;
		}
	}

	// returns null if there is no child with multiple maps
	private CWMM getChildWithMultipleMaps(ConversionInfo parent) {
		ArrayList<ConversionInfo> cis = getCisForSE(parent.target);
		HashMap<String, CWMM> ses = new HashMap<>();
		CWMM max = null;
		for (int i = 0; i < cis.size(); i++) {
			ConversionInfo ci = cis.get(i);
			CWMM cwmm = ses.get(ci.target.getName());
			if (null == cwmm) {
				ses.put(ci.target.getName(), new CWMM(ci.target, 1));
			} else {
				cwmm.count++;
				max = cwmm;
			}
		}
		return max;
	}

	private void execute(XElementValue srcOwner, ConversionInfo parent, XElementValue trgOwner) {
		try {
			ArrayList<ConversionInfo> cis = getCisForSE(parent.target);
			executeCis(srcOwner, parent, trgOwner, cis);
		} catch (Exception e) {

			throw new MdmiException(e.getMessage());
		}
	}

	private void execute(XElementValue srcOwner, ConversionInfo parent, ArrayList<XElementValue> trgOwners, CWMM cwmm) {
		try {
			ArrayList<ConversionInfo> cis = getCisForSE(parent.target);
			ArrayList<ConversionInfo> procs = new ArrayList<>();
			for (int i = 0; i < trgOwners.size(); i++) {
				// generate an array of CIs that for each owners has only obe CI of the multiple-mapped child
				XElementValue trgOwner = trgOwners.get(i);
				ArrayList<ConversionInfo> cisProc = new ArrayList<>();
				boolean added = false;
				for (int j = 0; j < cis.size(); j++) {
					ConversionInfo ci = cis.get(j);
					if (ci.target == cwmm.semanticElement) {
						if (!procs.contains(ci) && !added) {
							cisProc.add(ci);
							procs.add(ci);
							added = true;
						}
					} else {
						cisProc.add(ci);
					}
				}
				executeCis(srcOwner, parent, trgOwner, cisProc);
			}
		} catch (Exception e) {

			throw new MdmiException(e.getMessage());
		}
	}

	private void executeCis(XElementValue srcOwner, ConversionInfo parent, XElementValue trgOwner,
			ArrayList<ConversionInfo> cis) throws Exception {
		ConversionImpl impl = new ConversionImpl(null, null, null);
		for (int i = 0; i < cis.size(); i++) {
			ConversionInfo ci = cis.get(i);
			for (int j = 0; j < ci.source.size(); j++) {
				SemanticElement source = ci.source.get(j);
				SemanticElement seParent = source.getParent();
				SemanticElement seParentOwner = srcOwner.getSemanticElement();
				List<IElementValue> srcs = null;
				// if the owner SE is not the same as the source parent SE, use
				// all elements, otherwise get only children
				if (seParent != seParentOwner) {
					if (!globalSources.containsKey(source.getName())) {
						globalSources.put(source.getName(), m_owner.srcSemanticModel.getElementValuesByType(source));
					}
					srcs = globalSources.get(source.getName());
				} else {
					srcs = m_owner.srcSemanticModel.getDirectChildValuesByType(source, srcOwner);
				}

				List<IElementValue> trgs = m_owner.trgSemanticModel.getDirectChildValuesByType(ci.target, trgOwner);

				boolean deleteOnNull = false;
				if (ci.target.isMultipleInstances()) {
					HashMap<String, XElementValue> relTrgs = new HashMap<>();
					boolean hasKey = source.hasValidKeyRelation();
					for (int k = 0; k < srcs.size(); k++) {
						XElementValue src = (XElementValue) srcs.get(k);
						XElementValue trg = null;
						ArrayList<XElementValue> trgXes = new ArrayList<>();
						CWMM cwmm = null;

						if (hasKey && 0 < k) {
							// determine if there is another one with the same key
							if (null != src.getRelations() && null != src.getRelations().get(0) &&
									null != src.getRelations().get(0).getXValue()) {
								String keyValue = (String) src.getRelations().get(0).getXValue().getValue();
								trg = relTrgs.get(keyValue);
							}
						}

						if (null == trg && k < trgs.size()) {
							trg = (XElementValue) trgs.get(k);
							trgXes.add(trg);
						} else if (null == trg) {
							trg = new XElementValue(ci.target, m_owner.trgSemanticModel);
							trgOwner.addChild(trg);
							trgXes.add(trg);
							deleteOnNull = true;
							cwmm = getChildWithMultipleMaps(ci);
							if (null != cwmm) {
								for (int l = 1; l < cwmm.count; l++) {
									trg = new XElementValue(ci.target, m_owner.trgSemanticModel);
									trgOwner.addChild(trg);
									trgXes.add(trg);
								}
							}
						}
						if (null != cwmm) {
							boolean failed = false;
							for (int l = 1; l < trgXes.size(); l++) {
								trg = trgXes.get(l);
								if (!impl.convert(src, ci, trg)) {
									failed = true;
									if (deleteOnNull) {
										trgOwner.removeChild(trg);
										m_owner.trgSemanticModel.removeElementValue(trg);
									}
								}
								if (!failed) {
									execute(src, ci, trgXes, cwmm);
								}
							}
						} else {
							if (impl.convert(src, ci, trg)) {
								execute(src, ci, trg);
								if (hasKey) {
									if (null != src.getRelations() && null != src.getRelations().get(0) &&
											null != src.getRelations().get(0).getXValue()) {
										String keyValue = (String) src.getRelations().get(0).getXValue().getValue();
										if (null == relTrgs.get(keyValue)) {
											relTrgs.put(keyValue, trg);
										}
									}
								}
							} else if (deleteOnNull) {
								trgOwner.removeChild(trg);
								m_owner.trgSemanticModel.removeElementValue(trg);
							}
						}
					}
				} else {
					XElementValue trg = null;
					if (trgs.size() <= 0) {
						trg = new XElementValue(ci.target, m_owner.trgSemanticModel);
						trgOwner.addChild(trg);
						deleteOnNull = true;
					} else {
						trg = (XElementValue) trgs.get(0);
					}
					boolean targetSet = false;
					for (int k = 0; k < srcs.size(); k++) {
						XElementValue src = (XElementValue) srcs.get(k);
						if (impl.convert(src, ci, trg)) {
							targetSet = true;
							execute(src, ci, trg);
						}
					}
					if (!targetSet && deleteOnNull) {
						trgOwner.removeChild(trg);
						m_owner.trgSemanticModel.removeElementValue(trg);
					}
				}
			}
		}
	}

	// generates target ElementValue tree
	private void generateTargetValue(IElementValue targetValue, IElementValue parentContainer) {
		if (parentContainer == null) {
			return;
		}
		if (targetValue.getSemanticElement().getSyntaxNode().isSingle()) {
			IElementValue parentTargetValue = new XElementValue(
				targetValue.getSemanticElement().getParent(), m_owner.trgSemanticModel);
			((XValue) parentTargetValue.getXValue()).intializeStructs();
			parentTargetValue.addChild(targetValue);

			generateRequiredSEValues(parentTargetValue.getSemanticElement(), parentTargetValue);
			generateTargetValue(parentTargetValue, parentContainer.getParent());
			m_owner.trgSemanticModel.removeElementValue(parentTargetValue);
		} else {
			parentContainer.addChild(targetValue);
		}
	}

	// remove generated parent tree
	private void removeGeneratedTargetValue(XElementValue targetValue, XElementValue parentContainer) {
		if (parentContainer == null) {
			return;
		}
		if (targetValue.getSemanticElement().getSyntaxNode().isSingle()) {
			XElementValue parentTargetValue = (XElementValue) targetValue.getParent();
			removeGeneratedRequiredSEValues(parentTargetValue.getSemanticElement(), parentTargetValue);
			removeGeneratedTargetValue(parentTargetValue, (XElementValue) parentContainer.getParent());
		} else {
			parentContainer.removeChild(targetValue);
		}
	}

	// generates target element values for required SNs
	private void generateRequiredSEValues(SemanticElement sourceSE, IElementValue sourceEV) {
		for (SemanticElement childSE : sourceSE.getChildren()) {
			if (!hasChildElementValue(sourceEV, childSE) && childSE.getSyntaxNode().isRequired()) {
				XElementValue childTargetValue = new XElementValue(childSE, m_owner.trgSemanticModel);
				childTargetValue.getXValue().intializeStructs();
				sourceEV.addChild(childTargetValue);
				childTargetValue.setParent(sourceEV);
			}

			if (childSE.getChildren().size() > 0) {
				generateRequiredSEValues(childSE, getChildElementValue(sourceEV, childSE));
			}
		}
	}

	// remove generated target element values for required SNs
	private void removeGeneratedRequiredSEValues(SemanticElement sourceSE, XElementValue sourceEV) {
		for (SemanticElement childSE : sourceSE.getChildren()) {
			if (childSE.getSyntaxNode().isRequired()) {
				XElementValue child = (XElementValue) getChildElementValue(sourceEV, childSE);
				if (childSE.getChildren().size() > 0) {
					removeGeneratedRequiredSEValues(childSE, child);
				}
				m_owner.trgSemanticModel.removeElementValue(child);
				sourceEV.removeChild(child);
			}
		}
	}

	private boolean hasChildElementValue(IElementValue elementValue, SemanticElement childSemanticElement) {
		return getChildElementValue(elementValue, childSemanticElement) != null;
	}

	private IElementValue getChildElementValue(IElementValue elementValue, SemanticElement childSemanticElement) {
		for (IElementValue childEV : elementValue.getChildren()) {
			if (childEV.getSemanticElement() == childSemanticElement) {
				return childEV;
			}
		}
		return null;
	}

	// get the CIs for which the target SE's are top level, i.e. have no parent or have a LOCAL parent
	private ArrayList<ConversionInfo> getTopLevelCis() {
		ArrayList<ConversionInfo> cis = new ArrayList<>();

		// HashMap to make sure ConversionInfo is only added once
		HashMap<String, ConversionInfo> hm = new HashMap<>();
		for (int i = 0; i < m_conversionInfos.size(); i++) {
			ConversionInfo ci = m_conversionInfos.get(i);
			SemanticElement parent = ci.target.getParent();
			if (null == parent || parent.getSemanticElementType() == SemanticElementType.LOCAL) {
				cis.add(ci);
				hm.put(String.valueOf(i), ci);
			}
		}
		// check for the case where the parent is a container and is not mapped and the grand parent is a local SE
		// this case is to fix a different hierarchy depth mapping (Ken)
		for (int i = 0; i < m_conversionInfos.size(); i++) {
			ConversionInfo ci = m_conversionInfos.get(i);
			SemanticElement parent = ci.target.getParent();
			if (null == parent || !parent.getDatatype().getName().equalsIgnoreCase("container") ||
					hm.containsKey(String.valueOf(i)) || parentHasConversion(cis, parent)) {
				continue; // a CI with the target = the parent is in conversions list already, do not add twice
			}
			SemanticElement grandParent = parent.getParent(); // check if the grandparent is null or local
			if (null == grandParent || grandParent.getSemanticElementType() == SemanticElementType.LOCAL) {
				cis.add(ci);
			}
		}
		return cis;
	}

	// true if a CI with the parent as target is already in the list
	private static boolean parentHasConversion(ArrayList<ConversionInfo> cis, SemanticElement parent) {
		for (int i = 0; i < cis.size(); i++) {
			ConversionInfo ci = cis.get(i);
			if (parent == ci.target) {
				return true;
			}
		}
		return false;
	}

	// get the CIs for which the target SE is a child of the given SE
	private ArrayList<ConversionInfo> getCisForSE(SemanticElement parent) {
		ArrayList<ConversionInfo> cis = new ArrayList<>();
		for (int i = 0; i < m_conversionInfos.size(); i++) {
			ConversionInfo ci = m_conversionInfos.get(i);
			if (parent.hasChild(ci.target)) {
				cis.add(ci);
			}
		}
		return cis;
	}

	// given a BER get a list of all SEs that have a ConversionRule rule for it
	private ArrayList<SemanticElement> getSourceSESforBER(MessageModel model, MDMIBusinessElementReference ber) {
		ArrayList<SemanticElement> a = new ArrayList<>();
		Collection<SemanticElement> srcSEs = model.getElementSet().getSemanticElements();
		for (Iterator<SemanticElement> itSE = srcSEs.iterator(); itSE.hasNext();) {
			SemanticElement se = itSE.next();
			Collection<ConversionRule> toBEs = se.getMapFromMdmi();
			for (Iterator<ConversionRule> itBE = toBEs.iterator(); itBE.hasNext();) {
				ConversionRule tbe = itBE.next();
				if (tbe != null && tbe.getBusinessElement() == ber) {
					a.add(se);
					break;
				}
			}
		}
		// if (a.size() <= 0) {
		// SemanticElement se = model.getElementSet().getSemanticElement(ber.getName());
		// if (se != null) {
		// a.add(se);
		// }
		// }
		return a;
	}

	// given a BER get a list of all SEs that have a ConversionRule rule for it
	private ArrayList<SemanticElement> getTargetSESforBER(MessageModel model, MDMIBusinessElementReference ber) {
		ArrayList<SemanticElement> a = new ArrayList<>();
		Collection<SemanticElement> srcSEs = model.getElementSet().getSemanticElements();
		for (Iterator<SemanticElement> itSE = srcSEs.iterator(); itSE.hasNext();) {
			SemanticElement se = itSE.next();
			Collection<ConversionRule> toMEs = se.getMapToMdmi();
			for (Iterator<ConversionRule> itME = toMEs.iterator(); itME.hasNext();) {
				ConversionRule tme = itME.next();
				if (tme != null && tme.getBusinessElement() == ber) {
					a.add(se);
					break;
				}
			}
		}
		// if (a.size() <= 0) {
		// SemanticElement se = model.getElementSet().getSemanticElement(ber.getName());
		// if (se != null) {
		// a.add(se);
		// }
		// }
		return a;
	}

	@SuppressWarnings("unused")
	private ArrayList<MDMIBusinessElementReference> getSourceBERSforSE(MessageModel model, SemanticElement se) {
		ArrayList<MDMIBusinessElementReference> a = new ArrayList<>();
		Collection<ConversionRule> toBEs = se.getMapFromMdmi();
		for (Iterator<ConversionRule> itBE = toBEs.iterator(); itBE.hasNext();) {
			ConversionRule tbe = itBE.next();
			if (tbe != null) {
				a.add(tbe.getBusinessElement());
				break;
			}
		}
		if (a.size() <= 0) {
			MDMIBusinessElementReference ber = model.getGroup().getDomainDictionary().getBusinessElement(se.getName());
			if (ber != null) {
				a.add(ber);
			}
		}
		return a;
	}

	private ArrayList<MDMIBusinessElementReference> getTargetBERSforSE(MessageModel model, SemanticElement se) {
		ArrayList<MDMIBusinessElementReference> a = new ArrayList<>();
		Collection<ConversionRule> toMEs = se.getMapToMdmi();
		for (Iterator<ConversionRule> itME = toMEs.iterator(); itME.hasNext();) {
			ConversionRule tme = itME.next();
			if (tme != null) {
				a.add(tme.getBusinessElement());
				// JGK: This line must be a bug because one can map multiple BEs to an SE.
				// break;
			}
		}
		if (a.size() <= 0) {
			MDMIBusinessElementReference ber = model.getGroup().getDomainDictionary().getBusinessElement(se.getName());
			if (ber != null) {
				a.add(ber);
			}
		}
		return a;
	}

	static ConversionRule getToSE(SemanticElement src, MDMIBusinessElementReference ber) {
		Collection<ConversionRule> toBEs = src.getMapFromMdmi();
		for (Iterator<ConversionRule> it = toBEs.iterator(); it.hasNext();) {
			ConversionRule t = it.next();
			if (t.getBusinessElement().getUniqueIdentifier().equals(ber.getUniqueIdentifier())) {
				return t;
			}
		}
		return null;
	}

	static ConversionRule getToBE(SemanticElement trg, MDMIBusinessElementReference ber) {
		Collection<ConversionRule> toSEs = trg.getMapToMdmi();
		for (Iterator<ConversionRule> it = toSEs.iterator(); it.hasNext();) {
			ConversionRule t = it.next();
			if (t.getBusinessElement().getUniqueIdentifier().equals(ber.getUniqueIdentifier())) {
				return t;
			}
		}
		return null;
	}

	/**
	 * Each instance of this class wraps one conversion, from one source SE to
	 * one or more target SEs, through a source and target BER.
	 *
	 * @author goancea
	 */
	static public class ConversionInfo {
		public SemanticElement target; // target message element

		public MDMIBusinessElementReference trgBER; // target business element reference

		public MDMIBusinessElementReference srcBER; // source business element reference (same unique ID as target)

		ArrayList<SemanticElement> source; // source message elements

		public ConversionInfo(SemanticElement target, MDMIBusinessElementReference trgBER,
				MDMIBusinessElementReference srcBER) {
			this.target = target;
			this.trgBER = trgBER;
			this.srcBER = srcBER;
			this.source = new ArrayList<>();
		}

		@SuppressWarnings("unchecked")
		ConversionInfo(ConversionInfo src) {
			target = src.target;
			trgBER = src.trgBER;
			srcBER = src.srcBER;
			source = (ArrayList<SemanticElement>) src.source.clone();
		}

		@Override
		public ConversionInfo clone() {
			return new ConversionInfo(this);
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			if (source.size() == 1) {
				sb.append(source.get(0).getName() + " -> ");
			} else {
				sb.append("[ ");
				for (int i = 0; i < source.size(); i++) {
					if (i > 0) {
						sb.append(", ");
					}
					sb.append(source.get(i).getName());
				}
				sb.append(" ] -> ");
			}
			sb.append(
				(trgBER == null
						? "null"
						: trgBER.getName()) + " -> ");
			sb.append(
				(target == null
						? "null"
						: target.getName()));
			return sb.toString();
		}
	} // Conversion$ConversionInfo

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < m_conversionInfos.size(); i++) {
			ConversionInfo ci = m_conversionInfos.get(i);
			sb.append(ci.toString()).append("\r\n");
		}
		return sb.toString();
	}
} // Conversion
