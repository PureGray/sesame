package org.sesame.service.impl.populator;

import org.sesame.service.entity.SerialNumber.Builder;
import org.sesame.service.entity.SerialNumberMeta;
import org.sesame.service.interfaces.SerialNumberPopulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerialNumberPopulatorImpl implements SerialNumberPopulator{
	private final static Logger log=LoggerFactory.getLogger(SerialNumberPopulatorImpl.class);
	private long lastMilliseconds=-1;
	private long sequence=0;
	
	public Builder populate(Builder snBuilder, SerialNumberMeta serialNumberMeta) {
		long milliseconds=System.currentTimeMillis();
		
		if(milliseconds < lastMilliseconds) {
			
			String msg=String
                    .format("Clock moved backwards.  Refusing to generate id for %d milisecond.",
                    		lastMilliseconds - milliseconds);
			if (log.isErrorEnabled())
                log.error(msg);
			
			throw new IllegalStateException(msg);
		}
		
		return snBuilder.millisecond(milliseconds).sequence(sequence);
	}

}
