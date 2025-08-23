/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.to;

public class BooleanToNumberConverter implements IConvertToString {
	private String m_trueVal = "1";

	public BooleanToNumberConverter() {
	}

	public BooleanToNumberConverter(String trueVal) {
		m_trueVal = trueVal;
	}

	@Override
	public String convertToString(Object obj, String format) {
		if (!(obj instanceof Boolean)) {
			throw new IllegalArgumentException("Object is not a Boolean type.");
		}
		// Make sure value is not out of range.
		return ((Boolean) obj).booleanValue()
				? m_trueVal
				: "0";
	}
}
