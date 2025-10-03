/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.semanticprocessors;

import org.mdmi.SemanticElement;
import org.mdmi.core.ElementValueSet;
import org.mdmi.core.IElementValue;
import org.mdmi.core.engine.XValue;

/**
 * Processes semantic models for normalization.
 */
public class Normalizer2 extends ConfigurableSemanticProcessor {

	/**
	 * Processes the semantic model by normalizing relationships.
	 *
	 * @param elementSet
	 *            the set of element values to process
	 */
	@Override
	public void processSemanticModel(ElementValueSet elementSet) {

		IElementValue rootElement = null;
		for (IElementValue element : elementSet.getAllElementValues()) {
			if (element.getParent() == null) {
				rootElement = element;
			}
		}

		for (IElementValue element : elementSet.getAllElementValues()) {
			SemanticElement se = element.getSemanticElement();

			if (se.getRelationshipByName("NORMALIZE2") != null) {

				element.getParent().removeChild(element);
				rootElement.addChild(element);
				element.setParent(rootElement);

				// String refValue = extractReferenceValue(semanticElement);
				// SemanticElement parent = se.getRelationshipByName("NORMALIZE").getRelatedSemanticElement();
				//
				// for (IElementValue parentValue : elementSet.getElementValuesByName(parent)) {
				// String idValue = extractIdValue(parent, parentValue);
				//
				// if (refValue.equals(idValue) && parentValue.getChildren() != null) {
				// for (IElementValue child : parentValue.getChildren()) {
				// semanticElement.addChild(child);
				// }
				// }
				// }
			}
		}

	}

	/**
	 * Extracts the reference value from a semantic element.
	 *
	 * @param semanticElement
	 *            the semantic element to process
	 * @return the extracted reference value
	 */
	private String extractReferenceValue(IElementValue semanticElement) {
		String refValue = "";

		if (semanticElement.getChildren() != null) {
			for (IElementValue child : semanticElement.getChildren()) {
				if (child.getSemanticElement().getSyntaxNode() != null &&
						"reference".equals(child.getSemanticElement().getSyntaxNode().getLocation())) {

					XValue xvalue = (XValue) child.getXValue();
					refValue = (String) xvalue.getValueByName("value");
					refValue = refValue.substring(refValue.lastIndexOf('/') + 1);
				}
			}
		} else {
			XValue xvalue = (XValue) semanticElement.getXValue();
			refValue = (String) xvalue.getValueByName("value");
		}

		return refValue;
	}

	/**
	 * Extracts the ID value from a parent semantic element.
	 *
	 * @param parent
	 *            the parent semantic element
	 * @param parentValue
	 *            the value of the parent element
	 * @return the extracted ID value
	 */
	private String extractIdValue(SemanticElement parent, IElementValue parentValue) {
		String idValue = "";

		if ("Container".equals(parent.getDatatype().getName())) {
			for (IElementValue id : parentValue.getChildren()) {
				if (id.getSemanticElement().getSyntaxNode() != null &&
						"id".equals(id.getSemanticElement().getSyntaxNode().getLocation())) {

					XValue xvalue = (XValue) id.getXValue();
					idValue = (String) xvalue.getValueByName("value");
					break;
				}
			}
		}

		return idValue;
	}
}
