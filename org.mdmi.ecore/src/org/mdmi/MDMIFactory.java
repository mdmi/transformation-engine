/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @see org.mdmi.MDMIPackage
 * @generated
 */
public interface MDMIFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	MDMIFactory eINSTANCE = org.mdmi.impl.MDMIFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Message Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Message Model</em>'.
	 * @generated
	 */
	MessageModel createMessageModel();

	/**
	 * Returns a new object of class '<em>Message Syntax Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Message Syntax Model</em>'.
	 * @generated
	 */
	MessageSyntaxModel createMessageSyntaxModel();

	/**
	 * Returns a new object of class '<em>Bag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Bag</em>'.
	 * @generated
	 */
	Bag createBag();

	/**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
	Choice createChoice();

	/**
	 * Returns a new object of class '<em>Leaf Syntax Translator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Leaf Syntax Translator</em>'.
	 * @generated
	 */
	LeafSyntaxTranslator createLeafSyntaxTranslator();

	/**
	 * Returns a new object of class '<em>Message Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Message Group</em>'.
	 * @generated
	 */
	MessageGroup createMessageGroup();

	/**
	 * Returns a new object of class '<em>Data Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Data Rule</em>'.
	 * @generated
	 */
	DataRule createDataRule();

	/**
	 * Returns a new object of class '<em>Semantic Element Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Semantic Element Set</em>'.
	 * @generated
	 */
	SemanticElementSet createSemanticElementSet();

	/**
	 * Returns a new object of class '<em>Semantic Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Semantic Element</em>'.
	 * @generated
	 */
	SemanticElement createSemanticElement();

	/**
	 * Returns a new object of class '<em>Simple Message Composite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Simple Message Composite</em>'.
	 * @generated
	 */
	SimpleMessageComposite createSimpleMessageComposite();

	/**
	 * Returns a new object of class '<em>Message Composite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Message Composite</em>'.
	 * @generated
	 */
	MessageComposite createMessageComposite();

	/**
	 * Returns a new object of class '<em>Semantic Element Business Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Semantic Element Business Rule</em>'.
	 * @generated
	 */
	SemanticElementBusinessRule createSemanticElementBusinessRule();

	/**
	 * Returns a new object of class '<em>Semantic Element Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Semantic Element Relationship</em>'.
	 * @generated
	 */
	SemanticElementRelationship createSemanticElementRelationship();

	/**
	 * Returns a new object of class '<em>Business Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Business Element Reference</em>'.
	 * @generated
	 */
	MDMIBusinessElementReference createMDMIBusinessElementReference();

	/**
	 * Returns a new object of class '<em>Business Element Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Business Element Rule</em>'.
	 * @generated
	 */
	MDMIBusinessElementRule createMDMIBusinessElementRule();

	/**
	 * Returns a new object of class '<em>Conversion Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Conversion Rule</em>'.
	 * @generated
	 */
	ConversionRule createConversionRule();

	/**
	 * Returns a new object of class '<em>Domain Dictionary Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Domain Dictionary Reference</em>'.
	 * @generated
	 */
	MDMIDomainDictionaryReference createMDMIDomainDictionaryReference();

	/**
	 * Returns a new object of class '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Expression</em>'.
	 * @generated
	 */
	MDMIExpression createMDMIExpression();

	/**
	 * Returns a new object of class '<em>Keyword</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Keyword</em>'.
	 * @generated
	 */
	Keyword createKeyword();

	/**
	 * Returns a new object of class '<em>Datatype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Datatype</em>'.
	 * @generated
	 */
	MDMIDatatype createMDMIDatatype();

	/**
	 * Returns a new object of class '<em>DTS Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>DTS Primitive</em>'.
	 * @generated
	 */
	DTSPrimitive createDTSPrimitive();

	/**
	 * Returns a new object of class '<em>DTC Structured</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>DTC Structured</em>'.
	 * @generated
	 */
	DTCStructured createDTCStructured();

	/**
	 * Returns a new object of class '<em>Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Field</em>'.
	 * @generated
	 */
	Field createField();

	/**
	 * Returns a new object of class '<em>DT External</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>DT External</em>'.
	 * @generated
	 */
	DTExternal createDTExternal();

	/**
	 * Returns a new object of class '<em>DTS Derived</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>DTS Derived</em>'.
	 * @generated
	 */
	DTSDerived createDTSDerived();

	/**
	 * Returns a new object of class '<em>DTC Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>DTC Choice</em>'.
	 * @generated
	 */
	DTCChoice createDTCChoice();

	/**
	 * Returns a new object of class '<em>DTS Enumerated</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>DTS Enumerated</em>'.
	 * @generated
	 */
	DTSEnumerated createDTSEnumerated();

	/**
	 * Returns a new object of class '<em>Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Enumeration Literal</em>'.
	 * @generated
	 */
	EnumerationLiteral createEnumerationLiteral();

	/**
	 * Returns a new object of class '<em>Datatype Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Datatype Map</em>'.
	 * @generated
	 */
	DatatypeMap createDatatypeMap();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the package supported by this factory.
	 * @generated
	 */
	MDMIPackage getMDMIPackage();

	/**
	 *
	 * @generated Not
	 */

	public enum Primitive {
		Binary, Boolean, DateTime, Decimal, Integer, String
	}

	/**
	 *
	 * @generated NOT
	 */

	DTSPrimitive createDTSPrimitive(Primitive primitive);

	/**
	 *
	 * @generated NOT
	 */

	DTSPrimitive createDTSPrimitive(String primitive);

} // MDMIFactory
