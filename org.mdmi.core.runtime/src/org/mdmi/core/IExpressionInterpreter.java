/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import java.util.List;
import java.util.Properties;

import org.mdmi.SemanticElement;
import org.mdmi.core.engine.XElementValue;
import org.mdmi.core.engine.XValue;

/**
 * @TODO - single expressions are to expensive - replace with functions
 *
 *       An interface implemented by the expression processors.
 * @author goancea
 * @deprecated
 */

@Deprecated
public interface IExpressionInterpreter {
	/**
	 * Perform initialization. This was done by the constructor but we need to make
	 * it separate since we're externalizing the actual adapter.
	 */
	public void initialize(ElementValueSet eset, XElementValue context, String name, XValue value);

	/**
	 * Evaluate the given constraint in the given context.
	 *
	 * @param context
	 *            The context, which is an element value.
	 * @param rule
	 *            The rule to evaluate (as a string).
	 * @return True if the constraint is valid (evaluates to true).
	 */

	/**
	 * Evaluate an action language rule in the given context.
	 *
	 * @param context
	 *            The context, which is an element value.
	 * @param rule
	 *            The rule to evaluate (as a string).
	 */
	public void evalAction(IElementValue context, String rule, Properties properties);

	/**
	 * Evaluate an action language rule in the given context BUT do not execute.
	 *
	 * @param context
	 *            The context, which is an element value.
	 * @param rule
	 *            The rule to evaluate (as a string).
	 * @return errors The list of compilation errors.
	 */
	public List<String> compileAction(SemanticElement se, String rule);

	/**
	 * Evaluate an constraint language rule in the given context BUT do not execute.
	 *
	 * @param context
	 *            The context, which is an element value.
	 * @param rule
	 *            The rule to evaluate (as a string).
	 * @return errors The list of compilation errors.
	 */
} // IExpressionInterpreter
