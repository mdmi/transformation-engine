/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.to;

import java.util.Date;

import org.mdmi.core.engine.converter.DateWrapper;
import org.mdmi.core.util.DateUtil;

public class ToStringConverter implements IConvertToString {
	private String originalFormat = null;

	@Override
	public String convertToString(Object obj, String format) {
		if (format != null && format.length() > 0) {
			if (obj instanceof Date) {
				return convertStringSplit(obj, format);
			}
			if (obj instanceof DateWrapper) {
				originalFormat = ((DateWrapper) obj).getOriginalFormat();
				return convertStringSplit(((DateWrapper) obj).getDate(), format);
			}
		}
		return obj.toString();
	}

	public String convertStringSplit(Object obj, String format) {
		String bestFormat = DateUtil.getLongestWithoutSemiColons(format);
		String convert = convert(obj, bestFormat);
		if (convert != null) {
			return convert;
		}
		return null;
	}

	private String convert(Object obj, String format) {
		if (obj == null) {
			return "ERROR";
		}
		try {
			return DateUtil.formatDate(format, (Date) obj, originalFormat);
		} catch (IllegalArgumentException ignored) {
		}
		return null;
	}
}
