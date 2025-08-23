/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * The Node class is an abstract class that represents all nodes in the syntax tree. It primarily contains location information so that any field in a
 * message can be located.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.Node#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.Node#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.Node#getMinOccurs <em>Min Occurs</em>}</li>
 * <li>{@link org.mdmi.Node#getMaxOccurs <em>Max Occurs</em>}</li>
 * <li>{@link org.mdmi.Node#getLocation <em>Location</em>}</li>
 * <li>{@link org.mdmi.Node#getLocationExpressionLanguage <em>Location Expression Language</em>}</li>
 * <li>{@link org.mdmi.Node#getSyntaxModel <em>Syntax Model</em>}</li>
 * <li>{@link org.mdmi.Node#getSemanticElement <em>Semantic Element</em>}</li>
 * <li>{@link org.mdmi.Node#getFieldName <em>Field Name</em>}</li>
 * <li>{@link org.mdmi.Node#isIsSyntacticField <em>Is Syntactic Field</em>}</li>
 * <li>{@link org.mdmi.Node#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The "name" property, whose value is a name for the Node -- This name can be useful to label a section or element in a message format. The name
	 * property should provide a reference to a node for the expression languages used in the syntax tree.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.mdmi.MDMIPackage#getNode_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.Node#getName <em>Name</em>}' attribute.
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
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The optional "description" property whose value is a string describing the Node�s purpose.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getNode_Description()
	 * @model default="" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.Node#getDescription <em>Description</em>}' attribute.
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
	 * Returns the value of the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The "minOccurs" property with a multiplicity of 0..1. The multiplicity of zero indicates that the Node is optional.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Min Occurs</em>' attribute.
	 * @see #setMinOccurs(int)
	 * @see org.mdmi.MDMIPackage#getNode_MinOccurs()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getMinOccurs();

	/**
	 * Sets the value of the '{@link org.mdmi.Node#getMinOccurs <em>Min Occurs</em>}' attribute.
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * An optional "maxOccurs" property that puts an upper limit on the number of instances allowed for the node.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Max Occurs</em>' attribute.
	 * @see #setMaxOccurs(int)
	 * @see org.mdmi.MDMIPackage#getNode_MaxOccurs()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getMaxOccurs();

	/**
	 * Sets the value of the '{@link org.mdmi.Node#getMaxOccurs <em>Max Occurs</em>}' attribute.
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
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "location" property whose value describes the location of the Node in the physical message. The location is often in reference to, or
	 * anchored by, the URI that defines the location of the physical message.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.mdmi.MDMIPackage#getNode_Location()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getLocation();

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "location" property whose value describes the location of the Node in the physical message. The location is often in reference to, or
	 * anchored by, the URI that defines the location of the physical message.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.mdmi.MDMIPackage#getNode_Location()
	 * @model required="true" ordered="false"
	 * @generated NOT
	 */
	ArrayList<Node> getNodesByLocation(String nodeName);

	/**
	 * Sets the value of the '{@link org.mdmi.Node#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Location Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "locationExpressionLanguage" property whose value defines a reference to the expression language used in the location property. The language
	 * used must have a reference.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Location Expression Language</em>' attribute.
	 * @see #setLocationExpressionLanguage(String)
	 * @see org.mdmi.MDMIPackage#getNode_LocationExpressionLanguage()
	 * @model ordered="false"
	 * @generated
	 */
	String getLocationExpressionLanguage();

	/**
	 * Sets the value of the '{@link org.mdmi.Node#getLocationExpressionLanguage <em>Location Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Location Expression Language</em>' attribute.
	 * @see #getLocationExpressionLanguage()
	 * @generated
	 */
	void setLocationExpressionLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Syntax Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.MessageSyntaxModel#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syntax Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Syntax Model</em>' container reference.
	 * @see #setSyntaxModel(MessageSyntaxModel)
	 * @see org.mdmi.MDMIPackage#getNode_SyntaxModel()
	 * @see org.mdmi.MessageSyntaxModel#getRoot
	 * @model opposite="root" transient="false" ordered="false"
	 * @generated
	 */
	MessageSyntaxModel getSyntaxModel();

	/**
	 * Sets the value of the '{@link org.mdmi.Node#getSyntaxModel <em>Syntax Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Syntax Model</em>' container reference.
	 * @see #getSyntaxModel()
	 * @generated
	 */
	void setSyntaxModel(MessageSyntaxModel value);

	/**
	 * Returns the value of the '<em><b>Semantic Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SemanticElement#getSyntaxNode <em>Syntax Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Semantic Element</em>' reference.
	 * @see #setSemanticElement(SemanticElement)
	 * @see org.mdmi.MDMIPackage#getNode_SemanticElement()
	 * @see org.mdmi.SemanticElement#getSyntaxNode
	 * @model opposite="syntaxNode" resolveProxies="false" ordered="false"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	SemanticElement getSemanticElement();

	/**
	 * Sets the value of the '{@link org.mdmi.Node#getSemanticElement <em>Semantic Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Semantic Element</em>' reference.
	 * @see #getSemanticElement()
	 * @generated
	 */
	void setSemanticElement(SemanticElement value);

	/**
	 * Returns the value of the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "fieldName" property has a value the class name of the simple datatype which is part of a complex MDMIDatatype, that corresponds to the
	 * syntactic field in the message format.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Field Name</em>' attribute.
	 * @see #setFieldName(String)
	 * @see org.mdmi.MDMIPackage#getNode_FieldName()
	 * @model ordered="false"
	 * @generated
	 */
	String getFieldName();

	/**
	 * Sets the value of the '{@link org.mdmi.Node#getFieldName <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Field Name</em>' attribute.
	 * @see #getFieldName()
	 * @generated
	 */
	void setFieldName(String value);

	/**
	 * Returns the value of the '<em><b>Is Syntactic Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A derived Boolean property "isSyntaticfield", which indicates that this node corresponds to a syntactic field if the property�s value is
	 * "True".
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Is Syntactic Field</em>' attribute.
	 * @see #setIsSyntacticField(boolean)
	 * @see org.mdmi.MDMIPackage#getNode_IsSyntacticField()
	 * @model required="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isIsSyntacticField();

	/**
	 * Sets the value of the '{@link org.mdmi.Node#isIsSyntacticField <em>Is Syntactic Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Is Syntactic Field</em>' attribute.
	 * @see #isIsSyntacticField()
	 * @generated
	 */
	void setIsSyntacticField(boolean value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * The default value is <code>"path"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "location" property whose value describes the location of the Node in the physical message. The location is often in reference to, or
	 * anchored by, the URI that defines the location of the physical message.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.mdmi.MDMIPackage#getNode_Path()
	 * @model default="path" required="true" transient="true" ordered="false"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.mdmi.Node#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getCompletePath();

	/**
	 * @generated not
	 * @return
	 */
	Node getParentNode();

	/**
	 * @generated not
	 * @return
	 */
	Integer getCardinality();

	/**
	 * @return
	 */
	boolean isSingle();

	/**
	 * @return
	 */
	boolean isRequired();

	/**
	 * @return
	 */
	Iterable getNodes();

	/**
	 * @return
	 */
	String getOriginalLocation();

	/**
	 * @return
	 */
	String getCurrentRelative();

	/**
	 * @param string
	 */
	void setCurrentRelative(String string);

} // Node
