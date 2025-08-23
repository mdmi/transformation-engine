/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import java.util.ArrayList;

import org.mdmi.core.engine.preprocessors.IPreProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MdmiPreProcessors {

	/**
	 * @return the m_preProcessors
	 */
	public ArrayList<IPreProcessor> getPreProcessors() {
		return preProcessors;
	}

	private static Logger logger = LoggerFactory.getLogger(MdmiPreProcessors.class);

	private final ArrayList<IPreProcessor> preProcessors = new ArrayList<>();

	public void addPreProcessor(IPreProcessor preProcessor) {
		if (preProcessor != null) {
			logger.trace("Adding post process " + preProcessor.getName());
			preProcessors.add(preProcessor);
		}

	}

	MdmiPreProcessors() {

	}

	/**
	 * From the list of pre-processors call all the ones that are registered to handle the source or target messages,
	 * based on the message group name and message model name.
	 *
	 * @param transferInfo
	 *            The transfer info which is just about to being processed by the runtime.
	 */
	public void preProcess(MdmiTransferInfo transferInfo) {
		if (transferInfo == null) {
			throw new IllegalArgumentException("transferInfo is null");
		}
		for (int i = 0; i < preProcessors.size(); i++) {
			IPreProcessor preprocessor = preProcessors.get(i);
			if (preprocessor.canProcess(transferInfo.sourceModel.getModel())) {
				try {
					preprocessor.processMessage(transferInfo.sourceModel.getModel(), transferInfo.sourceMessage);
				} catch (Exception ex) {
					throw new MdmiException(
						ex,
						"MdmiPreProcessor {0} throws an unexpected exception while processing source of transfer request {1}",
						preprocessor.getName(), transferInfo.toString());
				}
			}
		}
	}
} // MdmiPreProcessors
