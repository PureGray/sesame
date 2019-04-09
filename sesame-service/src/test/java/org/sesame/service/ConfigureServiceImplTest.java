package org.sesame.service;

import org.sesame.service.interfaces.ConfigureService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class ConfigureServiceImplTest {
  @Test
  public void f() {
	  ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
              "/sesame-service-property-factory-bean.xml");
	  
	ConfigureService configureService=(ConfigureService) applicationContext.getBean("configureService");
	
	System.out.println(configureService.getType());

	System.out.println(configureService.getVersion());
	
  }
}
