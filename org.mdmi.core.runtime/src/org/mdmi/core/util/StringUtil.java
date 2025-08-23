/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Base64;

//import org.apache.commons.codec.binary.Base64;
import org.mdmi.core.MdmiException;

/**
 * String utilities.
 *
 * @author goancea
 */
public class StringUtil {
	/**
	 * Returns true if the string passed in is null or empty or consist only of white-spaces.
	 *
	 * @param s
	 *            The string to test.
	 * @return True if the string passed in is null or empty or consist only of white-spaces.
	 */
	public static boolean isNullOrEmpty(String s) {
		return null == s || s.trim().length() <= 0;
	}

	/**
	 * Decode (base64) the parameter string passed in. Uses UTF-8 encoding.
	 *
	 * @param z
	 *            The string encoded
	 * @return The clear text
	 */
	public static String decode(String z) {
		return decode(z, null);
	}

	/**
	 * Decode (base64) the parameter string passed in, using specified encoding.
	 *
	 * @param z
	 *            The string encoded
	 * @param enc
	 *            Encoding to use, if null will use UTF-8.
	 * @return The clear text
	 */
	public static String decode(String z, String enc) {
		if (z == null) {
			throw new IllegalArgumentException("null argument in Util.decode()");
		}
		return getString(decodeBytes(z), enc);
	}

	/**
	 * Encode (base64) the string passed in. Uses UTF-8 encoding.
	 *
	 * @param s
	 *            Clear-text to be encoded
	 * @return The encoded string
	 */
	public static String encode(String s) {
		return encode(s, null);
	}

	/**
	 * Encode (base64) the string passed in, using specified encoding.
	 *
	 * @param s
	 *            Clear-text to be encoded
	 * @param enc
	 *            Encoding to use, if null will use UTF-8.
	 * @return The encoded string
	 */
	public static String encode(String s, String enc) {
		if (s == null) {
			throw new IllegalArgumentException("null argument in Util.encode()");
		}
		return encodeBytes(getBytes(s, enc));
	}

	/**
	 * Decode (base64) the parameter string passed in.
	 *
	 * @param z
	 *            The string encoded
	 * @return The clear-text bytes
	 */
	public static byte[] decodeBytes(String z) {
		if (z == null) {
			throw new IllegalArgumentException("null argument in Util.decodeBytes()");
		}
		try {

			return Base64.getDecoder().decode(z); // .decodeBase64(z);
		} catch (Exception ex) {
			throw new MdmiException(ex, "Decode fails");
		}
	}

	/**
	 * Decode (hex) the parameter string passed in.
	 *
	 * @param z
	 *            The string encoded as "A0B302..."
	 * @return The clear-text bytes
	 */
	public static byte[] decodeBytesHex(String z) {
		if (z == null || z.length() % 2 != 0) {
			throw new IllegalArgumentException("Invalid length or null argument in Util.decodeBytesHex()");
		}
		try {
			int len = z.length() / 2;
			byte[] a = new byte[len];
			for (int i = 0; i < len; i++) {
				String cc = z.substring(i * 2, i * 2 + 2);
				a[i] = (byte) (Integer.valueOf(cc, 16).intValue() & 0xFF);
			}
			return a;
		} catch (Exception ex) {
			throw new MdmiException(ex, "Decode hex fails");
		}
	}

	/**
	 * Encode (base64) the bytes passed in.
	 *
	 * @param a
	 *            Clear-text bytes to be encrypted and encoded
	 * @return The encoded string
	 */
	public static String encodeBytes(byte[] a) {
		if (a == null) {
			throw new IllegalArgumentException("null argument in Util.encodeBytes()");
		}
		try {
			return Base64.getEncoder().encodeToString(a);

			// return Base64.encodeBase64String(a);
		} catch (Exception ex) {
			throw new MdmiException(ex, "Encode fails");
		}
	}

