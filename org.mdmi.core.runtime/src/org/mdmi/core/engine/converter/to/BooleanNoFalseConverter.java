/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.to;

public class BooleanNoFalseConverter implements IConvertToString {
	private IConvertToString m_wrapped = null;

	public BooleanNoFalseConverter(IConvertToString wrapped) {
		m_wrapped = wrapped;
	}

	@Override
	public String convertToString(Object obj, String format) {
		if (!(obj instanceof Boolean)) {
			throw new IllegalArgumentException("Object is not a Boolean type.");
		}
		if (!((Boolean) obj).booleanValue()) {
			throw new IllegalArgumentException("Boolean value of false cannot be converted.");
		}
		return m_wrapped.convertToString(obj, format);
	}
}
