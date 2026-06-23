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

import org.mdmi.core.engine.postprocessors.IPostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Collection of post processors registered with this runtime.
 * Will be loaded from the config file at the start, and may be updated later.
 */
public final class MdmiPostProcessors {

	private static Logger logger = LoggerFactory.getLogger(MdmiPostProcessors.class);

	private final ArrayList<IPostProcessor> postProcessors = new ArrayList<>();

	/**
	 * @return the postProcessors
	 */
	public ArrayList<IPostProcessor> getPostProcessors() {
		return postProcessors;
	}

	public void addPostProcessor(IPostProcessor postProcessor) {
		if (postProcessor != null) {
			boolean add = true;
			for (IPostProcessor registered : postProcessors) {
				if (registered.getName().equals(postProcessor.getName())) {
					add = false;
				}
			}
			if (add) {
				logger.trace("Adding post process " + postProcessor.getName());
				postProcessors.add(postProcessor);
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
	public void postProcess(MdmiTransferInfo transferInfo) {
		if (transferInfo == null) {
			throw new IllegalArgumentException("transferInfo is null");
		}
		for (int i = 0; i < postProcessors.size(); i++) {
			IPostProcessor postProcessor = postProcessors.get(i);
			logger.trace("Checking " + postProcessor.getName());
			logger.trace("messageModel.getGroup().getName() " + transferInfo.targetModel.getGroupName());
			if (postProcessor.canProcess(transferInfo.targetModel.getModel())) {
				try {
					logger.info("Executing " + postProcessor.getName());
					postProcessor.processMessage(transferInfo.targetModel.getModel(), transferInfo.targetMessage);
				} catch (Exception ex) {

					logger.error(
						"MdmiPostProcessor {0} throws an unexpected exception while processing source of transfer request",
						ex);
				}
			}
		}
	}

} // MdmiPostProcessors
