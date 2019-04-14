package org.sesame.service.impl.populator;

import org.sesame.service.entity.SerialNumberMeta;
import org.sesame.service.entity.SerialNumber.Builder;

public class SerialNumberPopulatorSyncImpl extends SerialNumberPopulatorImpl{

	public SerialNumberPopulatorSyncImpl(){
		super();
	}
	
	@Override
	public synchronized Builder populate(Builder snBuilder, SerialNumberMeta serialNumberMeta) {
		return super.populate(snBuilder, serialNumberMeta);	
		
		
	}
}
