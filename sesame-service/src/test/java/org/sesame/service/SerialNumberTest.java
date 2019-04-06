package org.sesame.service;

import org.sesame.service.entity.SerialNumber;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class SerialNumberTest extends AbstractTestNGSpringContextTests {

	@Test(groups = { "idService" })
	public SerialNumberTest() {
		SerialNumber sn=new SerialNumber.Builder().version(312).build();
		AssertJUnit.assertEquals(sn.getVersion(), 312);
	}

}
