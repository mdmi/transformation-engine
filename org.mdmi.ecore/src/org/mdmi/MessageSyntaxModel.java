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
 * A representation of the model object '<em><b>Message Syntax Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * The MessageSyntaxModel contains a syntax tree that describes how each Semantic Element can be either inserted into or extracted from a message
 * based on that message�s message format.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.MessageSyntaxModel#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.MessageSyntaxModel#getModel <em>Model</em>}</li>
 * <li>{@link org.mdmi.MessageSyntaxModel#getRoot <em>Root</em>}</li>
 * <li>{@link org.mdmi.MessageSyntaxModel#getElementSet <em>Element Set</em>}</li>
 * <li>{@link org.mdmi.MessageSyntaxModel#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getMessageSyntaxModel()
 * @model
 * @generated
 */
public interface MessageSyntaxModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "name" property, whose value is the name of the MessageSyntaxModel -- This name will often be similar to the MessageModel name, e.g., "MT103
	 * Syntax Tree." The optional property "description" of type String provides a description of MessageGroup.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.mdmi.MDMIPackage#getMessageSyntaxModel_Name()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageSyntaxModel#getName <em>Name</em>}' attribute.
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
	 * Returns the value of the '<em><b>Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MessageModel#getSyntaxModel <em>Syntax Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Model</em>' container reference.
	 * @see #setModel(MessageModel)
	 * @see org.mdmi.MDMIPackage#getMessageSyntaxModel_Model()
	 * @see org.mdmi.MessageModel#getSyntaxModel
	 * @model opposite="syntaxModel" required="true" transient="false" ordered="false"
	 * @generated
	 */
	MessageModel getModel();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageSyntaxModel#getModel <em>Model</em>}' container reference.
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
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.Node#getSyntaxModel <em>Syntax Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(Node)
	 * @see org.mdmi.MDMIPackage#getMessageSyntaxModel_Root()
	 * @see org.mdmi.Node#getSyntaxModel
	 * @model opposite="syntaxModel" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Node getRoot();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageSyntaxModel#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Node value);

	/**
	 * Returns the value of the '<em><b>Element Set</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SemanticElementSet#getSyntaxModel <em>Syntax Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Element Set</em>' reference.
	 * @see #setElementSet(SemanticElementSet)
	 * @see org.mdmi.MDMIPackage#getMessageSyntaxModel_ElementSet()
	 * @see org.mdmi.SemanticElementSet#getSyntaxModel
	 * @model opposite="syntaxModel" required="true" ordered="false"
	 * @generated
	 */
	SemanticElementSet getElementSet();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageSyntaxModel#getElementSet <em>Element Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Element Set</em>' reference.
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
	 * The optional property "description" of type String provides a description of MessageGroup.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getMessageSyntaxModel_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageSyntaxModel#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // MessageSyntaxModel
