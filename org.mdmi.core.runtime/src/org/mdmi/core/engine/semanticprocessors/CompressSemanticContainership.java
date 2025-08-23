/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.semanticprocessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.mdmi.MessageModel;
import org.mdmi.core.ElementValueSet;
import org.mdmi.core.IElementValue;
import org.mdmi.core.engine.XDataStruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author seanmuir
 *
 */
public class CompressSemanticContainership extends ConfigurableSemanticProcessor {

	/**
	 * @param direction
	 */
	public CompressSemanticContainership() {
		super();

	}

	private static Logger logger = LoggerFactory.getLogger(CompressSemanticContainership.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#getName()
	 */
	@Override
	public String getName() {
		return "CompressSemanticContainership";
	}

	@Override
	public void setArguments(Object arguments) {
		Map map = (Map) arguments;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#canProcess(org.mdmi.MessageModel)
	 */
	@Override
	public boolean canProcess(MessageModel messageModel) {
		return true;
	}

	void serializeXDataStruct(XDataStruct v, int indent) {
		for (String field : v.getFields()) {
			if (v.getValue(field) != null) {
				if (v.getValue(field) instanceof String) {
					logger.trace(StringUtils.repeat(".", indent + 2) + " " + field + " = " + v.getValue(field));
				} else if (v.getValue(field) instanceof XDataStruct) {
					logger.trace(StringUtils.repeat("-", indent + 2) + "> " + field);
					serializeXDataStruct((XDataStruct) v.getValue(field), indent + 4);
				} else {
					logger.trace(v.getValue(field).getClass() + " " + v.getValue(field));
				}
			}
		}
	}

	void compress(IElementValue semanticElement) {
		logger.trace("compreass " + semanticElement.getName());
		for (IElementValue childSemanticElement : semanticElement.getChildren()) {
			compress(childSemanticElement);
		}

		if (semanticElement.getParent() != null) {
			for (IElementValue childSemanticElement : semanticElement.getChildren()) {
				if (!"Container".equals(childSemanticElement.getSemanticElement().getDatatype().getName())) {
					logger.trace("set parent " + semanticElement.getName());
					childSemanticElement.setParent(semanticElement.getParent());
				}
			}
		}

	}

	void log(IElementValue semanticElement, int indent) {

		// if (direction.equals(DIRECTION.TO)) {
		//
		// }
		//
		// logger.trace("***********************************************");
		// logger.trace("***********************************************");
		// logger.trace("***********************************************");

		String businessElementName = "NONE";

		// if (direction.equals(DIRECTION.TO)) {
		// for (ConversionRule fromRule : semanticElement.getSemanticElement().getMapToMdmi()) {
		// businessElementName = fromRule.getBusinessElement().getName();
		// }
		// } else {
		// for (ConversionRule fromRule : semanticElement.getSemanticElement().getMapFromMdmi()) {
		// businessElementName = fromRule.getBusinessElement().getName();
		// }
		// }

		if (semanticElement.getXValue().getValue() instanceof XDataStruct) {
			logger.trace(
				StringUtils.repeat("-", indent) + "> " + semanticElement.getName() + " (" + businessElementName + ")");
			XDataStruct v = (XDataStruct) semanticElement.getXValue().getValue();
			serializeXDataStruct(v, indent);
		} else {
			logger.trace(
				StringUtils.repeat("-", indent) + "> " + semanticElement.getName() + " (" + businessElementName + ")" +
						" = " + semanticElement.getXValue().getValue());
		}

		for (IElementValue childSemanticElement : semanticElement.getChildren()) {
			log(childSemanticElement, indent + 2);
		}

		logger.trace("***********************************************");
		logger.trace("***********************************************");
		logger.trace("***********************************************");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#processSemanticModel(org.mdmi.core.ElementValueSet)
	 */
	@Override
	public void processSemanticModel(ElementValueSet semanticModel) {

		List<IElementValue> parents = new ArrayList<>();

		for (IElementValue semanticElement : semanticModel.getAllElementValues()) {
			if (semanticElement.getParent() == null) {
				parents.add(semanticElement);
			}
		}

		for (IElementValue semanticElement : parents) {
			compress(semanticElement);
		}
	}

}
