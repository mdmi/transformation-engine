/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

/**
 * An interface implemented by a provider that wishes to process the target semantic model.
 *
 * @author smuir
 */
public interface ITargetSemanticModelPostProcessor {
	/**
	 * Get the unique name of this processor.
	 *
	 * @return The unique name of this processor.
	 */
	public String getName();

	/**
	 * Execute the processing of the specified message, do what is necessary to the message and set the
	 * values back as expected by the runtime. Note that the message is always the target message in its
	 * final form.
	 *
	 *
	 * @param model
	 *            The semanticModel.
	 */
	public void processModel(ElementValueSet semanticModel);
} // IPostProcessor
