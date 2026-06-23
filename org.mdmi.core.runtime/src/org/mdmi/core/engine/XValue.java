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
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.mdmi.Field;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MDMIDatatype;
import org.mdmi.SemanticElement;
import org.mdmi.core.IElementValue;
import org.mdmi.core.IValue;

/**
 * A semantic value (a field). It has a name, datatype and the actual value or
 * values. It may be owned by an element value, or by one of the structured
 * semantic type (XDataStruct or XDataChoice).
 *
 * @author goancea
 */
public final class XValue implements IValue {

	private String m_name;

	private MDMIDatatype m_datatype;

	private LinkedList<Object> m_values = new LinkedList<>();

	/**
	 * Construct one as the main value of an element value,
	 *
	 * @param owner
	 *            The element owner, may not be null.
	 */
	public XValue(IElementValue owner) {
		if (owner == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		initialize(SemanticElement.VALUE_NAME, owner.getSemanticElement().getDatatype());
	}

	/**
	 * Construct one as a field in a structure or choice.
	 *
	 * @param owner
	 *            The owner structure or choice.
	 * @param field
	 *            The field this is an instance of.
	 */
	public XValue(XData owner, Field field) {
		if (owner == null || field == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		initialize(field.getName(), field.getDatatype());
	}

	/**
	 * Construct a standalone one, no owner.
	 *
	 * @param name
	 *            The value name.
	 * @param datatype
	 *            The value data type.
	 */
	public XValue(String name, MDMIDatatype datatype) {
		if (name == null || datatype == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		initialize(name, datatype);
		intializeStructs();
	}

	public XValue(MDMIDatatype datatype) {
		this.m_datatype = datatype;
		intializeStructs();
	}

	public XValue(Field field, Object value) {
		if (field == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		initialize(field.getName(), field.getDatatype());
		setValue(value);
	}

	/**
	 * Initialize the value with a name and a type.
	 *
	 * @param name
	 *            The value name.
	 * @param datatype
	 *            The value data type.
	 */
	private void initialize(String name, MDMIDatatype datatype) {
		m_name = name;
		m_datatype = datatype;
	}

	public Object getNewByName(String field) {

		if (m_values.isEmpty()) {
			this.intializeStructs();
		}
		XValue o = null;
		XDataStruct p = null;
		for (Object v : m_values) {
			if (v instanceof XDataStruct) {

				XDataStruct xds = (XDataStruct) v;

				for (Field f : xds.getDatatype().getFields()) {
					if (f.getName().equals(field)) {
						if (f.getDatatype().isComplex()) {
							o = new XValue(f.getDatatype());
							p = new XDataStruct(o);
							xds.setValue(f.getName(), p);
						} else {
							o = new XValue(field, f.getDatatype());
							xds.setValue(f.getName(), o);
						}

					}

				}

			}
		}

		return p;

	}

	public void foobar() {
		intializeStructs();

		for (Object v : m_values) {
			if (v instanceof XDataStruct) {
				XDataStruct xds = (XDataStruct) v;

				for (Field f : xds.getDatatype().getFields()) {
					if (f.getDatatype().isComplex()) {
						xds.setValue(f.getName(), new XValue(m_datatype));
					}

				}
			}

		}
	}

	/**
	 * For stand alone values we add the fields, if the type is a structure or
	 * choice.
	 */
	public void intializeStructs() {

		if (m_datatype == null) {
			return;
		}
		if (m_datatype.isStruct()) {
			XDataStruct t = new XDataStruct(this, true);
			m_values.add(t);
		} else if (m_datatype.isChoice()) {
			XDataChoice t = new XDataChoice(this);
			m_values.add(t);
		} else if (m_datatype.isSimple()) {

		}
	}

	/**
	 * Private copy ctor.
	 *
	 * @param src
	 *            The source value.
	 * @param deep
	 *            If deep is true, it will clone all child values, otherwise just
	 *            the references.
	 */
	private XValue(XValue src, boolean deep) {
		m_name = src.m_name;
		m_datatype = src.m_datatype;
		m_values = new LinkedList<>();

		if (src.m_values.size() <= 0) {
			return;
		}

		if (!deep || getDatatype().isSimple()) {
			for (int i = 0; i < src.m_values.size(); i++) {
				m_values.add(src.m_values.get(i));
			}
		} else {
			for (int i = 0; i < src.m_values.size(); i++) {
				if (getDatatype().isChoice()) {
					XDataChoice x = (XDataChoice) src.m_values.get(i);
					XDataChoice c = new XDataChoice(this, x);
					m_values.add(c);
				} else {
					XDataStruct x = (XDataStruct) src.m_values.get(i);
					XDataStruct c = new XDataStruct(this, x);
					m_values.add(c);
				}
			}
		}
	}

	/**
	 * @param name
	 * @param referenceDatatype
	 */
	public XValue(MDMIBusinessElementReference name, MDMIDatatype referenceDatatype) {
	}

	/**
	 * Clone this value, optionally its child values as well (if deep is true).
	 *
	 * @param deep
	 *            If deep is true, it will clone all child values, otherwise just
	 *            the references.
	 * @return The cloned value.
	 */
	public XValue clone(boolean deep) {
		return new XValue(this, deep);
	}

	@Override
	public void cloneValues(IValue src) {
		m_values.clear();
		List<Object> srcValues = src.getValues();
		for (int i = 0; i < srcValues.size(); i++) {
			m_values.add(srcValues.get(i));
		}
	}

	@Override
	public MDMIDatatype getDatatype() {
		return m_datatype;
	}

	@Override
	public String getName() {
		return m_name;
	}

	@Override
	public void setName(String name) {
		m_name = name;
	}

	@Override
	public int size() {
		return m_values.size();
	}

	public XDataStruct getXDataStruct() {
		return (XDataStruct) (m_values.size() <= 0
				? null
				: getValue(0));
	}

	@Override
	public Object getValue() {
		return m_values.size() <= 0
				? null
				: getValue(0);
	}

	@Override
	public Object getValue(int index) {
		if (m_values.isEmpty()) {
			return null;
		}
		return m_values.get(index);
	}

	public Object getValueByName(String name) {

		if (!m_values.isEmpty()) {
			if (m_values.get(0) instanceof XDataStruct) {
				XDataStruct xds = (XDataStruct) m_values.get(0);

				return xds.getValue(name);

			} else {
				return this.getValue();
			}
		}

		return null;

	}

	@Override
	public List<Object> getValues() {
		return m_values;
	}

	@Override
	public int getIndexOf(Object value) {
		for (int i = 0; i < m_values.size(); i++) {
			Object o = m_values.get(i);
			if (o == value) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void setValue(Object value) {
		setValue(value, 0);
	}

	public boolean isNullOrEmpty() {
		if (m_values.size() <= 0) {
			return true;
		}
		boolean hasValue = false;
		for (Object v : m_values) {
			if (v instanceof XDataStruct) {
				XDataStruct x = (XDataStruct) v;
				if (!x.isNullOrEmpty()) {
					hasValue = true;
				}
			} else if (v instanceof XDataChoice) {
				XDataChoice x = (XDataChoice) v;
				if (!x.isNullOrEmpty()) {
					hasValue = true;
				}
			} else {
				hasValue = true;
			}
		}
		return !hasValue;
	}

	@Override
	public boolean isEmpty() {
		return m_values.isEmpty();
	}

	@Override
	public void setValue(Object value, int index) {
		if (index < 0 || index >= m_values.size()) {
			m_values.add(value);
		} else {
			m_values.set(index, value);
		}
	}

	@Override
	public void addValue(String field, Object value) {
		if (this.m_values.isEmpty()) {
			this.intializeStructs();
		}
		for (Object object : m_values) {
			if (object instanceof XDataStruct) {
				XDataStruct xds = (XDataStruct) object;

				xds.setValue(field, value);

			}
		}
	}

	public void addValue(String field, Object value, int index) {
		if (this.m_values.isEmpty()) {
			this.intializeStructs();
		}
		for (Object object : m_values) {
			if (object instanceof XDataStruct) {
				XDataStruct xds = (XDataStruct) object;

				xds.setValue(field, value, index);

			}
		}
	}

	public void addValueHack(String field) {
		if (this.m_values.isEmpty()) {
			this.intializeStructs();
		}
		for (Object object : m_values) {
			if (object instanceof XDataStruct) {
				XDataStruct xds = (XDataStruct) object;
				Object value = null;
				xds.setValue(field, value);
			}
		}
	}

	@Override
	public void addValue(Object value) {
		addValue(value, -1);
	}

	@Override
	public void addValue(Object value, int index) {
		if (index < 0 || index >= m_values.size()) {
			m_values.add(value);
		} else {
			m_values.add(index, value);
		}
	}

	@Override
	public void removeValue(Object value) {
		if (value == null) {
			return;
		}
		int index = m_values.indexOf(value);
		if (index >= 0) {
			m_values.remove(index);
		}
	}

	@Override
	public void clear() {
		m_values.clear();
	}

	@Override
	public void removeValue(int index) {
		m_values.remove(index);
	}

	/**
	 * @param p
	 */
	public void push(String p) {

	}

	/**
	 * @param string
	 * @param value
	 */
	public void addValues(String string, Object value) {

	}

	/**
	 * @param o
	 */
	public void addValue2(Object o) {
		this.m_values.add(o);

	}

	/**
	 * @param values
	 *
	 */
	public void addValues(String fieldName, Collection values) {

		for (Object v : values) {
			XValue xxx = new XValue(m_datatype);
			XDataStruct xv = new XDataStruct(xxx);
			xv.setValue(fieldName, v);
			this.m_values.add(xv);
		}

	}

	/**
	 * appendValue is a bit of a workaround to support semantic rollup to a string and support correct ordering
	 * The semantic relationship which the semantic roll up leverages does not have an order element so the java script is used to set the order
	 * cache the values in a m_temp so we can maintain order then set the value in the original m_values index of 0
	 * THIS IS ONLY FOR STRING ELEMENTS
	 */

	private ArrayList<String> m_temp = new ArrayList<>(10);

	public void appendValue(int order, Object value) {

		if (m_temp.isEmpty()) {
			for (int i = 1; i < 10; i++) {
				m_temp.add("");
			}
		}
		m_temp.set(order, (String) value);
		if (m_values.isEmpty()) {
			m_values.add(String.join("", m_temp));
		} else {
			m_values.set(0, (String.join("", m_temp)));
		}
	}
} // XValue
