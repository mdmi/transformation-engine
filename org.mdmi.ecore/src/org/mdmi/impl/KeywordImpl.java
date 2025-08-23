/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.mdmi.Keyword;
import org.mdmi.MDMIPackage;
import org.mdmi.SemanticElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Keyword</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.KeywordImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.KeywordImpl#getKeyword <em>Keyword</em>}</li>
 * <li>{@link org.mdmi.impl.KeywordImpl#getKeywordValue <em>Keyword Value</em>}</li>
 * <li>{@link org.mdmi.impl.KeywordImpl#getReference <em>Reference</em>}</li>
 * <li>{@link org.mdmi.impl.KeywordImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class KeywordImpl extends EObjectImpl implements Keyword {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = "";

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
	 * The default value of the '{@link #getKeyword() <em>Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getKeyword()
	 * @generated
	 * @ordered
	 */
	protected static final String KEYWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeyword() <em>Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getKeyword()
	 * @generated
	 * @ordered
	 */
	protected String keyword = KEYWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeywordValue() <em>Keyword Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getKeywordValue()
	 * @generated
	 * @ordered
	 */
	protected static final String KEYWORD_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeywordValue() <em>Keyword Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getKeywordValue()
	 * @generated
	 * @ordered
	 */
	protected String keywordValue = KEYWORD_VALUE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected KeywordImpl() {
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
		return MDMIPackage.Literals.KEYWORD;
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
					this, Notification.SET, MDMIPackage.KEYWORD__DESCRIPTION, oldDescription, description));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getKeyword() {
		return keyword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setKeyword(String newKeyword) {
		String oldKeyword = keyword;
		keyword = newKeyword;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.KEYWORD__KEYWORD, oldKeyword, keyword));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getKeywordValue() {
		return keywordValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setKeywordValue(String newKeywordValue) {
		String oldKeywordValue = keywordValue;
		keywordValue = newKeywordValue;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.KEYWORD__KEYWORD_VALUE, oldKeywordValue, keywordValue));
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
				new ENotificationImpl(this, Notification.SET, MDMIPackage.KEYWORD__REFERENCE, oldReference, reference));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SemanticElement getOwner() {
		if (eContainerFeatureID() != MDMIPackage.KEYWORD__OWNER) {
			return null;
		}
		return (SemanticElement) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetOwner(SemanticElement newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newOwner, MDMIPackage.KEYWORD__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setOwner(SemanticElement newOwner) {
		if (newOwner != eInternalContainer() ||
				(eContainerFeatureID() != MDMIPackage.KEYWORD__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newOwner != null) {
				msgs = ((InternalEObject) newOwner).eInverseAdd(
					this, MDMIPackage.SEMANTIC_ELEMENT__KEYWORDS, SemanticElement.class, msgs);
			}
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.KEYWORD__OWNER, newOwner, newOwner));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MDMIPackage.KEYWORD__OWNER:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
				return basicSetOwner((SemanticElement) otherEnd, msgs);
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
			case MDMIPackage.KEYWORD__OWNER:
				return basicSetOwner(null, msgs);
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
			case MDMIPackage.KEYWORD__OWNER:
				return eInternalContainer().eInverseRemove(
					this, MDMIPackage.SEMANTIC_ELEMENT__KEYWORDS, SemanticElement.class, msgs);
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
			case MDMIPackage.KEYWORD__DESCRIPTION:
				return getDescription();
			case MDMIPackage.KEYWORD__KEYWORD:
				return getKeyword();
			case MDMIPackage.KEYWORD__KEYWORD_VALUE:
				return getKeywordValue();
			case MDMIPackage.KEYWORD__REFERENCE:
				return getReference();
			case MDMIPackage.KEYWORD__OWNER:
				return getOwner();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MDMIPackage.KEYWORD__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.KEYWORD__KEYWORD:
				setKeyword((String) newValue);
				return;
			case MDMIPackage.KEYWORD__KEYWORD_VALUE:
				setKeywordValue((String) newValue);
				return;
			case MDMIPackage.KEYWORD__REFERENCE:
				setReference((String) newValue);
				return;
			case MDMIPackage.KEYWORD__OWNER:
				setOwner((SemanticElement) newValue);
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
			case MDMIPackage.KEYWORD__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.KEYWORD__KEYWORD:
				setKeyword(KEYWORD_EDEFAULT);
				return;
			case MDMIPackage.KEYWORD__KEYWORD_VALUE:
				setKeywordValue(KEYWORD_VALUE_EDEFAULT);
				return;
			case MDMIPackage.KEYWORD__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case MDMIPackage.KEYWORD__OWNER:
				setOwner((SemanticElement) null);
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
			case MDMIPackage.KEYWORD__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.KEYWORD__KEYWORD:
				return KEYWORD_EDEFAULT == null
						? keyword != null
						: !KEYWORD_EDEFAULT.equals(keyword);
			case MDMIPackage.KEYWORD__KEYWORD_VALUE:
				return KEYWORD_VALUE_EDEFAULT == null
						? keywordValue != null
						: !KEYWORD_VALUE_EDEFAULT.equals(keywordValue);
			case MDMIPackage.KEYWORD__REFERENCE:
				return REFERENCE_EDEFAULT == null
						? reference != null
						: !REFERENCE_EDEFAULT.equals(reference);
			case MDMIPackage.KEYWORD__OWNER:
				return getOwner() != null;
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
		result.append(" (description: ");
		result.append(description);
		result.append(", keyword: ");
		result.append(keyword);
		result.append(", keywordValue: ");
		result.append(keywordValue);
		result.append(", reference: ");
		result.append(reference);
		result.append(')');
		return result.toString();
	}

} // KeywordImpl
