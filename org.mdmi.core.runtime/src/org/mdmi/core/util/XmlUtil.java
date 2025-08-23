/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.util;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.mdmi.core.MdmiException;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Collection of static utility methods to process the XML DOM.
 *
 * @author goancea
 */
public class XmlUtil {
	private static final SimpleDateFormat YMDHMSMZ = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

	private static final SimpleDateFormat YMDHMSZ = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

	private static final SimpleDateFormat YMDZ = new SimpleDateFormat("yyyy-MM-ddZ");

	private static final SimpleDateFormat HMSMZ = new SimpleDateFormat("HH:mm:ss.SSSZ");

	private static final SimpleDateFormat HMSZ = new SimpleDateFormat("HH:mm:ssZ");

	// patterns for the XML Schema builtin types

	// duration
	// (-)P1Y2M3DT10H30M40.50S 1 year, 2 months 3 days, 10 hours, 30 minutes and 40.50 seconds
	// 5.5.3.2 of ISO 8601, http://www.iso.ch/markete/8601.pdf
	public static final Pattern P_DURATION = Pattern.compile(
		"-?P([0-9]+Y)?([0-9]+M)?([0-9]+D)?(T([0-9]+H)?([0-9]+M)?([0-9]+(.[0-9]+)?S)?)?");

	// dateTime
	// (-)CCYY-MM-DDThh:mm:ss.sss(Z|+/-hh:mm)
	public static final Pattern P_DATETIME = Pattern.compile(
		"-?([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2})(.[0-9]*)?(Z|(\\+|-)([0-9]{2}):([0-9]{2}))?");

	// time
	// hh:mm:ss.sss(Z|+/-hh:mm)
	public static final Pattern P_TIME = Pattern.compile(
		"([0-9]{2}):([0-9]{2}):([0-9]{2})(.[0-9]*)?(Z|(\\+|-)([0-9]{2}):([0-9]{2}))?");

	// date
	// (-)CCYY-MM-DD(Z|+/-hh:mm)
	public static final Pattern P_DATE = Pattern.compile(
		"-?([0-9]{4})-([0-9]{2})-([0-9]{2})(Z|(\\+|-)([0-9]{2}):([0-9]{2}))?");

	// gYearMonth
	// (-)CCYY-MM(Z|+/-hh:mm)
	public static final Pattern P_GYEARMONTH = Pattern.compile(
		"-?([0-9]{4})-([0-9]{2})(Z|(\\+|-)([0-9]{2}):([0-9]{2}))?");

	// gYear
	// (-)CCYY(Z|+/-hh:mm)
	public static final Pattern P_GYEAR = Pattern.compile("-?([0-9]{4})(Z|(\\+|-)([0-9]{2}):([0-9]{2}))?");

	// gMonthDay
	// --MM-DD(Z|+/-hh:mm)
	public static final Pattern P_GMONTHDAY = Pattern.compile(
		"--([0-9]{2})-([0-9]{2})(Z|(\\+|-)([0-9]{2}):([0-9]{2}))?");

	// gDay
	// ---DD(Z|+/-hh:mm)
	public static final Pattern P_GDAY = Pattern.compile("---([0-9]{2})(Z|(\\+|-)([0-9]{2}):([0-9]{2}))?");

	// G__M_
	// --MM--(Z|+/-hh:mm)
	public static final Pattern P_GMONTH = Pattern.compile("--([0-9]{2})--(Z|(\\+|-)([0-9]{2}):([0-9]{2}))?");

