package org.sesame.service;

import org.sesame.service.entity.SerialNumber;
import org.sesame.service.entity.SerialNumberMeta;
import org.sesame.service.factory.SerialNumberMetaFac;
import org.sesame.service.impl.populator.SerialNumberPopulatorImpl;
import org.sesame.service.interfaces.SerialNumberPopulator;
import org.sesame.service.util.SerialNumberConverter;
import org.testng.annotations.Test;

public class PopulatorTest {
  @Test
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
}
