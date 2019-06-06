package com.learnautomation.com.learnautomation.selenium;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNGAnnotationExample {
	
	
	
	@Test (priority = 1,groups = {"Smoke","funtional"})
	public void test1(){
		
		System.out.println("I am in Test1");
	}
	
	@Test  (priority = 6,groups ={"Smoke","funtional"})
	public void test2(){
	int i =5/0 ;
		System.out.println("I am in Test2");
	}
	@Test  (priority = 7,groups ={"funtional"})
	public void test7(){
		
		System.out.println("I am in Test7");
		Reporter.log("this is test set 7");
	}
	
	@Test  (priority = 3,groups ={"Smoke","funtional"})
	public void test3(){
		
		System.out.println("I am in Test3");
		Reporter.log("this is test set 3");
	}
	
	@Test  (priority = 4,groups ="Smoke",enabled = true)
	public void test4(){
		
		System.out.println("I am in Test4");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@Test   (priority = 5,groups ="Smoke")
	public void test5(){
		
		System.out.println("I am in Test5");
	}
	
	@Test    (priority = 2 ,groups ="Smoke")
	public void test6(){
		
		System.out.println("I am in Test6");
	}
	

}
