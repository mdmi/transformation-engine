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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.mdmi.Choice;
import org.mdmi.MDMIPackage;
import org.mdmi.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.ChoiceImpl#getConstraint <em>Constraint</em>}</li>
 * <li>{@link org.mdmi.impl.ChoiceImpl#getConstraintExpressionLanguage <em>Constraint Expression Language</em>}</li>
 * <li>{@link org.mdmi.impl.ChoiceImpl#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChoiceImpl extends NodeImpl implements Choice {
	/**
	 * The default value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTRAINT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected String constraint = CONSTRAINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getConstraintExpressionLanguage() <em>Constraint Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getConstraintExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTRAINT_EXPRESSION_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstraintExpressionLanguage() <em>Constraint Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getConstraintExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected String constraintExpressionLanguage = CONSTRAINT_EXPRESSION_LANGUAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ChoiceImpl() {
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
		return MDMIPackage.Literals.CHOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getConstraint() {
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setConstraint(String newConstraint) {
		String oldConstraint = constraint;
		constraint = newConstraint;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.CHOICE__CONSTRAINT, oldConstraint, constraint));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getConstraintExpressionLanguage() {
		return constraintExpressionLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setConstraintExpressionLanguage(String newConstraintExpressionLanguage) {
		String oldConstraintExpressionLanguage = constraintExpressionLanguage;
		constraintExpressionLanguage = newConstraintExpressionLanguage;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.CHOICE__CONSTRAINT_EXPRESSION_LANGUAGE,
					oldConstraintExpressionLanguage, constraintExpressionLanguage));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<>(Node.class, this, MDMIPackage.CHOICE__NODES);
		}
		return nodes;
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
			case MDMIPackage.CHOICE__NODES:
				return ((InternalEList<?>) getNodes()).basicRemove(otherEnd, msgs);
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
			case MDMIPackage.CHOICE__CONSTRAINT:
				return getConstraint();
			case MDMIPackage.CHOICE__CONSTRAINT_EXPRESSION_LANGUAGE:
				return getConstraintExpressionLanguage();
			case MDMIPackage.CHOICE__NODES:
				return getNodes();
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
			case MDMIPackage.CHOICE__CONSTRAINT:
				setConstraint((String) newValue);
				return;
			case MDMIPackage.CHOICE__CONSTRAINT_EXPRESSION_LANGUAGE:
				setConstraintExpressionLanguage((String) newValue);
				return;
			case MDMIPackage.CHOICE__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>) newValue);
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
			case MDMIPackage.CHOICE__CONSTRAINT:
				setConstraint(CONSTRAINT_EDEFAULT);
				return;
			case MDMIPackage.CHOICE__CONSTRAINT_EXPRESSION_LANGUAGE:
				setConstraintExpressionLanguage(CONSTRAINT_EXPRESSION_LANGUAGE_EDEFAULT);
				return;
			case MDMIPackage.CHOICE__NODES:
				getNodes().clear();
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
			case MDMIPackage.CHOICE__CONSTRAINT:
				return CONSTRAINT_EDEFAULT == null
						? constraint != null
						: !CONSTRAINT_EDEFAULT.equals(constraint);
			case MDMIPackage.CHOICE__CONSTRAINT_EXPRESSION_LANGUAGE:
				return CONSTRAINT_EXPRESSION_LANGUAGE_EDEFAULT == null
						? constraintExpressionLanguage != null
						: !CONSTRAINT_EXPRESSION_LANGUAGE_EDEFAULT.equals(constraintExpressionLanguage);
			case MDMIPackage.CHOICE__NODES:
				return nodes != null && !nodes.isEmpty();
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
		result.append(" (constraint: ");
		result.append(constraint);
		result.append(", constraintExpressionLanguage: ");
		result.append(constraintExpressionLanguage);
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
	 * @see org.mdmi.Choice#getNode(java.lang.String)
	 */
	@Override
	public Node getNode(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.Node#getNoden(java.lang.String)
	 */
	Map<String, ArrayList<Node>> nodeHash = Collections.synchronizedMap(new HashMap<String, ArrayList<Node>>());

	ArrayList<Node> empty = new ArrayList<>();

	@Override
	public ArrayList<Node> getNodesByLocation(String nodeName) {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<>(Node.class, this, MDMIPackage.BAG__NODES);
		}
		if (nodeHash.isEmpty()) {
			for (Node node : nodes) {

				String key = node.getLocation();
				int start = key.indexOf("[");
				if (start > -1) {
					key = key.substring(0, start);
				}
				if (!nodeHash.containsKey(key)) {
					nodeHash.put(key, new ArrayList<>());
				}
				nodeHash.get(key).add(node);
			}
		}

		if (nodeHash.containsKey(nodeName)) {
			return nodeHash.get(nodeName);
		} else {
			return empty;
		}

	}

} // ChoiceImpl
