package com.learnautomation.com.learnautomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Action;

public class WelcomeGuru99ManagerPage extends Action{

	By magrId = By.xpath("//table//table/tbody/tr[3]/td");
	WebDriver driver;
	
	public WelcomeGuru99ManagerPage(WebDriver driver){
		this.driver =driver;
	}
	public String getManUid() {
		WebElement element = driver.findElement(magrId);
		String magruId = getUserNameText(driver, element);
		return magruId;
		
	}
}
