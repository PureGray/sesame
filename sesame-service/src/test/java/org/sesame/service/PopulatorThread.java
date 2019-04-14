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
	SerialNumberPopulator populator;
	SerialNumberMeta snMeta = SerialNumberMetaFac.getSerialNumberMeta();

	SerialNumber sn;

	PopulatorThread(SerialNumberPopulator populator) {
		snBuilder.version(0).type(1).machineId(221);
		this.populator=populator;
	}

	public void run() {
		for(int i=0;i<100;i++){
			snBuilder = populator.populate(snBuilder, snMeta);
			sn = snBuilder.build();
			System.out.println(sn.toString());
			System.out.println("long serialNumber: " + SerialNumberConverter.convert(sn));
		}
	}

}
