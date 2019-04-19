package org.sesame.client;

import org.sesame.service.interfaces.SerialNumberService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/sesame-client.xml");
        context.start();
        SerialNumberService snService = (SerialNumberService)context.getBean("serialNumberService"); // 获取远程服务代理
        
        long start=System.nanoTime();
        for(int i=0;i<100000;i++) {
        	long sn = snService.getSerialNumber(); 
        }
        long end=System.nanoTime();
        
        System.out.println("============================"+String.valueOf(end-start)+"===========================================");
       
    }
}
