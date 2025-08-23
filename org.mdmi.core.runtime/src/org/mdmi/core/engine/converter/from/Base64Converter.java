/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.from;

import org.mdmi.core.util.StringUtil;

public class Base64Converter implements IConvertFromString {
	private IConvertFromString m_wrapped;

	public Base64Converter(IConvertFromString convert) {
		m_wrapped = convert;
	}

	@Override
	public Object convertFromString(String value, String format) {
		return m_wrapped.convertFromString(StringUtil.decode(value), format);
	}
}
