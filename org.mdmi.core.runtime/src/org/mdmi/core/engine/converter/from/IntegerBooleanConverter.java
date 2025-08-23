/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.from;

import java.math.BigInteger;

public class IntegerBooleanConverter implements IConvertFromString {
	private IConvertFromString s_convertFrom = null;

	public IntegerBooleanConverter(IConvertFromString convert) {
		s_convertFrom = convert;
	}

	@Override
	public Object convertFromString(String value, String format) {
		BigInteger intVal = new BigInteger(value);
		return s_convertFrom.convertFromString(
			intVal.equals(BigInteger.ZERO)
					? "false"
					: "true",
			format);
	}
}
