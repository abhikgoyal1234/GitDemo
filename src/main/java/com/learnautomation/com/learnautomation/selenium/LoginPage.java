package com.learnautomation.com.learnautomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Action;

public class LoginPage extends Action{

	WebDriver driver ;
	
	public LoginPage(WebDriver driver){
		this.driver =driver;
	}
	
	By userID = By.xpath("//input[@name='uid']");
	By passWord = By.xpath("//input[@name='password']");
	
	By login = By.xpath("//input[@name='btnLogin']");
	
	
	public void loginPage(String uId,String pass) {
		WebElement elementUid= driver.findElement(userID);
		inputText(driver, elementUid, uId);
		
		WebElement elementPass= driver.findElement(passWord);
		inputText(driver, elementPass, pass);
		
		WebElement loginButton= driver.findElement(login);
		click(driver, loginButton);
		
	}
	
	
	
	
	
}
