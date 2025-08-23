/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.semanticprocessors;

import java.util.List;

import org.mdmi.MessageModel;
import org.mdmi.SemanticElementRelationship;
import org.mdmi.core.ElementValueSet;
import org.mdmi.core.IElementValue;

/**
 * @author seanmuir
 *
 */
public class ProcessRelationships implements ISemanticProcessor {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#getName()
	 */
	@Override
	public String getName() {
		return "ProcessRelationships";
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

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#processSemanticModel(org.mdmi.core.ElementValueSet)
	 */
	@Override
	public void processSemanticModel(ElementValueSet semanticModel) {
		for (IElementValue element : semanticModel.getAllElementValues()) {
			if (!element.getSemanticElement().getRelationships().isEmpty()) {

				for (SemanticElementRelationship r : element.getSemanticElement().getRelationships()) {

					List<IElementValue> relatedElements = semanticModel.getElementValuesByName(
						r.getRelatedSemanticElement());

					for (IElementValue relatedElement : relatedElements) {
						for (IElementValue correctParent : relatedElement.getParent().getChildren()) {
							if (correctParent.getName().equals(element.getName())) {
								relatedElement.setParent(correctParent);
								correctParent.addChild(relatedElement);

							}

						}

					}

				}

			}
		}

	}

}
