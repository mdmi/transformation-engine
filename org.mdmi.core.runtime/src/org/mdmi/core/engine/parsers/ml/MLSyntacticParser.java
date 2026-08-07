/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.parsers.ml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.mdmi.Bag;
import org.mdmi.MessageModel;
import org.mdmi.MessageSyntaxModel;
import org.mdmi.Node;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementRelationship;
import org.mdmi.core.ISyntacticParser;
import org.mdmi.core.ISyntaxNode;
import org.mdmi.core.MdmiException;
import org.mdmi.core.MdmiMessage;
import org.mdmi.core.engine.YBag;
import org.mdmi.core.engine.YChoice;
import org.mdmi.core.engine.YLeaf;
import org.mdmi.core.engine.YNode;
import org.mdmi.core.engine.javascript.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author seanmuir
 *
 */
public class MLSyntacticParser implements ISyntacticParser {

	ArrayList<VS> valuesets = new ArrayList<>();

	/**
	 *
	 */
	public MLSyntacticParser() {
		super();

	}

	private static class VS {
		public String uri;

		public ArrayList<String> codes;

		/**
		 * @param uri
		 * @param codes
		 */
		public VS(String uri, ArrayList<String> codes) {
			super();
			this.uri = uri;
			this.codes = codes;
		}

	}

	private static Logger logger = LoggerFactory.getLogger(MLSyntacticParser.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.ISyntacticParser#parse(org.mdmi.MessageModel, org.mdmi.core.MdmiMessage)
	 */
	@Override
	public ISyntaxNode parse(MessageModel mdl, MdmiMessage msg) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.ISyntacticParser#serialize(org.mdmi.MessageModel, org.mdmi.core.MdmiMessage, org.mdmi.core.ISyntaxNode, java.lang.String)
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

		if (valuesets.isEmpty()) {

			for (SemanticElement serow : yroot.getNode().getSemanticElement().getChildren()) {

				for (SemanticElement seobservation : serow.getChildren()) {
					if (seobservation.getRelationshipByName("QUALIFIER") != null) {

						Properties qualifierset = Utils.mapOfTransforms.get(
							seobservation.getRelationshipByName("QUALIFIER").getDescription());
						ArrayList<String> vscodes = new ArrayList<>();
						if (qualifierset != null) {
							for (Object key : qualifierset.keySet()) {
								vscodes.add((String) key);
							}
						}
						VS vs = new VS(seobservation.getRelationshipByName("QUALIFIER").getDescription(), vscodes);
						valuesets.add(vs);
					} else {
						ArrayList<String> vscodes = new ArrayList<>();
						vscodes.add(seobservation.getSyntaxNode().getName());
						VS vs = new VS(seobservation.getName(), vscodes);
						valuesets.add(vs);
					}

				}

			}

		}

		StringBuffer root = new StringBuffer();

		if (node instanceof Bag) {
			serializeBag((YBag) yroot, root);
		}

		msg.setData(root.toString());

	}

	private void serializeBag(YBag yroot, StringBuffer root) {
		serialize(yroot, this.valuesets, root);
	}

	static int checkTotal = 0;

	static int checkNode = 0;

	private void serialize(YBag bag, ArrayList<VS> valuesets, StringBuffer element) {
		org.mdmi.core.engine.YNodeVisitor v = new MLVisitor(element);
		bag.accept(v);
	}

	static public class MLVisitor implements org.mdmi.core.engine.YNodeVisitor {

		StringBuffer element;

		ArrayList<String> currentRow = new ArrayList<String>();

		String currentSubject = "";

		int currentSubjectCounter = 0;

