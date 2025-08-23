/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.to;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDatePatternConverter implements IConvertToString {
	private String pattern;

	public ToDatePatternConverter(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String convertToString(Object obj, String format) {
		if (!(obj instanceof Date)) {
			throw new IllegalArgumentException("Object is not a java.util.Date type.");
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String value = sdf.format((Date) obj);

		// We need to insert a colon to make it compatible with XML date formats.
		// NOTE: this is used with the XML datatypes
		return value.substring(0, value.length() - 2) + ":" + value.substring(value.length() - 2);
	}
}
