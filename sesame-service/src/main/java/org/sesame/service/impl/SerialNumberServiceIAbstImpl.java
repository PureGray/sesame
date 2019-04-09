package org.sesame.service.impl;

import org.sesame.service.entity.SerialNumber;
import org.sesame.service.entity.SerialNumberMeta;
import org.sesame.service.factory.SerialNumberMetaFac;
import org.sesame.service.interfaces.ConfigureService;
import org.sesame.service.interfaces.SerialNumberConverter;
import org.sesame.service.interfaces.SerialNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SerialNumberServiceIAbstImpl implements SerialNumberService{
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected long version=0;
	protected long type=0;
	protected long machineId=-1;
	protected SerialNumberConverter snConverter;
	protected ConfigureService configureService;
	protected SerialNumberMeta snMeta;
	
	
	public void init() {
		if(null==snConverter) {
			setSerialNumberConverter(new SerialNumberConverterImpl());
		}
		
		if(null==configureService) {
			setConfigureService(new ConfigureServiceImpl());
		}
		
		if(snMeta==null) {
			setSerialNumberMeta(SerialNumberMetaFac.getSerialNumberMeta());
		}
		
		this.version=configureService.getVersion();
		this.type=configureService.getType();
		this.machineId=configureService.getMachineId();
	}
	
	public long getSerialNumber() {
		SerialNumber.Builder snBuilder=new SerialNumber.Builder();
		snBuilder.version(version).type(type).machineId(machineId);
		snBuilder=populate(snBuilder);
		SerialNumber sn=snBuilder.build();
		long ret=snConverter.convert(sn);
		
		if (log.isTraceEnabled())
            log.trace(String.format("Id: %s => %d", sn, ret));
		return ret;
	}
	
	protected abstract SerialNumber.Builder populate(SerialNumber.Builder snBuilder);

	public SerialNumber inverseSerialNumber(long serialNumber) {
		SerialNumber sn=snConverter.convert(serialNumber);
		return sn;
	}
	
	public void setVersion(long version) {
		this.version=version;
	}
	
	public void setType(long type) {
		this.type=type;
	}
	
	public void setMachineId(long machineId) {
		this.machineId=machineId;
	}
	
	public void setSerialNumberConverter(SerialNumberConverter snConverter) {
		this.snConverter=snConverter;
	}
	
	public void setConfigureService(ConfigureService configureService) {
		this.configureService=configureService;
	}
	
	public void setSerialNumberMeta(SerialNumberMeta snMeta) {
		this.snMeta=snMeta;
	}

	
	
}
