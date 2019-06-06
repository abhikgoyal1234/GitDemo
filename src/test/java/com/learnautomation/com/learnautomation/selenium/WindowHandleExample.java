package com.learnautomation.com.learnautomation.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import framework.BaseClass;


public class WindowHandleExample extends BaseClass{
	
	@BeforeMethod
	public void openBrowserUrl(){
		openBrowser();
		driver.get("http://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void closeAllTheWindow(){
		String currentTitle = driver.getTitle();
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindow =driver.getWindowHandles();
		
		for(String window : allWindow) {
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(window).close();
			}
			
		}
		driver.switchTo().window(mainWindow);
		System.out.println(currentTitle);
		Assert.assertTrue(driver.getWindowHandles().size()==1);
		Assert.assertTrue(currentTitle.contains("Jobs - Recruitment"));
	}

	
	@AfterTest
	public void closeBrowser() {
	//	closeWindow();
	}
	
	
}
