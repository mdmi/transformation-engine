/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.mdmi.core.MdmiException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Notation;

/**
 * XML DOM Document writer - used to output an XML DOM Document to a file or stream.
 *
 * @author goancea
 */
public final class XmlWriter {
	private static final int INDENT = 3;

	private static final int LINE_LENGTH = 100;

	private String m_fileName;

	private Writer m_out;

	private String m_encoding; // default is UTF8

	private boolean m_ownStream; // if true it owns the stream (i.e. close it when done writing)

	private int m_indent = INDENT;

	private int m_lineLen = LINE_LENGTH;

	private boolean m_XML11;

	public static String defaultEncoding = "UTF-8";

	public static void setDefaultEncoding(String encoding) {
		defaultEncoding = encoding;
	}

	/**
	 * Write the contents of this document to a formatted string, and return the string.
	 *
	 * @return The string representation of the DOM document.
	 */
	public static String toString(Document doc) {
		return toString(doc, true);
	}

	/**
	 * Write the contents of this document to a formatted string, and return the string.
	 *
	 * @param doc
	 *            The document to be written
	 * @param normalize
	 *            Whether or not to normalize TEXT_NODES, etc.
	 *
	 * @return The string representation of the DOM document.
	 */
	public static String toString(Document doc, boolean normalize) {
		if (doc == null) {
			return null;
		}
		String s = null;
		try {
			StringWriter sw = new StringWriter();
			XmlWriter w = new XmlWriter(sw);
			w.write(doc, normalize);
			s = sw.toString();
		} catch (Exception ex) {
			throw new MdmiException(ex, "XML writer fails");
		}
		return s;
	}

	/**
	 * Write the contents of this node to a formatted string, and return the string.
	 *
	 * @return The string representation of the DOM node
	 */
	public static String toString(Node node) {
		if (node == null) {
			return null;
		}
		String s = null;
		try {
			StringWriter sw = new StringWriter();
			XmlWriter w = new XmlWriter(sw);
			w.write(node, w.m_indent);
			s = sw.toString();
		} catch (Exception ex) {
			throw new MdmiException(ex, "XML writer fails");
		}
		return s;
	}

	/**
	 * Construct from a file name.
	 *
	 * @param fileName
	 *            The output file name.
	 */
	public XmlWriter(String fileName) {
		this(fileName, defaultEncoding);
	}

	/**
	 * Construct from a stream.
	 *
	 * @param sout
	 *            The output stream
	 */
	public XmlWriter(OutputStream sout) {
		m_fileName = "";
		m_encoding = defaultEncoding;
		try {
			OutputStreamWriter oswOut = new OutputStreamWriter(sout, m_encoding);
			m_out = new BufferedWriter(oswOut);
		} catch (Exception ex) {
			throw new MdmiException(ex, "XML writer fails");
		}
	}

	/**
	 * Construct from a Writer
	 *
	 * @param w
	 *            The writer to use.
	 */
	public XmlWriter(Writer w) {
		m_fileName = "";
		m_encoding = defaultEncoding;
		try {
			m_out = new BufferedWriter(w);
		} catch (Exception ex) {
			throw new MdmiException(ex, "XML writer fails");
		}
	}

	/**
	 * Construct from a file name, and the cannonical and encoding arguments.
	 *
	 * @param fileName
	 *            A valid file name
	 * @param encoding
	 *            Encoding to use
	 */
	public XmlWriter(String fileName, String encoding) {
		if (fileName == null || fileName.length() <= 0) {
			throw new IllegalArgumentException("Invalid fileName argument in XmlWriter.<init>");
		}
		m_fileName = fileName;
		m_encoding = encoding;
		m_ownStream = true;
	}

	public XmlWriter(OutputStream sout, String encoding) {
		m_fileName = "";
		m_encoding = encoding;
		try {
			OutputStreamWriter oswOut = new OutputStreamWriter(sout, m_encoding);
			m_out = new BufferedWriter(oswOut);
		} catch (Exception ex) {
			throw new MdmiException(ex, "XML writer fails");
		}

	}

	/**
	 * Write the specified document, using defaults for indent and max line length.
	 *
	 * @param doc
	 *            The DOM Document to write.
	 */
	public void write(Document doc) {
		write(doc, INDENT, LINE_LENGTH, true);
	}

	/**
	 * Write the specified document, using defaults for indent and max line length.
	 *
	 * @param doc
	 *            The DOM Document to write.
	 * @param normalize
	 *            Whether or not to normalize TEXT_NODES, etc.
	 */
	public void write(Document doc, boolean normalize) {
		write(doc, INDENT, LINE_LENGTH, normalize);
	}

	/**
	 * Write the specified document, using specified indent and max line length.
	 *
	 * @param doc
	 *            The document to write.
	 * @param indent
	 *            Indent to use (no of spaces, must be between 0 and 8).
	 * @param maxLineLen
	 *            Maximum line length to use (40 to 255).
	 */
	public void write(Document doc, int indent, int maxLineLen) {
		write(doc, indent, maxLineLen, true);
	}

