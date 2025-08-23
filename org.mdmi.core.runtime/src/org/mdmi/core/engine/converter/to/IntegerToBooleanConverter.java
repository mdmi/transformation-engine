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

public class IntegerToBooleanConverter implements IConvertToString {
	@Override
	public String convertToString(Object obj, String format) {
		if (!(obj instanceof BigInteger)) {
			throw new IllegalArgumentException("Object is not a BigInteger type.");
		}
		BigInteger bigInt = (BigInteger) obj;
		return Boolean.toString(!bigInt.equals(BigInteger.ZERO));
	}
}
