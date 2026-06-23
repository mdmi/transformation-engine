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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.mdmi.core.MdmiException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * XSLT Utilities. By default is caching the last 0x4000 expressions parsed.
 *
 * @author goancea
 */
public class XslUtil {
	public static final XPathFactory XPATH_FACTORY = XPathFactory.newInstance(); // new org.apache.xpath.jaxp.XPathFactoryImpl();

	public static final String DEFAULT_NS = "DEFAULT_NS";

	public static final String ANCESTOR = "ancestor";

	private static XCache s_cache;

	private static boolean s_isInitialized;

	/**
	 * Initialize with a cache size. If negative or 0, caching is disabled.
	 *
	 * @param cacheSize
	 *            Cache size. If negative or 0, caching is disabled.
	 */
	public static void initialize(int cacheSize) {
		if (s_isInitialized) {
			return;
		}
		if (0 < cacheSize) {
			s_cache = new XCache(cacheSize);
		}
	}

	static XCache cache() {
		if (!s_isInitialized) {
			initialize(0x1000);
		}
		return s_cache;
	}

	/**
	 * Get the DOM nodes that match the XPath passed in, relative to the element given. XPath must be relative.
	 *
	 * @param root
	 *            The element to which the XPath is relative to.
	 * @param xpath
	 *            The actual XPath expression.
	 * @return The list of nodes that match (if any). Will never be null.
	 */
	public static ArrayList<Node> getNodes(Element root, String xpath, NamespaceContext context) {
		if (root == null) {
			throw new IllegalArgumentException("The root element may not be null!");
		}
		if (xpath == null || xpath.length() <= 0) {
			throw new IllegalArgumentException("The xpath cannot be null or empty!");
		}
		NodeList nodes = getNodeList(root, xpath, context);
		ArrayList<Node> a = new ArrayList<>();
		for (int i = 0; i < nodes.getLength(); i++) {
			a.add(nodes.item(i));
		}
		return a;
	}

	/**
	 * Evaluate the XPath rule and return the evaluation result as a string. Use to get the values of simple type
	 * elements or attributes, like <code>node1/node2@attr</code>, or <code>node1/node2/text()</code>
	 *
	 * @param node
	 *            The node relative to which the evaluation of the rule takes place.
	 * @param rule
	 *            The rule to evaluate.
	 * @return The string result of the evaluation.
	 * @throws RuntimeException
	 *             If the rule is invalid, or its evaluation fails for any reason.
	 */
	public static String getString(Node node, String rule) {
		return getString(node, getRule(rule));
	}

	/**
	 * Evaluate the XPath rule and return the evaluation result as a string. Use to get the values of simple type
	 * elements or attributes, like <code>node1/node2@attr</code>, or <code>node1/node2/text()</code>
	 *
	 * @param node
	 *            The node relative to which the evaluation of the rule takes place.
	 * @param rule
	 *            The rule to evaluate.
	 * @param context
	 *            The namespace context, may be null.
	 * @return The string result of the evaluation.
	 * @throws RuntimeException
	 *             If the rule is invalid, or its evaluation fails for any reason.
	 */
	public static String getString(Node node, String rule, NamespaceContext context) {
		return getString(node, getRule(rule, context));
	}

	/**
	 * Evaluate the XPath rule and return the evaluation result as a string. Use to get the values of simple type
	 * elements or attributes, like <code>node1/node2@attr</code>, or <code>node1/node2/text()</code>
	 *
	 * @param node
	 *            The node relative to which the evaluation of the rule takes place.
	 * @param rule
	 *            The rule to evaluate.
	 * @return The string result of the evaluation.
	 * @throws RuntimeException
	 *             If the rule is invalid, or its evaluation fails for any reason.
	 */
	public static String getString(Node node, XPathExpression rule) {
		try {
			Node n = getNode(node, rule);
			if (n != null) {
				return getText(n);
			}
		} catch (Exception ignored) {
		}

		String value = null;
		try {
			value = rule.evaluate(node);
		} catch (Exception ex) {
			String err = "XslUtil.getString(): Error evaluating xpath expression '" + rule + "'";
			throw new MdmiException(ex, err);
		}
		return value;
	}

