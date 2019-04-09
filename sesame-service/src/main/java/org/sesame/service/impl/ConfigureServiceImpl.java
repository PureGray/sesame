package org.sesame.service.impl;

import org.sesame.service.interfaces.ConfigureService;
import org.sesame.service.interfaces.MachineIdProvider;

public class ConfigureServiceImpl implements ConfigureService{
	private  long version;
	private long type;
	private MachineIdProvider machineIdProvider;
	
	public void setVersion(long version) {
		this.version=version;
	}
	
	public void setType(long type) {
		this.type=type;
	}
	
	public void setMachineIdProvider(MachineIdProvider machineIdProvider) {
		this.machineIdProvider=machineIdProvider;
	}

	public long getVersion() {
		return version;
	}

	public long getType() {
		return type;
	}

	public long getMachineId() {
		return machineIdProvider.getMachineId();
	}

}
