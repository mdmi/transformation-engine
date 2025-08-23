/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DTS Enumerated</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.DTSEnumerated#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getDTSEnumerated()
 * @model
 * @generated
 */
public interface DTSEnumerated extends MDMIDatatype {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.EnumerationLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getDTSEnumerated_Literals()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumerationLiteral> getLiterals();

	/**
	 * @param value
	 * @return
	 */
	// org.openhealthtools.mdht.mdmi.model.EnumerationLiteral getLiteralByCode(String value);

	/**
	 * @param code
	 * @return
	 */
	Object getLiteralByName(String code);

	/**
	 * @param code
	 * @return
	 */
	EnumerationLiteral getLiteralByCode(String code);

} // DTSEnumerated
