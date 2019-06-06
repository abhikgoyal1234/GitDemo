package com.learnautomation.com.learnautomation.selenium;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleXpath {

	public static By linkTag = By.tagName("a");
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\Mercurytours\\driverjar\\chromedriver.exe");
  
  WebDriver driver = new ChromeDriver();
  
  driver.get("https://www.ebay.com/");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  
  List<WebElement> lstOfElements = driver.findElements(linkTag);
  lstOfElements.size();
  System.out.println(lstOfElements.size());
  Iterator<WebElement> itr = lstOfElements.iterator();
  int i = 0;
  while(itr.hasNext()) {
	  WebElement a = itr.next();
	  System.out.println("Text for link :" +a.getText());
	  i++;
	  System.out.println("Text for link :" +i);
  }
  
   String s = "ABhishek";
   s=s.replace('A', 'B') ;
  
   System.out.println("The value for s :" +s);
  
  
  
	}

}
