package org.sesame.service.impl.populator;

import org.sesame.service.entity.SerialNumberMeta;

import java.util.concurrent.locks.ReentrantLock;

import org.sesame.service.entity.SerialNumber.Builder;

public class SerialNumberPopulatorLockImpl extends SerialNumberPopulatorImpl{
	ReentrantLock lock;
	public SerialNumberPopulatorLockImpl(){
		super();
		lock=new ReentrantLock();
	}
	
	@Override
	public Builder populate(Builder snBuilder, SerialNumberMeta serialNumberMeta) {
		try {
			lock.lock();
			return super.populate(snBuilder, serialNumberMeta);
		}finally {
			lock.unlock();
		}
	}
	
}
