/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Leaf Syntax Translator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * The LeafSyntaxTranslator class is a key class in the syntax model. It is the leaf of the syntax tree, corresponding to every field or sub-field in
 * a message format.A LeafSyntaxTranslator (including its inherited attributes from the Node class) provides the information necessary to extract or
 * insert a value from a message field from/to a SemanticElement.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.mdmi.LeafSyntaxTranslator#getFormat <em>Format</em>}</li>
 * <li>{@link org.mdmi.LeafSyntaxTranslator#getFormatExpressionLanguage <em>Format Expression Language</em>}</li>
 * </ul>
 *
 * @see org.mdmi.MDMIPackage#getLeafSyntaxTranslator()
 * @model
 * @generated
 */
public interface LeafSyntaxTranslator extends Node {
	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The "format" property of type String provides the specific format of each field or subfield in the message format.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see org.mdmi.MDMIPackage#getLeafSyntaxTranslator_Format()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link org.mdmi.LeafSyntaxTranslator#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

	/**
	 * Returns the value of the '<em><b>Format Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * The "formatExpressionLanguage" property of type String is a reference to the expression language used in the format property. For example,
	 * SWIFT has a defined regular expression language for the format of fields in MT messages. The formatExpressionLanguage must be able to describe
	 * fields as well as sub-fields, in particular the proper termination character for a field or sub-field. While the MDMI standard does not require
	 * a specific formatExpressionLanguage, if no formatExpressionLanguage exists for a particular message format, the MDMI standard is recommending
	 * the use of a small subset of DFDL as a general solution.
	 * </p>
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Format Expression Language</em>' attribute.
	 * @see #setFormatExpressionLanguage(String)
	 * @see org.mdmi.MDMIPackage#getLeafSyntaxTranslator_FormatExpressionLanguage()
	 * @model ordered="false"
	 * @generated
	 */
	String getFormatExpressionLanguage();

	/**
	 * Sets the value of the '{@link org.mdmi.LeafSyntaxTranslator#getFormatExpressionLanguage <em>Format Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Format Expression Language</em>' attribute.
	 * @see #getFormatExpressionLanguage()
	 * @generated
	 */
	void setFormatExpressionLanguage(String value);

} // LeafSyntaxTranslator
