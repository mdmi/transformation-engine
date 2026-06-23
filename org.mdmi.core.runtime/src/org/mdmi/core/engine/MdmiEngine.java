/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import org.mdmi.core.ISyntaxNode;
import org.mdmi.core.Mdmi;
import org.mdmi.core.MdmiTransferInfo;

/**
 * The entry point for the transfer engine.
 * This class wraps the pool of threads.
 *
 * @TODO Combine wiht Mdmi and MdmiUow
 * @deprecated
 */

@Deprecated
public final class MdmiEngine {
	private Mdmi m_owner;

	public MdmiEngine(Mdmi owner) {
		m_owner = owner;
	}

	public void start() {
	}

	public void stop() {

	}

	Mdmi getOwner() {
		return m_owner;
	}

	ISyntaxNode sourceSyntaxModel;

	/**
	 * @return the sourceSyntaxModel
	 */
	public ISyntaxNode getSourceSyntaxModel() {
		return sourceSyntaxModel;
	}

	/**
	 * @return the targetSyntaxModel
	 */
	public ISyntaxNode getTargetSyntaxModel() {
		return targetSyntaxModel;
	}

	ISyntaxNode targetSyntaxModel;

	public void executeTransfer(MdmiTransferInfo transferInfo) {
		MdmiUow uow = new MdmiUow(this, transferInfo);
		uow.run();
		uow.clean();
		sourceSyntaxModel = uow.getSrcSyntaxModel();
		targetSyntaxModel = uow.getTrgSyntaxModel();

	}

} // MdmiEngine