	/**
	 * Evaluate the XPath rule and return the evaluation result as an XML Node. Use to get the values of any single node,
	 * like <code>node1/node2</code>, or <code>node1/node2@attr</code>
	 *
	 * @param node
	 *            The node relative to which the evaluation of the rule takes place.
	 * @param rule
	 *            The rule to evaluate.
	 * @return The Node result of the evaluation.
	 * @throws RuntimeException
	 *             If the rule is invalid, or its evaluation fails for any reason.
	 */
	public static Node getNode(Node node, String rule) {
		return getNode(node, getRule(rule));
	}

	/**
	 * Evaluate the XPath rule and return the evaluation result as an XML Node. Use to get the values of any single node,
	 * like <code>node1/node2</code>, or <code>node1/node2@attr</code>
	 *
	 * @param node
	 *            The node relative to which the evaluation of the rule takes place.
	 * @param rule
	 *            The rule to evaluate.
	 * @param context
	 *            The namespace context, may be null.
	 * @return The Node result of the evaluation.
	 * @throws RuntimeException
	 *             If the rule is invalid, or its evaluation fails for any reason.
	 */
	public static Node getNode(Node node, String rule, NamespaceContext context) {
		return getNode(node, getRule(rule, context));
	}

	/**
	 * Evaluate the XPath rule and return the evaluation result as an XML Node. Use to get the values of any single node,
	 * like <code>node1/node2</code>, or <code>node1/node2@attr</code>
	 *
	 * @param node
	 *            The node relative to which the evaluation of the rule takes place.
	 * @param rule
	 *            The rule to evaluate.
	 * @return The Node result of the evaluation.
	 * @throws RuntimeException
	 *             If the rule is invalid, or its evaluation fails for any reason.
	 */
	public static Node getNode(Node node, XPathExpression rule) {
		Node value = null;
		try {
			value = (Node) rule.evaluate(node, XPathConstants.NODE);
		} catch (Exception ex) {
			String err = "XslUtil.getNode(): Error evaluating xpath expression '" + rule + "'";
			throw new MdmiException(ex, err);
		}
		return value;
	}

	/**
	 * Evaluate the XPath rule and return the evaluation result as an XML NodeList. Use to get the values for multiple
	 * nodes, like <code>node1/node2</code>.
	 *
	 * @param node
	 *            The node relative to which the evaluation of the rule takes place.
	 * @param rule
	 *            The rule to evaluate.
	 * @param context
	 *            The namespace context, may be null.
	 * @return The NodeList result of the evaluation.
	 * @throws RuntimeException
	 *             If the rule is invalid, or its evaluation fails for any reason.
	 */
	public static NodeList getNodeList(Node node, String rule, NamespaceContext context) {
		return getNodeList(node, getRule(rule, context));
	}

	/**
	 * Evaluate the XPath rule and return the evaluation result as an XML NodeList. Use to get the values for multiple
	 * nodes, like <code>node1/node2</code>.
	 *
	 * @param node
	 *            The node relative to which the evaluation of the rule takes place.
	 * @param rule
	 *            The rule to evaluate.
	 * @return The NodeList result of the evaluation.
	 * @throws RuntimeException
	 *             If the rule is invalid, or its evaluation fails for any reason.
	 */
	public static NodeList getNodeList(Node node, String rule) {
		return getNodeList(node, getRule(rule));
	}

