package org.sesame.service.impl;

import org.sesame.service.entity.SerialNumber;
import org.sesame.service.interfaces.SerialNumberConverter;
import org.sesame.service.interfaces.SerialNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SerialNumberServiceIAbstImpl implements SerialNumberService{
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected long version;
	protected long type;
	protected long machineId;
	protected SerialNumberConverter snConverter;

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

	
	
}
