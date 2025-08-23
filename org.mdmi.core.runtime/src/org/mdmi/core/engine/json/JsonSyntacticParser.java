/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.ContentHandler;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mdmi.Bag;
import org.mdmi.LeafSyntaxTranslator;
import org.mdmi.MessageModel;
import org.mdmi.MessageSyntaxModel;
import org.mdmi.Node;
import org.mdmi.core.ISyntacticParser;
import org.mdmi.core.ISyntaxNode;
import org.mdmi.core.MdmiException;
import org.mdmi.core.MdmiMessage;
import org.mdmi.core.engine.YBag;
import org.mdmi.core.engine.YChoice;
import org.mdmi.core.engine.YLeaf;
import org.mdmi.core.engine.YNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @TODO Move runtime to One JSON library (GSON ???)
 * @author seanmuir
 *
 */
public class JsonSyntacticParser implements ISyntacticParser {

	private static Logger logger = LoggerFactory.getLogger(JsonSyntacticParser.class);

	class JsonHandler implements ContentHandler {

		private Stack<Node> syntaxNodes = new Stack<>();

		private Stack<YBag> yBags = new Stack<>();

		private Stack<String> keyStack = new Stack<>();

		YBag yroot = null;

		/**
		 * @param node
		 */
		public JsonHandler(Node node) {
			syntaxNodes.push(node);
		}

		public void startJSON() throws ParseException, IOException {
			logger.trace("startJSON()");

			if (syntaxNodes.peek().getMaxOccurs() != 1) {
				Bag root = (Bag) this.syntaxNodes.peek();

				yroot = new YBag(root, null);

				yBags.push(yroot);

				syntaxNodes.push(root.getNodes().get(0));

			}
		}

		boolean end = false;

		public void endJSON() throws ParseException, IOException {
			logger.trace("endJSON()");
			end = true;
		}

		private String liftFromValue(String value, String expression) {
			String[] params = expression.split(",");
			int results = StringUtils.countMatches(value.toString(), params[1]);
			if (results >= Integer.valueOf(params[0])) {
				return value.split(params[1])[Integer.valueOf(params[0])];
			} else {
				return null;
			}
		}

		public boolean primitive(Object value) throws ParseException, IOException {
			logger.trace("primitive(Object value) " + value);
			if (node != null) {

				if (node.getLocation().contains("[")) {

					if (value != null && !StringUtils.isEmpty(value.toString())) {
						for (Node matchingNode : nodes) {
							int start = matchingNode.getLocation().indexOf("[");
							int end = matchingNode.getLocation().lastIndexOf("]");
							if (start > -1 && end > -1) {
								String expression = matchingNode.getLocation().substring(start + 1, end);
								String theValue = liftFromValue(value.toString(), expression);

								if (!StringUtils.isEmpty(theValue)) {
									YBag parentYBag = yBags.peek();
									YLeaf leaf = new YLeaf((LeafSyntaxTranslator) matchingNode, parentYBag);
									parentYBag.addYNode(leaf);
									leaf.setValue(theValue.toString());
								}

							} else {
								if (value != null && !StringUtils.isEmpty(value.toString())) {
									YBag parentYBag = yBags.peek();
									YLeaf leaf = new YLeaf((LeafSyntaxTranslator) matchingNode, parentYBag);
									parentYBag.addYNode(leaf);
									leaf.setValue(value.toString());
								}

							}
						}
					}

				} else {

					if (this.syntaxNodes.peek() instanceof LeafSyntaxTranslator) {
						/**
						 * @TODO Modify logic to allow for some maps to process nulls
						 */
						if (value != null && !StringUtils.isEmpty(value.toString())) {
							YBag parentYBag = yBags.peek();
							YLeaf leaf = new YLeaf((LeafSyntaxTranslator) this.syntaxNodes.peek(), parentYBag);
							parentYBag.addYNode(leaf);
							leaf.setValue(value.toString());
						}
					} else {
						yBags.peek();
						this.syntaxNodes.peek();
					}
				}
			}

			return true;
		}

		public boolean startArray() throws ParseException, IOException {
			logger.trace("startArray()");
			return true;
		}

		boolean skipFirst = false;

