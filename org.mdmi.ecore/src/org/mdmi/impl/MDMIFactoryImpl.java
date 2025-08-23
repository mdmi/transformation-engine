/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.mdmi.*;
import org.mdmi.Bag;
import org.mdmi.Choice;
import org.mdmi.DTCChoice;
import org.mdmi.DTCStructured;
import org.mdmi.DTExternal;
import org.mdmi.DTSDerived;
import org.mdmi.DTSEnumerated;
import org.mdmi.DTSPrimitive;
import org.mdmi.DataRule;
import org.mdmi.DatatypeMap;
import org.mdmi.EnumerationLiteral;
import org.mdmi.Field;
import org.mdmi.Keyword;
import org.mdmi.LeafSyntaxTranslator;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MDMIBusinessElementRule;
import org.mdmi.MDMIDatatype;
import org.mdmi.MDMIDomainDictionaryReference;
import org.mdmi.MDMIExpression;
import org.mdmi.MDMIFactory;
import org.mdmi.MDMIPackage;
import org.mdmi.MessageComposite;
import org.mdmi.MessageElementType;
import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.mdmi.MessageSyntaxModel;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementBusinessRule;
import org.mdmi.SemanticElementRelationship;
import org.mdmi.SemanticElementSet;
import org.mdmi.SimpleMessageComposite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MDMIFactoryImpl extends EFactoryImpl implements MDMIFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static MDMIFactory init() {
		try {
			MDMIFactory theMDMIFactory = (MDMIFactory) EPackage.Registry.INSTANCE.getEFactory(MDMIPackage.eNS_URI);
			if (theMDMIFactory != null) {
				return theMDMIFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MDMIFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MDMIFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MDMIPackage.MESSAGE_MODEL:
				return createMessageModel();
			case MDMIPackage.MESSAGE_SYNTAX_MODEL:
				return createMessageSyntaxModel();
			case MDMIPackage.BAG:
				return createBag();
			case MDMIPackage.CHOICE:
				return createChoice();
			case MDMIPackage.LEAF_SYNTAX_TRANSLATOR:
				return createLeafSyntaxTranslator();
			case MDMIPackage.MESSAGE_GROUP:
				return createMessageGroup();
			case MDMIPackage.DATA_RULE:
				return createDataRule();
			case MDMIPackage.SEMANTIC_ELEMENT_SET:
				return createSemanticElementSet();
			case MDMIPackage.SEMANTIC_ELEMENT:
				return createSemanticElement();
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE:
				return createSimpleMessageComposite();
			case MDMIPackage.MESSAGE_COMPOSITE:
				return createMessageComposite();
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE:
				return createSemanticElementBusinessRule();
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP:
				return createSemanticElementRelationship();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE:
				return createMDMIBusinessElementReference();
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_RULE:
				return createMDMIBusinessElementRule();
			case MDMIPackage.CONVERSION_RULE:
				return createConversionRule();
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE:
				return createMDMIDomainDictionaryReference();
			case MDMIPackage.MDMI_EXPRESSION:
				return createMDMIExpression();
			case MDMIPackage.KEYWORD:
				return createKeyword();
			case MDMIPackage.MDMI_DATATYPE:
				return createMDMIDatatype();
			case MDMIPackage.DTS_PRIMITIVE:
				return createDTSPrimitive();
			case MDMIPackage.DTC_STRUCTURED:
				return createDTCStructured();
			case MDMIPackage.FIELD:
				return createField();
			case MDMIPackage.DT_EXTERNAL:
				return createDTExternal();
			case MDMIPackage.DTS_DERIVED:
				return createDTSDerived();
			case MDMIPackage.DTC_CHOICE:
				return createDTCChoice();
			case MDMIPackage.DTS_ENUMERATED:
				return createDTSEnumerated();
			case MDMIPackage.ENUMERATION_LITERAL:
				return createEnumerationLiteral();
			case MDMIPackage.DATATYPE_MAP:
				return createDatatypeMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MDMIPackage.MESSAGE_ELEMENT_TYPE:
				return createMessageElementTypeFromString(eDataType, initialValue);
			case MDMIPackage.URI:
				return createURIFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MDMIPackage.MESSAGE_ELEMENT_TYPE:
				return convertMessageElementTypeToString(eDataType, instanceValue);
			case MDMIPackage.URI:
				return convertURIToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MessageModel createMessageModel() {
		MessageModelImpl messageModel = new MessageModelImpl();
		return messageModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MessageSyntaxModel createMessageSyntaxModel() {
		MessageSyntaxModelImpl messageSyntaxModel = new MessageSyntaxModelImpl();
		return messageSyntaxModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Bag createBag() {
		BagImpl bag = new BagImpl();
		return bag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Choice createChoice() {
		ChoiceImpl choice = new ChoiceImpl();
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public LeafSyntaxTranslator createLeafSyntaxTranslator() {
		LeafSyntaxTranslatorImpl leafSyntaxTranslator = new LeafSyntaxTranslatorImpl();
		return leafSyntaxTranslator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MessageGroup createMessageGroup() {
		MessageGroupImpl messageGroup = new MessageGroupImpl();
		return messageGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DataRule createDataRule() {
		DataRuleImpl dataRule = new DataRuleImpl();
		return dataRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SemanticElementSet createSemanticElementSet() {
		SemanticElementSetImpl semanticElementSet = new SemanticElementSetImpl();
		return semanticElementSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SemanticElement createSemanticElement() {
		SemanticElementImpl semanticElement = new SemanticElementImpl();
		return semanticElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SimpleMessageComposite createSimpleMessageComposite() {
		SimpleMessageCompositeImpl simpleMessageComposite = new SimpleMessageCompositeImpl();
		return simpleMessageComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MessageComposite createMessageComposite() {
		MessageCompositeImpl messageComposite = new MessageCompositeImpl();
		return messageComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SemanticElementBusinessRule createSemanticElementBusinessRule() {
		SemanticElementBusinessRuleImpl semanticElementBusinessRule = new SemanticElementBusinessRuleImpl();
		return semanticElementBusinessRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SemanticElementRelationship createSemanticElementRelationship() {
		SemanticElementRelationshipImpl semanticElementRelationship = new SemanticElementRelationshipImpl();
		return semanticElementRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIBusinessElementReference createMDMIBusinessElementReference() {
		MDMIBusinessElementReferenceImpl mdmiBusinessElementReference = new MDMIBusinessElementReferenceImpl();
		return mdmiBusinessElementReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIBusinessElementRule createMDMIBusinessElementRule() {
		MDMIBusinessElementRuleImpl mdmiBusinessElementRule = new MDMIBusinessElementRuleImpl();
		return mdmiBusinessElementRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ConversionRule createConversionRule() {
		ConversionRuleImpl conversionRule = new ConversionRuleImpl();
		return conversionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIDomainDictionaryReference createMDMIDomainDictionaryReference() {
		MDMIDomainDictionaryReferenceImpl mdmiDomainDictionaryReference = new MDMIDomainDictionaryReferenceImpl();
		return mdmiDomainDictionaryReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIExpression createMDMIExpression() {
		MDMIExpressionImpl mdmiExpression = new MDMIExpressionImpl();
		return mdmiExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Keyword createKeyword() {
		KeywordImpl keyword = new KeywordImpl();
		return keyword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIDatatype createMDMIDatatype() {
		MDMIDatatypeImpl mdmiDatatype = new MDMIDatatypeImpl();
		return mdmiDatatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DTSPrimitive createDTSPrimitive() {
		DTSPrimitiveImpl dtsPrimitive = new DTSPrimitiveImpl();
		return dtsPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DTCStructured createDTCStructured() {
		DTCStructuredImpl dtcStructured = new DTCStructuredImpl();
		return dtcStructured;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Field createField() {
		FieldImpl field = new FieldImpl();
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DTExternal createDTExternal() {
		DTExternalImpl dtExternal = new DTExternalImpl();
		return dtExternal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DTSDerived createDTSDerived() {
		DTSDerivedImpl dtsDerived = new DTSDerivedImpl();
		return dtsDerived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DTCChoice createDTCChoice() {
		DTCChoiceImpl dtcChoice = new DTCChoiceImpl();
		return dtcChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DTSEnumerated createDTSEnumerated() {
		DTSEnumeratedImpl dtsEnumerated = new DTSEnumeratedImpl();
		return dtsEnumerated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EnumerationLiteral createEnumerationLiteral() {
		EnumerationLiteralImpl enumerationLiteral = new EnumerationLiteralImpl();
		return enumerationLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DatatypeMap createDatatypeMap() {
		DatatypeMapImpl datatypeMap = new DatatypeMapImpl();
		return datatypeMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MessageElementType createMessageElementTypeFromString(EDataType eDataType, String initialValue) {
		MessageElementType result = MessageElementType.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
				"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String convertMessageElementTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null
				? null
				: instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String createURIFromString(EDataType eDataType, String initialValue) {
		return (String) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIPackage getMDMIPackage() {
		return (MDMIPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MDMIPackage getPackage() {
		return MDMIPackage.eINSTANCE;
	}

	/*
	 * public static final DTSPrimitive BINARY = new DTSPrimitive(
	 * "Binary", "Binary", "http://www.w3.org/2001/XMLSchema#hexBinary");
	 *
	 * public static final DTSPrimitive BOOLEAN = new DTSPrimitive(
	 * "Boolean", "Boolean", "http://www.w3.org/2001/XMLSchema#boolean");
	 *
	 * public static final DTSPrimitive DATETIME = new DTSPrimitive(
	 * "DateTime", "DateTime", "http://www.w3.org/2001/XMLSchema#dateTime");
	 *
	 * public static final DTSPrimitive DECIMAL = new DTSPrimitive(
	 * "Decimal", "Decimal", "http://www.w3.org/2001/XMLSchema#decimal");
	 *
	 * public static final DTSPrimitive INTEGER = new DTSPrimitive(
	 * "Integer", "Integer", "http://www.w3.org/2001/XMLSchema#integer");
	 *
	 * public static final DTSPrimitive STRING = new DTSPrimitive(
	 * "String", "String", "http://www.w3.org/2001/XMLSchema#string");
	 *
	 */

	/**
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.MDMIFactory#createDTSPrimitive(org.mdmi.MDMIFactory.Primitive)
	 * @generated NOT
	 */
	@Override
	public DTSPrimitive createDTSPrimitive(Primitive primitive) {
		DTSPrimitive dtsPrimitive = MDMIFactory.eINSTANCE.createDTSPrimitive();
		switch (primitive) {
			case Binary:
				dtsPrimitive.setTypeName("Binary");
				dtsPrimitive.setDescription("Binary");
				dtsPrimitive.setReference("http://www.w3.org/2001/XMLSchema#hexBinary");
				break;
			case Boolean:
				dtsPrimitive.setTypeName("Boolean");
				dtsPrimitive.setDescription("Boolean");
				dtsPrimitive.setReference("http://www.w3.org/2001/XMLSchema#Boolean");
				break;
			case DateTime:
				dtsPrimitive.setTypeName("DateTime");
				dtsPrimitive.setDescription("DateTime");
				dtsPrimitive.setReference("http://www.w3.org/2001/XMLSchema#DateTime");
				break;
			case Decimal:
				dtsPrimitive.setTypeName("Decimal");
				dtsPrimitive.setDescription("Decimal");
				dtsPrimitive.setReference("http://www.w3.org/2001/XMLSchema#Decimal");
				break;
			case Integer:
				dtsPrimitive.setTypeName("Integer");
				dtsPrimitive.setDescription("Integer");
				dtsPrimitive.setReference("http://www.w3.org/2001/XMLSchema#Integer");
				break;
			case String:
				dtsPrimitive.setTypeName("String");
				dtsPrimitive.setDescription("String");
				dtsPrimitive.setReference("http://www.w3.org/2001/XMLSchema#String");
				break;
		}
		return dtsPrimitive;
	}

	/**
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.MDMIFactory#createDTSPrimitive(java.lang.String)
	 * @generated NOT
	 */
	@Override
	public DTSPrimitive createDTSPrimitive(String primitive) {
		switch (primitive.toUpperCase()) {
			case "BINARY":
				return MDMIFactory.eINSTANCE.createDTSPrimitive(org.mdmi.MDMIFactory.Primitive.Binary);

			case "BOOLEAN":
				return MDMIFactory.eINSTANCE.createDTSPrimitive(org.mdmi.MDMIFactory.Primitive.Boolean);

			case "DATETIME":
				return MDMIFactory.eINSTANCE.createDTSPrimitive(org.mdmi.MDMIFactory.Primitive.DateTime);

			case "DECIMAL":
				return MDMIFactory.eINSTANCE.createDTSPrimitive(org.mdmi.MDMIFactory.Primitive.Decimal);

			case "INTEGER":
				return MDMIFactory.eINSTANCE.createDTSPrimitive(org.mdmi.MDMIFactory.Primitive.Integer);

			case "STRING":
				return MDMIFactory.eINSTANCE.createDTSPrimitive(org.mdmi.MDMIFactory.Primitive.String);

		}
		return null;
	}

} // MDMIFactoryImpl
