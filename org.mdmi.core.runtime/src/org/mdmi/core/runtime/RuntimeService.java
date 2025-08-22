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

	private static Logger logger = LoggerFactory.getLogger(RuntimeService.class);

	//
	public static String runTransformation(String srcMdl, byte[] srcData, String trgMdl,
			Properties sourcePropertyValues, Properties targetPropertyValues, JSONObject sourceValues,
			JSONObject targetValues) throws Exception {

		String retVal = null;

		String[] a = srcMdl.split("\\.");
		String srcMapName = a[0];
		String srcMsgMdl = a[1];
		a = trgMdl.split("\\.");
		String trgMapName = a[0];
		String trgMsgMdl = a[1];
		final ArrayList<String> filter = new ArrayList<>();

		logger.trace("Start Mdmi.INSTANCE().getResolver().load(Mdmi.INSTANCE()) " + Thread.currentThread().getName());

		Mdmi.INSTANCE().getResolver().load(Mdmi.INSTANCE());

		logger.trace("End Mdmi.INSTANCE().getResolver().load(Mdmi.INSTANCE()) " + Thread.currentThread().getName());
		MdmiModelRef sMod = new MdmiModelRef(srcMapName, srcMsgMdl);
		MdmiMessage sMsg = new MdmiMessage(srcData);
		MdmiModelRef tMod = new MdmiModelRef(trgMapName, trgMsgMdl);
		MdmiMessage tMsg = new MdmiMessage();

		logger.trace(
			"Start  MdmiUtil.getElements(sMod.getModel(), tMod.getModel(), filter) " +
					Thread.currentThread().getName());
		ArrayList<MDMIBusinessElementReference> bers = MdmiUtil.getElements(sMod.getModel(), tMod.getModel(), filter);
		logger.trace(
			"End  MdmiUtil.getElements(sMod.getModel(), tMod.getModel(), filter) " + Thread.currentThread().getName());

		MdmiTransferInfo ti = new MdmiTransferInfo(sMod, sMsg, tMod, tMsg, bers);

		ti.sourceProperties = sourcePropertyValues;
		ti.targetProperties = targetPropertyValues;
		ti.sourceValues = sourceValues;
		ti.targetValues = targetValues;

		long start = System.nanoTime();

		logger.trace("Start Mdmi.INSTANCE().executeTransfer(ti) " + Thread.currentThread().getName());

		Mdmi.INSTANCE().executeTransfer(ti); // do something

		logger.trace("End Mdmi.INSTANCE().executeTransfer(ti) " + Thread.currentThread().getName());

		long elapsedTime = System.nanoTime() - start;

		logger.trace("Elapsed time for transformaiton" + elapsedTime);
		retVal = tMsg.getDataAsString();

		// ti.
		ti.targetMessage = null;
		ti.sourceMessage = null;
		// ti.

		return retVal; // return the target message transformed
	}

	public static void loadMapzzz(String srcMap, String srcMdl) throws Exception {
		Mdmi mdmi = Mdmi.INSTANCE();
		mdmi.start();
		Mdmi.INSTANCE().putMapInfo(new Mdmi.MapInfo(srcMdl, srcMap));
		Mdmi.INSTANCE().getResolver().load(Mdmi.INSTANCE());
	}

}
