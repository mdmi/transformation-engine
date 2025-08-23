/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.to;

import java.nio.ByteBuffer;

import org.mdmi.core.util.StringUtil;

public class BinaryToHexConverter implements IConvertToString {
	@Override
	public String convertToString(Object obj, String format) {
		if (!(obj instanceof ByteBuffer)) {
			throw new IllegalArgumentException("Object is not a ByteBuffer type.");
		}
		ByteBuffer buffer = (ByteBuffer) obj;
		byte[] bytes = new byte[buffer.capacity()];
		buffer.get(bytes, 0, bytes.length);
		return StringUtil.encodeBytesHex(bytes);
	}
}
