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
import org.mdmi.MDMIPackage;
import org.mdmi.MessageModel;
import org.mdmi.MessageSyntaxModel;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementSet;
import org.mdmi.SimpleMessageComposite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantic Element Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.SemanticElementSetImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementSetImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementSetImpl#getMessageModelName <em>Message Model Name</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementSetImpl#getSyntaxModel <em>Syntax Model</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementSetImpl#getModel <em>Model</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementSetImpl#getSemanticElements <em>Semantic Elements</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementSetImpl#getComposite <em>Composite</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticElementSetImpl extends EObjectImpl implements SemanticElementSet {
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
	 * The default value of the '{@link #getMessageModelName() <em>Message Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMessageModelName()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_MODEL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessageModelName() <em>Message Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMessageModelName()
	 * @generated
	 * @ordered
	 */
	protected String messageModelName = MESSAGE_MODEL_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSyntaxModel() <em>Syntax Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSyntaxModel()
	 * @generated
	 * @ordered
	 */
	protected MessageSyntaxModel syntaxModel;

	/**
	 * The cached value of the '{@link #getSemanticElements() <em>Semantic Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSemanticElements()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticElement> semanticElements;

	/**
	 * The cached value of the '{@link #getComposite() <em>Composite</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getComposite()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleMessageComposite> composite;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected SemanticElementSetImpl() {
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
		return MDMIPackage.Literals.SEMANTIC_ELEMENT_SET;
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
				new ENotificationImpl(this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_SET__NAME, oldName, name));
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
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_SET__DESCRIPTION, oldDescription,
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
	public String getMessageModelName() {
		return messageModelName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMessageModelName(String newMessageModelName) {
		String oldMessageModelName = messageModelName;
		messageModelName = newMessageModelName;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_SET__MESSAGE_MODEL_NAME, oldMessageModelName,
					messageModelName));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MessageSyntaxModel getSyntaxModel() {
		if (syntaxModel != null && syntaxModel.eIsProxy()) {
			InternalEObject oldSyntaxModel = (InternalEObject) syntaxModel;
			syntaxModel = (MessageSyntaxModel) eResolveProxy(oldSyntaxModel);
			if (syntaxModel != oldSyntaxModel) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE, MDMIPackage.SEMANTIC_ELEMENT_SET__SYNTAX_MODEL, oldSyntaxModel,
							syntaxModel));
				}
			}
		}
		return syntaxModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MessageSyntaxModel basicGetSyntaxModel() {
		return syntaxModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetSyntaxModel(MessageSyntaxModel newSyntaxModel, NotificationChain msgs) {
		MessageSyntaxModel oldSyntaxModel = syntaxModel;
		syntaxModel = newSyntaxModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_SET__SYNTAX_MODEL, oldSyntaxModel, newSyntaxModel);
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
	public void setSyntaxModel(MessageSyntaxModel newSyntaxModel) {
		if (newSyntaxModel != syntaxModel) {
			NotificationChain msgs = null;
			if (syntaxModel != null) {
				msgs = ((InternalEObject) syntaxModel).eInverseRemove(
					this, MDMIPackage.MESSAGE_SYNTAX_MODEL__ELEMENT_SET, MessageSyntaxModel.class, msgs);
			}
			if (newSyntaxModel != null) {
				msgs = ((InternalEObject) newSyntaxModel).eInverseAdd(
					this, MDMIPackage.MESSAGE_SYNTAX_MODEL__ELEMENT_SET, MessageSyntaxModel.class, msgs);
			}
			msgs = basicSetSyntaxModel(newSyntaxModel, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_SET__SYNTAX_MODEL, newSyntaxModel,
					newSyntaxModel));
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
		if (eContainerFeatureID() != MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL) {
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
		msgs = eBasicSetContainer((InternalEObject) newModel, MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL, msgs);
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
				(eContainerFeatureID() != MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL && newModel != null)) {
			if (EcoreUtil.isAncestor(this, newModel)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newModel != null) {
				msgs = ((InternalEObject) newModel).eInverseAdd(
					this, MDMIPackage.MESSAGE_MODEL__ELEMENT_SET, MessageModel.class, msgs);
			}
			msgs = basicSetModel(newModel, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL, newModel, newModel));
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
			semanticElements = new EObjectContainmentWithInverseEList<>(
				SemanticElement.class, this, MDMIPackage.SEMANTIC_ELEMENT_SET__SEMANTIC_ELEMENTS,
				MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_SET);
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
	public EList<SimpleMessageComposite> getComposite() {
		if (composite == null) {
			composite = new EObjectContainmentWithInverseEList<>(
				SimpleMessageComposite.class, this, MDMIPackage.SEMANTIC_ELEMENT_SET__COMPOSITE,
				MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET);
		}
		return composite;
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
			case MDMIPackage.SEMANTIC_ELEMENT_SET__SYNTAX_MODEL:
				if (syntaxModel != null) {
					msgs = ((InternalEObject) syntaxModel).eInverseRemove(
						this, MDMIPackage.MESSAGE_SYNTAX_MODEL__ELEMENT_SET, MessageSyntaxModel.class, msgs);
				}
				return basicSetSyntaxModel((MessageSyntaxModel) otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
				return basicSetModel((MessageModel) otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT_SET__SEMANTIC_ELEMENTS:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getSemanticElements()).basicAdd(
					otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT_SET__COMPOSITE:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getComposite()).basicAdd(otherEnd, msgs);
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
			case MDMIPackage.SEMANTIC_ELEMENT_SET__SYNTAX_MODEL:
				return basicSetSyntaxModel(null, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL:
				return basicSetModel(null, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT_SET__SEMANTIC_ELEMENTS:
				return ((InternalEList<?>) getSemanticElements()).basicRemove(otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT_SET__COMPOSITE:
				return ((InternalEList<?>) getComposite()).basicRemove(otherEnd, msgs);
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
			case MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL:
				return eInternalContainer().eInverseRemove(
					this, MDMIPackage.MESSAGE_MODEL__ELEMENT_SET, MessageModel.class, msgs);
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
			case MDMIPackage.SEMANTIC_ELEMENT_SET__NAME:
				return getName();
			case MDMIPackage.SEMANTIC_ELEMENT_SET__DESCRIPTION:
				return getDescription();
			case MDMIPackage.SEMANTIC_ELEMENT_SET__MESSAGE_MODEL_NAME:
				return getMessageModelName();
			case MDMIPackage.SEMANTIC_ELEMENT_SET__SYNTAX_MODEL:
				if (resolve) {
					return getSyntaxModel();
				}
				return basicGetSyntaxModel();
			case MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL:
				return getModel();
			case MDMIPackage.SEMANTIC_ELEMENT_SET__SEMANTIC_ELEMENTS:
				return getSemanticElements();
			case MDMIPackage.SEMANTIC_ELEMENT_SET__COMPOSITE:
				return getComposite();
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
			case MDMIPackage.SEMANTIC_ELEMENT_SET__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__MESSAGE_MODEL_NAME:
				setMessageModelName((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__SYNTAX_MODEL:
				setSyntaxModel((MessageSyntaxModel) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL:
				setModel((MessageModel) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__SEMANTIC_ELEMENTS:
				getSemanticElements().clear();
				getSemanticElements().addAll((Collection<? extends SemanticElement>) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__COMPOSITE:
				getComposite().clear();
				getComposite().addAll((Collection<? extends SimpleMessageComposite>) newValue);
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
			case MDMIPackage.SEMANTIC_ELEMENT_SET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__MESSAGE_MODEL_NAME:
				setMessageModelName(MESSAGE_MODEL_NAME_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__SYNTAX_MODEL:
				setSyntaxModel((MessageSyntaxModel) null);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL:
				setModel((MessageModel) null);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__SEMANTIC_ELEMENTS:
				getSemanticElements().clear();
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__COMPOSITE:
				getComposite().clear();
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
			case MDMIPackage.SEMANTIC_ELEMENT_SET__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.SEMANTIC_ELEMENT_SET__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.SEMANTIC_ELEMENT_SET__MESSAGE_MODEL_NAME:
				return MESSAGE_MODEL_NAME_EDEFAULT == null
						? messageModelName != null
						: !MESSAGE_MODEL_NAME_EDEFAULT.equals(messageModelName);
			case MDMIPackage.SEMANTIC_ELEMENT_SET__SYNTAX_MODEL:
				return syntaxModel != null;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL:
				return getModel() != null;
			case MDMIPackage.SEMANTIC_ELEMENT_SET__SEMANTIC_ELEMENTS:
				return semanticElements != null && !semanticElements.isEmpty();
			case MDMIPackage.SEMANTIC_ELEMENT_SET__COMPOSITE:
				return composite != null && !composite.isEmpty();
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
		result.append(", messageModelName: ");
		result.append(messageModelName);
		result.append(')');
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElementSet#getSemanticElement(java.lang.String)
	 */
	// @Override
	// public SemanticElement getSemanticElement(String name) {
	// for (SemanticElement semanticElement : this.semanticElements) {
	// if (semanticElement.getName() != null && semanticElement.getName().equals(name)) {
	// return semanticElement;
	//
	// }
	// }
	// return null;
	// }

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElementSet#getSemanticElement(org.mdmi.MDMIBusinessElementReference)
	 */
	@Override
	public SemanticElement getSemanticElement(MDMIBusinessElementReference name) {
		// TODO Auto-generated method stub
		return null;
	}

} // SemanticElementSetImpl
