/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.semanticprocessors;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.mdmi.ConversionRule;
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
public class LogSemanticErrors extends ConfigurableSemanticProcessor {

	public LogSemanticErrors() {
		super();
	}

	private static Logger logger = LoggerFactory.getLogger(LogSemanticErrors.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#getName()
	 */
	@Override
	public String getName() {
		return "LogSemantic";
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

	void log(IElementValue semanticElement, int indent) {

		String errorDescription = "NONE";

		for (ConversionRule fromRule : semanticElement.getSemanticElement().getMapToMdmi()) {
			errorDescription = fromRule.getDescription();
		}

		logger.error(
			StringUtils.repeat("-", indent) + "> " + semanticElement.getName() + " (" + errorDescription + ")" + " = " +
					semanticElement.getXValue().getValue());

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#processSemanticModel(org.mdmi.core.ElementValueSet)
	 */
	@Override
	public void processSemanticModel(ElementValueSet semanticModel) {

		for (IElementValue semanticElement : semanticModel.getAllElementValues()) {

			for (ConversionRule fromRule : semanticElement.getSemanticElement().getMapToMdmi()) {
				if ("2ddc0e5b-f7e6-4bb3-a79d-285616953c1e".equals(
					fromRule.getBusinessElement().getUniqueIdentifier())) {
					log(semanticElement, 0);

				}
			}

		}

	}

}