	/**
	 * Transform the XML Schema format for the timezone to Java format.
	 * <p>
	 * <code>0123456789012345678901234567890</code>
	 * <p>
	 * <code>yyyy-MM-ddTHH:mm:ss.SSS-05:00</code> to
	 * <p>
	 * <code>yyyy-MM-ddTHH:mm:ss.SSS-0500</code>
	 * <p>
	 * and
	 * <p>
	 * <code>yyyy-MM-ddTHH:mm:ss.SSSZ</code> to
	 * <p>
	 * <code>yyyy-MM-ddTHH:mm:ss.SSS-0000</code>
	 * <p>
	 *
	 * @param dateString
	 *            The date string to convert, must be one of the above.
	 * @return The date parsed.
	 * @throws ParseException
	 *             If the format does not match.
	 */
	public static Date parseDateYMDHMSMZ(String dateString) throws ParseException {
		if (dateString == null || dateString.length() < 23) {
			throw new IllegalArgumentException("Invalid date string " + dateString);
		}
		if (dateString.length() == 23) {
			dateString += "-0000";
		} else if (dateString.length() == 24 && dateString.endsWith("Z")) {
			dateString = dateString.substring(0, 23) + "-0000";
		} else if (dateString.length() == 25) {
			dateString = dateString.substring(0, 19) + ".000" + dateString.substring(19, 22) + dateString.substring(23);
		} else if (dateString.length() == 29) {
			String tz = dateString.substring(24);
			dateString = dateString.substring(0, 24) + tz.substring(0, 2) + tz.substring(3);
		}
		synchronized (YMDHMSMZ) {
			return YMDHMSMZ.parse(dateString);
		}
	}

	/**
	 * Transform the XML Schema format for the timezone to Java format.
	 * <p>
	 * <code>0123456789012345678901234567890</code>
	 * <p>
	 * <code>yyyy-MM-ddTHH:mm:ss-05:00</code> to
	 * <p>
	 * <code>yyyy-MM-ddTHH:mm:ss-0500</code>
	 * <p>
	 * and
	 * <p>
	 * <code>yyyy-MM-ddTHH:mm:ssZ</code> to
	 * <p>
	 * <code>yyyy-MM-ddTHH:mm:ss-0000</code>
	 * <p>
	 *
	 * @param dateString
	 *            The date string to convert, must be one of the above.
	 * @return The date parsed.
	 * @throws ParseException
	 *             If the format does not match.
	 */
	public static Date parseDateYMDHMSZ(String dateString) throws ParseException {
		if (dateString == null || dateString.length() < 19) {
			throw new IllegalArgumentException("Invalid date string " + dateString);
		}
		if (dateString.length() == 19) {
			dateString += "-0000";
		} else if (dateString.length() == 20 && dateString.endsWith("Z")) {
			dateString = dateString.substring(0, 19) + "-0000";
		} else if (dateString.length() == 25) {
			String tz = dateString.substring(20);
			dateString = dateString.substring(0, 20) + tz.substring(0, 2) + tz.substring(3);
		}
		synchronized (YMDHMSZ) {
			return YMDHMSZ.parse(dateString);
		}
	}

	/**
	 * Transform the XML Schema format for the timezone to Java format.
	 * <p>
	 * <code>0123456789012345678901234567890</code>
	 * <p>
	 * <code>yyyy-MM-dd-05:00</code> to
	 * <p>
	 * <code>yyyy-MM-dd-0500</code>
	 * <p>
	 * and
	 * <p>
	 * <code>yyyy-MM-ddZ</code> to
	 * <p>
	 * <code>yyyy-MM-dd-0000</code>
	 * <p>
	 *
	 * @param dateString
	 *            The date string to convert, must be one of the above.
	 * @return The date parsed.
	 * @throws ParseException
	 *             If the format does not match.
	 */
	public static Date parseDateYMDZ(String dateString) throws ParseException {
		if (dateString == null || dateString.length() < 10) {
			throw new IllegalArgumentException("Invalid date string " + dateString);
		}
		if (dateString.length() == 10) {
			dateString += "-0000";
		} else if (dateString.length() == 11 && dateString.endsWith("Z")) {
			dateString = dateString.substring(0, 10) + "-0000";
		} else if (dateString.length() == 16) {
			String tz = dateString.substring(11);
			dateString = dateString.substring(0, 11) + tz.substring(0, 2) + tz.substring(3);
		}
		synchronized (YMDZ) {
			return YMDZ.parse(dateString);
		}
	}

