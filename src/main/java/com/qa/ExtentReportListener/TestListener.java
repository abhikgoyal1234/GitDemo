package com.qa.ExtentReportListener;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.openqa.selenium.TakesScreenshot;

import framework.BaseClass;

public class TestListener extends BaseClass implements ITestListener{
	
	

	public static ExtentTest logger ;
	
	public static String getTestMethodName(ITestResult iTestResult) {
		
		
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am on this test Starting "+getTestMethodName(result) );
		
		
		logger = extent.createTest(result.getMethod().getMethodName());
		
		System.out.println("I am on this test Starting "+getTestMethodName(result) );
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am on onTestSuccess method "+getTestMethodName(result) +"success" );
		
		logger.log(Status.PASS, "This test case hase been Passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		logger.log(Status.FAIL, "This test case hase been Failed");
		//logger.fail(details, provider)
		     
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am on onTestSkipped method "+getTestMethodName(result) +"Skipped" );
		logger.log(Status.SKIP, "This test case hase been Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		  System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(result));
	}

	public void onStart(ITestContext iTestContext	) {
		// TODO Auto-generated method stub
		   System.out.println("I am in onStart method " + iTestContext.getName());
	     
		   
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("I am in onFinish method " + context.getName());
		
	}

}
