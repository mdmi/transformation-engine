/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.parser.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.lang3.StringUtils;
import org.mdmi.Bag;
import org.mdmi.Choice;
import org.mdmi.LeafSyntaxTranslator;
import org.mdmi.MessageModel;
import org.mdmi.MessageSyntaxModel;
import org.mdmi.Node;
import org.mdmi.core.ISyntacticParser;
import org.mdmi.core.ISyntaxNode;
import org.mdmi.core.MdmiException;
import org.mdmi.core.MdmiMessage;
import org.mdmi.core.engine.UnspecifiedNode;
import org.mdmi.core.engine.YBag;
import org.mdmi.core.engine.YChoice;
import org.mdmi.core.engine.YLeaf;
import org.mdmi.core.engine.YNode;
import org.mdmi.core.engine.parser.xml.XPathParser.AbbreviatedStepContext;
import org.mdmi.core.engine.parser.xml.XPathParser.AxisSpecifierContext;
import org.mdmi.core.engine.parser.xml.XPathParser.NodeTestContext;
import org.mdmi.core.engine.parser.xml.XPathParser.PredicateContext;
import org.mdmi.core.util.XmlParser;
import org.mdmi.core.util.XmlUtil;
import org.mdmi.core.util.XslUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class DOMSAXSyntacticParser implements ISyntacticParser {

	private static Logger logger = LoggerFactory.getLogger(DOMSAXSyntacticParser.class);

	private class XPathExtractor extends XPathBaseListener {

		private static final String DOTDOT = "..";

		boolean inPredicate = false;

		boolean isAttribute = false;

		boolean isContainer = false;

		org.w3c.dom.Node node;

		Document document;

		public XPathExtractor(Element element, boolean isContainer) {
			this.node = element;
			this.isContainer = isContainer;
			document = this.node.getOwnerDocument();
		}

		@Override
		public void exitAbbreviatedStep(AbbreviatedStepContext ctx) {
			// If xpath has .. move node upto parent
			if (DOTDOT.equals(ctx.getText())) {
				node = node.getParentNode();
			}
			super.exitAbbreviatedStep(ctx);
		}

		@Override
		public void exitNodeTest(NodeTestContext ctx) {
			if (!inPredicate) {
				if (isAttribute) {
					// sb.append(ctx.getText());
					Attr attribute = document.createAttribute(ctx.getText());
					((Element) node).setAttributeNode(attribute);
					node = attribute;
				} else {
					Element childElement = null;
					if (isContainer) {
						childElement = document.createElement(ctx.getText());
						node.appendChild(childElement);
					} else {
						if (childElement == null) {
							childElement = document.createElement(ctx.getText());
							node.appendChild(childElement);
						}
					}

					node = childElement;
				}
				isAttribute = false;
			}
			super.exitNodeTest(ctx);
		}

		@Override
		public void enterPredicate(PredicateContext ctx) {
			// logger.trace("enterPredicate " + ctx.getText());
			inPredicate = true;
			super.enterPredicate(ctx);
		}

		@Override
		public void exitPredicate(PredicateContext ctx) {
			// logger.trace("exitPredicate " + ctx.getText());
			inPredicate = false;
			super.exitPredicate(ctx);
		}

		@Override
		public void exitAxisSpecifier(AxisSpecifierContext ctx) {
			// logger.trace("exitAxisSpecifier " + ctx.getText());
			if (!inPredicate && "@".equals(ctx.getText())) {
				isAttribute = true;
			}
			super.exitAxisSpecifier(ctx);
		}

	}

	public static class SL4JBaseErrorListener extends BaseErrorListener {

		public static final SL4JBaseErrorListener INSTANCE = new SL4JBaseErrorListener();

		/*
		 * (non-Javadoc)
		 *
		 * @see org.antlr.v4.runtime.BaseErrorListener#syntaxError(org.antlr.v4.runtime.Recognizer, java.lang.Object, int, int, java.lang.String,
		 * org.antlr.v4.runtime.RecognitionException)
		 */
		@Override
		public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
				String msg, RecognitionException e) {
			if (logger.isTraceEnabled()) {
				logger.trace("line " + line + ":" + charPositionInLine + " " + msg);
			}
		}

	}

	String messageGroupName;

	/**
	 * @TODO Temporary fix for XML namespace
	 *       Supporting such configurations on model is needed
	 *       or access to the properties files
	 * @param name
	 */
	public DOMSAXSyntacticParser(String messageGroupName) {
		this.messageGroupName = messageGroupName;
	}

	private org.w3c.dom.Node createElement(Element elemement, String xPath, boolean container) {

		// logger.trace("ELEMEMENT IS :" + elemement.getTagName());

		// logger.trace("XPATH IS :" + xPath);

		if (xPath.startsWith("@")) {
			Attr attribute = elemement.getOwnerDocument().createAttribute(xPath.substring(1));
			elemement.setAttributeNode(attribute);
			return attribute;
		}

		if (!(xPath.contains(".") || xPath.contains("[") || xPath.contains("]"))) {
			if (xPath.contains("/")) {
				String[] elements = xPath.split("/");
				Element current = elemement;
				for (String element : elements) {
					if (element.startsWith("@")) {
						Attr attribute = elemement.getOwnerDocument().createAttribute(element.substring(1));
						current.setAttributeNode(attribute);
					} else {
						Element childElement = elemement.getOwnerDocument().createElement(element);
						current.appendChild(childElement);
						current = childElement;
					}
				}
				return current;
			} else {
				if (StringUtils.isEmpty(xPath)) {
					xPath = "XPATH";
				}
				Element childElement = elemement.getOwnerDocument().createElement(xPath);
				elemement.appendChild(childElement);
				return childElement;
			}
		}

		// logger.trace(elemement.getNodeName() + " creating " + xPath + " container " + container);

		CharStream input = CharStreams.fromString(xPath);

		XPathLexer lexer = new XPathLexer(input);

		// logger.trace("Creating CommonTokenStream");
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// logger.trace("Creating XPathParser" + tokens);
		XPathParser parser = new XPathParser(tokens);

		parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
		// parser.addErrorListener(SL4JBaseErrorListener.INSTANCE);

		// logger.trace("Creating ParseTreeWalker");
		ParseTreeWalker walker = new ParseTreeWalker();

		// logger.trace("Creating XPathExtractor");
		XPathExtractor extractor = new XPathExtractor(elemement, container);
		// logger.trace("walk");

		walker.walk(extractor, parser.main());

		// logger.trace("created " + extractor.node.getLocalName());
		return extractor.node;
	}

	protected NamespaceContext context;

	/*
	 * Extend DOM/SAX Tree Walker which tracks the current dom node so we can
	 * perform XPATH queries
	 */
	private class MDMITreeWalker extends InternalTreeWalker {

		public MDMITreeWalker(ContentHandler contentHandler) {
			super(contentHandler);
		}

		@Override
		protected void startNode(org.w3c.dom.Node node) throws SAXException {
			domNodes.push(node);
			super.startNode(node);
		}

		@Override
		protected void endNode(org.w3c.dom.Node node) throws SAXException {
			lastPop = domNodes.pop();
			super.endNode(node);
		}

	}

	// static int expressionCounter = 0;

	HashMap<String, XPathExpression> xPathExpressions = new HashMap<>();

	private Stack<org.w3c.dom.Node> domNodes = new Stack<>();

	private org.w3c.dom.Node lastPop = null;

	private void saxParse(final YBag yroot, final byte[] data, ArrayList<UnspecifiedNode> arrayList)
			throws ParserConfigurationException, SAXException {

		DefaultHandler2 mdmiHandler = new DefaultHandler2() {

			private Stack<EndTagProcessor> endTags;

			private Stack<Node> syntaxNodes;

			private Stack<YNode> yBags;

			boolean isParsing = false;

			boolean isActive = false;

			StringBuilder builder = null;

			YLeaf currentYLeaf = null;

			XPath xPath = null;

			@Override
			public void startCDATA() throws SAXException {
				if (isParsing && builder != null) {
					builder.append("<![CDATA[");
				} else {
					isParsing = true;
					builder = new StringBuilder();
					builder.append("<![CDATA[");
				}
			}

			@Override
			public void endCDATA() throws SAXException {
				if (isParsing && builder != null) {
					builder.append("]]>");
				}
			}

			@Override
			public void startDocument() throws SAXException {

				endTags = new Stack<>();
				syntaxNodes = new Stack<>();
				syntaxNodes.push(yroot.getNode());
				yBags = new Stack<>();
				yBags.push(yroot);
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				if (isParsing && builder != null) {
					builder.append(new String(ch, start, length));
				} else {
				}
			}

			/**
			 * Construct the XPath expression
			 */
			private String getCurrentXPath() {
				String str = "//";
				boolean first = true;
				for (Node node : syntaxNodes) {
					if (first) {
						str = node.getLocation();
					} else {
						str = str + "/" + node.getLocation();
					}
					first = false;
				}
				return str;
			}

			/**
			 * Construct the XPath expression
			 */
			private String getCurrentRelativePath(Node bag) {
				Stack<String> currentPath = getRelativePath(bag);

				if (currentPath != null && !currentPath.isEmpty()) {

					String str = "";

					boolean first = true;
					for (String node : currentPath) {

						if (first) {
							str = node;
							first = false;
						} else {
							str = str + "/" + node;
						}

					}
					return str = str + "/";
				} else {
					return "";
				}
			}

			HashMap<Node, Stack<String>> relativePaths = new HashMap<>();

			void pushXPath(Node bag, String path) {
				if (!relativePaths.containsKey(bag)) {
					relativePaths.put(bag, new Stack<String>());
				}
				relativePaths.get(bag).push(path);
			}

			void popXPath(Node bag) {
				if (relativePaths.containsKey(bag)) {
					relativePaths.get(bag).pop();
				}
			}

			Stack<String> getRelativePath(Node bag) {
				if (relativePaths.containsKey(bag)) {
					return relativePaths.get(bag);
				} else {
					return null;
				}
			}

			private boolean isMatch(String currentRelativeXPath, Node node) {

				String nodeXPathLocation = node.getLocation();

				// logger.trace(currentRelativeXPath);
				// logger.trace(nodeXPathLocation);

				if (currentRelativeXPath.equals(nodeXPathLocation) ||
						nodeXPathLocation.equals("@" + currentRelativeXPath)) {

					return true;
				}

				String[] locationSegments = nodeXPathLocation.split("/@");

				if (currentRelativeXPath.equals(locationSegments[0])) {

					return true;
				}

				String[] path = nodeXPathLocation.split("\\[");

				if (currentRelativeXPath.equals(path[0])) {

					return true;
				}

				// @TODO - Add some global to note call this unless parsing MDMI language map
				if ("MDMI".equals(node.getLocationExpressionLanguage())) {

					String[] locations = nodeXPathLocation.split(Pattern.quote("|"));
					for (String location : locations) {

						location = location.trim();

						if (location.equals(currentRelativeXPath)) {
							return true;
						}

						if (location.endsWith("#")) {
							if (location.startsWith(currentRelativeXPath.replaceAll("\\d+$", ""))) {
								return true;
							}
							if (location.startsWith("^")) {
								if (location.substring(1).toUpperCase().startsWith(
									currentRelativeXPath.toUpperCase().replaceAll("\\d+$", ""))) {
									return true;
								}
							}
						}
						if (location.startsWith("^")) {
							if (location.substring(1).equalsIgnoreCase(currentRelativeXPath)) {
								return true;
							}
						}

					}

				}

				return false;

			}

			BagEndTagProcessor bagEndTagProcessor = new BagEndTagProcessor();

			LeafEndTagProcessor leafEndTagProcessor = new LeafEndTagProcessor();

			NotFoundEndTagProcessor notFoundEndTagProcessor = new NotFoundEndTagProcessor();

			class NodePredicate implements Predicate<Node> {

				public NodePredicate(Node bag, final String qName) {
					sb.append(getCurrentRelativePath(bag));
					sb.append(qName);
				}

				StringBuilder sb = new StringBuilder();

				@Override
				public boolean apply(Node node) {

					/**
					 * Skip an computedIn nodes as they are local and not matched as part of the semantics
					 */

					return isMatch(sb.toString(), node);
				}

				void pushNode(Node node) {
					sb.insert(0, node.getLocation() + "/");
				}
			}

			private String getDirectText(org.w3c.dom.Node node) {
				StringBuilder text = new StringBuilder();
				NodeList children = node.getChildNodes();
				for (int i = 0; i < children.getLength(); i++) {
					org.w3c.dom.Node child = children.item(i);
					if (child.getNodeType() == org.w3c.dom.Node.TEXT_NODE) {
						text.append(child.getTextContent());
					}
				}
				return text.toString().trim();
			}

			public static Stack<String> extractElementsFromXPath(String xpath) {
				if (xpath == null || xpath.isEmpty())
					return new Stack<>();

				// Clean up XPath
				String cleaned = xpath.replaceAll("\\[", "/").replaceAll("\\]", "");
				cleaned = cleaned.replaceAll("=['\"].*?['\"]", ""); // remove comparison

				String[] parts = cleaned.split("/+");

				// Create Stack
				Stack<String> stack = new Stack<>();
				List<String> list = Arrays.stream(parts).map(String::trim).filter(s -> !s.isEmpty()).collect(
					Collectors.toList()); // returns mutable list

				Collections.reverse(list);
				list.forEach(stack::push);

				return stack;
			}

			private List<Node> lookForMatch(final String qName) {

				NodePredicate matches = null;
				List<Node> results = new ArrayList<>();

				int depthCtr = 0;
				for (Node currentBag : Lists.reverse(syntaxNodes)) {
					depthCtr++;

					logger.trace("Using MDMI Sytanx Node " + currentBag.getName() + " look For child element " + qName);

					if (results.size() > 0) {
						logger.info("Look for match using after found " + currentBag.getName());
					}

					if (matches == null) {
						matches = new NodePredicate(currentBag, qName);
					}
					// logger.trace("Try node " + matches);

					Iterable<Node> matchingNodes = null;

					matchingNodes = Iterables.filter(currentBag.getNodesByLocation(qName), matches);

					// Iterable<Node>
					Iterator<Node> iterator = matchingNodes.iterator();

					while (iterator.hasNext()) {

						if (!results.isEmpty()) {
							break;
						}

						Node node = iterator.next();

						String expression = "";
						try {
							String path = node.getLocation();

							// logger.trace("path " + path);

							int start = path.indexOf("[");
							int end = node.getLocation().lastIndexOf("]");
							if (start > -1 && end > -1) {

								expression = path.substring(start + 1, end);

								if (xPath == null) {
									xPath = XPathFactory.newInstance().newXPath();

									logger.debug("XPATH VERSION IS " + xPath.getClass().getCanonicalName());
									URL location = xPath.getClass().getResource(
										'/' + xPath.getClass().getName().replace('.', '/') + ".class");
									logger.debug("XPATH JAR IS " + location.getFile());

									NamespaceContext ctx = new NamespaceContext() {
										public String getNamespaceURI(String prefix) {
											if ("xsi".equals(prefix)) {
												return "http://www.w3.org/2001/XMLSchema-instance";
											}
											return null;
										}

										public String getPrefix(String uri) {
											throw new UnsupportedOperationException();
										}

										public Iterator getPrefixes(String uri) {
											throw new UnsupportedOperationException();
										}
									};

									xPath.setNamespaceContext(ctx);
								}
								try {

									if (!xPathExpressions.containsKey(expression)) {
										logger.trace("cache expression " + expression);
										XPathExpression xxxx = xPath.compile(expression);
										xPathExpressions.put(expression, xxxx);
									}
									org.w3c.dom.Node p = null;

									/*
									 * for performance reasons - use clone node wiht children
									 * unless the XPATH is relative to sibling node
									 *
									 */
									if (expression.contains("..")) {
										p = domNodes.peek();
									} else {
										p = domNodes.peek().cloneNode(false);

										String directText = getDirectText(domNodes.peek());
										if (!directText.isEmpty()) {
											p.setTextContent(directText);
										}

										// Extract elements from XPath expression
										Stack<String> expressions = extractElementsFromXPath(expression);

										org.w3c.dom.Node currentSource = domNodes.peek();
										org.w3c.dom.Node currentTarget = p;
										boolean foundAll = true;

										while (!expressions.isEmpty() && foundAll) {
											String elementName = expressions.pop();
											boolean found = false;

											NodeList children = currentSource.getChildNodes();
											for (int i = 0; i < children.getLength(); i++) {
												org.w3c.dom.Node child = children.item(i);
												if (elementName.contains(child.getNodeName())) {
													currentSource = child;
													org.w3c.dom.Node childClone = child.cloneNode(false);

													String childText = getDirectText(currentSource);
													if (!childText.isEmpty()) {
														childClone.setTextContent(childText);
													}

													currentTarget.appendChild(childClone);
													currentTarget = childClone;
													found = true;
													break;
												}
											}

											if (!found) {
												foundAll = false;
											}
										}

									}

									/*
									 * Attempt to limit evaluations because they are expensive
									 *
									 * do not skip if not @
									 * if @ set skip to true until you find an attribute value that is in the exxpression
									 */
									boolean skip = false;
									boolean foundSimple = false;
									if (expression.startsWith("@")) {
										skip = true;
										for (int attributeCtr = 0; attributeCtr < p.getAttributes().getLength(); attributeCtr++) {
											String theValue = p.getAttributes().item(attributeCtr).getNodeValue();
											String nodeName = p.getAttributes().item(attributeCtr).getNodeName();
											if (expression.contains(theValue) && expression.contains(nodeName)) {
												skip = false;
												// check for simple
												String[] xxx = expression.split("'");
												if (xxx.length == 2 && theValue.equals(xxx[1])) {
													foundSimple = true;
												}
												break;
											}
										}
									}
									if (skip) {
										continue;
									}
									Boolean isMatch = (foundSimple
											? Boolean.TRUE
											: (Boolean) xPathExpressions.get(expression).evaluate(
												p, XPathConstants.BOOLEAN));

									/**
									 * @TODO Fix bug with xsi type
									 *       XPath boolean expressions using xsi:type are not returning true
									 */
									if (!isMatch) {
										if (expression.startsWith("@xsi:type")) {
											String[] expressionArray = expression.split("=");
											if (expressionArray.length == 2) {
												String value = expressionArray[1].replaceAll("'", "");
												for (int aactr = 0; aactr < p.getAttributes().getLength(); aactr++) {
													if (value.equals(p.getAttributes().item(aactr).getNodeValue())) {
														isMatch = true;
														break;
													}
												}

											}

										}
									}

									if (isMatch) {

										results.add(node);
										logger.trace("Found Syntax Node " + path + "  using " + currentBag.getName());
									}
								} catch (Exception e) {
									NodeList nodes = (NodeList) xPath.evaluate(
										expression, domNodes.peek(), XPathConstants.NODESET);
									if (nodes.getLength() > 0) {
										results.add(node);
									}
								}
							} else {
								results.add(node);
								logger.trace(" Found Syntax Node " + path + "  using " + currentBag.getName());
							}
						} catch (XPathExpressionException ex) {
							logger.error("Expression Error " + expression + ex.getMessage());
						}

					}
					// logger.trace("pushing bag" + currentBag.getName());
					matches.pushNode(currentBag);

					/**
					 * @TODO - Set depthctr at model level
					 */
					if (results.size() > 0 || depthCtr > 0) {
						break;
					}

					// logger.info("results " + results.size());
				}
				if (logger.isWarnEnabled() && !results.isEmpty() && results.size() > 1) {
					for (Node n : results) {
						logger.warn(
							"Warning multiple matched elements " + getFullPathForNode(n) + " to " +
									(n.getSemanticElement() != null
											? n.getSemanticElement().getName()
											: "NO SEMANTIC ELEMENT"));
					}
				}

				return results;
			}

			public static String getXPath(org.w3c.dom.Node node) {
				if (node == null) {
					return null;
				}

				// If it's the document node
				if (node.getNodeType() == org.w3c.dom.Node.DOCUMENT_NODE) {
					return "/";
				}

				StringBuilder path = new StringBuilder();

				while (node != null && node.getNodeType() != org.w3c.dom.Node.DOCUMENT_NODE) {
					int index = getNodeIndex(node);
					String nodeName = node.getNodeName();

					// Add position only if there are siblings with the same name
					if (index > 1) {
						path.insert(0, "/" + nodeName + "[" + index + "]");
					} else {
						path.insert(0, "/" + nodeName);
					}

					node = node.getParentNode();
				}

				return path.toString();
			}

			private static int getNodeIndex(org.w3c.dom.Node node) {
				int index = 1;
				org.w3c.dom.Node prevSibling = node.getPreviousSibling();
				while (prevSibling != null) {
					if (prevSibling.getNodeType() == node.getNodeType() &&
							prevSibling.getNodeName().equals(node.getNodeName())) {
						index++;
					}
					prevSibling = prevSibling.getPreviousSibling();
				}
				return index;
			}

			public static Document createDocumentFromNode(org.w3c.dom.Node node) throws Exception {
				if (node == null) {
					throw new IllegalArgumentException("Node cannot be null");
				}

				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document newDoc = builder.newDocument();

				org.w3c.dom.Node importedNode = newDoc.importNode(node, true); // deep copy
				newDoc.appendChild(importedNode);

				return newDoc;
			}

			/**
			 * Converts a Document (or Node) to a formatted XML String.
			 */
			public static String toXmlString(org.w3c.dom.Node node) throws Exception {
				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer transformer = tf.newTransformer();

				transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty(OutputKeys.METHOD, "xml");
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

				StringWriter writer = new StringWriter();
				transformer.transform(new DOMSource(node), new StreamResult(writer));
				return writer.toString();
			}

			private String getAttributeValue(Attributes attributes, String attribute) {

				for (int i = 0; i < attributes.getLength(); i++) {
					if (attribute.equals(attributes.getQName(i))) {
						return attributes.getValue(i);
					}
				}

				return null;

			}

			private YNode getYBagForParentNode(Node matchingSyntaxNode) {

				Node currentParent = matchingSyntaxNode.getParentNode();
				boolean foundSyntaxNode = false;
				int index = 0;
				while (!foundSyntaxNode && currentParent != null) {
					index = 0;
					for (Node syntaxNode : syntaxNodes) {
						if (currentParent.equals(syntaxNode)) {
							foundSyntaxNode = true;
							break;
						}
						index++;
					}
					if (!foundSyntaxNode) {
						currentParent = currentParent.getParentNode();
					}
				}

				if (!foundSyntaxNode) {
					index = 0;
				}

				return yBags.get(index);
			}

			/*
			 * Processing Steps Syntax node should always be a bag (or a choice) If
			 * current syntax node is a bag and matching node is a bag and semantic
			 * element is a container - push corresponding node If current syntax
			 * node is a bag and matching node is a LST, create YNode and parse
			 */

			boolean prune = false;

			private boolean skipfirst = true;

			String unspecifiedXPath = "";

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {

				if (prune || this.skipfirst) {
					this.skipfirst = false;
					return;
				}

				List<Node> matchingSyntaxNodes = lookForMatch(qName);

				if (matchingSyntaxNodes.isEmpty() && !localName.equals(qName)) {
					matchingSyntaxNodes = lookForMatch(localName);
				}

				if (matchingSyntaxNodes.isEmpty()) {

					Bag b = (Bag) this.syntaxNodes.peek();

					StringBuilder sb = new StringBuilder();
					sb.append(getCurrentRelativePath(b));
					sb.append(qName);

					boolean isTruelyOrphan = true;
					for (Node m : b.getNodes()) {

						String[] path = m.getLocation().split("\\[");

						if (!sb.toString().equals(path[0])) {
							// System.err.println("Relative Node " + sb.toString());
							// System.err.println("Child Node " + path[0]);
							isTruelyOrphan = false;
							break;
						}
					}
					if (isTruelyOrphan) {
						try {

							String result = this.syntaxNodes.stream().map(Node::getName).collect(
								Collectors.joining(", ", "[", "]"));
							org.w3c.dom.Node x = domNodes.peek();

							arrayList.add(
								new UnspecifiedNode(
									qName, toXmlString(createDocumentFromNode(x)), getXPath(x), result,
									b.getNodes().stream().map(Node::getLocation).collect(Collectors.toList())));

							prune = true;
							org.w3c.dom.Node xxx = domNodes.peek();
							logger.trace("Unspecificed Content found at model node " + result);
							logger.trace("Start Unspecificed Content at " + getXPath(xxx));
							unspecifiedXPath = getXPath(xxx);
							// endTags.push(notFoundEndTagProcessor);

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

				Node matchingSyntaxNode = null;

				if (!matchingSyntaxNodes.isEmpty()) {
					int longestPath = 0;
					for (Node n : matchingSyntaxNodes) {
						if (n.getLocation() != null && n.getLocation().length() >= longestPath) {
							longestPath = n.getLocation().length();
							matchingSyntaxNode = n;
						}

					}
					// matchingSyntaxNode = matchingSyntaxNodes.get(0);
					if (isParsing && builder != null) {
						builder = null;
					}
				} else {

					if (isParsing && builder != null) {
						builder.append("<" + localName);

						for (int i = 0; i < attributes.getLength(); i++) {

							builder.append(" " + attributes.getQName(i) + "=\"" + attributes.getValue(i) + "\" ");

						}

						builder.append(">");
					}
				}

				if (matchingSyntaxNode != null) {

					logger.trace("Start Processing Matched Element Content " + qName);

					YNode parentYBag = getYBagForParentNode(matchingSyntaxNode);

					if (matchingSyntaxNode instanceof Bag) {
						YBag y = new YBag((Bag) matchingSyntaxNode, parentYBag);
						parentYBag.addYNode(y);
						syntaxNodes.push(matchingSyntaxNode);
						endTags.push(bagEndTagProcessor);
						for (Node n : ((Bag) matchingSyntaxNode).getNodes()) {
							if (n.getLocation().startsWith("@")) {
								String attributeValue = getAttributeValue(attributes, n.getLocation().substring(1));

								if (n instanceof LeafSyntaxTranslator && attributeValue != null) {
									YLeaf aLeaf = new YLeaf((LeafSyntaxTranslator) n, y);
									aLeaf.setValue(attributeValue);
									y.addYNode(aLeaf);
								}

							} else if (n.getLocation().equals(".")) {
								// YLeaf aLeaf = new YLeaf((LeafSyntaxTranslator) n, y);

								bagEndTagProcessor.currentMixedLeaf = new YLeaf((LeafSyntaxTranslator) n, y);
								// currentYLeaf = new YLeaf((LeafSyntaxTranslator) n, y);
								y.addYNode(bagEndTagProcessor.currentMixedLeaf);

								isParsing = true;

								if (builder == null) {
									builder = new StringBuilder();
								}

								// endTags.push(textEndProcessor);

							}

						}
						yBags.push(y);
					}

					if (matchingSyntaxNode instanceof Choice) {

						Choice aChoice = (Choice) matchingSyntaxNode;

						YChoice y = new YChoice((Choice) matchingSyntaxNode, parentYBag);
						parentYBag.addYNode(y);

						syntaxNodes.push(aChoice);
						endTags.push(bagEndTagProcessor);
						yBags.push(y);

						String choiceType = getAttributeValue(attributes, "xsi:type");

						for (Node choiceNode : aChoice.getNodes()) {
							if (choiceNode.getLocation() != null && choiceNode.getLocation().contains(choiceType)) {
								if (choiceNode instanceof Bag) {
									// YBag y2 = new YBag((Bag) choiceNode, y);
									// y.addYNode(y2);

									syntaxNodes.pop();
									syntaxNodes.push(choiceNode);
									YBag y2 = new YBag((Bag) choiceNode, y);
									y.addYNode(y2);

									for (Node attributeNode : ((Bag) choiceNode).getNodes()) {
										if (attributeNode.getLocation().startsWith("@")) {
											String attributeValue = getAttributeValue(
												attributes, attributeNode.getLocation().substring(1));
											if (attributeNode instanceof LeafSyntaxTranslator &&
													attributeValue != null) {
												YLeaf aLeaf = new YLeaf((LeafSyntaxTranslator) attributeNode, y2);
												aLeaf.setValue(attributeValue);
												y2.addYNode(aLeaf);
											}
										}
									}
								}

								if (choiceNode instanceof LeafSyntaxTranslator) {

									// syntaxNodes.push(aChoice);

									bagEndTagProcessor.currentMixedLeaf = new YLeaf(
										(LeafSyntaxTranslator) choiceNode, y);
									// currentYLeaf = new YLeaf((LeafSyntaxTranslator) n, y);
									y.addYNode(bagEndTagProcessor.currentMixedLeaf);

									isParsing = true;

									if (builder == null) {
										builder = new StringBuilder();
									}

								}

							}
						}

					}

					if (matchingSyntaxNode instanceof LeafSyntaxTranslator) {

						if (matchingSyntaxNode.getLocation().startsWith("@")) {

							/*
							 * Loop over all the matches - this supports maps with multiple syntax nodes with
							 */
							for (Node attributeMatches : matchingSyntaxNodes) {
								String[] locationSegments = attributeMatches.getLocation().split("/@");
								if (locationSegments.length > 1) {
									String attributeValue = getAttributeValue(attributes, locationSegments[1]);
									logger.trace(attributeValue);
									if (attributeValue != null) {
										YLeaf aLeaf = new YLeaf((LeafSyntaxTranslator) attributeMatches, parentYBag);
										aLeaf.setValue(attributeValue);
										parentYBag.addYNode(aLeaf);
									}
								}
							}

							pushXPath(syntaxNodes.peek(), qName);
							endTags.push(notFoundEndTagProcessor);

						} else {
							currentYLeaf = new YLeaf((LeafSyntaxTranslator) matchingSyntaxNode, parentYBag);
							parentYBag.addYNode(currentYLeaf);

							isParsing = true;
							if (builder == null) {
								builder = new StringBuilder();
							}

							endTags.push(leafEndTagProcessor);
						}

					}

				} else {
					pushXPath(syntaxNodes.peek(), qName);
					endTags.push(notFoundEndTagProcessor);
				}

				logger.trace("End Processing Matched Element Content " + qName);

			}

			/**
			 * EndTagProcessor is function object definition to support end tag functionality
			 *
			 *
			 *
			 */
			abstract class EndTagProcessor {
				abstract boolean process();
			}

			class BagEndTagProcessor extends EndTagProcessor {

				public YLeaf currentMixedLeaf = null;

				@Override
				boolean process() {
					syntaxNodes.pop();
					yBags.pop();
					isActive = false;
					if (currentMixedLeaf != null && builder != null) {
						currentMixedLeaf.setValue(builder.toString());
						builder = null;
						isParsing = false;
					}

					currentMixedLeaf = null;
					return true;

				}

			}

			class NotFoundEndTagProcessor extends EndTagProcessor {

				@Override
				boolean process() {
					popXPath(syntaxNodes.peek());
					isActive = false;
					return true;

				}

			}

			class LeafEndTagProcessor extends EndTagProcessor {

				@Override
				boolean process() {
					if (isParsing && currentYLeaf != null) {
						if (builder != null && builder.length() > 0) {
							currentYLeaf.setValue(builder.toString());
						}
						builder = null;
						isParsing = false;
						return true;
					}
					isActive = false;
					return false;

				}

			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {

				if (!prune) {
					if (!endTags.isEmpty()) {
						EndTagProcessor etp = endTags.pop();
						etp.process();
					}
					if (isParsing && builder != null) {
						builder.append("</" + localName + ">");
					}
				}

				if (prune && !domNodes.isEmpty()) {

					String result = getXPath(lastPop);
					if (this.unspecifiedXPath.equals(result)) {
						prune = false;

						logger.trace("End Unspecificed Content at " + result);

						if (!endTags.isEmpty()) {
							EndTagProcessor etp = endTags.pop();
							etp.process();
						}
					}

				}

			}

		};

		DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();

		// df.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		// df.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
		DocumentBuilder b = df.newDocumentBuilder();

		org.w3c.dom.Document doc;
		try {
			doc = b.parse(new ByteArrayInputStream(data));
			InternalTreeWalker treeWalker = new MDMITreeWalker(mdmiHandler);
			treeWalker.traverse(doc.getDocumentElement());
		} catch (

		IOException ex) {

		}

	}

	public String getXPath(org.w3c.dom.Node node) {
		return getXPath(node, "");
	}

	public String getXPath(org.w3c.dom.Node node, String xpath) {
		if (node == null) {
			return "";
		}
		String elementName = "";
		if (node instanceof Element) {
			elementName = node.getLocalName();
		}
		org.w3c.dom.Node parent = node.getParentNode();
		if (parent == null) {
			return xpath;
		}
		return getXPath(parent, "/" + elementName + xpath);
	}

	String getFullPathForNode(Node n) {
		if (n.getParentNode() == null) {
			return n.getLocation();
		} else {
			return getFullPathForNode(n.getParentNode()) + "/" + n.getLocation();
		}
	}

	@Override
	public ISyntaxNode parse(MessageModel mdl, MdmiMessage msg) {
		if (mdl == null || msg == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		byte[] data = msg.getData();
		if (data == null) {
			return null; // <---- NOTE message can be empty
		}

		YNode yroot = null;
		try {
			MessageSyntaxModel syn = mdl.getSyntaxModel();
			Node node = syn.getRoot();
			yroot = new YBag((Bag) node, null);
			saxParse((YBag) yroot, data, msg.getUnspecifiedNodes());
		} catch (MdmiException ex) {
			throw ex;
		} catch (Exception ex) {
			logger.error("Syntax.parse(): unexpected exception", ex);

			throw new MdmiException(ex, "Syntax.parse(): unexpected exception");
		}

		return yroot;
	}

	@Override
	public void serialize(MessageModel mdl, MdmiMessage msg, ISyntaxNode yroot, String transformComment) {
		if (mdl == null || msg == null || yroot == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		try {
			MessageSyntaxModel syn = mdl.getSyntaxModel();
			Node node = syn.getRoot();
			if (node != yroot.getNode()) {
				throw new MdmiException(
					"Invalid serialization attempt, expected node {0} forund node {1}", node.getName(),
					yroot.getNode().getName());
			}
			String nodeName = location(node); // for the root node it is its name
			msg.getData();
			XmlParser pppp = new XmlParser();
			Document doc = null;
			Element root = null;

			// if (data == null) {
			doc = pppp.newDocument();

			logger.trace("create node " + nodeName);
			root = doc.createElement(nodeName);

			if ("CDAR2".equals(messageGroupName)) {
				namespace(root, null, "urn:hl7-org:v3");
				namespace(root, "xsi", "http://www.w3.org/2001/XMLSchema-instance");
				namespace(root, "cda", "urn:hl7-org:v3");
				namespace(root, "sdtc", "urn:hl7-org:sdtc");
			}

			doc.appendChild(root);

			if (!StringUtils.isEmpty(transformComment)) {
				String[] comments = transformComment.split(System.getProperty("line.separator"));
				for (String comment : comments) {
					// org.w3c.dom.Comment comment = ;
					root.getParentNode().insertBefore(doc.createComment(comment), root);
				}

			}

			if (node instanceof Bag) {
				serializeBag((YBag) yroot, root);
			} else if (node instanceof Choice) {
				serializeChoice((YChoice) yroot, root);
			} else {
				serializeLeaf((YLeaf) yroot, root);
			}
			msg.setData(format(doc).getBytes());
		} catch (MdmiException ex) {
			throw ex;
		} catch (Exception ex) {

			throw new MdmiException(ex, "Syntax.serialize(): unexpected exception");
		}
	}

	public String format(Document document) {

		DOMImplementationRegistry registry;
		try {
			registry = DOMImplementationRegistry.newInstance();
			DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
			LSSerializer writer = impl.createLSSerializer();

			LSOutput lsOutput = impl.createLSOutput();
			lsOutput.setEncoding("UTF-8");
			Writer stringWriter = new StringWriter();
			lsOutput.setCharacterStream(stringWriter);
			writer.getDomConfig().setParameter("format-pretty-print", true);
			writer.write(document, lsOutput);
			String str = stringWriter.toString();
			return str;
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (ClassCastException e) {
		}

		return "";

		// try {
		// TransformerFactory tf = TransformerFactory.newInstance();
		// Transformer trans = tf.newTransformer();
		// StringWriter sw = new StringWriter();
		// trans.transform(new DOMSource(document), new StreamResult(sw));
		// return sw.toString();
		// } catch (TransformerException e) {
		// // TODO Auto-generated catch block
		//
		// }
		//
		// // DOMImplementationRegistry registry;
		// // try {
		// // registry = DOMImplementationRegistry.newInstance();
		// // DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
		// // LSSerializer writer = impl.createLSSerializer();
		// //
		// // LSOutput lsOutput = impl.createLSOutput();
		// // lsOutput.setEncoding("UTF-8");
		// // Writer stringWriter = new StringWriter();
		// // lsOutput.setCharacterStream(stringWriter);
		// // writer.getDomConfig().setParameter("format-pretty-print", true);
		// // writer.write(document, lsOutput);
		// // String str = stringWriter.toString();
		// // return str;
		// // } catch (ClassNotFoundException e) {
		// // } catch (InstantiationException e) {
		// // } catch (IllegalAccessException e) {
		// // } catch (ClassCastException e) {
		// // }
		// //
		// return "";
	}

	/**
	 * Serialize a YBag to the given root element.
	 *
	 * @param yroot
	 *            The bag node to serialize.
	 * @param root
	 *            The node to store it into.
	 */
	int indent = 0;

	private void serializeBag(YBag yroot, Element root) {
		serialize(yroot, root);
	}

	private void serialize(YBag bag, Element element) {

		LinkedList<YNode> ynodes = bag.getYNodes();

		Comparator<YNode> compare = new Comparator<>() {

			@Override
			public int compare(YNode o1, YNode o2) {
				Integer i1;
				Integer i2;
				try {
					if (!StringUtils.isEmpty(o1.getNode().getDescription()) &&
							StringUtils.isNumeric(o1.getNode().getDescription())) {
						i1 = Integer.valueOf(o1.getNode().getDescription());
					} else {
						i1 = Integer.valueOf(999);
					}
				} catch (Throwable t) {
					i1 = Integer.valueOf(999);
				}
				try {
					if (!StringUtils.isEmpty(o2.getNode().getDescription()) &&
							StringUtils.isNumeric(o2.getNode().getDescription())) {
						i2 = Integer.valueOf(o2.getNode().getDescription());
					} else {
						i2 = Integer.valueOf(999);
					}
				} catch (Throwable t) {
					i2 = Integer.valueOf(999);
				}
				return i1.compareTo(i2);
			}
		};

		try {
			Collections.sort(ynodes, compare);
		} catch (IllegalArgumentException iae) {
			logger.error(iae.getMessage() + " Invalid Descriptions used for sort");
		}

		// TODO - This loop maintains the physical order of serialization of the syntax mode
		// Replace with more effective loop
		logger.trace("serialize " + element.toString());
		// for (Node node : bag.getBag().getNodes()) {
		for (YNode ynode : ynodes) {
			Node node = ynode.getNode();

			// if (ynode.getNode().equals(node)) {
			if (ynode.isBag()) {
				boolean isContainer = false;
				if (node.getSemanticElement() != null && node.getSemanticElement().getDatatype() != null) {
					if ("Container".equals(node.getSemanticElement().getDatatype().getName())) {
						isContainer = true;
					}
				}

				if (node.getMaxOccurs() != 1) {
					isContainer = true;
				}
				try {
					logger.trace(
						"IsContainer " + ynode.getNode().getLocation() + " == " + isContainer + "  " +
								node.getMaxOccurs());
					Element childElement = (Element) createElement(element, ynode.getNode().getLocation(), isContainer);

					serialize((YBag) ynode, childElement);
				} catch (java.lang.ClassCastException cce) {

				}
			} else if (ynode.isChoice()) {

				try {
					Element childElement = (Element) createElement(element, ynode.getNode().getLocation(), false);
					YChoice yc = (YChoice) ynode;

					for (YNode fgh : yc.getChildren()) {
						serialize((YBag) fgh, childElement);
					}

					// serialize((YBag) ynode, childElement);
				} catch (java.lang.ClassCastException cce) {

				}

			} else if (ynode.isLeaf()) {

				YLeaf yleaf = (YLeaf) ynode;
				String value = yleaf.getValue();
				logger.trace("LEAF Value" + value);

				/*
				 * TODO FIX!!! Passing in a default of true - ynode.getNode().getMaxOccurs() != 1 is not working
				 * All data type attributes are returning 0..1 regardless of the model
				 * The createElement handles attributes but could have other unforseen issues
				 *
				 */

				/*
				 * treatAsContainer - If the leaf node has a "/" in its definition, combine all "/" of similiar types with a element
				 * node.getMaxOccurs != 1
				 * we set treat as container to false - this will cause the createElement process to search for existing elements before
				 * creating new ones
				 * SWM
				 *
				 */
				boolean treatAsContainer = true;

				if (ynode.getNode().getLocation().contains("/") && ynode.getNode().getMaxOccurs() == 1) {
					treatAsContainer = false;
				}

				org.w3c.dom.Node xmlNode = createElement(
					element, (ynode.getNode().getOriginalLocation() != null
							? ynode.getNode().getOriginalLocation()
							: ynode.getNode().getLocation()),
					treatAsContainer);

				if (xmlNode.getNodeType() == org.w3c.dom.Node.ATTRIBUTE_NODE) {
					Attr o = (Attr) xmlNode;
					o.setTextContent(value);
				} else if (xmlNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
					Element o = (Element) xmlNode;
					if (value != null) {
						XmlUtil.setText(o, value);
					}
				} else if (xmlNode.getNodeType() == org.w3c.dom.Node.TEXT_NODE) {
					Text o = (Text) xmlNode;
					o.setTextContent(value);
				}
			}
			// }
			// }

		}

	}

	/**
	 * Serialize a YChoice to the given root element.
	 *
	 * @param yroot
	 *            The choice node to serialize.
	 * @param root
	 *            The node to store it into.
	 */
	private void serializeChoice(YChoice yroot, Element root) {
		Node node = yroot.getChosenNode();
		String xpath = location(node);
		ArrayList<YNode> ynodes = yroot.getYNodes();
		for (int j = 0; j < ynodes.size(); j++) {
			if (node instanceof LeafSyntaxTranslator) {
				YLeaf y = (YLeaf) ynodes.get(j);
				setValue(root, xpath, y, j);
			} else if (node instanceof Bag) {
				YBag y = (YBag) ynodes.get(j);
				setBag(root, xpath, y, j);
			} else if (node instanceof Choice) {
				YChoice y = (YChoice) ynodes.get(j);
				setChoice(root, xpath, y, j);
			}
		}
	}

	/**
	 * Serialize a YLeaf to the given root element. Only called for the root leaf
	 * (boundary case).
	 *
	 * @param yroot
	 *            The leaf node to serialize.
	 * @param root
	 *            The node to store it into.
	 */
	private void serializeLeaf(YLeaf yroot, Element root) {
		LeafSyntaxTranslator rootLeaf = yroot.getLeaf();
		String xpath = location(rootLeaf);
		setValue(root, xpath, yroot, 0);
	}

	/**
	 * Set the values from the given YBag into the specified xpath relative to
	 * the given node.
	 *
	 * @param root
	 *            The root XML element relative to which we serialize.
	 * @param xpath
	 *            The XPath to store it at, relative root the root element.
	 * @param ybag
	 *            The YBag containing the values to store.
	 * @param yindex
	 *            The index of the ynode to store, used when having multiple
	 *            instances of ybag.
	 */
	private void setBag(Element root, String xpath, YBag ybag, int yindex) {
		if (xpath == null || xpath.length() <= 0) {
			serializeBag(ybag, root); // mapped to content
		} else {
			org.w3c.dom.Node xmlNode = XslUtil.createNodeForPath(root, xpath, yindex);
			if (xmlNode == null || xmlNode.getNodeType() != org.w3c.dom.Node.ELEMENT_NODE) {
				throw new MdmiException(
					"Invalid xpath expression {0} for element {1}, ybag {2}", xpath, root.getNodeName(),
					ybag.toString());
			}
			Element e = (Element) xmlNode;
			serializeBag(ybag, e);
		}
	}

	/**
	 * Set the values from the given YChoice into the specified xpath relative to
	 * the given node.
	 *
	 * @param root
	 *            The root XML element relative to which we serialize.
	 * @param xpath
	 *            The XPath to store it at, relative root the root element.
	 * @param ychoice
	 *            The YChoice containing the values to store.
	 * @param yindex
	 *            The index of the ynode to store
	 */
	private void setChoice(Element root, String xpath, YChoice ychoice, int yindex) {
		if (xpath == null || xpath.length() <= 0) {
			serializeChoice(ychoice, root); // mapped to content
		} else {
			org.w3c.dom.Node xmlNode = XslUtil.createNodeForPath(root, xpath, yindex);
			if (xmlNode == null || xmlNode.getNodeType() != org.w3c.dom.Node.ELEMENT_NODE) {
				throw new MdmiException(
					"Invalid xpath expression {0} for element {1}, ychoice {2}", xpath, root.getNodeName(),
					ychoice.toString());
			}
			Element e = (Element) xmlNode;
			serializeChoice(ychoice, e);
		}
	}

	/**
	 * Set one value (from the given YLeaf) into the specified xpath relative to
	 * the given node. The xpath can be: text()
	 *
	 * @attrName elementName elementName/text() elementName[2]
	 *           elementName[2]/text() elementName@attrName elementName[3]@attrName
	 *           element1/element2...
	 *
	 * @param root
	 *            The root XML element relative to which we serialize.
	 * @param xpath
	 *            The XPath to store it at, relative root the root element.
	 * @param yleaf
	 *            The YLeaf containing the value to store.
	 * @param yindex
	 *            The index of the ynode to store
	 */
	private void setValue(Element root, String xpath, YLeaf yleaf, int yindex) {
		String value = yleaf.getValue();
		logger.trace("Create for " + root.getNodeName() + "  --- " + xpath);
		org.w3c.dom.Node xmlNode = XslUtil.createNodeForPath(root, xpath, yindex);

		if (xmlNode.getNodeType() == org.w3c.dom.Node.ATTRIBUTE_NODE) {
			Attr o = (Attr) xmlNode;
			o.setTextContent(value);
		} else if (xmlNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
			Element o = (Element) xmlNode;
			XmlUtil.setText(o, value);
		} else if (xmlNode.getNodeType() == org.w3c.dom.Node.TEXT_NODE) {
			Text o = (Text) xmlNode;
			o.setTextContent(value);
		} else {
			throw new MdmiException(
				"Invalid XML node type for xpath expression {0} for element {1}, yleaf {2}: {3}", xpath,
				root.getNodeName(), yleaf.toString(), xmlNode.getNodeType());
		}
	}

	/**
	 * Get the node location (XPath) name based on the Node.location in the
	 * model. This field can be empty, and it is normally an XPath expression,
	 * such as "elem@attr", etc.
	 *
	 * @param node
	 *            The node.
	 * @return The node location as an XPath expression.
	 */
	static String location(Node node) {
		String location = node.getLocation();
		if (location == null || location.trim().length() <= 0) {
			return null;
		}
		return location.trim();
	}

	/**
	 * Get the model path to the given node.
	 *
	 * @param node
	 *            The node.
	 * @return The path (XPath) to this node.
	 */
	static String getNodePath(Node node) {
		Node parent = node.getParentNode();
		String name = node.getLocation();
		if (parent == null) {
			return name;
		}
		String p = getNodePath(parent);
		if (name.startsWith("@")) {
			return p + name;
		}
		return p + '/' + name;
	}

	protected void namespace(Element element, String prefix, String uri) {
		String qname;
		if ("".equals(prefix) || prefix == null) {
			qname = "xmlns";
		} else {
			qname = "xmlns:" + prefix;
		}

		// older version of Xerces (I confirmed that the bug is gone with Xerces 2.4.0)
		// have a problem of re-setting the same namespace attribute twice.
		// work around this bug removing it first.
		if (element.hasAttributeNS("http://www.w3.org/2000/xmlns/", qname)) {
			// further workaround for an old Crimson bug where the removeAttribtueNS
			// method throws NPE when the element doesn't have any attribute.
			// to be on the safe side, check the existence of attributes before
			// attempting to remove it.
			// for details about this bug, see org.apache.crimson.tree.ElementNode2
			// line 540 or the following message:
			// https://jaxb.dev.java.net/servlets/ReadMsg?list=users&msgNo=2767
			element.removeAttributeNS("http://www.w3.org/2000/xmlns/", qname);
		}
		// workaround until here

		element.setAttributeNS("http://www.w3.org/2000/xmlns/", qname, uri);
	}
} // DefaultMdmiSyntaxParser
