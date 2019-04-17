package org.sesame.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SesameServer {
	 public static void main(String[] args) throws IOException {
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
	                "sesame-server.xml");

	        context.start();

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        while (!"exit".equals(br.readLine()))
	            try {
	                Thread.sleep(60000);
	            } catch (InterruptedException e) {
	                // If error, print it to console
	                e.printStackTrace();
	            }
	        ;
	    }
}
