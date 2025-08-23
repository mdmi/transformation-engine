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
 * A representation of the model object '<em><b>Message Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * The MessageGroup class contains a set of message models that are considered in the same grouping, e.g., SWIFT 15022 messages, SWIFT 20022 payment
 * messages, FIX security messages, etc.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.MessageGroup#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getDataRules <em>Data Rules</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getDefaultLocationExprLang <em>Default Location Expr Lang</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getDefaultConstraintExprLang <em>Default Constraint Expr Lang</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getDefaultRuleExprLang <em>Default Rule Expr Lang</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getDefaultFormatExpressionLanguage <em>Default Format Expression Language</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getDefaultOrderingExpressionLanguage <em>Default Ordering Expression Language</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getModels <em>Models</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getDomainDictionary <em>Domain Dictionary</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getDefaultMDMIExpresionLanguage <em>Default MDMI Expresion Language</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getRules <em>Rules</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getDatatypes <em>Datatypes</em>}</li>
 * <li>{@link org.mdmi.MessageGroup#getDatatypeMaps <em>Datatype Maps</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getMessageGroup()
 * @model
 * @generated
 */
public interface MessageGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The property "name." of type String, names the MessageGroup.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.mdmi.MDMIPackage#getMessageGroup_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageGroup#getName <em>Name</em>}' attribute.
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
	 * Returns the value of the '<em><b>Data Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.DataRule}.
	 * It is bidirectional and its opposite is '{@link org.mdmi.DataRule#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Data Rules</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getMessageGroup_DataRules()
	 * @see org.mdmi.DataRule#getScope
	 * @model opposite="scope" containment="true" ordered="false"
	 * @generated
	 */
	EList<DataRule> getDataRules();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The optional property "description" of type String provides a description of MessageGroup.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getMessageGroup_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageGroup#getDescription <em>Description</em>}' attribute.
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
	 * Returns the value of the '<em><b>Default Location Expr Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The property "locationExpressionLanguage" of type String identifies the location language to be used as a default for specifying location for
	 * all the messages in the MessageGroup. The value must be recognized by a runtime transformation application. The location of any field or
	 * sub-field in a message must be expressible in the chosen messagelocationExpressionLanguage. For example a location language for an XML message
	 * format would be "XPath 2.0".
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Default Location Expr Lang</em>' attribute.
	 * @see #setDefaultLocationExprLang(String)
	 * @see org.mdmi.MDMIPackage#getMessageGroup_DefaultLocationExprLang()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDefaultLocationExprLang();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageGroup#getDefaultLocationExprLang <em>Default Location Expr Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Default Location Expr Lang</em>' attribute.
	 * @see #getDefaultLocationExprLang()
	 * @generated
	 */
	void setDefaultLocationExprLang(String value);

	/**
	 * Returns the value of the '<em><b>Default Constraint Expr Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The property "constraintExpressionLanguage" of type String identifies the constraint language to be used as a default for specifying the
	 * constraints in the Choice class for all the messages in the MessageGroup. The constraintExpressionLanguage must be able to reference nodes. The
	 * language used in the reference implementation is NRL 1.0
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Default Constraint Expr Lang</em>' attribute.
	 * @see #setDefaultConstraintExprLang(String)
	 * @see org.mdmi.MDMIPackage#getMessageGroup_DefaultConstraintExprLang()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDefaultConstraintExprLang();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageGroup#getDefaultConstraintExprLang <em>Default Constraint Expr Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Default Constraint Expr Lang</em>' attribute.
	 * @see #getDefaultConstraintExprLang()
	 * @generated
	 */
	void setDefaultConstraintExprLang(String value);

	/**
	 * Returns the value of the '<em><b>Default Rule Expr Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The property "ruleExpressionLanguage" of type String identifies the rule language to be used as a default for specifying rules in all classes
	 * with the property "rule" for all the messages in the MessageGroup. This rule language must be able to access the values of any SemanticElement
	 * and thus it also must be able to access the fields in complex datatypes. The language used in the reference implementation is NRL 1.0
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Default Rule Expr Lang</em>' attribute.
	 * @see #setDefaultRuleExprLang(String)
	 * @see org.mdmi.MDMIPackage#getMessageGroup_DefaultRuleExprLang()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDefaultRuleExprLang();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageGroup#getDefaultRuleExprLang <em>Default Rule Expr Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Default Rule Expr Lang</em>' attribute.
	 * @see #getDefaultRuleExprLang()
	 * @generated
	 */
	void setDefaultRuleExprLang(String value);

	/**
	 * Returns the value of the '<em><b>Default Format Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The property "formatExpressionLanguage" of type String identifies the format language to be used as a default for specifying fornats in the
	 * LeafSyntaxTranslator class for all the messages in the MessageGroup. The formatExpressionLanguage must be able to describe fields as well as
	 * sub-fields, in particular the proper termination character for a field or sub-field. The languages used in the reference implementation are
	 * "XML datatypes" and "SWIFT regular expression format language"
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Default Format Expression Language</em>' attribute.
	 * @see #setDefaultFormatExpressionLanguage(String)
	 * @see org.mdmi.MDMIPackage#getMessageGroup_DefaultFormatExpressionLanguage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDefaultFormatExpressionLanguage();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageGroup#getDefaultFormatExpressionLanguage <em>Default Format Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Default Format Expression Language</em>' attribute.
	 * @see #getDefaultFormatExpressionLanguage()
	 * @generated
	 */
	void setDefaultFormatExpressionLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Default Ordering Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Ordering Expression Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Default Ordering Expression Language</em>' attribute.
	 * @see #setDefaultOrderingExpressionLanguage(String)
	 * @see org.mdmi.MDMIPackage#getMessageGroup_DefaultOrderingExpressionLanguage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDefaultOrderingExpressionLanguage();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageGroup#getDefaultOrderingExpressionLanguage <em>Default Ordering Expression Language</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Default Ordering Expression Language</em>' attribute.
	 * @see #getDefaultOrderingExpressionLanguage()
	 * @generated
	 */
	void setDefaultOrderingExpressionLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.MessageModel}.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MessageModel#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Models</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getMessageGroup_Models()
	 * @see org.mdmi.MessageModel#getGroup
	 * @model opposite="group" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<MessageModel> getModels();

	/**
	 * Returns the value of the '<em><b>Domain Dictionary</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MDMIDomainDictionaryReference#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Dictionary</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Domain Dictionary</em>' containment reference.
	 * @see #setDomainDictionary(MDMIDomainDictionaryReference)
	 * @see org.mdmi.MDMIPackage#getMessageGroup_DomainDictionary()
	 * @see org.mdmi.MDMIDomainDictionaryReference#getGroup
	 * @model opposite="group" containment="true" required="true" ordered="false"
	 * @generated
	 */
	MDMIDomainDictionaryReference getDomainDictionary();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageGroup#getDomainDictionary <em>Domain Dictionary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Domain Dictionary</em>' containment reference.
	 * @see #getDomainDictionary()
	 * @generated
	 */
	void setDomainDictionary(MDMIDomainDictionaryReference value);

	/**
	 * Returns the value of the '<em><b>Default MDMI Expresion Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default MDMI Expresion Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Default MDMI Expresion Language</em>' attribute.
	 * @see #setDefaultMDMIExpresionLanguage(String)
	 * @see org.mdmi.MDMIPackage#getMessageGroup_DefaultMDMIExpresionLanguage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDefaultMDMIExpresionLanguage();

	/**
	 * Sets the value of the '{@link org.mdmi.MessageGroup#getDefaultMDMIExpresionLanguage <em>Default MDMI Expresion Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Default MDMI Expresion Language</em>' attribute.
	 * @see #getDefaultMDMIExpresionLanguage()
	 * @generated
	 */
	void setDefaultMDMIExpresionLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' reference list.
	 * The list contents are of type {@link org.mdmi.DataRule}.
	 * It is bidirectional and its opposite is '{@link org.mdmi.DataRule#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Rules</em>' reference list.
	 * @see org.mdmi.MDMIPackage#getMessageGroup_Rules()
	 * @see org.mdmi.DataRule#getGroup
	 * @model opposite="group" ordered="false"
	 * @generated
	 */
	EList<DataRule> getRules();

	/**
	 * Returns the value of the '<em><b>Datatypes</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.MDMIDatatype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatypes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Datatypes</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getMessageGroup_Datatypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<MDMIDatatype> getDatatypes();

	/**
	 * Returns the value of the '<em><b>Datatype Maps</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.DatatypeMap}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatype Maps</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Datatype Maps</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getMessageGroup_DatatypeMaps()
	 * @model containment="true"
	 * @generated
	 */
	EList<DatatypeMap> getDatatypeMaps();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @model required="true" nameRequired="true"
	 * @generated
	 */
	MDMIDatatype getDatatype(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @model datatypeRequired="true"
	 * @generated
	 */
	void addDatatype(MDMIDatatype datatype);

	/**
	 * @param messageModel
	 * @return
	 */
	MessageModel getModel(String messageModel);

} // MessageGroup
