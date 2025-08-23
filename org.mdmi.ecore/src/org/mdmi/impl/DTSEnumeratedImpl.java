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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.mdmi.DTSEnumerated;
import org.mdmi.EnumerationLiteral;
import org.mdmi.MDMIPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DTS Enumerated</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.DTSEnumeratedImpl#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DTSEnumeratedImpl extends MDMIDatatypeImpl implements DTSEnumerated {
	/**
	 * The cached value of the '{@link #getLiterals() <em>Literals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumerationLiteral> literals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected DTSEnumeratedImpl() {
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
		return MDMIPackage.Literals.DTS_ENUMERATED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<EnumerationLiteral> getLiterals() {
		if (literals == null) {
			literals = new EObjectContainmentEList<>(
				EnumerationLiteral.class, this, MDMIPackage.DTS_ENUMERATED__LITERALS);
		}
		return literals;
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
			case MDMIPackage.DTS_ENUMERATED__LITERALS:
				return ((InternalEList<?>) getLiterals()).basicRemove(otherEnd, msgs);
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
			case MDMIPackage.DTS_ENUMERATED__LITERALS:
				return getLiterals();
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
			case MDMIPackage.DTS_ENUMERATED__LITERALS:
				getLiterals().clear();
				getLiterals().addAll((Collection<? extends EnumerationLiteral>) newValue);
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
			case MDMIPackage.DTS_ENUMERATED__LITERALS:
				getLiterals().clear();
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
			case MDMIPackage.DTS_ENUMERATED__LITERALS:
				return literals != null && !literals.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see org.mdmi.MDMIDatatype#isComplex()
	// */
	// @Override
	// public boolean isComplex() {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.mdmi.MDMIDatatype#getName()
	// */
	// @Override
	// public String getName() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.mdmi.MDMIDatatype#getField(java.lang.String)
	// */
	// @Override
	// public Field getField(String string) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.mdmi.MDMIDatatype#getFields()
	// */
	// @Override
	// public EList<Field> getFields() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.mdmi.MDMIDatatype#isStruct()
	// */
	// @Override
	// public boolean isStruct() {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.mdmi.MDMIDatatype#isChoice()
	// */
	// @Override
	// public boolean isChoice() {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.mdmi.MDMIDatatype#isSimple()
	// */
	// @Override
	// public boolean isSimple() {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.mdmi.MDMIDatatype#isPrimitive()
	// */
	// @Override
	// public boolean isPrimitive() {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.mdmi.MDMIDatatype#isDerived()
	// */
	// @Override
	// public boolean isDerived() {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.mdmi.MDMIDatatype#isExternal()
	// */
	// @Override
	// public boolean isExternal() {
	// // TODO Auto-generated method stub
	// return false;
	// }

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.DTSEnumerated#getLiteralByName(java.lang.String)
	 */
	@Override
	public Object getLiteralByName(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.DTSEnumerated#getLiteralByCode(java.lang.String)
	 */
	@Override
	public EnumerationLiteral getLiteralByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

} // DTSEnumeratedImpl
