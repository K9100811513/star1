package com.TESTNG.pac;

import org.testng.annotations.Test;

public class Test2listners extends Annotations{
	
	@Test(groups = {"smoke"})
	public void testIOSapp() {
		System.out.println("testIOSapp");

	}
	@Test(groups = {"regression"})
	public void testdesktopapp() {
		System.out.println("testdesktopapp");
		
	}

}
