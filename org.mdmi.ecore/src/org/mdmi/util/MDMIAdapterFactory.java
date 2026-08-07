/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 *
 * @see org.mdmi.MDMIPackage
 * @generated
 */
public class MDMIAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static MDMIPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MDMIAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MDMIPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 *
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MDMISwitch<Adapter> modelSwitch = new MDMISwitch<>() {
		@Override
		public Adapter caseMessageModel(MessageModel object) {
			return createMessageModelAdapter();
		}

		@Override
		public Adapter caseMessageSyntaxModel(MessageSyntaxModel object) {
			return createMessageSyntaxModelAdapter();
		}

		@Override
		public Adapter caseNode(Node object) {
			return createNodeAdapter();
		}

		@Override
		public Adapter caseBag(Bag object) {
			return createBagAdapter();
		}

		@Override
		public Adapter caseChoice(Choice object) {
			return createChoiceAdapter();
		}

		@Override
		public Adapter caseLeafSyntaxTranslator(LeafSyntaxTranslator object) {
			return createLeafSyntaxTranslatorAdapter();
		}

		@Override
		public Adapter caseMessageGroup(MessageGroup object) {
			return createMessageGroupAdapter();
		}

		@Override
		public Adapter caseDataRule(DataRule object) {
			return createDataRuleAdapter();
		}

		@Override
		public Adapter caseSemanticElementSet(SemanticElementSet object) {
			return createSemanticElementSetAdapter();
		}

		@Override
		public Adapter caseSemanticElement(SemanticElement object) {
			return createSemanticElementAdapter();
		}

		@Override
		public Adapter caseSimpleMessageComposite(SimpleMessageComposite object) {
			return createSimpleMessageCompositeAdapter();
		}

		@Override
		public Adapter caseMessageComposite(MessageComposite object) {
			return createMessageCompositeAdapter();
		}

		@Override
		public Adapter caseSemanticElementBusinessRule(SemanticElementBusinessRule object) {
			return createSemanticElementBusinessRuleAdapter();
		}

		@Override
		public Adapter caseSemanticElementRelationship(SemanticElementRelationship object) {
			return createSemanticElementRelationshipAdapter();
		}

		@Override
		public Adapter caseMDMIBusinessElementReference(MDMIBusinessElementReference object) {
			return createMDMIBusinessElementReferenceAdapter();
		}

		@Override
		public Adapter caseMDMIBusinessElementRule(MDMIBusinessElementRule object) {
			return createMDMIBusinessElementRuleAdapter();
		}

		@Override
		public Adapter caseConversionRule(ConversionRule object) {
			return createConversionRuleAdapter();
		}

		@Override
		public Adapter caseMDMIDomainDictionaryReference(MDMIDomainDictionaryReference object) {
			return createMDMIDomainDictionaryReferenceAdapter();
		}

		@Override
		public Adapter caseMDMIExpression(MDMIExpression object) {
			return createMDMIExpressionAdapter();
		}

		@Override
		public Adapter caseKeyword(Keyword object) {
			return createKeywordAdapter();
		}

		@Override
		public Adapter caseMDMIDatatype(MDMIDatatype object) {
			return createMDMIDatatypeAdapter();
		}

		@Override
		public Adapter caseDTSPrimitive(DTSPrimitive object) {
			return createDTSPrimitiveAdapter();
		}

		@Override
		public Adapter caseDTCStructured(DTCStructured object) {
			return createDTCStructuredAdapter();
		}

		@Override
		public Adapter caseField(Field object) {
			return createFieldAdapter();
		}

		@Override
		public Adapter caseDTExternal(DTExternal object) {
			return createDTExternalAdapter();
		}

		@Override
		public Adapter caseDTSDerived(DTSDerived object) {
			return createDTSDerivedAdapter();
		}

		@Override
		public Adapter caseDTCChoice(DTCChoice object) {
			return createDTCChoiceAdapter();
		}

		@Override
		public Adapter caseDTSEnumerated(DTSEnumerated object) {
			return createDTSEnumeratedAdapter();
		}

		@Override
		public Adapter caseEnumerationLiteral(EnumerationLiteral object) {
			return createEnumerationLiteralAdapter();
		}

		@Override
		public Adapter caseDatatypeMap(DatatypeMap object) {
			return createDatatypeMapAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.MessageModel <em>Message Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.MessageModel
	 * @generated
	 */
	public Adapter createMessageModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.MessageSyntaxModel <em>Message Syntax Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.MessageSyntaxModel
	 * @generated
	 */
	public Adapter createMessageSyntaxModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.Bag <em>Bag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.Bag
	 * @generated
	 */
	public Adapter createBagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.Choice
	 * @generated
	 */
	public Adapter createChoiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.LeafSyntaxTranslator <em>Leaf Syntax Translator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.LeafSyntaxTranslator
	 * @generated
	 */
	public Adapter createLeafSyntaxTranslatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.MessageGroup <em>Message Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.MessageGroup
	 * @generated
	 */
	public Adapter createMessageGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.DataRule <em>Data Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.DataRule
	 * @generated
	 */
	public Adapter createDataRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.SemanticElementSet <em>Semantic Element Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.SemanticElementSet
	 * @generated
	 */
	public Adapter createSemanticElementSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.SemanticElement <em>Semantic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.SemanticElement
	 * @generated
	 */
	public Adapter createSemanticElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.SimpleMessageComposite <em>Simple Message Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.SimpleMessageComposite
	 * @generated
	 */
	public Adapter createSimpleMessageCompositeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.MessageComposite <em>Message Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.MessageComposite
	 * @generated
	 */
	public Adapter createMessageCompositeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.SemanticElementBusinessRule <em>Semantic Element Business Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.SemanticElementBusinessRule
	 * @generated
	 */
	public Adapter createSemanticElementBusinessRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.SemanticElementRelationship <em>Semantic Element Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.SemanticElementRelationship
	 * @generated
	 */
	public Adapter createSemanticElementRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.MDMIBusinessElementReference <em>Business Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.MDMIBusinessElementReference
	 * @generated
	 */
	public Adapter createMDMIBusinessElementReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.MDMIBusinessElementRule <em>Business Element Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.MDMIBusinessElementRule
	 * @generated
	 */
	public Adapter createMDMIBusinessElementRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.ConversionRule <em>Conversion Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.ConversionRule
	 * @generated
	 */
	public Adapter createConversionRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.MDMIDomainDictionaryReference <em>Domain Dictionary Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.MDMIDomainDictionaryReference
	 * @generated
	 */
	public Adapter createMDMIDomainDictionaryReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.MDMIExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.MDMIExpression
	 * @generated
	 */
	public Adapter createMDMIExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.Keyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.Keyword
	 * @generated
	 */
	public Adapter createKeywordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.MDMIDatatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.MDMIDatatype
	 * @generated
	 */
	public Adapter createMDMIDatatypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.DTSPrimitive <em>DTS Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.DTSPrimitive
	 * @generated
	 */
	public Adapter createDTSPrimitiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.DTCStructured <em>DTC Structured</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.DTCStructured
	 * @generated
	 */
	public Adapter createDTCStructuredAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.Field
	 * @generated
	 */
	public Adapter createFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.DTExternal <em>DT External</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.DTExternal
	 * @generated
	 */
	public Adapter createDTExternalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.DTSDerived <em>DTS Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.DTSDerived
	 * @generated
	 */
	public Adapter createDTSDerivedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.DTCChoice <em>DTC Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.DTCChoice
	 * @generated
	 */
	public Adapter createDTCChoiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.DTSEnumerated <em>DTS Enumerated</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.DTSEnumerated
	 * @generated
	 */
	public Adapter createDTSEnumeratedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.EnumerationLiteral
	 * @generated
	 */
	public Adapter createEnumerationLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.mdmi.DatatypeMap <em>Datatype Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.mdmi.DatatypeMap
	 * @generated
	 */
	public Adapter createDatatypeMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // MDMIAdapterFactory
