/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.impl;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.mdmi.ConversionRule;
import org.mdmi.DataRule;
import org.mdmi.Keyword;
import org.mdmi.MDMIDatatype;
import org.mdmi.MDMIExpression;
import org.mdmi.MDMIPackage;
import org.mdmi.Node;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementBusinessRule;
import org.mdmi.SemanticElementRelationship;
import org.mdmi.SemanticElementSet;
import org.mdmi.SemanticElementType;
import org.mdmi.SimpleMessageComposite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantic Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getElementType <em>Element Type</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getDatatype <em>Datatype</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getPropertyQualifier <em>Property Qualifier</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getComposite <em>Composite</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getElementSet <em>Element Set</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getBusinessRules <em>Business Rules</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getDataRules <em>Data Rules</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getRelationships <em>Relationships</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#isMultipleInstances <em>Multiple Instances</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getMapFromMdmi <em>Map From Mdmi</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getOrdering <em>Ordering</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getOrderingLanguage <em>Ordering Language</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getComputedValue <em>Computed Value</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getComputedInValue <em>Computed In Value</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getMapToMdmi <em>Map To Mdmi</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getParent <em>Parent</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getChildren <em>Children</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getSyntaxNode <em>Syntax Node</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getComputedOutValue <em>Computed Out Value</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getKeywords <em>Keywords</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getEnumValueField <em>Enum Value Field</em>}</li>
 * <li>{@link org.mdmi.impl.SemanticElementImpl#getEnumValueDescrField <em>Enum Value Descr Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticElementImpl extends EObjectImpl implements SemanticElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getElementType() <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementType() <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected String elementType = ELEMENT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDatatype() <em>Datatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDatatype()
	 * @generated
	 * @ordered
	 */
	protected MDMIDatatype datatype;

	/**
	 * The cached value of the '{@link #getPropertyQualifier() <em>Property Qualifier</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getPropertyQualifier()
	 * @generated
	 * @ordered
	 */
	protected EList<String> propertyQualifier;

	/**
	 * The cached value of the '{@link #getComposite() <em>Composite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getComposite()
	 * @generated
	 * @ordered
	 */
	protected SimpleMessageComposite composite;

	/**
	 * The cached value of the '{@link #getBusinessRules() <em>Business Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getBusinessRules()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticElementBusinessRule> businessRules;

	/**
	 * The cached value of the '{@link #getDataRules() <em>Data Rules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDataRules()
	 * @generated
	 * @ordered
	 */
	protected EList<DataRule> dataRules;

	/**
	 * The cached value of the '{@link #getRelationships() <em>Relationships</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRelationships()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticElementRelationship> relationships;

	/**
	 * The default value of the '{@link #isMultipleInstances() <em>Multiple Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isMultipleInstances()
	 * @generated NOT
	 * @ordered
	 */
	protected static final boolean MULTIPLE_INSTANCES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isMultipleInstances() <em>Multiple Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isMultipleInstances()
	 * @generated
	 * @ordered
	 */
	protected boolean multipleInstances = MULTIPLE_INSTANCES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMapFromMdmi() <em>Map From Mdmi</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMapFromMdmi()
	 * @generated
	 * @ordered
	 */
	protected EList<ConversionRule> mapFromMdmi;

	/**
	 * The default value of the '{@link #getOrdering() <em>Ordering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getOrdering()
	 * @generated
	 * @ordered
	 */
	protected static final String ORDERING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrdering() <em>Ordering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getOrdering()
	 * @generated
	 * @ordered
	 */
	protected String ordering = ORDERING_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrderingLanguage() <em>Ordering Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getOrderingLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String ORDERING_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrderingLanguage() <em>Ordering Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getOrderingLanguage()
	 * @generated
	 * @ordered
	 */
	protected String orderingLanguage = ORDERING_LANGUAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComputedValue() <em>Computed Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getComputedValue()
	 * @generated
	 * @ordered
	 */
	protected MDMIExpression computedValue;

	/**
	 * The cached value of the '{@link #getComputedInValue() <em>Computed In Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getComputedInValue()
	 * @generated
	 * @ordered
	 */
	protected MDMIExpression computedInValue;

	/**
	 * The cached value of the '{@link #getMapToMdmi() <em>Map To Mdmi</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMapToMdmi()
	 * @generated
	 * @ordered
	 */
	protected EList<ConversionRule> mapToMdmi;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected SemanticElement parent;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticElement> children;

	/**
	 * The cached value of the '{@link #getSyntaxNode() <em>Syntax Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSyntaxNode()
	 * @generated
	 * @ordered
	 */
	protected Node syntaxNode;

	/**
	 * The cached value of the '{@link #getComputedOutValue() <em>Computed Out Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getComputedOutValue()
	 * @generated
	 * @ordered
	 */
	protected MDMIExpression computedOutValue;

	/**
	 * The cached value of the '{@link #getKeywords() <em>Keywords</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getKeywords()
	 * @generated
	 * @ordered
	 */
	protected EList<Keyword> keywords;

	/**
	 * The default value of the '{@link #getEnumValueField() <em>Enum Value Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumValueField()
	 * @generated
	 * @ordered
	 */
	protected static final String ENUM_VALUE_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnumValueField() <em>Enum Value Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumValueField()
	 * @generated
	 * @ordered
	 */
	protected String enumValueField = ENUM_VALUE_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnumValueDescrField() <em>Enum Value Descr Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumValueDescrField()
	 * @generated
	 * @ordered
	 */
	protected static final String ENUM_VALUE_DESCR_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnumValueDescrField() <em>Enum Value Descr Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEnumValueDescrField()
	 * @generated
	 * @ordered
	 */
	protected String enumValueDescrField = ENUM_VALUE_DESCR_FIELD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected SemanticElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MDMIPackage.Literals.SEMANTIC_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__DESCRIPTION, oldDescription, description));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getElementType() {
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setElementType(String newElementType) {
		String oldElementType = elementType;
		elementType = newElementType;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_TYPE, oldElementType, elementType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIDatatype getDatatype() {
		if (datatype != null && datatype.eIsProxy()) {
			InternalEObject oldDatatype = (InternalEObject) datatype;
			datatype = (MDMIDatatype) eResolveProxy(oldDatatype);
			if (datatype != oldDatatype) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE, MDMIPackage.SEMANTIC_ELEMENT__DATATYPE, oldDatatype, datatype));
				}
			}
		}
		return datatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MDMIDatatype basicGetDatatype() {
		return datatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDatatype(MDMIDatatype newDatatype) {
		MDMIDatatype oldDatatype = datatype;
		datatype = newDatatype;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__DATATYPE, oldDatatype, datatype));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<String> getPropertyQualifier() {
		if (propertyQualifier == null) {
			propertyQualifier = new EDataTypeUniqueEList<>(
				String.class, this, MDMIPackage.SEMANTIC_ELEMENT__PROPERTY_QUALIFIER);
		}
		return propertyQualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SimpleMessageComposite getComposite() {
		if (composite != null && composite.eIsProxy()) {
			InternalEObject oldComposite = (InternalEObject) composite;
			composite = (SimpleMessageComposite) eResolveProxy(oldComposite);
			if (composite != oldComposite) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE, MDMIPackage.SEMANTIC_ELEMENT__COMPOSITE, oldComposite,
							composite));
				}
			}
		}
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public SimpleMessageComposite basicGetComposite() {
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetComposite(SimpleMessageComposite newComposite, NotificationChain msgs) {
		SimpleMessageComposite oldComposite = composite;
		composite = newComposite;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__COMPOSITE, oldComposite, newComposite);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setComposite(SimpleMessageComposite newComposite) {
		if (newComposite != composite) {
			NotificationChain msgs = null;
			if (composite != null) {
				msgs = ((InternalEObject) composite).eInverseRemove(
					this, MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS, SimpleMessageComposite.class, msgs);
			}
			if (newComposite != null) {
				msgs = ((InternalEObject) newComposite).eInverseAdd(
					this, MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS, SimpleMessageComposite.class, msgs);
			}
			msgs = basicSetComposite(newComposite, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__COMPOSITE, newComposite, newComposite));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SemanticElementSet getElementSet() {
		if (eContainerFeatureID() != MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_SET) {
			return null;
		}
		return (SemanticElementSet) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetElementSet(SemanticElementSet newElementSet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newElementSet, MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_SET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setElementSet(SemanticElementSet newElementSet) {
		if (newElementSet != eInternalContainer() ||
				(eContainerFeatureID() != MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_SET && newElementSet != null)) {
			if (EcoreUtil.isAncestor(this, newElementSet)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newElementSet != null) {
				msgs = ((InternalEObject) newElementSet).eInverseAdd(
					this, MDMIPackage.SEMANTIC_ELEMENT_SET__SEMANTIC_ELEMENTS, SemanticElementSet.class, msgs);
			}
			msgs = basicSetElementSet(newElementSet, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_SET, newElementSet, newElementSet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<SemanticElementBusinessRule> getBusinessRules() {
		if (businessRules == null) {
			businessRules = new EObjectContainmentWithInverseEList<>(
				SemanticElementBusinessRule.class, this, MDMIPackage.SEMANTIC_ELEMENT__BUSINESS_RULES,
				MDMIPackage.SEMANTIC_ELEMENT_BUSINESS_RULE__SEMANTIC_ELEMENT);
		}
		return businessRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<DataRule> getDataRules() {
		if (dataRules == null) {
			dataRules = new EObjectWithInverseResolvingEList<>(
				DataRule.class, this, MDMIPackage.SEMANTIC_ELEMENT__DATA_RULES,
				MDMIPackage.DATA_RULE__SEMANTIC_ELEMENT);
		}
		return dataRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<SemanticElementRelationship> getRelationships() {
		if (relationships == null) {
			relationships = new EObjectContainmentEList<>(
				SemanticElementRelationship.class, this, MDMIPackage.SEMANTIC_ELEMENT__RELATIONSHIPS);
		}
		return relationships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isMultipleInstances() {
		return multipleInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMultipleInstances(boolean newMultipleInstances) {
		boolean oldMultipleInstances = multipleInstances;
		multipleInstances = newMultipleInstances;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__MULTIPLE_INSTANCES, oldMultipleInstances,
					multipleInstances));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<ConversionRule> getMapFromMdmi() {
		if (mapFromMdmi == null) {
			mapFromMdmi = new EObjectContainmentEList<>(
				ConversionRule.class, this, MDMIPackage.SEMANTIC_ELEMENT__MAP_FROM_MDMI);
		}
		return mapFromMdmi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getOrdering() {
		return ordering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setOrdering(String newOrdering) {
		String oldOrdering = ordering;
		ordering = newOrdering;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__ORDERING, oldOrdering, ordering));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getOrderingLanguage() {
		return orderingLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setOrderingLanguage(String newOrderingLanguage) {
		String oldOrderingLanguage = orderingLanguage;
		orderingLanguage = newOrderingLanguage;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__ORDERING_LANGUAGE, oldOrderingLanguage,
					orderingLanguage));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIExpression getComputedValue() {
		return computedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetComputedValue(MDMIExpression newComputedValue, NotificationChain msgs) {
		MDMIExpression oldComputedValue = computedValue;
		computedValue = newComputedValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_VALUE, oldComputedValue,
				newComputedValue);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setComputedValue(MDMIExpression newComputedValue) {
		if (newComputedValue != computedValue) {
			NotificationChain msgs = null;
			if (computedValue != null) {
				msgs = ((InternalEObject) computedValue).eInverseRemove(
					this, EOPPOSITE_FEATURE_BASE - MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_VALUE, null, msgs);
			}
			if (newComputedValue != null) {
				msgs = ((InternalEObject) newComputedValue).eInverseAdd(
					this, EOPPOSITE_FEATURE_BASE - MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_VALUE, null, msgs);
			}
			msgs = basicSetComputedValue(newComputedValue, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_VALUE, newComputedValue,
					newComputedValue));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIExpression getComputedInValue() {
		return computedInValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetComputedInValue(MDMIExpression newComputedInValue, NotificationChain msgs) {
		MDMIExpression oldComputedInValue = computedInValue;
		computedInValue = newComputedInValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_IN_VALUE, oldComputedInValue,
				newComputedInValue);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setComputedInValue(MDMIExpression newComputedInValue) {
		if (newComputedInValue != computedInValue) {
			NotificationChain msgs = null;
			if (computedInValue != null) {
				msgs = ((InternalEObject) computedInValue).eInverseRemove(
					this, EOPPOSITE_FEATURE_BASE - MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_IN_VALUE, null, msgs);
			}
			if (newComputedInValue != null) {
				msgs = ((InternalEObject) newComputedInValue).eInverseAdd(
					this, EOPPOSITE_FEATURE_BASE - MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_IN_VALUE, null, msgs);
			}
			msgs = basicSetComputedInValue(newComputedInValue, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_IN_VALUE, newComputedInValue,
					newComputedInValue));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<ConversionRule> getMapToMdmi() {
		if (mapToMdmi == null) {
			mapToMdmi = new EObjectContainmentEList<>(
				ConversionRule.class, this, MDMIPackage.SEMANTIC_ELEMENT__MAP_TO_MDMI);
		}
		return mapToMdmi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SemanticElement getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject) parent;
			parent = (SemanticElement) eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE, MDMIPackage.SEMANTIC_ELEMENT__PARENT, oldParent, parent));
				}
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public SemanticElement basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetParent(SemanticElement newParent, NotificationChain msgs) {
		SemanticElement oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__PARENT, oldParent, newParent);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setParent(SemanticElement newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null) {
				msgs = ((InternalEObject) parent).eInverseRemove(
					this, MDMIPackage.SEMANTIC_ELEMENT__CHILDREN, SemanticElement.class, msgs);
			}
			if (newParent != null) {
				msgs = ((InternalEObject) newParent).eInverseAdd(
					this, MDMIPackage.SEMANTIC_ELEMENT__CHILDREN, SemanticElement.class, msgs);
			}
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__PARENT, newParent, newParent));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<SemanticElement> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList<>(
				SemanticElement.class, this, MDMIPackage.SEMANTIC_ELEMENT__CHILDREN,
				MDMIPackage.SEMANTIC_ELEMENT__PARENT);
		}
		return children;
	}

	// public EList<SemanticElement> getChildren() {
	// if (children == null) {
	// children = new SemanticChildren(
	// SemanticElement.class, this, MDMIPackage.SEMANTIC_ELEMENT__CHILDREN,
	// MDMIPackage.SEMANTIC_ELEMENT__PARENT);
	// }
	// return children;
	// }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Node getSyntaxNode() {
		if (syntaxNode != null && syntaxNode.eIsProxy()) {
			InternalEObject oldSyntaxNode = (InternalEObject) syntaxNode;
			syntaxNode = (Node) eResolveProxy(oldSyntaxNode);
			if (syntaxNode != oldSyntaxNode) {
				if (eNotificationRequired()) {
					eNotify(
						new ENotificationImpl(
							this, Notification.RESOLVE, MDMIPackage.SEMANTIC_ELEMENT__SYNTAX_NODE, oldSyntaxNode,
							syntaxNode));
				}
			}
		}
		return syntaxNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Node basicGetSyntaxNode() {
		return syntaxNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetSyntaxNode(Node newSyntaxNode, NotificationChain msgs) {
		Node oldSyntaxNode = syntaxNode;
		syntaxNode = newSyntaxNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__SYNTAX_NODE, oldSyntaxNode, newSyntaxNode);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSyntaxNode(Node newSyntaxNode) {
		if (newSyntaxNode != syntaxNode) {
			NotificationChain msgs = null;
			if (syntaxNode != null) {
				msgs = ((InternalEObject) syntaxNode).eInverseRemove(
					this, MDMIPackage.NODE__SEMANTIC_ELEMENT, Node.class, msgs);
			}
			if (newSyntaxNode != null) {
				msgs = ((InternalEObject) newSyntaxNode).eInverseAdd(
					this, MDMIPackage.NODE__SEMANTIC_ELEMENT, Node.class, msgs);
			}
			msgs = basicSetSyntaxNode(newSyntaxNode, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__SYNTAX_NODE, newSyntaxNode, newSyntaxNode));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIExpression getComputedOutValue() {
		return computedOutValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetComputedOutValue(MDMIExpression newComputedOutValue, NotificationChain msgs) {
		MDMIExpression oldComputedOutValue = computedOutValue;
		computedOutValue = newComputedOutValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_OUT_VALUE, oldComputedOutValue,
				newComputedOutValue);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setComputedOutValue(MDMIExpression newComputedOutValue) {
		if (newComputedOutValue != computedOutValue) {
			NotificationChain msgs = null;
			if (computedOutValue != null) {
				msgs = ((InternalEObject) computedOutValue).eInverseRemove(
					this, EOPPOSITE_FEATURE_BASE - MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_OUT_VALUE, null, msgs);
			}
			if (newComputedOutValue != null) {
				msgs = ((InternalEObject) newComputedOutValue).eInverseAdd(
					this, EOPPOSITE_FEATURE_BASE - MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_OUT_VALUE, null, msgs);
			}
			msgs = basicSetComputedOutValue(newComputedOutValue, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_OUT_VALUE, newComputedOutValue,
					newComputedOutValue));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<Keyword> getKeywords() {
		if (keywords == null) {
			keywords = new EObjectContainmentWithInverseEList<>(
				Keyword.class, this, MDMIPackage.SEMANTIC_ELEMENT__KEYWORDS, MDMIPackage.KEYWORD__OWNER);
		}
		return keywords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getEnumValueField() {
		return enumValueField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setEnumValueField(String newEnumValueField) {
		String oldEnumValueField = enumValueField;
		enumValueField = newEnumValueField;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__ENUM_VALUE_FIELD, oldEnumValueField,
					enumValueField));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getEnumValueDescrField() {
		return enumValueDescrField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setEnumValueDescrField(String newEnumValueDescrField) {
		String oldEnumValueDescrField = enumValueDescrField;
		enumValueDescrField = newEnumValueDescrField;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__ENUM_VALUE_DESCR_FIELD,
					oldEnumValueDescrField, enumValueDescrField));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MDMIPackage.SEMANTIC_ELEMENT__COMPOSITE:
				if (composite != null) {
					msgs = ((InternalEObject) composite).eInverseRemove(
						this, MDMIPackage.SIMPLE_MESSAGE_COMPOSITE__SEMANTIC_ELEMENTS, SimpleMessageComposite.class,
						msgs);
				}
				return basicSetComposite((SimpleMessageComposite) otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_SET:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
				return basicSetElementSet((SemanticElementSet) otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__BUSINESS_RULES:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getBusinessRules()).basicAdd(
					otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__DATA_RULES:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getDataRules()).basicAdd(otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__PARENT:
				if (parent != null) {
					msgs = ((InternalEObject) parent).eInverseRemove(
						this, MDMIPackage.SEMANTIC_ELEMENT__CHILDREN, SemanticElement.class, msgs);
				}
				return basicSetParent((SemanticElement) otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__CHILDREN:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildren()).basicAdd(otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__SYNTAX_NODE:
				if (syntaxNode != null) {
					msgs = ((InternalEObject) syntaxNode).eInverseRemove(
						this, MDMIPackage.NODE__SEMANTIC_ELEMENT, Node.class, msgs);
				}
				return basicSetSyntaxNode((Node) otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__KEYWORDS:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getKeywords()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MDMIPackage.SEMANTIC_ELEMENT__COMPOSITE:
				return basicSetComposite(null, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_SET:
				return basicSetElementSet(null, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__BUSINESS_RULES:
				return ((InternalEList<?>) getBusinessRules()).basicRemove(otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__DATA_RULES:
				return ((InternalEList<?>) getDataRules()).basicRemove(otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__RELATIONSHIPS:
				return ((InternalEList<?>) getRelationships()).basicRemove(otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__MAP_FROM_MDMI:
				return ((InternalEList<?>) getMapFromMdmi()).basicRemove(otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_VALUE:
				return basicSetComputedValue(null, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_IN_VALUE:
				return basicSetComputedInValue(null, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__MAP_TO_MDMI:
				return ((InternalEList<?>) getMapToMdmi()).basicRemove(otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__PARENT:
				return basicSetParent(null, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__CHILDREN:
				return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__SYNTAX_NODE:
				return basicSetSyntaxNode(null, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_OUT_VALUE:
				return basicSetComputedOutValue(null, msgs);
			case MDMIPackage.SEMANTIC_ELEMENT__KEYWORDS:
				return ((InternalEList<?>) getKeywords()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_SET:
				return eInternalContainer().eInverseRemove(
					this, MDMIPackage.SEMANTIC_ELEMENT_SET__SEMANTIC_ELEMENTS, SemanticElementSet.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MDMIPackage.SEMANTIC_ELEMENT__NAME:
				return getName();
			case MDMIPackage.SEMANTIC_ELEMENT__DESCRIPTION:
				return getDescription();
			case MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_TYPE:
				return getElementType();
			case MDMIPackage.SEMANTIC_ELEMENT__DATATYPE:
				if (resolve) {
					return getDatatype();
				}
				return basicGetDatatype();
			case MDMIPackage.SEMANTIC_ELEMENT__PROPERTY_QUALIFIER:
				return getPropertyQualifier();
			case MDMIPackage.SEMANTIC_ELEMENT__COMPOSITE:
				if (resolve) {
					return getComposite();
				}
				return basicGetComposite();
			case MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_SET:
				return getElementSet();
			case MDMIPackage.SEMANTIC_ELEMENT__BUSINESS_RULES:
				return getBusinessRules();
			case MDMIPackage.SEMANTIC_ELEMENT__DATA_RULES:
				return getDataRules();
			case MDMIPackage.SEMANTIC_ELEMENT__RELATIONSHIPS:
				return getRelationships();
			case MDMIPackage.SEMANTIC_ELEMENT__MULTIPLE_INSTANCES:
				return isMultipleInstances();
			case MDMIPackage.SEMANTIC_ELEMENT__MAP_FROM_MDMI:
				return getMapFromMdmi();
			case MDMIPackage.SEMANTIC_ELEMENT__ORDERING:
				return getOrdering();
			case MDMIPackage.SEMANTIC_ELEMENT__ORDERING_LANGUAGE:
				return getOrderingLanguage();
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_VALUE:
				return getComputedValue();
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_IN_VALUE:
				return getComputedInValue();
			case MDMIPackage.SEMANTIC_ELEMENT__MAP_TO_MDMI:
				return getMapToMdmi();
			case MDMIPackage.SEMANTIC_ELEMENT__PARENT:
				if (resolve) {
					return getParent();
				}
				return basicGetParent();
			case MDMIPackage.SEMANTIC_ELEMENT__CHILDREN:
				return getChildren();
			case MDMIPackage.SEMANTIC_ELEMENT__SYNTAX_NODE:
				if (resolve) {
					return getSyntaxNode();
				}
				return basicGetSyntaxNode();
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_OUT_VALUE:
				return getComputedOutValue();
			case MDMIPackage.SEMANTIC_ELEMENT__KEYWORDS:
				return getKeywords();
			case MDMIPackage.SEMANTIC_ELEMENT__ENUM_VALUE_FIELD:
				return getEnumValueField();
			case MDMIPackage.SEMANTIC_ELEMENT__ENUM_VALUE_DESCR_FIELD:
				return getEnumValueDescrField();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MDMIPackage.SEMANTIC_ELEMENT__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_TYPE:
				setElementType((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__DATATYPE:
				setDatatype((MDMIDatatype) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__PROPERTY_QUALIFIER:
				getPropertyQualifier().clear();
				getPropertyQualifier().addAll((Collection<? extends String>) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__COMPOSITE:
				setComposite((SimpleMessageComposite) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_SET:
				setElementSet((SemanticElementSet) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__BUSINESS_RULES:
				getBusinessRules().clear();
				getBusinessRules().addAll((Collection<? extends SemanticElementBusinessRule>) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__DATA_RULES:
				getDataRules().clear();
				getDataRules().addAll((Collection<? extends DataRule>) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__RELATIONSHIPS:
				getRelationships().clear();
				getRelationships().addAll((Collection<? extends SemanticElementRelationship>) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__MULTIPLE_INSTANCES:
				setMultipleInstances((Boolean) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__MAP_FROM_MDMI:
				getMapFromMdmi().clear();
				getMapFromMdmi().addAll((Collection<? extends ConversionRule>) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__ORDERING:
				setOrdering((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__ORDERING_LANGUAGE:
				setOrderingLanguage((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_VALUE:
				setComputedValue((MDMIExpression) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_IN_VALUE:
				setComputedInValue((MDMIExpression) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__MAP_TO_MDMI:
				getMapToMdmi().clear();
				getMapToMdmi().addAll((Collection<? extends ConversionRule>) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__PARENT:
				setParent((SemanticElement) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends SemanticElement>) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__SYNTAX_NODE:
				setSyntaxNode((Node) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_OUT_VALUE:
				setComputedOutValue((MDMIExpression) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__KEYWORDS:
				getKeywords().clear();
				getKeywords().addAll((Collection<? extends Keyword>) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__ENUM_VALUE_FIELD:
				setEnumValueField((String) newValue);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__ENUM_VALUE_DESCR_FIELD:
				setEnumValueDescrField((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MDMIPackage.SEMANTIC_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_TYPE:
				setElementType(ELEMENT_TYPE_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__DATATYPE:
				setDatatype((MDMIDatatype) null);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__PROPERTY_QUALIFIER:
				getPropertyQualifier().clear();
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__COMPOSITE:
				setComposite((SimpleMessageComposite) null);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_SET:
				setElementSet((SemanticElementSet) null);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__BUSINESS_RULES:
				getBusinessRules().clear();
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__DATA_RULES:
				getDataRules().clear();
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__RELATIONSHIPS:
				getRelationships().clear();
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__MULTIPLE_INSTANCES:
				setMultipleInstances(MULTIPLE_INSTANCES_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__MAP_FROM_MDMI:
				getMapFromMdmi().clear();
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__ORDERING:
				setOrdering(ORDERING_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__ORDERING_LANGUAGE:
				setOrderingLanguage(ORDERING_LANGUAGE_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_VALUE:
				setComputedValue((MDMIExpression) null);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_IN_VALUE:
				setComputedInValue((MDMIExpression) null);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__MAP_TO_MDMI:
				getMapToMdmi().clear();
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__PARENT:
				setParent((SemanticElement) null);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__CHILDREN:
				getChildren().clear();
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__SYNTAX_NODE:
				setSyntaxNode((Node) null);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_OUT_VALUE:
				setComputedOutValue((MDMIExpression) null);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__KEYWORDS:
				getKeywords().clear();
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__ENUM_VALUE_FIELD:
				setEnumValueField(ENUM_VALUE_FIELD_EDEFAULT);
				return;
			case MDMIPackage.SEMANTIC_ELEMENT__ENUM_VALUE_DESCR_FIELD:
				setEnumValueDescrField(ENUM_VALUE_DESCR_FIELD_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MDMIPackage.SEMANTIC_ELEMENT__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.SEMANTIC_ELEMENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_TYPE:
				return ELEMENT_TYPE_EDEFAULT == null
						? elementType != null
						: !ELEMENT_TYPE_EDEFAULT.equals(elementType);
			case MDMIPackage.SEMANTIC_ELEMENT__DATATYPE:
				return datatype != null;
			case MDMIPackage.SEMANTIC_ELEMENT__PROPERTY_QUALIFIER:
				return propertyQualifier != null && !propertyQualifier.isEmpty();
			case MDMIPackage.SEMANTIC_ELEMENT__COMPOSITE:
				return composite != null;
			case MDMIPackage.SEMANTIC_ELEMENT__ELEMENT_SET:
				return getElementSet() != null;
			case MDMIPackage.SEMANTIC_ELEMENT__BUSINESS_RULES:
				return businessRules != null && !businessRules.isEmpty();
			case MDMIPackage.SEMANTIC_ELEMENT__DATA_RULES:
				return dataRules != null && !dataRules.isEmpty();
			case MDMIPackage.SEMANTIC_ELEMENT__RELATIONSHIPS:
				return relationships != null && !relationships.isEmpty();
			case MDMIPackage.SEMANTIC_ELEMENT__MULTIPLE_INSTANCES:
				return multipleInstances != MULTIPLE_INSTANCES_EDEFAULT;
			case MDMIPackage.SEMANTIC_ELEMENT__MAP_FROM_MDMI:
				return mapFromMdmi != null && !mapFromMdmi.isEmpty();
			case MDMIPackage.SEMANTIC_ELEMENT__ORDERING:
				return ORDERING_EDEFAULT == null
						? ordering != null
						: !ORDERING_EDEFAULT.equals(ordering);
			case MDMIPackage.SEMANTIC_ELEMENT__ORDERING_LANGUAGE:
				return ORDERING_LANGUAGE_EDEFAULT == null
						? orderingLanguage != null
						: !ORDERING_LANGUAGE_EDEFAULT.equals(orderingLanguage);
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_VALUE:
				return computedValue != null;
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_IN_VALUE:
				return computedInValue != null;
			case MDMIPackage.SEMANTIC_ELEMENT__MAP_TO_MDMI:
				return mapToMdmi != null && !mapToMdmi.isEmpty();
			case MDMIPackage.SEMANTIC_ELEMENT__PARENT:
				return parent != null;
			case MDMIPackage.SEMANTIC_ELEMENT__CHILDREN:
				return children != null && !children.isEmpty();
			case MDMIPackage.SEMANTIC_ELEMENT__SYNTAX_NODE:
				return syntaxNode != null;
			case MDMIPackage.SEMANTIC_ELEMENT__COMPUTED_OUT_VALUE:
				return computedOutValue != null;
			case MDMIPackage.SEMANTIC_ELEMENT__KEYWORDS:
				return keywords != null && !keywords.isEmpty();
			case MDMIPackage.SEMANTIC_ELEMENT__ENUM_VALUE_FIELD:
				return ENUM_VALUE_FIELD_EDEFAULT == null
						? enumValueField != null
						: !ENUM_VALUE_FIELD_EDEFAULT.equals(enumValueField);
			case MDMIPackage.SEMANTIC_ELEMENT__ENUM_VALUE_DESCR_FIELD:
				return ENUM_VALUE_DESCR_FIELD_EDEFAULT == null
						? enumValueDescrField != null
						: !ENUM_VALUE_DESCR_FIELD_EDEFAULT.equals(enumValueDescrField);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", elementType: ");
		result.append(elementType);
		result.append(", propertyQualifier: ");
		result.append(propertyQualifier);
		result.append(", multipleInstances: ");
		result.append(multipleInstances);
		result.append(", ordering: ");
		result.append(ordering);
		result.append(", orderingLanguage: ");
		result.append(orderingLanguage);
		result.append(", enumValueField: ");
		result.append(enumValueField);
		result.append(", enumValueDescrField: ");
		result.append(enumValueDescrField);
		result.append(')');
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElement#isNullFlavor()
	 */
	@Override
	public boolean isNullFlavor() {
		// return false;
		// return false;
		if ((computedValue == null) || (this.getRelationshipByName("NULLFLAVOR") == null)) {
			return false;
		}
		String x = computedValue.getExpression();
		return !StringUtils.isEmpty(x);
	}

	/*
	 * @generated NOT
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElement#isComputedIn()
	 */
	@Override
	public boolean isComputedIn() {
		return this.computedInValue != null && !StringUtils.isEmpty(this.computedInValue.getExpression());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElement#getRelationshipByName(java.lang.String)
	 *
	 * @generated not
	 */
	@Override
	public SemanticElementRelationship getRelationshipByName(String relationshipName) {
		if (relationships != null) {
			for (SemanticElementRelationship relationship : relationships) {
				if (relationshipName.equals(relationship.getName())) {
					return relationship;
				}
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElement#getSemanticElementType()
	 */
	@Override
	public SemanticElementType getSemanticElementType() {
		if (this.elementType != null) {
			switch (this.elementType) {
				case "NORMAL":
					return org.mdmi.SemanticElementType.NORMAL;
				case "LOCAL":
					return org.mdmi.SemanticElementType.LOCAL;
				case "COMPUTED":
					return org.mdmi.SemanticElementType.COMPUTED;
				default:
					return org.mdmi.SemanticElementType.NORMAL;
			}
		}
		return org.mdmi.SemanticElementType.NORMAL;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElement#isComputed()
	 */
	@Override
	public boolean isComputed() {
		// return false;
		return !isNullFlavor() && this.computedValue != null &&
				!StringUtils.isEmpty(this.computedValue.getExpression());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElement#isComputedOut()
	 */
	@Override
	public boolean isComputedOut() {
		return this.computedOutValue != null && !StringUtils.isEmpty(this.computedOutValue.getExpression());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElement#getEnumValueSet()
	 */
	@Override
	public String getEnumValueSet() {
		return this.enumValueField;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElement#hasValidKeyRelation()
	 */
	@Override
	public boolean hasValidKeyRelation() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElement#hasChild(org.mdmi.SemanticElement)
	 */
	@Override
	public boolean hasChild(SemanticElement target) {
		// TODO Auto-generated method stub
		return false;
	}

	String uniqueID = null;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElement#getUniqueId()
	 */
	@Override
	public String getUniqueId() {
		if (uniqueID == null) {
			XMLResource xmlResource = (XMLResource) this.eResource();
			uniqueID = xmlResource.getID(this);
		}
		return uniqueID;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.SemanticElement#setPropertyQualifier(java.lang.String)
	 */
	@Override
	public void setPropertyQualifier(String value) {
		// TODO Auto-generated method stub
		EList<String> oldQualifier = propertyQualifier;
		propertyQualifier.clear();
		propertyQualifier.add(value);
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.SEMANTIC_ELEMENT__PROPERTY_QUALIFIER, oldQualifier,
					propertyQualifier));
		}
	}

} // SemanticElementImpl
