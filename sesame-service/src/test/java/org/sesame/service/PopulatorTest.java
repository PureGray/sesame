package org.sesame.service;

import org.sesame.service.entity.SerialNumber;
import org.sesame.service.entity.SerialNumberMeta;
import org.sesame.service.factory.SerialNumberMetaFac;
import org.sesame.service.impl.populator.SerialNumberPopulaterAtomicImpl;
import org.sesame.service.impl.populator.SerialNumberPopulatorImpl;
import org.sesame.service.impl.populator.SerialNumberPopulatorLockImpl;
import org.sesame.service.impl.populator.SerialNumberPopulatorSyncImpl;
import org.sesame.service.interfaces.SerialNumberPopulator;
import org.sesame.service.util.SerialNumberConverter;
import org.testng.annotations.Test;

public class PopulatorTest {
 

  public void SerialNumberPopulatorImplTest() {
	  SerialNumber.Builder snBuilder=new SerialNumber.Builder();
	  SerialNumberPopulator populator=new SerialNumberPopulatorImpl();
	  SerialNumberMeta snMeta=SerialNumberMetaFac.getSerialNumberMeta();
	  
	  SerialNumber sn;
	  
	  snBuilder.version(0).type(1).machineId(221);
	  
	  for(int i=0; i<10;i++) {
		  snBuilder=populator.populate(snBuilder,snMeta);
		  sn=snBuilder.build();
		  System.out.println(sn.toString());
		  System.out.println("long serialNumber: "+SerialNumberConverter.convert(sn));
	  }
	  
	  
	  
  }
  
  
  public void SerialNumberPopulatorSyncImplTest() {
	  SerialNumberPopulator populator=new SerialNumberPopulatorSyncImpl();
	  for(int i=0; i<4;i++) {
		 new Thread(new PopulatorThread(populator)).start();
	  
	  }
  }
  

  public void SerialNumberPopulatorLockImplTest() {
	  SerialNumberPopulator populator=new SerialNumberPopulatorLockImpl();
	  for(int i=0; i<4;i++) {
		 new Thread(new PopulatorThread(populator)).start();
	  
	  }
  }
 
 @Test
 public void SerialNumberPopulatorAtomicImplTest() {
	  SerialNumberPopulator populator=new SerialNumberPopulaterAtomicImpl();
	  for(int i=0; i<4;i++) {
		 new Thread(new PopulatorThread(populator)).start();
	  
	  }
 }
}
