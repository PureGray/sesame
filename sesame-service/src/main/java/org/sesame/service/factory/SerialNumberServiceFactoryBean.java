package org.sesame.service.factory;

import org.sesame.service.interfaces.SerialNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

public class SerialNumberServiceFactoryBean implements FactoryBean<SerialNumberService>{
	protected final Logger log=LoggerFactory.getLogger(SerialNumberServiceFactoryBean.class);
	
	private SerialNumberService serialNumberService;
	public void setSerialNumberService(SerialNumberService snService) {
		this.serialNumberService = snService;
	}

	public SerialNumberService getObject() throws Exception {
		return serialNumberService;
	}

	public Class<?> getObjectType() {
		return SerialNumberService.class;
	}

	public boolean isSingleton() {
		return true;
	}

}