	/**
	 * Write the specified document, using specified indent and max line length.
	 *
	 * @param doc
	 *            The document to write.
	 * @param indent
	 *            Indent to use (no of spaces, must be between 0 and 8).
	 * @param maxLineLen
	 *            Maximum line length to use (40 to 255).
	 * @param normalize
	 *            Whether or not to normalize TEXT_NODES, etc.
	 */
	public void write(Document doc, int indent, int maxLineLen, boolean normalize) {
		if (m_ownStream) {
			try {
				FileOutputStream fileOut = new FileOutputStream(new File(m_fileName));
				OutputStreamWriter oswOut = new OutputStreamWriter(fileOut, m_encoding);
				m_out = new BufferedWriter(oswOut);
			} catch (Exception ex) {
				throw new MdmiException(ex, "XML writer fails");
			}
		}

		m_indent = (indent < 0 || 8 < indent)
				? INDENT
				: indent;
		m_lineLen = (maxLineLen < 40 || 255 < maxLineLen)
				? LINE_LENGTH
				: maxLineLen;
		try {
			write(doc, 0, normalize);
		} catch (Exception ex) {
			throw new MdmiException(ex, "XML writer fails");
		}

		try {
			m_out.flush();
			if (m_ownStream) {
				m_out.close();
			}
			m_out = null;
		} catch (Exception ignored) {
		}
	}

	private void write(Node node, int indentLevel) throws IOException {
		write(node, indentLevel, true);
	}

	private void write(Node node, int indentLevel, boolean normalize) throws IOException {
		if (node == null) {
			return;
		}

		int type = node.getNodeType();
		switch (type) {
			case Node.DOCUMENT_NODE:
				writeDoc((Document) node, 0, normalize);
				break;

			case Node.ELEMENT_NODE:
				writeElement((Element) node, indentLevel, normalize);
				break;

			case Node.ENTITY_REFERENCE_NODE: {
				m_out.write('&');
				m_out.write(node.getNodeName());
				m_out.write(';');
			}
				break;

			case Node.CDATA_SECTION_NODE: {
				m_out.write(space(indentLevel));
				m_out.write("<![CDATA[");
				m_out.write(node.getNodeValue());
				m_out.write("]]>\n");
			}
				break;

			case Node.TEXT_NODE: {
				String v = node.getNodeValue();
				if (v != null && v.length() > 0) {
					v = v.trim();
					if (v.length() > 0) {
						m_out.write(
							normalize
									? normalize(v, false)
									: v);
					}
				}
			}
				break;

			case Node.COMMENT_NODE: {
				m_out.write(space(indentLevel));
				m_out.write("<!-- ");
				m_out.write(node.getNodeValue());
				m_out.write(" -->\n");
			}
				break;

			case Node.PROCESSING_INSTRUCTION_NODE: {
				m_out.write(space(indentLevel));
				m_out.write("<?");
				m_out.write(node.getNodeName());
				String data = node.getNodeValue();
				if (data != null && data.length() > 0) {
					m_out.write(' ');
					m_out.write(data);
				}
				m_out.write("?>\n");
			}
				break;

			case Node.NOTATION_NODE: {
				Notation n = (Notation) node;
				m_out.write(space(indentLevel));
				m_out.write("<!NOTATION ");
				m_out.write(n.getNodeName());

				String sysId = n.getSystemId();
				if (sysId != null && sysId.length() > 0) {
					m_out.write(" SYSTEM \"");
					m_out.write(sysId);
					m_out.write("\"");
				}

				String pubId = n.getPublicId();
				if (pubId != null && pubId.length() > 0) {
					m_out.write(" PUBLIC \"");
					m_out.write(pubId);
					m_out.write("\"");
				}
				m_out.write(">\n");
			}
				break;
		}
		m_out.flush();
	}

	private void writeDoc(Document node, int indentLevel, boolean normalize) throws IOException {
		if (node == null) {
			return;
		}

		m_out.write("<?xml version=\"1.0\" encoding=\"" + m_encoding + "\"?>\n");

		m_XML11 = "1.1".equals(getVersion(node));
		DocumentType docType = node.getDoctype();
		if (docType != null) {
			m_out.write("<!DOCTYPE ");
			m_out.write(docType.getNodeName());

			String sysId = docType.getSystemId();
			if (sysId != null && sysId.length() > 0) {
				m_out.write(" SYSTEM \"");
				m_out.write(sysId);
				m_out.write("\"");
			}

			String pubId = docType.getPublicId();
			if (pubId != null && pubId.length() > 0) {
				m_out.write(" PUBLIC \"");
				m_out.write(pubId);
				m_out.write("\"");
			}

			String intSS = docType.getInternalSubset();
			if (intSS != null && intSS.length() > 0) {
				String si = space(1);
				m_out.write(" [\n");
				m_out.write(si);
				m_out.write(intSS);
				m_out.write("\n]");
			}
			m_out.write(">\n");
		}

		NodeList children = node.getChildNodes();
		int n = children.getLength();
		for (int i = 0; i < n; i++) {
			write(children.item(i), 0, normalize);
		}
	}

