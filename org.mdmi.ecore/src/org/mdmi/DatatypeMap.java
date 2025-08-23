/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Datatype Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.DatatypeMap#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.DatatypeMap#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.DatatypeMap#getFromMDMI <em>From MDMI</em>}</li>
 * <li>{@link org.mdmi.DatatypeMap#getToMDMI <em>To MDMI</em>}</li>
 * <li>{@link org.mdmi.DatatypeMap#getMdmiDatatype <em>Mdmi Datatype</em>}</li>
 * <li>{@link org.mdmi.DatatypeMap#getMessageDatatype <em>Message Datatype</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getDatatypeMap()
 * @model
 * @generated
 */
public interface DatatypeMap extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.mdmi.MDMIPackage#getDatatypeMap_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.DatatypeMap#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getDatatypeMap_Description()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.DatatypeMap#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>From MDMI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From MDMI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>From MDMI</em>' attribute.
	 * @see #setFromMDMI(String)
	 * @see org.mdmi.MDMIPackage#getDatatypeMap_FromMDMI()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getFromMDMI();

	/**
	 * Sets the value of the '{@link org.mdmi.DatatypeMap#getFromMDMI <em>From MDMI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>From MDMI</em>' attribute.
	 * @see #getFromMDMI()
	 * @generated
	 */
	void setFromMDMI(String value);

	/**
	 * Returns the value of the '<em><b>To MDMI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To MDMI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>To MDMI</em>' attribute.
	 * @see #setToMDMI(String)
	 * @see org.mdmi.MDMIPackage#getDatatypeMap_ToMDMI()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getToMDMI();

	/**
	 * Sets the value of the '{@link org.mdmi.DatatypeMap#getToMDMI <em>To MDMI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>To MDMI</em>' attribute.
	 * @see #getToMDMI()
	 * @generated
	 */
	void setToMDMI(String value);

	/**
	 * Returns the value of the '<em><b>Mdmi Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mdmi Datatype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Mdmi Datatype</em>' reference.
	 * @see #setMdmiDatatype(MDMIDatatype)
	 * @see org.mdmi.MDMIPackage#getDatatypeMap_MdmiDatatype()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	MDMIDatatype getMdmiDatatype();

	/**
	 * Sets the value of the '{@link org.mdmi.DatatypeMap#getMdmiDatatype <em>Mdmi Datatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Mdmi Datatype</em>' reference.
	 * @see #getMdmiDatatype()
	 * @generated
	 */
	void setMdmiDatatype(MDMIDatatype value);

	/**
	 * Returns the value of the '<em><b>Message Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Datatype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Message Datatype</em>' reference.
	 * @see #setMessageDatatype(MDMIDatatype)
	 * @see org.mdmi.MDMIPackage#getDatatypeMap_MessageDatatype()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	MDMIDatatype getMessageDatatype();

	/**
	 * Sets the value of the '{@link org.mdmi.DatatypeMap#getMessageDatatype <em>Message Datatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Message Datatype</em>' reference.
	 * @see #getMessageDatatype()
	 * @generated
	 */
	void setMessageDatatype(MDMIDatatype value);

} // DatatypeMap
