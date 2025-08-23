/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Keyword</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * The keyword class contains either a keyword or a keyword/value pair. The set of Keywords can be used to profile a SemanticElement, to provide a
 * mechanism to search for a SemanticElement, and to associate a SemanticElement with an external ontology or taxonomy.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.Keyword#getDescription <em>Description</em>}</li>
 * <li>{@link org.mdmi.Keyword#getKeyword <em>Keyword</em>}</li>
 * <li>{@link org.mdmi.Keyword#getKeywordValue <em>Keyword Value</em>}</li>
 * <li>{@link org.mdmi.Keyword#getReference <em>Reference</em>}</li>
 * <li>{@link org.mdmi.Keyword#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getKeyword()
 * @model
 * @generated
 */
public interface Keyword extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The optional "description" property of type string describing the Keyword and/or the set of Keyword associated with a SemanticElement.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.mdmi.MDMIPackage#getKeyword_Description()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.mdmi.Keyword#getDescription <em>Description</em>}' attribute.
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
	 * Returns the value of the '<em><b>Keyword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A "keyword" property of type String is used to describe or profile a SemanticElement.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Keyword</em>' attribute.
	 * @see #setKeyword(String)
	 * @see org.mdmi.MDMIPackage#getKeyword_Keyword()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getKeyword();

	/**
	 * Sets the value of the '{@link org.mdmi.Keyword#getKeyword <em>Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Keyword</em>' attribute.
	 * @see #getKeyword()
	 * @generated
	 */
	void setKeyword(String value);

	/**
	 * Returns the value of the '<em><b>Keyword Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * An optional "keywordValue" of type string that is associated with the keyword creating a keyword/value pair.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Keyword Value</em>' attribute.
	 * @see #setKeywordValue(String)
	 * @see org.mdmi.MDMIPackage#getKeyword_KeywordValue()
	 * @model ordered="false"
	 * @generated
	 */
	String getKeywordValue();

	/**
	 * Sets the value of the '{@link org.mdmi.Keyword#getKeywordValue <em>Keyword Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Keyword Value</em>' attribute.
	 * @see #getKeywordValue()
	 * @generated
	 */
	void setKeywordValue(String value);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * An optional reference that identifies the origin set for the keywords, for example a formal ontology.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Reference</em>' attribute.
	 * @see #setReference(String)
	 * @see org.mdmi.MDMIPackage#getKeyword_Reference()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getReference();

	/**
	 * Sets the value of the '{@link org.mdmi.Keyword#getReference <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Reference</em>' attribute.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.mdmi.SemanticElement#getKeywords <em>Keywords</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(SemanticElement)
	 * @see org.mdmi.MDMIPackage#getKeyword_Owner()
	 * @see org.mdmi.SemanticElement#getKeywords
	 * @model opposite="keywords" required="true" transient="false" ordered="false"
	 * @generated
	 */
	SemanticElement getOwner();

	/**
	 * Sets the value of the '{@link org.mdmi.Keyword#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(SemanticElement value);

} // Keyword
