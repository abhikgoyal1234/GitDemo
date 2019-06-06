package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action{

	static WebDriverWait wait;
	public static void click(WebDriver driver,WebElement element)
	{  waitforObject( driver,element);		
	   JavascriptExecutor js = (JavascriptExecutor) driver ;
	   js.executeScript("arguments[0].click();", element);
		//element.click();
	}
	
	public void inputText(WebDriver driver,WebElement element,String text) {
		waitforObject( driver,element);
		/*JavascriptExecutor js = (JavascriptExecutor) driver ;
		  js.executeScript("document.getElementByName('firstName').value="+text);*/
		element.sendKeys(text);
		
	}
	
	public void selectDropDown(WebDriver driver,WebElement element,int countryIndex) {
		waitforObject( driver,element);
		Select country = new Select(element); 
		country.selectByIndex(countryIndex);
	}
	
	public String getAttribute(WebDriver driver,WebElement element,String value) {
		waitforObject( driver,element);
		String getInputField = element.getAttribute(value);
		return getInputField;
		
	}
	
    public static String getUserNameText(WebDriver driver,WebElement element) {
        waitforObject( driver,element);
		String userNameText = element.getText();
		return userNameText;
	}
	static void waitforObject(WebDriver driver,WebElement element)
	{  wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
	
	
//input
//getText()
//Selectdropdown
}

	
	
