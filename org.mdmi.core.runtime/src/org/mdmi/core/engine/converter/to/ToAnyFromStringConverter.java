/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.to;

import org.mdmi.core.engine.converter.from.IConvertFromString;

public class ToAnyFromStringConverter implements IConvertToString {
	private IConvertFromString m_from;

	private IConvertToString m_to;

	public ToAnyFromStringConverter(IConvertFromString from, IConvertToString to) {
		m_from = from;
		m_to = to;
	}

	@Override
	public String convertToString(Object obj, String format) {
		Object toConvert = m_from.convertFromString(obj.toString(), format);
		return m_to.convertToString(toConvert, format);
	}
}
