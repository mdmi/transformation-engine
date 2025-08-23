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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.mdmi.ConversionRule;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MDMIPackage;
import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.mdmi.MessageSyntaxModel;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.MessageModelImpl#getMessageModelName <em>Message Model Name</em>}</li>
 * <li>{@link org.mdmi.impl.MessageModelImpl#getSyntaxModel <em>Syntax Model</em>}</li>
 * <li>{@link org.mdmi.impl.MessageModelImpl#getElementSet <em>Element Set</em>}</li>
 * <li>{@link org.mdmi.impl.MessageModelImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.MessageModelImpl#getSource <em>Source</em>}</li>
 * <li>{@link org.mdmi.impl.MessageModelImpl#getGroup <em>Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageModelImpl extends EObjectImpl implements MessageModel {
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
	 * The cached value of the '{@link #getSyntaxModel() <em>Syntax Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSyntaxModel()
	 * @generated
	 * @ordered
	 */
	protected MessageSyntaxModel syntaxModel;

	/**
	 * The cached value of the '{@link #getElementSet() <em>Element Set</em>}' containment reference.
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
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MessageModelImpl() {
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
		return MDMIPackage.Literals.MESSAGE_MODEL;
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
					this, Notification.SET, MDMIPackage.MESSAGE_MODEL__MESSAGE_MODEL_NAME, oldMessageModelName,
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
				this, Notification.SET, MDMIPackage.MESSAGE_MODEL__SYNTAX_MODEL, oldSyntaxModel, newSyntaxModel);
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
					this, MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL, MessageSyntaxModel.class, msgs);
			}
			if (newSyntaxModel != null) {
				msgs = ((InternalEObject) newSyntaxModel).eInverseAdd(
					this, MDMIPackage.MESSAGE_SYNTAX_MODEL__MODEL, MessageSyntaxModel.class, msgs);
			}
			msgs = basicSetSyntaxModel(newSyntaxModel, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_MODEL__SYNTAX_MODEL, newSyntaxModel, newSyntaxModel));
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
				this, Notification.SET, MDMIPackage.MESSAGE_MODEL__ELEMENT_SET, oldElementSet, newElementSet);
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
					this, MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL, SemanticElementSet.class, msgs);
			}
			if (newElementSet != null) {
				msgs = ((InternalEObject) newElementSet).eInverseAdd(
					this, MDMIPackage.SEMANTIC_ELEMENT_SET__MODEL, SemanticElementSet.class, msgs);
			}
			msgs = basicSetElementSet(newElementSet, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_MODEL__ELEMENT_SET, newElementSet, newElementSet));
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
					this, Notification.SET, MDMIPackage.MESSAGE_MODEL__DESCRIPTION, oldDescription, description));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(this, Notification.SET, MDMIPackage.MESSAGE_MODEL__SOURCE, oldSource, source));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MessageGroup getGroup() {
		if (eContainerFeatureID() != MDMIPackage.MESSAGE_MODEL__GROUP) {
			return null;
		}
		return (MessageGroup) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetGroup(MessageGroup newGroup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newGroup, MDMIPackage.MESSAGE_MODEL__GROUP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setGroup(MessageGroup newGroup) {
		if (newGroup != eInternalContainer() ||
				(eContainerFeatureID() != MDMIPackage.MESSAGE_MODEL__GROUP && newGroup != null)) {
			if (EcoreUtil.isAncestor(this, newGroup)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newGroup != null) {
				msgs = ((InternalEObject) newGroup).eInverseAdd(
					this, MDMIPackage.MESSAGE_GROUP__MODELS, MessageGroup.class, msgs);
			}
			msgs = basicSetGroup(newGroup, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(this, Notification.SET, MDMIPackage.MESSAGE_MODEL__GROUP, newGroup, newGroup));
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
			case MDMIPackage.MESSAGE_MODEL__SYNTAX_MODEL:
				if (syntaxModel != null) {
					msgs = ((InternalEObject) syntaxModel).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE - MDMIPackage.MESSAGE_MODEL__SYNTAX_MODEL, null, msgs);
				}
				return basicSetSyntaxModel((MessageSyntaxModel) otherEnd, msgs);
			case MDMIPackage.MESSAGE_MODEL__ELEMENT_SET:
				if (elementSet != null) {
					msgs = ((InternalEObject) elementSet).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE - MDMIPackage.MESSAGE_MODEL__ELEMENT_SET, null, msgs);
				}
				return basicSetElementSet((SemanticElementSet) otherEnd, msgs);
			case MDMIPackage.MESSAGE_MODEL__GROUP:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
				return basicSetGroup((MessageGroup) otherEnd, msgs);
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
			case MDMIPackage.MESSAGE_MODEL__SYNTAX_MODEL:
				return basicSetSyntaxModel(null, msgs);
			case MDMIPackage.MESSAGE_MODEL__ELEMENT_SET:
				return basicSetElementSet(null, msgs);
			case MDMIPackage.MESSAGE_MODEL__GROUP:
				return basicSetGroup(null, msgs);
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
			case MDMIPackage.MESSAGE_MODEL__GROUP:
				return eInternalContainer().eInverseRemove(
					this, MDMIPackage.MESSAGE_GROUP__MODELS, MessageGroup.class, msgs);
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
			case MDMIPackage.MESSAGE_MODEL__MESSAGE_MODEL_NAME:
				return getMessageModelName();
			case MDMIPackage.MESSAGE_MODEL__SYNTAX_MODEL:
				return getSyntaxModel();
			case MDMIPackage.MESSAGE_MODEL__ELEMENT_SET:
				return getElementSet();
			case MDMIPackage.MESSAGE_MODEL__DESCRIPTION:
				return getDescription();
			case MDMIPackage.MESSAGE_MODEL__SOURCE:
				return getSource();
			case MDMIPackage.MESSAGE_MODEL__GROUP:
				return getGroup();
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
			case MDMIPackage.MESSAGE_MODEL__MESSAGE_MODEL_NAME:
				setMessageModelName((String) newValue);
				return;
			case MDMIPackage.MESSAGE_MODEL__SYNTAX_MODEL:
				setSyntaxModel((MessageSyntaxModel) newValue);
				return;
			case MDMIPackage.MESSAGE_MODEL__ELEMENT_SET:
				setElementSet((SemanticElementSet) newValue);
				return;
			case MDMIPackage.MESSAGE_MODEL__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.MESSAGE_MODEL__SOURCE:
				setSource((String) newValue);
				return;
			case MDMIPackage.MESSAGE_MODEL__GROUP:
				setGroup((MessageGroup) newValue);
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
			case MDMIPackage.MESSAGE_MODEL__MESSAGE_MODEL_NAME:
				setMessageModelName(MESSAGE_MODEL_NAME_EDEFAULT);
				return;
			case MDMIPackage.MESSAGE_MODEL__SYNTAX_MODEL:
				setSyntaxModel((MessageSyntaxModel) null);
				return;
			case MDMIPackage.MESSAGE_MODEL__ELEMENT_SET:
				setElementSet((SemanticElementSet) null);
				return;
			case MDMIPackage.MESSAGE_MODEL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.MESSAGE_MODEL__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case MDMIPackage.MESSAGE_MODEL__GROUP:
				setGroup((MessageGroup) null);
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
			case MDMIPackage.MESSAGE_MODEL__MESSAGE_MODEL_NAME:
				return MESSAGE_MODEL_NAME_EDEFAULT == null
						? messageModelName != null
						: !MESSAGE_MODEL_NAME_EDEFAULT.equals(messageModelName);
			case MDMIPackage.MESSAGE_MODEL__SYNTAX_MODEL:
				return syntaxModel != null;
			case MDMIPackage.MESSAGE_MODEL__ELEMENT_SET:
				return elementSet != null;
			case MDMIPackage.MESSAGE_MODEL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.MESSAGE_MODEL__SOURCE:
				return SOURCE_EDEFAULT == null
						? source != null
						: !SOURCE_EDEFAULT.equals(source);
			case MDMIPackage.MESSAGE_MODEL__GROUP:
				return getGroup() != null;
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
		result.append(" (messageModelName: ");
		result.append(messageModelName);
		result.append(", description: ");
		result.append(description);
		result.append(", source: ");
		result.append(source);
		result.append(')');
		return result.toString();
	}

	/*
	 * @generated NOT
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.MessageModel#getBusinessElementHashMap()
	 */
	@Override
	public Map<String, MDMIBusinessElementReference> getBusinessElementHashMap() {
		// // public HashMap<String, MdmiBusinessElementReference> getBusinessElementHashMap() {
		Collection<SemanticElement> ses = this.elementSet.getSemanticElements();

		HashMap<String, MDMIBusinessElementReference> bers = new HashMap<>();
		for (Iterator<SemanticElement> it = ses.iterator(); it.hasNext();) {
			SemanticElement se = it.next();
			Collection<ConversionRule> toMdmi = se.getMapToMdmi();
			for (Iterator<ConversionRule> tm = toMdmi.iterator(); tm.hasNext();) {
				ConversionRule toME = tm.next();
				MDMIBusinessElementReference ber = toME.getBusinessElement();
				if (ber != null && null == bers.get(ber.getUniqueIdentifier())) {
					bers.put(ber.getUniqueIdentifier(), ber);
				}
			}
			Collection<ConversionRule> toBers = se.getMapFromMdmi();
			for (Iterator<ConversionRule> tb = toBers.iterator(); tb.hasNext();) {
				ConversionRule toBE = tb.next();
				MDMIBusinessElementReference ber = toBE.getBusinessElement();
				if (ber != null && null == bers.get(ber.getUniqueIdentifier())) {
					bers.put(ber.getUniqueIdentifier(), ber);
				}
			}
		}
		return bers;
		// // }
	}

} // MessageModelImpl
