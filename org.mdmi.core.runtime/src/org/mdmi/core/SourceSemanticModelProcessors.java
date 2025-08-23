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
public final class SourceSemanticModelProcessors {

	public ArrayList<ISemanticProcessor> getSourceSemanticProcessors() {
		return sourceSemanticProcessors;
	}

	private static Logger logger = LoggerFactory.getLogger(SourceSemanticModelProcessors.class);

	private final ArrayList<ISemanticProcessor> sourceSemanticProcessors = new ArrayList<>();

	public void addSourceSemanticProcessor(ISemanticProcessor sourceSemanticProcessor) {
		if (sourceSemanticProcessor != null) {
			boolean add = true;
			// fail safe to make sure post process is onyl added once
			for (ISemanticProcessor registered : sourceSemanticProcessors) {

				if (registered.getName().equals(sourceSemanticProcessor.getName())) {
					add = false;
				}
			}
			if (add) {
				logger.trace("Adding Source Semantic Model Processor " + sourceSemanticProcessor.getName());
				sourceSemanticProcessors.add(sourceSemanticProcessor);
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
	public void sourceSemanticProcessing(MdmiTransferInfo transferInfo, ElementValueSet sourceSemanticModel) {

		for (ISemanticProcessor sourceSemanticProcessor : sourceSemanticProcessors) {
			logger.trace("Checking " + sourceSemanticProcessor.getName());
			if (sourceSemanticProcessor.canProcess(transferInfo.sourceModel.getModel())) {
				try {
					logger.info("Executing " + sourceSemanticProcessor.getName());
					sourceSemanticProcessor.processSemanticModel(sourceSemanticModel);
				} catch (Exception ex) {
					ex.printStackTrace();
					logger.error(
						"SourceSemanticModelProcessors.postProcess {0} throws an unexpected exception while processing source of transfer request",
						ex);
				}
			}
		}
	}

} // MdmiPostProcessors
