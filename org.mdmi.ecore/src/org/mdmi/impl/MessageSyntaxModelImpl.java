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
import org.mdmi.MDMIPackage;
import org.mdmi.MessageModel;
import org.mdmi.MessageSyntaxModel;
import org.mdmi.Node;
import org.mdmi.SemanticElementSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Syntax Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.MessageSyntaxModelImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.MessageSyntaxModelImpl#getModel <em>Model</em>}</li>
 * <li>{@link org.mdmi.impl.MessageSyntaxModelImpl#getRoot <em>Root</em>}</li>
 * <li>{@link org.mdmi.impl.MessageSyntaxModelImpl#getElementSet <em>Element Set</em>}</li>
 * <li>{@link org.mdmi.impl.MessageSyntaxModelImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageSyntaxModelImpl extends EObjectImpl implements MessageSyntaxModel {
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
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected Node root;

	/**
	 * The cached value of the '{@link #getElementSet() <em>Element Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getElementSet()
	 * @generated
	 * @ordered
	 */
	protected SemanticElementSet elementSet;

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
	protected MessageSyntaxModelImpl() {
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
		return MDMIPackage.Literals.MESSAGE_SYNTAX_MODEL;
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
				new ENotificationImpl(this, Notification.SET, MDMIPackage.MESSAGE_SYNTAX_MODEL__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MessageModel getModel() {
		if (eContainerFeatureID() != MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL) {
			return null;
		}
		return (MessageModel) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetModel(MessageModel newModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newModel, MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setModel(MessageModel newModel) {
		if (newModel != eInternalContainer() ||
				(eContainerFeatureID() != MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL && newModel != null)) {
			if (EcoreUtil.isAncestor(this, newModel)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newModel != null) {
				msgs = ((InternalEObject) newModel).eInverseAdd(
					this, MDMIPackage.MESSAGE_MODEL__SYNTAX_MODEL, MessageModel.class, msgs);
			}
			msgs = basicSetModel(newModel, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL, newModel, newModel));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Node getRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetRoot(Node newRoot, NotificationChain msgs) {
		Node oldRoot = root;
		root = newRoot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.MESSAGE_SYNTAX_MODEL__ROOT, oldRoot, newRoot);
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
	public void setRoot(Node newRoot) {
		if (newRoot != root) {
			NotificationChain msgs = null;
			if (root != null) {
				msgs = ((InternalEObject) root).eInverseRemove(this, MDMIPackage.NODE__SYNTAX_MODEL, Node.class, msgs);
			}
			if (newRoot != null) {
				msgs = ((InternalEObject) newRoot).eInverseAdd(this, MDMIPackage.NODE__SYNTAX_MODEL, Node.class, msgs);
			}
			msgs = basicSetRoot(newRoot, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_SYNTAX_MODEL__ROOT, newRoot, newRoot));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SemanticElementSet getElementSet() {
		if (elementSet != null && elementSet.eIsProxy()) {
			InternalEObject oldElementSet = (InternalEObject) elementSet;
			elementSet = (SemanticElementSet) eResolveProxy(oldElementSet);
			if (elementSet != oldElementSet) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE, MDMIPackage.MESSAGE_SYNTAX_MODEL__ELEMENT_SET, oldElementSet,
							elementSet));
				}
			}
		}
		return elementSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public SemanticElementSet basicGetElementSet() {
		return elementSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetElementSet(SemanticElementSet newElementSet, NotificationChain msgs) {
		SemanticElementSet oldElementSet = elementSet;
		elementSet = newElementSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.MESSAGE_SYNTAX_MODEL__ELEMENT_SET, oldElementSet, newElementSet);
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
	public void setElementSet(SemanticElementSet newElementSet) {
		if (newElementSet != elementSet) {
			NotificationChain msgs = null;
			if (elementSet != null) {
				msgs = ((InternalEObject) elementSet).eInverseRemove(
					this, MDMIPackage.SEMANTIC_ELEMENT_SET__SYNTAX_MODEL, SemanticElementSet.class, msgs);
			}
			if (newElementSet != null) {
				msgs = ((InternalEObject) newElementSet).eInverseAdd(
					this, MDMIPackage.SEMANTIC_ELEMENT_SET__SYNTAX_MODEL, SemanticElementSet.class, msgs);
			}
			msgs = basicSetElementSet(newElementSet, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_SYNTAX_MODEL__ELEMENT_SET, newElementSet,
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
					this, Notification.SET, MDMIPackage.MESSAGE_SYNTAX_MODEL__DESCRIPTION, oldDescription,
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
				return basicSetModel((MessageModel) otherEnd, msgs);
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__ROOT:
				if (root != null) {
					msgs = ((InternalEObject) root).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE - MDMIPackage.MESSAGE_SYNTAX_MODEL__ROOT, null, msgs);
				}
				return basicSetRoot((Node) otherEnd, msgs);
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__ELEMENT_SET:
				if (elementSet != null) {
					msgs = ((InternalEObject) elementSet).eInverseRemove(
						this, MDMIPackage.SEMANTIC_ELEMENT_SET__SYNTAX_MODEL, SemanticElementSet.class, msgs);
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
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL:
				return basicSetModel(null, msgs);
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__ROOT:
				return basicSetRoot(null, msgs);
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__ELEMENT_SET:
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
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL:
				return eInternalContainer().eInverseRemove(
					this, MDMIPackage.MESSAGE_MODEL__SYNTAX_MODEL, MessageModel.class, msgs);
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
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__NAME:
				return getName();
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL:
				return getModel();
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__ROOT:
				return getRoot();
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__ELEMENT_SET:
				if (resolve) {
					return getElementSet();
				}
				return basicGetElementSet();
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__DESCRIPTION:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL:
				setModel((MessageModel) newValue);
				return;
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__ROOT:
				setRoot((Node) newValue);
				return;
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__ELEMENT_SET:
				setElementSet((SemanticElementSet) newValue);
				return;
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__DESCRIPTION:
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
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL:
				setModel((MessageModel) null);
				return;
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__ROOT:
				setRoot((Node) null);
				return;
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__ELEMENT_SET:
				setElementSet((SemanticElementSet) null);
				return;
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__DESCRIPTION:
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
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL:
				return getModel() != null;
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__ROOT:
				return root != null;
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__ELEMENT_SET:
				return elementSet != null;
			case MDMIPackage.MESSAGE_SYNTAX_MODEL__DESCRIPTION:
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

} // MessageSyntaxModelImpl