	/**
	 * Hex encode the bytes passed in, ie 0xA0 -> "A0"
	 *
	 * @param a
	 *            Clear-text bytes to be encrypted and encoded
	 * @return The encoded string
	 */
	public static String encodeBytesHex(byte[] a) {
		if (a == null) {
			throw new IllegalArgumentException("null argument in Util.encodeBytesHex()");
		}
		try {
			StringBuffer sb = new StringBuffer(a.length * 2);
			for (int i = 0; i < a.length; i++) {
				String h = Integer.toHexString(a[i] & 0xFF);
				if (h.length() < 2) {
					sb.append('0');
				}
				sb.append(h);
			}
			return sb.toString().toUpperCase();
		} catch (Exception ex) {
			throw new MdmiException(ex, "Encode hex fails");
		}
	}

	/**
	 * Transform a string into bytes, using UTF-8 encoding.
	 *
	 * @param s
	 *            Input string.
	 * @return Output byte array.
	 */
	public static byte[] getBytes(String s) {
		return getBytes(s, null);
	}

	/**
	 * Transform a string into bytes, using the specified encoding.
	 *
	 * @param s
	 *            Input string.
	 * @param enc
	 *            Encoding to use, if null will use UTF-8.
	 * @return Output byte array.
	 */
	public static byte[] getBytes(String s, String enc) {
		if (s == null) {
			throw new IllegalArgumentException("null argument in Util.getBytes()");
		}
		if (s.length() <= 0) {
			return new byte[0];
		}
		if (enc == null) {
			enc = "UTF-8";
		}
		Charset cs = Charset.forName(enc);
		ByteBuffer bb = cs.encode(s);
		byte[] ba = new byte[bb.limit()];
		System.arraycopy(bb.array(), 0, ba, 0, bb.limit());
		return ba;
	}

	/**
	 * Transform byte array into string using UTF-8 encoding.
	 *
	 * @param a
	 *            Input byte array.
	 * @return Output string.
	 */
	public static String getString(byte[] a) {
		return getString(a, null);
	}

	/**
	 * Transform byte array into string using UTF-8 encoding.
	 *
	 * @param a
	 *            Input byte array.
	 * @param enc
	 *            Encoding to use, if null will use UTF-8.
	 * @return Output string.
	 */
	public static String getString(byte[] a, String enc) {
		if ((a == null) || (a.length <= 0)) {
			return "";
		}
		if (enc == null) {
			enc = "UTF-8";
		}
		Charset cs = Charset.forName(enc);
		return cs.decode(ByteBuffer.wrap(a)).toString();
	}

	/**
	 * Take a string delimited with either single or double quotes and remove the delimiters. Also if there are any
	 * escaped quotes in the string un-escape them. For example:
	 * <p>
	 * <code>'Arthur''s sword'</code>
	 * <p>
	 * becomes:
	 * <p>
	 * <code>Arthur's sword</code> and:
	 * <p>
	 * <code>"Arthur has a 36"" sword"</code>
	 * <p>
	 * becomes:
	 * <p>
	 * <code>Arthur has a 36" sword</code>
	 *
	 * @param s
	 *            The input string.
	 * @return The unquoted string; if the input is null or not delimited by single quotes return unchanged.
	 */
	public static String unquote(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		if (s.charAt(0) == '\'') {
			return unquoteImpl(s, '\'');
		}
		return unquoteImpl(s, '\"');
	}

	/**
	 * Take a string delimited with single quotes and remove the delimiters. Also if there are any escaped single quotes
	 * in the string un-escape them. For example:
	 * <p>
	 * <code>'Arthur''s sword'</code>
	 * <p>
	 * becomes:
	 * <p>
	 * <code>Arthur's sword</code>
	 *
	 * @param s
	 *            The input string.
	 * @return The unquoted string; if the input is null or not delimited by single quotes return unchanged.
	 */
	public static String unquoteS(String s) {
		return unquoteImpl(s, '\'');
	}

	/**
	 * Take a string and delimit it with single quotes. If there are any single quotes in the string escape them. For
	 * example:
	 * <p>
	 * <code>Arthur's sword</code>
	 * <p>
	 * becomes:
	 * <p>
	 * <code>'Arthur''s sword'</code>
	 *
	 * @param s
	 *            The input string.
	 * @return The sinle quotes delimited string; if the input is null returns null.
	 */
	public static String quoteS(String s) {
		return quoteImpl(s, '\'');
	}

