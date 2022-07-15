package selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportS 
{
	// Path,title,theme
	ExtentSparkReporter reporter;

	//Set config ,attch reporter
	ExtentReports reports;

	// To create entries in reports
	ExtentTest test;

	@Test
	public void generateReport() throws IOException
	{

		reporter = new ExtentSparkReporter("../TYSS_KALPANA1/KalpanaVtiger.html");
		reporter.config().setDocumentTitle("vtiger");
		reporter.config().setTheme(Theme.DARK);

		reports= new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("VERSION", "5.1");
		reports.setSystemInfo("env", "QA");


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		test=reports.createTest("facebook");
		driver.get("https://facebook.com");

		TakesScreenshot takescreenshot = (TakesScreenshot)driver;
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		String path ="../TYSS_KALPANA1/screenshot/Pic_1.png";
		File dest= new File(path);
		Files.copy(src, dest);

		
		test.addScreenCaptureFromPath(path);
		
		reports.flush();

	}

}
