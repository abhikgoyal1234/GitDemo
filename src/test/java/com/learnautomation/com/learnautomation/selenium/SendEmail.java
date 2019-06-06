package com.learnautomation.com.learnautomation.selenium;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import framework.BaseClass;
import framework.Utility;

public class SendEmail extends BaseClass {

	@BeforeTest
	public void launchGmail() {
		openBrowser();
		driver.get("https://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void sendEmail() throws Exception {
		GmailSignInPage gmSnPage = new GmailSignInPage(driver);
		gmSnPage.enterEmailAdd();
		System.out.println(driver.getTitle());
		gmSnPage.clickNext();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		GmailSignInPage gmSnPage1 = new GmailSignInPage(driver);

		gmSnPage1.enterPassword();
		gmSnPage1.clickNextAgain();
		// Thread.sleep(30000);

		// driver.switchTo().frame(1);
		comPoseEmailPage cmPoEMail = new comPoseEmailPage(driver);
		cmPoEMail.comPoseEmail();
		cmPoEMail.attachFile();

		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_D);

		rb.keyRelease(KeyEvent.VK_D);

		Thread.sleep(2000);

		rb.keyPress(KeyEvent.VK_COLON);

		rb.keyRelease(KeyEvent.VK_COLON);

		rb.keyPress(KeyEvent.VK_BACK_SLASH);

		rb.keyRelease(KeyEvent.VK_BACK_SLASH);

		Thread.sleep(2000);

		rb.keyPress(KeyEvent.VK_S);
		rb.keyRelease(KeyEvent.VK_S);

		rb.keyPress(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_C);

		rb.keyPress(KeyEvent.VK_R);
		rb.keyRelease(KeyEvent.VK_R);

		rb.keyPress(KeyEvent.VK_E);
		rb.keyRelease(KeyEvent.VK_E);

		rb.keyPress(KeyEvent.VK_E);
		rb.keyRelease(KeyEvent.VK_E);

		rb.keyPress(KeyEvent.VK_N);
		rb.keyRelease(KeyEvent.VK_N);

		rb.keyPress(KeyEvent.VK_STOP);
		rb.keyRelease(KeyEvent.VK_STOP);

		rb.keyPress(KeyEvent.VK_P);
		rb.keyRelease(KeyEvent.VK_P);

		rb.keyPress(KeyEvent.VK_N);
		rb.keyRelease(KeyEvent.VK_N);

		rb.keyPress(KeyEvent.VK_G);
		rb.keyRelease(KeyEvent.VK_G);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		String scrShotPath = "D:\\Screenshots\\";
		Utility utiScreenSHot = new Utility();
		utiScreenSHot.takeScreenShot(driver, scrShotPath);

	}

	@AfterMethod
	public void closebrowser() {
		driver.quit();
		// closeWindow();
	}
}