	/**
	 * Take a string delimited with double quotes and remove the delimiters. Also if there are any escaped double quotes
	 * in the string un-escape them. For example:
	 * <p>
	 * <code>"Arthur has a 36"" sword"</code>
	 * <p>
	 * becomes:
	 * <p>
	 * <code>Arthur has a 36" sword</code>
	 *
	 * @param s
	 *            The input string.
	 * @return The unquoted string; if the input is null or not delimited by double quotes return unchanged.
	 */
	public static String unquoteD(String s) {
		return unquoteImpl(s, '\"');
	}

	/**
	 * Take a string and delimit it with double quotes. If there are any double quotes in the string escape them. For
	 * example:
	 * <p>
	 * <code>Arthur has a 36" sword</code>
	 * <p>
	 * becomes:
	 * <p>
	 * <code>"Arthur has a 36"" sword"</code>
	 *
	 * @param s
	 *            The input string.
	 * @return The double quotes delimited string; if the input is null returns null.
	 */
	public static String quoteD(String s) {
		return quoteImpl(s, '\"');
	}

	private static String unquoteImpl(String s, char delim) {
		if (s == null || s.length() < 2 || !(s.charAt(0) == delim && s.charAt(s.length() - 1) == delim)) {
			return s;
		}
		if (s.length() == 2) {
			return "";
		}
		s = s.substring(1, s.length() - 1);
		StringBuffer sb = new StringBuffer(s.length());
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == delim) {
				if (i + 1 < s.length()) {
					char d = s.charAt(i + 1);
					if (d == delim) {
						i++;
					}
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}

	private static String quoteImpl(String s, char delim) {
		if (s == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer(s.length() + 3); // two delims one magic
		sb.append(delim);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == delim) {
				sb.append(delim);
			}
			sb.append(c);
		}
		sb.append(delim);
		return sb.toString();
	}

	/**
	 * Pad the given string to the specified length with the given character. The padding occurs by adding the specified
	 * character to the right to the specified length. If the string is longer that the given length, it will be trimmed
	 * to match the length. The length cannot be less than 0. If it is 0 a zero-length string is returned.
	 *
	 * @param src
	 *            The source string, may not be null.
	 * @param len
	 *            The length of the padded string to return.
	 * @param fill
	 *            The character to use to for padding.
	 * @return The paddded string.
	 */
	public static String padr(String src, int len, char fill) {
		if (src == null) {
			throw new IllegalArgumentException("The src string cannot be null!");
		}
		if (len < 0) {
			throw new IllegalArgumentException("The len argument cannot be negative!");
		}
		if (len == 0) {
			return "";
		}
		int slen = src.length();
		if (slen >= len) {
			return src.substring(0, len);
		}
		StringBuffer sb = new StringBuffer(len);
		sb.append(src);
		for (int i = 0; i < len - slen; i++) {
			sb.append(fill);
		}
		return sb.toString();
	}

	/**
	 * Pad the given string to the specified length with the given character. The padding occurs by adding the specified
	 * character to the left to the specified length. If the string is longer that the given length, it will be trimmed
	 * to match the length. The length cannot be less than 0. If it is 0 a zero-length string is returned.
	 *
	 * @param src
	 *            The source string, may not be null.
	 * @param len
	 *            The length of the padded string to return.
	 * @param fill
	 *            The character to use to for padding.
	 * @return The paddded string.
	 */
	public static String padl(String src, int len, char fill) {
		if (src == null) {
			throw new IllegalArgumentException("The src string cannot be null!");
		}
		if (len < 0) {
			throw new IllegalArgumentException("The len argument cannot be negative!");
		}
		if (len == 0) {
			return "";
		}
		int slen = src.length();
		if (slen >= len) {
			return src.substring(0, len);
		}
		StringBuffer sb = new StringBuffer(len);
		for (int i = 0; i < len - slen; i++) {
			sb.append(fill);
		}
		sb.append(src);
		return sb.toString();
	}
} // StringUtil
