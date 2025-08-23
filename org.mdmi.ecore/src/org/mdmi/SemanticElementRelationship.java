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
 * A representation of the model object '<em><b>Semantic Element Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * The SemanticElementRelationship class is a key artifact in the MDMI standard. It provides the context and dependency relationships for each
 * SemanticElement with other SemanticElements in the message. SemanticElementRelationship make it possible to extract and insert SemanticElement
 * values in a valid manner.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.SemanticElementRelationship#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.SemanticElementRelationship#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.SemanticElementRelationship#getRule <em>Rule</em>}</li>
 * <li>{@link org.mdmi.SemanticElementRelationship#getRuleExpressionLanguage <em>Rule Expression Language</em>}</li>
 * <li>{@link org.mdmi.SemanticElementRelationship#getContext <em>Context</em>}</li>
 * <li>{@link org.mdmi.SemanticElementRelationship#getMinOccurs <em>Min Occurs</em>}</li>
 * <li>{@link org.mdmi.SemanticElementRelationship#getMaxOccurs <em>Max Occurs</em>}</li>
 * <li>{@link org.mdmi.SemanticElementRelationship#isSourceIsInstance <em>Source Is Instance</em>}</li>
 * <li>{@link org.mdmi.SemanticElementRelationship#isTargetIsInstance <em>Target Is Instance</em>}</li>
 * <li>{@link org.mdmi.SemanticElementRelationship#getRelatedSemanticElement <em>Related Semantic Element</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getSemanticElementRelationship()
 * @model
 * @generated
 */
public interface SemanticElementRelationship extends EObject {
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
	 * @see org.mdmi.MDMIPackage#getSemanticElementRelationship_Name()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementRelationship#getName <em>Name</em>}' attribute.
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
	 * @see org.mdmi.MDMIPackage#getSemanticElementRelationship_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementRelationship#getDescription <em>Description</em>}' attribute.
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
	 * A "rule" property of type String that defines a relationship between a source SemanticElement and other SemanticElements in the
	 * SemanticElementSet.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Rule</em>' attribute.
	 * @see #setRule(String)
	 * @see org.mdmi.MDMIPackage#getSemanticElementRelationship_Rule()
	 * @model ordered="false"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	String getRule();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementRelationship#getRule <em>Rule</em>}' attribute.
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
	 * A "ruleExpressionLanguage" property of type String that contains a reference to the expression language used in the "rule" property. This rule
	 * language must be able to access the values of any SemanticElement and to that it must be able to access the fields in complex datatypes.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Rule Expression Language</em>' attribute.
	 * @see #setRuleExpressionLanguage(String)
	 * @see org.mdmi.MDMIPackage#getSemanticElementRelationship_RuleExpressionLanguage()
	 * @model ordered="false"
	 * @generated
	 */
	String getRuleExpressionLanguage();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementRelationship#getRuleExpressionLanguage <em>Rule Expression Language</em>}' attribute.
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
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(SemanticElement)
	 * @see org.mdmi.MDMIPackage#getSemanticElementRelationship_Context()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SemanticElement getContext();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementRelationship#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(SemanticElement value);

	/**
	 * Returns the value of the '<em><b>Min Occurs</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * "minOccurs" property of type integer, which says how many instances of the target at a minimum must be involved in the relationship.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Min Occurs</em>' attribute.
	 * @see #setMinOccurs(int)
	 * @see org.mdmi.MDMIPackage#getSemanticElementRelationship_MinOccurs()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getMinOccurs();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementRelationship#getMinOccurs <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Min Occurs</em>' attribute.
	 * @see #getMinOccurs()
	 * @generated
	 */
	void setMinOccurs(int value);

	/**
	 * Returns the value of the '<em><b>Max Occurs</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "maxOccurs" property of type integer, which says how many instances at most can be involved in the relationship.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Max Occurs</em>' attribute.
	 * @see #setMaxOccurs(int)
	 * @see org.mdmi.MDMIPackage#getSemanticElementRelationship_MaxOccurs()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getMaxOccurs();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementRelationship#getMaxOccurs <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Max Occurs</em>' attribute.
	 * @see #getMaxOccurs()
	 * @generated
	 */
	void setMaxOccurs(int value);

	/**
	 * Returns the value of the '<em><b>Source Is Instance</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "sourceIs Instance" property of type Boolean. When the sourceInstance is true, the defined relationship is for each Instance of the source
	 * SemanticElement. When the sourceInstance is false, the defined relationship is for the SemanticElement class as a whole. (The source
	 * SemanticElement owns the relationship by composition.)
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Source Is Instance</em>' attribute.
	 * @see #setSourceIsInstance(boolean)
	 * @see org.mdmi.MDMIPackage#getSemanticElementRelationship_SourceIsInstance()
	 * @model default="true" required="true" ordered="false"
	 * @generated
	 */
	boolean isSourceIsInstance();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementRelationship#isSourceIsInstance <em>Source Is Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Source Is Instance</em>' attribute.
	 * @see #isSourceIsInstance()
	 * @generated
	 */
	void setSourceIsInstance(boolean value);

	/**
	 * Returns the value of the '<em><b>Target Is Instance</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "targetIsInstance" property of type Boolean. When the targetIsInstance is true, the defined relationship is for each Instance of the target
	 * SemanticElement. When the targetIsInstance is false, the defined relationship is for the SemanticElement class as a whole.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Target Is Instance</em>' attribute.
	 * @see #setTargetIsInstance(boolean)
	 * @see org.mdmi.MDMIPackage#getSemanticElementRelationship_TargetIsInstance()
	 * @model default="true" required="true" ordered="false"
	 * @generated
	 */
	boolean isTargetIsInstance();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementRelationship#isTargetIsInstance <em>Target Is Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Target Is Instance</em>' attribute.
	 * @see #isTargetIsInstance()
	 * @generated
	 */
	void setTargetIsInstance(boolean value);

	/**
	 * Returns the value of the '<em><b>Related Semantic Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Semantic Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Related Semantic Element</em>' reference.
	 * @see #setRelatedSemanticElement(SemanticElement)
	 * @see org.mdmi.MDMIPackage#getSemanticElementRelationship_RelatedSemanticElement()
	 * @model required="true" ordered="false"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	SemanticElement getRelatedSemanticElement();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElementRelationship#getRelatedSemanticElement <em>Related Semantic Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Related Semantic Element</em>' reference.
	 * @see #getRelatedSemanticElement()
	 * @generated
	 */
	void setRelatedSemanticElement(SemanticElement value);

} // SemanticElementRelationship