	/**
	 * Transform the XML Schema format for the timezone to Java format.
	 * <p>
	 * <code>0123456789012345678901234567890</code>
	 * <p>
	 * <code>HH:mm:ss.SSS-05:00</code> to
	 * <p>
	 * <code>HH:mm:ss.SSS-0500</code>
	 * <p>
	 * and
	 * <p>
	 * <code>HH:mm:ss.SSSZ</code> to
	 * <p>
	 * <code>HH:mm:ss.SSS-0000</code>
	 * <p>
	 *
	 * @param dateString
	 *            The date string to convert, must be one of the above.
	 * @return The date parsed.
	 * @throws ParseException
	 *             If the format does not match.
	 */
	public static Date parseDateHMSMZ(String dateString) throws ParseException {
		if (dateString == null || dateString.length() < 12) {
			throw new IllegalArgumentException("Invalid date string " + dateString);
		}
		if (dateString.length() == 12) {
			dateString += "-0000";
		} else if (dateString.length() == 13 && dateString.endsWith("Z")) {
			dateString = dateString.substring(0, 12) + "-0000";
		} else if (dateString.length() == 18) {
			String tz = dateString.substring(13);
			dateString = dateString.substring(0, 13) + tz.substring(0, 2) + tz.substring(3);
		}
		synchronized (HMSMZ) {
			return HMSMZ.parse(dateString);
		}
	}

	/**
	 * Transform the XML Schema format for the timezone to Java format.
	 * <p>
	 * <code>0123456789012345678901234567890</code>
	 * <p>
	 * <code>HH:mm:ss-05:00</code> to
	 * <p>
	 * <code>HH:mm:ss-0500</code>
	 * <p>
	 * and
	 * <p>
	 * <code>HH:mm:ssZ</code> to
	 * <p>
	 * <code>HH:mm:ss-0000</code>
	 * <p>
	 *
	 * @param dateString
	 *            The date string to convert, must be one of the above.
	 * @return The date parsed.
	 * @throws ParseException
	 *             If the format does not match.
	 */
	public static Date parseDateHMSZ(String dateString) throws ParseException {
		if (dateString == null || dateString.length() < 8) {
			throw new IllegalArgumentException("Invalid date string " + dateString);
		}
		if (dateString.length() == 8) {
			dateString += "-0000";
		} else if (dateString.length() == 9 && dateString.endsWith("Z")) {
			dateString = dateString.substring(0, 12) + "-0000";
		} else if (dateString.length() == 14) {
			String tz = dateString.substring(9);
			dateString = dateString.substring(0, 9) + tz.substring(0, 2) + tz.substring(3);
		}
		synchronized (HMSZ) {
			return HMSZ.parse(dateString);
		}
	}

	/**
	 * Transform the Java to XML Schema format for the timezone.
	 * <p>
	 * <code>0123456789012345678901234567890</code>
	 * <p>
	 * <code>yyyy-MM-ddTHH:mm:ss.SSS-0500</code> to
	 * <p>
	 * <code>yyyy-MM-ddTHH:mm:ss.SSS-05:00</code>
	 * <p>
	 *
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static String formatDateYMDHMSMZ(Date date) {
		synchronized (YMDHMSMZ) {
			String dateString = YMDHMSMZ.format(date);
			return dateString.substring(0, 26) + ":" + dateString.substring(26);
		}
	}

	/**
	 * Transform the Java to XML Schema format for the timezone.
	 * <p>
	 * <code>0123456789012345678901234567890</code>
	 * <p>
	 * <code>yyyy-MM-ddTHH:mm:ss-0500</code> to
	 * <p>
	 * <code>yyyy-MM-ddTHH:mm:ss-05:00</code>
	 * <p>
	 *
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static String formatDateYMDHMSZ(Date date) {
		synchronized (YMDHMSZ) {
			String dateString = YMDHMSZ.format(date);
			return dateString.substring(0, 26) + ":" + dateString.substring(26);
		}
	}

	/**
	 * Transform the Java to XML Schema format for the timezone.
	 * <p>
	 * <code>0123456789012345678901234567890</code>
	 * <p>
	 * <code>yyyy-MM-dd-0500</code> to
	 * <p>
	 * <code>yyyy-MM-dd-05:00</code>
	 * <p>
	 *
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static String formatDateYMDZ(Date date) {
		synchronized (YMDZ) {
			String dateString = YMDZ.format(date);
			return dateString.substring(0, 13) + ":" + dateString.substring(13);
		}
	}

	/**
	 * Transform the Java to XML Schema format for the timezone.
	 * <p>
	 * <code>0123456789012345678901234567890</code>
	 * <p>
	 * <code>HH:mm:ss.SSS-0500</code> to
	 * <p>
	 * <code>HH:mm:ss.SSS-05:00</code>
	 * <p>
	 *
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static String formatDateHMSMZ(Date date) {
		synchronized (HMSMZ) {
			String dateString = HMSMZ.format(date);
			return dateString.substring(0, 15) + ":" + dateString.substring(15);
		}
	}

	/**
	 * Transform the Java to XML Schema format for the timezone.
	 * <p>
	 * <code>0123456789012345678901234567890</code>
	 * <p>
	 * <code>HH:mm:ss-0500</code> to
	 * <p>
	 * <code>HH:mm:ss-05:00</code>
	 * <p>
	 *
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static String formatDateHMSZ(Date date) {
		synchronized (HMSZ) {
			String dateString = HMSZ.format(date);
			return dateString.substring(0, 11) + ":" + dateString.substring(11);
		}
	}

	/**
	 * Add a new element to the specified (root) element. The new element will have the specified name.
	 *
	 * @param root
	 *            The element to add to.
	 * @param name
	 *            The name of the new element.
	 * @return The newly created and added element.
	 */
	public static Element addElement(Element root, String name) {
		if (root == null || name == null || name.length() <= 0) {
			throw new IllegalArgumentException("Null or invalid argument passed to XmlUtil.addElement()");
		}
		try {
			Document doc = root.getOwnerDocument();
			Element e = doc.createElement(name);
			root.appendChild(e);
			return e;
		} catch (Exception ex) {
			throw new MdmiException(ex, "XmlUtil.addElement({0}, {1}) fails", root.getNodeName(), name);
		}
	}

