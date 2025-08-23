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
import java.util.HashMap;

import org.mdmi.DTSEnumerated;
import org.mdmi.EnumerationLiteral;
import org.mdmi.MDMIDatatype;
import org.mdmi.MessageGroup;
import org.mdmi.core.util.XmlUtil;
import org.w3c.dom.Element;

public class MdmiValueSet {
	public static final String TAG = "valueSet";

	private static final String VALUES_TAG = "values";

	public class Value {
		public static final String TAG = "value";

		private String code;

		private String description;

		public Value(String code, String description) {
			if (null == code || code.trim().length() <= 0) {
				throw new IllegalArgumentException("Code cannot be null or empty!");
			}
			this.code = code;
			this.description = description;
		}

		protected Value(EnumerationLiteral literal) {
			if (null == literal) {
				throw new IllegalArgumentException("Enumeration literal is null!");
			}
			this.code = literal.getName();
			this.description = literal.getDescription();
		}

		protected Value(Element root) {
			fromXml(root);
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			if (null == code || code.trim().length() <= 0) {
				throw new IllegalArgumentException("Code cannot be null or empty!");
			}
			if (isEnumerated()) {
				throw new IllegalArgumentException("Cannot change the code for enumerated types!");
			}
			this.code = code;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			if (isEnumerated()) {
				throw new IllegalArgumentException("Cannot change the description for enumerated types!");
			}
			this.description = description;
		}

		protected void fromXml(Element root) {
			code = root.getAttribute("code");
			description = root.getAttribute("description");
		}

		protected void toXml(Element owner) {
			Element root = XmlUtil.addElement(owner, TAG);
			root.setAttribute("code", code);
			if (null != description) {
				root.setAttribute("description", description);
			}
		}
	} // Value

	private MdmiValueSetsHandler owner;

	private String name;

	private DTSEnumerated dataType;

	private HashMap<String, Value> values;

	public MdmiValueSet(MdmiValueSetsHandler owner, String name) {
		if (null == owner) {
			throw new IllegalArgumentException("Owner cannot be null!");
		}
		if (null == name || name.trim().length() <= 0) {
			throw new IllegalArgumentException("Name must be non-empty or null!");
		}
		this.owner = owner;
		this.name = name;
		values = new HashMap<>();
	}

	public MdmiValueSet(MdmiValueSetsHandler owner, DTSEnumerated enumDataType) {
		if (null == owner) {
			throw new IllegalArgumentException("Owner cannot be null!");
		}
		if (null == enumDataType) {
			throw new IllegalArgumentException("Enumerated data type can't be null!");
		}
		this.owner = owner;
		this.name = enumDataType.getName();
		this.dataType = enumDataType;
		values = new HashMap<>();
		PopulateFromEnum();
	}

	protected MdmiValueSet(MdmiValueSetsHandler owner, Element root) {
		if (null == owner) {
			throw new IllegalArgumentException("Owner cannot be null!");
		}
		this.owner = owner;
		values = new HashMap<>();
		fromXml(root);
	}

	private void PopulateFromEnum() {
		dataType.getLiterals();
	}

	public boolean isEnumerated() {
		return null != dataType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (null == name || name.trim().length() <= 0) {
			throw new IllegalArgumentException("Name must be non-empty of null!");
		}
		if (isEnumerated()) {
			throw new IllegalArgumentException("Cannot set the name of an enumerated value set!");
		}
		this.name = name;
	}

	public MdmiValueSetsHandler getOwner() {
		return owner;
	}

	public DTSEnumerated getDataType() {
		return dataType;
	}

	public ArrayList<Value> getValues() {
		return new ArrayList<>(values.values());
	}

	public Value getValue(String code) {
		return values.get(code);
	}

	public boolean containsValue(String code) {
		return null != values.get(code);
	}

	public void addValue(String code, String description) {
		if (null == code || code.trim().length() <= 0) {
			throw new IllegalArgumentException("Value code cannot be null");
		}
		if (isEnumerated()) {
			throw new IllegalArgumentException("Cannot modify an enumerated value set!");
		}
		Value v = values.get(code);
		if (null == v) {
			v = new Value(code, description);
			values.put(code, v);
		} else {
			v.setDescription(description);
		}
	}

	public void removeValue(String name) {
		if (null == name || name.trim().length() <= 0) {
			throw new IllegalArgumentException("Value name cannot be null");
		}
		if (isEnumerated()) {
			throw new IllegalArgumentException("Cannot modify an enumerated value set!");
		}
		values.remove(name);
	}

	protected void fromXml(Element root) {
		name = root.getAttribute("name");
		String dt = root.getAttribute("dataType");
		if (null != dt && 0 < dt.length()) {
			MdmiResolver r = Mdmi.INSTANCE().getResolver();
			MessageGroup mg = r.getMessageGroup(owner);
			MDMIDatatype t = mg.getDatatype(dt);
			dataType = (DTSEnumerated) t;
			PopulateFromEnum();
			return; // <= NOTE
		}

		Element vs = XmlUtil.getElement(root, VALUES_TAG);
		if (null != vs) {
			ArrayList<Element> evs = XmlUtil.getElements(vs, Value.TAG);
			for (int i = 0; i < evs.size(); i++) {
				Element e = evs.get(i);
				Value v = new Value(e);
				values.put(v.getCode(), v);
			}
		}
	}

	protected void toXml(Element owner) {
		Element root = XmlUtil.addElement(owner, TAG);
		root.setAttribute("name", name);
		if (null != dataType) {
			root.setAttribute("dataType", dataType.getName());
			return; // <= NOTE
		}

		Element vs = XmlUtil.addElement(root, VALUES_TAG);
		for (Value v : values.values()) {
			v.toXml(vs);
		}
	}
} // MdmiValueSet
