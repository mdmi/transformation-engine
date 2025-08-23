/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import java.util.ArrayList;
import java.util.List;

import org.mdmi.Bag;
import org.mdmi.Choice;
import org.mdmi.Node;

/**
 * A choice syntax node, it has one node usually (or more but all of the same type).
 *
 * @author goancea
 */
public final class YChoice extends YNode {
	private Choice m_choice;

	private ArrayList<YNode> m_nodes; // can be more than one, but all the same type

	/**
	 * Construct a choice syntax node from its model node and its parent.
	 *
	 * @param choice
	 *            The model node - a Choice.
	 * @param parent
	 *            The owner of this instance. Null only for the root node.
	 */
	public YChoice(Choice choice, YNode parent) {
		super(choice, parent);
		m_choice = choice;
		m_nodes = new ArrayList<>();
	}

	/**
	 * Construct one from the model node, its parent and a value node, which is the selected node value.
	 *
	 * @param choice
	 *            The model node - a Choice.
	 * @param parent
	 *            The owner of this instance. Null only for the root node.
	 * @param ynode
	 *            value The value node - the selected choice item.
	 */
	public YChoice(Choice choice, YNode parent, YNode value) {
		this(choice, parent);
		if (value != null) {
			m_nodes.add(value);
		}
	}

	/**
	 * Get the model node.
	 *
	 * @return The model node, a choice.
	 */
	public Choice getChoice() {
		return m_choice;
	}

	/**
	 * Get all the child nodes. All these nodes are of the same type.
	 * That is, all of them have the same model node.
	 *
	 * @return The list of child syntax nodes.
	 */
	public ArrayList<YNode> getYNodes() {
		return m_nodes;
	}

	private static Node searchForNode(Bag bag, Node node) {

		for (Node childNode : bag.getNodes()) {
			if (node.equals(childNode)) {
				return childNode;
			}
			if (childNode instanceof Bag) {
				Node n = searchForNode((Bag) childNode, node);
				if (n != null) {
					return n;
				}

			}
		}

		return null;
	}

	private static Node searchForNode(Choice m_choice2, Node node) {

		for (Node childNode : m_choice2.getNodes()) {
			if (node.equals(childNode)) {
				return childNode;
			}
			if (childNode instanceof Bag) {
				Node n = searchForNode((Bag) childNode, node);
				if (n != null) {
					return n;
				}

			}
		}

		return null;
	}

	public Node getNode(Node node) {
		return searchForNode(m_choice, node);
	}

	/**
	 * Add a new child syntax node. The child syntax node's model node must match the existing nodes,
	 * if there are any.
	 *
	 * @param ynode
	 *            The syntax node to be added as a child.
	 */
	@Override
	public void addYNode(YNode ynode) {
		if (m_nodes.isEmpty()) {
			m_nodes.add(ynode);
		} else {
			m_nodes.get(0).addYNode(ynode);
		}
	}

	/**
	 * Force the choice to the new ynode value passed in. Will delete the old choice.
	 * If the new choice node is null, then the choice becomes empty again.
	 *
	 * @param ynode
	 *            YNode replacing the existing choice. May be null.
	 */
	public void forceChoice(YNode ynode) {
		m_nodes.clear();
		if (ynode != null) {
			m_nodes.add(ynode);
		}
	}

	/**
	 * Get the chosen (selected) model node (type). Identifies which of the choice's child nodes is really present.
	 * May be null if none selected yet.
	 *
	 * @return The chosen (selected) model node (type).
	 */
	public Node getChosenNode() {
		if (m_nodes.size() > 0) {
			return m_nodes.get(0).getNode();
		}
		return null;
	}

	@Override
	public boolean isChoice() {
		return true;
	}

	@Override
	protected String toString(String indent) {
		StringBuffer sb = new StringBuffer();
		sb.append(indent + m_choice.getName());
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
		return m_nodes;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.engine.YNode#getYNodesForNode(org.mdmi.model.Node)
	 */
	@Override
	public ArrayList<YNode> getYNodesForNode(Node newNode) {
		ArrayList<YNode> ynodes = new ArrayList<>();
		for (int i = 0; i < m_nodes.size(); i++) {
			YNode ynode = m_nodes.get(i);
			if (ynode.getNode() == newNode) {
				ynodes.add(ynode);
			}
		}
		return ynodes;
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

} // YChoice