		public boolean startObject() throws ParseException, IOException {
			logger.trace("startObject()");
			if (skipFirst) {
				skipFirst = false;
				return true;
			}
			YBag parentYBag = null;
			if (!yBags.isEmpty()) {
				parentYBag = yBags.peek();
			}

			logger.trace("create YBag for " + syntaxNodes.peek().getName());

			if (this.syntaxNodes.peek() instanceof Bag) {

				YBag y = new YBag((Bag) this.syntaxNodes.peek(), parentYBag);
				if (parentYBag != null) {
					parentYBag.addYNode(y);
				}

				if (yroot == null) {
					yroot = y;
				}

				yBags.push(y);

			} else {
				logger.error("error parsing");
			}

			return true;
		}

		// Node matchingSyntaxNode = null;

		Stack<Boolean> shouldPop = new Stack<>();

		private Node getSyntaxNode(String key) {
			Bag bag = (Bag) syntaxNodes.peek();
			nodes = bag.getNodesByLocation(key);
			if (!nodes.isEmpty()) {
				return nodes.get(0);
			}
			return null;
		}

		Node node = null;

		ArrayList<Node> nodes = null;

		public boolean startObjectEntry(String key) throws ParseException, IOException {

			logger.trace("startObjectEntry(String key)" + key);

			keyStack.push(key);

			node = getSyntaxNode(key);

			logger.trace(
				"startObjectEntry(String key)" + (node != null
						? node.getLocation()
						: "null"));

			if (node != null) {
				syntaxNodes.push(node);
			}

			return true;
		}

		public boolean endArray() throws ParseException, IOException {
			logger.trace("endArray()");
			return true;
		}

		public boolean endObject() throws ParseException, IOException {

			if (!yBags.isEmpty()) {
				yBags.pop();
			}

			logger.trace("endObject()");
			return true;
		}

		public boolean endObjectEntry() throws ParseException, IOException {

			String key = keyStack.pop();
			logger.trace("endObjectEntry()" + key);

			/**
			 * @TODO Need to have better way to track syntax nodes
			 *
			 */
			if (!syntaxNodes.isEmpty()) {
				Node n = syntaxNodes.peek();
				if (!StringUtils.isEmpty(n.getLocation())) {
					String simplelocation = n.getLocation().split("\\[")[0];
					if (simplelocation.equals(key)) {
						syntaxNodes.pop();
					}
				}
			}

			return true;
		}

		/**
		 * @return
		 */
		public boolean isEnd() {

			return end;
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.ISyntacticParser#parse(org.mdmi.model.MessageModel,
	 * org.mdmi.MdmiMessage)
	 */
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
			// yroot = new YBag((Bag) node, null);
			long l = System.currentTimeMillis();
			yroot = jsonParse(node, data);
			logger.trace(
				"------ Parse Inbound Message took " + (System.currentTimeMillis() - l) / 1000 + " Seconds ----");
		} catch (MdmiException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MdmiException(ex, "Syntax.parse(): unexpected exception");
		}

