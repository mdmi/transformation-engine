/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.to;

public class ArrayToAnyConverter implements IConvertToString {
	private IConvertToString m_wrapped;

	public ArrayToAnyConverter(IConvertToString wrapped) {
		m_wrapped = wrapped;
	}

	@Override
	public String convertToString(Object obj, String format) {
		if (!(obj instanceof Object[])) {
			throw new IllegalArgumentException("Object is not an Object array type.");
		}
		StringBuilder builder = new StringBuilder();
		for (Object curObj : (Object[]) obj) {
			if (builder.length() > 0) {
				builder.append(" ");
			}
			builder.append(m_wrapped.convertToString(curObj, format));
		}
		return builder.toString();
	}
}