	/**
	 * Add a new simple content element to the specified (root) element. The new element will have the specified name,
	 * and the text string as content.
	 *
	 * @param root
	 *            The element to add to.
	 * @param name
	 *            The name of the new element.
	 * @param text
	 *            The text content of the new element.
	 * @return The newly created and added element.
	 */
	public static Element addElement(Element root, String name, String text) {
		if (root == null || name == null || name.length() <= 0) {
			throw new IllegalArgumentException("Null or invalid argument passed to XmlUtil.addElement()");
		}
		try {
			Document doc = root.getOwnerDocument();
			Element e = doc.createElement(name);
			root.appendChild(e);
			Text txt = doc.createTextNode(
				text == null
						? ""
						: text);
			e.appendChild(txt);
			return e;
		} catch (Exception ex) {
			throw new MdmiException(ex, "XmlUtil.addElement({0}, {1}, {2}) fails", root.getNodeName(), name, text);
		}
	}

	/**
	 * Add a new element to the specified (root) element, before the specified child. The new element will have the
	 * specified name.
	 *
	 * @param root
	 *            The element to add to.
	 * @param name
	 *            The name of the new element.
	 * @param before
	 *            The child to insert before (may be null).
	 * @return The newly created and added element.
	 */
	public static Element addElement(Element root, String name, Element before) {
		if (root == null || before == null || name == null || name.length() <= 0) {
			throw new IllegalArgumentException("Null or invalid argument passed to XmlUtil.addElement()");
		}
		try {
			Document doc = root.getOwnerDocument();
			Element e = doc.createElement(name);
			root.insertBefore(e, before);
			return e;
		} catch (Exception ex) {
			throw new MdmiException(
				ex, "XmlUtil.addElement({0}, {1}, {2}) fails", root.getNodeName(), name, before.getNodeName());
		}
	}

	/**
	 * Add a new simple content element to the specified (root) element, before the specified child. The new element will
	 * have the specified name, and the text string as content.
	 *
	 * @param root
	 *            The element to add to.
	 * @param name
	 *            The name of the new element.
	 * @param text
	 *            The text content of the new element.
	 * @param before
	 *            The child to insert before (may be null).
	 * @return The newly created and added element.
	 */
	public static Element addElement(Element root, String name, String text, Element before) {
		if (root == null || name == null || name.length() <= 0) {
			throw new IllegalArgumentException("Null or invalid argument passed to XmlUtil.addElement()");
		}
		try {
			Document doc = root.getOwnerDocument();
			Element e = doc.createElement(name);
			root.insertBefore(e, before);
			Text txt = doc.createTextNode(text);
			e.appendChild(txt);
			return e;
		} catch (Exception ex) {
			throw new MdmiException(
				ex, "XmlUtil.addElement({0}, {1}, {2}, {3}) fails", root.getNodeName(), name, text,
				before.getNodeName());
		}
	}