	/**
	 * Evaluate the XPath rule and return the evaluation result as an XML NodeList. Use to get the values for multiple
	 * nodes, like <code>node1/node2</code>.
	 *
	 * @param node
	 *            The node relative to which the evaluation of the rule takes place.
	 * @param rule
	 *            The rule to evaluate.
	 * @return The NodeList result of the evaluation.
	 * @throws RuntimeException
	 *             If the rule is invalid, or its evaluation fails for any reason.
	 */
	public static NodeList getNodeList(Node node, XPathExpression rule) {
		NodeList value = null;
		try {
			value = (NodeList) rule.evaluate(node, XPathConstants.NODESET);
		} catch (Exception ex) {
			String err = "XslUtil.getNode(): Error evaluating xpath expression '" + rule + "'";
			throw new MdmiException(ex, err);
		}
		return value;
	}

	/**
	 * Create or get and existing node or hierarchy of nodes based on the given XPath.
	 * Supported expressions are most (but not all) XPath constructs:
	 *
	 * <pre>
	* elem - select child element 'elem' of the parent node.
	* &#64;attr - select attribute 'attr' of the parent node
	* e1/e2/eN - select element 'eN' child of 'e2', child of 'e1, in turn child of parent.
	* e1/e2/../eN/text() - select the text content of the same as previous element.
	* e1/e2/../eN@attr - select the 'attr' attribute of the same as previous element.
	* e1/e2/../eN/@attr - same as previous - different notation.
	* a[2]/b[3] - use literal index (the third child element b of the second element a, child of parent).
	* a/b/c[d[@a='v']] - select element c, child of b child of a child of parent, which has an attribute 'a' with the value 'v'.
	* a[b/c/text()='v'] - select element a child of parent, which has a child b, which has a child c, which has a text with the value 'v'.
	* a/b/ancestor::test/c - select the c node child of be which has a child of test as well.
	 * </pre>
	 *
	 * More than one node of the specified type may be created (for the nodes which support this) by using the
	 * ordinalIndex. The path must be relative to the node passed in, so a path cannot begin with '/'.
	 * Also relative paths like '//' cannot be used.
	 * The ./ (current node) is implicit if it is missing. That is "./e" == "e".
	 * The only axe/axis expression allowed is "ancestor".
	 *
	 * @param parent
	 *            Node relative to which the XPath expression will be evaluated.
	 * @param path
	 *            The XPath expression to evaluate
	 * @param ordinalIndex
	 *            The ordinal index if adding more than one node.
	 * @return The existing or created end node, as identified in the path.
	 */
	public static Node createNodeForPath(Element parent, String path, int ordinalIndex) {
		if (path.startsWith("/")) {
			throw new MdmiException("Invalid XSLT expression: '" + path + "' may not contain be absolute '/'");
		}
		if (path.startsWith("//")) {
			throw new MdmiException(
				"Invalid XSLT expression: '" + path + "' may not contain relative descendants '//'");
		}

		NodeList nodeList = XslUtil.getNodeList(parent, path);
		if (nodeList != null) {
			int count = nodeList.getLength();
			if (ordinalIndex + 1 <= count) {
				return nodeList.item(ordinalIndex); // done, we found it, so just return it.
			}
		}

		String axesPath[] = splitForFirstAxes(path);
		if (null == axesPath) {
			return createNodeForPathNoAxes(parent, path, ordinalIndex); // no axis
		}
		String sPath = axesPath[0];
		String sAxe = axesPath[1];
		String sAxePath = axesPath[2];
		String sAxeRestOfPath = axesPath[3];
		Node nodeForPathNoAxes = parent;
		if (sPath != null) {
			nodeForPathNoAxes = createNodeForPathNoAxes(parent, sPath, ordinalIndex);
		}
		Node node = null;
		if (!ANCESTOR.equals(sAxe)) {
			throw new MdmiException("XSLT axis expression: '" + sAxe + "' not supported in " + path);
		}

		String axesTag[] = splitForBrackets(sAxePath); // in case we have 'e1[...]'
		node = nodeForPathNoAxes;
		String nodeNameInPath = axesTag[0];
		int index = nodeNameInPath.indexOf(':'); // remove namespace prefix (for ns:e1)
		nodeNameInPath = index == -1
				? nodeNameInPath
				: nodeNameInPath.substring(index + 1);
		while (node != null) {
			node = node.getParentNode();
			if (node.getNodeName().equals(nodeNameInPath)) {
				break;
			}
		}
		if (node == null) {
			throw new MdmiException("Invalid XSLT expression: '" + path + "' ancestor not found: " + nodeNameInPath);
		}
		if (null == axesTag[1]) {
			if (null == sAxeRestOfPath) {
				return node;
			} else {
				return createNodeForPathNoAxes((Element) node, sAxeRestOfPath, ordinalIndex);
			}
		}
		String sp = null == axesTag[2]
				? axesTag[1]
				: axesTag[1] + axesTag[2];
		return createNodeForPathNoAxes((Element) node, sp + sAxeRestOfPath, ordinalIndex);
	}

