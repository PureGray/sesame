package org.sesame.service;

import java.util.Random;

import org.sesame.service.entity.SerialNumber;
import org.sesame.service.util.SerialNumberConverter;
import org.testng.annotations.Test;

public class SerialNumberConverterTest {
	@Test
	public void f() {

		long serialNumber = new Random().nextLong();
		SerialNumber sn = SerialNumberConverter.convert(serialNumber);
		long sn_c = SerialNumberConverter.convert(sn);

		System.out.println("random sn : " + serialNumber);
		System.out.println("sn object : " + sn);
		System.out.println(String.format("sn_c : %d", sn_c));

	}
}
