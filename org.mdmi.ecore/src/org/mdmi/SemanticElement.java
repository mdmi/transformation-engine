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
 * A representation of the model object '<em><b>Semantic Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * SemanticElement are the core of the MDMI message map. They represent the smallest semantic elements in a message format, stripped of any
 * complicating syntax considerations. Each SemanticElement is unique in the context of its message format. It must have an individual semantic
 * meaning. As example "address" cannot be a SemanticElement; "address" is a datatype that can be repeated in many message fields. "Primary Debtor
 * Address" is a SemanticElement as it refers to a particular unique address in a message format.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.SemanticElement#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getElementType <em>Element Type</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getDatatype <em>Datatype</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getPropertyQualifier <em>Property Qualifier</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getComposite <em>Composite</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getElementSet <em>Element Set</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getBusinessRules <em>Business Rules</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getDataRules <em>Data Rules</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getRelationships <em>Relationships</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#isMultipleInstances <em>Multiple Instances</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getMapFromMdmi <em>Map From Mdmi</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getOrdering <em>Ordering</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getOrderingLanguage <em>Ordering Language</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getComputedValue <em>Computed Value</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getComputedInValue <em>Computed In Value</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getMapToMdmi <em>Map To Mdmi</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getParent <em>Parent</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getChildren <em>Children</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getSyntaxNode <em>Syntax Node</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getComputedOutValue <em>Computed Out Value</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getKeywords <em>Keywords</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getEnumValueField <em>Enum Value Field</em>}</li>
 * <li>{@link org.mdmi.SemanticElement#getEnumValueDescrField <em>Enum Value Descr Field</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getSemanticElement()
 * @model
 * @generated
 */
public interface SemanticElement extends EObject {
	String VALUE_NAME = "value";

	String getUniqueId();

	// }

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "name" property, whose value is the name of the SemanticElement.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_Name()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	void setPropertyQualifier(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The optional "description" property contains, as a String, a description of the SemanticElement.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getDescription <em>Description</em>}' attribute.
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
	 * Returns the value of the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * elementType can have one of three values. "NORMAL" if the MessageElement is a semantic unit that explicitly exists in the message format and is
	 * mapped to an MDMIBusinessElement in the Dictionary. "COMPUTED" if the MessageElement must be computed from the value of other MessageElements.
	 * This may be required because there is not a direct mapping from the message format to the MessageElement and/or because there is not a direct
	 * mapping from an MDMIDomainDictionary MDMIBusinessElement to the MessageElement. "LOCAL" if the MessageElement is needed for technical reasons
	 * but is not meant to be mapped to an MDMIBusinessElement. For example, constructed indexes for a container are local, as they are not mapped to
	 * the domain dictionary. An "elementType" property that has three values has three values contained in the enumeration MessageElementType, each
	 * of which defines the type of Semantic Element.
	 * <ul>
	 * <li>NORMAL - a "NORMAL" semantic element is equivalent to the current definition of a SemanticElement, i.e., a semantic element, contained in a
	 * message format, which is to be mapped to a central dictionary.</li>
	 * <li>LOCAL - a "LOCAL semantic element contains some technical information need that is needed to correctly map NORMAL semantic element, e.g.,
	 * it may contain an index that is used to provide the ordering for a semantic element that has multiple instances.</li>
	 * <li>COMPUTED - a "COMPUTED" semantic element that is to be mapped to the central dictionary but contains a value that is not extracted from a
	 * message. Instead, a "COMPUTED" semantic element�s value is computed from the value of other SemanticElements in the message.</li>
	 * </ul>
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Element Type</em>' attribute.
	 * @see #setElementType(String)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_ElementType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getElementType();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getElementType <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Element Type</em>' attribute.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(String value);

	/**
	 * Returns the value of the '<em><b>Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "datatype" property, whose value is associated with an MDMIDatatype.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Datatype</em>' reference.
	 * @see #setDatatype(MDMIDatatype)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_Datatype()
	 * @model required="true" ordered="false"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	MDMIDatatype getDatatype();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getDatatype <em>Datatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Datatype</em>' reference.
	 * @see #getDatatype()
	 * @generated
	 */
	void setDatatype(MDMIDatatype value);

	/**
	 * Returns the value of the '<em><b>Property Qualifier</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "propertyQualifier" property, which is a list of keyword of type String that contains reference keywords of interest such as a tag associated
	 * with a SemanticElement.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Property Qualifier</em>' attribute list.
	 * @see org.mdmi.MDMIPackage#getSemanticElement_PropertyQualifier()
	 * @model ordered="false"
	 * @generated
	 */
	EList<String> getPropertyQualifier();

	/**
	 * Returns the value of the '<em><b>Composite</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SimpleMessageComposite#getSemanticElements <em>Semantic Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Composite</em>' reference.
	 * @see #setComposite(SimpleMessageComposite)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_Composite()
	 * @see org.mdmi.SimpleMessageComposite#getSemanticElements
	 * @model opposite="semanticElements" ordered="false"
	 * @generated
	 */
	SimpleMessageComposite getComposite();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getComposite <em>Composite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Composite</em>' reference.
	 * @see #getComposite()
	 * @generated
	 */
	void setComposite(SimpleMessageComposite value);

	/**
	 * Returns the value of the '<em><b>Element Set</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SemanticElementSet#getSemanticElements <em>Semantic Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Set</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Element Set</em>' container reference.
	 * @see #setElementSet(SemanticElementSet)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_ElementSet()
	 * @see org.mdmi.SemanticElementSet#getSemanticElements
	 * @model opposite="semanticElements" required="true" transient="false" ordered="false"
	 * @generated
	 */
	SemanticElementSet getElementSet();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getElementSet <em>Element Set</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Element Set</em>' container reference.
	 * @see #getElementSet()
	 * @generated
	 */
	void setElementSet(SemanticElementSet value);

	/**
	 * Returns the value of the '<em><b>Business Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.SemanticElementBusinessRule}.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SemanticElementBusinessRule#getSemanticElement <em>Semantic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Business Rules</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getSemanticElement_BusinessRules()
	 * @see org.mdmi.SemanticElementBusinessRule#getSemanticElement
	 * @model opposite="semanticElement" containment="true" ordered="false"
	 * @generated
	 */
	EList<SemanticElementBusinessRule> getBusinessRules();

	/**
	 * Returns the value of the '<em><b>Data Rules</b></em>' reference list.
	 * The list contents are of type {@link org.mdmi.DataRule}.
	 * It is bidirectional and its opposite is '{@link org.mdmi.DataRule#getSemanticElement <em>Semantic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Rules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Data Rules</em>' reference list.
	 * @see org.mdmi.MDMIPackage#getSemanticElement_DataRules()
	 * @see org.mdmi.DataRule#getSemanticElement
	 * @model opposite="semanticElement" ordered="false"
	 * @generated
	 */
	EList<DataRule> getDataRules();

	/**
	 * Returns the value of the '<em><b>Relationships</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.SemanticElementRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relationships</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Relationships</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getSemanticElement_Relationships()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SemanticElementRelationship> getRelationships();

	/**
	 * Returns the value of the '<em><b>Multiple Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "multipleInstances" Boolean property, whose value if true indicates that this SemanticElement can be repeated in a physical message instance
	 * as a list or array. The multipleInstances property, if true, also can indicate that this SemanticElement can be repeated as part of a more
	 * complex structure defined in that message�s message format.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Multiple Instances</em>' attribute.
	 * @see #setMultipleInstances(boolean)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_MultipleInstances()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isMultipleInstances();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#isMultipleInstances <em>Multiple Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Multiple Instances</em>' attribute.
	 * @see #isMultipleInstances()
	 * @generated
	 */
	void setMultipleInstances(boolean value);

	/**
	 * Returns the value of the '<em><b>Map From Mdmi</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.ConversionRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map From Mdmi</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Map From Mdmi</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getSemanticElement_MapFromMdmi()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<ConversionRule> getMapFromMdmi();

	/**
	 * Returns the value of the '<em><b>Ordering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * An "ordering" property of type String, whose value contains an expression or keyword that describes how the instances are ordered, if the
	 * SemanticElement's multipleInstances property is "True", e.g., the keyword Alphabetic.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Ordering</em>' attribute.
	 * @see #setOrdering(String)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_Ordering()
	 * @model ordered="false"
	 * @generated
	 */
	String getOrdering();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getOrdering <em>Ordering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Ordering</em>' attribute.
	 * @see #getOrdering()
	 * @generated
	 */
	void setOrdering(String value);

	/**
	 * Returns the value of the '<em><b>Ordering Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * An optional "orderingExpressionLanguage" property of type String, whose value is a reference to the expression language used for the value of
	 * the "ordering" property. The ordering languagemust be able to describe ordinal and cardinal positioning as well as expressions that when
	 * evaluated will provide an index. The language used in the reference implementation is NRL.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Ordering Language</em>' attribute.
	 * @see #setOrderingLanguage(String)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_OrderingLanguage()
	 * @model ordered="false"
	 * @generated
	 */
	String getOrderingLanguage();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getOrderingLanguage <em>Ordering Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Ordering Language</em>' attribute.
	 * @see #getOrderingLanguage()
	 * @generated
	 */
	void setOrderingLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Computed Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "computedValue" property, which is an MDMIexpression that computes the value of the SemanticElement, which can refer to the value of other
	 * SemanticElements. This property is most often used for SemanticElements of the type LOCAL.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Computed Value</em>' containment reference.
	 * @see #setComputedValue(MDMIExpression)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_ComputedValue()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	MDMIExpression getComputedValue();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getComputedValue <em>Computed Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Computed Value</em>' containment reference.
	 * @see #getComputedValue()
	 * @generated
	 */
	void setComputedValue(MDMIExpression value);

	/**
	 * Returns the value of the '<em><b>Computed In Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "computedInValue" property, which is an MDMIexpression that computes a value for a SemanticElement, when it is a target, based on the values
	 * of one or more BusinessElements and SemanticElements. The value when it is a source is directly mapped.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Computed In Value</em>' containment reference.
	 * @see #setComputedInValue(MDMIExpression)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_ComputedInValue()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	MDMIExpression getComputedInValue();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getComputedInValue <em>Computed In Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Computed In Value</em>' containment reference.
	 * @see #getComputedInValue()
	 * @generated
	 */
	void setComputedInValue(MDMIExpression value);

	/**
	 * Returns the value of the '<em><b>Map To Mdmi</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.ConversionRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map To Mdmi</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Map To Mdmi</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getSemanticElement_MapToMdmi()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<ConversionRule> getMapToMdmi();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SemanticElement#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(SemanticElement)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_Parent()
	 * @see org.mdmi.SemanticElement#getChildren
	 * @model opposite="children" ordered="false"
	 * @generated
	 */
	SemanticElement getParent();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(SemanticElement value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.mdmi.SemanticElement}.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SemanticElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.mdmi.MDMIPackage#getSemanticElement_Children()
	 * @see org.mdmi.SemanticElement#getParent
	 * @model opposite="parent" ordered="false"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	EList<SemanticElement> getChildren();

	/**
	 * Returns the value of the '<em><b>Syntax Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.Node#getSemanticElement <em>Semantic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syntax Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Syntax Node</em>' reference.
	 * @see #setSyntaxNode(Node)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_SyntaxNode()
	 * @see org.mdmi.Node#getSemanticElement
	 * @model opposite="semanticElement" ordered="false"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	Node getSyntaxNode();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getSyntaxNode <em>Syntax Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Syntax Node</em>' reference.
	 * @see #getSyntaxNode()
	 * @generated
	 */
	void setSyntaxNode(Node value);

	/**
	 * Returns the value of the '<em><b>Computed Out Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * "computedOutValue" property, which is an MDMIexpression that computes a value for a SemanticElement, when it is a source, based on the values
	 * of one or more SemanticElements. The value when it is a target is directly mapped.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Computed Out Value</em>' containment reference.
	 * @see #setComputedOutValue(MDMIExpression)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_ComputedOutValue()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	MDMIExpression getComputedOutValue();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getComputedOutValue <em>Computed Out Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Computed Out Value</em>' containment reference.
	 * @see #getComputedOutValue()
	 * @generated
	 */
	void setComputedOutValue(MDMIExpression value);

	/**
	 * Returns the value of the '<em><b>Keywords</b></em>' containment reference list.
	 * The list contents are of type {@link org.mdmi.Keyword}.
	 * It is bidirectional and its opposite is '{@link org.mdmi.Keyword#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keywords</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Keywords</em>' containment reference list.
	 * @see org.mdmi.MDMIPackage#getSemanticElement_Keywords()
	 * @see org.mdmi.Keyword#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<Keyword> getKeywords();

	/**
	 * Returns the value of the '<em><b>Enum Value Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Value Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Enum Value Field</em>' attribute.
	 * @see #setEnumValueField(String)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_EnumValueField()
	 * @model
	 * @generated
	 */
	String getEnumValueField();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getEnumValueField <em>Enum Value Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Enum Value Field</em>' attribute.
	 * @see #getEnumValueField()
	 * @generated
	 */
	void setEnumValueField(String value);

	/**
	 * Returns the value of the '<em><b>Enum Value Descr Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Value Descr Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Enum Value Descr Field</em>' attribute.
	 * @see #setEnumValueDescrField(String)
	 * @see org.mdmi.MDMIPackage#getSemanticElement_EnumValueDescrField()
	 * @model
	 * @generated
	 */
	String getEnumValueDescrField();

	/**
	 * Sets the value of the '{@link org.mdmi.SemanticElement#getEnumValueDescrField <em>Enum Value Descr Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Enum Value Descr Field</em>' attribute.
	 * @see #getEnumValueDescrField()
	 * @generated
	 */
	void setEnumValueDescrField(String value);

	/**
	 * @generated NOT
	 * @return
	 */
	boolean isNullFlavor();

	/**
	 * @generated NOT
	 * @return
	 */
	boolean isComputedIn();

	/**
	 * @param string
	 * @return
	 */
	SemanticElementRelationship getRelationshipByName(String string);

	/**
	 * @return
	 */
	Object getSemanticElementType();

	/**
	 * @return
	 */
	boolean isComputed();

	/**
	 * @return
	 */
	boolean isComputedOut();

	/**
	 * @return
	 */
	String getEnumValueSet();

	/**
	 * @return
	 */
	boolean hasValidKeyRelation();

	/**
	 * @param target
	 * @return
	 */
	boolean hasChild(SemanticElement target);

} // SemanticElement
