/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MDMIBusinessElementRule;
import org.mdmi.MDMIDatatype;
import org.mdmi.MDMIDomainDictionaryReference;
import org.mdmi.MDMIPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl#getReference <em>Reference</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl#getUniqueIdentifier <em>Unique Identifier</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl#getBusinessRules <em>Business Rules</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl#getDomainDictionaryReference <em>Domain Dictionary Reference</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl#getReferenceDatatype <em>Reference Datatype</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl#getEnumValueSetField <em>Enum Value Set Field</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl#getEnumValueField <em>Enum Value Field</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl#getEnumValueDescrField <em>Enum Value Descr Field</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl#getEnumValueSet <em>Enum Value Set</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl#getReadonly <em>Readonly</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MDMIBusinessElementReferenceImpl extends EObjectImpl implements MDMIBusinessElementReference {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected String reference = REFERENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUniqueIdentifier() <em>Unique Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getUniqueIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIQUE_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUniqueIdentifier() <em>Unique Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getUniqueIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String uniqueIdentifier = UNIQUE_IDENTIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBusinessRules() <em>Business Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getBusinessRules()
	 * @generated
	 * @ordered
	 */
	protected EList<MDMIBusinessElementRule> businessRules;

	/**
	 * The cached value of the '{@link #getReferenceDatatype() <em>Reference Datatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getReferenceDatatype()
	 * @generated
	 * @ordered
	 */
	protected MDMIDatatype referenceDatatype;

	/**
	 * The default value of the '{@link #getEnumValueSetField() <em>Enum Value Set Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumValueSetField()
	 * @generated
	 * @ordered
	 */
	protected static final String ENUM_VALUE_SET_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnumValueSetField() <em>Enum Value Set Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumValueSetField()
	 * @generated
	 * @ordered
	 */
	protected String enumValueSetField = ENUM_VALUE_SET_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnumValueField() <em>Enum Value Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumValueField()
	 * @generated
	 * @ordered
	 */
	protected static final String ENUM_VALUE_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnumValueField() <em>Enum Value Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumValueField()
	 * @generated
	 * @ordered
	 */
	protected String enumValueField = ENUM_VALUE_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnumValueDescrField() <em>Enum Value Descr Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumValueDescrField()
	 * @generated
	 * @ordered
	 */
	protected static final String ENUM_VALUE_DESCR_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnumValueDescrField() <em>Enum Value Descr Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumValueDescrField()
	 * @generated
	 * @ordered
	 */
	protected String enumValueDescrField = ENUM_VALUE_DESCR_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnumValueSet() <em>Enum Value Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumValueSet()
	 * @generated
	 * @ordered
	 */
	protected static final String ENUM_VALUE_SET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnumValueSet() <em>Enum Value Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumValueSet()
	 * @generated
	 * @ordered
	 */
	protected String enumValueSet = ENUM_VALUE_SET_EDEFAULT;

	/**
	 * The default value of the '{@link #getReadonly() <em>Readonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getReadonly()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean READONLY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReadonly() <em>Readonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getReadonly()
	 * @generated
	 * @ordered
	 */
	protected Boolean readonly = READONLY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MDMIBusinessElementReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MDMIPackage.Literals.MDMI_BUSINESS_ELEMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DESCRIPTION, oldDescription,
					description));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setReference(String newReference) {
		String oldReference = reference;
		reference = newReference;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE, oldReference,
					reference));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setUniqueIdentifier(String newUniqueIdentifier) {
		String oldUniqueIdentifier = uniqueIdentifier;
		uniqueIdentifier = newUniqueIdentifier;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__UNIQUE_IDENTIFIER,
					oldUniqueIdentifier, uniqueIdentifier));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<MDMIBusinessElementRule> getBusinessRules() {
		if (businessRules == null) {
			businessRules = new EObjectContainmentWithInverseEList<>(
				MDMIBusinessElementRule.class, this, MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__BUSINESS_RULES,
				MDMIPackage.MDMI_BUSINESS_ELEMENT_RULE__BUSINESS_ELEMENT);
		}
		return businessRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIDomainDictionaryReference getDomainDictionaryReference() {
		if (eContainerFeatureID() != MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE) {
			return null;
		}
		return (MDMIDomainDictionaryReference) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetDomainDictionaryReference(
			MDMIDomainDictionaryReference newDomainDictionaryReference, NotificationChain msgs) {
		msgs = eBasicSetContainer(
			(InternalEObject) newDomainDictionaryReference,
			MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDomainDictionaryReference(MDMIDomainDictionaryReference newDomainDictionaryReference) {
		if (newDomainDictionaryReference != eInternalContainer() ||
				(eContainerFeatureID() != MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE &&
						newDomainDictionaryReference != null)) {
			if (EcoreUtil.isAncestor(this, newDomainDictionaryReference)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newDomainDictionaryReference != null) {
				msgs = ((InternalEObject) newDomainDictionaryReference).eInverseAdd(
					this, MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__BUSINESS_ELEMENTS,
					MDMIDomainDictionaryReference.class, msgs);
			}
			msgs = basicSetDomainDictionaryReference(newDomainDictionaryReference, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE,
					newDomainDictionaryReference, newDomainDictionaryReference));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIDatatype getReferenceDatatype() {
		return referenceDatatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setReferenceDatatype(MDMIDatatype newReferenceDatatype) {
		MDMIDatatype oldReferenceDatatype = referenceDatatype;
		referenceDatatype = newReferenceDatatype;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE_DATATYPE,
					oldReferenceDatatype, referenceDatatype));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getEnumValueSetField() {
		return enumValueSetField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setEnumValueSetField(String newEnumValueSetField) {
		String oldEnumValueSetField = enumValueSetField;
		enumValueSetField = newEnumValueSetField;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET_FIELD,
					oldEnumValueSetField, enumValueSetField));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getEnumValueField() {
		return enumValueField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setEnumValueField(String newEnumValueField) {
		String oldEnumValueField = enumValueField;
		enumValueField = newEnumValueField;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_FIELD,
					oldEnumValueField, enumValueField));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getEnumValueDescrField() {
		return enumValueDescrField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setEnumValueDescrField(String newEnumValueDescrField) {
		String oldEnumValueDescrField = enumValueDescrField;
		enumValueDescrField = newEnumValueDescrField;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_DESCR_FIELD,
					oldEnumValueDescrField, enumValueDescrField));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getEnumValueSet() {
		return enumValueSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setEnumValueSet(String newEnumValueSet) {
		String oldEnumValueSet = enumValueSet;
		enumValueSet = newEnumValueSet;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET,
					oldEnumValueSet, enumValueSet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Boolean getReadonly() {
		return readonly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setReadonly(Boolean newReadonly) {
		Boolean oldReadonly = readonly;
		readonly = newReadonly;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__READONLY, oldReadonly,
					readonly));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__BUSINESS_RULES:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getBusinessRules()).basicAdd(
					otherEnd, msgs);
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
				return basicSetDomainDictionaryReference((MDMIDomainDictionaryReference) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__BUSINESS_RULES:
				return ((InternalEList<?>) getBusinessRules()).basicRemove(otherEnd, msgs);
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE:
				return basicSetDomainDictionaryReference(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE:
				return eInternalContainer().eInverseRemove(
					this, MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__BUSINESS_ELEMENTS,
					MDMIDomainDictionaryReference.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__NAME:
				return getName();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DESCRIPTION:
				return getDescription();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE:
				return getReference();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__UNIQUE_IDENTIFIER:
				return getUniqueIdentifier();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__BUSINESS_RULES:
				return getBusinessRules();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE:
				return getDomainDictionaryReference();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE_DATATYPE:
				return getReferenceDatatype();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET_FIELD:
				return getEnumValueSetField();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_FIELD:
				return getEnumValueField();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_DESCR_FIELD:
				return getEnumValueDescrField();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET:
				return getEnumValueSet();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__READONLY:
				return getReadonly();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE:
				setReference((String) newValue);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__UNIQUE_IDENTIFIER:
				setUniqueIdentifier((String) newValue);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__BUSINESS_RULES:
				getBusinessRules().clear();
				getBusinessRules().addAll((Collection<? extends MDMIBusinessElementRule>) newValue);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE:
				setDomainDictionaryReference((MDMIDomainDictionaryReference) newValue);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE_DATATYPE:
				setReferenceDatatype((MDMIDatatype) newValue);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET_FIELD:
				setEnumValueSetField((String) newValue);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_FIELD:
				setEnumValueField((String) newValue);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_DESCR_FIELD:
				setEnumValueDescrField((String) newValue);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET:
				setEnumValueSet((String) newValue);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__READONLY:
				setReadonly((Boolean) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__UNIQUE_IDENTIFIER:
				setUniqueIdentifier(UNIQUE_IDENTIFIER_EDEFAULT);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__BUSINESS_RULES:
				getBusinessRules().clear();
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE:
				setDomainDictionaryReference((MDMIDomainDictionaryReference) null);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE_DATATYPE:
				setReferenceDatatype((MDMIDatatype) null);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET_FIELD:
				setEnumValueSetField(ENUM_VALUE_SET_FIELD_EDEFAULT);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_FIELD:
				setEnumValueField(ENUM_VALUE_FIELD_EDEFAULT);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_DESCR_FIELD:
				setEnumValueDescrField(ENUM_VALUE_DESCR_FIELD_EDEFAULT);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET:
				setEnumValueSet(ENUM_VALUE_SET_EDEFAULT);
				return;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__READONLY:
				setReadonly(READONLY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE:
				return REFERENCE_EDEFAULT == null
						? reference != null
						: !REFERENCE_EDEFAULT.equals(reference);
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__UNIQUE_IDENTIFIER:
				return UNIQUE_IDENTIFIER_EDEFAULT == null
						? uniqueIdentifier != null
						: !UNIQUE_IDENTIFIER_EDEFAULT.equals(uniqueIdentifier);
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__BUSINESS_RULES:
				return businessRules != null && !businessRules.isEmpty();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE:
				return getDomainDictionaryReference() != null;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE_DATATYPE:
				return referenceDatatype != null;
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET_FIELD:
				return ENUM_VALUE_SET_FIELD_EDEFAULT == null
						? enumValueSetField != null
						: !ENUM_VALUE_SET_FIELD_EDEFAULT.equals(enumValueSetField);
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_FIELD:
				return ENUM_VALUE_FIELD_EDEFAULT == null
						? enumValueField != null
						: !ENUM_VALUE_FIELD_EDEFAULT.equals(enumValueField);
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_DESCR_FIELD:
				return ENUM_VALUE_DESCR_FIELD_EDEFAULT == null
						? enumValueDescrField != null
						: !ENUM_VALUE_DESCR_FIELD_EDEFAULT.equals(enumValueDescrField);
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET:
				return ENUM_VALUE_SET_EDEFAULT == null
						? enumValueSet != null
						: !ENUM_VALUE_SET_EDEFAULT.equals(enumValueSet);
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__READONLY:
				return READONLY_EDEFAULT == null
						? readonly != null
						: !READONLY_EDEFAULT.equals(readonly);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", reference: ");
		result.append(reference);
		result.append(", uniqueIdentifier: ");
		result.append(uniqueIdentifier);
		result.append(", enumValueSetField: ");
		result.append(enumValueSetField);
		result.append(", enumValueField: ");
		result.append(enumValueField);
		result.append(", enumValueDescrField: ");
		result.append(enumValueDescrField);
		result.append(", enumValueSet: ");
		result.append(enumValueSet);
		result.append(", readonly: ");
		result.append(readonly);
		result.append(')');
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.MDMIBusinessElementReference#getParent()
	 */
	@Override
	public MDMIBusinessElementReference getParent() {
		// TODO Auto-generated method stub
		return null;
	}

} // MDMIBusinessElementReferenceImpl
