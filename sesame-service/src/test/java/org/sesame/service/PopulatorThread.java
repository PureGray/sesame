package org.sesame.service;

import org.sesame.service.entity.SerialNumber;
import org.sesame.service.entity.SerialNumberMeta;
import org.sesame.service.factory.SerialNumberMetaFac;
import org.sesame.service.impl.populator.SerialNumberPopulatorImpl;
import org.sesame.service.impl.populator.SerialNumberPopulatorSyncImpl;
import org.sesame.service.interfaces.SerialNumberPopulator;
import org.sesame.service.util.SerialNumberConverter;

public class PopulatorThread implements Runnable {

	SerialNumber.Builder snBuilder = new SerialNumber.Builder();
	SerialNumberPopulator populator = new SerialNumberPopulatorSyncImpl();
	SerialNumberMeta snMeta = SerialNumberMetaFac.getSerialNumberMeta();

	SerialNumber sn;

	PopulatorThread() {
		snBuilder.version(0).type(1).machineId(221);

	}

	public void run() {
		snBuilder = populator.populate(snBuilder, snMeta);
		sn = snBuilder.build();
		System.out.println(sn.toString());
		System.out.println("long serialNumber: " + SerialNumberConverter.convert(sn));

	}

}
