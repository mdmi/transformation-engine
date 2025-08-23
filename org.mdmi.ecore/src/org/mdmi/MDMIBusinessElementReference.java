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
 * A representation of the model object '<em><b>Business Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * The MDMIBusinessElementReference is as a class that references a business element in a dictionary. No assumption is made about the format of the
 * business element in the central dictionary. Therefore, the reference can only be informational. However a function must be available that, given
 * the reference, will return a uniqueIdentifier and a reference MDMIDatatype.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.MDMIBusinessElementReference#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementReference#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementReference#getReference <em>Reference</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementReference#getUniqueIdentifier <em>Unique Identifier</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementReference#getBusinessRules <em>Business Rules</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementReference#getDomainDictionaryReference <em>Domain Dictionary Reference</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementReference#getReferenceDatatype <em>Reference Datatype</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementReference#getEnumValueSetField <em>Enum Value Set Field</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementReference#getEnumValueField <em>Enum Value Field</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementReference#getEnumValueDescrField <em>Enum Value Descr Field</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementReference#getEnumValueSet <em>Enum Value Set</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementReference#getReadonly <em>Readonly</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference()
 * @model
 * @generated
 */
public interface MDMIBusinessElementReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The "Name" property of type String names the MDMIBusinessElementReference.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference_Name()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementReference#getName <em>Name</em>}' attribute.
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
	 * The optional "description" property of type String describes the MDMIBusinessElementReference.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementReference#getDescription <em>Description</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The "reference" property identifies the location of the BusinessElement in a central dictionary through a URI. URIs are very general address,
	 * i.e., the URI could even point to a line in a page in a document therefore the "reference� property is informational.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Reference</em>' attribute.
	 * @see #setReference(String)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference_Reference()
	 * @model dataType="org.mdmi.URI" required="true"
	 * @generated
	 */
	String getReference();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementReference#getReference <em>Reference</em>}' attribute.
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
	 * Returns the value of the '<em><b>Unique Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The "uniqueIdentifier" is a key property. The �uniqueIdentifier" of type String provides a unique identifier for all
	 * MDMIBusinessElementReference instances that reference the same business element in the central dictionary. There must be a function associated
	 * with the central dictionary that provides this identifier. Runtime transformation engines recognize the matching source and target mappings for
	 * a Semantic Element because they will each have the same "uniqueIdentifier".
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Unique Identifier</em>' attribute.
	 * @see #setUniqueIdentifier(String)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference_UniqueIdentifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getUniqueIdentifier();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementReference#getUniqueIdentifier <em>Unique Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Unique Identifier</em>' attribute.
	 * @see #getUniqueIdentifier()
	 * @generated
	 */
	void setUniqueIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Business Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.MDMIBusinessElementRule}.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MDMIBusinessElementRule#getBusinessElement <em>Business Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Business Rules</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference_BusinessRules()
	 * @see org.mdmi.MDMIBusinessElementRule#getBusinessElement
	 * @model opposite="businessElement" containment="true" ordered="false"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	EList<MDMIBusinessElementRule> getBusinessRules();

	/**
	 * Returns the value of the '<em><b>Domain Dictionary Reference</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MDMIDomainDictionaryReference#getBusinessElements <em>Business Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Dictionary Reference</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Domain Dictionary Reference</em>' container reference.
	 * @see #setDomainDictionaryReference(MDMIDomainDictionaryReference)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference_DomainDictionaryReference()
	 * @see org.mdmi.MDMIDomainDictionaryReference#getBusinessElements
	 * @model opposite="businessElements" required="true" transient="false" ordered="false"
	 * @generated
	 */
	MDMIDomainDictionaryReference getDomainDictionaryReference();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementReference#getDomainDictionaryReference <em>Domain Dictionary Reference</em>}'
	 * container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Domain Dictionary Reference</em>' container reference.
	 * @see #getDomainDictionaryReference()
	 * @generated
	 */
	void setDomainDictionaryReference(MDMIDomainDictionaryReference value);

	/**
	 * Returns the value of the '<em><b>Reference Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The "referenceDatatype" property of type MDMIDatatype provides a reference datatype for each business element in the central dictionary. There
	 * must be a function associated with the central dictionary that will deliver the "referenceDatatype". Maps to/from this reference datatype to
	 * the "datatype" in the SemanticElement should be provided as a ConversionRule.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Reference Datatype</em>' reference.
	 * @see #setReferenceDatatype(MDMIDatatype)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference_ReferenceDatatype()
	 * @model resolveProxies="false" required="true" ordered="false"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	MDMIDatatype getReferenceDatatype();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementReference#getReferenceDatatype <em>Reference Datatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Reference Datatype</em>' reference.
	 * @see #getReferenceDatatype()
	 * @generated
	 */
	void setReferenceDatatype(MDMIDatatype value);

	/**
	 * Returns the value of the '<em><b>Enum Value Set Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * Datatype description.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Enum Value Set Field</em>' attribute.
	 * @see #setEnumValueSetField(String)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference_EnumValueSetField()
	 * @model ordered="false"
	 * @generated
	 */
	String getEnumValueSetField();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementReference#getEnumValueSetField <em>Enum Value Set Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Enum Value Set Field</em>' attribute.
	 * @see #getEnumValueSetField()
	 * @generated
	 */
	void setEnumValueSetField(String value);

	/**
	 * Returns the value of the '<em><b>Enum Value Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * Datatype description.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Enum Value Field</em>' attribute.
	 * @see #setEnumValueField(String)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference_EnumValueField()
	 * @model ordered="false"
	 * @generated
	 */
	String getEnumValueField();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementReference#getEnumValueField <em>Enum Value Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Enum Value Field</em>' attribute.
	 * @see #getEnumValueField()
	 * @generated
	 */
	void setEnumValueField(String value);

	/**
	 * Returns the value of the '<em><b>Enum Value Descr Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * Datatype description.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Enum Value Descr Field</em>' attribute.
	 * @see #setEnumValueDescrField(String)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference_EnumValueDescrField()
	 * @model ordered="false"
	 * @generated
	 */
	String getEnumValueDescrField();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementReference#getEnumValueDescrField <em>Enum Value Descr Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Enum Value Descr Field</em>' attribute.
	 * @see #getEnumValueDescrField()
	 * @generated
	 */
	void setEnumValueDescrField(String value);

	/**
	 * Returns the value of the '<em><b>Enum Value Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * Datatype description.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Enum Value Set</em>' attribute.
	 * @see #setEnumValueSet(String)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference_EnumValueSet()
	 * @model ordered="false"
	 * @generated
	 */
	String getEnumValueSet();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementReference#getEnumValueSet <em>Enum Value Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Enum Value Set</em>' attribute.
	 * @see #getEnumValueSet()
	 * @generated
	 */
	void setEnumValueSet(String value);

	/**
	 * Returns the value of the '<em><b>Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Readonly</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Readonly</em>' attribute.
	 * @see #setReadonly(Boolean)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementReference_Readonly()
	 * @model required="true"
	 * @generated
	 */
	Boolean getReadonly();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementReference#getReadonly <em>Readonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Readonly</em>' attribute.
	 * @see #getReadonly()
	 * @generated
	 */
	void setReadonly(Boolean value);

	/**
	 * @return
	 */
	MDMIBusinessElementReference getParent();

} // MDMIBusinessElementReference
