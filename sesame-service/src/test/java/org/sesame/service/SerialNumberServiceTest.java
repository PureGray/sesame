package org.sesame.service;

import org.sesame.service.interfaces.SerialNumberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class SerialNumberServiceTest {
  @Test
  public void dbSerialNumberServiceTest() {
	  ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/sync-serial-number-service-bean.xml");
	  
	  SerialNumberService service=(SerialNumberService) applicationContext.getBean("serialNumberService");
	  
	  for(int i=0; i<4;i++) {
		  new testThread(i,service).start();
	  }
  }
  
  class testThread extends Thread{
	  private int index;
	  private SerialNumberService service;
	  
	  testThread(int i,SerialNumberService service){
		  this.index=i;
		  this.service=service;
	  }
	  
	  @Override
	  public void run() {
		  for(int i=0; i<10;i++) {
			  System.out.println(String.format("This is %s Thread, %sth, get serialNumber: %d",index,i,service.getSerialNumber()));
		  }
		 
		  
	  }
  }
}
