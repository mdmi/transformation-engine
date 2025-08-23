/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * MessageModel contains the MessageElementSet in a message and the related MessageSyntaxModel. It important to point out that a MessageModel does not
 * necessarily contain all of the MessageElements in a message, as some MessageElements can be associated with other domains. (For example, a
 * RosettaNet message may have two hundred MessageElements but only a couple of dozen MessageElements associated with payments. In that case, only the
 * payment MessageElements may be modeled and grouped into a MessageModel associated with a Payment-domain dictionary.) The MessageModel is the parent
 * class that contains the MDMI model of a message format. Database schema of a record in a table can also be considered a message format as well as
 * most XML documents.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.MessageModel#getMessageModelName <em>Message Model Name</em>}</li>
 * <li>{@link org.mdmi.MessageModel#getSyntaxModel <em>Syntax Model</em>}</li>
 * <li>{@link org.mdmi.MessageModel#getElementSet <em>Element Set</em>}</li>
 * <li>{@link org.mdmi.MessageModel#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.MessageModel#getSource <em>Source</em>}</li>
 * <li>{@link org.mdmi.MessageModel#getGroup <em>Group</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getMessageModel()
 * @model
 * @generated
 */
public interface MessageModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Message Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The MessageModel is the parent class that contains the MDMI model of a message format. Database schema of a record in a table can also be
	 * considered a message format as well as most XML documents. A MessageModel does not necessarily contain all of the MessageElements in a message,
	 * as some MessageElements can be associated with other domains. For example, a RosettaNet message may have two hundred MessageElements but only a
	 * couple of dozen MessageElements associated with payments. In that case, only the payment MessageElements may be modeled and grouped into a
	 * MessageModel associated with a Payment domain dictionary.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Message Model Name</em>' attribute.
	 * @see #setMessageModelName(String)
	 * @see org.mdmi.MDMIPackage#getMessageModel_MessageModelName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getMessageModelName();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageModel#getMessageModelName <em>Message Model Name</em>}' attribute.
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
	 * Returns the value of the '<em><b>Syntax Model</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MessageSyntaxModel#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syntax Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Syntax Model</em>' containment reference.
	 * @see #setSyntaxModel(MessageSyntaxModel)
	 * @see org.mdmi.MDMIPackage#getMessageModel_SyntaxModel()
	 * @see org.mdmi.MessageSyntaxModel#getModel
	 * @model opposite="model" containment="true" required="true" ordered="false"
	 * @generated
	 */
	MessageSyntaxModel getSyntaxModel();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageModel#getSyntaxModel <em>Syntax Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Syntax Model</em>' containment reference.
	 * @see #getSyntaxModel()
	 * @generated
	 */
	void setSyntaxModel(MessageSyntaxModel value);

	/**
	 * Returns the value of the '<em><b>Element Set</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SemanticElementSet#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Element Set</em>' containment reference.
	 * @see #setElementSet(SemanticElementSet)
	 * @see org.mdmi.MDMIPackage#getMessageModel_ElementSet()
	 * @see org.mdmi.SemanticElementSet#getModel
	 * @model opposite="model" containment="true" required="true" ordered="false"
	 * @generated
	 */
	SemanticElementSet getElementSet();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageModel#getElementSet <em>Element Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Element Set</em>' containment reference.
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
	 * An optional "description" property of type String containing a description of the message model.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getMessageModel_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageModel#getDescription <em>Description</em>}' attribute.
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
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "source" property � the value is a reference to the definition of the message format, whose elements are being mapped. This reference might
	 * be to a formal model such as the location of the message definition in the ISO 20022 repository or it might be a paper document.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.mdmi.MDMIPackage#getMessageModel_Source()
	 * @model dataType="org.mdmi.URI"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageModel#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MessageGroup#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Group</em>' container reference.
	 * @see #setGroup(MessageGroup)
	 * @see org.mdmi.MDMIPackage#getMessageModel_Group()
	 * @see org.mdmi.MessageGroup#getModels
	 * @model opposite="models" required="true" transient="false" ordered="false"
	 * @generated
	 */
	MessageGroup getGroup();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageModel#getGroup <em>Group</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Group</em>' container reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(MessageGroup value);

	/**
	 * @return
	 */
	Map<String, MDMIBusinessElementReference> getBusinessElementHashMap();

} // MessageModel
