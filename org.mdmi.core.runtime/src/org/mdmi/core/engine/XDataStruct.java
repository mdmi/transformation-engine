/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.mdmi.DTCStructured;
import org.mdmi.Field;
import org.mdmi.core.MdmiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An instance of a DTCStructured data type - a structure with some fields.
 *
 * @author goancea
 */
public class XDataStruct extends XData {

	private static Logger logger = LoggerFactory.getLogger(XDataStruct.class);

	private LinkedHashMap<String, XValue> m_values = new LinkedHashMap<>();

	/**
	 * Construct one from its owner value and its data type.
	 *
	 * @param owner
	 *            The owner value.
	 */
	public XDataStruct(XValue owner) {
		super(owner, owner.getDatatype());
		EList<Field> fields = ((DTCStructured) owner.getDatatype()).getFields();
		for (int i = 0; i < fields.size(); i++) {
			XValue v = new XValue(this, fields.get(i));
			m_values.put(v.getName(), v);
		}
	}

	/**
	 * Construct one from its owner value and its data type, and initialize its
	 * fields, optionally recursive. Used only from the XValue when constructing
	 * a stand alone value.
	 *
	 * @param owner
	 *            The owner value.
	 * @param recursive
	 *            If true recursively create nested structs.
	 */
	XDataStruct(XValue owner, boolean recursive) {
		super(owner, owner.getDatatype());
		EList<Field> fields = ((DTCStructured) owner.getDatatype()).getFields();
		for (int i = 0; i < fields.size(); i++) {
			XValue v = new XValue(this, fields.get(i));
			// v.intializeStructs();
			m_values.put(v.getName(), v);
		}
	}

	/**
	 * A copy ctor, but for a different owner. Used when cloning a value.
	 *
	 * @param owner
	 *            The owner value.
	 * @param src
	 *            The source for the cloning.
	 */
	XDataStruct(XValue owner, XDataStruct src) {
		super(owner, src.m_datatype);

		// src.m_values;

		for (String key : src.m_values.keySet()) {
			XValue xv = src.m_values.get(key);
			if (xv != null) {
				m_values.put(xv.getName(), xv.clone(true));
			}
		}

	}

	/**
	 * Initialize a struct of choice field with the defaults.
	 *
	 * @param fieldName
	 *            Name of the field.
	 * @return The XValue initialized.
	 */
	public XValue initializeField(String fieldName) {
		XValue xv = m_values.get(fieldName);
		xv.intializeStructs();
		return xv;
	}

	/**
	 * Get the list of field values, one for each field.
	 *
	 * @return The list of field values, one for each field.
	 */
	public Collection<XValue> getXValues() {
		return m_values.values();
	}

	/**
	 * Get the value of the specified field.
	 *
	 * @param fieldName
	 *            The field.
	 * @return The value, if found, null otherwise.
	 */
	public XValue getXValue(Field field) {
		return getXValue(field.getName());
	}

	/**
	 * Get the value of the specified field.
	 *
	 * @param fieldName
	 *            The field name.
	 * @return The value, if found, null otherwise.
	 */
	public XValue getXValue(String fieldName) {
		if (fieldName == null) {
			throw new IllegalArgumentException("Null 'fieldName'");
		}
		XValue xValue = m_values.get(fieldName);
		return xValue;
	}

	// public XValue getXValueAsString(String fieldName) {
	// if (fieldName == null) {
	// throw new IllegalArgumentException("Null 'fieldName'");
	// }
	// XValue xValue = m_values.get(fieldName);
	//
	// StringBuffer sb = new StringBuffer();
	//
	// for (Object s : xValue.getValues()) {
	// XValue xs = (XValue) s;
	// sb.append(xs.getValue()).append(" ");
	// }
	//
	// return xValue;
	// }

	/**
	 * Set the value for a field, replaces the existing one.
	 *
	 * @param value
	 *            The new value.
	 * @return The index of the field being updated.
	 */
	public void setXValue(XValue value) {
		if (value == null) {
			throw new IllegalArgumentException("Null 'value'");
		}
		m_values.put(value.getName(), value);
	}

