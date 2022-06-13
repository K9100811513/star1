package com.TESTNG.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TGAnnotations {
	@BeforeSuite(groups= {"smoke","sanity","regression"})
	public void bs()
	{
		System.out.println("before suite");
	}
	@AfterSuite(groups= {"smoke","sanity","regression"})
	public void as()
	{
		System.out.println("After suite");
	}
	
	@BeforeTest(groups= {"smoke","sanity","regression"})
	public void bt()
	{
		System.out.println("before test");
	}
	@AfterTest(groups= {"smoke","sanity","regression"})
	public void at()
	{
		System.out.println("After test");
	}@BeforeClass(groups= {"smoke","sanity","regression"})
	public void bc()
	{
		System.out.println("before class");
	}
	@AfterClass(groups= {"smoke","sanity","regression"})
	public void ac()
	{
		System.out.println("After class");
	}
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void bm()
	{
		System.out.println("before suite");
	}
	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void am()
	{
		System.out.println("After suite");
	}
	
	


}
