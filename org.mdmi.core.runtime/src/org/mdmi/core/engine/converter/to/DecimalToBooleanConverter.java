/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.to;

import java.math.BigDecimal;

public class DecimalToBooleanConverter implements IConvertToString {
	@Override
	public String convertToString(Object obj, String format) {
		if (!(obj instanceof BigDecimal)) {
			throw new IllegalArgumentException("Object is not a BigDecimal type.");
		}
		BigDecimal bigDec = (BigDecimal) obj;
		return Boolean.toString(bigDec.compareTo(BigDecimal.ZERO) != 0);
	}
}
