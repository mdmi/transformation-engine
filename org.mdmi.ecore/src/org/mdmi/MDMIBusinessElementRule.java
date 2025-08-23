/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business Element Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * Given that the MDMI standard does not provide a specification for a the hub dictionary and in effect allows mapping to any appropriate dictionary,
 * such as the ISO 20022 Data Dictionary, then some business rules may have to be specified to make sure that the mapping is correct. Instances of the
 * MDMIBusinessElementRule maintain these rules.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.MDMIBusinessElementRule#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementRule#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementRule#getRule <em>Rule</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementRule#getRuleExpressionLanguage <em>Rule Expression Language</em>}</li>
 * <li>{@link org.mdmi.MDMIBusinessElementRule#getBusinessElement <em>Business Element</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementRule()
 * @model
 * @generated
 */
public interface MDMIBusinessElementRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "name" property of type String that assigns a name to the rule.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementRule_Name()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementRule#getName <em>Name</em>}' attribute.
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
	 * An optional "description" property of type String that provides a description of the rule.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementRule_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementRule#getDescription <em>Description</em>}' attribute.
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
	 * A "rule" property of type String that is an expression defining the rule that applies to an associated MDMIBusinessElementReference.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Rule</em>' attribute.
	 * @see #setRule(String)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementRule_Rule()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getRule();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementRule#getRule <em>Rule</em>}' attribute.
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
	 * A "ruleExpressionLanguage", which provides a reference to the language used in the used for the "rule" property. This language must be able to
	 * describe the context in which the rule applies. The language should be able to reference the value of any Semantic Element instance and it
	 * should allow external function calls. If this property is not specified the default ruleExpressionLanguage will be used.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Rule Expression Language</em>' attribute.
	 * @see #setRuleExpressionLanguage(String)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementRule_RuleExpressionLanguage()
	 * @model ordered="false"
	 * @generated
	 */
	String getRuleExpressionLanguage();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementRule#getRuleExpressionLanguage <em>Rule Expression Language</em>}' attribute.
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
	 * Returns the value of the '<em><b>Business Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MDMIBusinessElementReference#getBusinessRules <em>Business Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Business Element</em>' container reference.
	 * @see #setBusinessElement(MDMIBusinessElementReference)
	 * @see org.mdmi.MDMIPackage#getMDMIBusinessElementRule_BusinessElement()
	 * @see org.mdmi.MDMIBusinessElementReference#getBusinessRules
	 * @model opposite="businessRules" required="true" transient="false" ordered="false"
	 * @generated
	 */
	MDMIBusinessElementReference getBusinessElement();

	/**
	 * Sets the value of the '{@link org.mdmi.MDMIBusinessElementRule#getBusinessElement <em>Business Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Business Element</em>' container reference.
	 * @see #getBusinessElement()
	 * @generated
	 */
	void setBusinessElement(MDMIBusinessElementReference value);

} // MDMIBusinessElementRule
