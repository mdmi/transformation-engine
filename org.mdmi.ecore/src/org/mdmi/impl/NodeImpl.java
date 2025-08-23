/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.impl;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.mdmi.MDMIPackage;
import org.mdmi.MessageSyntaxModel;
import org.mdmi.Node;
import org.mdmi.SemanticElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.NodeImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.NodeImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.NodeImpl#getMinOccurs <em>Min Occurs</em>}</li>
 * <li>{@link org.mdmi.impl.NodeImpl#getMaxOccurs <em>Max Occurs</em>}</li>
 * <li>{@link org.mdmi.impl.NodeImpl#getLocation <em>Location</em>}</li>
 * <li>{@link org.mdmi.impl.NodeImpl#getLocationExpressionLanguage <em>Location Expression Language</em>}</li>
 * <li>{@link org.mdmi.impl.NodeImpl#getSyntaxModel <em>Syntax Model</em>}</li>
 * <li>{@link org.mdmi.impl.NodeImpl#getSemanticElement <em>Semantic Element</em>}</li>
 * <li>{@link org.mdmi.impl.NodeImpl#getFieldName <em>Field Name</em>}</li>
 * <li>{@link org.mdmi.impl.NodeImpl#isIsSyntacticField <em>Is Syntactic Field</em>}</li>
 * <li>{@link org.mdmi.impl.NodeImpl#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NodeImpl extends EObjectImpl implements Node {
	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.Node#getCurrentRelative()
	 */

	String currentRelative = null;

	@Override
	public String getCurrentRelative() {
		return currentRelative;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.Node#setCurrentRelative(java.lang.String)
	 */
	@Override
	public void setCurrentRelative(String s) {
		currentRelative = s;

	}

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	protected static final String DESCRIPTION_EDEFAULT = "";

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
	 * The default value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_OCCURS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected int minOccurs = MIN_OCCURS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_OCCURS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected int maxOccurs = MAX_OCCURS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getLocation()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocationExpressionLanguage() <em>Location Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getLocationExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EXPRESSION_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocationExpressionLanguage() <em>Location Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getLocationExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected String locationExpressionLanguage = LOCATION_EXPRESSION_LANGUAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSemanticElement() <em>Semantic Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSemanticElement()
	 * @generated
	 * @ordered
	 */
	protected SemanticElement semanticElement;

	/**
	 * The default value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected String fieldName = FIELD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsSyntacticField() <em>Is Syntactic Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isIsSyntacticField()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SYNTACTIC_FIELD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSyntacticField() <em>Is Syntactic Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isIsSyntacticField()
	 * @generated
	 * @ordered
	 */
	protected boolean isSyntacticField = IS_SYNTACTIC_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = "path";

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected NodeImpl() {
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
		return MDMIPackage.Literals.NODE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.NODE__NAME, oldName, name));
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
					this, Notification.SET, MDMIPackage.NODE__DESCRIPTION, oldDescription, description));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getMinOccurs() {
		return minOccurs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMinOccurs(int newMinOccurs) {
		int oldMinOccurs = minOccurs;
		minOccurs = newMinOccurs;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(this, Notification.SET, MDMIPackage.NODE__MIN_OCCURS, oldMinOccurs, minOccurs));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getMaxOccurs() {
		return maxOccurs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMaxOccurs(int newMaxOccurs) {
		int oldMaxOccurs = maxOccurs;
		maxOccurs = newMaxOccurs;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(this, Notification.SET, MDMIPackage.NODE__MAX_OCCURS, oldMaxOccurs, maxOccurs));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.NODE__LOCATION, oldLocation, location));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getLocationExpressionLanguage() {
		return locationExpressionLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setLocationExpressionLanguage(String newLocationExpressionLanguage) {
		String oldLocationExpressionLanguage = locationExpressionLanguage;
		locationExpressionLanguage = newLocationExpressionLanguage;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.NODE__LOCATION_EXPRESSION_LANGUAGE,
					oldLocationExpressionLanguage, locationExpressionLanguage));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MessageSyntaxModel getSyntaxModel() {
		if (eContainerFeatureID() != MDMIPackage.NODE__SYNTAX_MODEL) {
			return null;
		}
		return (MessageSyntaxModel) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetSyntaxModel(MessageSyntaxModel newSyntaxModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newSyntaxModel, MDMIPackage.NODE__SYNTAX_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSyntaxModel(MessageSyntaxModel newSyntaxModel) {
		if (newSyntaxModel != eInternalContainer() ||
				(eContainerFeatureID() != MDMIPackage.NODE__SYNTAX_MODEL && newSyntaxModel != null)) {
			if (EcoreUtil.isAncestor(this, newSyntaxModel)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newSyntaxModel != null) {
				msgs = ((InternalEObject) newSyntaxModel).eInverseAdd(
					this, MDMIPackage.MESSAGE_SYNTAX_MODEL__ROOT, MessageSyntaxModel.class, msgs);
			}
			msgs = basicSetSyntaxModel(newSyntaxModel, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.NODE__SYNTAX_MODEL, newSyntaxModel, newSyntaxModel));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SemanticElement getSemanticElement() {
		return semanticElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetSemanticElement(SemanticElement newSemanticElement, NotificationChain msgs) {
		SemanticElement oldSemanticElement = semanticElement;
		semanticElement = newSemanticElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.NODE__SEMANTIC_ELEMENT, oldSemanticElement, newSemanticElement);
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
	public void setSemanticElement(SemanticElement newSemanticElement) {
		if (newSemanticElement != semanticElement) {
			NotificationChain msgs = null;
			if (semanticElement != null) {
				msgs = ((InternalEObject) semanticElement).eInverseRemove(
					this, MDMIPackage.SEMANTIC_ELEMENT__SYNTAX_NODE, SemanticElement.class, msgs);
			}
			if (newSemanticElement != null) {
				msgs = ((InternalEObject) newSemanticElement).eInverseAdd(
					this, MDMIPackage.SEMANTIC_ELEMENT__SYNTAX_NODE, SemanticElement.class, msgs);
			}
			msgs = basicSetSemanticElement(newSemanticElement, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.NODE__SEMANTIC_ELEMENT, newSemanticElement,
					newSemanticElement));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setFieldName(String newFieldName) {
		String oldFieldName = fieldName;
		fieldName = newFieldName;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(this, Notification.SET, MDMIPackage.NODE__FIELD_NAME, oldFieldName, fieldName));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isIsSyntacticField() {
		return isSyntacticField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setIsSyntacticField(boolean newIsSyntacticField) {
		boolean oldIsSyntacticField = isSyntacticField;
		isSyntacticField = newIsSyntacticField;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.NODE__IS_SYNTACTIC_FIELD, oldIsSyntacticField,
					isSyntacticField));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.NODE__PATH, oldPath, path));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public String getCompletePath() {
		StringBuffer sb = new StringBuffer();
		// Node currentNode = this;
		int ii = 0;
		SemanticElement se = getSemanticElement();
		if (se != null && se.getSyntaxNode() != null) {
			while (se != null && se.getSyntaxNode() != null && ii < 10) {

				String location = se.getSyntaxNode().getLocation();
				if (!StringUtils.isEmpty(location)) {
					sb.insert(0, "\\" + location.split("\\[")[0]);
					se = se.getParent();
				}
				ii++;

			}
		}

		return sb.toString();

		// return "COMPLETELPATH";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MDMIPackage.NODE__SYNTAX_MODEL:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
				return basicSetSyntaxModel((MessageSyntaxModel) otherEnd, msgs);
			case MDMIPackage.NODE__SEMANTIC_ELEMENT:
				if (semanticElement != null) {
					msgs = ((InternalEObject) semanticElement).eInverseRemove(
						this, MDMIPackage.SEMANTIC_ELEMENT__SYNTAX_NODE, SemanticElement.class, msgs);
				}
				return basicSetSemanticElement((SemanticElement) otherEnd, msgs);
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
			case MDMIPackage.NODE__SYNTAX_MODEL:
				return basicSetSyntaxModel(null, msgs);
			case MDMIPackage.NODE__SEMANTIC_ELEMENT:
				return basicSetSemanticElement(null, msgs);
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
			case MDMIPackage.NODE__SYNTAX_MODEL:
				return eInternalContainer().eInverseRemove(
					this, MDMIPackage.MESSAGE_SYNTAX_MODEL__ROOT, MessageSyntaxModel.class, msgs);
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
			case MDMIPackage.NODE__NAME:
				return getName();
			case MDMIPackage.NODE__DESCRIPTION:
				return getDescription();
			case MDMIPackage.NODE__MIN_OCCURS:
				return getMinOccurs();
			case MDMIPackage.NODE__MAX_OCCURS:
				return getMaxOccurs();
			case MDMIPackage.NODE__LOCATION:
				return getLocation();
			case MDMIPackage.NODE__LOCATION_EXPRESSION_LANGUAGE:
				return getLocationExpressionLanguage();
			case MDMIPackage.NODE__SYNTAX_MODEL:
				return getSyntaxModel();
			case MDMIPackage.NODE__SEMANTIC_ELEMENT:
				return getSemanticElement();
			case MDMIPackage.NODE__FIELD_NAME:
				return getFieldName();
			case MDMIPackage.NODE__IS_SYNTACTIC_FIELD:
				return isIsSyntacticField();
			case MDMIPackage.NODE__PATH:
				return getPath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MDMIPackage.NODE__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.NODE__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.NODE__MIN_OCCURS:
				setMinOccurs((Integer) newValue);
				return;
			case MDMIPackage.NODE__MAX_OCCURS:
				setMaxOccurs((Integer) newValue);
				return;
			case MDMIPackage.NODE__LOCATION:
				setLocation((String) newValue);
				return;
			case MDMIPackage.NODE__LOCATION_EXPRESSION_LANGUAGE:
				setLocationExpressionLanguage((String) newValue);
				return;
			case MDMIPackage.NODE__SYNTAX_MODEL:
				setSyntaxModel((MessageSyntaxModel) newValue);
				return;
			case MDMIPackage.NODE__SEMANTIC_ELEMENT:
				setSemanticElement((SemanticElement) newValue);
				return;
			case MDMIPackage.NODE__FIELD_NAME:
				setFieldName((String) newValue);
				return;
			case MDMIPackage.NODE__IS_SYNTACTIC_FIELD:
				setIsSyntacticField((Boolean) newValue);
				return;
			case MDMIPackage.NODE__PATH:
				setPath((String) newValue);
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
			case MDMIPackage.NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.NODE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.NODE__MIN_OCCURS:
				setMinOccurs(MIN_OCCURS_EDEFAULT);
				return;
			case MDMIPackage.NODE__MAX_OCCURS:
				setMaxOccurs(MAX_OCCURS_EDEFAULT);
				return;
			case MDMIPackage.NODE__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case MDMIPackage.NODE__LOCATION_EXPRESSION_LANGUAGE:
				setLocationExpressionLanguage(LOCATION_EXPRESSION_LANGUAGE_EDEFAULT);
				return;
			case MDMIPackage.NODE__SYNTAX_MODEL:
				setSyntaxModel((MessageSyntaxModel) null);
				return;
			case MDMIPackage.NODE__SEMANTIC_ELEMENT:
				setSemanticElement((SemanticElement) null);
				return;
			case MDMIPackage.NODE__FIELD_NAME:
				setFieldName(FIELD_NAME_EDEFAULT);
				return;
			case MDMIPackage.NODE__IS_SYNTACTIC_FIELD:
				setIsSyntacticField(IS_SYNTACTIC_FIELD_EDEFAULT);
				return;
			case MDMIPackage.NODE__PATH:
				setPath(PATH_EDEFAULT);
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
			case MDMIPackage.NODE__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.NODE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.NODE__MIN_OCCURS:
				return minOccurs != MIN_OCCURS_EDEFAULT;
			case MDMIPackage.NODE__MAX_OCCURS:
				return maxOccurs != MAX_OCCURS_EDEFAULT;
			case MDMIPackage.NODE__LOCATION:
				return LOCATION_EDEFAULT == null
						? location != null
						: !LOCATION_EDEFAULT.equals(location);
			case MDMIPackage.NODE__LOCATION_EXPRESSION_LANGUAGE:
				return LOCATION_EXPRESSION_LANGUAGE_EDEFAULT == null
						? locationExpressionLanguage != null
						: !LOCATION_EXPRESSION_LANGUAGE_EDEFAULT.equals(locationExpressionLanguage);
			case MDMIPackage.NODE__SYNTAX_MODEL:
				return getSyntaxModel() != null;
			case MDMIPackage.NODE__SEMANTIC_ELEMENT:
				return semanticElement != null;
			case MDMIPackage.NODE__FIELD_NAME:
				return FIELD_NAME_EDEFAULT == null
						? fieldName != null
						: !FIELD_NAME_EDEFAULT.equals(fieldName);
			case MDMIPackage.NODE__IS_SYNTACTIC_FIELD:
				return isSyntacticField != IS_SYNTACTIC_FIELD_EDEFAULT;
			case MDMIPackage.NODE__PATH:
				return PATH_EDEFAULT == null
						? path != null
						: !PATH_EDEFAULT.equals(path);
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
		result.append(", minOccurs: ");
		result.append(minOccurs);
		result.append(", maxOccurs: ");
		result.append(maxOccurs);
		result.append(", location: ");
		result.append(location);
		result.append(", locationExpressionLanguage: ");
		result.append(locationExpressionLanguage);
		result.append(", fieldName: ");
		result.append(fieldName);
		result.append(", isSyntacticField: ");
		result.append(isSyntacticField);
		result.append(", path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Node getParentNode() {
		if (this.eContainer instanceof Node) {
			return (Node) this.eContainer;
		}
		return null;
	}

} // NodeImpl
