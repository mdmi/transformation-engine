/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import org.mdmi.MessageModel;

/**
 * Implemented by classes that know how to parse and serialize MDMI messages.
 */
public interface ISyntacticParser {
	/**
	 * Parse an MDMI message into a token tree (YNode tree).
	 *
	 * @param mdl
	 *            The MessageModel for the specified message.
	 * @param msg
	 *            The actual message (bytes).
	 * @return The YNode that represents the root of the tree.
	 */
	public ISyntaxNode parse(MessageModel mdl, MdmiMessage msg);

	/**
	 * Serialize (write) an MDMI message from the given syntax tree (the YNode is the root).
	 *
	 * @param mdl
	 *            The MessageModel for the specified message.
	 * @param msg
	 *            The actual message where the bytes will be written.
	 * @param root
	 *            The syntax tree.
	 * @param transformComment
	 *            Comment to inject into serialization if target syntax supports it
	 */
	public void serialize(MessageModel mdl, MdmiMessage msg, ISyntaxNode root, String transformComment);
} // ISyntaxParser
