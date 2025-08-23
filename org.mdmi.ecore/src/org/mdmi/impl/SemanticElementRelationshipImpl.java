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
import org.mdmi.MDMIPackage;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementRelationship;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantic Element Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.SemanticElementRelationshipImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementRelationshipImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementRelationshipImpl#getRule <em>Rule</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementRelationshipImpl#getRuleExpressionLanguage <em>Rule Expression Language</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementRelationshipImpl#getContext <em>Context</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementRelationshipImpl#getMinOccurs <em>Min Occurs</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementRelationshipImpl#getMaxOccurs <em>Max Occurs</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementRelationshipImpl#isSourceIsInstance <em>Source Is Instance</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementRelationshipImpl#isTargetIsInstance <em>Target Is Instance</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementRelationshipImpl#getRelatedSemanticElement <em>Related Semantic Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticElementRelationshipImpl extends EObjectImpl implements SemanticElementRelationship {
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
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected SemanticElement context;

	/**
	 * The default value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_OCCURS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected int minOccurs = MIN_OCCURS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_OCCURS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected int maxOccurs = MAX_OCCURS_EDEFAULT;

	/**
	 * The default value of the '{@link #isSourceIsInstance() <em>Source Is Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isSourceIsInstance()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SOURCE_IS_INSTANCE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isSourceIsInstance() <em>Source Is Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isSourceIsInstance()
	 * @generated
	 * @ordered
	 */
	protected boolean sourceIsInstance = SOURCE_IS_INSTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isTargetIsInstance() <em>Target Is Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isTargetIsInstance()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TARGET_IS_INSTANCE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isTargetIsInstance() <em>Target Is Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isTargetIsInstance()
	 * @generated
	 * @ordered
	 */
	protected boolean targetIsInstance = TARGET_IS_INSTANCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRelatedSemanticElement() <em>Related Semantic Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRelatedSemanticElement()
	 * @generated
	 * @ordered
	 */
	protected SemanticElement relatedSemanticElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected SemanticElementRelationshipImpl() {
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
		return MDMIPackage.Literals.SEMANTIC_ELEMENT_RELATIONSHIP;
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
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__NAME, oldName, name));
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
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__DESCRIPTION, oldDescription,
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
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RULE, oldRule, rule));
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
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RULE_EXPRESSION_LANGUAGE,
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
	public SemanticElement getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject) context;
			context = (SemanticElement) eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE, MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__CONTEXT, oldContext,
							context));
				}
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public SemanticElement basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setContext(SemanticElement newContext) {
		SemanticElement oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__CONTEXT, oldContext, context));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getMinOccurs() {
		return minOccurs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMinOccurs(int newMinOccurs) {
		int oldMinOccurs = minOccurs;
		minOccurs = newMinOccurs;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__MIN_OCCURS, oldMinOccurs,
					minOccurs));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getMaxOccurs() {
		return maxOccurs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMaxOccurs(int newMaxOccurs) {
		int oldMaxOccurs = maxOccurs;
		maxOccurs = newMaxOccurs;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__MAX_OCCURS, oldMaxOccurs,
					maxOccurs));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isSourceIsInstance() {
		return sourceIsInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSourceIsInstance(boolean newSourceIsInstance) {
		boolean oldSourceIsInstance = sourceIsInstance;
		sourceIsInstance = newSourceIsInstance;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__SOURCE_IS_INSTANCE,
					oldSourceIsInstance, sourceIsInstance));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isTargetIsInstance() {
		return targetIsInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setTargetIsInstance(boolean newTargetIsInstance) {
		boolean oldTargetIsInstance = targetIsInstance;
		targetIsInstance = newTargetIsInstance;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__TARGET_IS_INSTANCE,
					oldTargetIsInstance, targetIsInstance));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SemanticElement getRelatedSemanticElement() {
		if (relatedSemanticElement != null && relatedSemanticElement.eIsProxy()) {
			InternalEObject oldRelatedSemanticElement = (InternalEObject) relatedSemanticElement;
			relatedSemanticElement = (SemanticElement) eResolveProxy(oldRelatedSemanticElement);
			if (relatedSemanticElement != oldRelatedSemanticElement) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE,
							MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RELATED_SEMANTIC_ELEMENT,
							oldRelatedSemanticElement, relatedSemanticElement));
				}
			}
		}
		return relatedSemanticElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public SemanticElement basicGetRelatedSemanticElement() {
		return relatedSemanticElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setRelatedSemanticElement(SemanticElement newRelatedSemanticElement) {
		SemanticElement oldRelatedSemanticElement = relatedSemanticElement;
		relatedSemanticElement = newRelatedSemanticElement;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RELATED_SEMANTIC_ELEMENT,
					oldRelatedSemanticElement, relatedSemanticElement));
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
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__NAME:
				return getName();
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__DESCRIPTION:
				return getDescription();
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RULE:
				return getRule();
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RULE_EXPRESSION_LANGUAGE:
				return getRuleExpressionLanguage();
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__CONTEXT:
				if (resolve) {
					return getContext();
				}
				return basicGetContext();
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__MIN_OCCURS:
				return getMinOccurs();
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__MAX_OCCURS:
				return getMaxOccurs();
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__SOURCE_IS_INSTANCE:
				return isSourceIsInstance();
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__TARGET_IS_INSTANCE:
				return isTargetIsInstance();
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RELATED_SEMANTIC_ELEMENT:
				if (resolve) {
					return getRelatedSemanticElement();
				}
				return basicGetRelatedSemanticElement();
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
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RULE:
				setRule((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RULE_EXPRESSION_LANGUAGE:
				setRuleExpressionLanguage((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__CONTEXT:
				setContext((SemanticElement) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__MIN_OCCURS:
				setMinOccurs((Integer) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__MAX_OCCURS:
				setMaxOccurs((Integer) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__SOURCE_IS_INSTANCE:
				setSourceIsInstance((Boolean) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__TARGET_IS_INSTANCE:
				setTargetIsInstance((Boolean) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RELATED_SEMANTIC_ELEMENT:
				setRelatedSemanticElement((SemanticElement) newValue);
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
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RULE:
				setRule(RULE_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RULE_EXPRESSION_LANGUAGE:
				setRuleExpressionLanguage(RULE_EXPRESSION_LANGUAGE_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__CONTEXT:
				setContext((SemanticElement) null);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__MIN_OCCURS:
				setMinOccurs(MIN_OCCURS_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__MAX_OCCURS:
				setMaxOccurs(MAX_OCCURS_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__SOURCE_IS_INSTANCE:
				setSourceIsInstance(SOURCE_IS_INSTANCE_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__TARGET_IS_INSTANCE:
				setTargetIsInstance(TARGET_IS_INSTANCE_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RELATED_SEMANTIC_ELEMENT:
				setRelatedSemanticElement((SemanticElement) null);
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
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RULE:
				return RULE_EDEFAULT == null
						? rule != null
						: !RULE_EDEFAULT.equals(rule);
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RULE_EXPRESSION_LANGUAGE:
				return RULE_EXPRESSION_LANGUAGE_EDEFAULT == null
						? ruleExpressionLanguage != null
						: !RULE_EXPRESSION_LANGUAGE_EDEFAULT.equals(ruleExpressionLanguage);
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__CONTEXT:
				return context != null;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__MIN_OCCURS:
				return minOccurs != MIN_OCCURS_EDEFAULT;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__MAX_OCCURS:
				return maxOccurs != MAX_OCCURS_EDEFAULT;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__SOURCE_IS_INSTANCE:
				return sourceIsInstance != SOURCE_IS_INSTANCE_EDEFAULT;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__TARGET_IS_INSTANCE:
				return targetIsInstance != TARGET_IS_INSTANCE_EDEFAULT;
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP__RELATED_SEMANTIC_ELEMENT:
				return relatedSemanticElement != null;
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
		result.append(", minOccurs: ");
		result.append(minOccurs);
		result.append(", maxOccurs: ");
		result.append(maxOccurs);
		result.append(", sourceIsInstance: ");
		result.append(sourceIsInstance);
		result.append(", targetIsInstance: ");
		result.append(targetIsInstance);
		result.append(')');
		return result.toString();
	}

} // SemanticElementRelationshipImpl