		/**
		 * @param element
		 */
		public MLVisitor(StringBuffer element) {
			super();
			this.element = element;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see org.mdmi.core.engine.YNodeVisitor#visit(org.mdmi.core.engine.YBag)
		 */
		@Override
		public void visit(YBag ybag) {

			currentRow.clear();

			if ("DocumentRoot".equals(ybag.getNode().getName())) {

				for (YNode ynode : ybag.getChildren()) {
					for (Node n : ((Bag) ynode.getNode()).getNodes()) {
						String name = n.getName().replaceAll(",", " ");
						if (!n.getSemanticElement().getName().equals("ACCOUNTIDENTIFIERSE")) {
							for (int nctr = 0; nctr < n.getMaxOccurs(); nctr++) {

								if (n.getMaxOccurs() == 1) {
									currentRow.add(name);
								} else {
									if (nctr + 1 == n.getMaxOccurs()) {
										currentRow.add(name + " Other");
									} else {
										currentRow.add(name + " " + nctr);
									}
								}

							}
						}

					}
					break;
				}

				String cr = currentRow.stream().collect(Collectors.joining(","));
				element.append(cr).append(System.getProperty("line.separator"));

				for (YNode ynode : ybag.getYNodes()) {
					ynode.accept(this);
				}
			}

			if ("ROW".equals(ybag.getNode().getName()))

			{

				Bag b = (Bag) ybag.getNode();
				for (Node n : b.getNodes()) {
					if (n.getSemanticElement().getName().equals("ACCOUNTIDENTIFIERSE")) {
						continue;
					}

					if (checkNode == 0) {
						checkNode = ybag.getChildren().size();
					} else {
						if (checkNode != ybag.getChildren().size()) {
							throw new RuntimeException("missing ynodes");
						}
					}

					for (YNode ynode : ybag.getChildren()) {

						if (n.getName().equals(ynode.getNode().getName())) {
							String nn = n.getSemanticElement().getName();

							List<String> values = new ArrayList<>();

							if (ynode instanceof YLeaf) {
								YLeaf l = (YLeaf) ynode;
								currentRow.add(l.getValue());
								continue;
							}

							YBag x = (YBag) ynode;

							for (YNode y : x.getChildren()) {
								if (!y.getNode().getSemanticElement().getKeywords().isEmpty()) {
									values = Arrays.asList(
										((YLeaf) y).getValue().replace("[", "").replace("]", "").split(","));
									break;
								}
							}

							for (int ynodectr = 0; ynodectr < n.getMaxOccurs(); ynodectr++) {

								if (n.getMaxOccurs() != 1 && ynodectr + 1 == n.getMaxOccurs()) {

									if (values.size() > n.getMaxOccurs()) {
										String joined = String.join(" ", values.subList(ynodectr, values.size()));
										currentRow.add(joined);
									} else {
										currentRow.add("");
									}

								} else {
									if (ynodectr < values.size()) {
										currentRow.add(values.get(ynodectr));
									} else {
										currentRow.add("");
									}
								}
							}
						}
					}

				}

				if (checkTotal == 0) {
					checkTotal = currentRow.size();
				} else {
					if (checkTotal != currentRow.size()) {
						throw new RuntimeException("checksum error");
					}
				}

				String cr = currentRow.stream().collect(Collectors.joining(","));
				element.append(cr).append(System.getProperty("line.separator"));
			}

		}

		/*
		 * (non-Javadoc)
		 *
		 * @see org.mdmi.core.engine.YNodeVisitor#visit(org.mdmi.core.engine.YLeaf)
		 */
		@Override
		public void visit(YLeaf yleaf) {

			if (!yleaf.getNode().getSemanticElement().getKeywords().isEmpty()) {
				currentRow.add(yleaf.getValue());
			}

		}

		/*
		 * (non-Javadoc)
		 *
		 * @see org.mdmi.core.engine.YNodeVisitor#visit(org.mdmi.core.engine.YChoice)
		 */
		@Override
		public void visit(YChoice ychoice) {

		}

	}

	static public class ExpandByValuesetVisitor implements org.mdmi.core.engine.YNodeVisitor {

		StringBuffer element;

