/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.javascript;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.mdmi.Bag;
import org.mdmi.ConversionRule;
import org.mdmi.LeafSyntaxTranslator;
import org.mdmi.MDMIPackage;
import org.mdmi.Node;
import org.mdmi.SemanticElement;
import org.mdmi.core.engine.XDataStruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author seanmuir
 *
 */
public class Utils {

	private static Logger logger = LoggerFactory.getLogger(Utils.class);

	/**
	 * RuntimeDateFormat pairs the format for parsing and the expected significant digits in the date for the target format
	 * We are assuming all two digit dates are in this century
	 *
	 * @author seanmuir
	 *
	 */
	public enum DateSegments {
		YEAR(1), YEARMONTH(2), YEARMONTHDAY(3), YEARMONTHDAYHOUR(4), YEARMONTHDAYHOURMINUTE(
				5), YEARMONTHDAYHOURMINUTESECOND(6), YEARMONTHDAYHOURMINUTESUBSECOND(7), YEARMONTHDAYHOURTZ(
						8), YEARMONTHDAYHOURMINUTETZ(
								9), YEARMONTHDAYHOURMINUTESECONDTZ(10), YEARMONTHDAYHOURMINUTESUBSECONDTZ(11);

		private final int value;

		DateSegments(final int newValue) {
			value = newValue;
		}

		public int getValue() {
			return value;
		}
	}

	public static class RuntimeDateFormat {

		public DateTimeFormatter input;

		public DateTimeFormatter output;

		public DateSegments segment;

		public String pattern;

		public boolean preferred;

		public RuntimeDateFormat(String pattern, DateSegments significant, boolean preferred) {
			super();

			this.input = DateTimeFormatter.ofPattern(pattern.replace("yyyy", "uuuu")).withLocale(Locale.US).withZone(
				ZoneId.systemDefault());
			this.output = DateTimeFormatter.ofPattern(pattern.replace("yyyy", "uuuu")).withLocale(Locale.US).withZone(
				ZoneId.systemDefault());
			this.segment = significant;
			this.pattern = pattern;
			this.preferred = preferred;
		}

		public RuntimeDateFormat(String inpattern, String outpattern, DateSegments significant, boolean preferred) {
			super();

			this.input = DateTimeFormatter.ofPattern(inpattern.replace("yyyy", "uuuu")).withLocale(Locale.US).withZone(
				ZoneId.systemDefault());
			this.output = DateTimeFormatter.ofPattern(outpattern.replace("yyyy", "uuuu")).withLocale(
				Locale.US).withZone(ZoneId.systemDefault());
			this.segment = significant;
			this.pattern = inpattern;
			this.preferred = preferred;
		}
	}

	private static final String dash = "MM-dd-yyyy";

	private static final RuntimeDateFormat dashes[] = {
			new RuntimeDateFormat("M-d-yyyy", "MM-dd-yyyy", DateSegments.YEARMONTHDAY, true),
			new RuntimeDateFormat("M-d-yy", DateSegments.YEARMONTHDAY, false),
			new RuntimeDateFormat("M-yy", DateSegments.YEARMONTH, false),
			new RuntimeDateFormat("yy", DateSegments.YEAR, false),
			new RuntimeDateFormat("M-yyyy", DateSegments.YEARMONTH, true),
			new RuntimeDateFormat("yyyy", DateSegments.YEAR, true) };

	private static final String dash2 = "yyyy-MM-dd";

	private static final RuntimeDateFormat dashes2[] = {
			new RuntimeDateFormat("yyyy-M-d", "yyyy-MM-dd", DateSegments.YEARMONTHDAY, true),
			new RuntimeDateFormat("yyyy-MM", DateSegments.YEARMONTH, true),
			new RuntimeDateFormat("yyyy", DateSegments.YEAR, true) };

	private static final String dash3 = "yyyy-MM-dd HH:mm:ss";

	private static final RuntimeDateFormat dashes3[] = {
			new RuntimeDateFormat("yyyy-M-d HH:mm:ss", DateSegments.YEARMONTHDAYHOURMINUTESECOND, true),
			new RuntimeDateFormat("yyyy-M-d", DateSegments.YEARMONTHDAY, true),
			new RuntimeDateFormat("yyyy-MM", DateSegments.YEARMONTH, true),
			new RuntimeDateFormat("yyyy", DateSegments.YEAR, true) };

