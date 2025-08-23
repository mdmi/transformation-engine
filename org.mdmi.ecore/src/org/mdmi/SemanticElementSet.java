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
 * A representation of the model object '<em><b>Semantic Element Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * The SemanticElement Set contains all of the smallest semantic elements contained in a message format. The syntax of a particular message format has
 * been removed.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.SemanticElementSet#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.SemanticElementSet#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.SemanticElementSet#getMessageModelName <em>Message Model Name</em>}</li>
 * <li>{@link org.mdmi.SemanticElementSet#getSyntaxModel <em>Syntax Model</em>}</li>
 * <li>{@link org.mdmi.SemanticElementSet#getModel <em>Model</em>}</li>
 * <li>{@link org.mdmi.SemanticElementSet#getSemanticElements <em>Semantic Elements</em>}</li>
 * <li>{@link org.mdmi.SemanticElementSet#getComposite <em>Composite</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getSemanticElementSet()
 * @model
 * @generated
 */
public interface SemanticElementSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "name" property whose value is the name of the SemanticElementSet.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.mdmi.MDMIPackage#getSemanticElementSet_Name()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementSet#getName <em>Name</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The optional "description" property of type String provides a description of the SemanticElement Set.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getSemanticElementSet_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementSet#getDescription <em>Description</em>}' attribute.
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
	 * Returns the value of the '<em><b>Message Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "MessageModelName" property, whose value is constrained to be the same as the name property in the MessageModel that contains the
	 * SemanticElementSet. This derived property is included for implementation convenience.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Message Model Name</em>' attribute.
	 * @see #setMessageModelName(String)
	 * @see org.mdmi.MDMIPackage#getSemanticElementSet_MessageModelName()
	 * @model required="true" derived="true" ordered="false"
	 * @generated
	 */
	String getMessageModelName();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementSet#getMessageModelName <em>Message Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Message Model Name</em>' attribute.
	 * @see #getMessageModelName()
	 * @generated
	 */
	void setMessageModelName(String value);

	/**
	 * Returns the value of the '<em><b>Syntax Model</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MessageSyntaxModel#getElementSet <em>Element Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syntax Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Syntax Model</em>' reference.
	 * @see #setSyntaxModel(MessageSyntaxModel)
	 * @see org.mdmi.MDMIPackage#getSemanticElementSet_SyntaxModel()
	 * @see org.mdmi.MessageSyntaxModel#getElementSet
	 * @model opposite="elementSet" required="true" ordered="false"
	 * @generated
	 */
	MessageSyntaxModel getSyntaxModel();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementSet#getSyntaxModel <em>Syntax Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Syntax Model</em>' reference.
	 * @see #getSyntaxModel()
	 * @generated
	 */
	void setSyntaxModel(MessageSyntaxModel value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MessageModel#getElementSet <em>Element Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Model</em>' container reference.
	 * @see #setModel(MessageModel)
	 * @see org.mdmi.MDMIPackage#getSemanticElementSet_Model()
	 * @see org.mdmi.MessageModel#getElementSet
	 * @model opposite="elementSet" required="true" transient="false" ordered="false"
	 * @generated
	 */
	MessageModel getModel();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementSet#getModel <em>Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Model</em>' container reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(MessageModel value);

	/**
	 * Returns the value of the '<em><b>Semantic Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.SemanticElement}.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SemanticElement#getElementSet <em>Element Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Semantic Elements</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getSemanticElementSet_SemanticElements()
	 * @see org.mdmi.SemanticElement#getElementSet
	 * @model opposite="elementSet" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<SemanticElement> getSemanticElements();

	/**
	 * Returns the value of the '<em><b>Composite</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.SimpleMessageComposite}.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SimpleMessageComposite#getElementSet <em>Element Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Composite</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getSemanticElementSet_Composite()
	 * @see org.mdmi.SimpleMessageComposite#getElementSet
	 * @model opposite="elementSet" containment="true" ordered="false"
	 * @generated
	 */
	EList<SimpleMessageComposite> getComposite();

	/**
	 * @param string
	 * @return
	 */
	// SemanticElement getSemanticElement(String string);

	/**
	 * @param name
	 * @return
	 */
	SemanticElement getSemanticElement(MDMIBusinessElementReference name);

} // SemanticElementSet
