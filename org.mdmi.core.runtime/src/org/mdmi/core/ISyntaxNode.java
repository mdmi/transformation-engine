/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import org.mdmi.Node;

/**
 * Syntax node abstraction - a node in a syntax tree.
 *
 * @author goancea
 */
public interface ISyntaxNode {
	/**
	 * Get the model Node class for this syntax node instance.
	 *
	 * @return The model Node class for this syntax node instance.
	 */
	public Node getNode();

	/**
	 * Get the parent syntax node of this syntax node. Only the root node will return null.
	 *
	 * @return The parent syntax node of this syntax node.
	 */
	public ISyntaxNode getParent();

	/**
	 * Return true if this instance is a leaf. Means the getNode will return a LeafSyntaxTranslator.
	 *
	 * @return True if this instance is a leaf.
	 */
	public boolean isLeaf();

	/**
	 * Return true if this instance is a bag. Means the getNode will return a Bag.
	 *
	 * @return True if this instance is a bag.
	 */
	public boolean isBag();

	/**
	 * Return true if this instance is a choice. Means the getNode will return a Choice.
	 *
	 * @return True if this instance is a choice.
	 */
	public boolean isChoice();
} // ISynNode
