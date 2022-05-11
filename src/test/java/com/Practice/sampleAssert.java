package com.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class sampleAssert {
	@Test
	public void org()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		WebElement un =driver.findElement(By.name("user_name"));
		boolean value=un.isDisplayed();
		
		Assert.assertEquals(value, false);
		un.sendKeys("admin");
		
		WebElement pwd =driver.findElement(By.name("user_password"));
		boolean pwdvalue=pwd.isDisplayed();
		
		Assert.assertEquals(pwdvalue,true);
		pwd.sendKeys("12345");
		
	WebElement bt=driver.findElement(By.id("submitButton"));
		bt.click();
		
		
	}

}
