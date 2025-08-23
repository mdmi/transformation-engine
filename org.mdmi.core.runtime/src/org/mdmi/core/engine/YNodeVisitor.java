/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

/**
 * @author seanmuir
 *
 */
public interface YNodeVisitor {

	public void visit(YBag ybag);

	public void visit(YLeaf yleaf);

	public void visit(YChoice ychoice);

}
