/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.mdmi.MessageSyntaxModel;
import org.mdmi.Node;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementBusinessRule;
import org.mdmi.SemanticElementRelationship;
import org.mdmi.SemanticElementSet;
import org.mdmi.SimpleMessageComposite;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see org.mdmi.MDMIPackage
 * @generated
 */
public class MDMISwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static MDMIPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MDMISwitch() {
		if (modelPackage == null) {
			modelPackage = MDMIPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param ePackage
	 *            the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MDMIPackage.MESSAGE_MODEL: {
				MessageModel messageModel = (MessageModel) theEObject;
				T result = caseMessageModel(messageModel);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.MESSAGE_SYNTAX_MODEL: {
				MessageSyntaxModel messageSyntaxModel = (MessageSyntaxModel) theEObject;
				T result = caseMessageSyntaxModel(messageSyntaxModel);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.NODE: {
				Node node = (Node) theEObject;
				T result = caseNode(node);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.BAG: {
				Bag bag = (Bag) theEObject;
				T result = caseBag(bag);
				if (result == null) {
					result = caseNode(bag);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.CHOICE: {
				Choice choice = (Choice) theEObject;
				T result = caseChoice(choice);
				if (result == null) {
					result = caseNode(choice);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.LEAF_SYNTAX_TRANSLATOR: {
				LeafSyntaxTranslator leafSyntaxTranslator = (LeafSyntaxTranslator) theEObject;
				T result = caseLeafSyntaxTranslator(leafSyntaxTranslator);
				if (result == null) {
					result = caseNode(leafSyntaxTranslator);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.MESSAGE_GROUP: {
				MessageGroup messageGroup = (MessageGroup) theEObject;
				T result = caseMessageGroup(messageGroup);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.DATA_RULE: {
				DataRule dataRule = (DataRule) theEObject;
				T result = caseDataRule(dataRule);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.SEMANTIC_ELEMENT_SET: {
				SemanticElementSet semanticElementSet = (SemanticElementSet) theEObject;
				T result = caseSemanticElementSet(semanticElementSet);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.SEMANTIC_ELEMENT: {
				SemanticElement semanticElement = (SemanticElement) theEObject;
				T result = caseSemanticElement(semanticElement);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.SIMPLE_MESSAGE_COMPOSITE: {
				SimpleMessageComposite simpleMessageComposite = (SimpleMessageComposite) theEObject;
				T result = caseSimpleMessageComposite(simpleMessageComposite);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.MESSAGE_COMPOSITE: {
				MessageComposite messageComposite = (MessageComposite) theEObject;
				T result = caseMessageComposite(messageComposite);
				if (result == null) {
					result = caseSimpleMessageComposite(messageComposite);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE: {
				SemanticElementBusinessRule semanticElementBusinessRule = (SemanticElementBusinessRule) theEObject;
				T result = caseSemanticElementBusinessRule(semanticElementBusinessRule);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.SEMANTIC_ELEMENT_RELATIONSHIP: {
				SemanticElementRelationship semanticElementRelationship = (SemanticElementRelationship) theEObject;
				T result = caseSemanticElementRelationship(semanticElementRelationship);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE: {
				MDMIBusinessElementReference mdmiBusinessElementReference = (MDMIBusinessElementReference) theEObject;
				T result = caseMDMIBusinessElementReference(mdmiBusinessElementReference);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.MDMI_BUSINESS_ELEMENT_RULE: {
				MDMIBusinessElementRule mdmiBusinessElementRule = (MDMIBusinessElementRule) theEObject;
				T result = caseMDMIBusinessElementRule(mdmiBusinessElementRule);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.CONVERSION_RULE: {
				ConversionRule conversionRule = (ConversionRule) theEObject;
				T result = caseConversionRule(conversionRule);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE: {
				MDMIDomainDictionaryReference mdmiDomainDictionaryReference = (MDMIDomainDictionaryReference) theEObject;
				T result = caseMDMIDomainDictionaryReference(mdmiDomainDictionaryReference);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.MDMI_EXPRESSION: {
				MDMIExpression mdmiExpression = (MDMIExpression) theEObject;
				T result = caseMDMIExpression(mdmiExpression);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.KEYWORD: {
				Keyword keyword = (Keyword) theEObject;
				T result = caseKeyword(keyword);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.MDMI_DATATYPE: {
				MDMIDatatype mdmiDatatype = (MDMIDatatype) theEObject;
				T result = caseMDMIDatatype(mdmiDatatype);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.DTS_PRIMITIVE: {
				DTSPrimitive dtsPrimitive = (DTSPrimitive) theEObject;
				T result = caseDTSPrimitive(dtsPrimitive);
				if (result == null) {
					result = caseMDMIDatatype(dtsPrimitive);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.DTC_STRUCTURED: {
				DTCStructured dtcStructured = (DTCStructured) theEObject;
				T result = caseDTCStructured(dtcStructured);
				if (result == null) {
					result = caseMDMIDatatype(dtcStructured);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.FIELD: {
				Field field = (Field) theEObject;
				T result = caseField(field);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.DT_EXTERNAL: {
				DTExternal dtExternal = (DTExternal) theEObject;
				T result = caseDTExternal(dtExternal);
				if (result == null) {
					result = caseDTSPrimitive(dtExternal);
				}
				if (result == null) {
					result = caseMDMIDatatype(dtExternal);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.DTS_DERIVED: {
				DTSDerived dtsDerived = (DTSDerived) theEObject;
				T result = caseDTSDerived(dtsDerived);
				if (result == null) {
					result = caseDTSPrimitive(dtsDerived);
				}
				if (result == null) {
					result = caseMDMIDatatype(dtsDerived);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.DTC_CHOICE: {
				DTCChoice dtcChoice = (DTCChoice) theEObject;
				T result = caseDTCChoice(dtcChoice);
				if (result == null) {
					result = caseMDMIDatatype(dtcChoice);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.DTS_ENUMERATED: {
				DTSEnumerated dtsEnumerated = (DTSEnumerated) theEObject;
				T result = caseDTSEnumerated(dtsEnumerated);
				if (result == null) {
					result = caseMDMIDatatype(dtsEnumerated);
				}
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.ENUMERATION_LITERAL: {
				EnumerationLiteral enumerationLiteral = (EnumerationLiteral) theEObject;
				T result = caseEnumerationLiteral(enumerationLiteral);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			case MDMIPackage.DATATYPE_MAP: {
				DatatypeMap datatypeMap = (DatatypeMap) theEObject;
				T result = caseDatatypeMap(datatypeMap);
				if (result == null) {
					result = defaultCase(theEObject);
				}
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageModel(MessageModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Syntax Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Syntax Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageSyntaxModel(MessageSyntaxModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBag(Bag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoice(Choice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leaf Syntax Translator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leaf Syntax Translator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeafSyntaxTranslator(LeafSyntaxTranslator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageGroup(MessageGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataRule(DataRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Element Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Element Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticElementSet(SemanticElementSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticElement(SemanticElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Message Composite</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Message Composite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleMessageComposite(SimpleMessageComposite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Composite</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Composite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageComposite(MessageComposite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Element Business Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Element Business Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticElementBusinessRule(SemanticElementBusinessRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Element Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Element Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticElementRelationship(SemanticElementRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Element Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMDMIBusinessElementReference(MDMIBusinessElementReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Element Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Element Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMDMIBusinessElementRule(MDMIBusinessElementRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conversion Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conversion Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConversionRule(ConversionRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Dictionary Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Dictionary Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMDMIDomainDictionaryReference(MDMIDomainDictionaryReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMDMIExpression(MDMIExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Keyword</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Keyword</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeyword(Keyword object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Datatype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Datatype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMDMIDatatype(MDMIDatatype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DTS Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DTS Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDTSPrimitive(DTSPrimitive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DTC Structured</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DTC Structured</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDTCStructured(DTCStructured object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseField(Field object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DT External</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DT External</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDTExternal(DTExternal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DTS Derived</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DTS Derived</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDTSDerived(DTSDerived object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DTC Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DTC Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDTCChoice(DTCChoice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DTS Enumerated</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DTS Enumerated</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDTSEnumerated(DTSEnumerated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationLiteral(EnumerationLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Datatype Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Datatype Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDatatypeMap(DatatypeMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // MDMISwitch
