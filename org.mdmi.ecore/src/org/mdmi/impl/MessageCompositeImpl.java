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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.mdmi.MDMIPackage;
import org.mdmi.MessageComposite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.MessageCompositeImpl#getComposites <em>Composites</em>}</li>
 * <li>{@link org.mdmi.impl.MessageCompositeImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageCompositeImpl extends SimpleMessageCompositeImpl implements MessageComposite {
	/**
	 * The cached value of the '{@link #getComposites() <em>Composites</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getComposites()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageComposite> composites;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected MessageComposite owner;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MessageCompositeImpl() {
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
		return MDMIPackage.Literals.MESSAGE_COMPOSITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<MessageComposite> getComposites() {
		if (composites == null) {
			composites = new EObjectWithInverseResolvingEList<>(
				MessageComposite.class, this, MDMIPackage.MESSAGE_COMPOSITE__COMPOSITES,
				MDMIPackage.MESSAGE_COMPOSITE__OWNER);
		}
		return composites;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MessageComposite getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject) owner;
			owner = (MessageComposite) eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE, MDMIPackage.MESSAGE_COMPOSITE__OWNER, oldOwner, owner));
				}
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MessageComposite basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetOwner(MessageComposite newOwner, NotificationChain msgs) {
		MessageComposite oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.MESSAGE_COMPOSITE__OWNER, oldOwner, newOwner);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setOwner(MessageComposite newOwner) {
		if (newOwner != owner) {
			NotificationChain msgs = null;
			if (owner != null) {
				msgs = ((InternalEObject) owner).eInverseRemove(
					this, MDMIPackage.MESSAGE_COMPOSITE__COMPOSITES, MessageComposite.class, msgs);
			}
			if (newOwner != null) {
				msgs = ((InternalEObject) newOwner).eInverseAdd(
					this, MDMIPackage.MESSAGE_COMPOSITE__COMPOSITES, MessageComposite.class, msgs);
			}
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_COMPOSITE__OWNER, newOwner, newOwner));
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
			case MDMIPackage.MESSAGE_COMPOSITE__COMPOSITES:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getComposites()).basicAdd(otherEnd, msgs);
			case MDMIPackage.MESSAGE_COMPOSITE__OWNER:
				if (owner != null) {
					msgs = ((InternalEObject) owner).eInverseRemove(
						this, MDMIPackage.MESSAGE_COMPOSITE__COMPOSITES, MessageComposite.class, msgs);
				}
				return basicSetOwner((MessageComposite) otherEnd, msgs);
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
			case MDMIPackage.MESSAGE_COMPOSITE__COMPOSITES:
				return ((InternalEList<?>) getComposites()).basicRemove(otherEnd, msgs);
			case MDMIPackage.MESSAGE_COMPOSITE__OWNER:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MDMIPackage.MESSAGE_COMPOSITE__COMPOSITES:
				return getComposites();
			case MDMIPackage.MESSAGE_COMPOSITE__OWNER:
				if (resolve) {
					return getOwner();
				}
				return basicGetOwner();
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
			case MDMIPackage.MESSAGE_COMPOSITE__COMPOSITES:
				getComposites().clear();
				getComposites().addAll((Collection<? extends MessageComposite>) newValue);
				return;
			case MDMIPackage.MESSAGE_COMPOSITE__OWNER:
				setOwner((MessageComposite) newValue);
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
			case MDMIPackage.MESSAGE_COMPOSITE__COMPOSITES:
				getComposites().clear();
				return;
			case MDMIPackage.MESSAGE_COMPOSITE__OWNER:
				setOwner((MessageComposite) null);
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
			case MDMIPackage.MESSAGE_COMPOSITE__COMPOSITES:
				return composites != null && !composites.isEmpty();
			case MDMIPackage.MESSAGE_COMPOSITE__OWNER:
				return owner != null;
		}
		return super.eIsSet(featureID);
	}

} // MessageCompositeImpl
