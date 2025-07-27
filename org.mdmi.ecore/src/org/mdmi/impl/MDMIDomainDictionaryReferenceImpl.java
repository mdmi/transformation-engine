/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MDMIDomainDictionaryReference;
import org.mdmi.MDMIPackage;
import org.mdmi.MessageGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Dictionary Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.impl.MDMIDomainDictionaryReferenceImpl#getName <em>Name</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIDomainDictionaryReferenceImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIDomainDictionaryReferenceImpl#getBusinessElements <em>Business Elements</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIDomainDictionaryReferenceImpl#getReference <em>Reference</em>}</li>
 * <li>{@link org.mdmi.impl.MDMIDomainDictionaryReferenceImpl#getGroup <em>Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MDMIDomainDictionaryReferenceImpl extends EObjectImpl implements MDMIDomainDictionaryReference {
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
	 * The cached value of the '{@link #getBusinessElements() <em>Business Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getBusinessElements()
	 * @generated
	 * @ordered
	 */
	protected EList<MDMIBusinessElementReference> businessElements;

	/**
	 * The default value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected String reference = REFERENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MDMIDomainDictionaryReferenceImpl() {
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
		return MDMIPackage.Literals.MDMI_DOMAIN_DICTIONARY_REFERENCE;
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
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__NAME, oldName, name));
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
					this, Notification.SET, MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__DESCRIPTION, oldDescription,
					description));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<MDMIBusinessElementReference> getBusinessElements() {
		if (businessElements == null) {
			businessElements = new EObjectContainmentWithInverseEList<>(
				MDMIBusinessElementReference.class, this,
				MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__BUSINESS_ELEMENTS,
				MDMIPackage.MDMI_BUSINESS_ELEMENT_REFERENCE__DOMAIN_DICTIONARY_REFERENCE);
		}
		return businessElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setReference(String newReference) {
		String oldReference = reference;
		reference = newReference;
		if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__REFERENCE, oldReference,
					reference));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MessageGroup getGroup() {
		if (eContainerFeatureID() != MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP) {
			return null;
		}
		return (MessageGroup) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetGroup(MessageGroup newGroup, NotificationChain msgs) {
		msgs = eBasicSetContainer(
			(InternalEObject) newGroup, MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setGroup(MessageGroup newGroup) {
		if (newGroup != eInternalContainer() ||
				(eContainerFeatureID() != MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP && newGroup != null)) {
			if (EcoreUtil.isAncestor(this, newGroup)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newGroup != null) {
				msgs = ((InternalEObject) newGroup).eInverseAdd(
					this, MDMIPackage.MESSAGE_GROUP__DOMAIN_DICTIONARY, MessageGroup.class, msgs);
			}
			msgs = basicSetGroup(newGroup, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(
				new ENotificationImpl(
					this, Notification.SET, MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP, newGroup, newGroup));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public void addBusinessElement(MDMIBusinessElementReference businessElementReference) {
		// make sure business elements is initialized
		int size = getBusinessElements().size();
		for (int i = 0; i < size; i++) {
			MDMIBusinessElementReference ber = businessElements.get(i);
			if (null == businessElementReference.getUniqueIdentifier() || null == ber.getUniqueIdentifier()) {
				continue;
			}
			if (businessElementReference.getUniqueIdentifier().equals(ber.getUniqueIdentifier())) {
				businessElements.set(i, businessElementReference);
				return;
			}
		}
		businessElements.add(businessElementReference);

	}

	@Override
	public MDMIBusinessElementReference findMDMIBusinessElementReference(String id) {

		getBusinessElements().size();
		for (MDMIBusinessElementReference ber : businessElements) {
			if (ber.getUniqueIdentifier().equals(id)) {
				return ber;

			}
		}
		return null;
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
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__BUSINESS_ELEMENTS:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getBusinessElements()).basicAdd(
					otherEnd, msgs);
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
				return basicSetGroup((MessageGroup) otherEnd, msgs);
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
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__BUSINESS_ELEMENTS:
				return ((InternalEList<?>) getBusinessElements()).basicRemove(otherEnd, msgs);
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP:
				return basicSetGroup(null, msgs);
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
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP:
				return eInternalContainer().eInverseRemove(
					this, MDMIPackage.MESSAGE_GROUP__DOMAIN_DICTIONARY, MessageGroup.class, msgs);
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
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__NAME:
				return getName();
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__DESCRIPTION:
				return getDescription();
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__BUSINESS_ELEMENTS:
				return getBusinessElements();
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__REFERENCE:
				return getReference();
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP:
				return getGroup();
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
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__NAME:
				setName((String) newValue);
				return;
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__BUSINESS_ELEMENTS:
				getBusinessElements().clear();
				getBusinessElements().addAll((Collection<? extends MDMIBusinessElementReference>) newValue);
				return;
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__REFERENCE:
				setReference((String) newValue);
				return;
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP:
				setGroup((MessageGroup) newValue);
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
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__BUSINESS_ELEMENTS:
				getBusinessElements().clear();
				return;
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP:
				setGroup((MessageGroup) null);
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
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__NAME:
				return NAME_EDEFAULT == null
						? name != null
						: !NAME_EDEFAULT.equals(name);
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__BUSINESS_ELEMENTS:
				return businessElements != null && !businessElements.isEmpty();
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__REFERENCE:
				return REFERENCE_EDEFAULT == null
						? reference != null
						: !REFERENCE_EDEFAULT.equals(reference);
			case MDMIPackage.MDMI_DOMAIN_DICTIONARY_REFERENCE__GROUP:
				return getGroup() != null;
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
		result.append(", reference: ");
		result.append(reference);
		result.append(')');
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.MDMIDomainDictionaryReference#getBusinessElement(org.mdmi.MDMIBusinessElementReference)
	 */
	@Override
	public MDMIBusinessElementReference getBusinessElement(MDMIBusinessElementReference name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.MDMIDomainDictionaryReference#getBusinessElementByUniqueID(java.lang.String)
	 *
	 * @generated not
	 */
	@Override
	public MDMIBusinessElementReference getBusinessElementByUniqueID(String uid) {

		for (MDMIBusinessElementReference be : this.getBusinessElements()) {
			if (uid.equals(be.getUniqueIdentifier())) {
				return be;
			}
		}

		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.MDMIDomainDictionaryReference#getBusinessElement(java.lang.String)
	 */
	@Override
	public MDMIBusinessElementReference getBusinessElement(String name) {

		for (MDMIBusinessElementReference be : this.getBusinessElements()) {
			if (name.equals(be.getName())) {
				return be;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

} // MDMIDomainDictionaryReferenceImpl