	public static Node createNodeForPathNoAxes(Element parent, String path, int ordinalIndex) {
		if (parent == null || path == null || path.length() <= 0) {
			throw new IllegalArgumentException("Null or empty arguments!");
		}
		ordinalIndex = ordinalIndex < 0
				? 0
				: ordinalIndex;

		int isqb = indexOfNotInQuotes(path, '[');
		int islh = indexOfNotInQuotes(path, '/');
		int icat = indexOfNotInQuotes(path, '@');

		if (isqb == 0) {
			throw new IllegalArgumentException("Invalid xpath expression '" + path + "', cannot start with '['");
		}
		if (islh == 0) {
			throw new IllegalArgumentException("Invalid xpath expression '" + path + "', cannot start with '/'");
		}
		if (path.length() <= islh + 1) {
			throw new IllegalArgumentException("Invalid xpath expression '" + path + "', cannot end with '/'");
		}

		if (isqb < 0) {
			if (icat == 0) {
				if (0 < islh) {
					throw new IllegalArgumentException(
						"Invalid xpath expresion '" + path + "', cannot contain '/' after '@'");
				}
				String name = path.substring(1);
				return getOrCreateAttribute(parent, name);
			}
			if (icat < 0) {
				int i = islh;
				String spath = path;
				Element p = parent;
				while (0 < i) {
					String name = spath.substring(0, i);
					spath = spath.substring(i + 1);
					i = indexOfNotInQuotes(spath, '/');
					if (spath.equals("text()")) {
						p = getOrCreateElement(p, name, ordinalIndex);
					} else {
						p = getOrCreateElement(p, name);
					}
				}
				if (spath.equals("text()")) {
					return p;
				} else {
					return getOrCreateElement(p, spath, ordinalIndex);
				}
			} else {
				if (icat < path.lastIndexOf('/')) {
					throw new IllegalArgumentException(
						"Invalid xpath expresion '" + path + "', cannot contain '/' after '@'");
				}
				int i = islh;
				String spath = path;
				Element p = parent;
				String name = null;
				while (0 < i) {
					name = spath.substring(0, i);
					spath = spath.substring(i + 1);
					i = indexOfNotInQuotes(spath, '/');
					p = getOrCreateElement(p, name);
				}
				i = indexOfNotInQuotes(spath, '@');
				name = spath.substring(0, i);
				spath = spath.substring(i + 1);
				if (0 < name.length()) {
					p = getOrCreateElement(p, name);
				}
				return getOrCreateAttribute(p, spath);
			}
		} else {
			if (icat == 0) {
				throw new IllegalArgumentException(
					"Invalid xpath expresion '" + path + "', cannot contain '@' after '['");
			}
			int x = isqb;
			int y = islh;
			String spath = path;
			Element p = parent;
			String name = null;
			while (0 < x || 0 <= y) {
				if (0 < x && x < y || y < 0) {
					String[] a = splitForBrackets(spath);
					name = a[0];
					String expr = a[1]; // never null here, we just checked for '['
					spath = null == a[2]
							? ""
							: a[2];
					int index = xpathIndex(expr);
					if (0 < index) {
						ArrayList<Element> elems = XmlUtil.getElements(p, name);
						while (elems.size() < index) {
							XmlUtil.addElement(p, name);
							elems = XmlUtil.getElements(p, name);
						}
						p = elems.get(index - 1);
					} else {
						String pred = name + '[' + expr + ']';
						boolean isFinal = spath.length() <= 0;
						NodeList nl = XslUtil.getNodeList(p, pred);
						int count = nl.getLength();
						Node on = null;
						if (isFinal) {
							int oi = ordinalIndex < 0
									? 0
									: ordinalIndex;
							if (nl == null || count < oi + 1) {
								on = addNodeBasedOnPredicate(p, nl, name, expr, oi);
							} else {
								on = nl.item(oi);
							}
						} else {
							if (nl == null || count <= 0) {
								on = addNodeBasedOnPredicate(p, nl, name, expr, 0);
							} else {
								on = nl.item(0);
							}
						}
						if (on instanceof Element) {
							p = (Element) on;
						} else if (!isFinal) {
							throw new IllegalArgumentException(
								"Invalid attribute node followed by XPath expresion: " + path);
						}
					}
				} else {
					name = spath.substring(0, y);
					spath = spath.substring(y + 1);
					p = getOrCreateElement(p, name);
				}
				if (0 < spath.length() && spath.startsWith("/")) {
					spath = spath.substring(1);
				}
				x = indexOfNotInQuotes(spath, '[');
				y = indexOfNotInQuotes(spath, '/');
			}
			if (null == spath || 0 < spath.length()) {
				return getOrCreateElement(p, spath, ordinalIndex);
			}
			return p;
		}
	}

