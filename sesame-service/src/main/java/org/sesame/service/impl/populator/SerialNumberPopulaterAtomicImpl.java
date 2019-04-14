package org.sesame.service.impl.populator;

import java.util.concurrent.atomic.AtomicReference;

import org.sesame.service.entity.SerialNumber.Builder;
import org.sesame.service.entity.SerialNumberMeta;
import org.sesame.service.interfaces.SerialNumberPopulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerialNumberPopulaterAtomicImpl implements SerialNumberPopulator{
 private static Logger log=LoggerFactory.getLogger(SerialNumberPopulaterAtomicImpl.class);
	class Timestamp{
		private long milliseconds=0;
		private long sequence=-1;
	}
	
	private AtomicReference<Timestamp> timestamp=new AtomicReference<Timestamp>(new Timestamp());
	public Builder populate(Builder snBuilder, SerialNumberMeta serialNumberMeta) {
		
		Timestamp oldTimestamp,newTimestamp;
		long milliseconds,sequence;
		
		while(true) {
			oldTimestamp=timestamp.get();
			milliseconds=System.currentTimeMillis()-EPOCH;
			sequence=oldTimestamp.sequence;
			if(milliseconds < oldTimestamp.milliseconds) {
				String msg = String.format("Clock moved backwards.  Refusing to generate id for %d milisecond.",
						oldTimestamp.milliseconds - milliseconds);
				if (log.isErrorEnabled())
					log.error(msg);

				throw new IllegalStateException(msg);
			}
			
			if(milliseconds==oldTimestamp.milliseconds) {
				sequence++;
				
				sequence &= serialNumberMeta.getSequenceBitsMask();
				
				if(sequence==0) {
					milliseconds=System.currentTimeMillis()-EPOCH;
				}
			}else {
				sequence=0;
			}
			
			newTimestamp=new Timestamp();
			newTimestamp.milliseconds=milliseconds;
			newTimestamp.sequence=sequence;
			
			if(timestamp.compareAndSet(oldTimestamp, newTimestamp)) {
				snBuilder.millisecond(milliseconds).sequence(sequence);
				break;
			}
		}
		
		return snBuilder;
	}

}
