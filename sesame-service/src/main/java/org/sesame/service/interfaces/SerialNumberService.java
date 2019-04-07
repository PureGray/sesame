package org.sesame.service.interfaces;

import org.sesame.service.entity.SerialNumber;

public interface SerialNumberService {
	public long getSerialNumber();
	public SerialNumber inverseSerialNumber(long serialNumber);
	public long generateSerialNumber(long milliseconds,long seq);
	public long generateSerialNumber(long machineId,long milliseconds,long seq);
	public long generateSerialNumber(long type,long machineId,long milliseconds,long seq);
	public long generateSerialNumber(long version,long type,long machineId,long milliseconds,long seq);
	
}