	private static Node addNodeBasedOnPredicate(Element parent, NodeList nl, String name, String expr, int index) {
		if (parent == null || name == null || expr == null || name.length() <= 0 || expr.length() <= 0) {
			throw new IllegalArgumentException("Invalid null or empty argument!");
		}
		int count = nl.getLength();
		if (index < count) {
			return nl.item(index);
		}
		Element child = null;
		for (int i = count; i < index + 1; i++) {
			child = XmlUtil.addElement(parent, name);
			processPredicate(child, expr);
		}
		return child;
	}

	private static void processPredicate(Element child, String expr) {
		if (expr.startsWith("@")) {
			String[] a = parseAttrValue(expr);
			Node n = getOrCreateAttribute(child, a[0]);
			n.setTextContent(a[1]);
		} else if (0 < indexOfNotInQuotes(expr, '[')) {
			createNodeForPath(child, expr, -1);
		} else {
			int ieq = indexOfNotInQuotes(expr, '=');
			if (0 < ieq) {
				String[] a = parseElemValue(expr);
				Node n = createNodeForPath(child, a[0], -1);
				if (null == n) {
					throw new MdmiException("Can't handle predicate expression: " + expr);
				}
				n.setTextContent(a[1]);
			} else {
				throw new MdmiException("Can't handle predicate expression: " + expr);
			}
		}
	}

	private static String[] parseElemValue(String s) {
		if (s == null || s.length() <= 0) {
			throw new IllegalArgumentException("Invalid argument expresion " + s);
		}
		int i = s.indexOf('=');
		String[] a = new String[2];
		a[0] = s.substring(0, i);
		a[1] = s.substring(i + 2, s.length() - 1);
		return a;
	}

	private static String[] parseAttrValue(String s) {
		if (s == null || s.length() <= 0 || !s.startsWith("@")) {
			throw new IllegalArgumentException("Invalid argument expresion " + s);
		}
		s = s.substring(1);
		int i = s.indexOf('=');
		String[] a = new String[2];
		a[0] = s.substring(0, i);
		a[1] = s.substring(i + 2, s.length() - 1);
		return a;
	}

	private static int xpathIndex(String expr) {
		try {
			return Integer.valueOf(expr);
		} catch (Exception ignored) {
		}
		return -1;
	}

