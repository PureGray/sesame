package org.sesame.service.impl.provider;

import org.sesame.service.entity.SerialNumberMeta;
import org.sesame.service.factory.SerialNumberMetaFac;
import org.sesame.service.interfaces.MachineIdProvider;

/**
 * This provide a simple MachineIdProvider which just provides machineId by configure machineId
 * property & MachineIdBitsMask.
 * @author renlan
 *
 */
public class PropertyMachineIdProvider implements MachineIdProvider{
	private long machineId;
	private SerialNumberMeta snMeta;
	
	public PropertyMachineIdProvider() {
		snMeta=SerialNumberMetaFac.getSerialNumberMeta();
	}

	public long getMachineId() {
		
		return machineId;
	}
	
	public void setMachineId(long machineId) {
		this.machineId = machineId & snMeta.getMachineIdBitsMask();
	}

}