	/**
	 * Set the value of the given field to the given value.
	 *
	 * @param fieldName
	 *            The name of the field to set.
	 * @param value
	 *            The value to set it to.
	 */
	public void setValue(String fieldName, Object value) {
		XValue xv = getXValue(fieldName);
		if (xv == null) {
			logger.error("Error in setValue ", new MdmiException("Invalid fieldName: " + fieldName));
		} else {
			xv.addValue(value);
		}
	}

	public void setValue(String fieldName, Object value, int index) {
		XValue xv = getXValue(fieldName);
		if (xv == null) {
			logger.error("Error in setValue ", new MdmiException("Invalid fieldName: " + fieldName));
		} else {
			xv.addValue(value, index);
		}
	}

	/**
	 * setValueSafely will take in a dot "." delimited path and makes sure the underlying structures are created before setting value
	 * This is a little funky based on the current XValue and XDataStructure layout
	 *
	 * @param fieldName
	 * @param value
	 */
	@SuppressWarnings("rawtypes")
	public void setValueSafely(String fieldName, Object value) {

		logger.trace("Setting " + fieldName + " to -->>  " + value);
		String[] segments = fieldName.split("\\.");
		// if length == 1 then we do not have a path so set normally
		if (segments.length == 1) {
			setValue(fieldName, value);
			return;
		}

		// pop the corresponding XValue from current XDataStructure using first segment
		XValue xvalue = m_values.get(segments[0]);
		// If the segments is 2 - need to process slightly differently because we have
		// XValue versus XDataStruct
		if (segments.length == 2) {
			if (value instanceof Collection) {
				Collection values = (Collection) value;
				xvalue.addValues(segments[1], values);
			} else {
				try {
					xvalue.addValue(segments[1], value);
				} catch (NullPointerException npe) {

				}
			}

			return;
		}
		// Start our journey down the segments by getting the corresponding XDataStructure from the XValue
		// creating a new one if there is none

		XDataStruct xds = (XDataStruct) xvalue.getValueByName(segments[1]);
		if (xds == null) {
			xds = (XDataStruct) xvalue.getNewByName(segments[1]);
		}

		// loop over the middle segments using getValueSafely which will not returen null
		int pathCtr = 2;

		while (pathCtr < segments.length - 1) {
			xds = (XDataStruct) xds.getValueSafely(segments[pathCtr]);
			pathCtr++;
		}

		// finally set our value with the last segment
		if (xds == null) {
			logger.error("Error processing " + this.toString());
			return;
		}
		Field f = xds.m_datatype.getField(segments[pathCtr]);
		if (f.getMaxOccurs() == 0 || f.getMaxOccurs() == 1) {
			xds.setValue(segments[pathCtr], value);
		} else {
			xds.setXValues((Collection<XValue>) value); // .addNewValue(segments[pathCtr], value);
		}

	}

	/**
	 * @param string
	 * @return
	 */
	private Object getValueSafely(String string) {

		XValue xvalue = m_values.get(string);
		if (xvalue.isEmpty()) {
			xvalue.intializeStructs();
		}

		return this.getValue(string);
	}

	public void setXValues(Collection<XValue> xValues) {
		for (XValue xValue : xValues) {
			m_values.put(xValue.getName(), xValue);
		}
	}

	/**
	 * Get the value of the given field.
	 *
	 * @param fieldName
	 *            The name of the field to get.
	 * @return The value of the field.
	 */
	public Object getValue(String fieldName) {

		XValue xv = getXValue(fieldName);
		if (xv == null) {
			throw new MdmiException("Invalid fieldName: " + fieldName);
		}
		return xv.getValue();
	}

	/**
	 * Get the value of the given field.
	 *
	 * @param fieldName
	 *            The name of the field to get.
	 * @return The value of the field.
	 */
	public Object getValueByIndex(String fieldName, int index) {

		XValue xv = getXValue(fieldName);
		if (xv == null) {
			throw new MdmiException("Invalid fieldName: " + fieldName);
		}
		return xv.getValue(index);
	}