	/**
	 * It will split and XSLT axis expression like:
	 *
	 * <pre>
	* ancestor::test
	* e1/e2/ancestor::test
	* ancestor::test/e3
	* e1/e2/ancestor::test/e3[@a='v']
	 * </pre>
	 *
	 * into parts:
	 *
	 * <pre>
	* e1/e2/
	* ancestor
	* test
	* /e3[@a='v']
	 * </pre>
	 *
	 * @param s
	 *            the expression to split.
	 * @return The array containing the parts, as shown above.
	 */
	private static String[] splitForFirstAxes(String s) {
		String[] a = new String[4];
		int i = indexOfNotInQuotes(s, "::");
		if (0 > i) {
			return null;
		}
		String part1 = s.substring(0, i);
		String part2 = s.substring(i + 2);
		int part1LastsSlash = part1.lastIndexOf('/');
		int part2FirstSlash = part2.indexOf('/');

		if (part1LastsSlash < 0) {
			a[0] = null;
			a[1] = part1;// axe
		} else {
			a[0] = part1.substring(0, part1LastsSlash); //
			a[1] = part1.substring(part1LastsSlash + 1);// axe
		}
		if (part2FirstSlash < 0) {
			a[2] = part2;// axe path
			a[3] = null;
		} else {
			a[2] = part2.substring(0, part2FirstSlash); // axe path
			a[3] = part2.substring(part2FirstSlash);// rest of path after axe
		}
		return a;
	}

	/**
	 * Split an expression like:
	 *
	 * <pre>
	* e1/e2[e3[@a='v']]/e4...
	 * </pre>
	 *
	 * In the following:
	 *
	 * <pre>
	* e1/e2
	* [e3[@a='v']]
	* /e4...
	 * </pre>
	 *
	 * If no brackets are present, then the return string array will have items at index 1 and 2 null.
	 *
	 * @param s
	 * @return
	 */
	private static String[] splitForBrackets(String s) {
		String[] a = new String[3];
		int i = indexOfNotInQuotes(s, '[');
		if (i <= 0) {
			a[0] = s;
			return a;
		}
		int j = i;
		int closeBindex = -1;
		int openBcount = 0;
		boolean insideQuotes = false;
		while (j < s.length() && closeBindex < 0) {
			char c = s.charAt(++j);
			if (c == '\'') {
				if (insideQuotes) {
					if (s.charAt(j - 1) != '\\') {
						insideQuotes = false;
					}
				} else {
					insideQuotes = true;
				}
			}
			if (c == '[' && !insideQuotes) {
				openBcount++;
			} else if (c == ']' && !insideQuotes) {
				if (openBcount == 0) {
					closeBindex = j; // found the closing bracket
				} else {
					openBcount--;
				}
			}
		}
		if (closeBindex < 0) {
			throw new IllegalArgumentException("Invalid xpath expresion '" + s + "', does not contain matching ']'");
		}
		a[0] = s.substring(0, i);
		a[1] = s.substring(i + 1, closeBindex);
		if (s.length() <= closeBindex + 1) {
			a[2] = null;
		} else {
			a[2] = s.substring(closeBindex + 1);
		}
		return a;
	}

	private static int indexOfNotInQuotes(String s, char x) {
		int i = s.indexOf(x);
		if (i < 0) {
			return i;
		}
		i = -1;
		int j = 0;
		boolean insideQuotes = false;
		while (j < s.length() && i < 0) {
			char c = s.charAt(j);
			if (c == '\'') {
				if (insideQuotes) {
					if (0 <= j - 1 && s.charAt(j - 1) != '\\') {
						insideQuotes = false;
					}
				} else {
					insideQuotes = true;
				}
			}
			if (c == x && !insideQuotes) {
				i = j;
			}
			j++;
		}
		return i;
	}

