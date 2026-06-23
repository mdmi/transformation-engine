/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import java.util.LinkedList;
import java.util.List;

import org.mdmi.SemanticElement;
import org.mdmi.core.ElementValueSet;
import org.mdmi.core.IElementValue;

/**
 * Structured view of the element value set, grouped by semantic elements and in tree form.
 *
 * @author goancea
 */
final class XElementValues {
	public List<XES> elementValues = new LinkedList<>();

	/**
	 * Construct one from an element values set.
	 *
	 * @param eset
	 *            The element value set to useas source.
	 */
	public XElementValues(ElementValueSet eset) {
		List<IElementValue> values = eset.getAllElementValues();
		for (IElementValue value : values) {
			XElementValue v = (XElementValue) value;
			if (v.getParent() == null) {
				XE xe = new XE(v);
				XES xes = get(v.getSemanticElement());
				if (xes == null) {
					xes = new XES(v.getSemanticElement());
					elementValues.add(xes);
				}
				xes.elementValues.add(xe);
				elementValues.add(xes);
				addChildren(xe);
			}
		}
	}

	private XES get(SemanticElement se) {
		for (XES xes : elementValues) {
			if (xes.semanticElement == se) {
				return xes;
			}
		}
		return null;
	}

	private void addChildren(XE xe) {
		List<IElementValue> values = xe.elementValue.getChildren();
		for (IElementValue value : values) {
			XElementValue v = (XElementValue) value;
			SemanticElement se = v.getSemanticElement();
			XES xes = xe.get(se);
			if (xes == null) {
				xes = new XES(se);
				xe.children.add(xes);
			}
			XE child = new XE(v);
			xes.elementValues.add(child);
			addChildren(child);
		}
	}

	static class XE {
		public XElementValue elementValue;

		public LinkedList<XES> children = new LinkedList<>();

		public XE(XElementValue elementValue) {
			this.elementValue = elementValue;
		}

		public XES get(SemanticElement se) {
			for (XES c : children) {
				if (c.semanticElement == se) {
					return c;
				}
			}
			return null;
		}

	}

	static class XES {
		public SemanticElement semanticElement;

		public LinkedList<XE> elementValues = new LinkedList<>();

		public XES(SemanticElement semanticElement) {
			this.semanticElement = semanticElement;
		}

	}
} // XElementValues
