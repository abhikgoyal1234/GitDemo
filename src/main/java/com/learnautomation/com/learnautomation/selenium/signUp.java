package com.learnautomation.com.learnautomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Action;
import framework.BaseClass;

  

public class signUp extends Action{
	
	WebDriver driver;


	public signUp(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By firstName = By.xpath("//input[@name='firstName']");
	By lastName = By.xpath("//input[@name='lastName']");
	
	By eMail = By.xpath("//input[@name='email']");
	By countryName = By.xpath("//select[@name='country']");
	
	By passWord = By.xpath("//input[@name='password']");
	By conPassword = By.xpath("//input[@name='confirmPassword']");
	
	By submit = By.xpath("//input[@name='register']");
	
	
	public void firstName(String firstName1) {
	WebElement element =driver.findElement(firstName);
	inputText(driver,element,firstName1);
    }
	public String getFirstName() {
		String value ="value";
		WebElement element =driver.findElement(firstName);
		String getfirstNameValue =getAttribute(driver,element,value);
		return getfirstNameValue;
	    }
	public void lastName(String lastName1) {
		WebElement element =driver.findElement(lastName);
		inputText(driver,element,lastName1);
	}
	
	public void eMail(String eMail1) {
		WebElement element =driver.findElement(eMail);
		inputText(driver,element,eMail1);
	}
	
	public void countryName(int conIndex) {
		WebElement element =driver.findElement(countryName);
		selectDropDown(driver,element,conIndex);
	}
	
	public void passWord(String passWord1) {
		WebElement element =driver.findElement(passWord);
		inputText(driver,element,passWord1);
	    }
		
		public void conPassword(String confPass) {
			WebElement element =driver.findElement(conPassword);
			inputText(driver,element,confPass);
		}

		public void submit() {
			WebElement element =driver.findElement(submit);
			click(driver,element);
			
		}
}