	private static int indexOfNotInQuotes(String s, String x) {
		int i = s.indexOf(x);
		if (i < 0) {
			return i;
		}
		i = -1;
		int j = 0;
		int n = x.length();
		boolean insideQuotes = false;
		while (j + n < s.length() && i < 0) {
			char c = s.charAt(j);
			if (c == '\'') {
				if (insideQuotes) {
					if (0 <= j - 1 && s.charAt(j - 1) != '\\') {
						insideQuotes = false;
					}
				} else {
					insideQuotes = true;
				}
			}
			if (!insideQuotes && x.equals(s.substring(j, j + n))) {
				i = j;
			}
			j++;
		}
		return i;
	}

	private static Attr getOrCreateAttribute(Element parent, String name) {
		Attr a = parent.getAttributeNode(name);
		if (a == null) {
			Document doc = parent.getOwnerDocument();
			a = doc.createAttribute(name);
			parent.setAttributeNode(a);
		}
		return a;
	}

	private static Element getOrCreateElement(Element parent, String name) {
		Element child = XmlUtil.getElement(parent, name);
		if (child == null) {
			child = XmlUtil.addElement(parent, name);
		}
		return child;
	}

	private static Element getOrCreateElement(Element parent, String name, int index) {
		if (index <= 0) {
			return getOrCreateElement(parent, name);
		}
		ArrayList<Element> elems = XmlUtil.getElements(parent, name);
		while (elems.size() < index + 1) {
			XmlUtil.addElement(parent, name);
			elems = XmlUtil.getElements(parent, name);
		}
		return elems.get(index);
	}

	private static XPathExpression getRule(String rule) {
		return getRule(rule, null);
	}

	private static void createNodeXPath(StringBuilder stringBuilder, String tag) {

		int icln = indexOfNotInQuotes(tag, ':');
		int icat = indexOfNotInQuotes(tag, '@');
		if (icln < 0 && icat != 0) {
			stringBuilder.append(DEFAULT_NS);
			stringBuilder.append(":");
		}
		tag = tag.replace("[templateId", "[" + DEFAULT_NS + ":" + "templateId");
		stringBuilder.append(tag);

	}

	private static String getValidXpath(String xPath, NamespaceContext context) {
		if (context == null) {
			return xPath;
		}
		String namespaceURI = context.getNamespaceURI(DEFAULT_NS);
		if (namespaceURI != null && !namespaceURI.isEmpty()) {
			StringBuilder stringBuilder = new StringBuilder();
			String[] tags = xPath.split("/");
			int length = tags.length;
			for (int i = 0; i < length - 1; i++) {
				createNodeXPath(stringBuilder, tags[i]);
				stringBuilder.append("/");
			}
			createNodeXPath(stringBuilder, tags[length - 1]);
			return stringBuilder.toString();
		}
		return xPath;
	}

	private static XPathExpression getRule(String rule, NamespaceContext context) {
		XPathExpression r = cache().getExpression(rule);
		if (r == null) {
			XPath xpath = XPATH_FACTORY.newXPath();
			if (context != null) {
				xpath.setNamespaceContext(context);
			}
			try {
				r = xpath.compile(getValidXpath(rule, context));
			} catch (Exception ex) {
				String err = "XslUtil.getRule(): Error compiling xpath expression '" + rule + "'";
				throw new MdmiException(ex, err);
			}
			cache().addExpression(rule, r);
		}
		return r;
	}

