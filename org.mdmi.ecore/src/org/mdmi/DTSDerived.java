/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DTS Derived</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.DTSDerived#getBaseType <em>Base Type</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getDTSDerived()
 * @model
 * @generated
 */
public interface DTSDerived extends DTSPrimitive {
	/**
	 * Returns the value of the '<em><b>Base Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Base Type</em>' reference.
	 * @see #setBaseType(MDMIDatatype)
	 * @see org.mdmi.MDMIPackage#getDTSDerived_BaseType()
	 * @model
	 * @generated
	 */
	MDMIDatatype getBaseType();

	/**
	 * Sets the value of the '{@link org.mdmi.DTSDerived#getBaseType <em>Base Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Base Type</em>' reference.
	 * @see #getBaseType()
	 * @generated
	 */
	void setBaseType(MDMIDatatype value);

	/**
	 * @return
	 */
	DTSPrimitive getPrimitiveBaseType();

} // DTSDerived
