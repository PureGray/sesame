package org.sesame.service.interfaces;

import org.sesame.service.entity.SerialNumber;
import org.sesame.service.entity.SerialNumberMeta;

public interface SerialNumberPopulator {
	public SerialNumber.Builder populate(SerialNumber.Builder sbBuilder,SerialNumberMeta serialNumberMeta);
}
