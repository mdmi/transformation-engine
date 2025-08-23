/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.mdmi.Bag;
import org.mdmi.Node;

/**
 * A bag syntax node, it has one or mode nodes, may be of mixed types.
 *
 * @author goancea
 */
public final class YBag extends YNode {
	private Bag m_bag;

	private LinkedList<YNode> m_nodes; // more than one, mixed types

	/**
	 * Construct a bag syntax node from its model node and its parent.
	 *
	 * @param bag
	 *            The model node - a Bag.
	 * @param parent
	 *            The owner of this instance. Null only for the root node.
	 */
	public YBag(Bag bag, YNode parent) {
		super(bag, parent);

		m_bag = bag;
		m_nodes = new LinkedList<>();
	}

	/**
	 * Construct one from the model node, its parent and a value node, which will be added as the first value node.
	 *
	 * @param bag
	 *            The model node - a Bag.
	 * @param parent
	 *            The owner of this instance. Null only for the root node.
	 * @param ynode
	 *            value The value node to be added.
	 */
	public YBag(Bag bag, YNode parent, YNode ynode) {
		this(bag, parent);

		m_nodes.add(ynode);
	}

	/**
	 * Get the model node.
	 *
	 * @return The model node, a bag.
	 */
	public Bag getBag() {
		return m_bag;
	}

	/**
	 * Get all the child nodes.
	 *
	 * @return The list of child syntax nodes.
	 */
	public LinkedList<YNode> getYNodes() {
		sort();
		return m_nodes;
	}

	/**
	 * Get all the nodes of a given type, that is for a given model node.
	 *
	 * @param node
	 *            The model node to look for.
	 * @return All the nodes of a given type.
	 */
	@Override
	public List<YNode> getYNodesForNode(Node node) {
		LinkedList<YNode> ynodes = new LinkedList<>();
		for (int i = 0; i < m_nodes.size(); i++) {
			YNode ynode = m_nodes.get(i);
			if (ynode.getNode() == node) {
				ynodes.add(ynode);
			}
		}
		return ynodes;
	}

	/**
	 * searchForNode
	 *
	 * @Todo refactor node hierarchy to use composite pattern
	 * @param bag
	 * @param node
	 * @return
	 */
	private static Node searchForNode(Bag bag, Node node) {

		Node n = bag.getNodeByNode(node);
		return n;
	}

	public Node getNode(Node node) {
		return searchForNode(m_bag, node);
	}

	private static class CompareYNodes implements Comparator<YNode> {

		/*
		 * (non-Javadoc)
		 *
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(YNode o1, YNode o2) {
			if (o1 == null && o2 == null) {
				return 0;
			}

			if (o1 == null) {
				return -1;
			}

			if (o2 == null) {
				return 1;
			}

			if (o1.getNode() == null && o2.getNode() == null) {
				return 0;
			}

			if (o1.getNode() == null) {
				return -1;
			}

			if (o2.getNode() == null) {
				return 1;
			}

			if (!StringUtils.isNumeric(o1.getNode().getDescription()) &&
					!StringUtils.isNumeric(o2.getNode().getDescription())) {
				return 0;
			}
			if (!StringUtils.isNumeric(o1.getNode().getDescription())) {
				return -1;
			}
			if (!StringUtils.isNumeric(o2.getNode().getDescription())) {
				return 1;
			}
			return Integer.valueOf(o1.getNode().getDescription()).compareTo(
				Integer.valueOf(o2.getNode().getDescription()));

		}

	}

	private static CompareYNodes compareYNodes = new CompareYNodes();

	private void sort() {
		Collections.sort(m_nodes, compareYNodes);
	}

	private YBag getYNode(String location) {
		for (YNode y : m_nodes) {
			if (y.getNode().getLocation().equals(location)) {
				return (YBag) y;
			}
		}

		if (this.m_node instanceof Bag) {
			for (Node nn22 : ((Bag) this.m_node).getNodes()) {
				if (nn22.getLocation().equals(location)) {
					YBag y = new YBag((Bag) nn22, this);
					m_nodes.add(y);
					return y;
				}
			}
		}

		return null;

	}

	/**
	 * Add a child node.
	 *
	 * @param ynode
	 */
	@Override
	public void addYNode(YNode ynode) {

		Node node = this.getNode(ynode.getNode());

		if (node != null) {

			if (this.m_node.equals(node.getParentNode())) {
				m_nodes.add(ynode);
			} else {

				String[] datatypePath = ynode.getNode().getLocation().split("@")[0].split("/");

				YBag parentBag = this;
				for (int index = 0; index < datatypePath.length - 1; index++) {
					String currentLocation = datatypePath[index];
					parentBag = parentBag.getYNode(currentLocation);
				}

				parentBag.pushYNode(ynode);

			}
			return;
		}

	}

	/**
	 * @param ynode
	 */
	void pushYNode(YNode ynode) {
		this.m_nodes.add(ynode);

	}

	@Override
	public boolean isBag() {
		return true;
	}

	@Override
	protected String toString(String indent) {
		StringBuffer sb = new StringBuffer();
		sb.append(indent + m_bag.getName());
		for (int i = 0; i < m_nodes.size(); i++) {
			sb.append("\r\n");
			YNode ynode = m_nodes.get(i);
			sb.append(ynode.toString(indent + " "));
		}
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.engine.YNode#getChildren()
	 */
	@Override
	public List<YNode> getChildren() {
		return this.m_nodes;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.engine.YNode#accept(org.mdmi.engine.YNodeVisitor)
	 */
	@Override
	public void accept(YNodeVisitor visitor) {
		visitor.visit(this);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.engine.YNodeVisitable#accept(org.mdmi.engine.YNodeVisitor)
	 */

} // YBag
