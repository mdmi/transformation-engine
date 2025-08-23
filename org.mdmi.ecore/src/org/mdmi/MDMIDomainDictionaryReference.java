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
 * A representation of the model object '<em><b>Domain Dictionary Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * The MDMIDomainDictionaryReference class provides a reference to the central dictionary that the Maps in the Message group are using. This class is
 * purely for informational as the URI reference to the dictionary does not have be machine readable. The dictionary could reside on paper, for
 * example. However, there must be a function or method associated with the dictionary that will provide 1) a uniqueIdentifier for all Business
 * Elements, and 2) a reference to a datatype that is compatible with the set of MDMIDatatypes. The MessageSyntaxModel contains a syntax tree that
 * describes how each Semantic Element can be either inserted into or extracted from a message based on that message�s message format.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.MDMIDomainDictionaryReference#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.MDMIDomainDictionaryReference#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.MDMIDomainDictionaryReference#getBusinessElements <em>Business Elements</em>}</li>
 * <li>{@link org.mdmi.MDMIDomainDictionaryReference#getReference <em>Reference</em>}</li>
 * <li>{@link org.mdmi.MDMIDomainDictionaryReference#getGroup <em>Group</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getMDMIDomainDictionaryReference()
 * @model
 * @generated
 */
public interface MDMIDomainDictionaryReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "name" property of type string that provides a name for the referenced central dictionary.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.mdmi.MDMIPackage#getMDMIDomainDictionaryReference_Name()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIDomainDictionaryReference#getName <em>Name</em>}' attribute.
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
	 * An optional "description" property that provides a description of the referenced central dictionary.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getMDMIDomainDictionaryReference_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIDomainDictionaryReference#getDescription <em>Description</em>}' attribute.
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
	 * Returns the value of the '<em><b>Business Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.MDMIBusinessElementReference}.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MDMIBusinessElementReference#getDomainDictionaryReference <em>Domain Dictionary
	 * Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Business Elements</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getMDMIDomainDictionaryReference_BusinessElements()
	 * @see org.mdmi.MDMIBusinessElementReference#getDomainDictionaryReference
	 * @model opposite="domainDictionaryReference" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<MDMIBusinessElementReference> getBusinessElements();

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "reference" property of the type URI that provides a reference to the central dictionary, such as a URL.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Reference</em>' attribute.
	 * @see #setReference(String)
	 * @see org.mdmi.MDMIPackage#getMDMIDomainDictionaryReference_Reference()
	 * @model dataType="org.mdmi.URI" required="true"
	 * @generated
	 */
	String getReference();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIDomainDictionaryReference#getReference <em>Reference</em>}' attribute.
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
	 * Returns the value of the '<em><b>Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MessageGroup#getDomainDictionary <em>Domain Dictionary</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Group</em>' container reference.
	 * @see #setGroup(MessageGroup)
	 * @see org.mdmi.MDMIPackage#getMDMIDomainDictionaryReference_Group()
	 * @see org.mdmi.MessageGroup#getDomainDictionary
	 * @model opposite="domainDictionary" required="true" transient="false" ordered="false"
	 * @generated
	 */
	MessageGroup getGroup();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIDomainDictionaryReference#getGroup <em>Group</em>}' container reference.
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @model businessElementReferenceRequired="true"
	 * @generated
	 */
	void addBusinessElement(MDMIBusinessElementReference businessElementReference);

	//
	MDMIBusinessElementReference findMDMIBusinessElementReference(String id);

	/**
	 * @param name
	 * @return
	 */
	MDMIBusinessElementReference getBusinessElement(MDMIBusinessElementReference name);

	/**
	 * @param uid
	 * @return
	 */
	MDMIBusinessElementReference getBusinessElementByUniqueID(String uid);

	/**
	 * @param name
	 * @return
	 */
	MDMIBusinessElementReference getBusinessElement(String name);

} // MDMIDomainDictionaryReference
