package org.sesame.service.impl;

import org.sesame.service.entity.SerialNumber.Builder;
import org.sesame.service.interfaces.SerialNumberPopulator;

public class SerialNumberServiceImpl extends SerialNumberServiceIAbstImpl{

	private SerialNumberPopulator populator;
	public void setPopulator(SerialNumberPopulator populator) {
		this.populator = populator;
	}

	public SerialNumberServiceImpl() {
		super();
	}
	
	public void init() {
		if(null ==configureService) {
			throw new IllegalStateException("configureService was failed to inject");
		}
		
		if(null==populator) {
			throw new IllegalStateException("SerialNumberPopulator was failed to inject");
		}
		
		super.init();
	}
	
	@Override
	protected Builder populate(Builder snBuilder) {
		
		return populator.populate(snBuilder, super.snMeta);
	}

}
