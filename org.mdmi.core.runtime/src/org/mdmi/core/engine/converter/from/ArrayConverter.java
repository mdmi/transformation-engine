/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.from;

public class ArrayConverter implements IConvertFromString {
	private IConvertFromString m_wrapped;

	public ArrayConverter(IConvertFromString wrapped) {
		m_wrapped = wrapped;
	}

	@Override
	public Object convertFromString(String value, String format) {
		String[] arrStrings = value.split(" ");
		Object[] rv = new Object[arrStrings.length];

		for (int index = 0; index < rv.length; index++) {
			rv[index] = m_wrapped.convertFromString(arrStrings[index], format);
		}

		return rv;
	}
}
