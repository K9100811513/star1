... package com.Vtiger.generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Vtiger.ObjectRe.HomePage;
import com.Vtiger.ObjectRe.LoginPage;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public PropertyFiles proppertyFiles= new PropertyFiles();
 //  @Parameters("BROWSER")
	@BeforeSuite
	public void connecttoDB() {
		System.out.println("====DB Connection====");
	}

	@AfterSuite
	public void disConnectDB() {
		System.out.println("=====Disconnected DB=====");
	}

	//@Parameters("BROWSER")
	@BeforeClass
	public void launchBrowser(String BROWSER) throws IOException 
	{
	//	String BROWSER=proppertyFiles.readDatafrompropertyfile("browser");

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("Invalid input");
		}
		sdriver=driver;
		driver.get(proppertyFiles.readDatafrompropertyfile("url"));
		webdriverutil webDriverUtil = new webdriverutil(driver);
		webDriverUtil.maxwindow();
		webDriverUtil.pageloadtimeout();

	}

	@BeforeMethod
	public void login() throws IOException 
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.logintoApp();

	}
	@AfterMethod
	public void logout() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.logoutfromApp();
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(10000);
		driver.close();
	}

	

	public static void takeScreenshot(String methodname) {
		TakesScreenshot screenshot = (TakesScreenshot)sdriver;
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);

		String dest = "../SDET6/screenshot/"+methodname+".png";

		File destpath = new File(dest);
		try {
			Files.copy(src, destpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	

	