	/**
	 * Get the value of the given field.
	 *
	 * @param fieldName
	 *            The name of the field to get.
	 * @return The value of the field.
	 */
	// public Object addValueSafely(String fieldName) {
	//
	// // XValue xv = getXValue(fieldName);
	// // if (xv == null) {
	// // throw new MdmiException("Invalid fieldName: " + fieldName);
	// // }
	// //
	// // return xv.getValueSafelyByIndex(index);
	// }

	/**
	 * Clear the specified value, setting it to null in effect.
	 *
	 * @param name
	 *            The field name of the value to clear.
	 * @return The index of the value to be removed (cleared).
	 */
	public void clearValue(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Null 'name'");
		}
		XValue v = m_values.get(name);
		if (null == v) {
			throw new IllegalArgumentException("Onvalid field name " + name);
		}
		v.clear();
	}

	// @Override
	// protected String toString(String indent) {
	//// StringBuffer sb = new StringBuffer();
	//// if (null == indent) {
	//// indent = "";
	//// }
	//// for (Iterator<XValue> iterator = m_values.values().iterator(); iterator.hasNext();) {
	//// XValue v = iterator.next();
	//// if (v != null) {
	//// sb.append(v.toString(indent));
	//// } else {
	//// sb.append(indent + "null");
	//// }
	//// sb.append("\r\n");
	//// }
	//// return sb.toString();
	// }

	@Override
	public boolean isEmpty() {
		Collection<XValue> values = m_values.values();
		for (XValue xvalue : values) {
			if (!xvalue.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public boolean isNullOrEmpty() {
		if (m_datatype.getName().equalsIgnoreCase("Container")) {
			return false;
		}
		Collection<XValue> values = m_values.values();
		for (XValue xvalue : values) {
			if (!xvalue.isNullOrEmpty()) {
				return false;
			}
		}
		return true;
	}

	public Set<String> getFields() {
		return this.m_values.keySet();
	}

	public void init() {

		for (XValue xv : m_values.values()) {
			xv.intializeStructs();
		}

	}

	/**
	 * @param string
	 * @return
	 */
	public boolean hasfield(String key) {
		return (m_values.containsKey(key));
	}

	public String getXValueAsString(String fieldName) {

		if (m_values.containsKey(fieldName)) {
			XValue theValue = m_values.get(fieldName);
			if (theValue != null) {
				StringBuffer sb = new StringBuffer();
				for (Object object : theValue.getValues()) {
					if (object instanceof XDataStruct) {
						XDataStruct fieldValue = (XDataStruct) object;
						// sb.append(fieldValue.get).append(" ");
						sb.append(fieldValue.getXValues()).append(" ");
					} else {
						sb.append(object).append(" ");
					}
				}
				return sb.toString();
			}
		}
		return "";
	}

	public String getXValueAsString(String fieldName, int index) {

		if (m_values.containsKey(fieldName)) {
			XValue theValue = m_values.get(fieldName);
			if (theValue != null) {
				StringBuffer sb = new StringBuffer();
				if (!theValue.getValues().isEmpty()) {

					sb.append(theValue.getValue(index)).append(" ");
				}

				return sb.toString();
			}
		}
		return "";
	}

	/**
	 * @param string
	 * @param transform
	 * @param i
	 */
	public void replaceValue(String fieldName, String transform) {
		XValue xv = getXValue(fieldName);
		if (xv == null) {
			logger.error("Error in setValue ", new MdmiException("Invalid fieldName: " + fieldName));
		} else {
			xv.setValue(transform, 0);
		}
	}

	public Object addValueSafely(String fieldName) {
		XValue x = this.m_values.get(fieldName);
		XValue xxx = new XValue(x.getDatatype());
		this.setValue(fieldName, xxx);
		return xxx.getValue();
	}

} // XDataStruct
