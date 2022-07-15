package com.Vtiger.generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listners implements ITestListener {

	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {

		test=reports.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) { 
		test.log(Status.PASS, result.getMethod().getMethodName()+" method passed");

	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" method failed");
		test.log(Status.FAIL, result.getThrowable());

		String path = BaseClass.takeScreenshot(result.getMethod().getMethodName());
		
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onStart(ITestContext context) 
	{
		reporter = new ExtentSparkReporter("../TYSS_KALPANA1/VtigerApp_New.html");
		reporter.config().setDocumentTitle("Vtiger App");
		reporter.config().setTheme(Theme.STANDARD);

		reports= new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("env", "Prod");


	}

	public void onFinish(ITestContext context) {

		reports.flush();
	}


}
