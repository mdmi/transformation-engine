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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.mdmi.DatatypeMap;
import org.mdmi.MDMIDatatype;
import org.mdmi.MDMIPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Datatype Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.DatatypeMapImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.DatatypeMapImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.DatatypeMapImpl#getFromMDMI <em>From MDMI</em>}</li>
 * <li>{@link org.mdmi.impl.DatatypeMapImpl#getToMDMI <em>To MDMI</em>}</li>
 * <li>{@link org.mdmi.impl.DatatypeMapImpl#getMdmiDatatype <em>Mdmi Datatype</em>}</li>
 * <li>{@link org.mdmi.impl.DatatypeMapImpl#getMessageDatatype <em>Message Datatype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DatatypeMapImpl extends EObjectImpl implements DatatypeMap {
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
	 * The default value of the '{@link #getFromMDMI() <em>From MDMI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getFromMDMI()
	 * @generated
	 * @ordered
	 */
	protected static final String FROM_MDMI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFromMDMI() <em>From MDMI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getFromMDMI()
	 * @generated
	 * @ordered
	 */
	protected String fromMDMI = FROM_MDMI_EDEFAULT;

	/**
	 * The default value of the '{@link #getToMDMI() <em>To MDMI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getToMDMI()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_MDMI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToMDMI() <em>To MDMI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getToMDMI()
	 * @generated
	 * @ordered
	 */
	protected String toMDMI = TO_MDMI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMdmiDatatype() <em>Mdmi Datatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMdmiDatatype()
	 * @generated
	 * @ordered
	 */
	protected MDMIDatatype mdmiDatatype;

	/**
	 * The cached value of the '{@link #getMessageDatatype() <em>Message Datatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMessageDatatype()
	 * @generated
	 * @ordered
	 */
	protected MDMIDatatype messageDatatype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected DatatypeMapImpl() {
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
		return MDMIPackage.Literals.DATATYPE_MAP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.DATATYPE_MAP__NAME, oldName, name));
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
					this, Notification.SET, MDMIPackage.DATATYPE_MAP__DESCRIPTION, oldDescription, description));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getFromMDMI() {
		return fromMDMI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setFromMDMI(String newFromMDMI) {
		String oldFromMDMI = fromMDMI;
		fromMDMI = newFromMDMI;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.DATATYPE_MAP__FROM_MDMI, oldFromMDMI, fromMDMI));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getToMDMI() {
		return toMDMI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setToMDMI(String newToMDMI) {
		String oldToMDMI = toMDMI;
		toMDMI = newToMDMI;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(this, Notification.SET, MDMIPackage.DATATYPE_MAP__TO_MDMI, oldToMDMI, toMDMI));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIDatatype getMdmiDatatype() {
		if (mdmiDatatype != null && mdmiDatatype.eIsProxy()) {
			InternalEObject oldMdmiDatatype = (InternalEObject) mdmiDatatype;
			mdmiDatatype = (MDMIDatatype) eResolveProxy(oldMdmiDatatype);
			if (mdmiDatatype != oldMdmiDatatype) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE, MDMIPackage.DATATYPE_MAP__MDMI_DATATYPE, oldMdmiDatatype,
							mdmiDatatype));
				}
			}
		}
		return mdmiDatatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MDMIDatatype basicGetMdmiDatatype() {
		return mdmiDatatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMdmiDatatype(MDMIDatatype newMdmiDatatype) {
		MDMIDatatype oldMdmiDatatype = mdmiDatatype;
		mdmiDatatype = newMdmiDatatype;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.DATATYPE_MAP__MDMI_DATATYPE, oldMdmiDatatype, mdmiDatatype));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIDatatype getMessageDatatype() {
		if (messageDatatype != null && messageDatatype.eIsProxy()) {
			InternalEObject oldMessageDatatype = (InternalEObject) messageDatatype;
			messageDatatype = (MDMIDatatype) eResolveProxy(oldMessageDatatype);
			if (messageDatatype != oldMessageDatatype) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE, MDMIPackage.DATATYPE_MAP__MESSAGE_DATATYPE, oldMessageDatatype,
							messageDatatype));
				}
			}
		}
		return messageDatatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MDMIDatatype basicGetMessageDatatype() {
		return messageDatatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMessageDatatype(MDMIDatatype newMessageDatatype) {
		MDMIDatatype oldMessageDatatype = messageDatatype;
		messageDatatype = newMessageDatatype;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.DATATYPE_MAP__MESSAGE_DATATYPE, oldMessageDatatype,
					messageDatatype));
		}
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
			case MDMIPackage.DATATYPE_MAP__NAME:
				return getName();
			case MDMIPackage.DATATYPE_MAP__DESCRIPTION:
				return getDescription();
			case MDMIPackage.DATATYPE_MAP__FROM_MDMI:
				return getFromMDMI();
			case MDMIPackage.DATATYPE_MAP__TO_MDMI:
				return getToMDMI();
			case MDMIPackage.DATATYPE_MAP__MDMI_DATATYPE:
				if (resolve) {
					return getMdmiDatatype();
				}
				return basicGetMdmiDatatype();
			case MDMIPackage.DATATYPE_MAP__MESSAGE_DATATYPE:
				if (resolve) {
					return getMessageDatatype();
				}
				return basicGetMessageDatatype();
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
			case MDMIPackage.DATATYPE_MAP__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.DATATYPE_MAP__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.DATATYPE_MAP__FROM_MDMI:
				setFromMDMI((String) newValue);
				return;
			case MDMIPackage.DATATYPE_MAP__TO_MDMI:
				setToMDMI((String) newValue);
				return;
			case MDMIPackage.DATATYPE_MAP__MDMI_DATATYPE:
				setMdmiDatatype((MDMIDatatype) newValue);
				return;
			case MDMIPackage.DATATYPE_MAP__MESSAGE_DATATYPE:
				setMessageDatatype((MDMIDatatype) newValue);
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
			case MDMIPackage.DATATYPE_MAP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.DATATYPE_MAP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.DATATYPE_MAP__FROM_MDMI:
				setFromMDMI(FROM_MDMI_EDEFAULT);
				return;
			case MDMIPackage.DATATYPE_MAP__TO_MDMI:
				setToMDMI(TO_MDMI_EDEFAULT);
				return;
			case MDMIPackage.DATATYPE_MAP__MDMI_DATATYPE:
				setMdmiDatatype((MDMIDatatype) null);
				return;
			case MDMIPackage.DATATYPE_MAP__MESSAGE_DATATYPE:
				setMessageDatatype((MDMIDatatype) null);
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
			case MDMIPackage.DATATYPE_MAP__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.DATATYPE_MAP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.DATATYPE_MAP__FROM_MDMI:
				return FROM_MDMI_EDEFAULT == null
						? fromMDMI != null
						: !FROM_MDMI_EDEFAULT.equals(fromMDMI);
			case MDMIPackage.DATATYPE_MAP__TO_MDMI:
				return TO_MDMI_EDEFAULT == null
						? toMDMI != null
						: !TO_MDMI_EDEFAULT.equals(toMDMI);
			case MDMIPackage.DATATYPE_MAP__MDMI_DATATYPE:
				return mdmiDatatype != null;
			case MDMIPackage.DATATYPE_MAP__MESSAGE_DATATYPE:
				return messageDatatype != null;
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
		result.append(", fromMDMI: ");
		result.append(fromMDMI);
		result.append(", toMDMI: ");
		result.append(toMDMI);
		result.append(')');
		return result.toString();
	}

} // DatatypeMapImpl
