/*
 * MDIX - Model Driven Message Interoperability Runtime.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy at:
 *     http://www.apache.org/licenses/LICENSE-2.0
 */

package org.mdmi.core.runtime;

import java.util.ArrayList;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.core.Mdmi;
import org.mdmi.core.MdmiMessage;
import org.mdmi.core.MdmiModelRef;
import org.mdmi.core.MdmiTransferInfo;
import org.mdmi.core.MdmiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuntimeService {

	private static final Logger logger = LoggerFactory.getLogger(RuntimeService.class);

	public static String runTransformation(String srcMdl, byte[] srcData, String trgMdl,
			Properties sourcePropertyValues, Properties targetPropertyValues, JSONObject sourceValues,
			JSONObject targetValues) throws Exception {

		String[] srcParts = srcMdl.split("\\.");
		String srcMapName = srcParts[0];
		String srcMsgMdl = srcParts[1];

		String[] trgParts = trgMdl.split("\\.");
		String trgMapName = trgParts[0];
		String trgMsgMdl = trgParts[1];

		final ArrayList<String> filter = new ArrayList<>();

		logger.trace("Loading resolver (thread: {})", Thread.currentThread().getName());
		Mdmi.INSTANCE().getResolver().load(Mdmi.INSTANCE());

		MdmiModelRef sMod = new MdmiModelRef(srcMapName, srcMsgMdl);
		MdmiMessage sMsg = new MdmiMessage(srcData);
		MdmiModelRef tMod = new MdmiModelRef(trgMapName, trgMsgMdl);
		MdmiMessage tMsg = new MdmiMessage();

		logger.trace("Fetching business element references (thread: {})", Thread.currentThread().getName());
		ArrayList<MDMIBusinessElementReference> bers = MdmiUtil.getElements(sMod.getModel(), tMod.getModel(), filter);

		MdmiTransferInfo ti = new MdmiTransferInfo(sMod, sMsg, tMod, tMsg, bers);
		ti.sourceProperties = sourcePropertyValues;
		ti.targetProperties = targetPropertyValues;
		ti.sourceValues = sourceValues;
		ti.targetValues = targetValues;

		long start = System.nanoTime();
		logger.trace("Executing transfer (thread: {})", Thread.currentThread().getName());

		Mdmi.INSTANCE().executeTransfer(ti);

		long elapsedTime = System.nanoTime() - start;
		logger.trace("Transformation completed in {} ns", elapsedTime);

		String result = tMsg.getDataAsString();

		ti.targetMessage = null;
		ti.sourceMessage = null;

		return result;
	}

}
