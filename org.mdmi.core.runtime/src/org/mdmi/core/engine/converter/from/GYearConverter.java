/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.from;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GYearConverter implements IConvertFromString {
	private static final String PATTERN_STRING = "(-?[0-9]{4})((Z|[\\+-][0-9]{2}:[0-9]{2})?)";

	private static final Pattern s_pattern = Pattern.compile(PATTERN_STRING);

	private static final String s_defaultMonth = "01";

	private static final String s_defaultTimezone = "Z";

	private static final IConvertFromString s_converter = new GYearMonthConverter();

	@Override
	public Object convertFromString(String value, String format) {
		StringBuilder builder = new StringBuilder();
		Matcher match = s_pattern.matcher(value);
		if (match.matches()) {
			String timezone = match.group(2);
			if (timezone == null || timezone.length() == 0) {
				timezone = s_defaultTimezone;
			}
			builder.append(match.group(1)).append("-").append(s_defaultMonth).append(timezone);
			return s_converter.convertFromString(builder.toString(), format);
		} else {
			// Did not match pattern => not valid.
			throw new IllegalArgumentException("Unable to parse '" + value + "' as a gYear.");
		}
	}
}
