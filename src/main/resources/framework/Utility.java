package framework;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utility {

	
	
	public void takeScreenShot(WebDriver driver, String scrShotPath) {
		TakesScreenshot scrShot = (TakesScreenshot)driver;
		
		DateFormat dtfrmt = new SimpleDateFormat("dd-MM-yyyy h-m-s");
		Date dt = new Date();
        
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		String fileName = "Screen";
		 
		File desFile = new File(scrShotPath+fileName+dtfrmt.format(dt)+".png");
		
		try {
			FileUtils.copyFile(srcFile, desFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*	public  void takeScreenShot(WebDriver driver,String scrShotPath) {
		//convert webdriver object to take screenshot
		
		TakesScreenshot scrshot = (TakesScreenshot) driver;
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        Date date = new Date();
		//call screenshotAs method to create a screenshot file
		File srcFile=scrshot.getScreenshotAs(OutputType.FILE);
		
		//move this path to new path
		String fileName= "Screen";
		File desFile = new File(scrShotPath+fileName+dateFormat.format(date)+".png");
		
		try {
			FileUtils.copyFile(srcFile, desFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
	}

