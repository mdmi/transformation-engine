/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.mdmi.SemanticElement;
import org.mdmi.core.ElementValueSet;
import org.mdmi.core.IElementValue;

/**
 * An instance of this class is the value of a semantic element.
 *
 * @author goancea
 */
public class XElementValue implements IElementValue {
	private SemanticElement m_semanticElement;

	private XElementValue m_parent;

	private List<XElementValue> m_children;

	private List<RelElement> m_relations;

	private XValue m_xvalue;

	private ElementValueSet m_owner;

	String uniqueID = "";

	public void zap() {
		for (XElementValue c : m_children) {
			c.zap();
		}

		while (!m_children.isEmpty()) {
			for (XElementValue c : m_children) {
				// c.zap();
				m_owner.removeElementValue(c);
			}
		}

		m_owner.removeElementValue(this);
		m_owner = null;
		m_parent = null;
		m_xvalue = null;

	}

	public static class RelElement {
		public String name;

		public XElementValue relatedElement;

		public RelElement(String name, XElementValue relatedElement) {
			this.name = name;
			this.relatedElement = relatedElement;
		}
	}

	/**
	 * Construct one from the SemanticElement model instance and its owner set.
	 *
	 * @param semanticElement
	 *            The SemanticElement model for this value.
	 * @param eset
	 *            The owner element values set.
	 */
	public XElementValue(SemanticElement semanticElement, ElementValueSet eset) {
		if (semanticElement == null) {
			throw new IllegalArgumentException("Null argument!");
		}

		m_semanticElement = semanticElement;
		m_children = new LinkedList<>();
		m_relations = new ArrayList<>();
		m_xvalue = new XValue(this);
		m_owner = eset;
		m_owner.addElementValue(this);
	}

	// a private clone
	private XElementValue(XElementValue src, boolean deep) {
		m_semanticElement = src.m_semanticElement;
		if (deep) {
			m_children = new LinkedList<>();
			for (int i = 0; i < src.m_children.size(); i++) {
				XElementValue e = src.m_children.get(i);
				m_children.add(e.clone(true));
			}
			m_relations = new ArrayList<>();
			for (int i = 0; i < src.m_relations.size(); i++) {
				RelElement e = src.m_relations.get(i);
				RelElement t = new RelElement(e.name, e.relatedElement.clone(true));
				m_relations.add(t);
			}
			m_xvalue = src.m_xvalue.clone(true);
		} else {
			m_children = src.m_children;
			m_relations = src.m_relations;
			m_xvalue = src.m_xvalue;
		}
		m_owner = src.m_owner;
		m_owner.addElementValue(this);
	}

	/**
	 * @param iterator
	 * @param elementValueSet
	 * @param current
	 */
	public XElementValue(SemanticElement semanticElement, ElementValueSet elementValueSet,
			ListIterator<IElementValue> iterator) {
		if (semanticElement == null) {
			throw new IllegalArgumentException("Null argument!");
		}

		m_semanticElement = semanticElement;
		m_children = new LinkedList<>();
		m_relations = new ArrayList<>();
		m_xvalue = new XValue(this);
		m_owner = elementValueSet;
		iterator.add(this);
		elementValueSet.pushElementValue(this);
	}

	/**
	 * Clone this, optionally deep (meaning clone the referenced data constructs as well).
	 * A deep clone can be modified in any way without affecting the source.
	 *
	 * @param deep
	 *            If true a deep clone is requested.
	 * @return The newly created clone.
	 */
	public XElementValue clone(boolean deep) {
		return new XElementValue(this, deep);
	}

	@Override
	public SemanticElement getSemanticElement() {
		return m_semanticElement;
	}

	@Override
	public String getName() {
		return m_semanticElement.getName();
	}

	@Override
	public IElementValue getParent() {
		return m_parent;
	}

	@Override
	public void setParent(IElementValue parent) {
		m_parent = null == parent
				? null
				: (XElementValue) parent;
	}

	@Override
	/**
	 * @TODO This seems unneccesary
	 */
	public List<IElementValue> getChildren() {
		List<IElementValue> a = new LinkedList<>();
		for (XElementValue e : m_children) {
			a.add(e);
		}
		return a;
	}

