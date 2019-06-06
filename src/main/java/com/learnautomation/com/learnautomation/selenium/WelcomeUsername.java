package com.learnautomation.com.learnautomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Action;

public class WelcomeUsername extends Action{
	WebDriver driver;
   
	By userNametext = By.xpath("//table//table//table//table/tbody/tr[3]/td[1]/p[3]//b");

	public WelcomeUsername(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void printUserNameText() {
		WebElement element = driver.findElement(userNametext);
		String userNameText =getUserNameText(driver, element);
		System.out.println(userNameText);
	}
}
