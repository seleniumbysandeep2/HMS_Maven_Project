package com.hms.testscript;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hms.generic.BaseClass;

public class DoctorsModule extends BaseClass{

	@Test
	public void testCreatePatient() throws InterruptedException {
		Reporter.log("Create Patient",true);
		Thread.sleep(9000);  
	}
	
	
}
