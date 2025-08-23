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
import java.util.HashMap;

import org.mdmi.core.engine.converter.DateWrapper;
import org.mdmi.core.util.DateUtil;

public class ToDateTimeConverter implements IConvertToString {

	HashMap<String, SimpleDateFormat> formats = new HashMap<>();

	@Override
	public String convertToString(Object obj, String format) {
		String originalFormat = null;
		// if (!((obj instanceof Date) || obj instanceof DateWrapper)) {
		// throw new IllegalArgumentException("Object is not a java.util.Date type.");
		// }
		if (obj instanceof DateWrapper) {
			DateWrapper dateWrapper = (DateWrapper) obj;
			obj = dateWrapper.getDate();
			originalFormat = dateWrapper.getOriginalFormat();
		}
		try {
			if (obj instanceof Date) {
				return DateUtil.formatDate(
					format == null
							? null
							: DateUtil.getLongestWithoutSemiColons(format),
					(Date) obj, originalFormat);
			}
		} catch (Exception ex) {
			// throw new MdmiException(ex, "ToDateTimeConverter.convertToString({0}, {1}) failed.", obj, format);
		}
		if (obj instanceof String) {
			return (String) obj;
		}
		return obj.toString();
	}
}
