/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.mdmi.ConversionRule;
import org.mdmi.DTCStructured;
import org.mdmi.DTSEnumerated;
import org.mdmi.DTSPrimitive;
import org.mdmi.EnumerationLiteral;
import org.mdmi.Field;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MDMIDatatype;
import org.mdmi.MDMIFactory;
import org.mdmi.MDMIFactory.Primitive;
import org.mdmi.MessageGroup;
import org.mdmi.Node;
import org.mdmi.SemanticElement;
import org.mdmi.core.ElementValueSet;
import org.mdmi.core.IElementValue;
import org.mdmi.core.Mdmi;
import org.mdmi.core.MdmiResolver.MI;
import org.mdmi.core.MdmiValueSet;
import org.mdmi.core.MdmiValueSetMap;
import org.mdmi.core.MdmiValueSetsHandler;
import org.mdmi.core.engine.ITerminologyTransform.TransformCode;
import org.mdmi.core.engine.terminology.FHIRTerminologyTransform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation class for rule execution.
 */
@SuppressWarnings("deprecation")
class ConversionImpl {

	private static Logger logger = LoggerFactory.getLogger(ConversionImpl.class);

	boolean logging;

	FileOutputStream jsonFop;

	File jsonFile;

	boolean first = true;

	HashMap<IElementValue, ArrayList<IElementValue>> sourcetotarget;

	HashMap<IElementValue, IElementValue> targettosource;

	ElementValueSet trgSemanticModel;

	/**
	 * @param sourcetotarget
	 * @param targettosource
	 * @param trgSemanticModel
	 */
	public ConversionImpl(HashMap<IElementValue, ArrayList<IElementValue>> sourcetotarget,
			HashMap<IElementValue, IElementValue> targettosource, ElementValueSet trgSemanticModel) {
		this.sourcetotarget = sourcetotarget;
		this.targettosource = targettosource;
		this.trgSemanticModel = trgSemanticModel;
	}

	private static String parseFunctionName(String rule) {

		String[] content = rule.split(":");

		if (content.length == 2) {
			return content[1];
		} else {
			return "invalidfunctionmapping";
		}
	}

	public DatamapInterpreter targetDatamapInterpreter;

	public DatamapInterpreter sourceDatamapInterpreter;

	FHIRTerminologyTransform terminologyService;

	/**
	 * @return the terminologyService
	 */
	public FHIRTerminologyTransform getTerminologyService() {
		if (terminologyService == null) {
			terminologyService = new FHIRTerminologyTransform();

			if (!terminologyService.healthCheck()) {
				FHIRTerminologyTransform.processTerminology = false;
			}
		}
		return terminologyService;
	}

	public static class SEERvalues {
		/**
		 * @param mber
		 * @param xvalue
		 */
		public SEERvalues(String mber, XValue xvalue) {
			super();
			this.mber = mber;
			this.xvalue = xvalue;
		}

		public String mber;

		public XValue xvalue;

	}

	ArrayList<SEERvalues> theSeerValues = new ArrayList<>();

	boolean convert(XElementValue sourceSemanticElement, ConversionInvocation ci, XElementValue targetSemanticElement)
			throws Exception {

		logger.trace("convert business element " + ci.srcBER.getName());

		ConversionRule mapToMDMI = ConversionImpl.getToBE(sourceSemanticElement.getSemanticElement(), ci.srcBER);

		ConversionRule mapFromMDMI = ConversionImpl.getToSE(targetSemanticElement.getSemanticElement(), ci.trgBER);

		XValue xv = new XValue(
			mapToMDMI.getBusinessElement().getName(), mapToMDMI.getBusinessElement().getReferenceDatatype());

		execMapToMDMI(sourceSemanticElement, mapToMDMI, xv);
		if (!xv.isNullOrEmpty()) {
			theSeerValues.add(new SEERvalues(mapToMDMI.getBusinessElement().getName(), xv));

			execMapFromMDMI(sourceSemanticElement, xv, targetSemanticElement, mapFromMDMI);
		}

		return !xv.isNullOrEmpty();
	}

	boolean hasSrcRule(ConversionRule toBE) {
		return toBE != null && toBE.getRule() != null && 0 < toBE.getRule().length();
	}

