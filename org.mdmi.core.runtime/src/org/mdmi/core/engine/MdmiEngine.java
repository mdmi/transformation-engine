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

	/**
	 * @param sMod
	 * @param tMsg
	 * @param bers
	 * @param semanticContainer
	 * @param location
	 */
	// public void executeTransfer(MdmiModelRef sMod, MdmiMessage tMsg, ArrayList<MDMIBusinessElementReference> bers,
	// SemanticElement semanticContainer, List<SemanticElement> semanticElements, String location) {
	// MdmiUow uow = new MdmiUow(this);
	// uow.run(sMod, tMsg, bers, semanticContainer, semanticElements, location);
	// sourceSyntaxModel = uow.getSrcSyntaxModel();
	// targetSyntaxModel = uow.getTrgSyntaxModel();
	//
	// }

	// private ISyntacticParser getSyntaxProvider(MessageGroup messageGroup) {
	// for (MessageModel s : messageGroup.getModels()) {
	// return m_owner.getResolver().getSyntacticParser(messageGroup.getName(), s.getMessageModelName());
	// }
	// return null;
	//
	// }
	//
	// private ISemanticParser getSemanticProvider(MessageGroup messageGroup) {
	// for (MessageModel s : messageGroup.getModels()) {
	// return m_owner.getResolver().getSemanticParser(messageGroup.getName(), s.getMessageModelName());
	// }
	// return null;
	//
	// }

} // MdmiEngine
