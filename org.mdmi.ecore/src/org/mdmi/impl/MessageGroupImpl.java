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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.mdmi.DTSPrimitive;
import org.mdmi.DataRule;
import org.mdmi.DatatypeMap;
import org.mdmi.MDMIDatatype;
import org.mdmi.MDMIDomainDictionaryReference;
import org.mdmi.MDMIFactory;
import org.mdmi.MDMIPackage;
import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getDataRules <em>Data Rules</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getDefaultLocationExprLang <em>Default Location Expr Lang</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getDefaultConstraintExprLang <em>Default Constraint Expr Lang</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getDefaultRuleExprLang <em>Default Rule Expr Lang</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getDefaultFormatExpressionLanguage <em>Default Format Expression Language</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getDefaultOrderingExpressionLanguage <em>Default Ordering Expression Language</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getModels <em>Models</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getDomainDictionary <em>Domain Dictionary</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getDefaultMDMIExpresionLanguage <em>Default MDMI Expresion Language</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getRules <em>Rules</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getDatatypes <em>Datatypes</em>}</li>
 * <li>{@link org.mdmi.impl.MessageGroupImpl#getDatatypeMaps <em>Datatype Maps</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageGroupImpl extends EObjectImpl implements MessageGroup {
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
	 * The cached value of the '{@link #getDataRules() <em>Data Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDataRules()
	 * @generated
	 * @ordered
	 */
	protected EList<DataRule> dataRules;

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
	 * The default value of the '{@link #getDefaultLocationExprLang() <em>Default Location Expr Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDefaultLocationExprLang()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_LOCATION_EXPR_LANG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultLocationExprLang() <em>Default Location Expr Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDefaultLocationExprLang()
	 * @generated
	 * @ordered
	 */
	protected String defaultLocationExprLang = DEFAULT_LOCATION_EXPR_LANG_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultConstraintExprLang() <em>Default Constraint Expr Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDefaultConstraintExprLang()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_CONSTRAINT_EXPR_LANG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultConstraintExprLang() <em>Default Constraint Expr Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDefaultConstraintExprLang()
	 * @generated
	 * @ordered
	 */
	protected String defaultConstraintExprLang = DEFAULT_CONSTRAINT_EXPR_LANG_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultRuleExprLang() <em>Default Rule Expr Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDefaultRuleExprLang()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_RULE_EXPR_LANG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultRuleExprLang() <em>Default Rule Expr Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDefaultRuleExprLang()
	 * @generated
	 * @ordered
	 */
	protected String defaultRuleExprLang = DEFAULT_RULE_EXPR_LANG_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultFormatExpressionLanguage() <em>Default Format Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDefaultFormatExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_FORMAT_EXPRESSION_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultFormatExpressionLanguage() <em>Default Format Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDefaultFormatExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected String defaultFormatExpressionLanguage = DEFAULT_FORMAT_EXPRESSION_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultOrderingExpressionLanguage() <em>Default Ordering Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDefaultOrderingExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_ORDERING_EXPRESSION_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultOrderingExpressionLanguage() <em>Default Ordering Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDefaultOrderingExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected String defaultOrderingExpressionLanguage = DEFAULT_ORDERING_EXPRESSION_LANGUAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getModels()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageModel> models;

	/**
	 * The cached value of the '{@link #getDomainDictionary() <em>Domain Dictionary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDomainDictionary()
	 * @generated
	 * @ordered
	 */
	protected MDMIDomainDictionaryReference domainDictionary;

	/**
	 * The default value of the '{@link #getDefaultMDMIExpresionLanguage() <em>Default MDMI Expresion Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDefaultMDMIExpresionLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_MDMI_EXPRESION_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultMDMIExpresionLanguage() <em>Default MDMI Expresion Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDefaultMDMIExpresionLanguage()
	 * @generated
	 * @ordered
	 */
	protected String defaultMDMIExpresionLanguage = DEFAULT_MDMI_EXPRESION_LANGUAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<DataRule> rules;

	/**
	 * The cached value of the '{@link #getDatatypes() <em>Datatypes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDatatypes()
	 * @generated
	 * @ordered
	 */
	protected EList<MDMIDatatype> datatypes;

	/**
	 * The cached value of the '{@link #getDatatypeMaps() <em>Datatype Maps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDatatypeMaps()
	 * @generated
	 * @ordered
	 */
	protected EList<DatatypeMap> datatypeMaps;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MessageGroupImpl() {
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
		return MDMIPackage.Literals.MESSAGE_GROUP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MDMIPackage.MESSAGE_GROUP__NAME, oldName, name));
		}
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
			dataRules = new EObjectContainmentWithInverseEList<>(
				DataRule.class, this, MDMIPackage.MESSAGE_GROUP__DATA_RULES, MDMIPackage.DATA_RULE__SCOPE);
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
					this, Notification.SET, MDMIPackage.MESSAGE_GROUP__DESCRIPTION, oldDescription, description));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getDefaultLocationExprLang() {
		return defaultLocationExprLang;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDefaultLocationExprLang(String newDefaultLocationExprLang) {
		String oldDefaultLocationExprLang = defaultLocationExprLang;
		defaultLocationExprLang = newDefaultLocationExprLang;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_GROUP__DEFAULT_LOCATION_EXPR_LANG,
					oldDefaultLocationExprLang, defaultLocationExprLang));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getDefaultConstraintExprLang() {
		return defaultConstraintExprLang;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDefaultConstraintExprLang(String newDefaultConstraintExprLang) {
		String oldDefaultConstraintExprLang = defaultConstraintExprLang;
		defaultConstraintExprLang = newDefaultConstraintExprLang;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_GROUP__DEFAULT_CONSTRAINT_EXPR_LANG,
					oldDefaultConstraintExprLang, defaultConstraintExprLang));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getDefaultRuleExprLang() {
		return defaultRuleExprLang;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDefaultRuleExprLang(String newDefaultRuleExprLang) {
		String oldDefaultRuleExprLang = defaultRuleExprLang;
		defaultRuleExprLang = newDefaultRuleExprLang;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_GROUP__DEFAULT_RULE_EXPR_LANG, oldDefaultRuleExprLang,
					defaultRuleExprLang));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getDefaultFormatExpressionLanguage() {
		return defaultFormatExpressionLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDefaultFormatExpressionLanguage(String newDefaultFormatExpressionLanguage) {
		String oldDefaultFormatExpressionLanguage = defaultFormatExpressionLanguage;
		defaultFormatExpressionLanguage = newDefaultFormatExpressionLanguage;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_GROUP__DEFAULT_FORMAT_EXPRESSION_LANGUAGE,
					oldDefaultFormatExpressionLanguage, defaultFormatExpressionLanguage));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getDefaultOrderingExpressionLanguage() {
		return defaultOrderingExpressionLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDefaultOrderingExpressionLanguage(String newDefaultOrderingExpressionLanguage) {
		String oldDefaultOrderingExpressionLanguage = defaultOrderingExpressionLanguage;
		defaultOrderingExpressionLanguage = newDefaultOrderingExpressionLanguage;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_GROUP__DEFAULT_ORDERING_EXPRESSION_LANGUAGE,
					oldDefaultOrderingExpressionLanguage, defaultOrderingExpressionLanguage));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<MessageModel> getModels() {
		if (models == null) {
			models = new EObjectContainmentWithInverseEList<>(
				MessageModel.class, this, MDMIPackage.MESSAGE_GROUP__MODELS, MDMIPackage.MESSAGE_MODEL__GROUP);
		}
		return models;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MDMIDomainDictionaryReference getDomainDictionary() {
		return domainDictionary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetDomainDictionary(MDMIDomainDictionaryReference newDomainDictionary,
			NotificationChain msgs) {
		MDMIDomainDictionaryReference oldDomainDictionary = domainDictionary;
		domainDictionary = newDomainDictionary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, MDMIPackage.MESSAGE_GROUP__DOMAIN_DICTIONARY, oldDomainDictionary,
				newDomainDictionary);
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
	public void setDomainDictionary(MDMIDomainDictionaryReference newDomainDictionary) {
		if (newDomainDictionary != domainDictionary) {
			NotificationChain msgs = null;
			if (domainDictionary != null) {
				msgs = ((InternalEObject) domainDictionary).eInverseRemove(
					this, MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP, MDMIDomainDictionaryReference.class,
					msgs);
			}
			if (newDomainDictionary != null) {
				msgs = ((InternalEObject) newDomainDictionary).eInverseAdd(
					this, MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP, MDMIDomainDictionaryReference.class,
					msgs);
			}
			msgs = basicSetDomainDictionary(newDomainDictionary, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_GROUP__DOMAIN_DICTIONARY, newDomainDictionary,
					newDomainDictionary));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getDefaultMDMIExpresionLanguage() {
		return defaultMDMIExpresionLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDefaultMDMIExpresionLanguage(String newDefaultMDMIExpresionLanguage) {
		String oldDefaultMDMIExpresionLanguage = defaultMDMIExpresionLanguage;
		defaultMDMIExpresionLanguage = newDefaultMDMIExpresionLanguage;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MESSAGE_GROUP__DEFAULT_MDMI_EXPRESION_LANGUAGE,
					oldDefaultMDMIExpresionLanguage, defaultMDMIExpresionLanguage));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<DataRule> getRules() {
		if (rules == null) {
			rules = new EObjectWithInverseResolvingEList<>(
				DataRule.class, this, MDMIPackage.MESSAGE_GROUP__RULES, MDMIPackage.DATA_RULE__GROUP);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<MDMIDatatype> getDatatypes() {
		if (datatypes == null) {
			datatypes = new EObjectContainmentEList<>(MDMIDatatype.class, this, MDMIPackage.MESSAGE_GROUP__DATATYPES);
		}
		return datatypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<DatatypeMap> getDatatypeMaps() {
		if (datatypeMaps == null) {
			datatypeMaps = new EObjectContainmentEList<>(
				DatatypeMap.class, this, MDMIPackage.MESSAGE_GROUP__DATATYPE_MAPS);
		}
		return datatypeMaps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public MDMIDatatype getDatatype(String name) {
		if (datatypes != null) {
			for (int i = 0; i < datatypes.size(); i++) {
				MDMIDatatype dt = datatypes.get(i);
				if (dt.getTypeName().equals(name)) {
					return dt;
				}
			}
		}

		DTSPrimitive primitive = MDMIFactory.eINSTANCE.createDTSPrimitive();

		primitive.setTypeName(name);

		return primitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public void addDatatype(MDMIDatatype datatype) {
		for (int i = 0; i < getDatatypeMaps().size(); i++) {
			MDMIDatatype dt = datatypes.get(i);
			if (dt.getTypeName().equals(datatype.getTypeName())) {
				datatypes.set(i, datatype);
				return;
			}
		}
		datatypes.add(datatype);
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
			case MDMIPackage.MESSAGE_GROUP__DATA_RULES:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getDataRules()).basicAdd(otherEnd, msgs);
			case MDMIPackage.MESSAGE_GROUP__MODELS:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getModels()).basicAdd(otherEnd, msgs);
			case MDMIPackage.MESSAGE_GROUP__DOMAIN_DICTIONARY:
				if (domainDictionary != null) {
					msgs = ((InternalEObject) domainDictionary).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE - MDMIPackage.MESSAGE_GROUP__DOMAIN_DICTIONARY, null, msgs);
				}
				return basicSetDomainDictionary((MDMIDomainDictionaryReference) otherEnd, msgs);
			case MDMIPackage.MESSAGE_GROUP__RULES:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getRules()).basicAdd(otherEnd, msgs);
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
			case MDMIPackage.MESSAGE_GROUP__DATA_RULES:
				return ((InternalEList<?>) getDataRules()).basicRemove(otherEnd, msgs);
			case MDMIPackage.MESSAGE_GROUP__MODELS:
				return ((InternalEList<?>) getModels()).basicRemove(otherEnd, msgs);
			case MDMIPackage.MESSAGE_GROUP__DOMAIN_DICTIONARY:
				return basicSetDomainDictionary(null, msgs);
			case MDMIPackage.MESSAGE_GROUP__RULES:
				return ((InternalEList<?>) getRules()).basicRemove(otherEnd, msgs);
			case MDMIPackage.MESSAGE_GROUP__DATATYPES:
				return ((InternalEList<?>) getDatatypes()).basicRemove(otherEnd, msgs);
			case MDMIPackage.MESSAGE_GROUP__DATATYPE_MAPS:
				return ((InternalEList<?>) getDatatypeMaps()).basicRemove(otherEnd, msgs);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MDMIPackage.MESSAGE_GROUP__NAME:
				return getName();
			case MDMIPackage.MESSAGE_GROUP__DATA_RULES:
				return getDataRules();
			case MDMIPackage.MESSAGE_GROUP__DESCRIPTION:
				return getDescription();
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_LOCATION_EXPR_LANG:
				return getDefaultLocationExprLang();
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_CONSTRAINT_EXPR_LANG:
				return getDefaultConstraintExprLang();
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_RULE_EXPR_LANG:
				return getDefaultRuleExprLang();
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_FORMAT_EXPRESSION_LANGUAGE:
				return getDefaultFormatExpressionLanguage();
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_ORDERING_EXPRESSION_LANGUAGE:
				return getDefaultOrderingExpressionLanguage();
			case MDMIPackage.MESSAGE_GROUP__MODELS:
				return getModels();
			case MDMIPackage.MESSAGE_GROUP__DOMAIN_DICTIONARY:
				return getDomainDictionary();
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_MDMI_EXPRESION_LANGUAGE:
				return getDefaultMDMIExpresionLanguage();
			case MDMIPackage.MESSAGE_GROUP__RULES:
				return getRules();
			case MDMIPackage.MESSAGE_GROUP__DATATYPES:
				return getDatatypes();
			case MDMIPackage.MESSAGE_GROUP__DATATYPE_MAPS:
				return getDatatypeMaps();
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
			case MDMIPackage.MESSAGE_GROUP__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__DATA_RULES:
				getDataRules().clear();
				getDataRules().addAll((Collection<? extends DataRule>) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_LOCATION_EXPR_LANG:
				setDefaultLocationExprLang((String) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_CONSTRAINT_EXPR_LANG:
				setDefaultConstraintExprLang((String) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_RULE_EXPR_LANG:
				setDefaultRuleExprLang((String) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_FORMAT_EXPRESSION_LANGUAGE:
				setDefaultFormatExpressionLanguage((String) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_ORDERING_EXPRESSION_LANGUAGE:
				setDefaultOrderingExpressionLanguage((String) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__MODELS:
				getModels().clear();
				getModels().addAll((Collection<? extends MessageModel>) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__DOMAIN_DICTIONARY:
				setDomainDictionary((MDMIDomainDictionaryReference) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_MDMI_EXPRESION_LANGUAGE:
				setDefaultMDMIExpresionLanguage((String) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends DataRule>) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__DATATYPES:
				getDatatypes().clear();
				getDatatypes().addAll((Collection<? extends MDMIDatatype>) newValue);
				return;
			case MDMIPackage.MESSAGE_GROUP__DATATYPE_MAPS:
				getDatatypeMaps().clear();
				getDatatypeMaps().addAll((Collection<? extends DatatypeMap>) newValue);
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
			case MDMIPackage.MESSAGE_GROUP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.MESSAGE_GROUP__DATA_RULES:
				getDataRules().clear();
				return;
			case MDMIPackage.MESSAGE_GROUP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_LOCATION_EXPR_LANG:
				setDefaultLocationExprLang(DEFAULT_LOCATION_EXPR_LANG_EDEFAULT);
				return;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_CONSTRAINT_EXPR_LANG:
				setDefaultConstraintExprLang(DEFAULT_CONSTRAINT_EXPR_LANG_EDEFAULT);
				return;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_RULE_EXPR_LANG:
				setDefaultRuleExprLang(DEFAULT_RULE_EXPR_LANG_EDEFAULT);
				return;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_FORMAT_EXPRESSION_LANGUAGE:
				setDefaultFormatExpressionLanguage(DEFAULT_FORMAT_EXPRESSION_LANGUAGE_EDEFAULT);
				return;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_ORDERING_EXPRESSION_LANGUAGE:
				setDefaultOrderingExpressionLanguage(DEFAULT_ORDERING_EXPRESSION_LANGUAGE_EDEFAULT);
				return;
			case MDMIPackage.MESSAGE_GROUP__MODELS:
				getModels().clear();
				return;
			case MDMIPackage.MESSAGE_GROUP__DOMAIN_DICTIONARY:
				setDomainDictionary((MDMIDomainDictionaryReference) null);
				return;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_MDMI_EXPRESION_LANGUAGE:
				setDefaultMDMIExpresionLanguage(DEFAULT_MDMI_EXPRESION_LANGUAGE_EDEFAULT);
				return;
			case MDMIPackage.MESSAGE_GROUP__RULES:
				getRules().clear();
				return;
			case MDMIPackage.MESSAGE_GROUP__DATATYPES:
				getDatatypes().clear();
				return;
			case MDMIPackage.MESSAGE_GROUP__DATATYPE_MAPS:
				getDatatypeMaps().clear();
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
			case MDMIPackage.MESSAGE_GROUP__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.MESSAGE_GROUP__DATA_RULES:
				return dataRules != null && !dataRules.isEmpty();
			case MDMIPackage.MESSAGE_GROUP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_LOCATION_EXPR_LANG:
				return DEFAULT_LOCATION_EXPR_LANG_EDEFAULT == null
						? defaultLocationExprLang != null
						: !DEFAULT_LOCATION_EXPR_LANG_EDEFAULT.equals(defaultLocationExprLang);
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_CONSTRAINT_EXPR_LANG:
				return DEFAULT_CONSTRAINT_EXPR_LANG_EDEFAULT == null
						? defaultConstraintExprLang != null
						: !DEFAULT_CONSTRAINT_EXPR_LANG_EDEFAULT.equals(defaultConstraintExprLang);
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_RULE_EXPR_LANG:
				return DEFAULT_RULE_EXPR_LANG_EDEFAULT == null
						? defaultRuleExprLang != null
						: !DEFAULT_RULE_EXPR_LANG_EDEFAULT.equals(defaultRuleExprLang);
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_FORMAT_EXPRESSION_LANGUAGE:
				return DEFAULT_FORMAT_EXPRESSION_LANGUAGE_EDEFAULT == null
						? defaultFormatExpressionLanguage != null
						: !DEFAULT_FORMAT_EXPRESSION_LANGUAGE_EDEFAULT.equals(defaultFormatExpressionLanguage);
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_ORDERING_EXPRESSION_LANGUAGE:
				return DEFAULT_ORDERING_EXPRESSION_LANGUAGE_EDEFAULT == null
						? defaultOrderingExpressionLanguage != null
						: !DEFAULT_ORDERING_EXPRESSION_LANGUAGE_EDEFAULT.equals(defaultOrderingExpressionLanguage);
			case MDMIPackage.MESSAGE_GROUP__MODELS:
				return models != null && !models.isEmpty();
			case MDMIPackage.MESSAGE_GROUP__DOMAIN_DICTIONARY:
				return domainDictionary != null;
			case MDMIPackage.MESSAGE_GROUP__DEFAULT_MDMI_EXPRESION_LANGUAGE:
				return DEFAULT_MDMI_EXPRESION_LANGUAGE_EDEFAULT == null
						? defaultMDMIExpresionLanguage != null
						: !DEFAULT_MDMI_EXPRESION_LANGUAGE_EDEFAULT.equals(defaultMDMIExpresionLanguage);
			case MDMIPackage.MESSAGE_GROUP__RULES:
				return rules != null && !rules.isEmpty();
			case MDMIPackage.MESSAGE_GROUP__DATATYPES:
				return datatypes != null && !datatypes.isEmpty();
			case MDMIPackage.MESSAGE_GROUP__DATATYPE_MAPS:
				return datatypeMaps != null && !datatypeMaps.isEmpty();
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
		result.append(", defaultLocationExprLang: ");
		result.append(defaultLocationExprLang);
		result.append(", defaultConstraintExprLang: ");
		result.append(defaultConstraintExprLang);
		result.append(", defaultRuleExprLang: ");
		result.append(defaultRuleExprLang);
		result.append(", defaultFormatExpressionLanguage: ");
		result.append(defaultFormatExpressionLanguage);
		result.append(", defaultOrderingExpressionLanguage: ");
		result.append(defaultOrderingExpressionLanguage);
		result.append(", defaultMDMIExpresionLanguage: ");
		result.append(defaultMDMIExpresionLanguage);
		result.append(')');
		return result.toString();
	}

	/*
	 * @generated NOT
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.MessageGroup#getModel(java.lang.String)
	 */
	@Override
	public MessageModel getModel(String messageModel) {

		for (MessageModel mm : this.getModels()) {
			if (mm != null) {
				return mm;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

} // MessageGroupImpl
