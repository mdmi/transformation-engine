/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.postprocessors;

import org.mdmi.MessageModel;
import org.mdmi.core.MdmiMessage;

/**
 * An interface implemented by a provider that wishes to process the source or target messages after
 * the runtime is done with them. Typically in involves parsing the XML message and adding or removing elements
 * or attributes.
 *
 * @author goancea
 */
public interface IPostProcessor {
	/**
	 * Get the unique name of this processor.
	 *
	 * @return The unique name of this processor.
	 */
	public String getName();

	public boolean canProcess(org.mdmi.MessageModel messageModel);

	public void processMessage(MessageModel messageModel, MdmiMessage message);
} // IPostProcessor