	boolean hasTrgRule(ConversionRule toSE) {
		return toSE != null && toSE.getRule() != null && 0 < toSE.getRule().length();
	}

	private static Map<String, DatamapInterpreter> datamapInterpreters = new HashMap<>();

	public synchronized void initializeDI(MessageGroup source, MessageGroup target, Properties sp, Properties tp) {
		String sourceKey = source.getName() + "_" + source.getModels().get(0).getMessageModelName() +
				"__DATATYPEMAPS___";
		String targetKey = target.getName() + "_" + target.getModels().get(0).getMessageModelName() +
				"__DATATYPEMAPS___";

		if (!datamapInterpreters.containsKey(sourceKey)) {

			MI mi = Mdmi.INSTANCE().getResolver().getMaps().get(
				source.getName() + "." + source.getModels().get(0).getMessageModelName());

			if (!StringUtils.isEmpty(mi.datatypemappings)) {
				datamapInterpreters.put(sourceKey, new DatamapInterpreter(mi.datatypemappings));
			} else {
				datamapInterpreters.put(sourceKey, new DatamapInterpreter(source));
			}

		}

		if (!datamapInterpreters.containsKey(targetKey)) {

			MI mi = Mdmi.INSTANCE().getResolver().getMaps().get(
				target.getName() + "." + target.getModels().get(0).getMessageModelName());

			if (!StringUtils.isEmpty(mi.datatypemappings)) {
				datamapInterpreters.put(targetKey, new DatamapInterpreter(mi.datatypemappings));
			} else {
				datamapInterpreters.put(targetKey, new DatamapInterpreter(target));
			}
		}

		sourceDatamapInterpreter = datamapInterpreters.get(sourceKey);
		targetDatamapInterpreter = datamapInterpreters.get(targetKey);

		sourceProperties = sp;
		targetProperties = tp;
		theSeerValues.clear();

	}

	Properties sourceProperties;

	Properties targetProperties;

