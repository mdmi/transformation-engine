/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mdmi.core.engine.converter.DateWrapper;

import com.google.common.base.CharMatcher;

public class DateUtil {
	// Date formats
	public static final String fmtISO = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

	public static final String fmtHL7 = "yyyyMMddHHmmss.SSSZ"; // "YYYYMMDDHHMMSS.UUUU[+|-ZZzz]";

	private static final Pattern bracketMatcher = Pattern.compile("\\[([^\\]]+)");

	private static HashMap<String, SimpleDateFormat> dateCache = new HashMap<>();

	/***
	 * Global DateFormat cache. Note this is not thread safe, but
	 * MDMI is not in general currently anyway.
	 */
	public static SimpleDateFormat getDateFormatCached(String format) {
		if (dateCache.containsKey(format)) {
			return dateCache.get(format);
		}
		SimpleDateFormat sdf = null;
		try {
			sdf = new SimpleDateFormat(format);
		} catch (IllegalArgumentException e) {
			return null;
		}
		dateCache.put(format, sdf);
		return sdf;
	}

	/***
	 * Format the date as a string using cached SimpleDateFormats.
	 * Follows the MDMI convention of using
	 * ISO format if format is null, empty, or "DATE". Adds a colon after character 26, because
	 * XmlUtil used to, so I preserved it. Probably should be removed if it's not needed.
	 *
	 * Now will try to preserve formatting precision if originalFormat is not null, empty,
	 * or "DATE".
	 *
	 * @param format
	 *            Output format
	 * @param value
	 *            Date object
	 * @param originalFormat
	 *            Optional, original format for precision matching
	 * @return
	 */
	public static String formatDate(String format, Date value, String originalFormat) {
		if (value == null) {
			return "";
		}
		String myFormat = format;
		if (format == null || format.equals("") || format.equals("DATE")) {
			myFormat = fmtISO;
		}
		myFormat = matchPrecision(myFormat, originalFormat);
		SimpleDateFormat sdf = getDateFormatCached(myFormat);
		String dateString = sdf.format(value);

		// I've preserved a weird colon insertion in the timezone from XmlUtil.
		if (format == null || format.equals("") || format.equals("DATE")) {
			return dateString.substring(0, 26) + ":" + dateString.substring(26);
		} else {
			return dateString;
		}
	}

	/***
	 * Simple method to pick a date format.
	 * If format is empty or null, chooses either standard ISO
	 * or HL7 ISO.
	 * Then truncates the format string to be the length of the value string
	 * sans quotes. This works because each character in the format string
	 * represents at least one character in the value string. The other way around
	 * is not possible without complex logic.
	 * The bug with truncation resulting in invalid substrings due to quoted
	 * literals has been fixed.
	 */
	public static String pickDateFormat(String format, String value) {
		if (value == null) {
			return "";
		}
		if (format == null || format.equals("")) {
			if (value.contains("-")) {
				format = fmtISO;
			} else {
				format = fmtHL7;
			}
		}
		int fmtLen = format.replace("\'", "").length();
		if (fmtLen > value.length()) {
			String truncatedFormat = format.substring(0, value.length());
			// 8/8/14 bugfix: wasn't properly dealing with quoted strings
			int addlChars = 0;
			if (truncatedFormat.contains("\'")) {
				// If quoted strings are complete, just add the right number of chars
				addlChars = CharMatcher.is('\'').countIn(truncatedFormat);
				// If incomplete, find the end of the quoted string
				if (addlChars % 2 == 1) {
					return format.substring(0, format.substring(value.length() + 1).indexOf('\''));
				}
				return format.substring(0, value.length() + addlChars);
			}
			return format.substring(0, value.length());
		} else {
			return format;
		}
	}

	/***
	 * Compatibility method to handle the old semicolon split-string issue.
	 * Finds the longest string among the semicolon separated strings and returns that.
	 *
	 * @param format
	 * @return
	 */
	public static String getLongestWithoutSemiColons(String format) {
		String[] formatStrings = format.split(";");
		String outFormat = "";
		for (String formatString : formatStrings) {
			if (formatString.length() > outFormat.length()) {
				outFormat = formatString;
			}
		}
		return outFormat;
	}

	/**
	 * Parse a Java SimpleDateFormat with optional sections, i.e. yyyy[MM][dd].
	 * Not presently used.
	 *
	 * @param format
	 * @param value
	 * @return
	 */
	public static DateWrapper parseDateWithOptional(String format, String value) {
		ArrayList<String> fmts = new ArrayList<>();
		StringBuilder fmtSB = new StringBuilder();
		int firstBracket = format.indexOf('[');
		fmtSB.append(
			format.substring(
				0, firstBracket == -1
						? format.length()
						: firstBracket));
		fmts.add(fmtSB.toString());
		Matcher matcher = bracketMatcher.matcher(format);

		int pos = -1;
		while (matcher.find(pos + 1)) {
			pos = matcher.start();
			fmtSB.append(matcher.group(1));
			fmts.add(fmtSB.toString());
		}

		Date output = null;
		String originalFormat = null;
		for (int i = fmts.size() - 1; i >= 0; i--) {
			SimpleDateFormat sdf = new SimpleDateFormat(fmts.get(i));
			try {
				output = sdf.parse(value);
				originalFormat = fmts.get(i);
				break;
			} catch (ParseException e) {
				// Ignore, just keep going
			}
		}
		return new DateWrapper(output, originalFormat, null);
	}

