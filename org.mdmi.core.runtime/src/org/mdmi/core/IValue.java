/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import java.util.List;

import org.mdmi.MDMIDatatype;

/**
 * The value of a semantic element or a field at runtime.
 * It may contain more than one phisical value, if the field cardinality is greater than 1.
 *
 * @author goancea
 */
public interface IValue {
	/**
	 * The datatype of the value, can be simple or complex.
	 *
	 * @return The datatype of the value, can be simple or complex.
	 */
	public MDMIDatatype getDatatype();

	/**
	 * The value or field name.
	 *
	 * @return The value or field name.
	 */
	public String getName();

	/**
	 * Set the name of the field or value.
	 *
	 * @param name
	 *            The new name of the field or value.
	 */
	public void setName(String name);

	/**
	 * The number of actual values this instance holds.
	 *
	 * @return The number of actual values this instance holds.
	 */
	public int size();

	/**
	 * Clone the values from the source into this values.
	 *
	 * @param src
	 *            The source for the values.
	 */
	public void cloneValues(IValue src);

	/**
	 * Get the value of this. If it is not set, null is returned.
	 * If there are more than one values, will return the first one (at index 0).
	 *
	 * @return The value of this
	 */
	public Object getValue();

	/**
	 * Get the value at the given index. The index must be valid (between 0 and size()).
	 *
	 * @param index
	 *            The index to get the value at.
	 * @return The value at the specified index.
	 */
	public Object getValue(int index);

	/**
	 * Get all values for this value. It will not be null, but may be empty if not set.
	 *
	 * @return All values for this value.
	 */
	public List<Object> getValues();

	/**
	 * Get the index of the given value, if found in the list of values. -1 if not found.
	 *
	 * @param value
	 *            The value to look for.
	 * @return The index of the given value, if found in the list of values. -1 if not found.
	 */
	public int getIndexOf(Object value);

	/**
	 * Set the value of this. This is equivalent of calling setValue(value, 0). That is, if a value does not exists,
	 * the given one will be added, otherwise the existing value at 0 will be replaced by this.
	 *
	 * @param value
	 *            The value to add.
	 */
	public void setValue(Object value);

	/**
	 * Set the value at the specified index, replace existing one there.
	 * If the index is invalid, the new value is added at the end of the list.
	 *
	 * @param value
	 *            The new value.
	 * @param index
	 *            The index at which to set it.
	 */
	public void setValue(Object value, int index);

	/**
	 * Returns true if this instance holds no values at all.
	 *
	 * @return True if this instance holds no values at all, false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Add the new value at the end of the list.
	 *
	 * @param value
	 *            The new value.
	 */
	public void addValue(Object value);

	/**
	 * Add the value at the specified index, shifting existing values down.
	 * If the index is invalid, the new value is added at the end of the list.
	 *
	 * @param value
	 *            The new value.
	 * @param index
	 *            The index at which to add it.
	 */
	public void addValue(Object value, int index);

	/**
	 * Shortcut method, assumes the datatype is a struct, and if it is
	 * will set the field to the given value. Note that it will set the value of
	 * all structs if this is an array. Use with care!
	 *
	 * @param field
	 *            Field name in the struct value.
	 * @param value
	 *            Value to set it to.
	 */
	public void addValue(String field, Object value);

	/**
	 * Remove the given value, if found.
	 *
	 * @param value
	 *            The value to remove.
	 */
	public void removeValue(Object value);

	/**
	 * Remove the value at the specified index.
	 *
	 * @param index
	 *            The index at which the value is to be removed. Must be valid.
	 */
	public void removeValue(int index);

	/**
	 * Remove all values.
	 */
	public void clear();
} // IValue
