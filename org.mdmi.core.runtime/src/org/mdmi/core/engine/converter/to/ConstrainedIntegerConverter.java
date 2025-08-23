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

import org.mdmi.core.MdmiException;

public class ConstrainedIntegerConverter implements IConvertToString {
	private BigInteger m_minValue = null;

	private BigInteger m_maxValue = null;

	public ConstrainedIntegerConverter(Integer min, Integer max) {
		this(
			min == null
					? null
					: BigInteger.valueOf(min),
			max == null
					? null
					: BigInteger.valueOf(max));
	}

	public ConstrainedIntegerConverter(BigInteger min, BigInteger max) {
		m_minValue = min;
		m_maxValue = max;
	}

	@Override
	public String convertToString(Object obj, String format) {
		if (!(obj instanceof Number)) {
			throw new IllegalArgumentException("Object is not a Number type.");
		}

		BigInteger value = new BigInteger(obj.toString());
		if (m_minValue != null && value.compareTo(m_minValue) < 0) {
			throw new MdmiException("'" + obj.toString() + "' is not >= to '" + m_minValue + "'");
		}
		if (m_maxValue != null && value.compareTo(m_maxValue) > 0) {
			throw new IllegalArgumentException("'" + obj.toString() + "' is not <= to '" + m_minValue + "'");
		}
		return value.toString();
	}
}