	private static final String slash = "MM/dd/yyyy";

	private static final RuntimeDateFormat slashes[] = {
			new RuntimeDateFormat("M/d/yy", DateSegments.YEARMONTHDAY, false),
			new RuntimeDateFormat("M/d/yyyy", DateSegments.YEARMONTHDAY, true),
			new RuntimeDateFormat("M/yy", DateSegments.YEARMONTH, false),
			new RuntimeDateFormat("M/yyyy", DateSegments.YEARMONTH, true),
			new RuntimeDateFormat("yy", DateSegments.YEAR, false),
			new RuntimeDateFormat("yyyy", DateSegments.YEAR, true) };

	private static final String slash2 = "MM/dd/yyyy HH:mm:ss";

	private static final RuntimeDateFormat slashes2[] = {
			new RuntimeDateFormat("MM/dd/yyyy HH:mm:ss", DateSegments.YEARMONTHDAYHOURMINUTESECOND, true),
			new RuntimeDateFormat("M/d/yyyy", DateSegments.YEARMONTHDAY, true),
			new RuntimeDateFormat("M/d/yy", DateSegments.YEARMONTHDAY, false),
			new RuntimeDateFormat("M/yy", DateSegments.YEARMONTH, false),
			new RuntimeDateFormat("M/yyyy", DateSegments.YEARMONTH, true),
			new RuntimeDateFormat("yy", DateSegments.YEAR, false),
			new RuntimeDateFormat("yyyy", DateSegments.YEAR, true) };

	private static final String slash3 = "MM/dd/yyyy HH:mm:ss.SSSSSS";

	private static final RuntimeDateFormat slashes3[] = {
			new RuntimeDateFormat("MM/dd/yyyy HH:mm:ss.SSSSSS", DateSegments.YEARMONTHDAYHOURMINUTESUBSECOND, true),
			new RuntimeDateFormat("MM/dd/yyyy HH:mm:ss", DateSegments.YEARMONTHDAYHOURMINUTESECOND, true),
			new RuntimeDateFormat("M/d/yy", DateSegments.YEARMONTHDAY, false),
			new RuntimeDateFormat("M/d/yyyy", DateSegments.YEARMONTHDAY, true),
			new RuntimeDateFormat("M/yy", DateSegments.YEARMONTH, false),
			new RuntimeDateFormat("M/yyyy", DateSegments.YEARMONTH, true),
			new RuntimeDateFormat("yy", DateSegments.YEAR, false),
			new RuntimeDateFormat("yyyy", DateSegments.YEAR, true) };

	private static final String fmtHL7 = "yyyyMMddHHmmssZ";

	private static final RuntimeDateFormat fmtHL7s[] = {
			new RuntimeDateFormat("yyyyMMddHHmmss.SSSZ", DateSegments.YEARMONTHDAYHOURMINUTESUBSECONDTZ, true),
			new RuntimeDateFormat("yyyyMMddHHmmssZ", DateSegments.YEARMONTHDAYHOURMINUTESECONDTZ, true),
			new RuntimeDateFormat("yyyyMMddHHmmZ", DateSegments.YEARMONTHDAYHOURMINUTETZ, true),
			new RuntimeDateFormat("yyyyMMddHHZ", DateSegments.YEARMONTHDAYHOURTZ, true),
			new RuntimeDateFormat("yyyyMMddHHmmss", DateSegments.YEARMONTHDAYHOURMINUTESECOND, true),
			new RuntimeDateFormat("yyyyMMddHHmm", DateSegments.YEARMONTHDAYHOURMINUTE, true),
			new RuntimeDateFormat("yyyyMMdd", DateSegments.YEARMONTHDAY, true),
			new RuntimeDateFormat("yyyyMM", DateSegments.YEARMONTH, true),
			new RuntimeDateFormat("yyyy", DateSegments.YEAR, true) };

	private static final String fhirfmt = "yyyy-MM-dd'T'hh:mm:ss";

