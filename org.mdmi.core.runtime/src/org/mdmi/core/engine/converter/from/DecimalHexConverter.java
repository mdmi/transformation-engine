/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.from;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DecimalHexConverter implements IConvertFromString {
	private IConvertFromString s_convertFrom = new IntegerHexConverter();

	@Override
	public Object convertFromString(String value, String format) {
		BigInteger intVal = (BigInteger) s_convertFrom.convertFromString(value, format);
		return new BigDecimal(intVal);
	}
}
