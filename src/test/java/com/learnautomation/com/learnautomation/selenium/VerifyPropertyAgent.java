package com.learnautomation.com.learnautomation.selenium;

import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyPropertyAgent {
	WebDriver driver;

	@BeforeMethod
	public void launchUrl() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Eclipse\\Mercurytours\\driverjar\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.zoopla.co.uk/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	@Test
	public void verifyProperty_() throws InterruptedException {

		WebElement propertyLocation = driver.findElement(By.xpath("//input[@id='search-input-location']"));
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		driverWait.until(ExpectedConditions.visibilityOf(propertyLocation));
		propertyLocation.sendKeys("Uxbridge, London");

		WebElement searchElement = driver.findElement(By.xpath("//button[@id='search-submit']"));
		driverWait.until(ExpectedConditions.elementToBeClickable(searchElement));
		searchElement.click();

		List<WebElement> allPrice = driver
				.findElements(By.xpath("//li[contains(@class,'srp clearfix')]//a[@class='listing-results-price text-price']"));
		
		System.out.println(allPrice.size());

		TreeSet<Integer> propertyPrice = new TreeSet<Integer>();
		for (WebElement propertyValue : allPrice) {

			propertyPrice.add(Integer.parseInt(propertyValue.getText().replaceAll("[,£a-zA-Z ]", "")));

		}

		for (Integer  onePropertyPrice : propertyPrice) {

			java.text.NumberFormat format = java.text.NumberFormat.getCurrencyInstance(java.util.Locale.UK);
			System.out.println(format.format(onePropertyPrice));
		//	System.out.println(onePropertyPrice);

		}
		
		WebElement propperty5Element = driver
				.findElement(By.xpath("//li[contains(@class,'srp clearfix')][5]//a[@class='photo-hover']"));
		
		Thread.sleep(2000);
		
		propperty5Element.click();
		
		WebElement agentNameElement = driver
				.findElement(By.xpath("//div[@class='ui-agent__text']/h4[contains(@class,'ui-agent__name')]"));
		
		Thread.sleep(2000);
		
	
		agentNameElement.click();
		
		

	}

}
