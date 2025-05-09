/*******************************************************************************
 * Copyright (c) 2016 MDIX Software, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     MDIX Software, Inc.. - Refactored from Default Semantic Parser
 *
 * Author:
 *    Sean Muir
 *
 * SimplifiedSemanticParser - as it names suggests - has simplified and streamlined some of the
 * MDMI functions to support the CDA mapping requirements
 *
 *  In particular the use of Semantic Containers and limiting the use of Local Semantic Containers to being
 *  a cardinality of 1
 *
 *******************************************************************************/
package org.mdmi.core.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.lang3.tuple.Pair;
import org.json.simple.JSONObject;
import org.mdmi.Bag;
import org.mdmi.Choice;
import org.mdmi.DTCChoice;
import org.mdmi.DTCStructured;
import org.mdmi.DTExternal;
import org.mdmi.DTSDerived;
import org.mdmi.DTSEnumerated;
import org.mdmi.DTSPrimitive;
import org.mdmi.EnumerationLiteral;
import org.mdmi.Field;
import org.mdmi.LeafSyntaxTranslator;
import org.mdmi.MDMIDatatype;
import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.mdmi.Node;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementRelationship;
import org.mdmi.SemanticElementSet;
import org.mdmi.SemanticElementType;
import org.mdmi.core.ElementValueSet;
import org.mdmi.core.IElementValue;
import org.mdmi.core.ISemanticParser;
import org.mdmi.core.ISyntaxNode;
import org.mdmi.core.MdmiException;
import org.mdmi.core.MdmiUtil;
import org.mdmi.impl.MDMIPackageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimplifiedSemanticParser implements ISemanticParser {

	private static Logger logger = LoggerFactory.getLogger(SimplifiedSemanticParser.class);

	private static Map<String, SemanticInterpreter> semanticRollupInterpreters = new HashMap<>();

	private static String parseFunctionName(String rule) {

		String[] content = rule.split(":");

		if (content.length == 2) {
			return content[1];
		} else {
			return "invalidfunctionmapping";
		}
	}

	MessageGroup sourceMessageGroup = null;

	private ElementValueSet valueSet;

	/**
	 * @param messageGroup
	 */
	public SimplifiedSemanticParser(MessageGroup messageGroup) {
		this.sourceMessageGroup = messageGroup;
	}

	@Override
	public void buildSemanticModel(MessageModel mdl, ISyntaxNode yroot, ElementValueSet eset, Properties properties,
			JSONObject values) {

		if (mdl == null || yroot == null || eset == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		valueSet = eset;
		Node root = mdl.getSyntaxModel().getRoot();
		if (root != yroot.getNode()) {
			throw new MdmiException(
				"Invalid root node, expected {0}, found {1}.", root.getName(), (yroot.getNode() == null
						? "null"
						: yroot.getNode().getName()));
		}

		List<XElementValue> initalElements = new ArrayList<>();
		if (values != null) {
			initalElements.addAll(setInitialValues(mdl, values));
		}

		// 1. create all XElementValues
		getElements((YNode) yroot);

		// 2. set relationships
		List<IElementValue> xes = valueSet.getAllElementValues();
		for (IElementValue xe : xes) {
			setRelations((XElementValue) xe);
		}

		// 3. set computed SEs
		SemanticElementSet set = mdl.getElementSet();
		Collection<SemanticElement> ses = set.getSemanticElements();
		for (SemanticElement se : ses) {

			if (se.isComputed() && !se.isNullFlavor()) {
				setComputedValue(se, eset, properties);
			} else if (se.isComputedOut()) {
				if (se.getParent() != null) {
					List<IElementValue> elements = eset.getElementValuesByType(se.getParent());
					for (IElementValue element : elements) {
						setComputedOutValue(se, properties, element);
					}
				} else {
					setComputedOutValue(se, properties, null);
				}
			}
		}

		for (IElementValue elementValue : this.valueSet.getAllElementValues()) {

			if (elementValue.getParent() == null && !initalElements.contains(elementValue)) {

				for (IElementValue intialElement : initalElements) {
					intialElement.setParent(elementValue);
					elementValue.addChild(intialElement);

				}

			}

		}
	}

	/**
	 * @param sourceMessageGroup
	 */

	@Override
	public ISyntaxNode createNewSyntacticModel(MessageModel mdl, ElementValueSet eset, Properties properties) {
		Node root = mdl.getSyntaxModel().getRoot();
		if (root.getMinOccurs() != 1 || root.getMaxOccurs() != 1) {
			logger.error("Invalid mapping for root node  " + MdmiUtil.getNodePath(root));
		}
		YNode yroot = createYNode(root);
		updateSyntacticModel(mdl, eset, yroot, properties);
		return yroot;
	}

	// ==================================================================================================================
	// create top-level root node
	private YNode createYNode(Node node) {
		if (node instanceof Bag) {
			return new YBag((Bag) node, null);
		}
		if (node instanceof Choice) {
			return new YChoice((Choice) node, null);
		}
		return new YLeaf((LeafSyntaxTranslator) node, null);
	}

	/**
	 * Ensure the child of the specified parent exists, at the given index.
	 * Return the ynode at the given index. Will create it if necessary.
	 *
	 * @param parent
	 *            The parent ynode.
	 * @param node
	 *            The child type.
	 * @param index
	 *            The index of the child in the parent children of the same type.
	 * @return The ynode at the requested index (may be creating it if need be).
	 */
	private YNode ensureYNodeExists(YNode parent, Node node, int index) {
		YNode ynode = null;
		if (parent instanceof YBag) {
			YBag ybag = (YBag) parent;
			if (node instanceof Bag) {
				Bag bag = (Bag) node;
				List<YNode> ynodes = ybag.getYNodesForNode(bag);
				while (ynodes.size() <= index) {
					ynode = new YBag(bag, ybag);
					ybag.addYNode(ynode);
					ynodes = ybag.getYNodesForNode(bag);
				}
				return ynodes.get(index);
			} else if (node instanceof Choice) {
				Choice choice = (Choice) node;
				List<YNode> ynodes = ybag.getYNodesForNode(choice);
				while (ynodes.size() <= index) {
					ynode = new YChoice(choice, ybag);
					ybag.addYNode(ynode);
					ynodes = ybag.getYNodesForNode(choice);
				}
				return ynodes.get(index);
			} else {
				LeafSyntaxTranslator leaf = (LeafSyntaxTranslator) node;
				List<YNode> ynodes = ybag.getYNodesForNode(leaf);
				while (ynodes.size() <= index) {
					ynode = new YLeaf(leaf, ybag);
					ybag.addYNode(ynode);
					ynodes = ybag.getYNodesForNode(leaf);
				}
				return ynodes.get(index);
			}

		} else if (parent instanceof YChoice) {
			YChoice ychoice = (YChoice) parent;
			if (node instanceof Bag) {
				Bag bag = (Bag) node;
				if (ychoice.getChosenNode() != bag) {
					ychoice.forceChoice(null);
				}
				ArrayList<YNode> ynodes = ychoice.getYNodes();
				while (ynodes.size() <= index) {
					ynode = new YBag(bag, ychoice);
					ychoice.addYNode(ynode);
					ynodes = ychoice.getYNodes();
				}
				return ynodes.get(index);
			} else if (node instanceof Choice) {
				Choice choice = (Choice) node;
				if (ychoice.getChosenNode() != choice) {
					ychoice.forceChoice(null);
				}
				ArrayList<YNode> ynodes = ychoice.getYNodes();
				while (ynodes.size() <= index) {
					ynode = new YChoice(choice, ychoice);
					ychoice.addYNode(ynode);
					ynodes = ychoice.getYNodes();
				}
				return ynodes.get(index);
			} else {
				LeafSyntaxTranslator leaf = (LeafSyntaxTranslator) node;
				if (ychoice.getChosenNode() != leaf) {
					ychoice.forceChoice(null);
				}
				ArrayList<YNode> ynodes = ychoice.getYNodes();
				while (ynodes.size() <= index) {
					ynode = new YLeaf(leaf, ychoice);
					ychoice.addYNode(ynode);
					ynodes = ychoice.getYNodes();
				}
				return ynodes.get(index);
			}

		} else {
			throw new IllegalArgumentException("Invalid state: parent is a leaf!");
		}
	}

	private void getChoiceElement(YChoice ychoice, XElementValue owner) {

		ychoice.getChoice();

		for (YNode y : ychoice.getYNodes()) {

			if (y.getNode().getSemanticElement() != null) {
				getMappedElement(y, owner);
			}

		}

	}

	private void getChoiceElement(YChoice ychoice, XElementValue owner, ElementValueSet eset) {
		SemanticElement me = ychoice.getChoice().getSemanticElement();
		if (me == null) {
			throw new IllegalArgumentException(
				"Missing Semantic Elements for " + MdmiUtil.getNodePath(ychoice.getNode()));
		}
		XElementValue xe = new XElementValue(me, eset);
		if (owner != null) {
			// set parent-child relationship
			owner.addChild(xe);
		}

		// set the value
		MDMIDatatype dt = me.getDatatype();
		if (!dt.isChoice()) {
			throw new MdmiException(
				"Invalid mapping for node cccc {0}, expected datatype choice, found {1}.",
				MdmiUtil.getNodePath(ychoice.getNode()), dt.toString());
		}

		try {
			XDataChoice xc = new XDataChoice(xe.getXValue());
			xe.getXValue().addValue(xc);

			ArrayList<YNode> yns = ychoice.getYNodes();
			for (YNode yn : yns) {
				Node n = yn.getNode();
				if (n.getSemanticElement() != null) {
					// the choice has only child elements
					for (YNode yyn : yns) {
						getMappedElement(yyn, xe, eset);
					}
					break; // we found the choice
				} else {
					// the choice has only fields
					String fieldName = n.getFieldName();
					if (null != fieldName) {
						// if fieldName is null it means it is
						XValue xv = xc.setXValue(fieldName);
						for (YNode yyn : yns) {
							getValue(yyn, xv, xe, eset);
						}
						break; // we found the choice
					}
					// try the next node if this was no match
				}
			}
		} catch (Throwable throwable) {
			throw new MdmiException(throwable, "Error proccessing node " + MdmiUtil.getNodePath(ychoice.getNode()));
		}
	}

	private MDMIDatatype getDatatype(Node node) {
		ArrayList<String> fns = new ArrayList<>();
		Node n = node;
		while (n.getSemanticElement() == null) {
			fns.add(0, n.getFieldName());
			n = n.getParentNode();
		}

		MDMIDatatype dt = n.getSemanticElement().getDatatype();
		for (int i = 0; i < fns.size(); i++) {
			String fieldName = fns.get(i);
			Field f = null;
			if (dt.isStruct()) {
				DTCStructured dts = (DTCStructured) dt;
				f = dts.getField(fieldName);
			} else if (dt.isChoice()) {
				DTCChoice dtc = (DTCChoice) dt;
				f = dtc.getField(fieldName);
			}
			if (f == null) {
				throw new MdmiException("Invalid construct for node " + MdmiUtil.getNodePath(node));
			}
			dt = f.getDatatype();
		}
		return dt;
	}

	private void getElements(YNode yroot) {
		Node node = yroot.getNode();

		SemanticElement me = node.getSemanticElement();
		if (me == null) {
			// node is not mapped to an element or field (one of the top nodes)
			if (yroot instanceof YBag) {
				YBag y = (YBag) yroot;
				LinkedList<YNode> yns = y.getYNodes();
				for (YNode yn : yns) {
					getElements(yn);
				}
			} else if (yroot instanceof YChoice) {
				YChoice y = (YChoice) yroot;
				ArrayList<YNode> yns = y.getYNodes();
				for (YNode yn : yns) {
					getElements(yn);
				}
			}
			// else we have a not-mapped Leaf, we ignore it
		} else {
			// top node is mapped to an element, no owner
			getMappedElement(yroot, null);
		}
	}

	String getFullPathForNode(Node n) {
		if (n.getParentNode() == null) {
			return n.getLocation();
		} else {
			return getFullPathForNode(n.getParentNode()) + "/" + n.getLocation();
		}
	}

	private void getMappedElement(YNode yroot, XElementValue owner) {
		if (yroot.isLeaf()) {
			getSimpleElement((YLeaf) yroot, owner);
		} else if (yroot.isChoice()) {
			getChoiceElement((YChoice) yroot, owner);
		} else if (yroot.isBag()) { // Bag
			getStructElement((YBag) yroot, owner);
		} else {
			throw new IllegalArgumentException("Invalid YNode!");
		}
	}

	private void getMappedElement(YNode yroot, XElementValue owner, ElementValueSet eset) {
		if (yroot.isLeaf()) {
			getSimpleElement((YLeaf) yroot, owner, eset);
		} else if (yroot.isChoice()) {
			getChoiceElement((YChoice) yroot, owner, eset);
		} else if (yroot.isBag()) { // Bag
			getStructElement((YBag) yroot, owner, eset);
		} else {
			throw new IllegalArgumentException("Invalid YNode!");
		}
	}

	SemanticElement getNormalContainer(SemanticElement se) {

		if (se.getSemanticElementType().equals(SemanticElementType.NORMAL)) {
			return se;
		} else {
			if (se.getParent() != null) {
				if (se.getParent() != null &&
						se.getParent().getSemanticElementType().equals(SemanticElementType.NORMAL)) {
					return se.getParent();
				} else {
					return getNormalContainer(se.getParent());
				}
			}
		}
		return null;

	}

	void getPath(Stack<Node> bags, Node container, Node child) {

		if (child == null || container == null) {
			return;
		}
		bags.push(child);
		if (child.getParentNode() != null && container != null && !container.equals(child.getParentNode())) {
			getPath(bags, container, child.getParentNode());
		}
	}

	SemanticElement getRoot(SemanticElement child) {
		if (child.getParent() == null) {
			return child;
		} else {
			return getRoot(child.getParent());
		}
	}

	private SemanticInterpreter getSemanticInterpreter() {
		String key = sourceMessageGroup.getName() + "__SEMANTICINTERPRETER__" +
				sourceMessageGroup.getModels().get(0).getMessageModelName();
		if (!semanticRollupInterpreters.containsKey(key)) {
			semanticRollupInterpreters.put(key, new SemanticInterpreter(sourceMessageGroup));
		}

		return semanticRollupInterpreters.get(key);
	}

	// a leaf mapped to a simple type (must be simple)
	private void getSimpleElement(YLeaf yleaf, XElementValue owner) {
		SemanticElement me = yleaf.getLeaf().getSemanticElement();
		if (me == null) {
			throw new MdmiException("Null SE for node {0}", MdmiUtil.getNodePath(yleaf.getNode()));
		}
		XElementValue xe = new XElementValue(me, valueSet);
		if (owner != null) {
			if (!xe.getSemanticElement().getParent().getName().equals(owner.getSemanticElement().getName())) {
				XElementValue inject = new XElementValue(me.getParent(), valueSet);
				inject.addChild(xe);
				owner.addChild(inject);
			} else {
				owner.addChild(xe);
			}
		}

		// set the value
		MDMIDatatype dt = me.getDatatype();
		if (!(dt.isSimple() || dt.isExternal())) {
			// dt.isSimple();
			if ((!"InstanceIdentifier".equals(dt.getName())) && (!"Telecom".equals(dt.getName()))) {
				throw new MdmiException("Invalid mapping for node " + MdmiUtil.getNodePath(yleaf.getNode()));
			}
		}

		try {
			String value = yleaf.getValue();
			String format = yleaf.getLeaf().getFormat();
			XDT xdt = XDT.fromString(format);
			if (dt.isPrimitive()) {
				DTSPrimitive pdt = (DTSPrimitive) dt;
				if (xdt == null) {
					xdt = XDT.fromPDT(pdt);
				}
				Object o = XDT.convertFromString(xdt, value, format, pdt);
				xe.getXValue().addValue(o);
			} else if (dt.isDerived()) {
				DTSDerived ddt = (DTSDerived) dt;
				DTSPrimitive pdt = ddt.getPrimitiveBaseType();
				if (xdt == null) {
					xdt = XDT.fromPDT(pdt);
				}
				Object o = XDT.convertFromString(xdt, value, format, pdt);
				xe.getXValue().addValue(o);
			} else if (dt.isExternal()) {
				DTSPrimitive pdt = MDMIPackageImpl.STRING;
				if (xdt == null) {
					xdt = XDT.fromPDT(pdt);
				}
				Object o = XDT.convertFromString(xdt, value, format, pdt);
				xe.getXValue().addValue(o);
				// }
			} else if ("InstanceIdentifier".equals(dt.getName())) {
				XDataStruct xs = new XDataStruct(xe.getXValue(), true);
				xs.setValueSafely("extension", value);
				xe.getXValue().addValue(xs);
			} else if ("Telecom".equals(dt.getName())) {
				XDataStruct xs = new XDataStruct(xe.getXValue(), true);
				xs.setValueSafely("value", value);
				xe.getXValue().addValue(xs);

			} else {
				DTSEnumerated edt = (DTSEnumerated) dt;
				EnumerationLiteral el = edt.getLiteralByCode(value);
				xe.getXValue().addValue(el);
			}
		} catch (Throwable throwable) {
			throw new MdmiException("Error proccessing node " + MdmiUtil.getNodePath(yleaf.getNode()), throwable);
		}
	}

	// a leaf mapped to a simple type (must be simple)
	private void getSimpleElement(YLeaf yleaf, XElementValue owner, ElementValueSet eset) {
		SemanticElement me = yleaf.getLeaf().getSemanticElement();
		if (me == null) {
			throw new MdmiException("Null SE for node {0}", MdmiUtil.getNodePath(yleaf.getNode()));
		}
		XElementValue xe = new XElementValue(me, eset);
		if (owner != null) {
			// set parent-child relationship
			owner.addChild(xe);
		}

		// set the value
		MDMIDatatype dt = me.getDatatype();
		if (!(dt.isSimple() || dt.isExternal())) {
			throw new MdmiException("Invalid mapping for node bbbb " + MdmiUtil.getNodePath(yleaf.getNode()));
		}

		try {
			String value = yleaf.getValue();
			String format = yleaf.getLeaf().getFormat();
			XDT xdt = XDT.fromString(format);
			if (dt.isPrimitive()) {
				DTSPrimitive pdt = (DTSPrimitive) dt;
				if (xdt == null) {
					xdt = XDT.fromPDT(pdt);
				}
				Object o = XDT.convertFromString(xdt, value, format, pdt);
				xe.getXValue().addValue(o);
			} else if (dt.isDerived()) {
				DTSDerived ddt = (DTSDerived) dt;
				DTSPrimitive pdt = ddt.getPrimitiveBaseType();
				if (xdt == null) {
					xdt = XDT.fromPDT(pdt);
				}
				Object o = XDT.convertFromString(xdt, value, format, pdt);
				xe.getXValue().addValue(o);
			} else if (dt.isExternal()) {
				DTExternal dte = (DTExternal) dt;
				String uri = dte.getTypeSpec();
				if (uri != null) {
					// Object o = Mdmi.INSTANCE().getExternalResolvers().getDictionaryValue(dte, value);
					// xe.getXValue().addValue(o);
				} else {
					DTSPrimitive pdt = MDMIPackageImpl.STRING;
					if (xdt == null) {
						xdt = XDT.fromPDT(pdt);
					}
					Object o = XDT.convertFromString(xdt, value, format, pdt);
					xe.getXValue().addValue(o);
				}
			} else {
				DTSEnumerated edt = (DTSEnumerated) dt;
				EnumerationLiteral el = edt.getLiteralByCode(value);
				xe.getXValue().addValue(el);
			}
		} catch (Throwable throwable) {
			throw new MdmiException("Error proccessing node " + MdmiUtil.getNodePath(yleaf.getNode()), throwable);
		}
	}

	private void getStructElement(YBag ybag, XElementValue owner) {
		SemanticElement me = ybag.getBag().getSemanticElement();
		if (me == null) {
			throw new IllegalArgumentException("Missing Semantic Elements for " + MdmiUtil.getNodePath(ybag.getNode()));
		}
		XElementValue xe = new XElementValue(me, valueSet);
		if (owner != null) {
			// set parent-child relationship
			owner.addChild(xe);
		}

		// set the value
		MDMIDatatype dt = me.getDatatype();
		if (dt == null || !dt.isStruct()) {
			return;
		}

		try {
			XDataStruct xs = new XDataStruct(xe.getXValue(), true);
			xe.getXValue().addValue(xs);

			LinkedList<YNode> yns = ybag.getYNodes();
			for (YNode yn : yns) {

				Node n = yn.getNode();
				if (n.getSemanticElement() != null) {
					// child element
					getMappedElement(yn, xe);
				} else if (yn instanceof YChoice) {
					getMappedElement(yn, xe);
				} else {
					// field
					Stack<Node> nodes = new Stack<>();
					Node currentNode = n;

					while (currentNode != null && currentNode.getSemanticElement() == null) {
						nodes.push(currentNode);
						currentNode = currentNode.getParentNode();
					}

					String fieldName = n.getFieldName();
					if (fieldName == null) {
						continue; // will ignore it for now, assuming unmapped syntax node
					}
					XValue xv = null;
					while (!nodes.isEmpty()) {
						Node nn = nodes.pop();
						if (xv != null && xv.getValue() != null) {
							try {
								xv = ((XDataStruct) xv.getValue()).getXValue(nn.getFieldName());
							} catch (ClassCastException cce) {

							}

						} else {
							if (nn.getFieldName() != null) {
								xv = xs.getXValue(nn.getFieldName());
							}
						}

					}

					if (xv != null) {
						getValue(yn, xv, xe);
					}
				}
			}
		} catch (

		Throwable throwable) {

			throw new MdmiException(
				throwable,
				"Error proccessing node " + me.getName() + " at location " + MdmiUtil.getNodePath(ybag.getNode()));
		}
	}

	private void getStructElement(YBag ybag, XElementValue owner, ElementValueSet eset) {
		SemanticElement me = ybag.getBag().getSemanticElement();
		if (me == null) {
			throw new IllegalArgumentException("Missing Semantic Elements for " + MdmiUtil.getNodePath(ybag.getNode()));
		}
		XElementValue xe = new XElementValue(me, eset);
		if (owner != null) {
			// set parent-child relationship
			owner.addChild(xe);
		}

		// set the value
		MDMIDatatype dt = me.getDatatype();
		if (dt == null || !dt.isStruct()) {
			throw new MdmiException("Invalid mapping for node dddd " + MdmiUtil.getNodePath(ybag.getNode()));
		}

		try {
			XDataStruct xs = new XDataStruct(xe.getXValue());
			xe.getXValue().addValue(xs);

			LinkedList<YNode> yns = ybag.getYNodes();
			for (YNode yn : yns) {
				Node n = yn.getNode();
				if (n.getSemanticElement() != null) {
					// child element
					getMappedElement(yn, xe, eset);
				} else {
					// field
					String fieldName = n.getFieldName();
					if (fieldName == null) {
						continue; // will ignore it for now, assuming unmapped syntax node
					}
					// throw new MdmiException("Field Name is Null " + MdmiUtil.getNodePath(n));
					XValue xv = xs.getXValue(fieldName);
					if (xv == null) {
						throw new MdmiException(
							"Invalid mapping for node eee " + fieldName + " --- for type " +
									xs.getDatatype().getName() + MdmiUtil.getNodePath(ybag.getNode()));
					}
					getValue(yn, xv, xe, eset);
				}
			}
		} catch (Throwable throwable) {
			throw new MdmiException(throwable, "Error proccessing node " + MdmiUtil.getNodePath(ybag.getNode()));
		}
	}

	private void getValue(YNode yroot, XValue xv, XElementValue owner) {
		if (yroot.isLeaf()) {
			getValueLeaf((YLeaf) yroot, xv);
		} else if (yroot.isChoice()) {
			getValueChoice((YChoice) yroot, xv, owner);
		} else if (yroot.isBag()) { // Bag
			getValueStruct((YBag) yroot, xv, owner);
		} else {
			throw new IllegalArgumentException("Invalid YNode!");
		}
	}

	private void getValue(YNode yroot, XValue xv, XElementValue owner, ElementValueSet eset) {
		if (yroot.isLeaf()) {
			getValueLeaf((YLeaf) yroot, xv);
		} else if (yroot.isChoice()) {
			getValueChoice((YChoice) yroot, xv, owner, eset);
		} else if (yroot.isBag()) { // Bag
			getValueStruct((YBag) yroot, xv, owner, eset);
		} else {
			throw new IllegalArgumentException("Invalid YNode!");
		}
	}

	private void getValueChoice(YChoice ychoice, XValue xv, XElementValue owner) {
		MDMIDatatype dt = xv.getDatatype();
		if (!dt.isChoice()) {
			throw new MdmiException("Invalid mapping for node " + MdmiUtil.getNodePath(ychoice.getNode()));
		}
		XDataChoice xc = new XDataChoice(xv);
		xv.addValue(xc);

		ArrayList<YNode> yns = ychoice.getYNodes();
		if (yns.size() > 0) { // otherwise its an empty choice
			YNode yn0 = yns.get(0);
			Node n = yn0.getNode();
			if (n.getSemanticElement() != null) {
				// the choice has only child elements
				for (YNode yn : yns) {
					getMappedElement(yn, owner);
				}
			} else {
				// the choice has only fields
				String fieldName = n.getFieldName();
				XValue xvalue = xc.setXValue(fieldName);
				for (YNode yn : yns) {
					getValue(yn, xvalue, owner);
				}
			}
		}
	}

	private void getValueChoice(YChoice ychoice, XValue xv, XElementValue owner, ElementValueSet eset) {
		MDMIDatatype dt = xv.getDatatype();
		if (!dt.isChoice()) {
			throw new MdmiException("Invalid mapping for node hhh " + MdmiUtil.getNodePath(ychoice.getNode()));
		}
		XDataChoice xc = new XDataChoice(xv);
		xv.addValue(xc);

		ArrayList<YNode> yns = ychoice.getYNodes();
		if (yns.size() > 0) { // otherwise its an empty choice
			YNode yn0 = yns.get(0);
			Node n = yn0.getNode();
			if (n.getSemanticElement() != null) {
				// the choice has only child elements
				for (YNode yn : yns) {
					getMappedElement(yn, owner, eset);
				}
			} else {
				// the choice has only fields
				String fieldName = n.getFieldName();
				XValue xvalue = xc.setXValue(fieldName);
				for (YNode yn : yns) {
					getValue(yn, xvalue, owner, eset);
				}
			}
		}
	}

	private void getValueLeaf(YLeaf yleaf, XValue xv) {
		MDMIDatatype dt = xv.getDatatype();
		if (dt == null || !(dt.isSimple() || dt.isExternal())) {
			return;
		}

		try {
			String value = yleaf.getValue();
			String format = yleaf.getLeaf().getFormat();
			XDT xdt = XDT.fromString(format);
			if (xdt != null) {
				format = null; // null the format so it does not get into the
				// conversions
			}
			if (dt.isPrimitive()) {
				DTSPrimitive pdt = (DTSPrimitive) dt;
				if (xdt == null) {
					xdt = XDT.fromPDT(pdt);
				}
				Object o = XDT.convertFromString(xdt, value, format, pdt);
				xv.addValue(o);
			} else if (dt.isDerived()) {
				DTSDerived ddt = (DTSDerived) dt;
				DTSPrimitive pdt = ddt.getPrimitiveBaseType();
				if (xdt == null) {
					xdt = XDT.fromPDT(pdt);
				}
				Object o = XDT.convertFromString(xdt, value, format, pdt);
				xv.addValue(o);
			} else if (dt.isExternal()) {
				// DTExternal dte = (DTExternal) dt;
				// String uri = dte.getTypeSpec();
				// // if (uri != null) {
				// // Object o = Mdmi.INSTANCE().getExternalResolvers().getDictionaryValue(dte, value);
				// // xv.addValue(o);
				// // } else {
				// DTSPrimitive pdt = MDMIPackageImpl.STRING;
				// if (xdt == null) {
				// xdt = XDT.fromPDT(pdt);
				// }
				// Object o = XDT.convertFromString(xdt, value, format, pdt);
				// xv.addValue(o);
				// // }
			} else {
				DTSEnumerated edt = (DTSEnumerated) dt;
				EnumerationLiteral el = edt.getLiteralByCode(value);
				xv.addValue(el);
			}
		} catch (Throwable throwable) {
			throw new MdmiException("Error proccessing node " + MdmiUtil.getNodePath(yleaf.getNode()), throwable);
		}
	}

	private void getValueStruct(YBag ybag, XValue xv, XElementValue owner) {
		MDMIDatatype dt = xv.getDatatype();
		if (!dt.isStruct()) {
			// throw new MdmiException("Invalid mapping for node " + DefaultSyntacticParser.getNodePath(ybag.getNode()));
			return;
		}
		XDataStruct xs = new XDataStruct(xv);
		xv.addValue(xs);

		LinkedList<YNode> yns = ybag.getYNodes();
		for (YNode yn : yns) {
			Node n = yn.getNode();
			if (n.getSemanticElement() != null) {
				// child element
				getMappedElement(yn, owner);
			} else {
				// field
				String fieldName = n.getFieldName();
				XValue xvalue = xs.getXValue(fieldName);
				if (xvalue == null) {
					throw new MdmiException("Invalid mapping for node " + MdmiUtil.getNodePath(ybag.getNode()));
				}
				getValue(yn, xvalue, owner);
			}
		}
	}

	private void getValueStruct(YBag ybag, XValue xv, XElementValue owner, ElementValueSet eset) {
		MDMIDatatype dt = xv.getDatatype();
		if (!dt.isStruct()) {
			throw new MdmiException("Invalid mapping for node iiii " + MdmiUtil.getNodePath(ybag.getNode()));
		}
		XDataStruct xs = new XDataStruct(xv);
		xv.addValue(xs);

		LinkedList<YNode> yns = ybag.getYNodes();
		for (YNode yn : yns) {
			Node n = yn.getNode();
			if (n.getSemanticElement() != null) {
				// child element
				getMappedElement(yn, owner, eset);
			} else {
				// field
				String fieldName = n.getFieldName();
				XValue xvalue = xs.getXValue(fieldName);
				if (xvalue == null) {
					throw new MdmiException("Invalid mapping for node jjj " + MdmiUtil.getNodePath(ybag.getNode()));
				}
				getValue(yn, xvalue, owner, eset);
			}
		}
	}

	/**
	 * normalizeSemanticContainers - makes sure the appropriate semantic container chain is established
	 * during creation some semantic elements will be owned not by the direct sementic parent container but the grand parent element
	 * because the parent container is not part of the source message mapping
	 *
	 * So walk the children and if the semantic parent does not match the current parent add a new instance and connect the dots
	 *
	 *
	 * @param elementValueSet
	 * @param parent
	 * @param iterator
	 */
	void normalizeSemanticContainers(ElementValueSet elementValueSet, IElementValue parent,
			ListIterator<IElementValue> iterator, HashMap<String, IElementValue> containers) {
		// = new HashMap<>();
		ArrayList<IElementValue> remove = new ArrayList<>();
		for (IElementValue child : parent.getChildren()) {
			if (!child.getSemanticElement().getParent().getName().equals(parent.getSemanticElement().getName())) {
				if (!containers.containsKey(child.getSemanticElement().getParent().getName())) {
					XElementValue x = new XElementValue(
						child.getSemanticElement().getParent(), elementValueSet, iterator);
					containers.put(child.getSemanticElement().getParent().getName(), x);
					parent.addChild(x);
					x.setParent(parent);
				}

				IElementValue targetElementValue = containers.get(child.getSemanticElement().getParent().getName());

				targetElementValue.addChild(child);
				child.setParent(targetElementValue);
				remove.add(child);
			}

		}

		for (IElementValue r : remove) {
			parent.removeChild(r);
		}

	}

	private void setComputedOutValue(SemanticElement se, Properties properties, IElementValue parent) {
		se.getComputedOutValue().getExpression();
		se.getComputedOutValue().getLanguage();
		XElementValue xe = new XElementValue(se, valueSet);
		if (parent != null) {
			xe.setParent(parent);
			parent.addChild(xe);
		}

		getSemanticInterpreter().update(se.getName() + "_COMPUTEDOUT", xe);

	}

	/**
	 *
	 * @implNote Need to revisit the computed value
	 *
	 *           SEMANTICROLLUP
	 *           Simplify option - use a rule such a set field
	 *           Optimize by putting map roll ups into script library
	 *           Support Structure to Structure for roll ups
	 *
	 *
	 * @param se
	 * @param elementValueSet
	 * @param properties
	 */
	@SuppressWarnings("deprecation")
	private void setComputedValue(SemanticElement se, ElementValueSet elementValueSet, Properties properties) {

		String rule = se.getComputedValue().getExpression();
		se.getComputedValue().getLanguage();
		HashMap<IElementValue, ArrayList<IElementValue>> valuesByParent = new HashMap<>();
		HashMap<SemanticElement, String> rulesBySemanticElement = new HashMap<>();

		if (rule.equals("SEMANTICROLLUP")) {
			/*
			 * SEMANTICROLLUP provides a mechanism for multiple local semantic elements be "rolled up" into one normal semantic
			 * element based on semantic relationships
			 * This is currently required for when content is related but syntactically mixed in with other elements
			 * for instance religionCode and religionName are not isolated and the syntax processors do not currently
			 * provide overlapped matching - perhaps supporting more sophisticated matching is required but now this is
			 * an isolated requirement
			 *
			 * <pid>2939;19</pid>
			 * <religionCode>urn:va:pat-religion:99</religionCode>
			 * <religionName>ROMAN CATHOLIC CHURCH</religionName>
			 * <scPercent>0</scPercent>
			 * <sensitive>false</sensitive>
			 * <serviceConnected>true</serviceConnected>
			 *
			 * using StringEscapeUtils.escapeEcmaScript because current apache in eclipse does not have StringEscapeUtils.escapeJavaScript
			 * StringEscapeUtils.escapeEcmaScript is the same as StringEscapeUtils.escapeJava except it encodes single quotes ' to \'
			 *
			 */

			logger.trace("Processing SEMANTICROLLUP " + se.getName());
			// organize data by parent and rules by semantic element
			for (SemanticElementRelationship relationship : se.getRelationships()) {

				logger.trace(
					"Processing SEMANTICROLLUP Relationship " + relationship.getRelatedSemanticElement().getName());
				rulesBySemanticElement.put(relationship.getRelatedSemanticElement(), relationship.getRule());

				if (logger.isTraceEnabled()) {
					if (elementValueSet.getElementValuesByType(relationship.getRelatedSemanticElement()).isEmpty()) {

						logger.trace(
							"Processing SEMANTICROLLUP Relationship No value found for  " +
									relationship.getRelatedSemanticElement().getName());

					}
				}
				if (elementValueSet.hasElementValuesByName(relationship.getRelatedSemanticElement())) {

					for (IElementValue iev2 : elementValueSet.getElementValuesByType(
						relationship.getRelatedSemanticElement())) {

						logger.trace("Walk the elements " + iev2.getName());
						IElementValue theParentForRollup = iev2.getParent();

						logger.trace("theParentForRollup  " + theParentForRollup);
						/*
						 * Loop for the IElementValue parent - this allows for roll ups where the content is not at the same level
						 */
						while ((theParentForRollup != null) && (theParentForRollup.getSemanticElement() != null) &&
								!theParentForRollup.getSemanticElement().getName().equals(se.getParent().getName())) {
							theParentForRollup = theParentForRollup.getParent();
						}

						if (theParentForRollup != null) {
							if (!valuesByParent.containsKey(theParentForRollup)) {
								valuesByParent.put(theParentForRollup, new ArrayList<>());
							}

							valuesByParent.get(theParentForRollup).add(iev2);
						} else {

							// check for root owned
							logger.error("Invalid Semantic Rollup Relationship, no apparent parent " + se.getName());
						}

					}
				}
			}

			logger.trace("Root level parent = null" + valuesByParent.isEmpty());
			if (valuesByParent.isEmpty()) {
				if (se.getParent() == null) {
					logger.trace("Root level parent = null");
				} else {
					logger.trace("Root level parent" + se.getParent());
				}
			}

			/**
			 * @TODO Need to properly define roll up functionality and relationships
			 *
			 *       SCRIPT BASED - Use java script to set values leveraging LOCALSEMANTICVALUE
			 *
			 *       FUNCTION BASED - Use a java function - was added for performance - could be moot if we can compile computed scripts
			 *
			 *       COMPLEX TYPE BASED - Uses field to field
			 *
			 *       CONTAINER BASED - sets the parent container - no manipulation of value
			 *
			 *
			 *
			 */
			// for each parent - create a new element and roll up all the values leveraging the relationship rule
			for (IElementValue parentValue : valuesByParent.keySet()) {
				XElementValue computedInElement = new XElementValue(se, elementValueSet);
				parentValue.addChild(computedInElement);
				computedInElement.setParent(parentValue);
				for (IElementValue rollupValue : valuesByParent.get(parentValue)) {
					// Need a value to process
					if (rollupValue.getXValue().getValue() != null) {
						if (rollupValue.getXValue().getValue() instanceof String) {
							String rollupRule = rulesBySemanticElement.get(rollupValue.getSemanticElement());
							if (!StringUtils.isEmpty(rollupRule)) {
								logger.trace("Setting value to rollup " + (String) rollupValue.getXValue().getValue());
								if (rollupRule.startsWith("SEMANTICROLLUPFUNCTION:")) {
									switch (parseFunctionName(rollupRule)) {
										case "setDocumentHomeId":
											setDocumentHomeId(
												computedInElement, StringEscapeUtils.escapeEcmaScript(
													(String) rollupValue.getXValue().getValue()));
											break;
										case "setRepositoryId":
											setRepositoryId(
												computedInElement, StringEscapeUtils.escapeEcmaScript(
													(String) rollupValue.getXValue().getValue()));
											break;
										case "setDocumentId":
											setDocumentId(
												computedInElement, StringEscapeUtils.escapeEcmaScript(
													(String) rollupValue.getXValue().getValue()));
											break;

										case "setDocumentCode":
											setDocumentCode(
												computedInElement, StringEscapeUtils.escapeEcmaScript(
													(String) rollupValue.getXValue().getValue()));
											break;

									}

								} else {

									getSemanticInterpreter().execute(
										SemanticInterpreter.getFunctionName(rollupValue.getSemanticElement(), se),
										computedInElement, rollupValue.getXValue().getValue());

								}
							}
						} else {
							String rollupRule = rulesBySemanticElement.get(rollupValue.getSemanticElement());
							if (!StringUtils.isEmpty(rollupRule)) {
								/**
								 * The rule currently is a format of fromfield,tofield or field
								 */
								String[] fromto = rollupRule.split(",");
								XValue foo = (XValue) rollupValue.getXValue();
								computedInElement.getXValue().addValue(
									(fromto.length > 1
											? fromto[1]
											: fromto[0]),
									foo.getValueByName(fromto[0]));
							} else {
								logger.trace("Container Rollup");
								rollupValue.setParent(computedInElement);
								logger.trace("Container Rollup" + rollupValue.getSemanticElement().getName());

							}
						}
					}
				}
			}

		} else {

			if (rule.startsWith("UPDATEVALUE:")) {
				if (elementValueSet.hasElementValuesByName(se)) {
					for (IElementValue value : elementValueSet.getElementValuesByName(se)) {
						getSemanticInterpreter().update(se.getName() + "_UPDATEVALUE", value);
					}
				}
			} else {
				if (se.getParent() != null) {

					if (elementValueSet.hasElementValuesByName(se.getParent())) {

						List<IElementValue> elements = elementValueSet.getElementValuesByType(se.getParent());
						for (IElementValue element : elements) {
							XElementValue computedInElement = new XElementValue(se, elementValueSet);
							computedInElement.setParent(element);
							element.addChild(computedInElement);
							getSemanticInterpreter().update(se.getName() + "_COMPUTED", computedInElement);
						}
					}
				}

			}
		}

	}

	private void setDocumentCode(XElementValue computedInElement, String escapeEcmaScript) {
		if (computedInElement.getXValue().getValue() == null) {
			computedInElement.setValue("homeID_##_repositoryUniqueID_##_documentID_##_documentCode");
		}
		String str = (String) computedInElement.getXValue().getValue();
		str = str.replace("documentCode", escapeEcmaScript);
		computedInElement.getXValue().setValue(str);

	}

	/**
	 * @param computedInElement
	 * @param escapeEcmaScript
	 */
	private void setDocumentHomeId(XElementValue computedInElement, String escapeEcmaScript) {
		if (computedInElement.getXValue().getValue() == null) {
			computedInElement.setValue("homeID_##_repositoryUniqueID_##_documentID_##_documentCode");
		}
		String str = (String) computedInElement.getXValue().getValue();
		str = str.replace("homeID", escapeEcmaScript);
		computedInElement.getXValue().setValue(str);
	}

	/**
	 * @param computedInElement
	 * @param escapeEcmaScript
	 */
	private void setDocumentId(XElementValue computedInElement, String escapeEcmaScript) {
		if (computedInElement.getXValue().getValue() == null) {
			computedInElement.setValue("homeID_##_repositoryUniqueID_##_documentID_##_documentCode");
		}
		String str = (String) computedInElement.getXValue().getValue();
		str = str.replace("documentID", escapeEcmaScript);
		computedInElement.getXValue().setValue(str);

	}

	private List<XElementValue> setInitialValues(MessageModel mdl, JSONObject initialValues) {

		List<XElementValue> initalElements = new ArrayList<>();

		try {
			for (Object key : initialValues.keySet()) {
				for (SemanticElement x : mdl.getElementSet().getSemanticElements()) {
					if (key.equals(x.getName())) {
						walkTheValues(mdl, null, initialValues, initalElements);
					}
				}
			}

		} catch (Exception e) {
			logger.error("setInitialValues", e);
		}

		return initalElements;

	}

	private void setLeafValue(YLeaf yleaf, Object value) {
		if (value == null) {
			return;
		}
		Node node = yleaf.getNode();
		MDMIDatatype dt = getDatatype(node);
		if (!(dt.isSimple() || dt.isExternal())) {
			// throw new MdmiException("Invalid mapping for node " + MdmiUtil.getNodePath(yleaf.getNode()));
		}
		try {
			String format = yleaf.getLeaf().getFormat();

			XDT xdt = XDT.fromString(format);
			String v = null;
			if (dt.isPrimitive()) {
				DTSPrimitive pdt = (DTSPrimitive) dt;
				if (xdt == null) {
					xdt = XDT.fromPDT(pdt);
				}
				v = XDT.convertToString(pdt, value, format, xdt);
			} else if (dt.isDerived()) {
				DTSDerived ddt = (DTSDerived) dt;
				DTSPrimitive pdt = ddt.getPrimitiveBaseType();
				if (xdt == null) {
					xdt = XDT.fromPDT(pdt);
				}
				v = XDT.convertToString(pdt, value, format, xdt);
			} else if (dt.isExternal()) {
				// DTExternal dte = (DTExternal) dt;
				// String uri = dte.getTypeSpec();
				// if (uri != null) {
				// v = Mdmi.INSTANCE().getExternalResolvers().getModelValue(dte, value);
				// } else {
				// DTSPrimitive pdt = MDMIPackageImpl.STRING;
				// if (xdt == null) {
				// xdt = XDT.fromPDT(pdt);
				// }
				// v = XDT.convertToString(pdt, value, format, xdt);
				// }
			} else {
				if (value instanceof EnumerationLiteral) {
					v = ((EnumerationLiteral) value).getCode();
				} else if (value instanceof String) {
					v = (String) value;
				} else {
					// throw new MdmiException("Invalid enum conversion for type {0} value {1}", edt.getTypeName(), value);
				}
			}
			yleaf.setValue(v);
		} catch (Throwable throwable) {
			throw new MdmiException("Error proccessing node " + MdmiUtil.getNodePath(yleaf.getNode()), throwable);
		}
	}

	private void setRelations(XElementValue xe) {
		SemanticElement me = xe.getSemanticElement();
		Collection<SemanticElementRelationship> rels = me.getRelationships();
		for (SemanticElementRelationship rel : rels) {
			SemanticElement trg = rel.getRelatedSemanticElement();
			// 1. Check child elements
			if (trg == null) {
				continue;
			}
			List<IElementValue> xevs = valueSet.getChildElementValuesByType(trg, xe);
			if (xevs != null && 0 < xevs.size()) {
				for (IElementValue xev : xevs) {
					xe.addRelation(rel.getName(), xev);
				}
				return;
			}
			// 2. Check child elements of the owner
			xevs = valueSet.getOwnerElementValuesByType(trg, xe);
			if (xevs != null && 0 < xevs.size()) {
				for (IElementValue xev : xevs) {
					xe.addRelation(rel.getName(), xev);
				}
				return;
			}
			// 3. Last resort: get all
			xevs = valueSet.getElementValuesByType(trg);
			for (IElementValue xev : xevs) {
				xe.addRelation(rel.getName(), xev);
			}
		}
	}

	/**
	 * @param computedInElement
	 * @param escapeEcmaScript
	 */
	private void setRepositoryId(XElementValue computedInElement, String escapeEcmaScript) {
		if (computedInElement.getXValue().getValue() == null) {
			computedInElement.setValue("homeID_##_repositoryUniqueID_##_documentID_##_documentCode");
		}
		String str = (String) computedInElement.getXValue().getValue();
		str = str.replace("repositoryUniqueID", escapeEcmaScript);
		computedInElement.getXValue().setValue(str);

	}

	// set the node value(s) for all fields
	private void setYNodeValues(YNode ynode, Object value) {
		if (value == null) {
			return;
		}
		Node node = ynode.getNode();
		if (node instanceof Bag) {
			if (!(value instanceof XDataStruct)) {
				/**
				 * @TODO
				 *       The XValue,etc do not support an array of structures - so pop the value from the value
				 */
				if (value instanceof XValue) {
					XValue xValue = (XValue) value;
					setYNodeValuesForBag((YBag) ynode, xValue.getXDataStruct());
				} else {
					logger.error(
						"Invalid map: expected XDataStruct for node " + ynode.getNode().getName() + " : " +
								MdmiUtil.getNodePath(ynode.getNode()) + value.toString());
				}
			} else {
				setYNodeValuesForBag((YBag) ynode, (XDataStruct) value);
			}

		} else if (node instanceof Choice) {
			if (!(value instanceof XDataChoice)) {
				throw new IllegalArgumentException(
					"Invalid map: expected XDataChoice for node " + ynode.getNode().getName() + " : " +
							MdmiUtil.getNodePath(ynode.getNode()));
			}
			setYNodeValuesForChoice((YChoice) ynode, (XDataChoice) value);
		} else { // Leaf
			setLeafValue((YLeaf) ynode, value);
		}
	}

	private void setYNodeValuesForBag(YBag ybag, XDataStruct xds) {
		if (xds.getXValues().size() <= 0) {
			return; // nothing to set
		}
		Node node = ybag.getNode();
		Bag bag = (Bag) node;
		Collection<Node> nodes = bag.getNodes();
		for (Iterator<Node> it = nodes.iterator(); it.hasNext();) {
			Node n = it.next();

			// if (n instanceof Bag) {
			//
			// }
			String fieldName = n.getFieldName();
			if (fieldName == null) {
				continue;
			}
			XValue xvalue = xds.getXValue(fieldName);

			if (xvalue == null || xvalue.size() <= 0) {
				continue;
			}

			for (int i = 0; i < xvalue.size(); i++) {
				Object xv = xvalue.getValue(i);
				YNode yn = ensureYNodeExists(ybag, n, i);
				setYNodeValues(yn, xv);
			}

		}
	}

	private void setYNodeValuesForChoice(YChoice ychoice, XDataChoice xdc) {
		if (xdc.getXValue() == null) {
			return;
		}
		XValue xvalue = xdc.getXValue();
		if (xvalue != null && xvalue.size() > 0) {
			Node sel = ychoice.getChoice().getNode(xvalue.getName());
			for (int i = 0; i < xvalue.size(); i++) {
				Object xv = xvalue.getValue(i);
				YNode yn = ensureYNodeExists(ychoice, sel, i);
				setYNodeValues(yn, xv);
			}
		}
	}

	@Override
	public void updateSyntacticModel(MessageModel mdl, ElementValueSet elementValueSet, ISyntaxNode yr,
			Properties properties) {

		StopWatch watch = new StopWatch();
		watch.start();
		logger.trace("Start updateSyntacticModel ");

		if (mdl == null || elementValueSet == null || yr == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		YNode yroot = (YNode) yr;

		// Locate the root semantic element
		SemanticElement rootSemantic = null;
		for (IElementValue elementValue : elementValueSet.getAllElementValues()) {
			if (elementValue.getSemanticElement() != null) {
				rootSemantic = getRoot(elementValue.getSemanticElement());
			}
			if (rootSemantic != null) {
				break;
			}
		}

		if (rootSemantic == null) {
			logger.error("NO RootElement Found ");
			return;
		}

		HashMap<String, XElementValue> fillInTheBlanks = new HashMap<>();

		logger.trace("Root Semantic Element " + rootSemantic.getName());

		watch.split();
		logger.trace("Set up: " + watch.toSplitString());

		for (IElementValue rootElementValue : elementValueSet.getElementValuesByName(rootSemantic)) {
			fillInTheBlanks.put(rootSemantic.getName(), (XElementValue) rootElementValue);
		}

		watch.split();
		logger.trace("fillInTheBlanks: " + watch.toSplitString());

		// update all semantic containment

		ListIterator<IElementValue> iterator = elementValueSet.getAllElementValues().listIterator();

		while (iterator.hasNext()) {
			IElementValue value = iterator.next();
			if (value.getParent() == null) {
				logger.trace("ORPHAN ELEMENT " + value.getSemanticElement().getName());
				Stack<SemanticElement> path = new Stack<>();
				SemanticElement currentParent = value.getSemanticElement().getParent();
				while (currentParent != null) {
					path.push(currentParent);
					currentParent = currentParent.getParent();
				}
				IElementValue currentValueParent = null;
				while (!path.isEmpty()) {
					SemanticElement current = path.pop();
					logger.trace("PATH " + current.getName());
					if (!fillInTheBlanks.containsKey(current.getName())) {
						XElementValue localElement = new XElementValue(current, elementValueSet, iterator);
						if (currentValueParent != null) {
							currentValueParent.addChild(localElement);
						}
						fillInTheBlanks.put(current.getName(), localElement);
					}

					currentValueParent = fillInTheBlanks.get(current.getName());
				}
				if (currentValueParent != null) {
					currentValueParent.addChild(value);
				}
			}
		}

		watch.split();
		logger.trace("update all semantic containment: " + watch.toSplitString());

		HashMap<String, IElementValue> containers = new HashMap<>();

		for (IElementValue rootElementValue : elementValueSet.getElementValuesByName(rootSemantic)) {
			containers.put(rootElementValue.getSemanticElement().getName(), rootElementValue);
		}

		normalizeSemantics(mdl, elementValueSet, properties, containers);
		watch.split();
		logger.trace("normalizeSemantics: " + watch.toSplitString());

		for (IElementValue elementValue : elementValueSet.getAllElementValues()) {
			if (elementValue.getSemanticElement() != null && elementValue.getSemanticElement().getParent() == null) {
				if (elementValue.value() instanceof XDataStruct) {
					setYNodeValuesForBag((YBag) yroot, (XDataStruct) elementValue.value());
				}
				walkModel(yroot, elementValue);
			}
		}

		watch.split();
		logger.trace("walkModel: " + watch.toSplitString());

		logger.debug("compled update syntax model");

		watch.stop();

		logger.trace("updateSyntacticModel time : " + watch.getTime());

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.ISemanticParser#updateTargetSemanticModel(org.mdmi.MessageModel, org.mdmi.core.ElementValueSet, org.mdmi.core.ISyntaxNode,
	 * java.util.Properties)
	 */
	@Override
	public void updateTargetSemanticModel(MessageModel mdl, ElementValueSet elementValueSet, ISyntaxNode yr,
			Properties properties) {
		StopWatch watch = new StopWatch();
		watch.start();
		logger.trace("Start updateSyntacticModel ");

		if (mdl == null || elementValueSet == null || yr == null) {
			throw new IllegalArgumentException("Null argument!");
		}

		// Locate the root semantic element
		SemanticElement rootSemantic = null;
		for (IElementValue elementValue : elementValueSet.getAllElementValues()) {
			if (elementValue.getSemanticElement() != null) {
				rootSemantic = getRoot(elementValue.getSemanticElement());
			}
			if (rootSemantic != null) {
				break;
			}
		}

		if (rootSemantic == null) {
			logger.error("NO RootElement Found ");
			return;
		}

		HashMap<String, XElementValue> fillInTheBlanks = new HashMap<>();

		logger.trace("Root Semantic Element " + rootSemantic.getName());

		watch.split();
		logger.trace("Set up: " + watch.toSplitString());

		for (IElementValue rootElementValue : elementValueSet.getElementValuesByName(rootSemantic)) {
			fillInTheBlanks.put(rootSemantic.getName(), (XElementValue) rootElementValue);
		}

		watch.split();
		logger.trace("fillInTheBlanks: " + watch.toSplitString());

		// update all semantic containment

		ListIterator<IElementValue> iterator = elementValueSet.getAllElementValues().listIterator();

		while (iterator.hasNext()) {
			IElementValue value = iterator.next();
			if (value.getParent() == null) {
				logger.trace("ORPHAN ELEMENT " + value.getSemanticElement().getName());
				Stack<SemanticElement> path = new Stack<>();
				SemanticElement currentParent = value.getSemanticElement().getParent();
				while (currentParent != null) {
					path.push(currentParent);
					currentParent = currentParent.getParent();
				}
				IElementValue currentValueParent = null;
				while (!path.isEmpty()) {
					SemanticElement current = path.pop();
					logger.trace("PATH " + current.getName());
					if (!fillInTheBlanks.containsKey(current.getName())) {
						XElementValue localElement = new XElementValue(current, elementValueSet, iterator);
						if (currentValueParent != null) {
							currentValueParent.addChild(localElement);
						}
						fillInTheBlanks.put(current.getName(), localElement);
					}

					currentValueParent = fillInTheBlanks.get(current.getName());
				}
				if (currentValueParent != null) {
					currentValueParent.addChild(value);
				}
			}
		}

		watch.split();
		logger.trace("update all semantic containment: " + watch.toSplitString());

		HashMap<String, IElementValue> containers = new HashMap<>();

		for (IElementValue rootElementValue : elementValueSet.getElementValuesByName(rootSemantic)) {
			containers.put(rootElementValue.getSemanticElement().getName(), rootElementValue);
		}

		walkComputedIn(mdl, elementValueSet, properties, containers);
		watch.split();
		logger.trace("walkComputedIn: " + watch.toSplitString());

		walkNullFlavor(elementValueSet, properties);

		watch.split();
		logger.trace("walkNullFlavor: " + watch.toSplitString());

	}

	void normalizeSemantics(MessageModel mdl, ElementValueSet elementValueSet, Properties properties,
			HashMap<String, IElementValue> containers) {

		ListIterator<IElementValue> iterator = elementValueSet.getAllElementValues().listIterator();

		while (iterator.hasNext()) {
			IElementValue elementValue = iterator.next();
			if (elementValue.getSemanticElement() != null) {

				normalizeSemanticContainers(elementValueSet, elementValue, iterator, containers);
			}
		}

	}

	void walkComputedIn(MessageModel mdl, ElementValueSet elementValueSet, Properties properties,
			HashMap<String, IElementValue> containers) {

		ArrayList<SemanticElement> computedElementsContainers = new ArrayList<>();
		ArrayList<SemanticElement> rootComputedElements = new ArrayList<>();

		for (IElementValue ses : elementValueSet.getAllElementValues()) {
			if ("container".equalsIgnoreCase(ses.getSemanticElement().getDatatype().getName())) {
				if (ses.getParent() != null) {
					computedElementsContainers.add(ses.getSemanticElement());
				}
			}

		}

		StopWatch watch = new StopWatch();
		watch.start();

		// for (SemanticElement semanticElement : mdl.getElementSet().getSemanticElements()) {
		// if (semanticElement.isComputedIn()) {
		//
		// if (semanticElement.getParent() != null && semanticElement.getParent().getParent() != null) {
		// computedElementsContainers.add(semanticElement);
		// }
		// if (semanticElement.getParent() != null && semanticElement.getParent().getParent() == null) {
		// rootComputedElements.add(semanticElement);
		// }
		// }
		// }

		ListIterator<IElementValue> iterator = elementValueSet.getAllElementValues().listIterator();

		// while (iterator.hasNext()) {
		// IElementValue elementValue = iterator.next();
		// if (elementValue.getSemanticElement() != null) {
		//
		// normalizeSemanticContainers(elementValueSet, elementValue, iterator, containers);
		// }
		// }

		for (SemanticElement computedElementOwner : computedElementsContainers) {

			// if (computedElementOwner.getParent() != null &&
			// elementValueSet.hasElementValuesByName(computedElementOwner.getParent())) {

			List<IElementValue> foundElements = elementValueSet.getElementValuesByName(computedElementOwner);

			for (IElementValue elementValue : foundElements) {

				if (elementValue.getSemanticElement() != null) {

					for (SemanticElement child : elementValue.getSemanticElement().getChildren()) {

						if (child.isComputedIn()) {

							boolean ran = false;
							for (IElementValue ce : elementValue.getChildren()) {
								if (ce.getSemanticElement().getName().equals(child.getName())) {
									ran = true;
								}
							}

							if (ran) {
								continue;
							}

							logger.trace("Process computedin " + child.getName());
							String rule = child.getComputedInValue().getExpression();
							String lang = child.getComputedInValue().getLanguage();
							XElementValue computedInElement = new XElementValue(child, elementValueSet);
							elementValue.addChild(computedInElement);
							if ("Value".equals(lang)) {
								logger.trace("Process computedin value " + rule);
								computedInElement.getXValue().setValue(rule);
							} else {
								logger.trace("Process computedin rule " + rule);
								computedInElement.getParent().getUniqueId();
								this.getSemanticInterpreter().execute(
									child.getName() + "_COMPUTEDIN", computedInElement, properties);
							}

						}

					}
				}

			}
			// }

		}

		for (SemanticElement child : rootComputedElements) {
			logger.trace("Walk for computedin " + child.getName());
			if (child.isComputedIn()) {
				String rule = child.getComputedInValue().getExpression();
				String lang = child.getComputedInValue().getLanguage();
				XElementValue computedInElement = new XElementValue(child, elementValueSet);

				if ("Value".equals(lang)) {
					computedInElement.getXValue().setValue(rule);
				} else {
					logger.trace("Process computedin " + child.getName());
					logger.trace("Process computedin rule " + rule);

					logger.trace("Process computedin rule " + rule);

					this.getSemanticInterpreter().execute(
						child.getName() + "_COMPUTEDIN", computedInElement, properties);

				}

				for (IElementValue parentValue : elementValueSet.getElementValuesByName(child.getParent())) {
					parentValue.addChild(computedInElement);
					break;
				}
			}

		}

		watch.split();
		logger.trace("call computed in: " + watch.toSplitString());

		watch.split();
		logger.trace("walk computedin for children computed in: " + watch.toSplitString());

		/**
		 * @TODO - This is required to fire any compute ins when the path between the value has a local container
		 *       This only supports on local container need to support multiple local contianers
		 */

		watch.split();
		logger.trace("locals : " + watch.toSplitString());

		watch.stop();

		logger.trace("walk computed in time : " + watch.getTime());

	}

	/**
	 * walkModel is a recursive method used to populate the YBag
	 *
	 * @param currentYBag
	 * @param elementValue
	 */

	void walkModel(YNode currentYBag, IElementValue elementValue) {

		logger.trace("walkModel : " + elementValue.getName());

		HashMap<Node, YNode> createdNodes = new HashMap<>();

		for (IElementValue childElementValue : elementValue.getChildren()) {
			Stack<Node> bags = new Stack<>();

			getPath(bags, currentYBag.getNode(), childElementValue.getSemanticElement().getSyntaxNode());

			logger.trace("walkModel child : " + childElementValue.getName());

			YNode ynode = currentYBag;
			while (!bags.isEmpty()) {
				Node newNode = bags.pop();

				YNode child = null;
				if (newNode instanceof Choice) {
					if (!createdNodes.containsKey(newNode)) {
						logger.trace("Create YChoice: " + newNode.getName());
						createdNodes.put(newNode, new YChoice((Choice) newNode, ynode));
						child = createdNodes.get(newNode);
						ynode.addYNode(child);
					}
					child = createdNodes.get(newNode);
				}
				if (newNode instanceof Bag) {

					if (newNode.getMaxOccurs() != 1 || !createdNodes.containsKey(newNode)) {

						logger.trace("Create YBag: " + newNode.getName());
						createdNodes.put(newNode, new YBag((Bag) newNode, ynode));

						child = createdNodes.get(newNode);
						if (childElementValue.value() != null) {
							if (childElementValue.value() instanceof XDataStruct) {
								setYNodeValuesForBag((YBag) child, (XDataStruct) childElementValue.value());
							} else {

								logger.error(
									" Syntax Model Populating Error/Mismatch - Possible missing proper semantic containment/container " +
											elementValue.getSemanticElement().getName() + " " +
											getFullPathForNode(child.getNode()) + " " + childElementValue.value());

							}
						}
						ynode.addYNode(child);
					}
					child = createdNodes.get(newNode);

				}
				if (newNode instanceof LeafSyntaxTranslator) {
					if (!createdNodes.containsKey(newNode)) {

						logger.trace("Create YLeaf: " + newNode.getName());

						createdNodes.put(newNode, new YLeaf((LeafSyntaxTranslator) newNode, ynode));
						child = createdNodes.get(newNode);
						setLeafValue((YLeaf) child, childElementValue.value());
						ynode.addYNode(child);
					}
					child = createdNodes.get(newNode);

				}

				ynode = child;
			}

			if (ynode != null) {

				logger.trace("ynode setvalue " + ynode.getNode().getName() + " : " + childElementValue.getXValue());
				ynode.setElementValue(childElementValue);
				walkModel(ynode, childElementValue);
			}
		}

	}

	void walkNullFlavor(ElementValueSet elementValueSet, Properties properties) {

		ArrayList<Pair<IElementValue, SemanticElement>> toRun = new ArrayList<>();

		for (IElementValue elementValue : elementValueSet.getAllElementValues()) {

			logger.trace("walkNullFlavor " + elementValue.getSemanticElement().getName());

			if (elementValue.getSemanticElement() != null) {
				for (SemanticElement child : elementValue.getSemanticElement().getChildren()) {

					logger.trace("walkNullFlavor child " + child.getName());

					if (child.isNullFlavor()) {

						logger.trace("child is null flavor" + child.getName());

						boolean runForElement = true;

						for (SemanticElementRelationship ser : child.getRelationships()) {
							for (IElementValue childElement : elementValue.getChildren()) {
								if (ser.getRelatedSemanticElement() != null) {
									if (childElement.getSemanticElement().getName().equals(
										ser.getRelatedSemanticElement().getName())) {

										logger.trace(
											"do not run found element " + childElement.getSemanticElement().getName());
										runForElement = false;
									}
									if (ser.getRelatedSemanticElement().isComputedIn()) {

										logger.trace(
											"do not run, isComputedIn" + childElement.getSemanticElement().getName());

										runForElement = false;
									}
								} else {
									logger.error(
										"Error! processing Null Flavor " + child.getName() +
												", NULLFLAVOR relationship missing semantic element");
									runForElement = false;
								}
							}

						}

						if (runForElement) {
							toRun.add(Pair.of(elementValue, child));
						}
					}
				}
			}
		}

		for (Pair<IElementValue, SemanticElement> nullFlavorToRun : toRun) {
			try {
				SemanticElementRelationship ser = nullFlavorToRun.getRight().getRelationshipByName("NULLFLAVOR");
				logger.trace("Running Null Flavor " + ser.getRelatedSemanticElement().getName());
				XElementValue nullFlavor = new XElementValue(ser.getRelatedSemanticElement(), elementValueSet);
				this.getSemanticInterpreter().execute(
					"setNullFlavorFor" + nullFlavorToRun.getRight().getName(), nullFlavor, properties);
				nullFlavorToRun.getLeft().addChild(nullFlavor);
				nullFlavor.setParent(nullFlavorToRun.getLeft());

			} catch (Exception e) {
				logger.error("Error processing null flavor " + nullFlavorToRun.getRight().getName(), e);
			}
		}
	}

	private void walkTheValues(MessageModel mdl, XElementValue parent, JSONObject theValues,
			List<XElementValue> initalElements) {
		for (Object key : theValues.keySet()) {

			for (SemanticElement x : mdl.getElementSet().getSemanticElements()) {
				if (key.equals(x.getName())) {
					XElementValue element = new XElementValue(x, valueSet);

					if (parent != null) {
						parent.addChild(element);
						// element.setParent(parent);
					} else {
						initalElements.add(element);
					}

					if (x.getDatatype() != null && "Container".endsWith(x.getDatatype().getName())) {
						parent = element;
						walkTheValues(mdl, parent, (JSONObject) theValues.get(key), initalElements);
					} else {

						Object vv = theValues.get(key);
						if (vv instanceof JSONObject) {
							JSONObject ddd = (JSONObject) theValues.get(key);

							XDataStruct xs = new XDataStruct(parent.getXValue(), true);

							for (Object vkey : ddd.keySet()) {
								xs.setValueSafely((String) vkey, theValues.get(vkey));
							}
							element.getXValue().addValue(xs);
						} else {
							element.getXValue().addValue(vv);

						}
					}

				}
			}
		}

	}
}