	private static final RuntimeDateFormat fhirfmts[] = {
			new RuntimeDateFormat("yyyy-MM-dd'T'HH:mm:ss", DateSegments.YEARMONTHDAYHOURMINUTESECOND, true),
			new RuntimeDateFormat("yyyy-MM-dd'T'HH:mm", DateSegments.YEARMONTHDAYHOURMINUTE, true),
			new RuntimeDateFormat("yyyy-MM-dd'T'HH", DateSegments.YEARMONTHDAYHOUR, true),
			new RuntimeDateFormat("yyyy-MM-dd", DateSegments.YEARMONTHDAY, true),
			new RuntimeDateFormat("yyyy-MM", DateSegments.YEARMONTH, true),
			new RuntimeDateFormat("yyyy", DateSegments.YEAR, true) };

	private static final String fhirInstancefmt = "yyyy-MM-dd'T'HH:mm:ss+zzzz";

	private static final RuntimeDateFormat fhirInstancefmts[] = {
			new RuntimeDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSS+zzzz", "yyyy-MM-dd'T'HH:mm:ss.SSS+zzzz",
				DateSegments.YEARMONTHDAYHOURMINUTESUBSECONDTZ, true),
			new RuntimeDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSSxxx", "yyyy-MM-dd'T'HH:mm:ss.SSSxxx",
				DateSegments.YEARMONTHDAYHOURMINUTESUBSECONDTZ, true),
			new RuntimeDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss+zzzz", "yyyy-MM-dd'T'HH:mm:ssxxx", DateSegments.YEARMONTHDAYHOURMINUTESECONDTZ,
				true),
			new RuntimeDateFormat(
				"yyyy-MM-dd'T'HH:mm:ssxxx", "yyyy-MM-dd'T'HH:mm:ssxxx", DateSegments.YEARMONTHDAYHOURMINUTESECONDTZ,
				true),
			new RuntimeDateFormat(
				"yyyy-MM-dd'T'HH:mm:ssZZZ", "yyyy-MM-dd'T'HH:mm:ssZZZ", DateSegments.YEARMONTHDAYHOURMINUTESECONDTZ,
				true),
			new RuntimeDateFormat("yyyy-MM-dd'T'HH:mm:ss", DateSegments.YEARMONTHDAYHOURMINUTESECOND, true),
			new RuntimeDateFormat("yyyy-MM-dd'T'HH:mmxxx", DateSegments.YEARMONTHDAYHOURMINUTETZ, true),
			new RuntimeDateFormat("yyyy-MM-dd'T'HH", DateSegments.YEARMONTHDAYHOUR, true),
			new RuntimeDateFormat("yyyy-MM-dd", DateSegments.YEARMONTHDAY, true),
			new RuntimeDateFormat("yyyy-MM", DateSegments.YEARMONTH, true),
			new RuntimeDateFormat("yyyy", DateSegments.YEAR, true) };

	private static final String iso8601timezone = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

	private static final RuntimeDateFormat iso8601timezones[] = {
			new RuntimeDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSSXXX", "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
				DateSegments.YEARMONTHDAYHOURMINUTESUBSECONDTZ, true),
			new RuntimeDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd'T'HH:mm:ss.SSS", DateSegments.YEARMONTHDAYHOURMINUTESUBSECOND,
				true),
			new RuntimeDateFormat("yyyy-MM-dd'T'HH:mm:ss", DateSegments.YEARMONTHDAYHOURMINUTESECOND, true),
			new RuntimeDateFormat("yyyy-MM-dd'T'HH:mmxxx", DateSegments.YEARMONTHDAYHOURMINUTETZ, true),
			new RuntimeDateFormat("yyyy-MM-dd'T'HH:mm", DateSegments.YEARMONTHDAYHOURMINUTE, true),
			new RuntimeDateFormat("yyyy-MM-dd'T'HH", DateSegments.YEARMONTHDAYHOUR, true),
			new RuntimeDateFormat("yyyy-MM-dd", DateSegments.YEARMONTHDAY, true),
			new RuntimeDateFormat("yyyy-MM", DateSegments.YEARMONTH, true),
			new RuntimeDateFormat("yyyy", DateSegments.YEAR, true) };

	public static HashMap<String, RuntimeDateFormat[]> FORMATS = new HashMap<>();

	/*
	 * Ignore case when matching formats
	 */
	static {
		FORMATS.put("yyyyMMdd".toUpperCase(), fhirfmts);
		FORMATS.put("yyyy-MM-dd".toUpperCase(), fmtHL7s);
		FORMATS.put(fmtHL7.toUpperCase(), fmtHL7s);
		FORMATS.put(fhirfmt.toUpperCase(), fhirfmts);
		FORMATS.put(slash.toUpperCase(), slashes);
		FORMATS.put(slash2.toUpperCase(), slashes2);
		FORMATS.put(slash3.toUpperCase(), slashes3);
		FORMATS.put(dash.toUpperCase(), dashes);
		FORMATS.put(dash2.toUpperCase(), dashes2);
		FORMATS.put(dash3.toUpperCase(), dashes3);
		FORMATS.put(fhirInstancefmt.toUpperCase(), fhirInstancefmts);
		FORMATS.put(iso8601timezone.toUpperCase(), iso8601timezones);
	}

	public static String FormatToDate(String to, String date) {
		return FormatDate("yyyy-MM-dd'T'hh:mm:ss+zzzz", to, date);

	}

	public static String FormatFromDate(String from, String date) {
		return FormatDate(from, "yyyy-MM-dd'T'hh:mm:ss+zzzz", date);

	}

	public static String FormatDate(String from, String to, String date) {

		String fromKey = from.toUpperCase();
		String toKey = to.toUpperCase();

		if (logger.isTraceEnabled()) {
			logger.trace("from : " + from);
			logger.trace("to : " + to);
			logger.trace("date : " + date);

		}
		if (date == null || StringUtils.isEmpty(date)) {
			return "";
		}

		DateSegments significant = null;

		if (FORMATS.containsKey(toKey) && FORMATS.containsKey(fromKey)) {
			TemporalAccessor fromDate = null;
			for (RuntimeDateFormat fromFormat : FORMATS.get(fromKey)) {
				try {
					fromDate = fromFormat.input.parse(date);
				} catch (DateTimeParseException ne) {
				}
				if (fromDate != null) {
					significant = fromFormat.segment;
					break;
				}
			}

			/*
			 * This is specific fix for known data issue for a particular transformation
			 */
			if (fromDate == null && (date.endsWith("-"))) {

				date = StringUtils.stripEnd(date, "-");
				for (RuntimeDateFormat fromFormat : FORMATS.get(fromKey)) {
					try {
						fromDate = fromFormat.input.parse(date);
					} catch (DateTimeParseException ne) {
					}
					if (fromDate != null) {
						significant = fromFormat.segment;
						break;
					}
				}
			}

			if (fromDate == null && (date.contains("--"))) {
				String[] splitresult = date.split("--");
				date = splitresult[0];
				for (RuntimeDateFormat fromFormat : FORMATS.get(fromKey)) {
					try {
						fromDate = fromFormat.input.parse(date);
					} catch (DateTimeParseException ne) {
					}
					if (fromDate != null) {
						significant = fromFormat.segment;
						break;
					}
				}
			}

			if (fromDate != null) {
				for (RuntimeDateFormat toFormat : FORMATS.get(toKey)) {
					if (toFormat.preferred && toFormat.segment.getValue() == significant.getValue()) {
						try {
							return toFormat.output.format(fromDate);
						} catch (UnsupportedTemporalTypeException unsupportedTemporalTypeException) {
							logger.error("From " + from + " To " + to + " Date " + date);
							logger.error(unsupportedTemporalTypeException.getLocalizedMessage());
							return date;
						}
					}
				}
				for (RuntimeDateFormat toFormat : FORMATS.get(toKey)) {
					if (toFormat.preferred && toFormat.pattern.equals(toKey.replace("yyyy", "uuuu"))) {
						try {
							return toFormat.output.format(fromDate);
						} catch (UnsupportedTemporalTypeException unsupportedTemporalTypeException) {
							logger.error("From " + from + " To " + to + " Date " + date);
							logger.error(unsupportedTemporalTypeException.getLocalizedMessage());
							return date;
						}
					}

				}

				for (RuntimeDateFormat toFormat : FORMATS.get(toKey)) {
					try {
						return toFormat.output.format(fromDate);
					} catch (UnsupportedTemporalTypeException unsupportedTemporalTypeException) {
						logger.error("From " + from + " To " + to + " Date " + date);
						logger.error(unsupportedTemporalTypeException.getLocalizedMessage());
						return date;
					}

				}
			}
		} else {
			if (!FORMATS.containsKey(toKey)) {
				logger.error("to date format is missing " + toKey);
				for (String key : FORMATS.keySet()) {
					logger.trace(key);
				}

			}
			if (!FORMATS.containsKey(fromKey)) {
				logger.error("from date format is missing " + fromKey);
				for (String key : FORMATS.keySet()) {
					logger.trace(key);
				}
			}
		}
		return date;
	}

	/**
	 * @TODO There are better parses in nodejs - update runtime to support node js
	 *
	 * @param sourceAddress
	 * @param object
	 */
	public static void StringToAddress(String sourceAddress, Object object) {

	}

	public static void StringToPatientName(String sourceName, Object object) {

		if (!StringUtils.isEmpty(sourceName)) {

			NameParser nameParser = new NameParser();
			nameParser.parse(sourceName.replaceAll("\\^", " ").replaceAll(",", " "));
			XDataStruct xds = (XDataStruct) object;
			if (!StringUtils.isEmpty(nameParser.getFirstName())) {
				xds.getXValue("given").addValue(nameParser.getFirstName());
			}

			if (!StringUtils.isEmpty(nameParser.getMiddleName())) {
				xds.getXValue("given").addValue(nameParser.getMiddleName());
			}

			if (!StringUtils.isEmpty(nameParser.getLastName())) {
				xds.getXValue("family").addValue(nameParser.getLastName());
			}

			for (String prefix : nameParser.getTitlesBefore()) {
				xds.getXValue("prefix").addValue(prefix);
			}

			for (String suffix : nameParser.getTitlesAfter()) {
				xds.getXValue("suffix").addValue(suffix);
			}

		}
	}

	static public Map<String, Properties> mapOfTransforms = new HashMap<>();

	public static void loadMap(String targetSystem) {
		if (!mapOfTransforms.containsKey(targetSystem)) {
			mapOfTransforms.put(targetSystem, new Properties());
		}
		try {
			mapOfTransforms.get(targetSystem).load(
				Utils.class.getClassLoader().getResourceAsStream(targetSystem + ".properties"));
		} catch (Exception e1) {
			logger.error(e1.getMessage());
		}
	}

	public static String transform(String sourceCode, String targetSystem) {
		loadMap(targetSystem);
		if (mapOfTransforms.containsKey(targetSystem)) {
			return (String) mapOfTransforms.get(targetSystem).get(sourceCode);
		} else {
			return sourceCode;
		}

	}

	public static String getSemanticProperyQualifier(ConversionRule conversionRule, String prefix) {
		if (conversionRule.getOwner() != null && !conversionRule.getOwner().getPropertyQualifier().isEmpty()) {
			for (String properyQualifier : conversionRule.getOwner().getPropertyQualifier()) {
				if (properyQualifier.startsWith(prefix)) {
					return properyQualifier.substring(prefix.length());
				}
			}

		}
		return "";
	}

	public static String getLeafNodeFormat(ConversionRule conversionRule) {
		if (MDMIPackage.eINSTANCE.getSemanticElement().isInstance(conversionRule.getOwner())) {
			SemanticElement semanticElement = conversionRule.getOwner();
			if (MDMIPackage.eINSTANCE.getLeafSyntaxTranslator().isInstance(semanticElement.getSyntaxNode())) {
				LeafSyntaxTranslator lst = (LeafSyntaxTranslator) semanticElement.getSyntaxNode();
				if (StringUtils.isEmpty(lst.getFormat())) {
					return lst.getFormat();
				}
			}

		}
		return "";
	}

	public static String getBagNodeFormat(ConversionRule conversionRule, String field) {
		if (MDMIPackage.eINSTANCE.getSemanticElement().isInstance(conversionRule.getOwner())) {
			SemanticElement semanticElement = conversionRule.getOwner();
			if (MDMIPackage.eINSTANCE.getBag().isInstance(semanticElement.getSyntaxNode())) {
				Bag bag = (Bag) semanticElement.getSyntaxNode();
				if (!StringUtils.isEmpty(field)) {
					Node node = bag.getNode(field);
					if (MDMIPackage.eINSTANCE.getLeafSyntaxTranslator().isInstance(node)) {
						LeafSyntaxTranslator lst = (LeafSyntaxTranslator) node;
						if (!StringUtils.isEmpty(lst.getFormat())) {
							return lst.getFormat();
						}
					}

				}
			}
		}
		return "";
	}

}
