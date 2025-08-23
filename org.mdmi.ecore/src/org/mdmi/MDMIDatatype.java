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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Datatype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * Abstract class, base for the named types used to represent a message element. Can be a simple type (built-in, derived, or enumerated), or a complex
 * type (structure or a choice) or an external datatype. The latter is a registered datatype that is associated with the domain dictionary - a URI is
 * required to reference it.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.MDMIDatatype#getTypeName <em>Type Name</em>}</li>
 * <li>{@link org.mdmi.MDMIDatatype#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.MDMIDatatype#getReference <em>Reference</em>}</li>
 * <li>{@link org.mdmi.MDMIDatatype#isIsReadonly <em>Is Readonly</em>}</li>
 * <li>{@link org.mdmi.MDMIDatatype#getTypeSpec <em>Type Spec</em>}</li>
 * <li>{@link org.mdmi.MDMIDatatype#getRestriction <em>Restriction</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getMDMIDatatype()
 * @model
 * @generated
 */
public interface MDMIDatatype extends EObject {
	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Type Name</em>' attribute.
	 * @see #setTypeName(String)
	 * @see org.mdmi.MDMIPackage#getMDMIDatatype_TypeName()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getTypeName();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIDatatype#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Type Name</em>' attribute.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * Datatype description.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getMDMIDatatype_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIDatatype#getDescription <em>Description</em>}' attribute.
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
	 * Returns the value of the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Reference</em>' attribute.
	 * @see #setReference(String)
	 * @see org.mdmi.MDMIPackage#getMDMIDatatype_Reference()
	 * @model dataType="org.mdmi.URI" required="true"
	 * @generated
	 */
	String getReference();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIDatatype#getReference <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Reference</em>' attribute.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(String value);

	/**
	 * Returns the value of the '<em><b>Is Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Readonly</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Is Readonly</em>' attribute.
	 * @see #setIsReadonly(boolean)
	 * @see org.mdmi.MDMIPackage#getMDMIDatatype_IsReadonly()
	 * @model
	 * @generated
	 */
	boolean isIsReadonly();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIDatatype#isIsReadonly <em>Is Readonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Is Readonly</em>' attribute.
	 * @see #isIsReadonly()
	 * @generated
	 */
	void setIsReadonly(boolean value);

	/**
	 * Returns the value of the '<em><b>Type Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Spec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Type Spec</em>' attribute.
	 * @see #setTypeSpec(String)
	 * @see org.mdmi.MDMIPackage#getMDMIDatatype_TypeSpec()
	 * @model
	 * @generated
	 */
	String getTypeSpec();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIDatatype#getTypeSpec <em>Type Spec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Type Spec</em>' attribute.
	 * @see #getTypeSpec()
	 * @generated
	 */
	void setTypeSpec(String value);

	/**
	 * Returns the value of the '<em><b>Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restriction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Restriction</em>' attribute.
	 * @see #setRestriction(String)
	 * @see org.mdmi.MDMIPackage#getMDMIDatatype_Restriction()
	 * @model
	 * @generated
	 */
	String getRestriction();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIDatatype#getRestriction <em>Restriction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Restriction</em>' attribute.
	 * @see #getRestriction()
	 * @generated
	 */
	void setRestriction(String value);

	/**
	 * @return
	 */
	boolean isComplex();

	/**
	 * @return
	 */
	String getName();

	/**
	 * @param string
	 * @return
	 */
	Field getField(String string);

	EList<Field> getFields();

	/**
	 * @return
	 */
	boolean isStruct();

	/**
	 * @return
	 */
	boolean isChoice();

	/**
	 * @return
	 */
	boolean isSimple();

	/**
	 * @return
	 */
	boolean isPrimitive();

	/**
	 * @return
	 */
	boolean isDerived();

	/**
	 * @return
	 */
	boolean isExternal();

	// /**
	// * @return
	// */
	// Object getFields();

} // MDMIDatatype
