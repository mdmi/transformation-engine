/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.to;

import java.math.BigInteger;

import org.mdmi.core.util.StringUtil;

public class ToHexStringConverter implements IConvertToString {
	private IConvertToString m_wrapped;

	public ToHexStringConverter() {
		m_wrapped = new ToStringConverter();
	}

	public ToHexStringConverter(IConvertToString toString) {
		m_wrapped = toString;
	}

	@Override
	public String convertToString(Object obj, String format) {
		String toConvert = m_wrapped.convertToString(obj, format);
		return StringUtil.encodeBytesHex(new BigInteger(toConvert).toByteArray());
	}
}