	@Override
	public int getChildCount() {
		return m_children.size();
	}

	@Override
	public void addChild(IElementValue child) {
		m_children.add((XElementValue) child);
		child.setParent(this);
	}

	public void addChildExtended(IElementValue child) {

		for (SemanticElement ase : this.getSemanticElement().getChildren()) {

			if (ase.getName().equals(child.getSemanticElement().getName())) {
				m_children.add((XElementValue) child);
				child.setParent(this);
				return;
			}
		}

		for (SemanticElement ase : this.getSemanticElement().getChildren()) {
			for (SemanticElement ase2 : ase.getChildren()) {
				if (ase2.getName().equals(child.getSemanticElement().getName())) {
					XElementValue targetElementValue = new XElementValue(ase, this.m_owner);
					m_children.add(targetElementValue);
					targetElementValue.setParent(this);
					targetElementValue.addChild(child);
					child.setParent(targetElementValue);
					return;
				}
			}

		}

	}

	@Override
	public void removeChild(IElementValue child) {
		m_children.remove(child);
		// child.setParent(this);
	}

	@Override
	public List<IElementValue> getRelations() {
		List<IElementValue> a = new ArrayList<>();
		for (RelElement e : m_relations) {
			a.add(e.relatedElement);
		}
		return a;
	}

	// public void removeChild(IElementValue child) {
	// m_children.remove(child);
	// child.setParent(null);
	// }

	public void addRelation(String name, IElementValue relation) {
		m_relations.add(new RelElement(name, (XElementValue) relation));
	}

	public XElementValue getRelation(String name) {
		for (RelElement re : m_relations) {
			if (re.name.equalsIgnoreCase(name)) {
				return re.relatedElement;
			}
		}
		return null;
	}

	@Override
	public Object value() {
		return m_xvalue.getValue();
	}

	@Override
	public XValue getXValue() {
		return m_xvalue;
	}

	public void setValue(Object value) {
		m_xvalue.setValue(value);
	}

	@Override
	public boolean isSimple() {
		return m_semanticElement.getDatatype().isSimple();
	}

	@Override
	public ElementValueSet getOwner() {
		return m_owner;
	}

	// @Override
	// public String toString() {
	// return toString("");
	// }

	String toStringShort() {
		if (m_xvalue.size() <= 0) {
			return "null";
		} else if (m_xvalue.getDatatype().isStruct()) {
			return "struct...";
		} else if (m_xvalue.getDatatype().isChoice()) {
			return "choice...";
		}
		return m_xvalue.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.IElementValue#getUniqueId()
	 */
	@Override
	public String getUniqueId() {
		if (StringUtils.isEmpty(uniqueID)) {
			uniqueID = UUID.randomUUID().toString();
		}
		// TODO Auto-generated method stub
		return uniqueID;
	}

	// String toString(String indent) {
	// StringBuffer sb = new StringBuffer();
	// sb.append(indent);
	// if (indent.length() <= 0) {
	// sb.append("SemanticElement: ");
	// }
	// sb.append(getName());
	// sb.append("\r\n");
	// indent += " ";
	// if (m_parent != null) {
	// sb.append(indent + "parent: " + m_parent.getName() + " [" + m_parent.toStringShort() + "]\r\n");
	// }
	// if (m_children.size() > 0) {
	// sb.append(indent + "children:\r\n");
	// for (int i = 0; i < m_children.size(); i++) {
	// XElementValue xe = m_children.get(i);
	// sb.append(indent + " " + xe.getName() + " [" + xe.toStringShort() + "]\r\n");
	// }
	// }
	// if (m_relations.size() > 0) {
	// sb.append(indent + "relations:\r\n");
	// for (int i = 0; i < m_relations.size(); i++) {
	// RelElement re = m_relations.get(i);
	// sb.append(indent + " " + re.name + " [" + re.relatedElement.toStringShort() + "]\r\n");
	// }
	// }
	// sb.append(m_xvalue.toString(indent));
	// sb.append("\r\n");
	// return sb.toString();
	// }
} // XElementValue
