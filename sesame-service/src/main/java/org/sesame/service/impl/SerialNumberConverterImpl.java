package org.sesame.service.impl;

import org.sesame.service.entity.SerialNumber;
import org.sesame.service.interfaces.SerialNumberConverter;

public class SerialNumberConverterImpl implements SerialNumberConverter{

	public SerialNumber convert(long serialNumber) {
		return org.sesame.service.util.SerialNumberConverter.convert(serialNumber);
	}

	public long convert(SerialNumber serialNumber) {
		return org.sesame.service.util.SerialNumberConverter.convert(serialNumber);
	}

}
