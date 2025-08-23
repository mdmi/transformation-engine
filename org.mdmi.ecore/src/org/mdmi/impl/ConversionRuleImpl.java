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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.mdmi.ConversionRule;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MDMIPackage;
import org.mdmi.SemanticElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conversion Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.ConversionRuleImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.ConversionRuleImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.ConversionRuleImpl#getRuleExpressionLanguage <em>Rule Expression Language</em>}</li>
 * <li>{@link org.mdmi.impl.ConversionRuleImpl#getEnumExtResolverUri <em>Enum Ext Resolver Uri</em>}</li>
 * <li>{@link org.mdmi.impl.ConversionRuleImpl#getBusinessElement <em>Business Element</em>}</li>
 * <li>{@link org.mdmi.impl.ConversionRuleImpl#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConversionRuleImpl extends EObjectImpl implements ConversionRule {
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
	 * The default value of the '{@link #getRuleExpressionLanguage() <em>Rule Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRuleExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String RULE_EXPRESSION_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRuleExpressionLanguage() <em>Rule Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRuleExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected String ruleExpressionLanguage = RULE_EXPRESSION_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnumExtResolverUri() <em>Enum Ext Resolver Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumExtResolverUri()
	 * @generated
	 * @ordered
	 */
	protected static final String ENUM_EXT_RESOLVER_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnumExtResolverUri() <em>Enum Ext Resolver Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumExtResolverUri()
	 * @generated
	 * @ordered
	 */
	protected String enumExtResolverUri = ENUM_EXT_RESOLVER_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBusinessElement() <em>Business Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getBusinessElement()
	 * @generated
	 * @ordered
	 */
	protected MDMIBusinessElementReference businessElement;

	/**
	 * The default value of the '{@link #getRule() <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected static final String RULE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRule() <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected String rule = RULE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ConversionRuleImpl() {
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
		return MDMIPackage.Literals.CONVERSION_RULE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.CONVERSION_RULE__NAME, oldName, name));
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
					this, Notification.SET, MDMIPackage.CONVERSION_RULE__DESCRIPTION, oldDescription, description));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getRuleExpressionLanguage() {
		return ruleExpressionLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setRuleExpressionLanguage(String newRuleExpressionLanguage) {
		String oldRuleExpressionLanguage = ruleExpressionLanguage;
		ruleExpressionLanguage = newRuleExpressionLanguage;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.CONVERSION_RULE__RULE_EXPRESSION_LANGUAGE,
					oldRuleExpressionLanguage, ruleExpressionLanguage));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getEnumExtResolverUri() {
		return enumExtResolverUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setEnumExtResolverUri(String newEnumExtResolverUri) {
		String oldEnumExtResolverUri = enumExtResolverUri;
		enumExtResolverUri = newEnumExtResolverUri;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.CONVERSION_RULE__ENUM_EXT_RESOLVER_URI, oldEnumExtResolverUri,
					enumExtResolverUri));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIBusinessElementReference getBusinessElement() {
		return businessElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setBusinessElement(MDMIBusinessElementReference newBusinessElement) {
		MDMIBusinessElementReference oldBusinessElement = businessElement;
		businessElement = newBusinessElement;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.CONVERSION_RULE__BUSINESS_ELEMENT, oldBusinessElement,
					businessElement));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getRule() {
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setRule(String newRule) {
		String oldRule = rule;
		rule = newRule;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.CONVERSION_RULE__RULE, oldRule, rule));
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
			case MDMIPackage.CONVERSION_RULE__NAME:
				return getName();
			case MDMIPackage.CONVERSION_RULE__DESCRIPTION:
				return getDescription();
			case MDMIPackage.CONVERSION_RULE__RULE_EXPRESSION_LANGUAGE:
				return getRuleExpressionLanguage();
			case MDMIPackage.CONVERSION_RULE__ENUM_EXT_RESOLVER_URI:
				return getEnumExtResolverUri();
			case MDMIPackage.CONVERSION_RULE__BUSINESS_ELEMENT:
				return getBusinessElement();
			case MDMIPackage.CONVERSION_RULE__RULE:
				return getRule();
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
			case MDMIPackage.CONVERSION_RULE__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.CONVERSION_RULE__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.CONVERSION_RULE__RULE_EXPRESSION_LANGUAGE:
				setRuleExpressionLanguage((String) newValue);
				return;
			case MDMIPackage.CONVERSION_RULE__ENUM_EXT_RESOLVER_URI:
				setEnumExtResolverUri((String) newValue);
				return;
			case MDMIPackage.CONVERSION_RULE__BUSINESS_ELEMENT:
				setBusinessElement((MDMIBusinessElementReference) newValue);
				return;
			case MDMIPackage.CONVERSION_RULE__RULE:
				setRule((String) newValue);
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
			case MDMIPackage.CONVERSION_RULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.CONVERSION_RULE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.CONVERSION_RULE__RULE_EXPRESSION_LANGUAGE:
				setRuleExpressionLanguage(RULE_EXPRESSION_LANGUAGE_EDEFAULT);
				return;
			case MDMIPackage.CONVERSION_RULE__ENUM_EXT_RESOLVER_URI:
				setEnumExtResolverUri(ENUM_EXT_RESOLVER_URI_EDEFAULT);
				return;
			case MDMIPackage.CONVERSION_RULE__BUSINESS_ELEMENT:
				setBusinessElement((MDMIBusinessElementReference) null);
				return;
			case MDMIPackage.CONVERSION_RULE__RULE:
				setRule(RULE_EDEFAULT);
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
			case MDMIPackage.CONVERSION_RULE__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.CONVERSION_RULE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.CONVERSION_RULE__RULE_EXPRESSION_LANGUAGE:
				return RULE_EXPRESSION_LANGUAGE_EDEFAULT == null
						? ruleExpressionLanguage != null
						: !RULE_EXPRESSION_LANGUAGE_EDEFAULT.equals(ruleExpressionLanguage);
			case MDMIPackage.CONVERSION_RULE__ENUM_EXT_RESOLVER_URI:
				return ENUM_EXT_RESOLVER_URI_EDEFAULT == null
						? enumExtResolverUri != null
						: !ENUM_EXT_RESOLVER_URI_EDEFAULT.equals(enumExtResolverUri);
			case MDMIPackage.CONVERSION_RULE__BUSINESS_ELEMENT:
				return businessElement != null;
			case MDMIPackage.CONVERSION_RULE__RULE:
				return RULE_EDEFAULT == null
						? rule != null
						: !RULE_EDEFAULT.equals(rule);
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
		result.append(", ruleExpressionLanguage: ");
		result.append(ruleExpressionLanguage);
		result.append(", enumExtResolverUri: ");
		result.append(enumExtResolverUri);
		result.append(", rule: ");
		result.append(rule);
		result.append(')');
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.ConversionRule#getOwner()
	 */
	@Override
	public SemanticElement getOwner() {
		return (SemanticElement) this.eContainer;
	}

} // ConversionRuleImpl