		HashMap<String, HashMap<String, String>> currentRow;

		ArrayList<VS> valuesets;

		/*
		 * (non-Javadoc)
		 *
		 * @see org.mdmi.core.engine.YNodeVisitor#visit(org.mdmi.core.engine.YBag)
		 */
		@Override
		public void visit(YBag ybag) {

			logger.trace("start visit " + ybag.getNode().getName());

			currentRow = new HashMap<>();

			if ("DocumentRoot".equals(ybag.getNode().getName())) {

				for (VS xx : this.valuesets) {
					currentRow.put(xx.uri, new HashMap<>());
					for (String code : xx.codes) {
						currentRow.get(xx.uri).put(code, "");

					}
				}

				Consumer<? super Entry<String, String>> appendtobuffer = new Consumer<>() {

					@Override
					public void accept(Entry<String, String> t) {
						element.append(t.getKey()).append(",");

					}
				};
				for (String uri : currentRow.keySet()) {
					currentRow.get(uri).entrySet().stream().sorted(Map.Entry.<String, String> comparingByKey()).forEach(
						appendtobuffer);
				}

				element.append(System.getProperty("line.separator"));

				currentRow.clear();

				for (YNode ynode : ybag.getYNodes()) {

					ynode.accept(this);

				}

			}

			if ("ROW".equals(ybag.getNode().getName()))

			{

				for (VS xx : this.valuesets) {
					currentRow.put(xx.uri, new HashMap<>());
					for (String code : xx.codes) {
						currentRow.get(xx.uri).put(code, "0");

					}
				}

				for (YNode ynode : ybag.getChildren()) {
					if (ynode instanceof YLeaf) {
						ynode.accept(this);
					} else {

						SemanticElementRelationship relationship = ynode.getElementValue().getSemanticElement().getRelationshipByName(
							"QUALIFIER");

						SemanticElement qualifier = relationship.getRelatedSemanticElement();

						YBag aa = (YBag) ynode;
						String key = "";
						String value = "";
						for (YNode yc : aa.getChildren()) {
							if (yc.getElementValue().getSemanticElement().equals(qualifier)) {
								key = ((YLeaf) yc).getValue();
							} else {
								value = ((YLeaf) yc).getValue();
							}

						}
						HashMap<String, String> x = currentRow.get(relationship.getDescription());
						x.put(key, value);

					}
				}

				Consumer<? super Entry<String, String>> appendtobuffer = new Consumer<>() {

					@Override
					public void accept(Entry<String, String> t) {
						element.append(t.getValue()).append(",");

					}
				};

				for (

				String uri : currentRow.keySet()) {
					currentRow.get(uri).entrySet().stream().sorted(Map.Entry.<String, String> comparingByKey()).forEach(
						appendtobuffer);
				}

				element.append(System.getProperty("line.separator"));

			}

			logger.trace("end visit " + ybag.getNode().getName());

		}

		/**
					 *
					 */
		public ExpandByValuesetVisitor(ArrayList<VS> valuesets, StringBuffer element) {
			super();
			this.element = element;
			this.valuesets = valuesets;

		}

		/*
		 * (non-Javadoc)
		 *
		 * @see org.mdmi.core.engine.YNodeVisitor#visit(org.mdmi.core.engine.YLeaf)
		 */
		@Override
		public void visit(YLeaf yleaf) {

			if (yleaf.getElementValue().getSemanticElement().getParent().getRelationshipByName("QUALIFIER") == null) {
				currentRow.get(yleaf.getElementValue().getSemanticElement().getName()).put(
					yleaf.getNode().getName(), yleaf.getValue());

			}

		}

		/*
		 * (non-Javadoc)
		 *
		 * @see org.mdmi.core.engine.YNodeVisitor#visit(org.mdmi.core.engine.YChoice)
		 */
		@Override
		public void visit(YChoice ychoice) {

		}

	}

}
