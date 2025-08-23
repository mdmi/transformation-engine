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
 * A representation of the model object '<em><b>Simple Message Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * SimpleMessageComposite represent aggregations of SemanticElements. SimpleMessageComposite are an informative artifact that can be useful when
 * SemanticElement are associated with an object model. Usually the attributes of an object will be equivalent to a SemanticElement and the object
 * itself equivalent to a SimpleMessageComposite.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.SimpleMessageComposite#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.SimpleMessageComposite#getSemanticElements <em>Semantic Elements</em>}</li>
 * <li>{@link org.mdmi.SimpleMessageComposite#getElementSet <em>Element Set</em>}</li>
 * <li>{@link org.mdmi.SimpleMessageComposite#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getSimpleMessageComposite()
 * @model
 * @generated
 */
public interface SimpleMessageComposite extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "name" property, whose value is the name of the SimpleMessageComposite.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.mdmi.MDMIPackage#getSimpleMessageComposite_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.SimpleMessageComposite#getName <em>Name</em>}' attribute.
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
	 * Returns the value of the '<em><b>Semantic Elements</b></em>' reference list.
	 * The list contents are of type {@link org.mdmi.SemanticElement}.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SemanticElement#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Semantic Elements</em>' reference list.
	 * @see org.mdmi.MDMIPackage#getSimpleMessageComposite_SemanticElements()
	 * @see org.mdmi.SemanticElement#getComposite
	 * @model opposite="composite" required="true" ordered="false"
	 * @generated
	 */
	EList<SemanticElement> getSemanticElements();

	/**
	 * Returns the value of the '<em><b>Element Set</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SemanticElementSet#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Set</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Element Set</em>' container reference.
	 * @see #setElementSet(SemanticElementSet)
	 * @see org.mdmi.MDMIPackage#getSimpleMessageComposite_ElementSet()
	 * @see org.mdmi.SemanticElementSet#getComposite
	 * @model opposite="composite" required="true" transient="false" ordered="false"
	 * @generated
	 */
	SemanticElementSet getElementSet();

	/**
	 * Sets the value of the '{@link org.mdmi.SimpleMessageComposite#getElementSet <em>Element Set</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Element Set</em>' container reference.
	 * @see #getElementSet()
	 * @generated
	 */
	void setElementSet(SemanticElementSet value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * An optional "description" property of type String that describes SimpleMessageComposite.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getSimpleMessageComposite_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.SimpleMessageComposite#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // SimpleMessageComposite
