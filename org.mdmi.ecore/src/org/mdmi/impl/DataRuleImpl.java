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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.mdmi.DataRule;
import org.mdmi.MDMIDatatype;
import org.mdmi.MDMIPackage;
import org.mdmi.MessageGroup;
import org.mdmi.SemanticElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.DataRuleImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.DataRuleImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.DataRuleImpl#getRule <em>Rule</em>}</li>
 * <li>{@link org.mdmi.impl.DataRuleImpl#getRuleExpressionLanguage <em>Rule Expression Language</em>}</li>
 * <li>{@link org.mdmi.impl.DataRuleImpl#getScope <em>Scope</em>}</li>
 * <li>{@link org.mdmi.impl.DataRuleImpl#getDatatype <em>Datatype</em>}</li>
 * <li>{@link org.mdmi.impl.DataRuleImpl#getSemanticElement <em>Semantic Element</em>}</li>
 * <li>{@link org.mdmi.impl.DataRuleImpl#getGroup <em>Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataRuleImpl extends EObjectImpl implements DataRule {
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
	 * The cached value of the '{@link #getDatatype() <em>Datatype</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDatatype()
	 * @generated
	 * @ordered
	 */
	protected EList<MDMIDatatype> datatype;

	/**
	 * The cached value of the '{@link #getSemanticElement() <em>Semantic Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSemanticElement()
	 * @generated
	 * @ordered
	 */
	protected SemanticElement semanticElement;

	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected MessageGroup group;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected DataRuleImpl() {
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
		return MDMIPackage.Literals.DATA_RULE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.DATA_RULE__NAME, oldName, name));
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
					this, Notification.SET, MDMIPackage.DATA_RULE__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.DATA_RULE__RULE, oldRule, rule));
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
					this, Notification.SET, MDMIPackage.DATA_RULE__RULE_EXPRESSION_LANGUAGE, oldRuleExpressionLanguage,
					ruleExpressionLanguage));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MessageGroup getScope() {
		if (eContainerFeatureID() != MDMIPackage.DATA_RULE__SCOPE) {
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
	public NotificationChain basicSetScope(MessageGroup newScope, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newScope, MDMIPackage.DATA_RULE__SCOPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setScope(MessageGroup newScope) {
		if (newScope != eInternalContainer() ||
				(eContainerFeatureID() != MDMIPackage.DATA_RULE__SCOPE && newScope != null)) {
			if (EcoreUtil.isAncestor(this, newScope)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newScope != null) {
				msgs = ((InternalEObject) newScope).eInverseAdd(
					this, MDMIPackage.MESSAGE_GROUP__DATA_RULES, MessageGroup.class, msgs);
			}
			msgs = basicSetScope(newScope, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.DATA_RULE__SCOPE, newScope, newScope));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<MDMIDatatype> getDatatype() {
		if (datatype == null) {
			datatype = new EObjectResolvingEList<>(MDMIDatatype.class, this, MDMIPackage.DATA_RULE__DATATYPE);
		}
		return datatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SemanticElement getSemanticElement() {
		if (semanticElement != null && semanticElement.eIsProxy()) {
			InternalEObject oldSemanticElement = (InternalEObject) semanticElement;
			semanticElement = (SemanticElement) eResolveProxy(oldSemanticElement);
			if (semanticElement != oldSemanticElement) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE, MDMIPackage.DATA_RULE__SEMANTIC_ELEMENT, oldSemanticElement,
							semanticElement));
				}
			}
		}
		return semanticElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public SemanticElement basicGetSemanticElement() {
		return semanticElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetSemanticElement(SemanticElement newSemanticElement, NotificationChain msgs) {
		SemanticElement oldSemanticElement = semanticElement;
		semanticElement = newSemanticElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.DATA_RULE__SEMANTIC_ELEMENT, oldSemanticElement,
				newSemanticElement);
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
	public void setSemanticElement(SemanticElement newSemanticElement) {
		if (newSemanticElement != semanticElement) {
			NotificationChain msgs = null;
			if (semanticElement != null) {
				msgs = ((InternalEObject) semanticElement).eInverseRemove(
					this, MDMIPackage.SEMANTIC_ELEMENT__DATA_RULES, SemanticElement.class, msgs);
			}
			if (newSemanticElement != null) {
				msgs = ((InternalEObject) newSemanticElement).eInverseAdd(
					this, MDMIPackage.SEMANTIC_ELEMENT__DATA_RULES, SemanticElement.class, msgs);
			}
			msgs = basicSetSemanticElement(newSemanticElement, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.DATA_RULE__SEMANTIC_ELEMENT, newSemanticElement,
					newSemanticElement));
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
		if (group != null && group.eIsProxy()) {
			InternalEObject oldGroup = (InternalEObject) group;
			group = (MessageGroup) eResolveProxy(oldGroup);
			if (group != oldGroup) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE, MDMIPackage.DATA_RULE__GROUP, oldGroup, group));
				}
			}
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MessageGroup basicGetGroup() {
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetGroup(MessageGroup newGroup, NotificationChain msgs) {
		MessageGroup oldGroup = group;
		group = newGroup;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.DATA_RULE__GROUP, oldGroup, newGroup);
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
	public void setGroup(MessageGroup newGroup) {
		if (newGroup != group) {
			NotificationChain msgs = null;
			if (group != null) {
				msgs = ((InternalEObject) group).eInverseRemove(
					this, MDMIPackage.MESSAGE_GROUP__RULES, MessageGroup.class, msgs);
			}
			if (newGroup != null) {
				msgs = ((InternalEObject) newGroup).eInverseAdd(
					this, MDMIPackage.MESSAGE_GROUP__RULES, MessageGroup.class, msgs);
			}
			msgs = basicSetGroup(newGroup, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.DATA_RULE__GROUP, newGroup, newGroup));
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
			case MDMIPackage.DATA_RULE__SCOPE:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
				return basicSetScope((MessageGroup) otherEnd, msgs);
			case MDMIPackage.DATA_RULE__SEMANTIC_ELEMENT:
				if (semanticElement != null) {
					msgs = ((InternalEObject) semanticElement).eInverseRemove(
						this, MDMIPackage.SEMANTIC_ELEMENT__DATA_RULES, SemanticElement.class, msgs);
				}
				return basicSetSemanticElement((SemanticElement) otherEnd, msgs);
			case MDMIPackage.DATA_RULE__GROUP:
				if (group != null) {
					msgs = ((InternalEObject) group).eInverseRemove(
						this, MDMIPackage.MESSAGE_GROUP__RULES, MessageGroup.class, msgs);
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
			case MDMIPackage.DATA_RULE__SCOPE:
				return basicSetScope(null, msgs);
			case MDMIPackage.DATA_RULE__SEMANTIC_ELEMENT:
				return basicSetSemanticElement(null, msgs);
			case MDMIPackage.DATA_RULE__GROUP:
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
			case MDMIPackage.DATA_RULE__SCOPE:
				return eInternalContainer().eInverseRemove(
					this, MDMIPackage.MESSAGE_GROUP__DATA_RULES, MessageGroup.class, msgs);
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
			case MDMIPackage.DATA_RULE__NAME:
				return getName();
			case MDMIPackage.DATA_RULE__DESCRIPTION:
				return getDescription();
			case MDMIPackage.DATA_RULE__RULE:
				return getRule();
			case MDMIPackage.DATA_RULE__RULE_EXPRESSION_LANGUAGE:
				return getRuleExpressionLanguage();
			case MDMIPackage.DATA_RULE__SCOPE:
				return getScope();
			case MDMIPackage.DATA_RULE__DATATYPE:
				return getDatatype();
			case MDMIPackage.DATA_RULE__SEMANTIC_ELEMENT:
				if (resolve) {
					return getSemanticElement();
				}
				return basicGetSemanticElement();
			case MDMIPackage.DATA_RULE__GROUP:
				if (resolve) {
					return getGroup();
				}
				return basicGetGroup();
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
			case MDMIPackage.DATA_RULE__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.DATA_RULE__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.DATA_RULE__RULE:
				setRule((String) newValue);
				return;
			case MDMIPackage.DATA_RULE__RULE_EXPRESSION_LANGUAGE:
				setRuleExpressionLanguage((String) newValue);
				return;
			case MDMIPackage.DATA_RULE__SCOPE:
				setScope((MessageGroup) newValue);
				return;
			case MDMIPackage.DATA_RULE__DATATYPE:
				getDatatype().clear();
				getDatatype().addAll((Collection<? extends MDMIDatatype>) newValue);
				return;
			case MDMIPackage.DATA_RULE__SEMANTIC_ELEMENT:
				setSemanticElement((SemanticElement) newValue);
				return;
			case MDMIPackage.DATA_RULE__GROUP:
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
			case MDMIPackage.DATA_RULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.DATA_RULE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.DATA_RULE__RULE:
				setRule(RULE_EDEFAULT);
				return;
			case MDMIPackage.DATA_RULE__RULE_EXPRESSION_LANGUAGE:
				setRuleExpressionLanguage(RULE_EXPRESSION_LANGUAGE_EDEFAULT);
				return;
			case MDMIPackage.DATA_RULE__SCOPE:
				setScope((MessageGroup) null);
				return;
			case MDMIPackage.DATA_RULE__DATATYPE:
				getDatatype().clear();
				return;
			case MDMIPackage.DATA_RULE__SEMANTIC_ELEMENT:
				setSemanticElement((SemanticElement) null);
				return;
			case MDMIPackage.DATA_RULE__GROUP:
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
			case MDMIPackage.DATA_RULE__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.DATA_RULE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.DATA_RULE__RULE:
				return RULE_EDEFAULT == null
						? rule != null
						: !RULE_EDEFAULT.equals(rule);
			case MDMIPackage.DATA_RULE__RULE_EXPRESSION_LANGUAGE:
				return RULE_EXPRESSION_LANGUAGE_EDEFAULT == null
						? ruleExpressionLanguage != null
						: !RULE_EXPRESSION_LANGUAGE_EDEFAULT.equals(ruleExpressionLanguage);
			case MDMIPackage.DATA_RULE__SCOPE:
				return getScope() != null;
			case MDMIPackage.DATA_RULE__DATATYPE:
				return datatype != null && !datatype.isEmpty();
			case MDMIPackage.DATA_RULE__SEMANTIC_ELEMENT:
				return semanticElement != null;
			case MDMIPackage.DATA_RULE__GROUP:
				return group != null;
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

} // DataRuleImpl
