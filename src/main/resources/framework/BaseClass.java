package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extent;

	public static WebDriver openBrowser() {

		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\Mercurytours\\driverjar\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();

		/*
		 * ExtentHtmlReporter reporter = new ExtentHtmlReporter(
		 * "E://Eclipse//com.learnautomation.selenium//Extent//nameOfTheReport.html");
		 * extent = new ExtentReports(); System.out.println(reporter.toString());
		 * extent.attachReporter(reporter);
		 */

		return driver;
	}

	public static void closeWindow() {
		driver.close();

	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

}
