package org.mdmi.core.engine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mdmi.core.ElementValueSet;
import org.mdmi.core.IElementValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility methods for tracing MDMI semantic element values.
 */
public final class MdmiUowLogUtil {

	private static final Logger logger = LoggerFactory.getLogger(MdmiUowLogUtil.class);

	private MdmiUowLogUtil() {
		// Utility class.
	}

	public static void logElementSet(ElementValueSet srcSemanticModel2) {

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

	private static void logXElementValue(XElementValue xElementValue) {

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

	private static void logXDataStruct(XDataStruct xDataStruct) {
		for (XValue value : xDataStruct.getXValues()) {
			logXValue(value);
		}
	}

	private static void logXValue(XValue xValue) {

		for (Object value : xValue.getValues()) {
			if (value instanceof XDataStruct) {
				logXDataStruct((XDataStruct) value);
			} else {
				logger.trace("VALUE IS " + value);
			}
		}

	}

	public void logElementTree(List<IElementValue> elementValues) {
		Set<String> printedIds = new HashSet<>();

		for (IElementValue elementValue : elementValues) {
			if (elementValue.getParent() == null) {
				logElementTree(elementValue, 0, printedIds);
			}
		}

		// Verify that every element in the original list was printed
		for (IElementValue elementValue : elementValues) {
			String uniqueId = elementValue.getUniqueId();

			if (!printedIds.contains(uniqueId)) {
				logger.trace("NOT PRINTED: " + getSemanticName(elementValue) + " [uniqueId=" + uniqueId + "]");
			}
		}

		logger.trace("Total elements: " + elementValues.size());
		logger.trace("Printed elements: " + printedIds.size());
		logger.trace("All elements printed: " + (printedIds.size() == elementValues.size()));
	}

	private void logElementTree(IElementValue elementValue, int depth, Set<String> printedIds) {

		if (elementValue == null) {
			return;
		}

		String uniqueId = elementValue.getUniqueId();

		// Prevent duplicate printing and infinite recursion
		if (!printedIds.add(uniqueId)) {
			return;
		}

		String indent = "  ".repeat(depth);

		logger.trace(indent + getSemanticName(elementValue) + " [uniqueId=" + uniqueId + "]");

		if (elementValue.getChildren() != null) {
			for (IElementValue child : elementValue.getChildren()) {
				logElementTree(child, depth + 1, printedIds);
			}
		}
	}

	private String getSemanticName(IElementValue elementValue) {
		return elementValue.getSemanticElement() != null
				? elementValue.getSemanticElement().getName()
				: "null";
	}

}
