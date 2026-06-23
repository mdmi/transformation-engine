/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.mdmi.SemanticElement;

/**
 * Collection of all message element instances in a message, grouped by semantic element.
 */
public final class ElementValueSet {

	List<IElementValue> theSetOfAll = new LinkedList<>();

	private LinkedHashMap<String, List<IElementValue>> m_xelements = new LinkedHashMap<>();

	/**
	 * Get all the element values in this element values set.
	 *
	 * @return All the element values in this element values set.
	 */
	public List<IElementValue> getAllElementValues() {
		return theSetOfAll;
	}

	/**
	 * Get all element values of the specified type (for the given semantic element) from this set.
	 *
	 * @param semanticElement
	 *            The semantic element to look for.
	 * @return The sub-set of all element values of the specified type.
	 */
	public List<IElementValue> getElementValuesByType(SemanticElement semanticElement) {
		if (semanticElement == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		return getElementValuesByName(semanticElement);
	}

	/**
	 * Get all element values of the specified type (for the given semantic element) from this set,
	 * which are children or descendants of the given element value.
	 *
	 * @param semanticElement
	 *            The semantic element to look for.
	 * @param thiz
	 *            The element value at whose descendants we should look at.
	 * @return The sub-set of all element values of the specified type, which are descendants of thiz.
	 */
	public List<IElementValue> getChildElementValuesByType(SemanticElement semanticElement, IElementValue thiz) {
		if (semanticElement == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		List<IElementValue> values = new LinkedList<>();
		processChildren(semanticElement, thiz, values);
		return values;
	}

	/**
	 * Get all element values of the specified type (for the given semantic element) from this set,
	 * which are direct children of the given element value.
	 *
	 * @param semanticElement
	 *            The semantic element to look for.
	 * @param thiz
	 *            The element value at whose descendants we should look at.
	 * @return The sub-set of all element values of the specified type, which are direct descendants of thiz.
	 */
	public List<IElementValue> getDirectChildValuesByType(SemanticElement semanticElement, IElementValue thiz) {
		if (semanticElement == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		List<IElementValue> values = new LinkedList<>();
		List<IElementValue> children = thiz.getChildren();
		for (IElementValue child : children) {
			if (child.getSemanticElement() == semanticElement) {
				values.add(child);
			}
		}
		return values;
	}

	/**
	 * Get all element values of the specified type (for the given semantic element) from this set,
	 * which are either the owner, or owner's descendants of the given element value.
	 * It will go up the tree and look at all children of all ancestors of thiz.
	 *
	 * @param semanticElement
	 *            The semantic element to look for.
	 * @param thiz
	 *            The element value at whose owner and ancestors we should look at.
	 * @return The sub-set of all element values of the specified type, which are ancestors or ancestors children of thiz.
	 */
	public LinkedList<IElementValue> getOwnerElementValuesByType(SemanticElement semanticElement, IElementValue thiz) {
		if (semanticElement == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		LinkedList<IElementValue> values = new LinkedList<>();
		IElementValue owner = thiz.getParent();
		if (owner != null) {
			processOwner(semanticElement, owner, values, thiz);
		}
		return values;
	}

	public boolean hasElementValuesByName(SemanticElement semanticElementName) {
		return m_xelements.containsKey(semanticElementName.getUniqueId());
	}

	/**
	 * Get all element values of the specified type (for the given semantic element name) from this set.
	 *
	 * @param semanticElementName
	 *            The semantic element name to look for.
	 * @return The sub-set of all element values of the specified type.
	 */
	public List<IElementValue> getElementValuesByName(SemanticElement semanticElementName) {

		if (!m_xelements.containsKey(semanticElementName.getUniqueId())) {
			m_xelements.put(semanticElementName.getUniqueId(), new LinkedList<IElementValue>());
			for (IElementValue avalue : this.theSetOfAll) {
				if (avalue.getSemanticElement() != null &&
						semanticElementName.getUniqueId().equals(avalue.getSemanticElement().getUniqueId())) {
					m_xelements.get(semanticElementName.getUniqueId()).add(avalue);
				}

			}

		}

		return m_xelements.get(semanticElementName.getUniqueId());
	}

	/**
	 * Add the given element value to the set.
	 *
	 * @param xelement
	 *            The element value to add.
	 */
	public void addElementValue(IElementValue xelement) {

		theSetOfAll.add(xelement);
		if (xelement.getSemanticElement() != null &&
				!StringUtils.isEmpty(xelement.getSemanticElement().getUniqueId())) {
			if (!m_xelements.containsKey(xelement.getSemanticElement().getUniqueId())) {
				m_xelements.put(xelement.getSemanticElement().getUniqueId(), new LinkedList<IElementValue>());
			}
			m_xelements.get(xelement.getSemanticElement().getUniqueId()).add(xelement);
		}

	}

	public void pushElementValue(IElementValue xelement) {
		if (xelement.getSemanticElement() != null &&
				!StringUtils.isEmpty(xelement.getSemanticElement().getUniqueId())) {
			if (!m_xelements.containsKey(xelement.getSemanticElement().getUniqueId())) {
				m_xelements.put(xelement.getSemanticElement().getUniqueId(), new LinkedList<IElementValue>());
			}
			m_xelements.get(xelement.getSemanticElement().getUniqueId()).add(xelement);
		}

	}

	public void removeElementValue(IElementValue xelement) {
		for (IElementValue child : xelement.getChildren()) {
			this.removeElementValue(child);
		}

		this.theSetOfAll.remove(xelement);

	}

	/**
	 * Add the given element values to this set.
	 *
	 * @param xelements
	 *            The element values to add.
	 */
	public void addElementValues(LinkedList<IElementValue> xelements) {
		for (IElementValue xelement : xelements) {
			addElementValue(xelement);
		}
	}

	private void processChildren(SemanticElement semanticElement, IElementValue thiz, List<IElementValue> values) {
		List<IElementValue> children = thiz.getChildren();
		for (IElementValue child : children) {
			if (child.getSemanticElement() == semanticElement) {
				values.add(child);
			}
		}
		for (IElementValue child : children) {
			if (child.getSemanticElement() != semanticElement) {
				processChildren(semanticElement, child, values);
			}
		}
	}

	private void processOwner(SemanticElement semanticElement, IElementValue owner, LinkedList<IElementValue> values,
			IElementValue thiz) {
		List<IElementValue> children = owner.getChildren();
		for (IElementValue child : children) {
			if (!child.equals(thiz) && child.getSemanticElement() == semanticElement) {
				values.add(child);
			}
		}
		for (IElementValue child : children) {
			if (!child.equals(thiz) && child.getSemanticElement() != semanticElement) {
				processChildren(semanticElement, child, values);
			}
		}
		IElementValue parent = owner.getParent();
		if (parent != null) {
			processOwner(semanticElement, parent, values, owner);
		}
	}

	/**
	 * @param tobedeleted
	 */
	public void removeElementValue(ArrayList<IElementValue> tobedeleted) {

		theSetOfAll.removeAll(tobedeleted);

	}
}
