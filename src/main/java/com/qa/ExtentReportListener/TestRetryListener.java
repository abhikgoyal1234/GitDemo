package com.qa.ExtentReportListener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetryListener implements IRetryAnalyzer{

	
	int counter = 0;
	int maxRetryCounter =2 ;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (counter<maxRetryCounter && !result.isSuccess()) {
			System.out.println("Retrying test " + result.getName() + " with status "
                    + result.getStatus()+ " for the " + (counter+1) + " time(s).");
			++counter;
			return true;
		}
		return false;
	}

}
