/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import org.mdmi.MDMIDatatype;

/**
 * Base class for the structure and choice data types.
 * It is owned by a value, and always has a data type.
 *
 * @author goancea
 */
abstract class XData {

	protected XValue m_owner;

	protected MDMIDatatype m_datatype;

	/**
	 * The owner may be null in some circumstances, the data type may not.
	 *
	 * @param owner
	 *            The value owner.
	 * @param datatype
	 *            The data type (can be DTCStructured or DTCChoice).
	 */
	public XData(XValue owner, MDMIDatatype datatype) {
		if (datatype == null) {
			throw new IllegalArgumentException(
				(owner != null
						? owner.getName()
						: "NULL OWNER") + " has null datatype!");
		}
		m_datatype = datatype;
		m_owner = owner;
	}

	/**
	 * Get the owner value.
	 *
	 * @return The owner value.
	 */
	public XValue getOwner() {
		return m_owner;
	}

	/**
	 * Get the data type (can be DTCStructured or DTCChoice).
	 *
	 * @return The data type (can be DTCStructured or DTCChoice).
	 */
	public MDMIDatatype getDatatype() {
		return m_datatype;
	}

	// @Override
	// public String toString() {
	// return toString("");
	// }

	// /**
	// * Build the string representation of this value.
	// *
	// * @param indent The indentation to use.
	// * @return The string representation of this value.
	// */
	// protected abstract String toString(String indent);

	/**
	 * Return true if the data structure/choice has no value.
	 *
	 * @return True if the data structure/choice has no value.
	 */
	public abstract boolean isEmpty();
} // XData
