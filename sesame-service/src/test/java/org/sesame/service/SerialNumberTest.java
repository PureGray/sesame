package org.sesame.service;

import java.util.ArrayList;
import java.util.List;

import org.sesame.service.entity.SerialNumber;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class SerialNumberTest extends AbstractTestNGSpringContextTests {

	@Test
	public SerialNumberTest() {
		SerialNumber sn1=new SerialNumber.Builder().version(312).type(2).machineId(123).millisecond(1111).sequence(12).build();
		long startTime=System.nanoTime();
		List<SerialNumber> list1=new ArrayList<SerialNumber>();
		for(int i=0; i<100;i++) {
			SerialNumber sn=new SerialNumber.Builder().version(312).type(2).machineId(123).millisecond(1111).sequence(12).build();
			list1.add(sn);
		}
		
		long endTime=System.nanoTime();
		
		System.out.println("create 100 serial number take times: "+(endTime-startTime));
		System.out.println(list1.size());
		
	}

}
