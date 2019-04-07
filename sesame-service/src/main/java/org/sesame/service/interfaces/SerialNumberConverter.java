package org.sesame.service.interfaces;

import org.sesame.service.entity.SerialNumber;

public interface SerialNumberConverter {
	public SerialNumber convert(long serialNumber);
	public long convert(SerialNumber serialNumber);
}
