package com.learnautomation.com.learnautomation.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Action;
import framework.BaseClass;

public class comPoseEmailPage extends Action {
	WebDriver driver ;
	
	comPoseEmailPage(WebDriver driver){
		this.driver = driver ;
	}

	By comPoseEmail = By.xpath("//div[@class='z0']//div[contains(text(),'Compose')]");
	By attachFile = By.xpath("//div[contains(@command,'Files')]//div[@class='a1 aaA aMZ']");
	
	
	public void comPoseEmail() {
		WebElement comPoseElement =  driver.findElement(comPoseEmail);
		click(driver,comPoseElement);
		comPoseElement.click();
	}
	
	public void attachFile() {
		WebElement attachElement =  driver.findElement(attachFile);
		List<WebElement> listofElement = driver.findElements(attachFile);
		listofElement.size();
		
		click(driver,attachElement);
	}
	
	
}
