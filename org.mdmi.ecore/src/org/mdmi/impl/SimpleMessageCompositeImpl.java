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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.mdmi.MDMIPackage;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementSet;
import org.mdmi.SimpleMessageComposite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Message Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.SimpleMessageCompositeImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.SimpleMessageCompositeImpl#getSemanticElements <em>Semantic Elements</em>}</li>
 * <li>{@link org.mdmi.impl.SimpleMessageCompositeImpl#getElementSet <em>Element Set</em>}</li>
 * <li>{@link org.mdmi.impl.SimpleMessageCompositeImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleMessageCompositeImpl extends EObjectImpl implements SimpleMessageComposite {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * The cached value of the '{@link #getSemanticElements() <em>Semantic Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSemanticElements()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticElement> semanticElements;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected SimpleMessageCompositeImpl() {
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
		return MDMIPackage.Literals.SIMPLE_MESSAGE_COMPOSITE;
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
					this, Notification.SET, MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<SemanticElement> getSemanticElements() {
		if (semanticElements == null) {
			semanticElements = new EObjectWithInverseResolvingEList<>(
				SemanticElement.class, this, MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS,
				MDMIPackage.SEMANTIC_ELEMENT__COMPOSITE);
		}
		return semanticElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SemanticElementSet getElementSet() {
		if (eContainerFeatureID() != MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET) {
			return null;
		}
		return (SemanticElementSet) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetElementSet(SemanticElementSet newElementSet, NotificationChain msgs) {
		msgs = eBasicSetContainer(
			(InternalEObject) newElementSet, MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setElementSet(SemanticElementSet newElementSet) {
		if (newElementSet != eInternalContainer() ||
				(eContainerFeatureID() != MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET && newElementSet != null)) {
			if (EcoreUtil.isAncestor(this, newElementSet)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newElementSet != null) {
				msgs = ((InternalEObject) newElementSet).eInverseAdd(
					this, MDMIPackage.SEMANTIC_ELEMENT_SET__COMPOSITE, SemanticElementSet.class, msgs);
			}
			msgs = basicSetElementSet(newElementSet, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET, newElementSet,
					newElementSet));
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
					this, Notification.SET, MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__DESCRIPTION, oldDescription,
					description));
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
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getSemanticElements()).basicAdd(
					otherEnd, msgs);
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
				return basicSetElementSet((SemanticElementSet) otherEnd, msgs);
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
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS:
				return ((InternalEList<?>) getSemanticElements()).basicRemove(otherEnd, msgs);
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET:
				return basicSetElementSet(null, msgs);
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
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET:
				return eInternalContainer().eInverseRemove(
					this, MDMIPackage.SEMANTIC_ELEMENT_SET__COMPOSITE, SemanticElementSet.class, msgs);
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
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__NAME:
				return getName();
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS:
				return getSemanticElements();
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET:
				return getElementSet();
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__DESCRIPTION:
				return getDescription();
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
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS:
				getSemanticElements().clear();
				getSemanticElements().addAll((Collection<? extends SemanticElement>) newValue);
				return;
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET:
				setElementSet((SemanticElementSet) newValue);
				return;
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__DESCRIPTION:
				setDescription((String) newValue);
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
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS:
				getSemanticElements().clear();
				return;
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET:
				setElementSet((SemanticElementSet) null);
				return;
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS:
				return semanticElements != null && !semanticElements.isEmpty();
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET:
				return getElementSet() != null;
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
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
		result.append(')');
		return result.toString();
	}

} // SimpleMessageCompositeImpl