	void execMapToMDMI(XElementValue src, ConversionRule toBE, XValue v) {

		if (!hasSrcRule(toBE)) {
			logger.trace("cloneValue");
			cloneValue(src.getXValue(), v, true, toBE, null);
		} else if (toBE.getRule().startsWith("DATATYPEMAP:")) {

			if (sourceDatamapInterpreter == null) {
				throw new RuntimeException("execMapToMDMI datamapInterpreter is null");
			}

			boolean executed = true;
			if (v.getValue() == null) {
				executed = sourceDatamapInterpreter.execute(
					parseFunctionName(toBE.getRule()), src.value(), v, sourceProperties, toBE);

			} else {
				executed = sourceDatamapInterpreter.execute(
					parseFunctionName(toBE.getRule()), src.value(), v.getValue(), sourceProperties, toBE);
			}
			if (!executed) {
				logger.error(
					"Unable To Execute " + parseFunctionName(toBE.getRule()) + " at " +
							getFullPathForNode(toBE.getOwner().getSyntaxNode()) + " for " +
							toBE.getBusinessElement().getName());
			}

		} else {
			logger.trace("Missing transformation Source Rule " + toBE.getRule());
		}

		if (v != null && hasTerminologyTransformation(toBE, toBE.getBusinessElement())) {

			if (v.getValue() != null && v.getValue() instanceof XDataStruct) {

				XDataStruct xds = (XDataStruct) v.getValue();

				if (xds.hasfield("code") && xds.getValue("code") != null &&
						!StringUtils.isEmpty(xds.getValue("code").toString())) {
					TransformCode transformCode = getTerminologyService().transform(
						toBE.getEnumExtResolverUri(), xds.getValue("code").toString(),
						toBE.getBusinessElement().getEnumValueSet());

					/** @TODO Add configuration for transformation code */
					if (!StringUtils.isEmpty(transformCode.code)) {
						xds.replaceValue("code", transformCode.code);
						if (xds.hasfield("codeSystem")) {
							xds.replaceValue("codeSystem", transformCode.system);
						}
						if (xds.hasfield("displayName")) {

							if (!StringUtils.isEmpty((String) xds.getValue("displayName")) &&
									xds.hasfield("originalText")) {
								xds.replaceValue("originalText", (String) xds.getValue("displayName"));
							}
							xds.replaceValue("displayName", transformCode.displayName);
						}
					}
				}
			}

		}

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

	private boolean hasTerminologyTransformation(ConversionRule conversionRule,
			MDMIBusinessElementReference businessElement) {

		if (conversionRule != null && businessElement != null) {
			return !StringUtils.isEmpty(conversionRule.getEnumExtResolverUri()) &&
					!StringUtils.isEmpty(businessElement.getEnumValueSet());
		}

		return false;
	}

	public HashMap<Object, XElementValue> refereneces = new HashMap<>();

	void execMapFromMDMI(XElementValue sourceSemanticElement, XValue v, XElementValue trg, ConversionRule toSE) {

		if (v != null) {

			if (hasTerminologyTransformation(toSE, toSE.getBusinessElement())) {

				if (v.getValue() != null && v.getValue() instanceof XDataStruct) {
					logger.trace("Looking to transform " + v.getValue());
					XDataStruct xds = (XDataStruct) v.getValue();
					if (xds.hasfield("code") && xds.getValue("code") != null &&
							!StringUtils.isEmpty(xds.getValue("code").toString())) {

						TransformCode transformCode = getTerminologyService().transform(
							toSE.getBusinessElement().getEnumValueSet(), xds.getValue("code").toString(),
							toSE.getEnumExtResolverUri());

						/** @TODO Add configuration for transformation code */
						if (!StringUtils.isEmpty(transformCode.code)) {
							xds.replaceValue("code", transformCode.code);
							if (xds.hasfield("codeSystem")) {
								xds.replaceValue("codeSystem", transformCode.system);
							}
							if (xds.hasfield("displayName")) {

								if (!StringUtils.isEmpty((String) xds.getValue("displayName")) &&
										xds.hasfield("originalText")) {
									xds.replaceValue("originalText", (String) xds.getValue("displayName"));
								}
								xds.replaceValue("displayName", transformCode.displayName);
							}
						}
					}
				}

			}

		}

		if (!hasTrgRule(toSE)) {
			cloneValue(v, trg.getXValue(), false, null, toSE);
		} else if (toSE.getRule().startsWith("DATATYPEMAP:")) {

			if (targetDatamapInterpreter == null) {
				throw new RuntimeException("execMapFromMDMI datamapInterpreter is null");
			}

			if (trg.getXValue().getValues().size() == 0) {
				if ((trg.getXValue().getDatatype() instanceof DTCStructured)) {
					XDataStruct xs = new XDataStruct(trg.getXValue());
					trg.getXValue().addValue(xs);
				}

			}

			Object source = null;

			if (v.getDatatype().isSimple()) {
				source = v;
			} else {
				source = v.getValue();
			}

			Object target = null;
			if (trg.getXValue().getDatatype().isSimple()) {
				target = trg;
			} else {
				target = trg.value();
			}
			boolean executed = targetDatamapInterpreter.execute(
				parseFunctionName(toSE.getRule()), source, target, targetProperties, toSE);

			if (!executed) {

				logger.error(
					"Unable To Execute " + parseFunctionName(toSE.getRule()) + " at " +
							getFullPathForNode(toSE.getOwner().getSyntaxNode()) + " for " +
							toSE.getBusinessElement().getName());
			}
		} else if (toSE.getRule().startsWith("REFERENCE:")) {
			if (trg.getXValue().getValues().size() == 0) {
				if ((trg.getXValue().getDatatype() instanceof DTCStructured)) {
					XDataStruct xs = new XDataStruct(trg.getXValue());
					trg.getXValue().addValue(xs);
				}
			}

			boolean executed = false;

			Object target = null;
			if (trg.getXValue().getDatatype().isSimple()) {
				target = trg;
			} else {
				target = trg.value();
			}

			DTSPrimitive primitive = MDMIFactory.eINSTANCE.createDTSPrimitive(Primitive.String);

			XValue guid = new XValue("GUID", primitive);

			String guidValue = "MISSING";

			if (toSE.getRule().endsWith("REVERSE")) {

				if (sourceSemanticElement.getParent() != null &&
						sourcetotarget.containsKey(sourceSemanticElement.getParent())) {
					guidValue = "urn:uuid:" +
							sourcetotarget.get(sourceSemanticElement.getParent()).get(0).getUniqueId();

				} else {
				}

			} else {

				if (trg.getSemanticElement().isMultipleInstances()) {
					if (sourceSemanticElement != null && sourcetotarget.containsKey(sourceSemanticElement)) {
						guidValue = "urn:uuid:" + sourcetotarget.get(sourceSemanticElement).get(0).getUniqueId();

					}
				} else {

					guidValue = "urn:uuid:" + sourceSemanticElement.getUniqueId();
				}
			}

			guid.setValue(guidValue);

			executed = targetDatamapInterpreter.execute(
				"mapStringToFHIR_Reference", guid, target, targetProperties, toSE);

			if (!executed) {
				logger.error(
					"Unable To Execute " + parseFunctionName(toSE.getRule()) + " at " +
							getFullPathForNode(toSE.getOwner().getSyntaxNode()) + " for " +
							toSE.getBusinessElement().getName());
			}

		} else

		{
			if (trg.getXValue().getValues().size() == 0 && (trg.getXValue().getDatatype() instanceof DTCStructured)) {

				XDataStruct xs = new XDataStruct(trg.getXValue());
				trg.getXValue().addValue(xs);
			}
		}
	}

	private void cloneStruct(XDataStruct src, XDataStruct trg, boolean fromSrc) {
		if (src == null || trg == null) {
			return;
		}
		Collection<XValue> values = trg.getXValues();
		for (XValue t : values) {
			XValue s = src.getXValue(t.getName());
			if (s != null) {
				cloneValue(s, t, fromSrc);
			}
		}
	}

	private void cloneChoice(XDataChoice src, XDataChoice trg, boolean fromSrc) {
		XValue s = src.getXValue();
		String fieldName = s.getName();
		XValue t = trg.setXValue(fieldName);
		cloneValue(s, t, fromSrc);
	}

	private void cloneValue(XValue src, XValue trg, boolean fromSrc) {
		cloneValue(src, trg, fromSrc, null, null);
	}

	private String getpath(Node n) {

		if (n == null) {
			return "null";
		}
		Stack<String> path = new Stack<>();

		if (n != null) {
			path.push(n.getLocation());
		}
		Node next = n.getParentNode();
		while (next != null) {
			path.push(next.getLocation());
			next = next.getParentNode();
		}

		StringBuilder sb = new StringBuilder();
		while (!path.isEmpty()) {
			sb.append(path.pop()).append("/");
		}

		return sb.toString();

	}

	private void cloneValue(XValue src, XValue trg, boolean fromSrc, ConversionRule toMDMI, ConversionRule fromMDMI) {

		if (src.getDatatype() == null) {
			logger.error(src.getName() + "  Datatype is NULL!");
			return;
		}

		if (trg.getDatatype() == null) {
			logger.error(trg.getName() + "  Datatype is NULL!");
			return;
		}

		if (!(src.getDatatype().getName().equals(trg.getDatatype().getName()))) {
			logger.error(
				"No Conversion rule found and the datatypes need to be the same to clone, \"" +
						src.getDatatype().getName() + " to " + trg.getDatatype().getName() + "\" at Semantic " +
						(toMDMI != null
								? toMDMI.getOwner().getName()
								: (fromMDMI != null
										? fromMDMI.getOwner().getName()
										: "UNKNOWN")) +
						" located " + getpath(
							(toMDMI != null
									? toMDMI.getOwner().getSyntaxNode()
									: (fromMDMI != null
											? fromMDMI.getOwner().getSyntaxNode()
											: null))));
			return;
		}

		List<Object> values = src.getValues();
		if (values.size() <= 0) {
			return;
		}

		if (src.getDatatype().isStruct()) {
			for (int i = 0; i < values.size(); i++) {
				XDataStruct srcXD = (XDataStruct) values.get(i);
				try {
					XDataStruct trgXD = new XDataStruct(trg);
					trg.setValue(trgXD);
					cloneStruct(srcXD, trgXD, fromSrc);
				} catch (java.lang.ClassCastException cce) {

					logger.debug(
						"NEED CONVERSION FOR " + src.getDatatype().getName() + " -----to----- " +
								trg.getDatatype().getName());
					logger.error(cce.getMessage());
				}

			}
		} else if (src.getDatatype().isChoice()) {
			for (int i = 0; i < values.size(); i++) {
				XDataChoice srcXD = (XDataChoice) values.get(i);
				XDataChoice trgXD = new XDataChoice(trg);
				trg.setValue(trgXD);
				cloneChoice(srcXD, trgXD, fromSrc);
			}
		} else { // simple
			if (src.getDatatype().isPrimitive() || src.getDatatype().isDerived() || src.getDatatype().isExternal()) {
				trg.cloneValues(src);
			} else {
				DTSEnumerated edt = (DTSEnumerated) trg.getDatatype();
				trg.clear();
				for (int i = 0; i < values.size(); i++) {
					EnumerationLiteral srcEL = (EnumerationLiteral) values.get(i);
					if (srcEL != null) {
						EnumerationLiteral trgEL = edt.getLiteralByCode(srcEL.getCode());
						trg.setValue(trgEL, -1);
					}
				}
			}
		}
	}

	/**
	 * @deprecated
	 *
	 * @param src
	 * @param trg
	 * @param fromSrc
	 * @param toBE
	 * @param toSE
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private void vsConvertWithResolver(XValue src, XValue trg, boolean fromSrc, ConversionRule toBE,
			ConversionRule toSE) {
		Field srcField = null;
		Field trgField = null;
		if (fromSrc) {
			SemanticElement se = toBE.getOwner(); // source
			MDMIBusinessElementReference ber = toBE.getBusinessElement(); // target
			DTCStructured srcDT = (DTCStructured) se.getDatatype();
			srcField = srcDT.getField(se.getEnumValueField());
			DTCStructured trgDT = (DTCStructured) ber.getReferenceDatatype();
			trgField = trgDT.getField(ber.getEnumValueField());
		} else {
			SemanticElement se = toSE.getOwner(); // target
			MDMIBusinessElementReference ber = toSE.getBusinessElement(); // source
			DTCStructured srcDT = (DTCStructured) ber.getReferenceDatatype();
			srcField = srcDT.getField(ber.getEnumValueField());
			DTCStructured trgDT = (DTCStructured) se.getDatatype();
			trgField = trgDT.getField(se.getEnumValueField());
		}
		List<Object> values = src.getValues();
		for (int i = 0; i < values.size(); i++) {
			XDataStruct srcXD = (XDataStruct) values.get(i);
			XDataStruct trgXD = new XDataStruct(trg);
			trg.setValue(trgXD);
			srcXD.getXValue(srcField);
			trgXD.getXValue(trgField);
		}
	}

	/**
	 * @deprecated
	 * @param src
	 * @param trg
	 * @param fromSrc
	 * @param toBE
	 * @param toSE
	 * @return
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private boolean vsConvert(XValue src, XValue trg, boolean fromSrc, ConversionRule toBE, ConversionRule toSE) {
		MdmiValueSetsHandler handler = null;
		String vsMapName = null;
		MDMIDatatype srcDT = null;
		MDMIDatatype trgDT = null;
		Field srcField = null;
		Field trgField = null;
		Field trgFieldDescr = null;
		if (fromSrc) {
			SemanticElement se = toBE.getOwner(); // source
			MDMIBusinessElementReference ber = toBE.getBusinessElement(); // target
			handler = Mdmi.INSTANCE().getResolver().getValueSetsHandler(
				se.getElementSet().getModel().getGroup().getName(), "");
			vsMapName = MdmiValueSetMap.getMapName(se.getEnumValueSet(), ber.getEnumValueSet());
			srcDT = se.getDatatype();
			trgDT = ber.getReferenceDatatype();
			if (srcDT instanceof DTCStructured) {
				DTCStructured xdt = (DTCStructured) se.getDatatype();
				srcField = xdt.getField(se.getEnumValueField());
			}
			if (trgDT instanceof DTCStructured) {
				DTCStructured xdt = (DTCStructured) ber.getReferenceDatatype();
				trgField = xdt.getField(ber.getEnumValueField());
				if (null != ber.getEnumValueDescrField()) {
					trgFieldDescr = xdt.getField(ber.getEnumValueDescrField());
				}
			}
		} else {
			SemanticElement se = toSE.getOwner(); // target
			MDMIBusinessElementReference ber = toSE.getBusinessElement(); // source
			handler = Mdmi.INSTANCE().getResolver().getValueSetsHandler(
				se.getElementSet().getModel().getGroup().getName(), "");
			vsMapName = MdmiValueSetMap.getMapName(ber.getEnumValueSet(), se.getEnumValueSet());
			srcDT = ber.getReferenceDatatype();
			trgDT = se.getDatatype();
			if (srcDT instanceof DTCStructured) {
				DTCStructured xdt = (DTCStructured) ber.getReferenceDatatype();
				srcField = xdt.getField(ber.getEnumValueField());
			}
			if (trgDT instanceof DTCStructured) {
				DTCStructured xdt = (DTCStructured) se.getDatatype();
				trgField = xdt.getField(se.getEnumValueField());
				if (null != se.getEnumValueDescrField()) {
					trgFieldDescr = xdt.getField(se.getEnumValueDescrField());
				}
			}
		}
		if (null == handler) {
			return false;
		}
		MdmiValueSetMap vsMap = handler.getValueSetMap(vsMapName);
		if (null == vsMap) {
			return false;
		}

		List<Object> values = src.getValues();
		for (int i = 0; i < values.size(); i++) {
			Object source = values.get(i); // XDataStruct or EnumerationLiteral

			if (null == srcField && null == trgField) {
				// 1. Enum - > Enum
				EnumerationLiteral srcEL = (EnumerationLiteral) source;
				MdmiValueSetMap.Mapping map = vsMap.getMappingBySource(srcEL.getName());
				if (null != map) {
					MdmiValueSet.Value target = map.getTarget();
					DTSEnumerated srcDTSE = (DTSEnumerated) srcDT;
					trg.setValue(srcDTSE.getLiteralByName(target.getCode()));
				}
			} else if (null != srcField && null == trgField) {
				// 2. VS - > Enum
				XDataStruct srcXD = (XDataStruct) values.get(i);
				XValue sfv = srcXD.getXValue(srcField);
				MdmiValueSetMap.Mapping map = vsMap.getMappingBySource((String) sfv.getValue());
				if (null != map) {
					MdmiValueSet.Value target = map.getTarget();
					DTSEnumerated srcDTSE = (DTSEnumerated) srcDT;
					trg.setValue(srcDTSE.getLiteralByName(target.getCode()));
				}
			} else if (null == srcField && null != trgField) {
				// 3. Enum -> VS
				EnumerationLiteral srcEL = (EnumerationLiteral) source;
				XDataStruct trgXD = new XDataStruct(trg);
				trg.setValue(trgXD);
				XValue tfv = trgXD.getXValue(trgField);
				XValue tfvd = null;
				if (null != trgFieldDescr) {
					tfvd = trgXD.getXValue(trgFieldDescr);
				}
				MdmiValueSetMap.Mapping map = vsMap.getMappingBySource(srcEL.getName());
				if (null != map) {
					MdmiValueSet.Value target = map.getTarget();
					tfv.setValue(target.getCode());
					if (null != tfvd) {
						tfvd.setValue(target.getDescription());
					}
				}
			} else {
				// 4. VS -> VS
				XDataStruct srcXD = (XDataStruct) values.get(i);
				XDataStruct trgXD = new XDataStruct(trg);
				trg.setValue(trgXD);
				XValue sfv = srcXD.getXValue(srcField);
				XValue tfv = trgXD.getXValue(trgField);
				XValue tfvd = null;
				if (null != trgFieldDescr) {
					tfvd = trgXD.getXValue(trgFieldDescr);
				}
				MdmiValueSetMap.Mapping map = vsMap.getMappingBySource((String) sfv.getValue());
				if (null != map) {
					MdmiValueSet.Value target = map.getTarget();
					tfv.setValue(target.getCode());
					if (null != tfvd) {
						tfvd.setValue(target.getDescription());
					}
				}
			}
		}
		return true;
	}

	public void start(boolean logging) {
		this.logging = logging;
		if (this.logging) {
			try (FileOutputStream jsonFop = new FileOutputStream(new File("./logs/Conversion.json"))) {
				jsonFop.write("[".getBytes());
			} catch (FileNotFoundException e) {

			} catch (IOException e) {

			}
			first = true;
		}
	}

	public void end() {
		if (this.logging) {
			try {
				jsonFop.write("]".getBytes());
				jsonFop.flush();
				jsonFop.close();
				jsonFop = null;
			} catch (IOException e) {

			}
		}
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

} // ConversionImpl
