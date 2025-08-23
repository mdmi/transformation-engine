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
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementBusinessRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantic Element Business Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.SemanticElementBusinessRuleImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementBusinessRuleImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementBusinessRuleImpl#getRule <em>Rule</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementBusinessRuleImpl#getRuleExpressionLanguage <em>Rule Expression Language</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementBusinessRuleImpl#getSemanticElement <em>Semantic Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticElementBusinessRuleImpl extends EObjectImpl implements SemanticElementBusinessRule {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected SemanticElementBusinessRuleImpl() {
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
		return MDMIPackage.Literals.SEMANTIC_ELEMENT_BUSINESS_RULE;
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
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__NAME, oldName, name));
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
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__DESCRIPTION, oldDescription,
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
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__RULE, oldRule, rule));
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
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__RULE_EXPRESSION_LANGUAGE,
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
	public SemanticElement getSemanticElement() {
		if (eContainerFeatureID() != MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT) {
			return null;
		}
		return (SemanticElement) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetSemanticElement(SemanticElement newSemanticElement, NotificationChain msgs) {
		msgs = eBasicSetContainer(
			(InternalEObject) newSemanticElement, MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSemanticElement(SemanticElement newSemanticElement) {
		if (newSemanticElement != eInternalContainer() ||
				(eContainerFeatureID() != MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT &&
						newSemanticElement != null)) {
			if (EcoreUtil.isAncestor(this, newSemanticElement)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newSemanticElement != null) {
				msgs = ((InternalEObject) newSemanticElement).eInverseAdd(
					this, MDMIPackage.SEMANTIC_ELEMENT__BUSINESS_RULES, SemanticElement.class, msgs);
			}
			msgs = basicSetSemanticElement(newSemanticElement, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT,
					newSemanticElement, newSemanticElement));
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
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
				return basicSetSemanticElement((SemanticElement) otherEnd, msgs);
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
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT:
				return basicSetSemanticElement(null, msgs);
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
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT:
				return eInternalContainer().eInverseRemove(
					this, MDMIPackage.SEMANTIC_ELEMENT__BUSINESS_RULES, SemanticElement.class, msgs);
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
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__NAME:
				return getName();
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__DESCRIPTION:
				return getDescription();
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__RULE:
				return getRule();
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__RULE_EXPRESSION_LANGUAGE:
				return getRuleExpressionLanguage();
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT:
				return getSemanticElement();
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
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__RULE:
				setRule((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__RULE_EXPRESSION_LANGUAGE:
				setRuleExpressionLanguage((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT:
				setSemanticElement((SemanticElement) newValue);
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
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__RULE:
				setRule(RULE_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__RULE_EXPRESSION_LANGUAGE:
				setRuleExpressionLanguage(RULE_EXPRESSION_LANGUAGE_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT:
				setSemanticElement((SemanticElement) null);
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
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__RULE:
				return RULE_EDEFAULT == null
						? rule != null
						: !RULE_EDEFAULT.equals(rule);
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__RULE_EXPRESSION_LANGUAGE:
				return RULE_EXPRESSION_LANGUAGE_EDEFAULT == null
						? ruleExpressionLanguage != null
						: !RULE_EXPRESSION_LANGUAGE_EDEFAULT.equals(ruleExpressionLanguage);
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT:
				return getSemanticElement() != null;
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
		result.append(", rule: ");
		result.append(rule);
		result.append(", ruleExpressionLanguage: ");
		result.append(ruleExpressionLanguage);
		result.append(')');
		return result.toString();
	}

} // SemanticElementBusinessRuleImpl