	/**
	 * Get the first child element of the specified (root) element that has the specified name. If no element by the
	 * specified name is found, null is returned. Note that more than one element with the same name may be a child of
	 * root. This method simply returns the first one.
	 *
	 * @param root
	 *            The element to search.
	 * @param name
	 *            The local name of the element to look for.
	 * @return The element if found, null otherwise.
	 */
	public static Element getElement(Element root, String name) {
		if (root == null || name == null || name.length() <= 0) {
			throw new IllegalArgumentException("Null or invalid argument passed to XmlUtil.getElement()");
		}
		NodeList lst = root.getChildNodes();
		int size = lst.getLength();
		name = localName(name);
		for (int i = 0; i < size; i++) {
			Node node = lst.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = localName(node);
				if (name.equals(nodeName)) {
					return (Element) node;
				}
			}
		}
		return null;
	}

	/**
	 * Get the path to a given element. The path is a simplified version of XPath. It begins with the first element UNDER
	 * the document element.
	 *
	 * @param elem
	 *            Element of interest
	 * @return XPath-like path to the element
	 */
	public static String getElementPath(Element elem) {
		if (elem == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		Node parent = null;
		for (Node node = elem; node != null; node = parent) {
			parent = node.getParentNode();
			if ((node instanceof Element) && (parent instanceof Element)) {
				if (sb.length() > 0) {
					sb.insert(0, '/');
				}
				sb.insert(0, node.getNodeName());
			}
		}
		return sb.toString();
	}

	/**
	 * Get all child elements of the specified (root) element. If the root is null, an illegal argument exception is
	 * thrown. If the root has no children, an empty array is returned.
	 *
	 * @param root
	 *            The element to search.
	 * @return An array of all child elements of the root.
	 */
	public static ArrayList<Element> getElements(Element root) {
		if (root == null) {
			throw new IllegalArgumentException("Null or invalid root element!");
		}
		NodeList lst = root.getChildNodes();
		final int n = lst.getLength();
		ArrayList<Element> a = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			Node node = lst.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				a.add((Element) node);
			}
		}
		return a;
	}

	/**
	 * Get all child elements of the specified (root) element, that are named by the specified name. If the root is null,
	 * an illegal argument exception is thrown. If the root has no children by the specified name, an empty array is
	 * returned.
	 *
	 * @param root
	 *            The element to search.
	 * @param name
	 *            The name of the child elements to look for.
	 * @return An array of the child elements named by the specified name, of the root.
	 */
	public static ArrayList<Element> getElements(Element root, String name) {
		if (root == null || name == null || name.length() <= 0) {
			throw new IllegalArgumentException("Null or invalid root element or name!");
		}
		NodeList lst = root.getChildNodes();
		int size = lst.getLength();
		ArrayList<Element> a = new ArrayList<>(size / 2);
		name = localName(name);
		for (int i = 0; i < size; i++) {
			Node node = lst.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = localName(node);
				if (name.equals(nodeName)) {
					a.add((Element) node);
				}
			}
		}
		return a;
	}

	/**
	 * Get the first child element of the specified element, null if it has no child elements.
	 *
	 * @param root
	 *            The element to search.
	 * @return The first child element, null if it has none.
	 */
	public static Element getFirstChild(Element root) {
		if (root == null) {
			return null;
		}
		NodeList lst = root.getChildNodes();
		final int n = lst.getLength();
		for (int i = 0; i < n; i++) {
			Node node = lst.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				return (Element) node;
			}
		}
		return null;
	}

	/**
	 * Get the next sibling element of the specified element, null if it has no other siblings.
	 *
	 * @param element
	 *            The element to search siblings for.
	 * @return The next sibling element, null if it has none.
	 */
	public static Element getNextSibling(Element element) {
		if (element == null) {
			return null;
		}
		Node node = element.getNextSibling();
		while (node != null) {
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				return (Element) node;
			}
			node = node.getNextSibling();
		}
		return null;
	}

	/**
	 * Get the previous sibling element of the specified element, null if it has no previous other siblings.
	 *
	 * @param element
	 *            The element to search siblings for.
	 * @return The previous sibling element, null if it has none.
	 */
	public static Element getPrevSibling(Element element) {
		if (element == null) {
			return null;
		}
		Node node = element.getPreviousSibling();
		while (node != null) {
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				return (Element) node;
			}
			node = node.getPreviousSibling();
		}
		return null;
	}

	/**
	 * Get the trimmed text of a text (simple content) element.
	 *
	 * @param e
	 *            The element.
	 * @return The text of the specified element, null if it has no text nodes.
	 */
	public static String getText(Element e) {
		if (e == null) {
			return null;
		}
		NodeList lst = e.getChildNodes();
		int size = lst.getLength();
		for (int i = 0; i < size; i++) {
			Node n = lst.item(i);
			if (n.getNodeType() == Node.TEXT_NODE) {
				Text t = (Text) n;
				String s = t.getData();
				return s == null
						? null
						: s.trim();
			}
		}
		return null;
	}

	/**
	 * Get the text of a text (simple content) element. Will return an empty string if not found or empty.
	 *
	 * @param e
	 *            The element.
	 * @return The text of the specified element, null if it has no text nodes.
	 */
	public static String getTextString(Element e) {
		String s = getText(e);
		return s == null
				? ""
				: s;
	}

	/**
	 * Set the text of the specified element to the given string.
	 *
	 * @param e
	 *            The element.
	 * @param text
	 *            The text string.
	 */
	public static void setText(Element e, String text) {
		NodeList lst = e.getChildNodes();
		int size = lst.getLength();
		for (int i = 0; i < size; i++) {
			Node n = lst.item(i);
			if (n.getNodeType() == Node.TEXT_NODE) {
				Text t = (Text) n;
				t.setData(text.trim());
				return;
			}
		}
		Document doc = e.getOwnerDocument();
		// bit of a hack - we preserve the cdata on the way in so we can serialize correctly
		// This only works on xml to xml
		// TODO need to have a "preserve format" or some such on the mdmi structure
		if (text.startsWith("<![CDATA[") && text.endsWith("]]>")) {
			CDATASection cdata = doc.createCDATASection(
				text != null
						? text.substring(9, text.lastIndexOf("]]>"))
						: null);
			e.appendChild(cdata);
		} else {

			// Add the result of the style sheet to the document as raw html
			DocumentBuilder documentBuilder;
			try {

				DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
				// df.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
				// df.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
				documentBuilder = df.newDocumentBuilder();

				ErrorHandler mine = new ErrorHandler() {

					@Override
					public void error(SAXParseException arg0) throws SAXException {
						// TODO Auto-generated method stub

					}

					@Override
					public void fatalError(SAXParseException arg0) throws SAXException {
						// TODO Auto-generated method stub

					}

					@Override
					public void warning(SAXParseException arg0) throws SAXException {
						// TODO Auto-generated method stub

					}
				};
				documentBuilder.setErrorHandler(mine);
				Document narrativeDocument = documentBuilder.parse(new InputSource(new StringReader(text)));
				Element narrativeContent = narrativeDocument.getDocumentElement();
				narrativeContent = (Element) doc.importNode(narrativeContent, true);
				e.appendChild(narrativeContent);
			} catch (Exception e1) {
				Text txt = doc.createTextNode(
					text != null
							? text.trim()
							: null);
				e.appendChild(txt);
			}

			// Text txt = doc.createTextNode(text != null
			// ? text.trim()
			// : null);
			// e.appendChild(txt);
		}

	}

	/**
	 * Get the value of the specified attribute as a boolean. If the element has no attribute by the specified name,
	 * false is returned.
	 *
	 * @param root
	 *            The element.
	 * @param attrName
	 *            The attribute name.
	 * @return True if the element has the attribute and its value is "true".
	 */
	public static boolean getAttrBoolean(Element root, String attrName) {
		if (root.hasAttribute(attrName)) {
			return "true".equals(root.getAttribute(attrName).toLowerCase());
		}
		return false;
	}

	/**
	 * Get the value of the specified attribute as an integer. If the element has no attribute by the specified name, 0
	 * is returned.
	 *
	 * @param root
	 *            The element.
	 * @param attrName
	 *            The attribute name.
	 * @return The value of the attribute, if it exists, 0 otherwise.
	 */
	public static int getAttrInt(Element root, String attrName) {
		if (root.hasAttribute(attrName)) {
			return Integer.valueOf(root.getAttribute(attrName)).intValue();
		}
		return 0;
	}

	/**
	 * Get the local name of a node (that may have a prefix). For example <code>localName( "xsd:string" )</code> will
	 * return <code>"string"</code>
	 *
	 * @param name
	 *            A node name (normally a DOM Element).
	 * @return The local part of the name.
	 */
	public static String localName(String name) {
		if (name == null || name.length() <= 0) {
			return name;
		}
		int p = name.indexOf(':');
		if (p < 0 || p + 1 >= name.length()) {
			return name;
		}
		return name.substring(p + 1);
	}

	/**
	 * Get the local name of a node (that may have a prefix).
	 *
	 * @param name
	 *            The node (normally a DOM Element).
	 * @return The local part of the name.
	 */
	public static String localName(Node node) {
		if (node == null) {
			return null;
		}
		String name = node.getLocalName();
		if (name == null || name.length() <= 0) {
			return localName(node.getNodeName());
		}
		return name;
	}

	/**
	 * Return true if an element/attribute name is a valid NCName (Non Colon Name).
	 *
	 * @param name
	 *            Non-qualified (no colon) name for an element/attribute.
	 * @return True if an element/attribute name is a valid NCName.
	 */
	public static boolean isValidNCName(String name) {
		if (name == null || name.length() <= 0 || name.equalsIgnoreCase("XML")) {
			return false;
		}
		char c = name.charAt(0);
		if (!Character.isLetter(c) && c != '_') {
			return false;
		}
		for (int i = 1; i < name.length(); i++) {
			c = name.charAt(i);
			if (!Character.isLetter(c) && !Character.isDigit(c) && c != '_' && c != '.' && c != '-') {
				return false;
			}
		}
		return true;
	}

	/**
	 * Make sure an element/attribute name is a valid NCname. Note that the name is assumed non-qualified, i.e. no
	 * namespaces (hence the Non Colon Name).
	 *
	 * @param name
	 *            Proposed non-qualified name for an element/attribute.
	 * @return Same string, with any invalid characters replaced by the underscore '_' character.
	 */
	public static String makeValidNCName(String name) {
		if (name == null || name.length() <= 0) {
			throw new IllegalArgumentException("Invalid NCName: null or empty not allowed!");
		}
		if (name.equalsIgnoreCase("XML")) {
			throw new IllegalArgumentException("Invalid NCName: 'XML' name is reserved!");
		}
		StringBuffer s = new StringBuffer(name);
		char c = name.charAt(0);
		if (!Character.isLetter(c) && c != '_') {
			s.setCharAt(0, '_');
		}
		for (int i = 1; i < name.length(); i++) {
			c = name.charAt(i);
			if (!Character.isLetter(c) && !Character.isDigit(c) && c != '_' && c != '.' && c != '-') {
				s.setCharAt(i, '_');
			}
		}
		return s.toString();
	}

	/**
	 * Extract a portion of a document, as specified by the path, and return it as a new DOM document. The path is
	 * specified as (simplified XPath syntax):
	 * <p>
	 * <code>element1/element2/.../payload</code>
	 * <p>
	 * The path starts relative to (and not including) the root (the document element).
	 * <p>
	 * The method returns a document with the specified fragment, or null if not found. The last element in the path
	 * becomes the root of the new document.
	 *
	 * @param doc
	 *            Document to extract the fragment from.
	 * @param path
	 *            Path to the payload to extract, as described above.
	 * @return A new Document, as described above.
	 */
	public static Document cloneFragment(final Document doc, String path) {
		Document frag = null;
		try {
			XmlParser p = new XmlParser();
			synchronized (doc) {
				Element root = doc.getDocumentElement();
				Node node = XslUtil.getNode(root, path, null); // TODO
				if (node == null) {
					return null;
				}
				Element part = (Element) node;
				frag = p.newDocument();
				Node n = frag.importNode(part, true);
				frag.appendChild(n);
			}
		} catch (Exception ex) {
			throw new MdmiException(ex, "Invalid clone fragment at " + path);
		}
		return frag;
	}

	/**
	 * Extract a portion of a document, as specified by the path, and return two documents: - the original one, without
	 * the portion extracted, and - the extracted portion as a separate document. The path is specified as (simplified
	 * XPath syntax):
	 * <p>
	 * <code>element1/element2/.../payload</code>
	 * <p>
	 * The path starts relative to (and not including) the root (the document element).
	 * <p>
	 * The method returns an array of exactly two Documents (i.e. Document[2]), the first one (index 0) is the original
	 * document from which a portion was extracted, the second one (at index 1) is the extracted portion.
	 * <p>
	 * If the element is not found at the specified path, the first array item is the same as the document passed in, and
	 * the second one is null. The root of the new document is the last element specified in the path.
	 *
	 * @param doc
	 *            Document to split
	 * @param path
	 *            Path to the payload to extract, as described above.
	 * @return An array of exactly two Documents, as described above.
	 */
	public static Document[] splitDocument(Document doc, String path) {
		Document[] docs = new Document[2];
		docs[0] = doc;
		try {
			XmlParser p = new XmlParser();
			synchronized (doc) {
				Element root = doc.getDocumentElement();
				XmlNamespaceContext context = XmlNamespaceContext.getDocumentNamespaces(doc, XslUtil.DEFAULT_NS);
				Node node = XslUtil.getNode(root, path, context);
				if (node == null) {
					return docs;
				}
				Element part = (Element) node;
				Node owner = part.getParentNode();
				Document pdoc = p.newDocument();
				Node n = pdoc.importNode(part, true);
				pdoc.appendChild(n);
				owner.removeChild(part);
				docs[1] = pdoc;
			}
		} catch (Exception ex) {
			throw new MdmiException(ex, "Invalid split at " + path);
		}
		return docs;
	}

	/**
	 * Merge the contents of the two documents, at the specified path.
	 * <p>
	 * The part doc is unchanged. Returns the main document, if the operation was successfull, or null if the path points
	 * to a non-existent document. The path is specified as (simplified XPath syntax):
	 * <p>
	 * <code>element1/element2/.../payload</code>
	 * <p>
	 * The path starts relative to (and not including) the root (the document element).
	 *
	 * @param mainDoc
	 *            Header (envelope) document.
	 * @param partDoc
	 *            Payload (body) document.
	 * @param path
	 *            Path (position) where the payload document content is merged into the header.
	 * @return The mainDoc document if all is well, null otherwise.
	 */
	public static Document mergeDocuments(Document mainDoc, Document partDoc, String path) {
		try {
			synchronized (mainDoc) {
				Element root = mainDoc.getDocumentElement();
				XmlNamespaceContext context = XmlNamespaceContext.getDocumentNamespaces(mainDoc, XslUtil.DEFAULT_NS);
				Node node = XslUtil.getNode(root, path, context);
				if (node == null) {
					return null;
				}
				Element owner = (Element) node;
				Element part = partDoc.getDocumentElement();
				Node n = mainDoc.importNode(part, true);
				owner.appendChild(n);
			}
		} catch (Exception ex) {
			throw new MdmiException(ex, "Invalid merge at " + path);
		}
		return mainDoc;
	}

	/**
	 * Clone a DOM Document and return the copy.
	 *
	 * @param src
	 *            The document to clone.
	 * @return The cloned document
	 */
	public static Document cloneDocument(Document src) {
		Document doc = null;
		try {
			if (src != null && src.getDocumentElement() != null) {
				synchronized (src) {
					doc = new XmlParser().newDocument();
					Node root = doc.importNode(src.getDocumentElement(), true);
					doc.appendChild(root);
				}
			}
		} catch (Exception ex) {
			throw new MdmiException(ex, "Clone document fails!");
		}
		return doc;
	}
} // XmlUtil
