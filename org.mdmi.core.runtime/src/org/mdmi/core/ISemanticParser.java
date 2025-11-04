/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import java.util.Properties;

import org.json.simple.JSONObject;
import org.mdmi.MessageModel;

/**
 * Implemented by classes that can construct a semantic MDMI model from the syntax tree, and vice versa.
 */
public interface ISemanticParser {

	/**
	 * Construct a semantic model, from the given syntax tree and the message model. The semantic model is represented by
	 * the elements set (eset), and may be partially populated.
	 *
	 * @param mdl
	 *            The MessageModel that applies.
	 * @param root
	 *            The syntax tree input.
	 * @param eset
	 *            The element set as defined by the message model (IN-OUT parameter).
	 */
	public void buildSemanticModel(MessageModel mdl, ISyntaxNode root, ElementValueSet eset, Properties properties,
			JSONObject values);

	/**
	 * Create a new syntax tree represented from the given semantic content (element set) and
	 * based on the specified message model.
	 *
	 * @param mdl
	 *            The MessageModel that applies.
	 * @param eset
	 *            The semantic content (element set).
	 * @return The syntax tree corresponding to the existing syntactic model.
	 */
	public ISyntaxNode createNewSyntacticModel(MessageModel mdl, ElementValueSet eset, Properties properties);

	public void updateTargetSemanticModel(MessageModel mdl, ElementValueSet eset, ISyntaxNode yroot,
			Properties properties, JSONObject targetValues);

	/**
	 * Update the syntax tree represented by the syntax node given from the given semantic content (element set) and
	 * based on the specified message model.
	 *
	 * @param mdl
	 *            The MessageModel that applies.
	 * @param eset
	 *            The semantic content (element set).
	 * @param yroot
	 *            The syntax tree corresponding to the existing syntactic model.
	 */
	public void updateSyntacticModel(MessageModel mdl, ElementValueSet eset, ISyntaxNode yroot, Properties properties);
} // ISemanticParser
