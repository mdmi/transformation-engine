/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.mdmi.MDMIFactory
 * @model kind="package"
 * @generated
 */
public interface MDMIPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "mdmi";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "http://schema.omg.org/spec/MDMI/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "mdmi";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	MDMIPackage eINSTANCE = org.mdmi.impl.MDMIPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.mdmi.impl.MessageModelImpl <em>Message Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.MessageModelImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getMessageModel()
	 * @generated
	 */
	int MESSAGE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Message Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_MODEL__MESSAGE_MODEL_NAME = 0;

	/**
	 * The feature id for the '<em><b>Syntax Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_MODEL__SYNTAX_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Element Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_MODEL__ELEMENT_SET = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_MODEL__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_MODEL__SOURCE = 4;

	/**
	 * The feature id for the '<em><b>Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_MODEL__GROUP = 5;

	/**
	 * The number of structural features of the '<em>Message Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_MODEL_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.MessageSyntaxModelImpl <em>Message Syntax Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.MessageSyntaxModelImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getMessageSyntaxModel()
	 * @generated
	 */
	int MESSAGE_SYNTAX_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_SYNTAX_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_SYNTAX_MODEL__MODEL = 1;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_SYNTAX_MODEL__ROOT = 2;

	/**
	 * The feature id for the '<em><b>Element Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_SYNTAX_MODEL__ELEMENT_SET = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_SYNTAX_MODEL__DESCRIPTION = 4;

	/**
	 * The number of structural features of the '<em>Message Syntax Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_SYNTAX_MODEL_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.NodeImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NODE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NODE__MIN_OCCURS = 2;

	/**
	 * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NODE__MAX_OCCURS = 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NODE__LOCATION = 4;

	/**
	 * The feature id for the '<em><b>Location Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NODE__LOCATION_EXPRESSION_LANGUAGE = 5;

	/**
	 * The feature id for the '<em><b>Syntax Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NODE__SYNTAX_MODEL = 6;

	/**
	 * The feature id for the '<em><b>Semantic Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NODE__SEMANTIC_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NODE__FIELD_NAME = 8;

	/**
	 * The feature id for the '<em><b>Is Syntactic Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NODE__IS_SYNTACTIC_FIELD = 9;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NODE__PATH = 10;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.BagImpl <em>Bag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.BagImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getBag()
	 * @generated
	 */
	int BAG = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__DESCRIPTION = NODE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__MIN_OCCURS = NODE__MIN_OCCURS;

	/**
	 * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__MAX_OCCURS = NODE__MAX_OCCURS;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__LOCATION = NODE__LOCATION;

	/**
	 * The feature id for the '<em><b>Location Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__LOCATION_EXPRESSION_LANGUAGE = NODE__LOCATION_EXPRESSION_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Syntax Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__SYNTAX_MODEL = NODE__SYNTAX_MODEL;

	/**
	 * The feature id for the '<em><b>Semantic Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__SEMANTIC_ELEMENT = NODE__SEMANTIC_ELEMENT;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__FIELD_NAME = NODE__FIELD_NAME;

	/**
	 * The feature id for the '<em><b>Is Syntactic Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__IS_SYNTACTIC_FIELD = NODE__IS_SYNTACTIC_FIELD;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__PATH = NODE__PATH;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__IS_UNIQUE = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__IS_ORDERED = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG__NODES = NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BAG_FEATURE_COUNT = NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.ChoiceImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__DESCRIPTION = NODE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__MIN_OCCURS = NODE__MIN_OCCURS;

	/**
	 * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__MAX_OCCURS = NODE__MAX_OCCURS;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__LOCATION = NODE__LOCATION;

	/**
	 * The feature id for the '<em><b>Location Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__LOCATION_EXPRESSION_LANGUAGE = NODE__LOCATION_EXPRESSION_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Syntax Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__SYNTAX_MODEL = NODE__SYNTAX_MODEL;

	/**
	 * The feature id for the '<em><b>Semantic Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__SEMANTIC_ELEMENT = NODE__SEMANTIC_ELEMENT;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__FIELD_NAME = NODE__FIELD_NAME;

	/**
	 * The feature id for the '<em><b>Is Syntactic Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__IS_SYNTACTIC_FIELD = NODE__IS_SYNTACTIC_FIELD;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__PATH = NODE__PATH;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__CONSTRAINT = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__CONSTRAINT_EXPRESSION_LANGUAGE = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE__NODES = NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.LeafSyntaxTranslatorImpl <em>Leaf Syntax Translator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.LeafSyntaxTranslatorImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getLeafSyntaxTranslator()
	 * @generated
	 */
	int LEAF_SYNTAX_TRANSLATOR = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__DESCRIPTION = NODE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__MIN_OCCURS = NODE__MIN_OCCURS;

	/**
	 * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__MAX_OCCURS = NODE__MAX_OCCURS;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__LOCATION = NODE__LOCATION;

	/**
	 * The feature id for the '<em><b>Location Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__LOCATION_EXPRESSION_LANGUAGE = NODE__LOCATION_EXPRESSION_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Syntax Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__SYNTAX_MODEL = NODE__SYNTAX_MODEL;

	/**
	 * The feature id for the '<em><b>Semantic Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__SEMANTIC_ELEMENT = NODE__SEMANTIC_ELEMENT;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__FIELD_NAME = NODE__FIELD_NAME;

	/**
	 * The feature id for the '<em><b>Is Syntactic Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__IS_SYNTACTIC_FIELD = NODE__IS_SYNTACTIC_FIELD;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__PATH = NODE__PATH;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__FORMAT = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Format Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR__FORMAT_EXPRESSION_LANGUAGE = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Leaf Syntax Translator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int LEAF_SYNTAX_TRANSLATOR_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.MessageGroupImpl <em>Message Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.MessageGroupImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getMessageGroup()
	 * @generated
	 */
	int MESSAGE_GROUP = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Data Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__DATA_RULES = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Default Location Expr Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__DEFAULT_LOCATION_EXPR_LANG = 3;

	/**
	 * The feature id for the '<em><b>Default Constraint Expr Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__DEFAULT_CONSTRAINT_EXPR_LANG = 4;

	/**
	 * The feature id for the '<em><b>Default Rule Expr Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__DEFAULT_RULE_EXPR_LANG = 5;

	/**
	 * The feature id for the '<em><b>Default Format Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__DEFAULT_FORMAT_EXPRESSION_LANGUAGE = 6;

	/**
	 * The feature id for the '<em><b>Default Ordering Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__DEFAULT_ORDERING_EXPRESSION_LANGUAGE = 7;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__MODELS = 8;

	/**
	 * The feature id for the '<em><b>Domain Dictionary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__DOMAIN_DICTIONARY = 9;

	/**
	 * The feature id for the '<em><b>Default MDMI Expresion Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__DEFAULT_MDMI_EXPRESION_LANGUAGE = 10;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__RULES = 11;

	/**
	 * The feature id for the '<em><b>Datatypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__DATATYPES = 12;

	/**
	 * The feature id for the '<em><b>Datatype Maps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP__DATATYPE_MAPS = 13;

	/**
	 * The number of structural features of the '<em>Message Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_GROUP_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.DataRuleImpl <em>Data Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.DataRuleImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getDataRule()
	 * @generated
	 */
	int DATA_RULE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATA_RULE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATA_RULE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATA_RULE__RULE = 2;

	/**
	 * The feature id for the '<em><b>Rule Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATA_RULE__RULE_EXPRESSION_LANGUAGE = 3;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATA_RULE__SCOPE = 4;

	/**
	 * The feature id for the '<em><b>Datatype</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATA_RULE__DATATYPE = 5;

	/**
	 * The feature id for the '<em><b>Semantic Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATA_RULE__SEMANTIC_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATA_RULE__GROUP = 7;

	/**
	 * The number of structural features of the '<em>Data Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATA_RULE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.SemanticElementSetImpl <em>Semantic Element Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.SemanticElementSetImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getSemanticElementSet()
	 * @generated
	 */
	int SEMANTIC_ELEMENT_SET = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_SET__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_SET__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Message Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_SET__MESSAGE_MODEL_NAME = 2;

	/**
	 * The feature id for the '<em><b>Syntax Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_SET__SYNTAX_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_SET__MODEL = 4;

	/**
	 * The feature id for the '<em><b>Semantic Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_SET__SEMANTIC_ELEMENTS = 5;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_SET__COMPOSITE = 6;

	/**
	 * The number of structural features of the '<em>Semantic Element Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_SET_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.SemanticElementImpl <em>Semantic Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.SemanticElementImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getSemanticElement()
	 * @generated
	 */
	int SEMANTIC_ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__ELEMENT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__DATATYPE = 3;

	/**
	 * The feature id for the '<em><b>Property Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__PROPERTY_QUALIFIER = 4;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__COMPOSITE = 5;

	/**
	 * The feature id for the '<em><b>Element Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__ELEMENT_SET = 6;

	/**
	 * The feature id for the '<em><b>Business Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__BUSINESS_RULES = 7;

	/**
	 * The feature id for the '<em><b>Data Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__DATA_RULES = 8;

	/**
	 * The feature id for the '<em><b>Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__RELATIONSHIPS = 9;

	/**
	 * The feature id for the '<em><b>Multiple Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__MULTIPLE_INSTANCES = 10;

	/**
	 * The feature id for the '<em><b>Map From Mdmi</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__MAP_FROM_MDMI = 11;

	/**
	 * The feature id for the '<em><b>Ordering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__ORDERING = 12;

	/**
	 * The feature id for the '<em><b>Ordering Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__ORDERING_LANGUAGE = 13;

	/**
	 * The feature id for the '<em><b>Computed Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__COMPUTED_VALUE = 14;

	/**
	 * The feature id for the '<em><b>Computed In Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__COMPUTED_IN_VALUE = 15;

	/**
	 * The feature id for the '<em><b>Map To Mdmi</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__MAP_TO_MDMI = 16;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__PARENT = 17;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__CHILDREN = 18;

	/**
	 * The feature id for the '<em><b>Syntax Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__SYNTAX_NODE = 19;

	/**
	 * The feature id for the '<em><b>Computed Out Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__COMPUTED_OUT_VALUE = 20;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__KEYWORDS = 21;

	/**
	 * The feature id for the '<em><b>Enum Value Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__ENUM_VALUE_FIELD = 22;

	/**
	 * The feature id for the '<em><b>Enum Value Descr Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT__ENUM_VALUE_DESCR_FIELD = 23;

	/**
	 * The number of structural features of the '<em>Semantic Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_FEATURE_COUNT = 24;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.SimpleMessageCompositeImpl <em>Simple Message Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.SimpleMessageCompositeImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getSimpleMessageComposite()
	 * @generated
	 */
	int SIMPLE_MESSAGE_COMPOSITE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MESSAGE_COMPOSITE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Semantic Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>Element Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MESSAGE_COMPOSITE__DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Simple Message Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MESSAGE_COMPOSITE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.MessageCompositeImpl <em>Message Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.MessageCompositeImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getMessageComposite()
	 * @generated
	 */
	int MESSAGE_COMPOSITE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COMPOSITE__NAME = SIMPLE_MESSAGE_COMPOSITE__NAME;

	/**
	 * The feature id for the '<em><b>Semantic Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS = SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Element Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COMPOSITE__ELEMENT_SET = SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COMPOSITE__DESCRIPTION = SIMPLE_MESSAGE_COMPOSITE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Composites</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COMPOSITE__COMPOSITES = SIMPLE_MESSAGE_COMPOSITE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COMPOSITE__OWNER = SIMPLE_MESSAGE_COMPOSITE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Message Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COMPOSITE_FEATURE_COUNT = SIMPLE_MESSAGE_COMPOSITE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.SemanticElementBusinessRuleImpl <em>Semantic Element Business Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.SemanticElementBusinessRuleImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getSemanticElementBusinessRule()
	 * @generated
	 */
	int SEMANTIC_ELEMENT_BUSINESS_RULE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_BUSINESS_RULE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_BUSINESS_RULE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_BUSINESS_RULE__RULE = 2;

	/**
	 * The feature id for the '<em><b>Rule Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_BUSINESS_RULE__RULE_EXPRESSION_LANGUAGE = 3;

	/**
	 * The feature id for the '<em><b>Semantic Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT = 4;

	/**
	 * The number of structural features of the '<em>Semantic Element Business Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_BUSINESS_RULE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.SemanticElementRelationshipImpl <em>Semantic Element Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.SemanticElementRelationshipImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getSemanticElementRelationship()
	 * @generated
	 */
	int SEMANTIC_ELEMENT_RELATIONSHIP = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_RELATIONSHIP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_RELATIONSHIP__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_RELATIONSHIP__RULE = 2;

	/**
	 * The feature id for the '<em><b>Rule Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_RELATIONSHIP__RULE_EXPRESSION_LANGUAGE = 3;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_RELATIONSHIP__CONTEXT = 4;

	/**
	 * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_RELATIONSHIP__MIN_OCCURS = 5;

	/**
	 * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_RELATIONSHIP__MAX_OCCURS = 6;

	/**
	 * The feature id for the '<em><b>Source Is Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_RELATIONSHIP__SOURCE_IS_INSTANCE = 7;

	/**
	 * The feature id for the '<em><b>Target Is Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_RELATIONSHIP__TARGET_IS_INSTANCE = 8;

	/**
	 * The feature id for the '<em><b>Related Semantic Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_RELATIONSHIP__RELATED_SEMANTIC_ELEMENT = 9;

	/**
	 * The number of structural features of the '<em>Semantic Element Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ELEMENT_RELATIONSHIP_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl <em>Business Element Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.MDMIBusinessElementReferenceImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getMDMIBusinessElementReference()
	 * @generated
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Unique Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE__UNIQUE_IDENTIFIER = 3;

	/**
	 * The feature id for the '<em><b>Business Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE__BUSINESS_RULES = 4;

	/**
	 * The feature id for the '<em><b>Domain Dictionary Reference</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Reference Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE_DATATYPE = 6;

	/**
	 * The feature id for the '<em><b>Enum Value Set Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET_FIELD = 7;

	/**
	 * The feature id for the '<em><b>Enum Value Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_FIELD = 8;

	/**
	 * The feature id for the '<em><b>Enum Value Descr Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_DESCR_FIELD = 9;

	/**
	 * The feature id for the '<em><b>Enum Value Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET = 10;

	/**
	 * The feature id for the '<em><b>Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE__READONLY = 11;

	/**
	 * The number of structural features of the '<em>Business Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_REFERENCE_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.MDMIBusinessElementRuleImpl <em>Business Element Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.MDMIBusinessElementRuleImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getMDMIBusinessElementRule()
	 * @generated
	 */
	int MDMI_BUSINESS_ELEMENT_RULE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_RULE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_RULE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_RULE__RULE = 2;

	/**
	 * The feature id for the '<em><b>Rule Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_RULE__RULE_EXPRESSION_LANGUAGE = 3;

	/**
	 * The feature id for the '<em><b>Business Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_RULE__BUSINESS_ELEMENT = 4;

	/**
	 * The number of structural features of the '<em>Business Element Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_BUSINESS_ELEMENT_RULE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.ConversionRuleImpl <em>Conversion Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.ConversionRuleImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getConversionRule()
	 * @generated
	 */
	int CONVERSION_RULE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONVERSION_RULE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONVERSION_RULE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Rule Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONVERSION_RULE__RULE_EXPRESSION_LANGUAGE = 2;

	/**
	 * The feature id for the '<em><b>Enum Ext Resolver Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONVERSION_RULE__ENUM_EXT_RESOLVER_URI = 3;

	/**
	 * The feature id for the '<em><b>Business Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONVERSION_RULE__BUSINESS_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONVERSION_RULE__RULE = 5;

	/**
	 * The number of structural features of the '<em>Conversion Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONVERSION_RULE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.MDMIDomainDictionaryReferenceImpl <em>Domain Dictionary Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.MDMIDomainDictionaryReferenceImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getMDMIDomainDictionaryReference()
	 * @generated
	 */
	int MDMI_DOMAIN_DICTIONARY_REFERENCE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DOMAIN_DICTIONARY_REFERENCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DOMAIN_DICTIONARY_REFERENCE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Business Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DOMAIN_DICTIONARY_REFERENCE__BUSINESS_ELEMENTS = 2;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DOMAIN_DICTIONARY_REFERENCE__REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP = 4;

	/**
	 * The number of structural features of the '<em>Domain Dictionary Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DOMAIN_DICTIONARY_REFERENCE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.MDMIExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.MDMIExpressionImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getMDMIExpression()
	 * @generated
	 */
	int MDMI_EXPRESSION = 18;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_EXPRESSION__EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_EXPRESSION__LANGUAGE = 1;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.KeywordImpl <em>Keyword</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.KeywordImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getKeyword()
	 * @generated
	 */
	int KEYWORD = 19;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int KEYWORD__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Keyword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int KEYWORD__KEYWORD = 1;

	/**
	 * The feature id for the '<em><b>Keyword Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int KEYWORD__KEYWORD_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int KEYWORD__REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int KEYWORD__OWNER = 4;

	/**
	 * The number of structural features of the '<em>Keyword</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int KEYWORD_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.MDMIDatatypeImpl <em>Datatype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.MDMIDatatypeImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getMDMIDatatype()
	 * @generated
	 */
	int MDMI_DATATYPE = 20;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DATATYPE__TYPE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DATATYPE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DATATYPE__REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Is Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DATATYPE__IS_READONLY = 3;

	/**
	 * The feature id for the '<em><b>Type Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DATATYPE__TYPE_SPEC = 4;

	/**
	 * The feature id for the '<em><b>Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DATATYPE__RESTRICTION = 5;

	/**
	 * The number of structural features of the '<em>Datatype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MDMI_DATATYPE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.DTSPrimitiveImpl <em>DTS Primitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.DTSPrimitiveImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getDTSPrimitive()
	 * @generated
	 */
	int DTS_PRIMITIVE = 21;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_PRIMITIVE__TYPE_NAME = MDMI_DATATYPE__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_PRIMITIVE__DESCRIPTION = MDMI_DATATYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_PRIMITIVE__REFERENCE = MDMI_DATATYPE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Is Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_PRIMITIVE__IS_READONLY = MDMI_DATATYPE__IS_READONLY;

	/**
	 * The feature id for the '<em><b>Type Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_PRIMITIVE__TYPE_SPEC = MDMI_DATATYPE__TYPE_SPEC;

	/**
	 * The feature id for the '<em><b>Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_PRIMITIVE__RESTRICTION = MDMI_DATATYPE__RESTRICTION;

	/**
	 * The number of structural features of the '<em>DTS Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_PRIMITIVE_FEATURE_COUNT = MDMI_DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.DTCStructuredImpl <em>DTC Structured</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.DTCStructuredImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getDTCStructured()
	 * @generated
	 */
	int DTC_STRUCTURED = 22;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_STRUCTURED__TYPE_NAME = MDMI_DATATYPE__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_STRUCTURED__DESCRIPTION = MDMI_DATATYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_STRUCTURED__REFERENCE = MDMI_DATATYPE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Is Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_STRUCTURED__IS_READONLY = MDMI_DATATYPE__IS_READONLY;

	/**
	 * The feature id for the '<em><b>Type Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_STRUCTURED__TYPE_SPEC = MDMI_DATATYPE__TYPE_SPEC;

	/**
	 * The feature id for the '<em><b>Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_STRUCTURED__RESTRICTION = MDMI_DATATYPE__RESTRICTION;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_STRUCTURED__FIELDS = MDMI_DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DTC Structured</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_STRUCTURED_FEATURE_COUNT = MDMI_DATATYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.FieldImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getField()
	 * @generated
	 */
	int FIELD = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FIELD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FIELD__MIN_OCCURS = 1;

	/**
	 * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FIELD__MAX_OCCURS = 2;

	/**
	 * The feature id for the '<em><b>Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FIELD__DATATYPE = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FIELD__DESCRIPTION = 4;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.DTExternalImpl <em>DT External</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.DTExternalImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getDTExternal()
	 * @generated
	 */
	int DT_EXTERNAL = 24;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DT_EXTERNAL__TYPE_NAME = DTS_PRIMITIVE__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DT_EXTERNAL__DESCRIPTION = DTS_PRIMITIVE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DT_EXTERNAL__REFERENCE = DTS_PRIMITIVE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Is Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DT_EXTERNAL__IS_READONLY = DTS_PRIMITIVE__IS_READONLY;

	/**
	 * The feature id for the '<em><b>Type Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DT_EXTERNAL__TYPE_SPEC = DTS_PRIMITIVE__TYPE_SPEC;

	/**
	 * The feature id for the '<em><b>Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DT_EXTERNAL__RESTRICTION = DTS_PRIMITIVE__RESTRICTION;

	/**
	 * The number of structural features of the '<em>DT External</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DT_EXTERNAL_FEATURE_COUNT = DTS_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.DTSDerivedImpl <em>DTS Derived</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.DTSDerivedImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getDTSDerived()
	 * @generated
	 */
	int DTS_DERIVED = 25;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_DERIVED__TYPE_NAME = DTS_PRIMITIVE__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_DERIVED__DESCRIPTION = DTS_PRIMITIVE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_DERIVED__REFERENCE = DTS_PRIMITIVE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Is Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_DERIVED__IS_READONLY = DTS_PRIMITIVE__IS_READONLY;

	/**
	 * The feature id for the '<em><b>Type Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_DERIVED__TYPE_SPEC = DTS_PRIMITIVE__TYPE_SPEC;

	/**
	 * The feature id for the '<em><b>Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_DERIVED__RESTRICTION = DTS_PRIMITIVE__RESTRICTION;

	/**
	 * The feature id for the '<em><b>Base Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_DERIVED__BASE_TYPE = DTS_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DTS Derived</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_DERIVED_FEATURE_COUNT = DTS_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.DTCChoiceImpl <em>DTC Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.DTCChoiceImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getDTCChoice()
	 * @generated
	 */
	int DTC_CHOICE = 26;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_CHOICE__TYPE_NAME = MDMI_DATATYPE__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_CHOICE__DESCRIPTION = MDMI_DATATYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_CHOICE__REFERENCE = MDMI_DATATYPE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Is Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_CHOICE__IS_READONLY = MDMI_DATATYPE__IS_READONLY;

	/**
	 * The feature id for the '<em><b>Type Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_CHOICE__TYPE_SPEC = MDMI_DATATYPE__TYPE_SPEC;

	/**
	 * The feature id for the '<em><b>Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_CHOICE__RESTRICTION = MDMI_DATATYPE__RESTRICTION;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_CHOICE__FIELDS = MDMI_DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DTC Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTC_CHOICE_FEATURE_COUNT = MDMI_DATATYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.DTSEnumeratedImpl <em>DTS Enumerated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.DTSEnumeratedImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getDTSEnumerated()
	 * @generated
	 */
	int DTS_ENUMERATED = 27;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_ENUMERATED__TYPE_NAME = MDMI_DATATYPE__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_ENUMERATED__DESCRIPTION = MDMI_DATATYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_ENUMERATED__REFERENCE = MDMI_DATATYPE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Is Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_ENUMERATED__IS_READONLY = MDMI_DATATYPE__IS_READONLY;

	/**
	 * The feature id for the '<em><b>Type Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_ENUMERATED__TYPE_SPEC = MDMI_DATATYPE__TYPE_SPEC;

	/**
	 * The feature id for the '<em><b>Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_ENUMERATED__RESTRICTION = MDMI_DATATYPE__RESTRICTION;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_ENUMERATED__LITERALS = MDMI_DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DTS Enumerated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DTS_ENUMERATED_FEATURE_COUNT = MDMI_DATATYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.EnumerationLiteralImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getEnumerationLiteral()
	 * @generated
	 */
	int ENUMERATION_LITERAL = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__CODE = 2;

	/**
	 * The number of structural features of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.mdmi.impl.DatatypeMapImpl <em>Datatype Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.impl.DatatypeMapImpl
	 * @see org.mdmi.impl.MDMIPackageImpl#getDatatypeMap()
	 * @generated
	 */
	int DATATYPE_MAP = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATATYPE_MAP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATATYPE_MAP__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>From MDMI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATATYPE_MAP__FROM_MDMI = 2;

	/**
	 * The feature id for the '<em><b>To MDMI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATATYPE_MAP__TO_MDMI = 3;

	/**
	 * The feature id for the '<em><b>Mdmi Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATATYPE_MAP__MDMI_DATATYPE = 4;

	/**
	 * The feature id for the '<em><b>Message Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATATYPE_MAP__MESSAGE_DATATYPE = 5;

	/**
	 * The number of structural features of the '<em>Datatype Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATATYPE_MAP_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.mdmi.MessageElementType <em>Message Element Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.mdmi.MessageElementType
	 * @see org.mdmi.impl.MDMIPackageImpl#getMessageElementType()
	 * @generated
	 */
	int MESSAGE_ELEMENT_TYPE = 30;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see java.lang.String
	 * @see org.mdmi.impl.MDMIPackageImpl#getURI()
	 * @generated
	 */
	int URI = 31;

	/**
	 * Returns the meta object for class '{@link org.mdmi.MessageModel <em>Message Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Message Model</em>'.
	 * @see org.mdmi.MessageModel
	 * @generated
	 */
	EClass getMessageModel();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageModel#getMessageModelName <em>Message Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Message Model Name</em>'.
	 * @see org.mdmi.MessageModel#getMessageModelName()
	 * @see #getMessageModel()
	 * @generated
	 */
	EAttribute getMessageModel_MessageModelName();

	/**
	 * Returns the meta object for the containment reference '{@link org.mdmi.MessageModel#getSyntaxModel <em>Syntax Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Syntax Model</em>'.
	 * @see org.mdmi.MessageModel#getSyntaxModel()
	 * @see #getMessageModel()
	 * @generated
	 */
	EReference getMessageModel_SyntaxModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.mdmi.MessageModel#getElementSet <em>Element Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Element Set</em>'.
	 * @see org.mdmi.MessageModel#getElementSet()
	 * @see #getMessageModel()
	 * @generated
	 */
	EReference getMessageModel_ElementSet();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.MessageModel#getDescription()
	 * @see #getMessageModel()
	 * @generated
	 */
	EAttribute getMessageModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageModel#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.mdmi.MessageModel#getSource()
	 * @see #getMessageModel()
	 * @generated
	 */
	EAttribute getMessageModel_Source();

	/**
	 * Returns the meta object for the container reference '{@link org.mdmi.MessageModel#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Group</em>'.
	 * @see org.mdmi.MessageModel#getGroup()
	 * @see #getMessageModel()
	 * @generated
	 */
	EReference getMessageModel_Group();

	/**
	 * Returns the meta object for class '{@link org.mdmi.MessageSyntaxModel <em>Message Syntax Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Message Syntax Model</em>'.
	 * @see org.mdmi.MessageSyntaxModel
	 * @generated
	 */
	EClass getMessageSyntaxModel();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageSyntaxModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.MessageSyntaxModel#getName()
	 * @see #getMessageSyntaxModel()
	 * @generated
	 */
	EAttribute getMessageSyntaxModel_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.mdmi.MessageSyntaxModel#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Model</em>'.
	 * @see org.mdmi.MessageSyntaxModel#getModel()
	 * @see #getMessageSyntaxModel()
	 * @generated
	 */
	EReference getMessageSyntaxModel_Model();

	/**
	 * Returns the meta object for the containment reference '{@link org.mdmi.MessageSyntaxModel#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see org.mdmi.MessageSyntaxModel#getRoot()
	 * @see #getMessageSyntaxModel()
	 * @generated
	 */
	EReference getMessageSyntaxModel_Root();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.MessageSyntaxModel#getElementSet <em>Element Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Element Set</em>'.
	 * @see org.mdmi.MessageSyntaxModel#getElementSet()
	 * @see #getMessageSyntaxModel()
	 * @generated
	 */
	EReference getMessageSyntaxModel_ElementSet();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageSyntaxModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.MessageSyntaxModel#getDescription()
	 * @see #getMessageSyntaxModel()
	 * @generated
	 */
	EAttribute getMessageSyntaxModel_Description();

	/**
	 * Returns the meta object for class '{@link org.mdmi.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.mdmi.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Node#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.Node#getDescription()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Node#getMinOccurs <em>Min Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Min Occurs</em>'.
	 * @see org.mdmi.Node#getMinOccurs()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_MinOccurs();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Node#getMaxOccurs <em>Max Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Max Occurs</em>'.
	 * @see org.mdmi.Node#getMaxOccurs()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_MaxOccurs();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Node#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.mdmi.Node#getLocation()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Node#getLocationExpressionLanguage <em>Location Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Location Expression Language</em>'.
	 * @see org.mdmi.Node#getLocationExpressionLanguage()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_LocationExpressionLanguage();

	/**
	 * Returns the meta object for the container reference '{@link org.mdmi.Node#getSyntaxModel <em>Syntax Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Syntax Model</em>'.
	 * @see org.mdmi.Node#getSyntaxModel()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_SyntaxModel();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.Node#getSemanticElement <em>Semantic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Semantic Element</em>'.
	 * @see org.mdmi.Node#getSemanticElement()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_SemanticElement();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Node#getFieldName <em>Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Field Name</em>'.
	 * @see org.mdmi.Node#getFieldName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_FieldName();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Node#isIsSyntacticField <em>Is Syntactic Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Is Syntactic Field</em>'.
	 * @see org.mdmi.Node#isIsSyntacticField()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_IsSyntacticField();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Node#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.mdmi.Node#getPath()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Path();

	/**
	 * Returns the meta object for class '{@link org.mdmi.Bag <em>Bag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Bag</em>'.
	 * @see org.mdmi.Bag
	 * @generated
	 */
	EClass getBag();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Bag#isIsUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see org.mdmi.Bag#isIsUnique()
	 * @see #getBag()
	 * @generated
	 */
	EAttribute getBag_IsUnique();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Bag#isIsOrdered <em>Is Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Is Ordered</em>'.
	 * @see org.mdmi.Bag#isIsOrdered()
	 * @see #getBag()
	 * @generated
	 */
	EAttribute getBag_IsOrdered();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.Bag#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.mdmi.Bag#getNodes()
	 * @see #getBag()
	 * @generated
	 */
	EReference getBag_Nodes();

	/**
	 * Returns the meta object for class '{@link org.mdmi.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see org.mdmi.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Choice#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see org.mdmi.Choice#getConstraint()
	 * @see #getChoice()
	 * @generated
	 */
	EAttribute getChoice_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Choice#getConstraintExpressionLanguage <em>Constraint Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Constraint Expression Language</em>'.
	 * @see org.mdmi.Choice#getConstraintExpressionLanguage()
	 * @see #getChoice()
	 * @generated
	 */
	EAttribute getChoice_ConstraintExpressionLanguage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.Choice#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.mdmi.Choice#getNodes()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_Nodes();

	/**
	 * Returns the meta object for class '{@link org.mdmi.LeafSyntaxTranslator <em>Leaf Syntax Translator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Leaf Syntax Translator</em>'.
	 * @see org.mdmi.LeafSyntaxTranslator
	 * @generated
	 */
	EClass getLeafSyntaxTranslator();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.LeafSyntaxTranslator#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.mdmi.LeafSyntaxTranslator#getFormat()
	 * @see #getLeafSyntaxTranslator()
	 * @generated
	 */
	EAttribute getLeafSyntaxTranslator_Format();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.LeafSyntaxTranslator#getFormatExpressionLanguage <em>Format Expression
	 * Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Format Expression Language</em>'.
	 * @see org.mdmi.LeafSyntaxTranslator#getFormatExpressionLanguage()
	 * @see #getLeafSyntaxTranslator()
	 * @generated
	 */
	EAttribute getLeafSyntaxTranslator_FormatExpressionLanguage();

	/**
	 * Returns the meta object for class '{@link org.mdmi.MessageGroup <em>Message Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Message Group</em>'.
	 * @see org.mdmi.MessageGroup
	 * @generated
	 */
	EClass getMessageGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.MessageGroup#getName()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EAttribute getMessageGroup_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.MessageGroup#getDataRules <em>Data Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Data Rules</em>'.
	 * @see org.mdmi.MessageGroup#getDataRules()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EReference getMessageGroup_DataRules();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageGroup#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.MessageGroup#getDescription()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EAttribute getMessageGroup_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageGroup#getDefaultLocationExprLang <em>Default Location Expr Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Default Location Expr Lang</em>'.
	 * @see org.mdmi.MessageGroup#getDefaultLocationExprLang()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EAttribute getMessageGroup_DefaultLocationExprLang();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageGroup#getDefaultConstraintExprLang <em>Default Constraint Expr Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Default Constraint Expr Lang</em>'.
	 * @see org.mdmi.MessageGroup#getDefaultConstraintExprLang()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EAttribute getMessageGroup_DefaultConstraintExprLang();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageGroup#getDefaultRuleExprLang <em>Default Rule Expr Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Default Rule Expr Lang</em>'.
	 * @see org.mdmi.MessageGroup#getDefaultRuleExprLang()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EAttribute getMessageGroup_DefaultRuleExprLang();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageGroup#getDefaultFormatExpressionLanguage <em>Default Format Expression
	 * Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Default Format Expression Language</em>'.
	 * @see org.mdmi.MessageGroup#getDefaultFormatExpressionLanguage()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EAttribute getMessageGroup_DefaultFormatExpressionLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageGroup#getDefaultOrderingExpressionLanguage <em>Default Ordering Expression
	 * Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Default Ordering Expression Language</em>'.
	 * @see org.mdmi.MessageGroup#getDefaultOrderingExpressionLanguage()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EAttribute getMessageGroup_DefaultOrderingExpressionLanguage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.MessageGroup#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Models</em>'.
	 * @see org.mdmi.MessageGroup#getModels()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EReference getMessageGroup_Models();

	/**
	 * Returns the meta object for the containment reference '{@link org.mdmi.MessageGroup#getDomainDictionary <em>Domain Dictionary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Domain Dictionary</em>'.
	 * @see org.mdmi.MessageGroup#getDomainDictionary()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EReference getMessageGroup_DomainDictionary();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MessageGroup#getDefaultMDMIExpresionLanguage <em>Default MDMI Expresion
	 * Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Default MDMI Expresion Language</em>'.
	 * @see org.mdmi.MessageGroup#getDefaultMDMIExpresionLanguage()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EAttribute getMessageGroup_DefaultMDMIExpresionLanguage();

	/**
	 * Returns the meta object for the reference list '{@link org.mdmi.MessageGroup#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Rules</em>'.
	 * @see org.mdmi.MessageGroup#getRules()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EReference getMessageGroup_Rules();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.MessageGroup#getDatatypes <em>Datatypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Datatypes</em>'.
	 * @see org.mdmi.MessageGroup#getDatatypes()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EReference getMessageGroup_Datatypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.MessageGroup#getDatatypeMaps <em>Datatype Maps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Datatype Maps</em>'.
	 * @see org.mdmi.MessageGroup#getDatatypeMaps()
	 * @see #getMessageGroup()
	 * @generated
	 */
	EReference getMessageGroup_DatatypeMaps();

	/**
	 * Returns the meta object for class '{@link org.mdmi.DataRule <em>Data Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Data Rule</em>'.
	 * @see org.mdmi.DataRule
	 * @generated
	 */
	EClass getDataRule();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.DataRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.DataRule#getName()
	 * @see #getDataRule()
	 * @generated
	 */
	EAttribute getDataRule_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.DataRule#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.DataRule#getDescription()
	 * @see #getDataRule()
	 * @generated
	 */
	EAttribute getDataRule_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.DataRule#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Rule</em>'.
	 * @see org.mdmi.DataRule#getRule()
	 * @see #getDataRule()
	 * @generated
	 */
	EAttribute getDataRule_Rule();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.DataRule#getRuleExpressionLanguage <em>Rule Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Rule Expression Language</em>'.
	 * @see org.mdmi.DataRule#getRuleExpressionLanguage()
	 * @see #getDataRule()
	 * @generated
	 */
	EAttribute getDataRule_RuleExpressionLanguage();

	/**
	 * Returns the meta object for the container reference '{@link org.mdmi.DataRule#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Scope</em>'.
	 * @see org.mdmi.DataRule#getScope()
	 * @see #getDataRule()
	 * @generated
	 */
	EReference getDataRule_Scope();

	/**
	 * Returns the meta object for the reference list '{@link org.mdmi.DataRule#getDatatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Datatype</em>'.
	 * @see org.mdmi.DataRule#getDatatype()
	 * @see #getDataRule()
	 * @generated
	 */
	EReference getDataRule_Datatype();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.DataRule#getSemanticElement <em>Semantic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Semantic Element</em>'.
	 * @see org.mdmi.DataRule#getSemanticElement()
	 * @see #getDataRule()
	 * @generated
	 */
	EReference getDataRule_SemanticElement();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.DataRule#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Group</em>'.
	 * @see org.mdmi.DataRule#getGroup()
	 * @see #getDataRule()
	 * @generated
	 */
	EReference getDataRule_Group();

	/**
	 * Returns the meta object for class '{@link org.mdmi.SemanticElementSet <em>Semantic Element Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Semantic Element Set</em>'.
	 * @see org.mdmi.SemanticElementSet
	 * @generated
	 */
	EClass getSemanticElementSet();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementSet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.SemanticElementSet#getName()
	 * @see #getSemanticElementSet()
	 * @generated
	 */
	EAttribute getSemanticElementSet_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementSet#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.SemanticElementSet#getDescription()
	 * @see #getSemanticElementSet()
	 * @generated
	 */
	EAttribute getSemanticElementSet_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementSet#getMessageModelName <em>Message Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Message Model Name</em>'.
	 * @see org.mdmi.SemanticElementSet#getMessageModelName()
	 * @see #getSemanticElementSet()
	 * @generated
	 */
	EAttribute getSemanticElementSet_MessageModelName();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.SemanticElementSet#getSyntaxModel <em>Syntax Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Syntax Model</em>'.
	 * @see org.mdmi.SemanticElementSet#getSyntaxModel()
	 * @see #getSemanticElementSet()
	 * @generated
	 */
	EReference getSemanticElementSet_SyntaxModel();

	/**
	 * Returns the meta object for the container reference '{@link org.mdmi.SemanticElementSet#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Model</em>'.
	 * @see org.mdmi.SemanticElementSet#getModel()
	 * @see #getSemanticElementSet()
	 * @generated
	 */
	EReference getSemanticElementSet_Model();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.SemanticElementSet#getSemanticElements <em>Semantic
	 * Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Semantic Elements</em>'.
	 * @see org.mdmi.SemanticElementSet#getSemanticElements()
	 * @see #getSemanticElementSet()
	 * @generated
	 */
	EReference getSemanticElementSet_SemanticElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.SemanticElementSet#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Composite</em>'.
	 * @see org.mdmi.SemanticElementSet#getComposite()
	 * @see #getSemanticElementSet()
	 * @generated
	 */
	EReference getSemanticElementSet_Composite();

	/**
	 * Returns the meta object for class '{@link org.mdmi.SemanticElement <em>Semantic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Semantic Element</em>'.
	 * @see org.mdmi.SemanticElement
	 * @generated
	 */
	EClass getSemanticElement();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.SemanticElement#getName()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EAttribute getSemanticElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.SemanticElement#getDescription()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EAttribute getSemanticElement_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElement#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Element Type</em>'.
	 * @see org.mdmi.SemanticElement#getElementType()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EAttribute getSemanticElement_ElementType();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.SemanticElement#getDatatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Datatype</em>'.
	 * @see org.mdmi.SemanticElement#getDatatype()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_Datatype();

	/**
	 * Returns the meta object for the attribute list '{@link org.mdmi.SemanticElement#getPropertyQualifier <em>Property Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute list '<em>Property Qualifier</em>'.
	 * @see org.mdmi.SemanticElement#getPropertyQualifier()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EAttribute getSemanticElement_PropertyQualifier();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.SemanticElement#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Composite</em>'.
	 * @see org.mdmi.SemanticElement#getComposite()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_Composite();

	/**
	 * Returns the meta object for the container reference '{@link org.mdmi.SemanticElement#getElementSet <em>Element Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Element Set</em>'.
	 * @see org.mdmi.SemanticElement#getElementSet()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_ElementSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.SemanticElement#getBusinessRules <em>Business Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Business Rules</em>'.
	 * @see org.mdmi.SemanticElement#getBusinessRules()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_BusinessRules();

	/**
	 * Returns the meta object for the reference list '{@link org.mdmi.SemanticElement#getDataRules <em>Data Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Data Rules</em>'.
	 * @see org.mdmi.SemanticElement#getDataRules()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_DataRules();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.SemanticElement#getRelationships <em>Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Relationships</em>'.
	 * @see org.mdmi.SemanticElement#getRelationships()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_Relationships();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElement#isMultipleInstances <em>Multiple Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Multiple Instances</em>'.
	 * @see org.mdmi.SemanticElement#isMultipleInstances()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EAttribute getSemanticElement_MultipleInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.SemanticElement#getMapFromMdmi <em>Map From Mdmi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Map From Mdmi</em>'.
	 * @see org.mdmi.SemanticElement#getMapFromMdmi()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_MapFromMdmi();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElement#getOrdering <em>Ordering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Ordering</em>'.
	 * @see org.mdmi.SemanticElement#getOrdering()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EAttribute getSemanticElement_Ordering();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElement#getOrderingLanguage <em>Ordering Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Ordering Language</em>'.
	 * @see org.mdmi.SemanticElement#getOrderingLanguage()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EAttribute getSemanticElement_OrderingLanguage();

	/**
	 * Returns the meta object for the containment reference '{@link org.mdmi.SemanticElement#getComputedValue <em>Computed Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Computed Value</em>'.
	 * @see org.mdmi.SemanticElement#getComputedValue()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_ComputedValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.mdmi.SemanticElement#getComputedInValue <em>Computed In Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Computed In Value</em>'.
	 * @see org.mdmi.SemanticElement#getComputedInValue()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_ComputedInValue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.SemanticElement#getMapToMdmi <em>Map To Mdmi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Map To Mdmi</em>'.
	 * @see org.mdmi.SemanticElement#getMapToMdmi()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_MapToMdmi();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.SemanticElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.mdmi.SemanticElement#getParent()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_Parent();

	/**
	 * Returns the meta object for the reference list '{@link org.mdmi.SemanticElement#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.mdmi.SemanticElement#getChildren()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_Children();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.SemanticElement#getSyntaxNode <em>Syntax Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Syntax Node</em>'.
	 * @see org.mdmi.SemanticElement#getSyntaxNode()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_SyntaxNode();

	/**
	 * Returns the meta object for the containment reference '{@link org.mdmi.SemanticElement#getComputedOutValue <em>Computed Out Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Computed Out Value</em>'.
	 * @see org.mdmi.SemanticElement#getComputedOutValue()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_ComputedOutValue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.SemanticElement#getKeywords <em>Keywords</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Keywords</em>'.
	 * @see org.mdmi.SemanticElement#getKeywords()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EReference getSemanticElement_Keywords();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElement#getEnumValueField <em>Enum Value Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Enum Value Field</em>'.
	 * @see org.mdmi.SemanticElement#getEnumValueField()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EAttribute getSemanticElement_EnumValueField();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElement#getEnumValueDescrField <em>Enum Value Descr Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Enum Value Descr Field</em>'.
	 * @see org.mdmi.SemanticElement#getEnumValueDescrField()
	 * @see #getSemanticElement()
	 * @generated
	 */
	EAttribute getSemanticElement_EnumValueDescrField();

	/**
	 * Returns the meta object for class '{@link org.mdmi.SimpleMessageComposite <em>Simple Message Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Simple Message Composite</em>'.
	 * @see org.mdmi.SimpleMessageComposite
	 * @generated
	 */
	EClass getSimpleMessageComposite();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SimpleMessageComposite#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.SimpleMessageComposite#getName()
	 * @see #getSimpleMessageComposite()
	 * @generated
	 */
	EAttribute getSimpleMessageComposite_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.mdmi.SimpleMessageComposite#getSemanticElements <em>Semantic Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Semantic Elements</em>'.
	 * @see org.mdmi.SimpleMessageComposite#getSemanticElements()
	 * @see #getSimpleMessageComposite()
	 * @generated
	 */
	EReference getSimpleMessageComposite_SemanticElements();

	/**
	 * Returns the meta object for the container reference '{@link org.mdmi.SimpleMessageComposite#getElementSet <em>Element Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Element Set</em>'.
	 * @see org.mdmi.SimpleMessageComposite#getElementSet()
	 * @see #getSimpleMessageComposite()
	 * @generated
	 */
	EReference getSimpleMessageComposite_ElementSet();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SimpleMessageComposite#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.SimpleMessageComposite#getDescription()
	 * @see #getSimpleMessageComposite()
	 * @generated
	 */
	EAttribute getSimpleMessageComposite_Description();

	/**
	 * Returns the meta object for class '{@link org.mdmi.MessageComposite <em>Message Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Message Composite</em>'.
	 * @see org.mdmi.MessageComposite
	 * @generated
	 */
	EClass getMessageComposite();

	/**
	 * Returns the meta object for the reference list '{@link org.mdmi.MessageComposite#getComposites <em>Composites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Composites</em>'.
	 * @see org.mdmi.MessageComposite#getComposites()
	 * @see #getMessageComposite()
	 * @generated
	 */
	EReference getMessageComposite_Composites();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.MessageComposite#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.mdmi.MessageComposite#getOwner()
	 * @see #getMessageComposite()
	 * @generated
	 */
	EReference getMessageComposite_Owner();

	/**
	 * Returns the meta object for class '{@link org.mdmi.SemanticElementBusinessRule <em>Semantic Element Business Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Semantic Element Business Rule</em>'.
	 * @see org.mdmi.SemanticElementBusinessRule
	 * @generated
	 */
	EClass getSemanticElementBusinessRule();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementBusinessRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.SemanticElementBusinessRule#getName()
	 * @see #getSemanticElementBusinessRule()
	 * @generated
	 */
	EAttribute getSemanticElementBusinessRule_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementBusinessRule#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.SemanticElementBusinessRule#getDescription()
	 * @see #getSemanticElementBusinessRule()
	 * @generated
	 */
	EAttribute getSemanticElementBusinessRule_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementBusinessRule#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Rule</em>'.
	 * @see org.mdmi.SemanticElementBusinessRule#getRule()
	 * @see #getSemanticElementBusinessRule()
	 * @generated
	 */
	EAttribute getSemanticElementBusinessRule_Rule();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementBusinessRule#getRuleExpressionLanguage <em>Rule Expression
	 * Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Rule Expression Language</em>'.
	 * @see org.mdmi.SemanticElementBusinessRule#getRuleExpressionLanguage()
	 * @see #getSemanticElementBusinessRule()
	 * @generated
	 */
	EAttribute getSemanticElementBusinessRule_RuleExpressionLanguage();

	/**
	 * Returns the meta object for the container reference '{@link org.mdmi.SemanticElementBusinessRule#getSemanticElement <em>Semantic
	 * Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Semantic Element</em>'.
	 * @see org.mdmi.SemanticElementBusinessRule#getSemanticElement()
	 * @see #getSemanticElementBusinessRule()
	 * @generated
	 */
	EReference getSemanticElementBusinessRule_SemanticElement();

	/**
	 * Returns the meta object for class '{@link org.mdmi.SemanticElementRelationship <em>Semantic Element Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Semantic Element Relationship</em>'.
	 * @see org.mdmi.SemanticElementRelationship
	 * @generated
	 */
	EClass getSemanticElementRelationship();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementRelationship#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.SemanticElementRelationship#getName()
	 * @see #getSemanticElementRelationship()
	 * @generated
	 */
	EAttribute getSemanticElementRelationship_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementRelationship#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.SemanticElementRelationship#getDescription()
	 * @see #getSemanticElementRelationship()
	 * @generated
	 */
	EAttribute getSemanticElementRelationship_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementRelationship#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Rule</em>'.
	 * @see org.mdmi.SemanticElementRelationship#getRule()
	 * @see #getSemanticElementRelationship()
	 * @generated
	 */
	EAttribute getSemanticElementRelationship_Rule();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementRelationship#getRuleExpressionLanguage <em>Rule Expression
	 * Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Rule Expression Language</em>'.
	 * @see org.mdmi.SemanticElementRelationship#getRuleExpressionLanguage()
	 * @see #getSemanticElementRelationship()
	 * @generated
	 */
	EAttribute getSemanticElementRelationship_RuleExpressionLanguage();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.SemanticElementRelationship#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.mdmi.SemanticElementRelationship#getContext()
	 * @see #getSemanticElementRelationship()
	 * @generated
	 */
	EReference getSemanticElementRelationship_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementRelationship#getMinOccurs <em>Min Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Min Occurs</em>'.
	 * @see org.mdmi.SemanticElementRelationship#getMinOccurs()
	 * @see #getSemanticElementRelationship()
	 * @generated
	 */
	EAttribute getSemanticElementRelationship_MinOccurs();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementRelationship#getMaxOccurs <em>Max Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Max Occurs</em>'.
	 * @see org.mdmi.SemanticElementRelationship#getMaxOccurs()
	 * @see #getSemanticElementRelationship()
	 * @generated
	 */
	EAttribute getSemanticElementRelationship_MaxOccurs();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementRelationship#isSourceIsInstance <em>Source Is Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Source Is Instance</em>'.
	 * @see org.mdmi.SemanticElementRelationship#isSourceIsInstance()
	 * @see #getSemanticElementRelationship()
	 * @generated
	 */
	EAttribute getSemanticElementRelationship_SourceIsInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.SemanticElementRelationship#isTargetIsInstance <em>Target Is Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Target Is Instance</em>'.
	 * @see org.mdmi.SemanticElementRelationship#isTargetIsInstance()
	 * @see #getSemanticElementRelationship()
	 * @generated
	 */
	EAttribute getSemanticElementRelationship_TargetIsInstance();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.SemanticElementRelationship#getRelatedSemanticElement <em>Related Semantic
	 * Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Related Semantic Element</em>'.
	 * @see org.mdmi.SemanticElementRelationship#getRelatedSemanticElement()
	 * @see #getSemanticElementRelationship()
	 * @generated
	 */
	EReference getSemanticElementRelationship_RelatedSemanticElement();

	/**
	 * Returns the meta object for class '{@link org.mdmi.MDMIBusinessElementReference <em>Business Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Business Element Reference</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference
	 * @generated
	 */
	EClass getMDMIBusinessElementReference();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference#getName()
	 * @see #getMDMIBusinessElementReference()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementReference_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementReference#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference#getDescription()
	 * @see #getMDMIBusinessElementReference()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementReference_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementReference#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference#getReference()
	 * @see #getMDMIBusinessElementReference()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementReference_Reference();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementReference#getUniqueIdentifier <em>Unique Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Unique Identifier</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference#getUniqueIdentifier()
	 * @see #getMDMIBusinessElementReference()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementReference_UniqueIdentifier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.MDMIBusinessElementReference#getBusinessRules <em>Business
	 * Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Business Rules</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference#getBusinessRules()
	 * @see #getMDMIBusinessElementReference()
	 * @generated
	 */
	EReference getMDMIBusinessElementReference_BusinessRules();

	/**
	 * Returns the meta object for the container reference '{@link org.mdmi.MDMIBusinessElementReference#getDomainDictionaryReference <em>Domain
	 * Dictionary Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Domain Dictionary Reference</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference#getDomainDictionaryReference()
	 * @see #getMDMIBusinessElementReference()
	 * @generated
	 */
	EReference getMDMIBusinessElementReference_DomainDictionaryReference();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.MDMIBusinessElementReference#getReferenceDatatype <em>Reference Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Reference Datatype</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference#getReferenceDatatype()
	 * @see #getMDMIBusinessElementReference()
	 * @generated
	 */
	EReference getMDMIBusinessElementReference_ReferenceDatatype();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementReference#getEnumValueSetField <em>Enum Value Set Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Enum Value Set Field</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference#getEnumValueSetField()
	 * @see #getMDMIBusinessElementReference()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementReference_EnumValueSetField();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementReference#getEnumValueField <em>Enum Value Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Enum Value Field</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference#getEnumValueField()
	 * @see #getMDMIBusinessElementReference()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementReference_EnumValueField();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementReference#getEnumValueDescrField <em>Enum Value Descr
	 * Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Enum Value Descr Field</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference#getEnumValueDescrField()
	 * @see #getMDMIBusinessElementReference()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementReference_EnumValueDescrField();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementReference#getEnumValueSet <em>Enum Value Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Enum Value Set</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference#getEnumValueSet()
	 * @see #getMDMIBusinessElementReference()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementReference_EnumValueSet();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementReference#getReadonly <em>Readonly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Readonly</em>'.
	 * @see org.mdmi.MDMIBusinessElementReference#getReadonly()
	 * @see #getMDMIBusinessElementReference()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementReference_Readonly();

	/**
	 * Returns the meta object for class '{@link org.mdmi.MDMIBusinessElementRule <em>Business Element Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Business Element Rule</em>'.
	 * @see org.mdmi.MDMIBusinessElementRule
	 * @generated
	 */
	EClass getMDMIBusinessElementRule();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.MDMIBusinessElementRule#getName()
	 * @see #getMDMIBusinessElementRule()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementRule_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementRule#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.MDMIBusinessElementRule#getDescription()
	 * @see #getMDMIBusinessElementRule()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementRule_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementRule#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Rule</em>'.
	 * @see org.mdmi.MDMIBusinessElementRule#getRule()
	 * @see #getMDMIBusinessElementRule()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementRule_Rule();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIBusinessElementRule#getRuleExpressionLanguage <em>Rule Expression
	 * Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Rule Expression Language</em>'.
	 * @see org.mdmi.MDMIBusinessElementRule#getRuleExpressionLanguage()
	 * @see #getMDMIBusinessElementRule()
	 * @generated
	 */
	EAttribute getMDMIBusinessElementRule_RuleExpressionLanguage();

	/**
	 * Returns the meta object for the container reference '{@link org.mdmi.MDMIBusinessElementRule#getBusinessElement <em>Business Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Business Element</em>'.
	 * @see org.mdmi.MDMIBusinessElementRule#getBusinessElement()
	 * @see #getMDMIBusinessElementRule()
	 * @generated
	 */
	EReference getMDMIBusinessElementRule_BusinessElement();

	/**
	 * Returns the meta object for class '{@link org.mdmi.ConversionRule <em>Conversion Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Conversion Rule</em>'.
	 * @see org.mdmi.ConversionRule
	 * @generated
	 */
	EClass getConversionRule();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.ConversionRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.ConversionRule#getName()
	 * @see #getConversionRule()
	 * @generated
	 */
	EAttribute getConversionRule_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.ConversionRule#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.ConversionRule#getDescription()
	 * @see #getConversionRule()
	 * @generated
	 */
	EAttribute getConversionRule_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.ConversionRule#getRuleExpressionLanguage <em>Rule Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Rule Expression Language</em>'.
	 * @see org.mdmi.ConversionRule#getRuleExpressionLanguage()
	 * @see #getConversionRule()
	 * @generated
	 */
	EAttribute getConversionRule_RuleExpressionLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.ConversionRule#getEnumExtResolverUri <em>Enum Ext Resolver Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Enum Ext Resolver Uri</em>'.
	 * @see org.mdmi.ConversionRule#getEnumExtResolverUri()
	 * @see #getConversionRule()
	 * @generated
	 */
	EAttribute getConversionRule_EnumExtResolverUri();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.ConversionRule#getBusinessElement <em>Business Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Business Element</em>'.
	 * @see org.mdmi.ConversionRule#getBusinessElement()
	 * @see #getConversionRule()
	 * @generated
	 */
	EReference getConversionRule_BusinessElement();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.ConversionRule#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Rule</em>'.
	 * @see org.mdmi.ConversionRule#getRule()
	 * @see #getConversionRule()
	 * @generated
	 */
	EAttribute getConversionRule_Rule();

	/**
	 * Returns the meta object for class '{@link org.mdmi.MDMIDomainDictionaryReference <em>Domain Dictionary Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Domain Dictionary Reference</em>'.
	 * @see org.mdmi.MDMIDomainDictionaryReference
	 * @generated
	 */
	EClass getMDMIDomainDictionaryReference();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIDomainDictionaryReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.MDMIDomainDictionaryReference#getName()
	 * @see #getMDMIDomainDictionaryReference()
	 * @generated
	 */
	EAttribute getMDMIDomainDictionaryReference_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIDomainDictionaryReference#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.MDMIDomainDictionaryReference#getDescription()
	 * @see #getMDMIDomainDictionaryReference()
	 * @generated
	 */
	EAttribute getMDMIDomainDictionaryReference_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.MDMIDomainDictionaryReference#getBusinessElements <em>Business
	 * Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Business Elements</em>'.
	 * @see org.mdmi.MDMIDomainDictionaryReference#getBusinessElements()
	 * @see #getMDMIDomainDictionaryReference()
	 * @generated
	 */
	EReference getMDMIDomainDictionaryReference_BusinessElements();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIDomainDictionaryReference#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see org.mdmi.MDMIDomainDictionaryReference#getReference()
	 * @see #getMDMIDomainDictionaryReference()
	 * @generated
	 */
	EAttribute getMDMIDomainDictionaryReference_Reference();

	/**
	 * Returns the meta object for the container reference '{@link org.mdmi.MDMIDomainDictionaryReference#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Group</em>'.
	 * @see org.mdmi.MDMIDomainDictionaryReference#getGroup()
	 * @see #getMDMIDomainDictionaryReference()
	 * @generated
	 */
	EReference getMDMIDomainDictionaryReference_Group();

	/**
	 * Returns the meta object for class '{@link org.mdmi.MDMIExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.mdmi.MDMIExpression
	 * @generated
	 */
	EClass getMDMIExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.mdmi.MDMIExpression#getExpression()
	 * @see #getMDMIExpression()
	 * @generated
	 */
	EAttribute getMDMIExpression_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIExpression#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.mdmi.MDMIExpression#getLanguage()
	 * @see #getMDMIExpression()
	 * @generated
	 */
	EAttribute getMDMIExpression_Language();

	/**
	 * Returns the meta object for class '{@link org.mdmi.Keyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Keyword</em>'.
	 * @see org.mdmi.Keyword
	 * @generated
	 */
	EClass getKeyword();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Keyword#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.Keyword#getDescription()
	 * @see #getKeyword()
	 * @generated
	 */
	EAttribute getKeyword_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Keyword#getKeyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Keyword</em>'.
	 * @see org.mdmi.Keyword#getKeyword()
	 * @see #getKeyword()
	 * @generated
	 */
	EAttribute getKeyword_Keyword();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Keyword#getKeywordValue <em>Keyword Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Keyword Value</em>'.
	 * @see org.mdmi.Keyword#getKeywordValue()
	 * @see #getKeyword()
	 * @generated
	 */
	EAttribute getKeyword_KeywordValue();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Keyword#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see org.mdmi.Keyword#getReference()
	 * @see #getKeyword()
	 * @generated
	 */
	EAttribute getKeyword_Reference();

	/**
	 * Returns the meta object for the container reference '{@link org.mdmi.Keyword#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.mdmi.Keyword#getOwner()
	 * @see #getKeyword()
	 * @generated
	 */
	EReference getKeyword_Owner();

	/**
	 * Returns the meta object for class '{@link org.mdmi.MDMIDatatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Datatype</em>'.
	 * @see org.mdmi.MDMIDatatype
	 * @generated
	 */
	EClass getMDMIDatatype();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIDatatype#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see org.mdmi.MDMIDatatype#getTypeName()
	 * @see #getMDMIDatatype()
	 * @generated
	 */
	EAttribute getMDMIDatatype_TypeName();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIDatatype#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.MDMIDatatype#getDescription()
	 * @see #getMDMIDatatype()
	 * @generated
	 */
	EAttribute getMDMIDatatype_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIDatatype#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see org.mdmi.MDMIDatatype#getReference()
	 * @see #getMDMIDatatype()
	 * @generated
	 */
	EAttribute getMDMIDatatype_Reference();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIDatatype#isIsReadonly <em>Is Readonly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Is Readonly</em>'.
	 * @see org.mdmi.MDMIDatatype#isIsReadonly()
	 * @see #getMDMIDatatype()
	 * @generated
	 */
	EAttribute getMDMIDatatype_IsReadonly();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIDatatype#getTypeSpec <em>Type Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Type Spec</em>'.
	 * @see org.mdmi.MDMIDatatype#getTypeSpec()
	 * @see #getMDMIDatatype()
	 * @generated
	 */
	EAttribute getMDMIDatatype_TypeSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.MDMIDatatype#getRestriction <em>Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Restriction</em>'.
	 * @see org.mdmi.MDMIDatatype#getRestriction()
	 * @see #getMDMIDatatype()
	 * @generated
	 */
	EAttribute getMDMIDatatype_Restriction();

	/**
	 * Returns the meta object for class '{@link org.mdmi.DTSPrimitive <em>DTS Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>DTS Primitive</em>'.
	 * @see org.mdmi.DTSPrimitive
	 * @generated
	 */
	EClass getDTSPrimitive();

	/**
	 * Returns the meta object for class '{@link org.mdmi.DTCStructured <em>DTC Structured</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>DTC Structured</em>'.
	 * @see org.mdmi.DTCStructured
	 * @generated
	 */
	EClass getDTCStructured();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.DTCStructured#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see org.mdmi.DTCStructured#getFields()
	 * @see #getDTCStructured()
	 * @generated
	 */
	EReference getDTCStructured_Fields();

	/**
	 * Returns the meta object for class '{@link org.mdmi.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Field</em>'.
	 * @see org.mdmi.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Field#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.Field#getName()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Field#getMinOccurs <em>Min Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Min Occurs</em>'.
	 * @see org.mdmi.Field#getMinOccurs()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_MinOccurs();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Field#getMaxOccurs <em>Max Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Max Occurs</em>'.
	 * @see org.mdmi.Field#getMaxOccurs()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_MaxOccurs();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.Field#getDatatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Datatype</em>'.
	 * @see org.mdmi.Field#getDatatype()
	 * @see #getField()
	 * @generated
	 */
	EReference getField_Datatype();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.Field#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.Field#getDescription()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Description();

	/**
	 * Returns the meta object for class '{@link org.mdmi.DTExternal <em>DT External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>DT External</em>'.
	 * @see org.mdmi.DTExternal
	 * @generated
	 */
	EClass getDTExternal();

	/**
	 * Returns the meta object for class '{@link org.mdmi.DTSDerived <em>DTS Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>DTS Derived</em>'.
	 * @see org.mdmi.DTSDerived
	 * @generated
	 */
	EClass getDTSDerived();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.DTSDerived#getBaseType <em>Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Base Type</em>'.
	 * @see org.mdmi.DTSDerived#getBaseType()
	 * @see #getDTSDerived()
	 * @generated
	 */
	EReference getDTSDerived_BaseType();

	/**
	 * Returns the meta object for class '{@link org.mdmi.DTCChoice <em>DTC Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>DTC Choice</em>'.
	 * @see org.mdmi.DTCChoice
	 * @generated
	 */
	EClass getDTCChoice();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.DTCChoice#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see org.mdmi.DTCChoice#getFields()
	 * @see #getDTCChoice()
	 * @generated
	 */
	EReference getDTCChoice_Fields();

	/**
	 * Returns the meta object for class '{@link org.mdmi.DTSEnumerated <em>DTS Enumerated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>DTS Enumerated</em>'.
	 * @see org.mdmi.DTSEnumerated
	 * @generated
	 */
	EClass getDTSEnumerated();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdmi.DTSEnumerated#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see org.mdmi.DTSEnumerated#getLiterals()
	 * @see #getDTSEnumerated()
	 * @generated
	 */
	EReference getDTSEnumerated_Literals();

	/**
	 * Returns the meta object for class '{@link org.mdmi.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Enumeration Literal</em>'.
	 * @see org.mdmi.EnumerationLiteral
	 * @generated
	 */
	EClass getEnumerationLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.EnumerationLiteral#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.EnumerationLiteral#getName()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EAttribute getEnumerationLiteral_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.EnumerationLiteral#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.EnumerationLiteral#getDescription()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EAttribute getEnumerationLiteral_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.EnumerationLiteral#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.mdmi.EnumerationLiteral#getCode()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EAttribute getEnumerationLiteral_Code();

	/**
	 * Returns the meta object for class '{@link org.mdmi.DatatypeMap <em>Datatype Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Datatype Map</em>'.
	 * @see org.mdmi.DatatypeMap
	 * @generated
	 */
	EClass getDatatypeMap();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.DatatypeMap#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdmi.DatatypeMap#getName()
	 * @see #getDatatypeMap()
	 * @generated
	 */
	EAttribute getDatatypeMap_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.DatatypeMap#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdmi.DatatypeMap#getDescription()
	 * @see #getDatatypeMap()
	 * @generated
	 */
	EAttribute getDatatypeMap_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.DatatypeMap#getFromMDMI <em>From MDMI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>From MDMI</em>'.
	 * @see org.mdmi.DatatypeMap#getFromMDMI()
	 * @see #getDatatypeMap()
	 * @generated
	 */
	EAttribute getDatatypeMap_FromMDMI();

	/**
	 * Returns the meta object for the attribute '{@link org.mdmi.DatatypeMap#getToMDMI <em>To MDMI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>To MDMI</em>'.
	 * @see org.mdmi.DatatypeMap#getToMDMI()
	 * @see #getDatatypeMap()
	 * @generated
	 */
	EAttribute getDatatypeMap_ToMDMI();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.DatatypeMap#getMdmiDatatype <em>Mdmi Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Mdmi Datatype</em>'.
	 * @see org.mdmi.DatatypeMap#getMdmiDatatype()
	 * @see #getDatatypeMap()
	 * @generated
	 */
	EReference getDatatypeMap_MdmiDatatype();

	/**
	 * Returns the meta object for the reference '{@link org.mdmi.DatatypeMap#getMessageDatatype <em>Message Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Message Datatype</em>'.
	 * @see org.mdmi.DatatypeMap#getMessageDatatype()
	 * @see #getDatatypeMap()
	 * @generated
	 */
	EReference getDatatypeMap_MessageDatatype();

	/**
	 * Returns the meta object for enum '{@link org.mdmi.MessageElementType <em>Message Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for enum '<em>Message Element Type</em>'.
	 * @see org.mdmi.MessageElementType
	 * @generated
	 */
	EEnum getMessageElementType();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * URI - see ISO standard [TODO: number]
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="pattern='^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?'"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MDMIFactory getMDMIFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.mdmi.impl.MessageModelImpl <em>Message Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.MessageModelImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getMessageModel()
		 * @generated
		 */
		EClass MESSAGE_MODEL = eINSTANCE.getMessageModel();

		/**
		 * The meta object literal for the '<em><b>Message Model Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_MODEL__MESSAGE_MODEL_NAME = eINSTANCE.getMessageModel_MessageModelName();

		/**
		 * The meta object literal for the '<em><b>Syntax Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_MODEL__SYNTAX_MODEL = eINSTANCE.getMessageModel_SyntaxModel();

		/**
		 * The meta object literal for the '<em><b>Element Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_MODEL__ELEMENT_SET = eINSTANCE.getMessageModel_ElementSet();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_MODEL__DESCRIPTION = eINSTANCE.getMessageModel_Description();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_MODEL__SOURCE = eINSTANCE.getMessageModel_Source();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_MODEL__GROUP = eINSTANCE.getMessageModel_Group();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.MessageSyntaxModelImpl <em>Message Syntax Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.MessageSyntaxModelImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getMessageSyntaxModel()
		 * @generated
		 */
		EClass MESSAGE_SYNTAX_MODEL = eINSTANCE.getMessageSyntaxModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_SYNTAX_MODEL__NAME = eINSTANCE.getMessageSyntaxModel_Name();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_SYNTAX_MODEL__MODEL = eINSTANCE.getMessageSyntaxModel_Model();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_SYNTAX_MODEL__ROOT = eINSTANCE.getMessageSyntaxModel_Root();

		/**
		 * The meta object literal for the '<em><b>Element Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_SYNTAX_MODEL__ELEMENT_SET = eINSTANCE.getMessageSyntaxModel_ElementSet();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_SYNTAX_MODEL__DESCRIPTION = eINSTANCE.getMessageSyntaxModel_Description();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.NodeImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute NODE__DESCRIPTION = eINSTANCE.getNode_Description();

		/**
		 * The meta object literal for the '<em><b>Min Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute NODE__MIN_OCCURS = eINSTANCE.getNode_MinOccurs();

		/**
		 * The meta object literal for the '<em><b>Max Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute NODE__MAX_OCCURS = eINSTANCE.getNode_MaxOccurs();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute NODE__LOCATION = eINSTANCE.getNode_Location();

		/**
		 * The meta object literal for the '<em><b>Location Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute NODE__LOCATION_EXPRESSION_LANGUAGE = eINSTANCE.getNode_LocationExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Syntax Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference NODE__SYNTAX_MODEL = eINSTANCE.getNode_SyntaxModel();

		/**
		 * The meta object literal for the '<em><b>Semantic Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference NODE__SEMANTIC_ELEMENT = eINSTANCE.getNode_SemanticElement();

		/**
		 * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute NODE__FIELD_NAME = eINSTANCE.getNode_FieldName();

		/**
		 * The meta object literal for the '<em><b>Is Syntactic Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute NODE__IS_SYNTACTIC_FIELD = eINSTANCE.getNode_IsSyntacticField();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute NODE__PATH = eINSTANCE.getNode_Path();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.BagImpl <em>Bag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.BagImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getBag()
		 * @generated
		 */
		EClass BAG = eINSTANCE.getBag();

		/**
		 * The meta object literal for the '<em><b>Is Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute BAG__IS_UNIQUE = eINSTANCE.getBag_IsUnique();

		/**
		 * The meta object literal for the '<em><b>Is Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute BAG__IS_ORDERED = eINSTANCE.getBag_IsOrdered();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference BAG__NODES = eINSTANCE.getBag_Nodes();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.ChoiceImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute CHOICE__CONSTRAINT = eINSTANCE.getChoice_Constraint();

		/**
		 * The meta object literal for the '<em><b>Constraint Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute CHOICE__CONSTRAINT_EXPRESSION_LANGUAGE = eINSTANCE.getChoice_ConstraintExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference CHOICE__NODES = eINSTANCE.getChoice_Nodes();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.LeafSyntaxTranslatorImpl <em>Leaf Syntax Translator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.LeafSyntaxTranslatorImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getLeafSyntaxTranslator()
		 * @generated
		 */
		EClass LEAF_SYNTAX_TRANSLATOR = eINSTANCE.getLeafSyntaxTranslator();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute LEAF_SYNTAX_TRANSLATOR__FORMAT = eINSTANCE.getLeafSyntaxTranslator_Format();

		/**
		 * The meta object literal for the '<em><b>Format Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute LEAF_SYNTAX_TRANSLATOR__FORMAT_EXPRESSION_LANGUAGE = eINSTANCE.getLeafSyntaxTranslator_FormatExpressionLanguage();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.MessageGroupImpl <em>Message Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.MessageGroupImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getMessageGroup()
		 * @generated
		 */
		EClass MESSAGE_GROUP = eINSTANCE.getMessageGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_GROUP__NAME = eINSTANCE.getMessageGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Data Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_GROUP__DATA_RULES = eINSTANCE.getMessageGroup_DataRules();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_GROUP__DESCRIPTION = eINSTANCE.getMessageGroup_Description();

		/**
		 * The meta object literal for the '<em><b>Default Location Expr Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_GROUP__DEFAULT_LOCATION_EXPR_LANG = eINSTANCE.getMessageGroup_DefaultLocationExprLang();

		/**
		 * The meta object literal for the '<em><b>Default Constraint Expr Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_GROUP__DEFAULT_CONSTRAINT_EXPR_LANG = eINSTANCE.getMessageGroup_DefaultConstraintExprLang();

		/**
		 * The meta object literal for the '<em><b>Default Rule Expr Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_GROUP__DEFAULT_RULE_EXPR_LANG = eINSTANCE.getMessageGroup_DefaultRuleExprLang();

		/**
		 * The meta object literal for the '<em><b>Default Format Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_GROUP__DEFAULT_FORMAT_EXPRESSION_LANGUAGE = eINSTANCE.getMessageGroup_DefaultFormatExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Default Ordering Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_GROUP__DEFAULT_ORDERING_EXPRESSION_LANGUAGE = eINSTANCE.getMessageGroup_DefaultOrderingExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_GROUP__MODELS = eINSTANCE.getMessageGroup_Models();

		/**
		 * The meta object literal for the '<em><b>Domain Dictionary</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_GROUP__DOMAIN_DICTIONARY = eINSTANCE.getMessageGroup_DomainDictionary();

		/**
		 * The meta object literal for the '<em><b>Default MDMI Expresion Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MESSAGE_GROUP__DEFAULT_MDMI_EXPRESION_LANGUAGE = eINSTANCE.getMessageGroup_DefaultMDMIExpresionLanguage();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_GROUP__RULES = eINSTANCE.getMessageGroup_Rules();

		/**
		 * The meta object literal for the '<em><b>Datatypes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_GROUP__DATATYPES = eINSTANCE.getMessageGroup_Datatypes();

		/**
		 * The meta object literal for the '<em><b>Datatype Maps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_GROUP__DATATYPE_MAPS = eINSTANCE.getMessageGroup_DatatypeMaps();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.DataRuleImpl <em>Data Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.DataRuleImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getDataRule()
		 * @generated
		 */
		EClass DATA_RULE = eINSTANCE.getDataRule();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute DATA_RULE__NAME = eINSTANCE.getDataRule_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute DATA_RULE__DESCRIPTION = eINSTANCE.getDataRule_Description();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute DATA_RULE__RULE = eINSTANCE.getDataRule_Rule();

		/**
		 * The meta object literal for the '<em><b>Rule Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute DATA_RULE__RULE_EXPRESSION_LANGUAGE = eINSTANCE.getDataRule_RuleExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference DATA_RULE__SCOPE = eINSTANCE.getDataRule_Scope();

		/**
		 * The meta object literal for the '<em><b>Datatype</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference DATA_RULE__DATATYPE = eINSTANCE.getDataRule_Datatype();

		/**
		 * The meta object literal for the '<em><b>Semantic Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference DATA_RULE__SEMANTIC_ELEMENT = eINSTANCE.getDataRule_SemanticElement();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference DATA_RULE__GROUP = eINSTANCE.getDataRule_Group();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.SemanticElementSetImpl <em>Semantic Element Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.SemanticElementSetImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getSemanticElementSet()
		 * @generated
		 */
		EClass SEMANTIC_ELEMENT_SET = eINSTANCE.getSemanticElementSet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_SET__NAME = eINSTANCE.getSemanticElementSet_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_SET__DESCRIPTION = eINSTANCE.getSemanticElementSet_Description();

		/**
		 * The meta object literal for the '<em><b>Message Model Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_SET__MESSAGE_MODEL_NAME = eINSTANCE.getSemanticElementSet_MessageModelName();

		/**
		 * The meta object literal for the '<em><b>Syntax Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT_SET__SYNTAX_MODEL = eINSTANCE.getSemanticElementSet_SyntaxModel();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT_SET__MODEL = eINSTANCE.getSemanticElementSet_Model();

		/**
		 * The meta object literal for the '<em><b>Semantic Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT_SET__SEMANTIC_ELEMENTS = eINSTANCE.getSemanticElementSet_SemanticElements();

		/**
		 * The meta object literal for the '<em><b>Composite</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT_SET__COMPOSITE = eINSTANCE.getSemanticElementSet_Composite();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.SemanticElementImpl <em>Semantic Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.SemanticElementImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getSemanticElement()
		 * @generated
		 */
		EClass SEMANTIC_ELEMENT = eINSTANCE.getSemanticElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT__NAME = eINSTANCE.getSemanticElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT__DESCRIPTION = eINSTANCE.getSemanticElement_Description();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT__ELEMENT_TYPE = eINSTANCE.getSemanticElement_ElementType();

		/**
		 * The meta object literal for the '<em><b>Datatype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__DATATYPE = eINSTANCE.getSemanticElement_Datatype();

		/**
		 * The meta object literal for the '<em><b>Property Qualifier</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT__PROPERTY_QUALIFIER = eINSTANCE.getSemanticElement_PropertyQualifier();

		/**
		 * The meta object literal for the '<em><b>Composite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__COMPOSITE = eINSTANCE.getSemanticElement_Composite();

		/**
		 * The meta object literal for the '<em><b>Element Set</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__ELEMENT_SET = eINSTANCE.getSemanticElement_ElementSet();

		/**
		 * The meta object literal for the '<em><b>Business Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__BUSINESS_RULES = eINSTANCE.getSemanticElement_BusinessRules();

		/**
		 * The meta object literal for the '<em><b>Data Rules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__DATA_RULES = eINSTANCE.getSemanticElement_DataRules();

		/**
		 * The meta object literal for the '<em><b>Relationships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__RELATIONSHIPS = eINSTANCE.getSemanticElement_Relationships();

		/**
		 * The meta object literal for the '<em><b>Multiple Instances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT__MULTIPLE_INSTANCES = eINSTANCE.getSemanticElement_MultipleInstances();

		/**
		 * The meta object literal for the '<em><b>Map From Mdmi</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__MAP_FROM_MDMI = eINSTANCE.getSemanticElement_MapFromMdmi();

		/**
		 * The meta object literal for the '<em><b>Ordering</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT__ORDERING = eINSTANCE.getSemanticElement_Ordering();

		/**
		 * The meta object literal for the '<em><b>Ordering Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT__ORDERING_LANGUAGE = eINSTANCE.getSemanticElement_OrderingLanguage();

		/**
		 * The meta object literal for the '<em><b>Computed Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__COMPUTED_VALUE = eINSTANCE.getSemanticElement_ComputedValue();

		/**
		 * The meta object literal for the '<em><b>Computed In Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__COMPUTED_IN_VALUE = eINSTANCE.getSemanticElement_ComputedInValue();

		/**
		 * The meta object literal for the '<em><b>Map To Mdmi</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__MAP_TO_MDMI = eINSTANCE.getSemanticElement_MapToMdmi();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__PARENT = eINSTANCE.getSemanticElement_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__CHILDREN = eINSTANCE.getSemanticElement_Children();

		/**
		 * The meta object literal for the '<em><b>Syntax Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__SYNTAX_NODE = eINSTANCE.getSemanticElement_SyntaxNode();

		/**
		 * The meta object literal for the '<em><b>Computed Out Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__COMPUTED_OUT_VALUE = eINSTANCE.getSemanticElement_ComputedOutValue();

		/**
		 * The meta object literal for the '<em><b>Keywords</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT__KEYWORDS = eINSTANCE.getSemanticElement_Keywords();

		/**
		 * The meta object literal for the '<em><b>Enum Value Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT__ENUM_VALUE_FIELD = eINSTANCE.getSemanticElement_EnumValueField();

		/**
		 * The meta object literal for the '<em><b>Enum Value Descr Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT__ENUM_VALUE_DESCR_FIELD = eINSTANCE.getSemanticElement_EnumValueDescrField();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.SimpleMessageCompositeImpl <em>Simple Message Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.SimpleMessageCompositeImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getSimpleMessageComposite()
		 * @generated
		 */
		EClass SIMPLE_MESSAGE_COMPOSITE = eINSTANCE.getSimpleMessageComposite();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SIMPLE_MESSAGE_COMPOSITE__NAME = eINSTANCE.getSimpleMessageComposite_Name();

		/**
		 * The meta object literal for the '<em><b>Semantic Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS = eINSTANCE.getSimpleMessageComposite_SemanticElements();

		/**
		 * The meta object literal for the '<em><b>Element Set</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SIMPLE_MESSAGE_COMPOSITE__ELEMENT_SET = eINSTANCE.getSimpleMessageComposite_ElementSet();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SIMPLE_MESSAGE_COMPOSITE__DESCRIPTION = eINSTANCE.getSimpleMessageComposite_Description();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.MessageCompositeImpl <em>Message Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.MessageCompositeImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getMessageComposite()
		 * @generated
		 */
		EClass MESSAGE_COMPOSITE = eINSTANCE.getMessageComposite();

		/**
		 * The meta object literal for the '<em><b>Composites</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_COMPOSITE__COMPOSITES = eINSTANCE.getMessageComposite_Composites();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MESSAGE_COMPOSITE__OWNER = eINSTANCE.getMessageComposite_Owner();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.SemanticElementBusinessRuleImpl <em>Semantic Element Business Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.SemanticElementBusinessRuleImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getSemanticElementBusinessRule()
		 * @generated
		 */
		EClass SEMANTIC_ELEMENT_BUSINESS_RULE = eINSTANCE.getSemanticElementBusinessRule();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_BUSINESS_RULE__NAME = eINSTANCE.getSemanticElementBusinessRule_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_BUSINESS_RULE__DESCRIPTION = eINSTANCE.getSemanticElementBusinessRule_Description();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_BUSINESS_RULE__RULE = eINSTANCE.getSemanticElementBusinessRule_Rule();

		/**
		 * The meta object literal for the '<em><b>Rule Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_BUSINESS_RULE__RULE_EXPRESSION_LANGUAGE = eINSTANCE.getSemanticElementBusinessRule_RuleExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Semantic Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT = eINSTANCE.getSemanticElementBusinessRule_SemanticElement();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.SemanticElementRelationshipImpl <em>Semantic Element Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.SemanticElementRelationshipImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getSemanticElementRelationship()
		 * @generated
		 */
		EClass SEMANTIC_ELEMENT_RELATIONSHIP = eINSTANCE.getSemanticElementRelationship();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_RELATIONSHIP__NAME = eINSTANCE.getSemanticElementRelationship_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_RELATIONSHIP__DESCRIPTION = eINSTANCE.getSemanticElementRelationship_Description();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_RELATIONSHIP__RULE = eINSTANCE.getSemanticElementRelationship_Rule();

		/**
		 * The meta object literal for the '<em><b>Rule Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_RELATIONSHIP__RULE_EXPRESSION_LANGUAGE = eINSTANCE.getSemanticElementRelationship_RuleExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT_RELATIONSHIP__CONTEXT = eINSTANCE.getSemanticElementRelationship_Context();

		/**
		 * The meta object literal for the '<em><b>Min Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_RELATIONSHIP__MIN_OCCURS = eINSTANCE.getSemanticElementRelationship_MinOccurs();

		/**
		 * The meta object literal for the '<em><b>Max Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_RELATIONSHIP__MAX_OCCURS = eINSTANCE.getSemanticElementRelationship_MaxOccurs();

		/**
		 * The meta object literal for the '<em><b>Source Is Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_RELATIONSHIP__SOURCE_IS_INSTANCE = eINSTANCE.getSemanticElementRelationship_SourceIsInstance();

		/**
		 * The meta object literal for the '<em><b>Target Is Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SEMANTIC_ELEMENT_RELATIONSHIP__TARGET_IS_INSTANCE = eINSTANCE.getSemanticElementRelationship_TargetIsInstance();

		/**
		 * The meta object literal for the '<em><b>Related Semantic Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference SEMANTIC_ELEMENT_RELATIONSHIP__RELATED_SEMANTIC_ELEMENT = eINSTANCE.getSemanticElementRelationship_RelatedSemanticElement();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.MDMIBusinessElementReferenceImpl <em>Business Element Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.MDMIBusinessElementReferenceImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getMDMIBusinessElementReference()
		 * @generated
		 */
		EClass MDMI_BUSINESS_ELEMENT_REFERENCE = eINSTANCE.getMDMIBusinessElementReference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_REFERENCE__NAME = eINSTANCE.getMDMIBusinessElementReference_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_REFERENCE__DESCRIPTION = eINSTANCE.getMDMIBusinessElementReference_Description();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE = eINSTANCE.getMDMIBusinessElementReference_Reference();

		/**
		 * The meta object literal for the '<em><b>Unique Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_REFERENCE__UNIQUE_IDENTIFIER = eINSTANCE.getMDMIBusinessElementReference_UniqueIdentifier();

		/**
		 * The meta object literal for the '<em><b>Business Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MDMI_BUSINESS_ELEMENT_REFERENCE__BUSINESS_RULES = eINSTANCE.getMDMIBusinessElementReference_BusinessRules();

		/**
		 * The meta object literal for the '<em><b>Domain Dictionary Reference</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE = eINSTANCE.getMDMIBusinessElementReference_DomainDictionaryReference();

		/**
		 * The meta object literal for the '<em><b>Reference Datatype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MDMI_BUSINESS_ELEMENT_REFERENCE__REFERENCE_DATATYPE = eINSTANCE.getMDMIBusinessElementReference_ReferenceDatatype();

		/**
		 * The meta object literal for the '<em><b>Enum Value Set Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET_FIELD = eINSTANCE.getMDMIBusinessElementReference_EnumValueSetField();

		/**
		 * The meta object literal for the '<em><b>Enum Value Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_FIELD = eINSTANCE.getMDMIBusinessElementReference_EnumValueField();

		/**
		 * The meta object literal for the '<em><b>Enum Value Descr Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_DESCR_FIELD = eINSTANCE.getMDMIBusinessElementReference_EnumValueDescrField();

		/**
		 * The meta object literal for the '<em><b>Enum Value Set</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_REFERENCE__ENUM_VALUE_SET = eINSTANCE.getMDMIBusinessElementReference_EnumValueSet();

		/**
		 * The meta object literal for the '<em><b>Readonly</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_REFERENCE__READONLY = eINSTANCE.getMDMIBusinessElementReference_Readonly();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.MDMIBusinessElementRuleImpl <em>Business Element Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.MDMIBusinessElementRuleImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getMDMIBusinessElementRule()
		 * @generated
		 */
		EClass MDMI_BUSINESS_ELEMENT_RULE = eINSTANCE.getMDMIBusinessElementRule();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_RULE__NAME = eINSTANCE.getMDMIBusinessElementRule_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_RULE__DESCRIPTION = eINSTANCE.getMDMIBusinessElementRule_Description();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_RULE__RULE = eINSTANCE.getMDMIBusinessElementRule_Rule();

		/**
		 * The meta object literal for the '<em><b>Rule Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_BUSINESS_ELEMENT_RULE__RULE_EXPRESSION_LANGUAGE = eINSTANCE.getMDMIBusinessElementRule_RuleExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Business Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MDMI_BUSINESS_ELEMENT_RULE__BUSINESS_ELEMENT = eINSTANCE.getMDMIBusinessElementRule_BusinessElement();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.ConversionRuleImpl <em>Conversion Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.ConversionRuleImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getConversionRule()
		 * @generated
		 */
		EClass CONVERSION_RULE = eINSTANCE.getConversionRule();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute CONVERSION_RULE__NAME = eINSTANCE.getConversionRule_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute CONVERSION_RULE__DESCRIPTION = eINSTANCE.getConversionRule_Description();

		/**
		 * The meta object literal for the '<em><b>Rule Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute CONVERSION_RULE__RULE_EXPRESSION_LANGUAGE = eINSTANCE.getConversionRule_RuleExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Enum Ext Resolver Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute CONVERSION_RULE__ENUM_EXT_RESOLVER_URI = eINSTANCE.getConversionRule_EnumExtResolverUri();

		/**
		 * The meta object literal for the '<em><b>Business Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference CONVERSION_RULE__BUSINESS_ELEMENT = eINSTANCE.getConversionRule_BusinessElement();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute CONVERSION_RULE__RULE = eINSTANCE.getConversionRule_Rule();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.MDMIDomainDictionaryReferenceImpl <em>Domain Dictionary Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.MDMIDomainDictionaryReferenceImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getMDMIDomainDictionaryReference()
		 * @generated
		 */
		EClass MDMI_DOMAIN_DICTIONARY_REFERENCE = eINSTANCE.getMDMIDomainDictionaryReference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_DOMAIN_DICTIONARY_REFERENCE__NAME = eINSTANCE.getMDMIDomainDictionaryReference_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_DOMAIN_DICTIONARY_REFERENCE__DESCRIPTION = eINSTANCE.getMDMIDomainDictionaryReference_Description();

		/**
		 * The meta object literal for the '<em><b>Business Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MDMI_DOMAIN_DICTIONARY_REFERENCE__BUSINESS_ELEMENTS = eINSTANCE.getMDMIDomainDictionaryReference_BusinessElements();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_DOMAIN_DICTIONARY_REFERENCE__REFERENCE = eINSTANCE.getMDMIDomainDictionaryReference_Reference();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP = eINSTANCE.getMDMIDomainDictionaryReference_Group();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.MDMIExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.MDMIExpressionImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getMDMIExpression()
		 * @generated
		 */
		EClass MDMI_EXPRESSION = eINSTANCE.getMDMIExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_EXPRESSION__EXPRESSION = eINSTANCE.getMDMIExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_EXPRESSION__LANGUAGE = eINSTANCE.getMDMIExpression_Language();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.KeywordImpl <em>Keyword</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.KeywordImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getKeyword()
		 * @generated
		 */
		EClass KEYWORD = eINSTANCE.getKeyword();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute KEYWORD__DESCRIPTION = eINSTANCE.getKeyword_Description();

		/**
		 * The meta object literal for the '<em><b>Keyword</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute KEYWORD__KEYWORD = eINSTANCE.getKeyword_Keyword();

		/**
		 * The meta object literal for the '<em><b>Keyword Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute KEYWORD__KEYWORD_VALUE = eINSTANCE.getKeyword_KeywordValue();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute KEYWORD__REFERENCE = eINSTANCE.getKeyword_Reference();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference KEYWORD__OWNER = eINSTANCE.getKeyword_Owner();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.MDMIDatatypeImpl <em>Datatype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.MDMIDatatypeImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getMDMIDatatype()
		 * @generated
		 */
		EClass MDMI_DATATYPE = eINSTANCE.getMDMIDatatype();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_DATATYPE__TYPE_NAME = eINSTANCE.getMDMIDatatype_TypeName();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_DATATYPE__DESCRIPTION = eINSTANCE.getMDMIDatatype_Description();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_DATATYPE__REFERENCE = eINSTANCE.getMDMIDatatype_Reference();

		/**
		 * The meta object literal for the '<em><b>Is Readonly</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_DATATYPE__IS_READONLY = eINSTANCE.getMDMIDatatype_IsReadonly();

		/**
		 * The meta object literal for the '<em><b>Type Spec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_DATATYPE__TYPE_SPEC = eINSTANCE.getMDMIDatatype_TypeSpec();

		/**
		 * The meta object literal for the '<em><b>Restriction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute MDMI_DATATYPE__RESTRICTION = eINSTANCE.getMDMIDatatype_Restriction();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.DTSPrimitiveImpl <em>DTS Primitive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.DTSPrimitiveImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getDTSPrimitive()
		 * @generated
		 */
		EClass DTS_PRIMITIVE = eINSTANCE.getDTSPrimitive();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.DTCStructuredImpl <em>DTC Structured</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.DTCStructuredImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getDTCStructured()
		 * @generated
		 */
		EClass DTC_STRUCTURED = eINSTANCE.getDTCStructured();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference DTC_STRUCTURED__FIELDS = eINSTANCE.getDTCStructured_Fields();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.FieldImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute FIELD__NAME = eINSTANCE.getField_Name();

		/**
		 * The meta object literal for the '<em><b>Min Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute FIELD__MIN_OCCURS = eINSTANCE.getField_MinOccurs();

		/**
		 * The meta object literal for the '<em><b>Max Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute FIELD__MAX_OCCURS = eINSTANCE.getField_MaxOccurs();

		/**
		 * The meta object literal for the '<em><b>Datatype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference FIELD__DATATYPE = eINSTANCE.getField_Datatype();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute FIELD__DESCRIPTION = eINSTANCE.getField_Description();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.DTExternalImpl <em>DT External</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.DTExternalImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getDTExternal()
		 * @generated
		 */
		EClass DT_EXTERNAL = eINSTANCE.getDTExternal();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.DTSDerivedImpl <em>DTS Derived</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.DTSDerivedImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getDTSDerived()
		 * @generated
		 */
		EClass DTS_DERIVED = eINSTANCE.getDTSDerived();

		/**
		 * The meta object literal for the '<em><b>Base Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference DTS_DERIVED__BASE_TYPE = eINSTANCE.getDTSDerived_BaseType();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.DTCChoiceImpl <em>DTC Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.DTCChoiceImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getDTCChoice()
		 * @generated
		 */
		EClass DTC_CHOICE = eINSTANCE.getDTCChoice();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference DTC_CHOICE__FIELDS = eINSTANCE.getDTCChoice_Fields();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.DTSEnumeratedImpl <em>DTS Enumerated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.DTSEnumeratedImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getDTSEnumerated()
		 * @generated
		 */
		EClass DTS_ENUMERATED = eINSTANCE.getDTSEnumerated();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference DTS_ENUMERATED__LITERALS = eINSTANCE.getDTSEnumerated_Literals();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.EnumerationLiteralImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getEnumerationLiteral()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL = eINSTANCE.getEnumerationLiteral();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL__NAME = eINSTANCE.getEnumerationLiteral_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL__DESCRIPTION = eINSTANCE.getEnumerationLiteral_Description();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL__CODE = eINSTANCE.getEnumerationLiteral_Code();

		/**
		 * The meta object literal for the '{@link org.mdmi.impl.DatatypeMapImpl <em>Datatype Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.impl.DatatypeMapImpl
		 * @see org.mdmi.impl.MDMIPackageImpl#getDatatypeMap()
		 * @generated
		 */
		EClass DATATYPE_MAP = eINSTANCE.getDatatypeMap();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute DATATYPE_MAP__NAME = eINSTANCE.getDatatypeMap_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute DATATYPE_MAP__DESCRIPTION = eINSTANCE.getDatatypeMap_Description();

		/**
		 * The meta object literal for the '<em><b>From MDMI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute DATATYPE_MAP__FROM_MDMI = eINSTANCE.getDatatypeMap_FromMDMI();

		/**
		 * The meta object literal for the '<em><b>To MDMI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute DATATYPE_MAP__TO_MDMI = eINSTANCE.getDatatypeMap_ToMDMI();

		/**
		 * The meta object literal for the '<em><b>Mdmi Datatype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference DATATYPE_MAP__MDMI_DATATYPE = eINSTANCE.getDatatypeMap_MdmiDatatype();

		/**
		 * The meta object literal for the '<em><b>Message Datatype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference DATATYPE_MAP__MESSAGE_DATATYPE = eINSTANCE.getDatatypeMap_MessageDatatype();

		/**
		 * The meta object literal for the '{@link org.mdmi.MessageElementType <em>Message Element Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.mdmi.MessageElementType
		 * @see org.mdmi.impl.MDMIPackageImpl#getMessageElementType()
		 * @generated
		 */
		EEnum MESSAGE_ELEMENT_TYPE = eINSTANCE.getMessageElementType();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see java.lang.String
		 * @see org.mdmi.impl.MDMIPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} // MDMIPackage
