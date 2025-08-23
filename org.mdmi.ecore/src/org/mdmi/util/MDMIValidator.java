/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;
import org.mdmi.Bag;
import org.mdmi.Choice;
import org.mdmi.ConversionRule;
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
import org.mdmi.MDMIPackage;
import org.mdmi.MessageComposite;
import org.mdmi.MessageElementType;
import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.mdmi.MessageSyntaxModel;
import org.mdmi.Node;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementBusinessRule;
import org.mdmi.SemanticElementRelationship;
import org.mdmi.SemanticElementSet;
import org.mdmi.SimpleMessageComposite;
import org.mdmi.ecore.MDMIPlugin;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 *
 * @see org.mdmi.MDMIPackage
 * @generated
 */
public class MDMIValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final MDMIValidator INSTANCE = new MDMIValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic
	 * {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.mdmi";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MDMIValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return MDMIPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		switch (classifierID) {
			case MDMIPackage.MESSAGE_MODEL:
				return validateMessageModel((MessageModel) value, diagnostics, context);
			case MDMIPackage.MESSAGE_SYNTAX_MODEL:
				return validateMessageSyntaxModel((MessageSyntaxModel) value, diagnostics, context);
			case MDMIPackage.NODE:
				return validateNode((Node) value, diagnostics, context);
			case MDMIPackage.BAG:
				return validateBag((Bag) value, diagnostics, context);
			case MDMIPackage.CHOICE:
				return validateChoice((Choice) value, diagnostics, context);
			case MDMIPackage.LEAF_SYNTAX_TRANSLATOR:
				return validateLeafSyntaxTranslator((LeafSyntaxTranslator) value, diagnostics, context);
			case MDMIPackage.MESSAGE_GROUP:
				return validateMessageGroup((MessageGroup) value, diagnostics, context);
			case MDMIPackage.DATA_RULE:
				return validateDataRule((DataRule) value, diagnostics, context);
			case MDMIPackage.SEMANTIC_ELEMENT_SET:
				return validateSemanticElementSet((SemanticElementSet) value, diagnostics, context);
			case MDMIPackage.SEMANTIC_ELEMENT:
				return validateSemanticElement((SemanticElement) value, diagnostics, context);
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE:
				return validateSimpleMessageComposite((SimpleMessageComposite) value, diagnostics, context);
			case MDMIPackage.MESSAGE_COMPOSITE:
				return validateMessageComposite((MessageComposite) value, diagnostics, context);
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE:
				return validateSemanticElementBusinessRule((SemanticElementBusinessRule) value, diagnostics, context);
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP:
				return validateSemanticElementRelationship((SemanticElementRelationship) value, diagnostics, context);
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE:
				return validateMDMIBusinessElementReference((MDMIBusinessElementReference) value, diagnostics, context);
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_RULE:
				return validateMDMIBusinessElementRule((MDMIBusinessElementRule) value, diagnostics, context);
			case MDMIPackage.CONVERSION_RULE:
				return validateConversionRule((ConversionRule) value, diagnostics, context);
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE:
				return validateMDMIDomainDictionaryReference(
					(MDMIDomainDictionaryReference) value, diagnostics, context);
			case MDMIPackage.MDMI_EXPRESSION:
				return validateMDMIExpression((MDMIExpression) value, diagnostics, context);
			case MDMIPackage.KEYWORD:
				return validateKeyword((Keyword) value, diagnostics, context);
			case MDMIPackage.MDMI_DATATYPE:
				return validateMDMIDatatype((MDMIDatatype) value, diagnostics, context);
			case MDMIPackage.DTS_PRIMITIVE:
				return validateDTSPrimitive((DTSPrimitive) value, diagnostics, context);
			case MDMIPackage.DTC_STRUCTURED:
				return validateDTCStructured((DTCStructured) value, diagnostics, context);
			case MDMIPackage.FIELD:
				return validateField((Field) value, diagnostics, context);
			case MDMIPackage.DT_EXTERNAL:
				return validateDTExternal((DTExternal) value, diagnostics, context);
			case MDMIPackage.DTS_DERIVED:
				return validateDTSDerived((DTSDerived) value, diagnostics, context);
			case MDMIPackage.DTC_CHOICE:
				return validateDTCChoice((DTCChoice) value, diagnostics, context);
			case MDMIPackage.DTS_ENUMERATED:
				return validateDTSEnumerated((DTSEnumerated) value, diagnostics, context);
			case MDMIPackage.ENUMERATION_LITERAL:
				return validateEnumerationLiteral((EnumerationLiteral) value, diagnostics, context);
			case MDMIPackage.DATATYPE_MAP:
				return validateDatatypeMap((DatatypeMap) value, diagnostics, context);
			case MDMIPackage.MESSAGE_ELEMENT_TYPE:
				return validateMessageElementType((MessageElementType) value, diagnostics, context);
			case MDMIPackage.URI:
				return validateURI((String) value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateMessageModel(MessageModel messageModel, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(messageModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateMessageSyntaxModel(MessageSyntaxModel messageSyntaxModel, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(messageSyntaxModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateNode(Node node, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(node, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateBag(Bag bag, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(bag, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateChoice(Choice choice, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(choice, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateLeafSyntaxTranslator(LeafSyntaxTranslator leafSyntaxTranslator, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(leafSyntaxTranslator, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateMessageGroup(MessageGroup messageGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(messageGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateDataRule(DataRule dataRule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataRule, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateSemanticElementSet(SemanticElementSet semanticElementSet, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(semanticElementSet, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateSemanticElement(SemanticElement semanticElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(semanticElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateSimpleMessageComposite(SimpleMessageComposite simpleMessageComposite,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(simpleMessageComposite, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateMessageComposite(MessageComposite messageComposite, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(messageComposite, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateSemanticElementBusinessRule(SemanticElementBusinessRule semanticElementBusinessRule,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(semanticElementBusinessRule, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateSemanticElementRelationship(SemanticElementRelationship semanticElementRelationship,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(semanticElementRelationship, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateMDMIBusinessElementReference(MDMIBusinessElementReference mdmiBusinessElementReference,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mdmiBusinessElementReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateMDMIBusinessElementRule(MDMIBusinessElementRule mdmiBusinessElementRule,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mdmiBusinessElementRule, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateConversionRule(ConversionRule conversionRule, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(conversionRule, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateMDMIDomainDictionaryReference(MDMIDomainDictionaryReference mdmiDomainDictionaryReference,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mdmiDomainDictionaryReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateMDMIExpression(MDMIExpression mdmiExpression, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mdmiExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateKeyword(Keyword keyword, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(keyword, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateMDMIDatatype(MDMIDatatype mdmiDatatype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mdmiDatatype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateDTSPrimitive(DTSPrimitive dtsPrimitive, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dtsPrimitive, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateDTCStructured(DTCStructured dtcStructured, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dtcStructured, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateField(Field field, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(field, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateDTExternal(DTExternal dtExternal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dtExternal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateDTSDerived(DTSDerived dtsDerived, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dtsDerived, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateDTCChoice(DTCChoice dtcChoice, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dtcChoice, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateDTSEnumerated(DTSEnumerated dtsEnumerated, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dtsEnumerated, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateEnumerationLiteral(EnumerationLiteral enumerationLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enumerationLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateDatatypeMap(DatatypeMap datatypeMap, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(datatypeMap, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateMessageElementType(MessageElementType messageElementType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateURI(String uri, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateURI_Pattern(uri, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @see #validateURI_Pattern
	 */
	public static final PatternMatcher[][] URI__PATTERN__VALUES = new PatternMatcher[][] {
			new PatternMatcher[] {
					XMLTypeUtil.createPatternMatcher("^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?") } };

	/**
	 * Validates the Pattern constraint of '<em>URI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateURI_Pattern(String uri, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(MDMIPackage.Literals.URI, uri, URI__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return MDMIPlugin.INSTANCE;
	}

} // MDMIValidator