	private void writeElement(Element node, int indentLevel, boolean normalize) throws IOException {
		if (node == null) {
			return;
		}

		StringBuffer sb = new StringBuffer(m_lineLen);
		space(sb, indentLevel);
		sb.append('<');
		sb.append(node.getNodeName());

		final int eLen = sb.length();
		int llen = sb.length();
		int aLen = 0;

		NamedNodeMap attrs = node.getAttributes();
		final int nAttrs = attrs.getLength();
		ArrayList<String> aAttrs = new ArrayList<>(nAttrs);
		for (int i = 0; i < nAttrs; i++) {
			Attr attr = (Attr) attrs.item(i);
			String sa = " " + attr.getNodeName() + "=\"" + (normalize
					? normalize(attr.getNodeValue(), true)
					: attr.getNodeValue()) + '"';
			aAttrs.add(sa);
			llen += sa.length();
			if (aLen < sa.length()) {
				aLen = sa.length();
			}
		}

		if (llen <= m_lineLen) {
			/*
			 * [indent]<tag a1="v1" a2="v2"
			 */
			m_out.write(sb.toString());
			for (int i = 0; i < nAttrs; i++) {
				String sa = aAttrs.get(i);
				m_out.write(sa);
			}
		} else {
			/*
			 * [indent]<tag a1="v1" a2="v2"
			 */
			m_out.write(sb.toString());
			String si = spaceEx(eLen);
			for (int i = 0; i < nAttrs; i++) {
				if (i > 0) {
					m_out.write('\n');
					m_out.write(si);
				}
				String sa = aAttrs.get(i);
				m_out.write(sa);
			}
		}

		NodeList children = node.getChildNodes();
		int nElems = children.getLength();

		if (nElems == 0) {
			m_out.write(" />\n");
			return;
		}

		if (nElems == 1 && children.item(0).getNodeType() == Node.TEXT_NODE) {
			String v = children.item(0).getNodeValue();
			if (v == null || v.trim().length() <= 0) {
				m_out.write(" />\n");
				return;
			}
			m_out.write(">");
			write(children.item(0), indentLevel + 1, normalize);
		} else {
			m_out.write(">\n");
			for (int i = 0; i < nElems; i++) {
				write(children.item(i), indentLevel + 1, normalize);
			}
			m_out.write(space(indentLevel));
		}
		m_out.write("</");
		m_out.write(node.getNodeName());
		m_out.write(">\n");
	}

	private String normalize(String s, boolean isAttribute) {
		if (s == null || s.length() <= 0) {
			return "";
		}

		StringBuffer b = new StringBuffer();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			switch (c) {
				case '<':
					b.append("&lt;");
					break;
				case '>':
					b.append("&gt;");
					break;
				case '&':
					b.append("&amp;");
					break;
				case '"': // escape needed only in attribute data
					if (isAttribute) {
						b.append("&quot;");
					} else {
						b.append('"');
					}
					break;
				case '\'': // escape needed only in attribute data
					if (isAttribute) {
						b.append("&apos;");
					} else {
						b.append('\'');
					}
					break;
				case '\r':
					// If CR is part of the document's content, it must not be printed as a literal
					// otherwise it would be normalized to LF when the document is reparsed.
					b.append("&#xD;");
					break;
				default: {
					// In XML 1.1, control chars in the ranges [#x1-#x1F, #x7F-#x9F] must be escaped.
					// Escape space characters that would be normalized to #x20 in attribute values
					// when the document is reparsed.
					// Escape NEL (0x85) and LSEP (0x2028) that appear in content
					// if the document is XML 1.1, since they would be normalized to LF when reparsing.
					if (m_XML11 && ((c >= 0x01 && c <= 0x1F && c != 0x09 && c != 0x0A) || (c >= 0x7F && c <= 0x9F) ||
							c == 0x2028) || isAttribute && (c == 0x09 || c == 0x0A)) {
						b.append("&#x");
						b.append(Integer.toHexString(c).toUpperCase());
						b.append(";");
					} else {
						b.append(c);
					}

				}
			}
		}
		return b.toString();
	}

	private void space(StringBuffer sb, int indentLevel) {
		final int n = indentLevel * m_indent;
		for (int i = 0; i < n; i++) {
			sb.append(' ');
		}
	}

	private String space(int indentLevel) {
		final int n = indentLevel * m_indent;
		StringBuffer sb = new StringBuffer(n);
		for (int i = 0; i < n; i++) {
			sb.append(' ');
		}
		return sb.toString();
	}

	private String spaceEx(int length) {
		StringBuffer sb = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			sb.append(' ');
		}
		return sb.toString();
	}

	protected String getVersion(Document document) {
		if (document == null) {
			return null;
		}
		String version = null;
		Method getXMLVersion = null;
		try {
			getXMLVersion = document.getClass().getMethod("getXmlVersion", new Class[] {});
			// If Document class implements DOM L3, this method will exist.
			if (getXMLVersion != null) {
				version = (String) getXMLVersion.invoke(document, (Object[]) null);
			}
		} catch (Exception ignored) {
			// Either this locator doesn't have the method, or old JDK.
		}
		return version;
	}
} // XmlWriter
