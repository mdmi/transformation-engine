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
 * A representation of the model object '<em><b>Conversion Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * ConversionRule is an abstract class that defines a rule used to convert values.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.ConversionRule#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.ConversionRule#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.ConversionRule#getRuleExpressionLanguage <em>Rule Expression Language</em>}</li>
 * <li>{@link org.mdmi.ConversionRule#getEnumExtResolverUri <em>Enum Ext Resolver Uri</em>}</li>
 * <li>{@link org.mdmi.ConversionRule#getBusinessElement <em>Business Element</em>}</li>
 * <li>{@link org.mdmi.ConversionRule#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getConversionRule()
 * @model
 * @generated
 */
public interface ConversionRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "name" property of type String that names the ConversionRule.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.mdmi.MDMIPackage#getConversionRule_Name()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.ConversionRule#getName <em>Name</em>}' attribute.
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
	 * The optional "description" property of type String describes the ToBusinessElement.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getConversionRule_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.ConversionRule#getDescription <em>Description</em>}' attribute.
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
	 * Returns the value of the '<em><b>Rule Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "ruleExpressionLanguage" property whose value is a reference to the expression language used to define the rule. This scope of the language
	 * allowed in conversions should be limited so that only very straightforward transformations are possible. This is because these ConversionRules
	 * can be used to define the semantic distance between business elements in a central dictionary by identifying "near synonyms". It is important
	 * that the "near synonyms do not turn out to be far synonyms.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Rule Expression Language</em>' attribute.
	 * @see #setRuleExpressionLanguage(String)
	 * @see org.mdmi.MDMIPackage#getConversionRule_RuleExpressionLanguage()
	 * @model ordered="false"
	 * @generated
	 */
	String getRuleExpressionLanguage();

	/**
	 * Sets the value of the '{@link org.mdmi.ConversionRule#getRuleExpressionLanguage <em>Rule Expression Language</em>}' attribute.
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
	 * Returns the value of the '<em><b>Enum Ext Resolver Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "ruleExpressionLanguage" property whose value is a reference to the expression language used to define the rule. This scope of the language
	 * allowed in conversions should be limited so that only very straightforward transformations are possible. This is because these ConversionRules
	 * can be used to define the semantic distance between business elements in a central dictionary by identifying "near synonyms". It is important
	 * that the "near synonyms do not turn out to be far synonyms.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Enum Ext Resolver Uri</em>' attribute.
	 * @see #setEnumExtResolverUri(String)
	 * @see org.mdmi.MDMIPackage#getConversionRule_EnumExtResolverUri()
	 * @model ordered="false"
	 * @generated
	 */
	String getEnumExtResolverUri();

	/**
	 * Sets the value of the '{@link org.mdmi.ConversionRule#getEnumExtResolverUri <em>Enum Ext Resolver Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Enum Ext Resolver Uri</em>' attribute.
	 * @see #getEnumExtResolverUri()
	 * @generated
	 */
	void setEnumExtResolverUri(String value);

	/**
	 * Returns the value of the '<em><b>Business Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Business Element</em>' reference.
	 * @see #setBusinessElement(MDMIBusinessElementReference)
	 * @see org.mdmi.MDMIPackage#getConversionRule_BusinessElement()
	 * @model resolveProxies="false" required="true" ordered="false"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	MDMIBusinessElementReference getBusinessElement();

	/**
	 * Sets the value of the '{@link org.mdmi.ConversionRule#getBusinessElement <em>Business Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Business Element</em>' reference.
	 * @see #getBusinessElement()
	 * @generated
	 */
	void setBusinessElement(MDMIBusinessElementReference value);

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "rule" property of type String that holds an expression for converting one value to another.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Rule</em>' attribute.
	 * @see #setRule(String)
	 * @see org.mdmi.MDMIPackage#getConversionRule_Rule()
	 * @model ordered="false"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	String getRule();

	/**
	 * Sets the value of the '{@link org.mdmi.ConversionRule#getRule <em>Rule</em>}' attribute.
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
	 * @return
	 */
	SemanticElement getOwner();

} // ConversionRule