	/**
	 * Parse a date string with the given format (of SimpleDateFormat format).
	 * All components are optional - the longest format string that can
	 * parse the given value string is used. Separators, literals, and all format elements
	 * are supported.
	 * TODO: Preserve optional timezones in shorter string
	 * TODO: Validate that date is logical?
	 *
	 * @param format
	 * @param value
	 * @return
	 */
	public static DateWrapper parseDateImplicitOptional(String format, String value) {
		format = pickDateFormat(format, value);
		Date output = null;

		// Optimization: in the average case, the format chosen by pickDateFormat will work
		SimpleDateFormat sdf = getDateFormatCached(format);
		sdf.setLenient(false);
		// Otherwise crazy dates crop up if the string is longer than the format
		try {
			output = sdf.parse(value);
			// It worked!
			return new DateWrapper(output, format, value);
		} catch (ParseException e) {
			// Ignore, just keep going
		}

		// All the complex logic to try subparts of the dateformat, in chunks.
		int vLen = value.length();
		int outLen = 0;
		ArrayList<String> dateparts = new ArrayList<>();
		StringBuilder datePart = new StringBuilder();
		char charAt = '~';
		boolean inQuote = false, buffering = true;
		for (int i = 0; i < format.length(); i++) {
			// Optimization: stop if the value string is shorter than the current format strings (sans quotes)
			// Note that you still have to try multiple formats because some characters in the
			// format string represent multiple characters in the value string.
			if (vLen < outLen) {
				break;
			}
			char currChar = format.charAt(i);
			// If we've encountered a new character, we need to do something...
			if (currChar != charAt) {
				// If we've just finished buffering, output dateformat to the list
				if (datePart.length() > 0 && buffering) {
					dateparts.add(datePart.toString());
					buffering = false;
				}
				// Buffer
				datePart.append(currChar);
				outLen++;
				boolean nonAlpha = ("" + currChar).matches("^.*[^a-zA-Z0-9 ].*$");
				// If not alphanumeric or inside a single-quoted string, buffer but don't set buffering flag...
				if (nonAlpha || inQuote) {
					if (currChar == '\'') {
						outLen--;
						if (!inQuote) {
							inQuote = true;
						} else if (inQuote) {
							inQuote = false;
						}
					}
					currChar = '~';
					continue;
				}
				charAt = currChar;
				buffering = true;
			} else {
				// Otherwise just keep buffering...
				datePart.append(currChar);
				outLen++;
			}
		}
		if (vLen >= outLen) {
			dateparts.add(datePart.toString());

		}

		// Loop through our list of formats, from longest to shortest...
		output = null;
		String originalFormat = null;
		for (int i = dateparts.size() - 1; i >= 0; i--) {
			sdf = getDateFormatCached(dateparts.get(i));
			sdf.setLenient(false);
			// Otherwise crazy dates crop up if the string is longer than the format
			try {
				output = sdf.parse(value);
				originalFormat = dateparts.get(i);
				break;
			} catch (ParseException e) {
				// Ignore, just keep going
			}
		}

		return new DateWrapper(output, originalFormat, value);
	}

	/* Define synonymous components of date format. */
	public static CharMatcher[] dateParts = new CharMatcher[10];

	static {
		dateParts[0] = CharMatcher.anyOf("G");
		dateParts[1] = CharMatcher.anyOf("yY");
		dateParts[2] = CharMatcher.anyOf("M");
		dateParts[3] = CharMatcher.anyOf("wW");
		dateParts[4] = CharMatcher.anyOf("DdFEu");
		dateParts[5] = CharMatcher.anyOf("aHkKh");
		dateParts[6] = CharMatcher.anyOf("m");
		dateParts[7] = CharMatcher.anyOf("s");
		dateParts[8] = CharMatcher.anyOf("S");
		dateParts[9] = CharMatcher.anyOf("zZX");
	}

	/**
	 * For outputting dates, tries to match the output precision with the input precision.
	 * This has been tested with quoted and unquoted literals and supports varying expressions
	 * of the same precision.
	 * TODO: Differing expressions of precision (e.g., from day as digit to day as name)
	 * has not been tested because the engine has a bug in which it always passes the destination
	 * format string, not the source.
	 *
	 * @param outFormat
	 *            The maximal precision output format.
	 * @param originalFormat
	 *            The orginalFormat of the date, from the date wrapper.
	 * @return A truncation of outFormat to match the precision of the originalFormat
	 */
	public static String matchPrecision(String outFormat, String originalFormat) {
		// Check for nulls
		if (originalFormat == null || originalFormat.equals("") || originalFormat.equals("DATE")) {
			return outFormat;
		}

		// Use our static data and a string matcher to add all the weird precision overlaps
		originalFormat = originalFormat.replaceAll("'.*'", ""); // Remove quoted literals
		String newOF_src = outFormat.replaceAll("'.*'", "");
		StringBuilder newOF_trg = new StringBuilder();
		for (int i = 0; i < dateParts.length; i++) {
			if (dateParts[i].matchesAnyOf(originalFormat)) {
				newOF_trg.append(dateParts[i].retainFrom(newOF_src));
			}
		}

		// Use Guava's charmatcher to deal with everything but single-quoted literals
		CharMatcher matcher = CharMatcher.anyOf(newOF_trg).or(CharMatcher.javaLetter().negate());
		// bugfix 2/9/15 - remove trailing non-format chars (e.g. :)
		if (!outFormat.contains("'")) {
			return CharMatcher.javaLetter().negate().trimTrailingFrom(matcher.retainFrom(outFormat));
		} else {
			// There are single-quoted literals. Yuck.
			StringBuilder newOut = new StringBuilder();
			boolean instring = false;
			for (int i = 0; i < outFormat.length(); i++) {
				char current = outFormat.charAt(i);
				if (current == '\'') {
					if (!instring) {
						instring = true;
					} else {
						instring = false;
					}
				}
				if (instring || matcher.matches(current)) {
					newOut.append(current);
				}
			}
			return newOut.toString();
		}
	}
}
