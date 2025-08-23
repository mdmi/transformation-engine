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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.mdmi.Bag;
import org.mdmi.MDMIPackage;
import org.mdmi.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.BagImpl#isIsUnique <em>Is Unique</em>}</li>
 * <li>{@link org.mdmi.impl.BagImpl#isIsOrdered <em>Is Ordered</em>}</li>
 * <li>{@link org.mdmi.impl.BagImpl#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BagImpl extends NodeImpl implements Bag {

	boolean hasMDMIExpressions = false;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.impl.NodeImpl#getCompletePath()
	 */
	@Override
	public String getCompletePath() {
		return super.getCompletePath();
	}

	/**
	 * The default value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNIQUE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean isUnique = IS_UNIQUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected boolean isOrdered = IS_ORDERED_EDEFAULT;

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
	protected BagImpl() {
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
		return MDMIPackage.Literals.BAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isIsUnique() {
		return isUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setIsUnique(boolean newIsUnique) {
		boolean oldIsUnique = isUnique;
		isUnique = newIsUnique;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.BAG__IS_UNIQUE, oldIsUnique, isUnique));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isIsOrdered() {
		return isOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setIsOrdered(boolean newIsOrdered) {
		boolean oldIsOrdered = isOrdered;
		isOrdered = newIsOrdered;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(this, Notification.SET, MDMIPackage.BAG__IS_ORDERED, oldIsOrdered, isOrdered));
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
			nodes = new EObjectContainmentEList<>(Node.class, this, MDMIPackage.BAG__NODES);
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
			case MDMIPackage.BAG__NODES:
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
			case MDMIPackage.BAG__IS_UNIQUE:
				return isIsUnique();
			case MDMIPackage.BAG__IS_ORDERED:
				return isIsOrdered();
			case MDMIPackage.BAG__NODES:
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
			case MDMIPackage.BAG__IS_UNIQUE:
				setIsUnique((Boolean) newValue);
				return;
			case MDMIPackage.BAG__IS_ORDERED:
				setIsOrdered((Boolean) newValue);
				return;
			case MDMIPackage.BAG__NODES:
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
			case MDMIPackage.BAG__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case MDMIPackage.BAG__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case MDMIPackage.BAG__NODES:
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
			case MDMIPackage.BAG__IS_UNIQUE:
				return isUnique != IS_UNIQUE_EDEFAULT;
			case MDMIPackage.BAG__IS_ORDERED:
				return isOrdered != IS_ORDERED_EDEFAULT;
			case MDMIPackage.BAG__NODES:
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
		result.append(" (isUnique: ");
		result.append(isUnique);
		result.append(", isOrdered: ");
		result.append(isOrdered);
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
	 * @see org.mdmi.Bag#getNode(java.lang.String)
	 */
	@Override
	public Node getNode(String key) {
		if (key == null) {
			return null;
		}
		for (Node node : getNodes()) {
			if (key.equals(node.getName())) {
				return node;
			}
		}
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

		synchronized (this) {

			if (nodes == null) {
				nodes = new EObjectContainmentEList<>(Node.class, this, MDMIPackage.BAG__NODES);
			}
			if (nodeHash.isEmpty()) {
				for (Node node : nodes) {

					String key = node.getLocation();

					if ("MDMI".equals(node.getLocationExpressionLanguage())) {
						hasMDMIExpressions = true;
						String[] locations = key.split(Pattern.quote("|"));
						for (String location : locations) {

							location = location.trim();

							if (location.endsWith("#")) {
								location = location.replace("#", "");
							}

							if (location.startsWith("^")) {
								location = location.replace("^", "").toUpperCase();
							}

							if (!nodeHash.containsKey(location)) {
								nodeHash.put(location, new ArrayList<>());
							}
							nodeHash.get(location).add(node);
						}

						// if (key.endsWith("#")) {
						// key = key.replace("#", "");
						// }
						// hasMDMIExpressions = true;
						//
						// if (key.contains("|")) {
						// String[] locations = key.split(Pattern.quote("|"));
						// for (String location : locations) {
						// if (!nodeHash.containsKey(location)) {
						// nodeHash.put(location, new ArrayList<Node>());
						// }
						// nodeHash.get(location).add(node);
						// }
						// } else {
						//
						// if (key.startsWith("^")) {
						// key = key.replace("^", "").toUpperCase();
						// }
						//
						// if (!nodeHash.containsKey(key)) {
						// nodeHash.put(key, new ArrayList<Node>());
						// }
						// nodeHash.get(key).add(node);
						// }
					} else {

						int start = key.indexOf("[");
						if (start > -1) {
							key = key.substring(0, start);
						}

						String[] keys = key.split("/");
						for (String k : keys) {
							if (!nodeHash.containsKey(k)) {
								nodeHash.put(k, new ArrayList<>());
							}
							nodeHash.get(k).add(node);
						}
					}

				}

			}

			if (nodeHash.containsKey(nodeName)) {
				return nodeHash.get(nodeName);
			} else {
				if (hasMDMIExpressions) {
					String mdmiNode = nodeName.replaceAll("\\d+$", "");
					if (nodeHash.containsKey(nodeName)) {
						return nodeHash.get(nodeName);
					} else if (nodeHash.containsKey(nodeName.toUpperCase())) {
						return nodeHash.get(nodeName.toUpperCase());
					} else if (nodeHash.containsKey(mdmiNode)) {
						return nodeHash.get(mdmiNode);
					} else if (nodeHash.containsKey(mdmiNode.toUpperCase())) {
						return nodeHash.get(mdmiNode.toUpperCase());
					}

				}
				return empty;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.Bag#getNodeByNode(org.mdmi.Node)
	 */
	@Override
	public Node getNodeByNode(Node node) {
		if (nodeset.isEmpty()) {
			nodeset.addAll(this.nodes);
		} else if (nodeset.size() != this.nodes.size()) {
			nodeset.clear();
			nodeset.addAll(this.nodes);
		}
		if (nodeset.contains(node)) {
			return node;
		}
		return null;
	}

	Set<Node> nodeset = Collections.synchronizedSet(new HashSet<Node>());

} // BagImpl
