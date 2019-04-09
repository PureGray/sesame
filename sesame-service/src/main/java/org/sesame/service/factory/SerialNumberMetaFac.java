package org.sesame.service.factory;

import org.sesame.service.entity.SerialNumberMeta;

public class SerialNumberMetaFac {
	public static SerialNumberMeta getSerialNumberMeta() {
		return new SerialNumberMeta((byte) 1, (byte) 2, (byte) 8, (byte) 41, (byte) 12);
	}
}
