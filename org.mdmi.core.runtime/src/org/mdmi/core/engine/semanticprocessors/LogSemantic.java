/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.semanticprocessors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class LogSemantic extends ConfigurableSemanticProcessor {

	void saveModel() {

	}

	private static Logger logger = LoggerFactory.getLogger(LogSemantic.class);

	static final int TRACE = 5;

	static final int DEBUG = 4;

	static final int INFO = 3;

	static final int WARN = 2;

	static final int ERROR = 1;

	public void log(String msg, StringBuffer sb) {
		// switch (level) {
		// case TRACE:
		// logger.trace(msg);
		// break;
		// case DEBUG:
		// logger.debug(msg);
		// break;
		// case INFO:
		// logger.info(msg);
		// break;
		// case WARN:
		// logger.warn(msg);
		// break;
		// case ERROR:
		// logger.error(msg);
		// break;
		// }
		sb.append(msg).append(System.lineSeparator());
	}

	public enum DIRECTION {
		FROM, TO
	}

	DIRECTION direction;

	int level = 1;

	/**
	 * @param direction
	 */
	public LogSemantic(DIRECTION direction) {
		super();
		this.direction = direction;
	}

	public LogSemantic() {
		super();
	}

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
		this.direction = DIRECTION.valueOf(map.get("direction").toString());
		if (map.containsKey("level")) {

			switch (map.get("level").toString()) {
				case "TRACE":
					level = 5;
					break;
				case "DEBUG":
					level = 4;
					break;
				case "INFO":
					level = 3;
					break;
				case "WARN":
					level = 2;
					break;
				case "ERROR":
					level = 1;
					break;
			}

		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#canProcess(org.mdmi.MessageModel)
	 */
	@Override
	public boolean canProcess(MessageModel messageModel) {
		if (level == ERROR) {
			return logger.isErrorEnabled();
		} else if (level == WARN) {
			return logger.isErrorEnabled();
		} else if (level == INFO) {
			return logger.isErrorEnabled();
		} else if (level == DEBUG) {
			return logger.isErrorEnabled();
		} else if (level == TRACE) {
			return logger.isErrorEnabled();
		}
		return false;
	}

	void serializeXDataStructa(XDataStruct v, int indent, StringBuffer sb) {

		for (String field : v.getFields()) {
			if (v.getValue(field) != null) {
				if (v.getValue(field) instanceof String) {
					log(field + " = " + v.getValue(field), sb);
				} else if (v.getValue(field) instanceof XDataStruct) {
					log(field, sb);
					serializeXDataStruct((XDataStruct) v.getValue(field), indent + 4, sb);
				} else {
					log(v.getValue(field).getClass() + " " + v.getValue(field), sb);
				}
			}
		}
	}

	void serializeXDataStruct(XDataStruct v, int indent, StringBuffer sb) {
		for (String field : v.getFields()) {
			Object value = v.getValue(field);

			if (value == null) {
				continue;
			}

			if (value instanceof String) {
				sb.append(" ".repeat(indent)).append(field).append(" = ").append(value).append(",");

			} else if (value instanceof XDataStruct) {
				sb.append(" ".repeat(indent)).append(field).append(",");

				serializeXDataStruct((XDataStruct) value, indent + 4, sb);

			} else {
				sb.append(" ".repeat(indent)).append(value.getClass()).append(" ").append(value).append(",");
			}
		}
	}

	void log(IElementValue semanticElement, int indent, StringBuffer sb) {

		String businessElementName = "NONE";

		if (direction.equals(DIRECTION.TO)) {
			for (ConversionRule fromRule : semanticElement.getSemanticElement().getMapToMdmi()) {
				businessElementName = fromRule.getBusinessElement().getName();
			}
		} else {
			for (ConversionRule fromRule : semanticElement.getSemanticElement().getMapFromMdmi()) {
				businessElementName = fromRule.getBusinessElement().getName();
			}
		}

		if (!businessElementName.equals("NONE")) {

			if (semanticElement.getXValue().getValue() instanceof XDataStruct) {
				log(semanticElement.getName() + " (" + businessElementName + ")", sb);
				XDataStruct v = (XDataStruct) semanticElement.getXValue().getValue();
				serializeXDataStruct(v, indent, sb);
				log(sb.toString(), sb);
			} else {
				log(
					semanticElement.getName() + " (" + businessElementName + ")" + " = " +
							semanticElement.getXValue().getValue(),
					sb);
			}
		}

		for (IElementValue childSemanticElement : semanticElement.getChildren()) {
			log(childSemanticElement, indent + 2, sb);
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#processSemanticModel(org.mdmi.core.ElementValueSet)
	 */
	@Override
	public void processSemanticModel(ElementValueSet semanticModel) {

		StringBuffer sb = new StringBuffer();
		printElementTree(semanticModel.getAllElementValues(), sb);

		// StringBuffer sb = new StringBuffer();
		// List<IElementValue> parents = new ArrayList<>();
		//
		// for (IElementValue semanticElement : semanticModel.getAllElementValues()) {
		// if (semanticElement.getParent() == null) {
		// parents.add(semanticElement);
		// }
		// }
		//
		// for (IElementValue semanticElement : parents) {
		// log(semanticElement, 1, sb);
		// }
		//
		if (logger.isTraceEnabled()) {
			try {
				Files.createDirectories(Paths.get("./logs"));
				if (direction.equals(DIRECTION.TO)) {
					Files.write(Paths.get("./logs/TargetSemanticModel.log"), sb.toString().getBytes());
				} else {
					Files.write(Paths.get("./logs/SourceSemanticModel.log"), sb.toString().getBytes());
				}
			} catch (IOException e) {
				logger.trace("Unable to log datatypes");
			}
		}
	}

	public void printElementTree(List<IElementValue> elementValues, StringBuffer sb) {
		Set<String> printedIds = new HashSet<>();

		for (IElementValue elementValue : elementValues) {
			if (elementValue.getParent() == null) {
				printElementTree(elementValue, 0, printedIds, sb);
			}
		}

		// Verify that every element in the original list was printed
		for (IElementValue elementValue : elementValues) {
			String uniqueId = elementValue.getUniqueId();

			if (!printedIds.contains(uniqueId)) {
				log("NOT PRINTED: " + getSemanticName(elementValue) + " [uniqueId=" + uniqueId + "]", sb);
			}
		}

		log("Total elements: " + elementValues.size(), sb);
		log("Printed elements: " + printedIds.size(), sb);
		log("All elements printed: " + (printedIds.size() == elementValues.size()), sb);
	}

	private void printElementTree(IElementValue elementValue, int depth, Set<String> printedIds, StringBuffer sb) {

		String businessElementName = "NONE";

		if (elementValue.getSemanticElement() != null) {

			if (direction.equals(DIRECTION.TO)) {
				for (ConversionRule fromRule : elementValue.getSemanticElement().getMapToMdmi()) {
					businessElementName = fromRule.getBusinessElement().getName();
				}
			} else {
				for (ConversionRule fromRule : elementValue.getSemanticElement().getMapFromMdmi()) {
					businessElementName = fromRule.getBusinessElement().getName();
				}
			}
		}

		if (elementValue == null) {
			return;
		}

		String uniqueId = elementValue.getUniqueId();

		// Prevent duplicate printing and infinite recursion
		if (!printedIds.add(uniqueId)) {
			return;
		}

		String indent = "  ".repeat(depth);

		log(
			indent + getSemanticName(elementValue) + "[SEER=" + businessElementName + "] [uniqueId=" + uniqueId + "]" +
					" = " + getSemanticValue(elementValue),
			sb);

		if (elementValue.getChildren() != null) {
			for (IElementValue child : elementValue.getChildren()) {
				printElementTree(child, depth + 1, printedIds, sb);
			}
		}
	}

	private String getSemanticValue(IElementValue elementValue) {

		StringBuffer sb = new StringBuffer();
		if (elementValue.getXValue().getValue() instanceof XDataStruct) {

			XDataStruct v = (XDataStruct) elementValue.getXValue().getValue();
			sb.append(v.getDatatype().getName() + " : ");
			serializeXDataStruct(v, 0, sb);
		} else {
			sb.append(elementValue.getXValue().getName() + " : ");
			sb.append(elementValue.getXValue().getValue());
		}
		return sb.toString();

	}

	private String getSemanticName(IElementValue elementValue) {
		return elementValue.getSemanticElement() != null
				? elementValue.getSemanticElement().getName()
				: "null";
	}

}
