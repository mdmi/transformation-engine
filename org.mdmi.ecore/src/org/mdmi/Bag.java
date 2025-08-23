/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * The Bag class represents a set of syntax nodes. They can be a set or a bag and can be ordered or unordered.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.Bag#isIsUnique <em>Is Unique</em>}</li>
 * <li>{@link org.mdmi.Bag#isIsOrdered <em>Is Ordered</em>}</li>
 * <li>{@link org.mdmi.Bag#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getBag()
 * @model
 * @generated
 */
public interface Bag extends Node {
	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * An "isUnique" Boolean property whose value is true if the set is composed of unique items and false if the set can contain duplicates.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(boolean)
	 * @see org.mdmi.MDMIPackage#getBag_IsUnique()
	 * @model default="true" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsUnique();

	/**
	 * Sets the value of the '{@link org.mdmi.Bag#isIsUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Is Unique</em>' attribute.
	 * @see #isIsUnique()
	 * @generated
	 */
	void setIsUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * An "isOrdered" Boolean property whose value is true if the nodes must be in an ordered sequence and false if the set can be unordered. This is
	 * needed information when inserting a value into a target message.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(boolean)
	 * @see org.mdmi.MDMIPackage#getBag_IsOrdered()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsOrdered();

	/**
	 * Sets the value of the '{@link org.mdmi.Bag#isIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #isIsOrdered()
	 * @generated
	 */
	void setIsOrdered(boolean value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getBag_Nodes()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * @param key
	 * @return
	 */
	Node getNode(String key);

	Node getNodeByNode(Node node);

} // Bag
