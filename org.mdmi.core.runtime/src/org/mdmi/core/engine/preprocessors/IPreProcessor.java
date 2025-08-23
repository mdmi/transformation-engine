/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.preprocessors;

import org.mdmi.MessageModel;
import org.mdmi.core.MdmiMessage;

/**
 * An interface implemented by a provider that wishes to process the source or target messages before
 * the runtime reads them. Typically in involves parsing the XML message and adding or removing elements
 * or attributes.
 *
 * @author goancea
 */
public interface IPreProcessor {
	/**
	 * Get the unique name of this processor.
	 *
	 * @return The unique name of this processor.
	 */
	public String getName();

	/**
	 * Return true if interested to process the message (can be source or target) for the specified message
	 * group and message models. The runtime will call this method for all providers, and only if it returns true
	 * it will invoke the process method, otherwise nothing will happen.
	 *
	 * @param messageGroupName
	 *            The message group name.
	 * @param messageModelName
	 *            The message model name.
	 * @return True if interested in processing messages of this type.
	 */
	public boolean canProcess(org.mdmi.MessageModel messageModel);

	/**
	 * Execute the processing of the specified message, do what is necessary to the message and set the
	 * values back as expected by the runtime.
	 *
	 * @param message
	 *            The message reference.
	 * @param model
	 *            The model reference.
	 * @param isSource
	 *            If true, this is a source message otherwise this is a target.
	 */
	public void processMessage(MessageModel messageModel, MdmiMessage message);
} // IPreProcessor
