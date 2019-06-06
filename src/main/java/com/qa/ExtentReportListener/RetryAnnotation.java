package com.qa.ExtentReportListener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.tools.ant.taskdefs.Retry;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryAnnotation implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		
		
		IRetryAnalyzer retry =  annotation.getRetryAnalyzer();
		
		
		if(retry == null) {
			annotation.setRetryAnalyzer(TestRetryListener.class);
		}
	}

}