		return yroot;

	}

	/**
	 * @param node
	 * @param data
	 * @return
	 */
	private YNode jsonParse(Node node, byte[] data) {

		JSONParser parser = new JSONParser();
		JsonHandler jsonHandler = new JsonHandler(node);

		try {
			while (!jsonHandler.isEnd()) {
				parser.parse(new String(data), jsonHandler, true);
			}
		} catch (ParseException pe) {
			logger.error(pe.getMessage());
			// pe.getMessage()
			// p
		}

		return jsonHandler.yroot;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.ISyntacticParser#serialize(org.mdmi.model.MessageModel,
	 * org.mdmi.MdmiMessage, org.mdmi.ISyntaxNode)
	 */
	@Override
	public void serialize(MessageModel mdl, MdmiMessage msg, ISyntaxNode yroot, String transformComment) {
		if (mdl == null || msg == null || yroot == null) {
			throw new IllegalArgumentException("Null argument!");
		}

		MessageSyntaxModel syn = mdl.getSyntaxModel();
		Node node = syn.getRoot();
		if (node != yroot.getNode()) {
			throw new MdmiException(
				"Invalid serialization attempt, expected node {0} forund node {1}", node.getName(),
				yroot.getNode().getName());
		}

		JSONObject root = new JSONObject();

		if (node instanceof Bag) {
			serializeBag((YBag) yroot, root);
		}

		msg.setData(root.toJSONString().getBytes());

	}

	static String location(Node node) {
		String location = node.getLocation();
		if (location == null || location.trim().length() <= 0) {
			return null;
		}
		return location.trim();
	}

	private void serializeBag(YBag yroot, JSONObject root) {
		serialize(yroot, root);
	}

	private HashMap<Node, ArrayList<YNode>> getHashMap(ArrayList<YNode> ynodes) {

		HashMap<Node, ArrayList<YNode>> nodes = new HashMap<>();

		for (YNode yNode : ynodes) {
			if (!nodes.containsKey(yNode.getNode())) {
				nodes.put(yNode.getNode(), new ArrayList<YNode>());
			}
			nodes.get(yNode.getNode()).add(yNode);
		}

		return nodes;
	}

	static public class Visitor implements org.mdmi.core.engine.YNodeVisitor {

		/**
		 * @param element
		 */
		public Visitor(JSONAware element) {
			super();
			elements.push(element);
			// path.push("");
		}

		Stack<JSONAware> elements = new Stack<>();

		/*
		 * (non-Javadoc)
		 *
		 * @see org.mdmi.engine.YNodeVisitor#visit(org.mdmi.engine.YBag)
		 */
		@Override
		public void visit(YBag ybag) {

			logger.trace("start visit " + ybag.getNode().getName());

			HashMap<String, JSONArray> bagnodes = new HashMap<>();

			for (YNode ynode : ybag.getYNodes()) {
				logger.trace("Check " + ynode.getNode().getName());

				if (!bagnodes.containsKey(ynode.getNode().getName())) {
					JSONArray childElement = null;
					if (ynode.getNode().getMaxOccurs() != 1) {
						logger.trace("create JSONArray " + ynode.getNode().getName());
						childElement = new JSONArray();

					}

					if (childElement == null && ynode.getNode() instanceof Bag) {

						JSONObject foo = new JSONObject();
						// bagnodes.put(ynode.getNode().getName(), foo);
						((JSONObject) elements.peek()).put(ynode.getNode().getLocation(), foo);
						elements.push(foo);

					}

					if (childElement != null) {

						bagnodes.put(ynode.getNode().getName(), childElement);
						((JSONObject) elements.peek()).put(ynode.getNode().getLocation(), childElement);
					}

				}
			}

			for (YNode ynode : ybag.getYNodes()) {
				JSONArray element = bagnodes.get(ynode.getNode().getName());

				if (element != null) {
					JSONObject object = new JSONObject();
					element.add(object);
					elements.push(object);
				} else {

				}

				ynode.accept(this);

				if (element != null) {
					elements.pop();
				}

			}
			logger.trace("end visit " + ybag.getNode().getName());

		}

		/*
		 * (non-Javadoc)
		 *
		 * @see org.mdmi.engine.YNodeVisitor#visit(org.mdmi.engine.YLeaf)
		 */
		@Override
		public void visit(YLeaf yleaf) {
			if (yleaf.getValue() != null) {
				logger.trace("leaf" + yleaf.getNode().getName() + " " + yleaf.getValue());
				JSONObject jsonObject = (JSONObject) elements.peek();
				if (yleaf.getNode().getSemanticElement() != null &&
						yleaf.getNode().getSemanticElement().getDatatype() != null) {
					if ("Decimal".equals(yleaf.getNode().getSemanticElement().getDatatype().getName())) {
						jsonObject.put(yleaf.getNode().getName(), Double.parseDouble(yleaf.getValue()));
						return;
					}
				}

				jsonObject.put(yleaf.getNode().getName(), yleaf.getValue());
			}
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see org.mdmi.engine.YNodeVisitor#visit(org.mdmi.engine.YChoice)
		 */
		@Override
		public void visit(YChoice ychoice) {
		}

	}

	@SuppressWarnings("unchecked")
	private void serialize(YBag bag, JSONAware element) {
		Visitor v = new Visitor(element);
		bag.accept(v);
	}
}
