/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.mdmi.LeafSyntaxTranslator;
import org.mdmi.MDMIPackage;
import org.mdmi.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Leaf Syntax Translator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.LeafSyntaxTranslatorImpl#getFormat <em>Format</em>}</li>
 * <li>{@link org.mdmi.impl.LeafSyntaxTranslatorImpl#getFormatExpressionLanguage <em>Format Expression Language</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LeafSyntaxTranslatorImpl extends NodeImpl implements LeafSyntaxTranslator {
	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormatExpressionLanguage() <em>Format Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getFormatExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EXPRESSION_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormatExpressionLanguage() <em>Format Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getFormatExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected String formatExpressionLanguage = FORMAT_EXPRESSION_LANGUAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected LeafSyntaxTranslatorImpl() {
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
		return MDMIPackage.Literals.LEAF_SYNTAX_TRANSLATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.LEAF_SYNTAX_TRANSLATOR__FORMAT, oldFormat, format));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getFormatExpressionLanguage() {
		return formatExpressionLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setFormatExpressionLanguage(String newFormatExpressionLanguage) {
		String oldFormatExpressionLanguage = formatExpressionLanguage;
		formatExpressionLanguage = newFormatExpressionLanguage;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.LEAF_SYNTAX_TRANSLATOR__FORMAT_EXPRESSION_LANGUAGE,
					oldFormatExpressionLanguage, formatExpressionLanguage));
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
			case MDMIPackage.LEAF_SYNTAX_TRANSLATOR__FORMAT:
				return getFormat();
			case MDMIPackage.LEAF_SYNTAX_TRANSLATOR__FORMAT_EXPRESSION_LANGUAGE:
				return getFormatExpressionLanguage();
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
			case MDMIPackage.LEAF_SYNTAX_TRANSLATOR__FORMAT:
				setFormat((String) newValue);
				return;
			case MDMIPackage.LEAF_SYNTAX_TRANSLATOR__FORMAT_EXPRESSION_LANGUAGE:
				setFormatExpressionLanguage((String) newValue);
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
			case MDMIPackage.LEAF_SYNTAX_TRANSLATOR__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case MDMIPackage.LEAF_SYNTAX_TRANSLATOR__FORMAT_EXPRESSION_LANGUAGE:
				setFormatExpressionLanguage(FORMAT_EXPRESSION_LANGUAGE_EDEFAULT);
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
			case MDMIPackage.LEAF_SYNTAX_TRANSLATOR__FORMAT:
				return FORMAT_EDEFAULT == null
						? format != null
						: !FORMAT_EDEFAULT.equals(format);
			case MDMIPackage.LEAF_SYNTAX_TRANSLATOR__FORMAT_EXPRESSION_LANGUAGE:
				return FORMAT_EXPRESSION_LANGUAGE_EDEFAULT == null
						? formatExpressionLanguage != null
						: !FORMAT_EXPRESSION_LANGUAGE_EDEFAULT.equals(formatExpressionLanguage);
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
		result.append(" (format: ");
		result.append(format);
		result.append(", formatExpressionLanguage: ");
		result.append(formatExpressionLanguage);
		result.append(')');
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.Node#getCardinality()
	 */
	@Override
	public Integer getCardinality() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.Node#isSingle()
	 */
	@Override
	public boolean isSingle() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.Node#isRequired()
	 */
	@Override
	public boolean isRequired() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.Node#getNodes()
	 */
	@Override
	public Iterable getNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.Node#getOriginalLocation()
	 */
	@Override
	public String getOriginalLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.Node#getNoden(java.lang.String)
	 */
	@Override
	public ArrayList<Node> getNodesByLocation(String nodeName) {
		// TODO Auto-generated method stub
		return null;
	}

} // LeafSyntaxTranslatorImpl
