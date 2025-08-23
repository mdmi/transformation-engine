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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * The DataRule class contains a rule that is to be applied to an MDMIDatatype to ensure that values extracted or inserted are valid.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.DataRule#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.DataRule#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.DataRule#getRule <em>Rule</em>}</li>
 * <li>{@link org.mdmi.DataRule#getRuleExpressionLanguage <em>Rule Expression Language</em>}</li>
 * <li>{@link org.mdmi.DataRule#getScope <em>Scope</em>}</li>
 * <li>{@link org.mdmi.DataRule#getDatatype <em>Datatype</em>}</li>
 * <li>{@link org.mdmi.DataRule#getSemanticElement <em>Semantic Element</em>}</li>
 * <li>{@link org.mdmi.DataRule#getGroup <em>Group</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getDataRule()
 * @model
 * @generated
 */
public interface DataRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "name" property of type String whose value is the name of the DatatypeRule.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.mdmi.MDMIPackage#getDataRule_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.DataRule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * An optional "description" property of type String that describes the DatatypeRule.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getDataRule_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.DataRule#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "rule" property that holds an expression for a rule or constraint associated with an associated Datatype.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Rule</em>' attribute.
	 * @see #setRule(String)
	 * @see org.mdmi.MDMIPackage#getDataRule_Rule()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getRule();

	/**
	 * Sets the value of the '{@link org.mdmi.DataRule#getRule <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Rule</em>' attribute.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(String value);

	/**
	 * Returns the value of the '<em><b>Rule Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "ruleExpressionLanguage" that references the language in which the "rule" property is expressed. The standard does not require any particular
	 * rule language, but the language has to allow access to fields represented by simple datatype classes within a complex datatype.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Rule Expression Language</em>' attribute.
	 * @see #setRuleExpressionLanguage(String)
	 * @see org.mdmi.MDMIPackage#getDataRule_RuleExpressionLanguage()
	 * @model ordered="false"
	 * @generated
	 */
	String getRuleExpressionLanguage();

	/**
	 * Sets the value of the '{@link org.mdmi.DataRule#getRuleExpressionLanguage <em>Rule Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Rule Expression Language</em>' attribute.
	 * @see #getRuleExpressionLanguage()
	 * @generated
	 */
	void setRuleExpressionLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MessageGroup#getDataRules <em>Data Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Scope</em>' container reference.
	 * @see #setScope(MessageGroup)
	 * @see org.mdmi.MDMIPackage#getDataRule_Scope()
	 * @see org.mdmi.MessageGroup#getDataRules
	 * @model opposite="dataRules" required="true" transient="false" ordered="false"
	 * @generated
	 */
	MessageGroup getScope();

	/**
	 * Sets the value of the '{@link org.mdmi.DataRule#getScope <em>Scope</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Scope</em>' container reference.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(MessageGroup value);

	/**
	 * Returns the value of the '<em><b>Datatype</b></em>' reference list.
	 * The list contents are of type {@link org.mdmi.MDMIDatatype}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "datatype" property of type MDMIDatatype that explicitly identifies the datatypes that are referenced in the "rule". The "datatype" property
	 * is to assist in the parsing and runtime processing of complex data.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Datatype</em>' reference list.
	 * @see org.mdmi.MDMIPackage#getDataRule_Datatype()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<MDMIDatatype> getDatatype();

	/**
	 * Returns the value of the '<em><b>Semantic Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SemanticElement#getDataRules <em>Data Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Semantic Element</em>' reference.
	 * @see #setSemanticElement(SemanticElement)
	 * @see org.mdmi.MDMIPackage#getDataRule_SemanticElement()
	 * @see org.mdmi.SemanticElement#getDataRules
	 * @model opposite="dataRules" required="true" ordered="false"
	 * @generated
	 */
	SemanticElement getSemanticElement();

	/**
	 * Sets the value of the '{@link org.mdmi.DataRule#getSemanticElement <em>Semantic Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Semantic Element</em>' reference.
	 * @see #getSemanticElement()
	 * @generated
	 */
	void setSemanticElement(SemanticElement value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MessageGroup#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Group</em>' reference.
	 * @see #setGroup(MessageGroup)
	 * @see org.mdmi.MDMIPackage#getDataRule_Group()
	 * @see org.mdmi.MessageGroup#getRules
	 * @model opposite="rules" required="true" ordered="false"
	 * @generated
	 */
	MessageGroup getGroup();

	/**
	 * Sets the value of the '{@link org.mdmi.DataRule#getGroup <em>Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Group</em>' reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(MessageGroup value);

} // DataRule
