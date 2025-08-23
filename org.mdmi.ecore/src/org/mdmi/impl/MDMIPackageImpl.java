/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.impl;

import java.io.IOException;
import java.net.URL;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.mdmi.DTSPrimitive;
import org.mdmi.MDMIFactory;
import org.mdmi.MDMIPackage;
import org.mdmi.util.MDMIValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MDMIPackageImpl extends EPackageImpl implements MDMIPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected String packageFilename = "mdmi.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass messageModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass messageSyntaxModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass bagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass choiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass leafSyntaxTranslatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass messageGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass dataRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass semanticElementSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass semanticElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass simpleMessageCompositeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass messageCompositeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass semanticElementBusinessRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass semanticElementRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass mdmiBusinessElementReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass mdmiBusinessElementRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass conversionRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass mdmiDomainDictionaryReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass mdmiExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass keywordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass mdmiDatatypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass dtsPrimitiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass dtcStructuredEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass fieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass dtExternalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass dtsDerivedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass dtcChoiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass dtsEnumeratedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass enumerationLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass datatypeMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EEnum messageElementTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.mdmi.MDMIPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MDMIPackageImpl() {
		super(eNS_URI, MDMIFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static boolean isInited = false;

	private static DTSPrimitive createPrimitive(String name, String uri) {
		DTSPrimitive primitive = MDMIFactory.eINSTANCE.createDTSPrimitive();
		primitive.setTypeName(name);
		primitive.setDescription(name);
		primitive.setTypeSpec(uri);
		return primitive;

	}

	/*
	 *
	 * // public static final DTSPrimitive BINARY = new DTSPrimitive(
	 * // "Binary", "Binary", "http://www.w3.org/2001/XMLSchema#hexBinary");
	 * //
	 * // public static final DTSPrimitive BOOLEAN = new DTSPrimitive(
	 * // "Boolean", "Boolean", "http://www.w3.org/2001/XMLSchema#boolean");
	 * //
	 * // public static final DTSPrimitive DATETIME = new DTSPrimitive(
	 * // "DateTime", "DateTime", "http://www.w3.org/2001/XMLSchema#dateTime");
	 * //
	 * // public static final DTSPrimitive DECIMAL = new DTSPrimitive(
	 * // "Decimal", "Decimal", "http://www.w3.org/2001/XMLSchema#decimal");
	 * //
	 * // public static final DTSPrimitive INTEGER = new DTSPrimitive(
	 * // "Integer", "Integer", "http://www.w3.org/2001/XMLSchema#integer");
	 * //
	 * public static final DTSPrimitive STRING = new DTSPrimitiveImpl(
	 * "String", "String", "http://www.w3.org/2001/XMLSchema#string");
	 *
	 *
	 *
	 * DTSPrimitive INTEGER = null;
	 *
	 * DTSPrimitive DECIMAL = null;
	 *
	 * DTSPrimitive BOOLEAN = null;
	 *
	 * DTSPrimitive BINARY = null;
	 *
	 * DTSPrimitive DATETIME = null;
	 */
	public static DTSPrimitive STRING = null;

	public static DTSPrimitive INTEGER = null;

	public static DTSPrimitive DECIMAL = null;

	public static DTSPrimitive BOOLEAN = null;

	public static DTSPrimitive BINARY = null;

	public static DTSPrimitive DATETIME = null;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link MDMIPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @generated NOT
	 */
	public static MDMIPackage init() {
		if (isInited) {
			return (MDMIPackage) EPackage.Registry.INSTANCE.getEPackage(MDMIPackage.eNS_URI);
		}

		// Obtain or create and register package
		MDMIPackageImpl theMDMIPackage = (MDMIPackageImpl) (EPackage.Registry.INSTANCE.get(
			eNS_URI) instanceof MDMIPackageImpl
					? EPackage.Registry.INSTANCE.get(eNS_URI)
					: new MDMIPackageImpl());

		isInited = true;

		// Load packages
		theMDMIPackage.loadPackage();

		// Fix loaded packages
		theMDMIPackage.fixPackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put(theMDMIPackage, new EValidator.Descriptor() {
			public EValidator getEValidator() {
				return MDMIValidator.INSTANCE;
			}
		});

		// Mark meta-data to indicate it can't be changed
		theMDMIPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MDMIPackage.eNS_URI, theMDMIPackage);

		STRING = createPrimitive("String", "http://www.w3.org/2001/XMLSchema#string");

		INTEGER = createPrimitive("Integer", "http://www.w3.org/2001/XMLSchema#integer");

		DECIMAL = createPrimitive("Decimal", "http://www.w3.org/2001/XMLSchema#decimal");

		BOOLEAN = createPrimitive("Boolean", "http://www.w3.org/2001/XMLSchema#boolean");

		BINARY = createPrimitive("Binary", "http://www.w3.org/2001/XMLSchema#hexBinary");

		DATETIME = createPrimitive("DateTime", "http://www.w3.org/2001/XMLSchema#dateTime");
		return theMDMIPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getMessageModel() {
		if (messageModelEClass == null) {
			messageModelEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(0);
		}
		return messageModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageModel_MessageModelName() {
		return (EAttribute) getMessageModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageModel_SyntaxModel() {
		return (EReference) getMessageModel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageModel_ElementSet() {
		return (EReference) getMessageModel().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageModel_Description() {
		return (EAttribute) getMessageModel().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageModel_Source() {
		return (EAttribute) getMessageModel().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageModel_Group() {
		return (EReference) getMessageModel().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getMessageSyntaxModel() {
		if (messageSyntaxModelEClass == null) {
			messageSyntaxModelEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(1);
		}
		return messageSyntaxModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageSyntaxModel_Name() {
		return (EAttribute) getMessageSyntaxModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageSyntaxModel_Model() {
		return (EReference) getMessageSyntaxModel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageSyntaxModel_Root() {
		return (EReference) getMessageSyntaxModel().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageSyntaxModel_ElementSet() {
		return (EReference) getMessageSyntaxModel().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageSyntaxModel_Description() {
		return (EAttribute) getMessageSyntaxModel().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getNode() {
		if (nodeEClass == null) {
			nodeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(MDMIPackage.eNS_URI).getEClassifiers().get(2);
		}
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getNode_Name() {
		return (EAttribute) getNode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getNode_Description() {
		return (EAttribute) getNode().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getNode_MinOccurs() {
		return (EAttribute) getNode().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getNode_MaxOccurs() {
		return (EAttribute) getNode().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getNode_Location() {
		return (EAttribute) getNode().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getNode_LocationExpressionLanguage() {
		return (EAttribute) getNode().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getNode_SyntaxModel() {
		return (EReference) getNode().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getNode_SemanticElement() {
		return (EReference) getNode().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getNode_FieldName() {
		return (EAttribute) getNode().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getNode_IsSyntacticField() {
		return (EAttribute) getNode().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getNode_Path() {
		return (EAttribute) getNode().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getBag() {
		if (bagEClass == null) {
			bagEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(MDMIPackage.eNS_URI).getEClassifiers().get(3);
		}
		return bagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getBag_IsUnique() {
		return (EAttribute) getBag().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getBag_IsOrdered() {
		return (EAttribute) getBag().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getBag_Nodes() {
		return (EReference) getBag().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getChoice() {
		if (choiceEClass == null) {
			choiceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(MDMIPackage.eNS_URI).getEClassifiers().get(
				4);
		}
		return choiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getChoice_Constraint() {
		return (EAttribute) getChoice().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getChoice_ConstraintExpressionLanguage() {
		return (EAttribute) getChoice().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getChoice_Nodes() {
		return (EReference) getChoice().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getLeafSyntaxTranslator() {
		if (leafSyntaxTranslatorEClass == null) {
			leafSyntaxTranslatorEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(5);
		}
		return leafSyntaxTranslatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getLeafSyntaxTranslator_Format() {
		return (EAttribute) getLeafSyntaxTranslator().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getLeafSyntaxTranslator_FormatExpressionLanguage() {
		return (EAttribute) getLeafSyntaxTranslator().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getMessageGroup() {
		if (messageGroupEClass == null) {
			messageGroupEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(6);
		}
		return messageGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageGroup_Name() {
		return (EAttribute) getMessageGroup().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageGroup_DataRules() {
		return (EReference) getMessageGroup().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageGroup_Description() {
		return (EAttribute) getMessageGroup().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageGroup_DefaultLocationExprLang() {
		return (EAttribute) getMessageGroup().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageGroup_DefaultConstraintExprLang() {
		return (EAttribute) getMessageGroup().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageGroup_DefaultRuleExprLang() {
		return (EAttribute) getMessageGroup().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageGroup_DefaultFormatExpressionLanguage() {
		return (EAttribute) getMessageGroup().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageGroup_DefaultOrderingExpressionLanguage() {
		return (EAttribute) getMessageGroup().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageGroup_Models() {
		return (EReference) getMessageGroup().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageGroup_DomainDictionary() {
		return (EReference) getMessageGroup().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMessageGroup_DefaultMDMIExpresionLanguage() {
		return (EAttribute) getMessageGroup().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageGroup_Rules() {
		return (EReference) getMessageGroup().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageGroup_Datatypes() {
		return (EReference) getMessageGroup().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageGroup_DatatypeMaps() {
		return (EReference) getMessageGroup().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getDataRule() {
		if (dataRuleEClass == null) {
			dataRuleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(MDMIPackage.eNS_URI).getEClassifiers().get(
				7);
		}
		return dataRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getDataRule_Name() {
		return (EAttribute) getDataRule().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getDataRule_Description() {
		return (EAttribute) getDataRule().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getDataRule_Rule() {
		return (EAttribute) getDataRule().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getDataRule_RuleExpressionLanguage() {
		return (EAttribute) getDataRule().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getDataRule_Scope() {
		return (EReference) getDataRule().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getDataRule_Datatype() {
		return (EReference) getDataRule().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getDataRule_SemanticElement() {
		return (EReference) getDataRule().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getDataRule_Group() {
		return (EReference) getDataRule().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getSemanticElementSet() {
		if (semanticElementSetEClass == null) {
			semanticElementSetEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(8);
		}
		return semanticElementSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementSet_Name() {
		return (EAttribute) getSemanticElementSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementSet_Description() {
		return (EAttribute) getSemanticElementSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementSet_MessageModelName() {
		return (EAttribute) getSemanticElementSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElementSet_SyntaxModel() {
		return (EReference) getSemanticElementSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElementSet_Model() {
		return (EReference) getSemanticElementSet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElementSet_SemanticElements() {
		return (EReference) getSemanticElementSet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElementSet_Composite() {
		return (EReference) getSemanticElementSet().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getSemanticElement() {
		if (semanticElementEClass == null) {
			semanticElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(9);
		}
		return semanticElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElement_Name() {
		return (EAttribute) getSemanticElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElement_Description() {
		return (EAttribute) getSemanticElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElement_ElementType() {
		return (EAttribute) getSemanticElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_Datatype() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElement_PropertyQualifier() {
		return (EAttribute) getSemanticElement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_Composite() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_ElementSet() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_BusinessRules() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_DataRules() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_Relationships() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElement_MultipleInstances() {
		return (EAttribute) getSemanticElement().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_MapFromMdmi() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElement_Ordering() {
		return (EAttribute) getSemanticElement().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElement_OrderingLanguage() {
		return (EAttribute) getSemanticElement().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_ComputedValue() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_ComputedInValue() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_MapToMdmi() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_Parent() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_Children() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_SyntaxNode() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_ComputedOutValue() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElement_Keywords() {
		return (EReference) getSemanticElement().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElement_EnumValueField() {
		return (EAttribute) getSemanticElement().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElement_EnumValueDescrField() {
		return (EAttribute) getSemanticElement().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getSimpleMessageComposite() {
		if (simpleMessageCompositeEClass == null) {
			simpleMessageCompositeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(10);
		}
		return simpleMessageCompositeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSimpleMessageComposite_Name() {
		return (EAttribute) getSimpleMessageComposite().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSimpleMessageComposite_SemanticElements() {
		return (EReference) getSimpleMessageComposite().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSimpleMessageComposite_ElementSet() {
		return (EReference) getSimpleMessageComposite().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSimpleMessageComposite_Description() {
		return (EAttribute) getSimpleMessageComposite().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getMessageComposite() {
		if (messageCompositeEClass == null) {
			messageCompositeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(11);
		}
		return messageCompositeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageComposite_Composites() {
		return (EReference) getMessageComposite().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMessageComposite_Owner() {
		return (EReference) getMessageComposite().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getSemanticElementBusinessRule() {
		if (semanticElementBusinessRuleEClass == null) {
			semanticElementBusinessRuleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(12);
		}
		return semanticElementBusinessRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementBusinessRule_Name() {
		return (EAttribute) getSemanticElementBusinessRule().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementBusinessRule_Description() {
		return (EAttribute) getSemanticElementBusinessRule().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementBusinessRule_Rule() {
		return (EAttribute) getSemanticElementBusinessRule().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementBusinessRule_RuleExpressionLanguage() {
		return (EAttribute) getSemanticElementBusinessRule().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElementBusinessRule_SemanticElement() {
		return (EReference) getSemanticElementBusinessRule().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getSemanticElementRelationship() {
		if (semanticElementRelationshipEClass == null) {
			semanticElementRelationshipEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(13);
		}
		return semanticElementRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementRelationship_Name() {
		return (EAttribute) getSemanticElementRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementRelationship_Description() {
		return (EAttribute) getSemanticElementRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementRelationship_Rule() {
		return (EAttribute) getSemanticElementRelationship().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementRelationship_RuleExpressionLanguage() {
		return (EAttribute) getSemanticElementRelationship().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElementRelationship_Context() {
		return (EReference) getSemanticElementRelationship().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementRelationship_MinOccurs() {
		return (EAttribute) getSemanticElementRelationship().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementRelationship_MaxOccurs() {
		return (EAttribute) getSemanticElementRelationship().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementRelationship_SourceIsInstance() {
		return (EAttribute) getSemanticElementRelationship().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSemanticElementRelationship_TargetIsInstance() {
		return (EAttribute) getSemanticElementRelationship().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getSemanticElementRelationship_RelatedSemanticElement() {
		return (EReference) getSemanticElementRelationship().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getMDMIBusinessElementReference() {
		if (mdmiBusinessElementReferenceEClass == null) {
			mdmiBusinessElementReferenceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(14);
		}
		return mdmiBusinessElementReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementReference_Name() {
		return (EAttribute) getMDMIBusinessElementReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementReference_Description() {
		return (EAttribute) getMDMIBusinessElementReference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementReference_Reference() {
		return (EAttribute) getMDMIBusinessElementReference().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementReference_UniqueIdentifier() {
		return (EAttribute) getMDMIBusinessElementReference().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMDMIBusinessElementReference_BusinessRules() {
		return (EReference) getMDMIBusinessElementReference().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMDMIBusinessElementReference_DomainDictionaryReference() {
		return (EReference) getMDMIBusinessElementReference().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMDMIBusinessElementReference_ReferenceDatatype() {
		return (EReference) getMDMIBusinessElementReference().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementReference_EnumValueSetField() {
		return (EAttribute) getMDMIBusinessElementReference().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementReference_EnumValueField() {
		return (EAttribute) getMDMIBusinessElementReference().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementReference_EnumValueDescrField() {
		return (EAttribute) getMDMIBusinessElementReference().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementReference_EnumValueSet() {
		return (EAttribute) getMDMIBusinessElementReference().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementReference_Readonly() {
		return (EAttribute) getMDMIBusinessElementReference().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getMDMIBusinessElementRule() {
		if (mdmiBusinessElementRuleEClass == null) {
			mdmiBusinessElementRuleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(15);
		}
		return mdmiBusinessElementRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementRule_Name() {
		return (EAttribute) getMDMIBusinessElementRule().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementRule_Description() {
		return (EAttribute) getMDMIBusinessElementRule().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementRule_Rule() {
		return (EAttribute) getMDMIBusinessElementRule().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIBusinessElementRule_RuleExpressionLanguage() {
		return (EAttribute) getMDMIBusinessElementRule().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMDMIBusinessElementRule_BusinessElement() {
		return (EReference) getMDMIBusinessElementRule().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getConversionRule() {
		if (conversionRuleEClass == null) {
			conversionRuleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(16);
		}
		return conversionRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getConversionRule_Name() {
		return (EAttribute) getConversionRule().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getConversionRule_Description() {
		return (EAttribute) getConversionRule().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getConversionRule_RuleExpressionLanguage() {
		return (EAttribute) getConversionRule().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getConversionRule_EnumExtResolverUri() {
		return (EAttribute) getConversionRule().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getConversionRule_BusinessElement() {
		return (EReference) getConversionRule().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getConversionRule_Rule() {
		return (EAttribute) getConversionRule().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getMDMIDomainDictionaryReference() {
		if (mdmiDomainDictionaryReferenceEClass == null) {
			mdmiDomainDictionaryReferenceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(17);
		}
		return mdmiDomainDictionaryReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIDomainDictionaryReference_Name() {
		return (EAttribute) getMDMIDomainDictionaryReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIDomainDictionaryReference_Description() {
		return (EAttribute) getMDMIDomainDictionaryReference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMDMIDomainDictionaryReference_BusinessElements() {
		return (EReference) getMDMIDomainDictionaryReference().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIDomainDictionaryReference_Reference() {
		return (EAttribute) getMDMIDomainDictionaryReference().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMDMIDomainDictionaryReference_Group() {
		return (EReference) getMDMIDomainDictionaryReference().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getMDMIExpression() {
		if (mdmiExpressionEClass == null) {
			mdmiExpressionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(18);
		}
		return mdmiExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIExpression_Expression() {
		return (EAttribute) getMDMIExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIExpression_Language() {
		return (EAttribute) getMDMIExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getKeyword() {
		if (keywordEClass == null) {
			keywordEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(MDMIPackage.eNS_URI).getEClassifiers().get(
				19);
		}
		return keywordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getKeyword_Description() {
		return (EAttribute) getKeyword().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getKeyword_Keyword() {
		return (EAttribute) getKeyword().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getKeyword_KeywordValue() {
		return (EAttribute) getKeyword().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getKeyword_Reference() {
		return (EAttribute) getKeyword().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getKeyword_Owner() {
		return (EReference) getKeyword().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getMDMIDatatype() {
		if (mdmiDatatypeEClass == null) {
			mdmiDatatypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(20);
		}
		return mdmiDatatypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIDatatype_TypeName() {
		return (EAttribute) getMDMIDatatype().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIDatatype_Description() {
		return (EAttribute) getMDMIDatatype().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIDatatype_Reference() {
		return (EAttribute) getMDMIDatatype().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIDatatype_IsReadonly() {
		return (EAttribute) getMDMIDatatype().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIDatatype_TypeSpec() {
		return (EAttribute) getMDMIDatatype().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMDMIDatatype_Restriction() {
		return (EAttribute) getMDMIDatatype().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getDTSPrimitive() {
		if (dtsPrimitiveEClass == null) {
			dtsPrimitiveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(23);
		}
		return dtsPrimitiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getDTCStructured() {
		if (dtcStructuredEClass == null) {
			dtcStructuredEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(24);
		}
		return dtcStructuredEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getDTCStructured_Fields() {
		return (EReference) getDTCStructured().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getField() {
		if (fieldEClass == null) {
			fieldEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(MDMIPackage.eNS_URI).getEClassifiers().get(
				25);
		}
		return fieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getField_Name() {
		return (EAttribute) getField().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getField_MinOccurs() {
		return (EAttribute) getField().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getField_MaxOccurs() {
		return (EAttribute) getField().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getField_Datatype() {
		return (EReference) getField().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getField_Description() {
		return (EAttribute) getField().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getDTExternal() {
		if (dtExternalEClass == null) {
			dtExternalEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(26);
		}
		return dtExternalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getDTSDerived() {
		if (dtsDerivedEClass == null) {
			dtsDerivedEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(27);
		}
		return dtsDerivedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getDTSDerived_BaseType() {
		return (EReference) getDTSDerived().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getDTCChoice() {
		if (dtcChoiceEClass == null) {
			dtcChoiceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(28);
		}
		return dtcChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getDTCChoice_Fields() {
		return (EReference) getDTCChoice().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getDTSEnumerated() {
		if (dtsEnumeratedEClass == null) {
			dtsEnumeratedEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(29);
		}
		return dtsEnumeratedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getDTSEnumerated_Literals() {
		return (EReference) getDTSEnumerated().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getEnumerationLiteral() {
		if (enumerationLiteralEClass == null) {
			enumerationLiteralEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(30);
		}
		return enumerationLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getEnumerationLiteral_Name() {
		return (EAttribute) getEnumerationLiteral().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getEnumerationLiteral_Description() {
		return (EAttribute) getEnumerationLiteral().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getEnumerationLiteral_Code() {
		return (EAttribute) getEnumerationLiteral().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getDatatypeMap() {
		if (datatypeMapEClass == null) {
			datatypeMapEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(31);
		}
		return datatypeMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getDatatypeMap_Name() {
		return (EAttribute) getDatatypeMap().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getDatatypeMap_Description() {
		return (EAttribute) getDatatypeMap().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getDatatypeMap_FromMDMI() {
		return (EAttribute) getDatatypeMap().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getDatatypeMap_ToMDMI() {
		return (EAttribute) getDatatypeMap().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getDatatypeMap_MdmiDatatype() {
		return (EReference) getDatatypeMap().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getDatatypeMap_MessageDatatype() {
		return (EReference) getDatatypeMap().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EEnum getMessageElementType() {
		if (messageElementTypeEEnum == null) {
			messageElementTypeEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(21);
		}
		return messageElementTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EDataType getURI() {
		if (uriEDataType == null) {
			uriEDataType = (EDataType) EPackage.Registry.INSTANCE.getEPackage(
				MDMIPackage.eNS_URI).getEClassifiers().get(22);
		}
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIFactory getMDMIFactory() {
		return (MDMIFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Loads the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded) {
			return;
		}
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		} catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage) resource.getContents().get(0));
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed) {
			return;
		}
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("org.mdmi." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} // MDMIPackageImpl
