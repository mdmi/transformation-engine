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
import java.nio.charset.Charset;

public class BinaryToStringConverter implements IConvertToString {
	@Override
	public String convertToString(Object obj, String format) {
		if (!(obj instanceof ByteBuffer)) {
			throw new IllegalArgumentException("Object is not a ByteBuffer type.");
		}
		Charset cs = Charset.forName("UTF-8");
		return cs.decode((ByteBuffer) obj).toString();
	}
}
