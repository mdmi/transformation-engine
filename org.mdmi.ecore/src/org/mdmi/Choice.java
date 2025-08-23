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
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * The Choice class describes a conditional branch of the syntax tree for which a subset is present in any particular message. The subset is
 * determined by a constraint expression.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.Choice#getConstraint <em>Constraint</em>}</li>
 * <li>{@link org.mdmi.Choice#getConstraintExpressionLanguage <em>Constraint Expression Language</em>}</li>
 * <li>{@link org.mdmi.Choice#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getChoice()
 * @model
 * @generated
 */
public interface Choice extends Node {
	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "constraint" property whose value is an expression that can be used to determine which of the set of nodes should be in a physical message
	 * instance.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Constraint</em>' attribute.
	 * @see #setConstraint(String)
	 * @see org.mdmi.MDMIPackage#getChoice_Constraint()
	 * @model default="" ordered="false"
	 * @generated
	 */
	String getConstraint();

	/**
	 * Sets the value of the '{@link org.mdmi.Choice#getConstraint <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Constraint</em>' attribute.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(String value);

	/**
	 * Returns the value of the '<em><b>Constraint Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * An optional "constraintExpressionLanguage" of type String that is a references the language used in the Choice constraint property. The
	 * constraintExpressionLanguage must be able to reference nodes.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Constraint Expression Language</em>' attribute.
	 * @see #setConstraintExpressionLanguage(String)
	 * @see org.mdmi.MDMIPackage#getChoice_ConstraintExpressionLanguage()
	 * @model ordered="false"
	 * @generated
	 */
	String getConstraintExpressionLanguage();

	/**
	 * Sets the value of the '{@link org.mdmi.Choice#getConstraintExpressionLanguage <em>Constraint Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Constraint Expression Language</em>' attribute.
	 * @see #getConstraintExpressionLanguage()
	 * @generated
	 */
	void setConstraintExpressionLanguage(String value);

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
	 * @see org.mdmi.MDMIPackage#getChoice_Nodes()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * @param name
	 * @return
	 */
	Node getNode(String name);

} // Choice
