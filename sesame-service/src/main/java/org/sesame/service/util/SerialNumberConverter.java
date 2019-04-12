package org.sesame.service.util;

import org.sesame.service.entity.SerialNumber;
import org.sesame.service.entity.SerialNumberMeta;
import org.sesame.service.factory.SerialNumberMetaFac;

public class SerialNumberConverter {
	private static SerialNumberMeta snMeta = SerialNumberMetaFac.getSerialNumberMeta();

	public static SerialNumber convert(long serialNumber) {
		long sequence = serialNumber & snMeta.getSequenceBitsMask();
		serialNumber = serialNumber >>> snMeta.getSequenceBits();
		long milliseconds = serialNumber & snMeta.getMillisecondBitsMask();
		serialNumber = serialNumber >>> snMeta.getMillisecondBits();
		long machineId = serialNumber & snMeta.getMachineIdBitsMask();
		serialNumber = serialNumber >>> snMeta.getMachineIdBits();
		long type = serialNumber & snMeta.getTypeBitsMask();
		serialNumber = serialNumber >>> snMeta.getTypeBits();
		long version = serialNumber & snMeta.getVersionBitsMask();

		return new SerialNumber.Builder().sequence(sequence).millisecond(milliseconds).machineId(machineId).type(type)
				.version(version).build();
	}

	public static long convert(SerialNumber serialNumber) {
		long sn = 0L;

		sn |= serialNumber.getSequence();
		sn |= serialNumber.getMillisecond() << snMeta.getgetMillisecondBitsStartPosition();
		sn |= serialNumber.getMachineId() << snMeta.getMachineIdBitsStartPosition();
		sn |= serialNumber.getType() << snMeta.getTypeBitsStartPosition();
		sn |= serialNumber.getVersion() << snMeta.getVersionBitsStartPosition();
		return sn;
	}

}
