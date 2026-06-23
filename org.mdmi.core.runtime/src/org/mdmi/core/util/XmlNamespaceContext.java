/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

public final class XmlNamespaceContext implements NamespaceContext {
	private String defaultNsPrefix;

	private final HashMap<String, String> prefixes;

	private final HashMap<String, HashSet<String>> namespaces;

	/**
	 * Default ctor - uses only the default namespace prefix.
	 *
	 * @param defaultNsPrefix
	 *            The default namespace prefix.
	 */
	public XmlNamespaceContext(String defaultNsPrefix) {
		this.defaultNsPrefix = defaultNsPrefix;
		prefixes = new HashMap<>();
		namespaces = new HashMap<>();
		addImpl(XMLConstants.XML_NS_PREFIX, XMLConstants.XML_NS_URI);
		addImpl(XMLConstants.XMLNS_ATTRIBUTE, XMLConstants.XMLNS_ATTRIBUTE_NS_URI);
	}

	/**
	 * Construct one from a given map of prefix-namespeces and the default NS prefix.
	 *
	 * @param prefixNamespaceMap
	 *            Map of prefix-namespaces.
	 * @param defaultNsPrefix
	 *            The default namespace prefix.
	 */
	public XmlNamespaceContext(Map<String, String> prefixNamespaceMap, String defaultNsPrefix) {
		this(defaultNsPrefix);
		if (prefixNamespaceMap == null) {
			throw new IllegalArgumentException("Null prefixNamespaceMap");
		}
		for (Iterator<String> i = prefixNamespaceMap.keySet().iterator(); i.hasNext();) {
			String prefix = i.next();
			add(prefix, prefixNamespaceMap.get(prefix));
		}
	}

	/**
	 * Get the map of prefix-namespaces in this instance.
	 *
	 * @return The map of prefix-namespaces in this instance.
	 */
	public Map<String, String> getPrefixNamespaceUriMap() {
		return Collections.unmodifiableMap(prefixes);
	}

	/**
	 * Add a prefix-namespace pair to this instance.
	 *
	 * @param prefix
	 *            The prefix.
	 * @param namespaceUri
	 *            The namespace - nsut not be null;
	 */
	public void add(String prefix, String namespaceUri) {
		if (prefix == null) {
			throw new IllegalArgumentException("Null prefix");
		}
		if (namespaceUri == null || namespaceUri.length() <= 0) {
			throw new IllegalArgumentException("Null or empty namespaceUri");
		}
		if (prefix.equals(XMLConstants.XML_NS_PREFIX)) {
			String ns = prefixes.get(prefix);
			if (ns != null && !ns.equals(namespaceUri)) {
				throw new IllegalArgumentException("Prefix " + prefix + " must be " + XMLConstants.XML_NS_URI);
			}
			return;
		}
		if (prefix.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
			String ns = prefixes.get(prefix);
			if (ns != null && !ns.equals(namespaceUri)) {
				throw new IllegalArgumentException(
					"Prefix " + prefix + " must be " + XMLConstants.XMLNS_ATTRIBUTE_NS_URI);
			}
			return;
		}
		addImpl(prefix, namespaceUri);
	}

	private void addImpl(String prefix, String namespaceUri) {
		if (prefix.length() <= 0) {
			prefix = defaultNsPrefix;
		}
		prefixes.put(prefix, namespaceUri);
		HashSet<String> ps = namespaces.get(namespaceUri);
		if (ps == null) {
			ps = new HashSet<>();
			namespaces.put(namespaceUri, ps);
		}
		if (!ps.contains(prefix)) {
			ps.add(prefix);
		}
	}

	/**
	 * Get all the namespaces from a DOM document.
	 *
	 * @param doc
	 *            The document.
	 * @param defaultNsPrefix
	 *            The string to use as default prefix.
	 * @return The map of namspaces used.
	 */
	public static XmlNamespaceContext getDocumentNamespaces(Document doc, String defaultNsPrefix) {
		if (doc == null) {
			throw new IllegalArgumentException("Null document!");
		}
		Element root = doc.getDocumentElement();
		XmlNamespaceContext ctx = new XmlNamespaceContext(defaultNsPrefix);
		scan(root, ctx);
		return ctx;
	}

	private static void scan(Element root, XmlNamespaceContext ctx) {
		NamedNodeMap attrs = root.getAttributes();
		if (attrs != null) {
			for (int i = 0; i < attrs.getLength(); i++) {
				Attr attr = (Attr) attrs.item(i);
				String an = attr.getNodeName();
				if (an.startsWith("xmlns")) {
					if (an.equals("xmlns")) {
						ctx.add("", attr.getNodeValue());
					} else if (an.startsWith("xmlns:")) {
						ctx.add(an.substring(6), attr.getNodeValue());
					}
				}
			}
		}
		ArrayList<Element> children = XmlUtil.getElements(root);
		for (int i = 0; i < children.size(); i++) {
			scan(children.get(i), ctx);
		}
	}

	@Override
	public String getNamespaceURI(String prefix) {
		if (prefix == null) {
			throw new IllegalArgumentException("Null prefix");
		}
		String namespaceUri = prefixes.get(prefix);
		return namespaceUri == null
				? XMLConstants.NULL_NS_URI
				: namespaceUri;
	}

	@Override
	public String getPrefix(String namespaceUri) {
		if (namespaceUri == null || namespaceUri.length() <= 0) {
			throw new IllegalArgumentException("Null or empty namespaceUri");
		}
		HashSet<String> ps = namespaces.get(namespaceUri);
		return ps == null
				? null
				: ps.iterator().next();
	}

	@Override
	public Iterator<String> getPrefixes(String namespaceUri) {
		if (namespaceUri == null || namespaceUri.length() <= 0) {
			throw new IllegalArgumentException("Null or empty namespaceUri");
		}
		HashSet<String> ps = namespaces.get(namespaceUri);
		return ps == null
				? null
				: ps.iterator();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Iterator<String> i = prefixes.keySet().iterator(); i.hasNext();) {
			String p = i.next();
			String n = prefixes.get(p);
			sb.append(p).append(":").append(n).append("\n");
		}
		return sb.toString();
	}
} // XmlNamespaceContext
