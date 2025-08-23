/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import org.mdmi.DTCChoice;
import org.mdmi.Field;
import org.mdmi.core.MdmiException;

/**
 * An instance of a DTCChoice data type - a choice with at most one chosen field value.
 *
 * @author goancea
 */
public class XDataChoice extends XData {
	private XValue m_value;

	/**
	 * Construct one from its owner and data type.
	 *
	 * @param owner
	 *            The owner value.
	 * @param datatype
	 *            The data type.
	 */
	public XDataChoice(XValue owner) {
		super(owner, owner.getDatatype());
	}

	/**
	 * Internal constructor use when cloning a value.
	 *
	 * @param owner
	 *            The new owner value.
	 * @param src
	 *            The source for the field value.
	 */
	XDataChoice(XValue owner, XDataChoice src) {
		super(owner, src.m_datatype);
		if (src.m_value != null) {
			m_value = src.m_value.clone(true);
		}
	}

	/**
	 * Initialize a struct of choice field with the defaults.
	 *
	 * @return The XValue initialized.
	 */
	public XValue initializeField() {
		m_value.intializeStructs();
		return m_value;
	}

	/**
	 * Get the chosen field value.
	 *
	 * @return The chosen field value.
	 */
	public XValue getXValue() {
		return m_value;
	}

	/**
	 * Get the chosen field name.
	 *
	 * @return The chosen field name.
	 */
	public String getChoiceName() {
		return m_value != null
				? m_value.getName()
				: "";
	}

	/**
	 * Return true if the data type has the specified field (it can be a choice).
	 *
	 * @param fieldName
	 *            the field name to look for.
	 * @return True if the choice data type has this field.
	 */
	public boolean hasChoice(String fieldName) {
		if (fieldName == null) {
			throw new IllegalArgumentException("Null field!");
		}
		DTCChoice cdt = (DTCChoice) m_datatype;
		return null != cdt.getField(fieldName);
	}

	/**
	 * Set the chosen value.
	 *
	 * @param fieldName
	 *            The field name, must be one of the data type fields.
	 * @return The set value reference.
	 */
	public XValue setXValue(String fieldName) {
		if (fieldName == null) {
			throw new IllegalArgumentException("Null field!");
		}
		DTCChoice cdt = (DTCChoice) m_datatype;
		Field field = cdt.getField(fieldName);
		if (field == null) {
			throw new MdmiException("Invalid field {0} in choice {1}", fieldName, m_datatype.getName());
		}
		m_value = new XValue(this, field);
		return m_value;
	}

	/**
	 * Set the value to the given value. The field name must be one of the data type fields.
	 *
	 * @param value
	 *            The new value.
	 */
	public void setXValue(XValue value) {
		DTCChoice cdt = (DTCChoice) m_datatype;
		Field field = cdt.getField(value.getName());
		if (field == null) {
			throw new MdmiException("Invalid field {0} in choice {1}", value.getName(), m_datatype.getName());
		}
		m_value = value;
	}

	/**
	 * Set the choice value to the given field, and set its value to the given value.
	 *
	 * @param fieldName
	 *            The name of the field to set as choosen.
	 * @param value
	 *            The value to set it to.
	 */
	public void setValue(String fieldName, Object value) {
		if (fieldName == null) {
			throw new IllegalArgumentException("Null field!");
		}
		DTCChoice cdt = (DTCChoice) m_datatype;
		Field field = cdt.getField(fieldName);
		if (field == null) {
			throw new MdmiException("Invalid field " + fieldName + " in choice " + cdt.getName());
		}
		m_value = new XValue(field, value);
	}

	/**
	 * Get the value of the selected field.
	 *
	 * @return The value of the field.
	 */
	public Object getValue() {
		if (m_value == null) {
			return null; // not set
		}
		return m_value.getValue();
	}

	/**
	 * Clear the chosen value.
	 */
	public void clearValue() {
		m_value = null;
	}

	// @Override
	// protected String toString(String indent) {
	// XValue v = m_value;
	// StringBuffer sb = new StringBuffer();
	// if (v != null) {
	// sb.append(v.toString(indent));
	// } else {
	// sb.append("NULL");
	// }
	//
	// sb.append("\r\n");
	// return sb.toString();
	// }

	@Override
	public boolean isEmpty() {
		return m_value == null || m_value.isEmpty();
	}

	public boolean isNullOrEmpty() {
		return m_value == null || m_value.isNullOrEmpty();
	}
} // XDataChoice
