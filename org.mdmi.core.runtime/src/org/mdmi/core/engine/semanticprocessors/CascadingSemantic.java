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
import java.util.Map;

import org.mdmi.Field;
import org.mdmi.SemanticElement;
import org.mdmi.core.ElementValueSet;
import org.mdmi.core.IElementValue;
import org.mdmi.core.engine.XElementValue;
import org.mdmi.core.engine.XValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author seanmuir
 *
 */
public class CascadingSemantic extends ConfigurableSemanticProcessor {

	public CascadingSemantic() {
		super();
	}

	private static Logger logger = LoggerFactory.getLogger(CascadingSemantic.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#getName()
	 */
	@Override
	public String getName() {
		return "CascadingSemantic";
	}

	@Override
	public void setArguments(Object arguments) {
		Map map = (Map) arguments;

	}

	void collectMapTarget(String target) {

	}

	void cascade(IElementValue semanticElement, IElementValue cascadingValue, String target) {

		String businessElementName = "NONE";

		for (IElementValue childSemanticElement : semanticElement.getChildren()) {
			cascade(childSemanticElement, cascadingValue, target);
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#processSemanticModel(org.mdmi.core.ElementValueSet)
	 */
	@Override
	public void processSemanticModel(ElementValueSet elementValueSet) {

		XElementValue cascadeSource = null;
		ArrayList<XElementValue> cascadetargets = new ArrayList<>();
		XElementValue cascadeParent = null;
		XElementValue idvalue = null;
		XElementValue typevalue = null;
		SemanticElement targetsemantic = null;
		for (IElementValue elementValue : elementValueSet.getAllElementValues()) {
			if ("AuthorCascading".equals(elementValue.getSemanticElement().getName())) {
				cascadeParent = (XElementValue) elementValue;
			}

			if ("AssignedAuthorCascading".equals(elementValue.getSemanticElement().getName())) {
				cascadeSource = (XElementValue) elementValue;
			}

			if ("AllergyConcernAct2".equals(elementValue.getSemanticElement().getName())) {
				cascadetargets.add((XElementValue) elementValue);
			}

			if ("Id9Cascading".equals(elementValue.getSemanticElement().getName())) {
				idvalue = (XElementValue) elementValue;
			}

			if ("Type2345Cascading".equals(elementValue.getSemanticElement().getName())) {
				typevalue = (XElementValue) elementValue;
			}

		}

		for (IElementValue cascadetarget : cascadetargets) {

			boolean process = true;
			for (IElementValue checkFor : cascadetarget.getChildren()) {

				if ("AuthorCascadingTarget".equals(checkFor.getSemanticElement().getName())) {
					process = false;
				}

			}
			if (process && cascadeSource != null && cascadetarget != null) {

				for (SemanticElement foo : cascadeSource.getSemanticElement().getElementSet().getSemanticElements()) {
					if ("AuthorCascadingTarget".equals(foo.getName())) {
						targetsemantic = foo;
						XElementValue t = new XElementValue(targetsemantic, elementValueSet);
						cascadetarget.addChild(t);
						cascadetarget = t;
					}
				}

				for (SemanticElement foo : cascadeSource.getSemanticElement().getElementSet().getSemanticElements()) {
					if ("Id46CascadingTarget".equals(foo.getName())) {
						targetsemantic = foo;
						XElementValue t = new XElementValue(targetsemantic, elementValueSet);
						if (idvalue != null) {

							XValue whatisthis = idvalue.getXValue();

							for (Field f : whatisthis.getDatatype().getFields()) {
								t.getXValue().addValue(f.getName(), idvalue.getXValue().getValueByName(f.getName()));

							}

						}

						cascadetarget.addChild(t);
					}
				}

				for (SemanticElement foo : cascadeSource.getSemanticElement().getElementSet().getSemanticElements()) {
					if ("Type2345128401CascadingTarget".equals(foo.getName())) {
						targetsemantic = foo;
						XElementValue t = new XElementValue(targetsemantic, elementValueSet);
						if (typevalue != null) {
							XValue whatisthis = typevalue.getXValue();
							for (Field f : whatisthis.getDatatype().getFields()) {
								t.getXValue().addValue(f.getName(), typevalue.getXValue().getValueByName(f.getName()));
							}
						}
						cascadetarget.addChild(t);
					}
				}

			}
		}
		if (cascadeParent != null)

		{

			elementValueSet.removeElementValue(cascadeParent);

			cascadeParent.getParent().removeChild(cascadeParent);
		}

	}

}
