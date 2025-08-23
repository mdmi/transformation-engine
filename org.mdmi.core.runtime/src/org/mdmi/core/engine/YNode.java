/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import java.util.List;

import org.mdmi.Node;
import org.mdmi.core.IElementValue;
import org.mdmi.core.ISyntaxNode;

/**
 * Syntax tree node - base class of all classes in the syntax tree.
 */
public abstract class YNode implements ISyntaxNode {
	protected Node m_node;

	protected YNode m_parent;

	IElementValue elementValue;

	public void setElementValue(IElementValue elementValue) {
		this.elementValue = elementValue;
	}

	public IElementValue getElementValue() {
		return elementValue;
	}

	/**
	 * Construct one from the model Node instance and its parent.
	 *
	 * @param node
	 *            The model Node instance.
	 * @param parent
	 *            The owner YNode.
	 */
	public YNode(Node node, YNode parent) {
		if (node == null) {
			throw new IllegalArgumentException("Invalid call, the model node cannot be null!");
		}
		m_node = node;
		m_parent = parent;
	}

	@Override
	public Node getNode() {
		return m_node;
	}

	@Override
	public ISyntaxNode getParent() {
		return m_parent;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public boolean isBag() {
		return false;
	}

	@Override
	public boolean isChoice() {
		return false;
	}

	@Override
	public String toString() {
		return toString("");
	}

	/**
	 * Output a representation of this instance to a string.
	 *
	 * @param indent
	 *            The indentation.
	 * @return The representation of this instance to a string.
	 */
	protected abstract String toString(String indent);

	public abstract List<YNode> getChildren();

	/**
	 * @param newNode
	 * @return
	 */
	public abstract List<YNode> getYNodesForNode(Node newNode);

	/**
	 * @param child
	 */
	public abstract void addYNode(YNode child);

	public abstract void accept(YNodeVisitor visitor);

} // YNode
