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

import org.mdmi.core.engine.semanticprocessors.ISemanticProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Collection of post processors registered with this runtime.
 * Will be loaded from the config file at the start, and may be updated later.
 */
public final class TargetSemanticModelProcessors {

	public ArrayList<ISemanticProcessor> getTargetSemanticProcessors() {
		return targetSemanticProcessors;
	}

	private static Logger logger = LoggerFactory.getLogger(TargetSemanticModelProcessors.class);

	private final ArrayList<ISemanticProcessor> targetSemanticProcessors = new ArrayList<>();

	public void addTargetSemanticProcessor(ISemanticProcessor targetSemanticProcessor) {
		if (targetSemanticProcessor != null) {
			boolean add = true;
			for (ISemanticProcessor registered : targetSemanticProcessors) {
				if (registered.getName().equals(targetSemanticProcessor.getName())) {
					add = false;
				}
			}
			if (add) {
				logger.trace("Adding Source Semantic Model Processor " + targetSemanticProcessor.getName());
				targetSemanticProcessors.add(targetSemanticProcessor);
			}
		}

	}

	/**
	 * From the list of post-processors call all the ones that are registered to handle the source or target messages,
	 * based on the message group name and message model name.
	 *
	 * @param transferInfo
	 *            The transfer info which is just about to being processed by the runtime.
	 */
	public void targetSemanticModelProcessing(MdmiTransferInfo transferInfo, ElementValueSet targetSemanticModel) {
		logger.trace("targetSemanticModelProcessingtargetSemanticModelProcessing " + targetSemanticProcessors);

		for (ISemanticProcessor targetSemanticProcessor : targetSemanticProcessors) {
			logger.trace("Checking " + targetSemanticProcessor.getName());
			if (targetSemanticProcessor.canProcess(transferInfo.targetModel.getModel())) {
				try {
					logger.info("Executing " + targetSemanticProcessor.getName());
					targetSemanticProcessor.processSemanticModel(targetSemanticModel);
				} catch (Exception ex) {

					logger.error(
						"TargetSemanticModelProcessors.postProcess {0} throws an unexpected exception while processing source of transfer request",
						ex);
				}
			}
		}
	}

}
