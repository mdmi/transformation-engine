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

import org.mdmi.SemanticElement;

/**
 * An instance of a semantic element at runtime, holding its value. May hold a simple value or a complex one.
 *
 * @author goancea
 */
public interface IElementValue {
	/**
	 * The semantic element that describes this value.
	 *
	 * @return The semantic element that describes this value.
	 */
	public SemanticElement getSemanticElement();

	/**
	 * The element name.
	 *
	 * @return The element name.
	 */
	public String getName();

	/**
	 * The parent element value.
	 *
	 * @return The parent element value.
	 */
	public IElementValue getParent();

	/**
	 * Set the parent element value.
	 *
	 * @param parent
	 *            The new parent element value.
	 */
	public void setParent(IElementValue parent);

	/**
	 * Get the children of this element value.
	 *
	 * @return The children of this element value.
	 */
	public List<IElementValue> getChildren();

	/**
	 * Get the total number of children.
	 *
	 * @return The total number of children.
	 */
	public int getChildCount();

	/**
	 * Add the child to the children array and set the parent to this.
	 *
	 * @param child
	 *            The child to add.
	 */
	public void addChild(IElementValue child);

	/**
	 * Get the related element values of this.
	 *
	 * @return The related element values of this.
	 */
	public List<IElementValue> getRelations();

	/**
	 * Get the actual value of this element value. May be a simple type (string) or complex type (XData).
	 *
	 * @return The actual value of this element value.
	 */
	public Object value();

	/**
	 * Get the XValue wrapper of this element value. May be a simple or complex type.
	 *
	 * @return The actual value of this element value.
	 */
	public IValue getXValue();

	/**
	 * Return true if this element value is of a simple type.
	 *
	 * @return True if this element value is of a simple type.
	 */
	public boolean isSimple();

	/**
	 * Get the owner element value set.
	 *
	 * @return The owner element value set.
	 */
	public ElementValueSet getOwner();

	/**
	 * @param child
	 */
	void removeChild(IElementValue child);

	/**
	 * @return
	 */
	public String getUniqueId();
} // IElementValue
