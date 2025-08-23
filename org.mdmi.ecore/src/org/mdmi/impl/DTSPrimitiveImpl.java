/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.impl;

import org.eclipse.emf.ecore.EClass;
import org.mdmi.DTSPrimitive;
import org.mdmi.MDMIPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DTS Primitive</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class DTSPrimitiveImpl extends MDMIDatatypeImpl implements DTSPrimitive {
	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.impl.MDMIDatatypeImpl#isPrimitive()
	 */
	@Override
	public boolean isPrimitive() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected DTSPrimitiveImpl() {
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
		return MDMIPackage.Literals.DTS_PRIMITIVE;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.impl.MDMIDatatypeImpl#isSimple()
	 */
	@Override
	public boolean isSimple() {
		return true;
	}

} // DTSPrimitiveImpl