	private static String getText(Node node) {
		if (node == null) {
			return null;
		}
		NodeList lst = node.getChildNodes();
		int size = lst.getLength();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			Node n = lst.item(i);
			if (n.getNodeType() == Node.TEXT_NODE) {
				Text t = (Text) n;
				sb.append(t.getData());
			}
		}
		return sb.toString();
	}

	private static class XC {
		String rule;

		XPathExpression expression;

		Date lastUsed;
	}

	private static class XCache {
		private final ArrayList<XC> m_cache = new ArrayList<>();

		private final HashMap<String, Integer> m_ruleNameIndex = new HashMap<>();

		private final TreeMap<Date, Integer> m_lastUsedIndex = new TreeMap<>();

		private final Object lock = new Object();

		private int maxSize = 0x4000;

		XCache(int cacheSize) {
			if (0 < cacheSize) {
				maxSize = cacheSize;
			}
		}

		XPathExpression getExpression(String rule) {
			synchronized (lock) {
				Integer i = m_ruleNameIndex.get(rule);
				if (i == null) {
					return null;
				}
				XC xc = m_cache.get(i.intValue());
				xc.lastUsed = new Date();
				return xc.expression;
			}
		}

		void addExpression(String rule, XPathExpression expression) {
			synchronized (lock) {
				Integer i = m_ruleNameIndex.get(rule);
				if (i != null) {
					XC xc = m_cache.get(i.intValue());
					xc.expression = expression;
					xc.lastUsed = new Date();
					return;
				}
			}

			if (m_cache.size() < maxSize) {
				XC xc = new XC();
				xc.rule = rule;
				xc.expression = expression;
				xc.lastUsed = new Date();
				synchronized (lock) {
					Integer i = m_cache.size();
					m_cache.add(xc);
					m_ruleNameIndex.put(xc.rule, i);
					m_lastUsedIndex.put(xc.lastUsed, i);
				}
			} else {
				synchronized (lock) {
					NavigableMap.Entry<Date, Integer> last = m_lastUsedIndex.lastEntry();
					Integer pos = last.getValue();
					XC xcOld = m_cache.get(pos);
					m_ruleNameIndex.remove(xcOld.rule);
					m_cache.remove(pos.intValue());

					XC xc = new XC();
					xc.rule = rule;
					xc.expression = expression;
					xc.lastUsed = new Date();
					m_cache.set(pos, xc);
					m_ruleNameIndex.put(xc.rule, pos);
					m_lastUsedIndex.put(xc.lastUsed, pos);
				}
			}
		}
	}

	public static void main(String[] args) {
		splitForFirstAxes("e1/e2/ancestor::tag/e3");
		splitForFirstAxes(
			"component/section[templateId[@root=\"2.16.840.1.113883.10.20.21.2.6.1\"]]/ancestor::DEFAULT_NS:component[1]");

		String xml = "<root><e a='v1'/><e a='v2'/></root>";
		XmlParser p = new XmlParser();
		Document doc = p.parse(new StringReader(xml));
		Element root = doc.getDocumentElement();

		Node n = createNodeForPath(root, "e[@a='v1']", 0);
		Element e = (Element) n;
		XmlUtil.addElement(e, "test1", "value1");

		n = createNodeForPath(root, "e[@a='v2']", 0);
		e = (Element) n;
		XmlUtil.addElement(e, "test2", "value2");

		xml = "<root>" + "  <e1>" + "    <e2 a='v1'></e2>" + "    <x>test1</x>" + "  </e1>" + "  <e1>" +
				"    <e2 a='v2'></e2>" + "  </e1>" + "</root>";
		p = new XmlParser();
		doc = p.parse(new StringReader(xml));
		root = doc.getDocumentElement();
		n = createNodeForPath(root, "e1[e2[@a='v1']]/e2[@a='v1']", 0);
		e = (Element) n;
		Element x = XmlUtil.getElement(e, "x");
		if (x == null) {
			x = XmlUtil.addElement(e, "x");
		}
		XmlUtil.setText(x, "changed1");

		n = createNodeForPath(root, "e1[e2[@a='v2']]/e2[@a='v2']", 0);
		e = (Element) n;
		x = XmlUtil.getElement(e, "x");
		if (x == null) {
			x = XmlUtil.addElement(e, "x");
		}
		XmlUtil.setText(x, "changed2");

		n = createNodeForPath(root, "e1[e2[@a='v3']]/e2[@a='v3']", 0);
		e = (Element) n;
		x = XmlUtil.getElement(e, "x");
		if (x == null) {
			x = XmlUtil.addElement(e, "x");
		}
		XmlUtil.setText(x, "changed3");

	}
} // XslUtil
