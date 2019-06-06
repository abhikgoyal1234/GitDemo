package com.learnautomation.com.learnautomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.Action;

public class GmailSignInPage extends Action {

	WebDriver driver;
	
	public GmailSignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By signInButton = By.xpath("//div[@class='h-c-header__cta']//li[2]/a");
	By emilAdd = By.xpath("//input[@type = 'email']");
	By nextButton = By.xpath("//div[@class = 'ZFr60d CeoRYc']");
			By passWord = By.xpath("//div[@id='password']//input");
			By next2Button = By.xpath("//span[@class = 'RveJvd snByac']");

	
	public void enterEmailAdd() throws Exception {
		System.out.println("I am inside enterEmailAdd");
		WebElement element =driver.findElement(emilAdd);
		
		/*JavascriptExecutor js =   (JavascriptExecutor)driver;
		js.executeScript("window.location.reload()") ;*/
		
		//driver.navigate().refresh();
        
		Thread.sleep(2000);
		inputText(driver, element, "abhi.kgoyal1234@gmail.com");
	}
	
	public void clickNext() {
		WebElement nxtButton =driver.findElement(nextButton);
	//	wait.until(ExpectedConditions.visibilityOf(nxtButton));
		click(driver,nxtButton);
		
	}
	public void enterPassword() throws InterruptedException {
		
		WebElement element =driver.findElement(passWord);
	//	wait.until(ExpectedConditions.visibilityOf(element));
		inputText(driver, element, "ABhisshek12@");
		
		Thread.sleep(4000);
	}
	
	public void clickNextAgain() {
		WebElement nxt2Button =driver.findElement(next2Button);
		click(driver,nxt2Button);
	}
}
