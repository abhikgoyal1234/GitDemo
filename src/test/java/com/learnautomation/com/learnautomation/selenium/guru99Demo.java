package com.learnautomation.com.learnautomation.selenium;
import static org.testng.Assert.assertEquals;



import java.lang.reflect.Method;

import java.util.HashMap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import framework.BaseClass;
import framework.Excel;



public class guru99Demo extends BaseClass{
	//public WebDriver driver;
	public Excel exData;
	public Object[][] obj;
	


	@BeforeMethod()
	@Parameters({"url","exPath"})
	public void openBrowserUrl(Method m, String url,String exPath){
		 
		System.out.println("I am in open Browser Url");
	       
		
		openBrowser();
		driver.get(url);
		driver.manage().window().maximize();
		
		

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		String getMethodName = m.getName();
        System.out.println(getMethodName);
       
       // exData.loadCredInMap(getMethodName);
        
        
	}
	
	@DataProvider(name="getTestData")
	public Object[][] getTestData(){
		System.out.println("I am in getTestData before ");
		 exData = new Excel("E:\\Eclipse\\Mercurytours\\TestData\\Guru99DemoDataSheet1.xlsx");
		 System.out.println("I am in getTestData after ");
		 obj = exData.getloadDataINHashMap();
		 
		return obj;
       }
	
    @Test(priority =1,groups="Login",dataProvider ="getTestData", description="Invalid Login Scenario with wrong username and password.")
	public void verifyLoginSection(HashMap<String,String> map1,ITestContext ctx ) throws Exception {
    	
    	
    	
    	System.out.println(map1.get("c_UserName"));
    	System.out.println(map1.get("c_PassWord"));
    	
    	
    	LoginPage log = new LoginPage(driver);
    	
    	
    	log.loginPage(map1.get("c_UserName"),map1.get("c_PassWord") );
    	Thread.sleep(30000);
    	
    	WelcomeGuru99ManagerPage welmanPage = new WelcomeGuru99ManagerPage(driver);
    	String manUid = welmanPage.getManUid();
    	System.out.println(manUid);
    	assertEquals(manUid, "Manger Id : mngr173585");
    	
    	/*File file  = new File("E:\\Eclipse\\Mercurytours\\src\\pageClasses\\config.properties");
    	FileInputStream input = new FileInputStream(file);
    	Properties p = new Properties(); 
    	p.load(input);
    	
    	System.out.println(p.getProperty("database"));*/
    	
    	SoftAssert softAssert = new SoftAssert();
    	softAssert.assertTrue(manUid.contains("mngr173585"));
    }
   /* @Test (priority =2,groups="Login",dependsOnMethods="verifyLoginSection",expectedExceptions=NumberFormatException.class)
	public void verifyInvLoginSection() {
    	driver.get("http://www.demo.guru99.com/V4/");

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    	LoginPage log = new LoginPage(driver);
    	
    	
    	log.loginPage(exData.getData("c_UserName"),exData.getData("c_PassWord") );
    	
    	WelcomeGuru99ManagerPage welmanPage = new WelcomeGuru99ManagerPage(driver);
    	String manUid = welmanPage.getManUid();
    	System.out.println(manUid);
    	//assertEquals(manUid, "Manger Id : mngr173585");
    	
    	//oftAssert softAssert = new SoftAssert();
    	//softAssert.assertTrue(manUid.contains("mngr173585"));
    }*/
    @AfterMethod()
    public void closeBrowser( ITestResult result) throws Exception
   {
    	
    	 exData = new Excel("E:\\Eclipse\\com.learnautomation.selenium\\src\\main\\resources\\TestData\\Guru99DemoDataSheet1.xlsx");
    	
    	System.out.println("result"+result.getStatus());
    	    if(result.getStatus()==ITestResult.SUCCESS)
    	    {

    	        //Do something here
    	        System.out.println("passed ****");
    	        String status = "PASSED";
    	        exData.writeResultStatus(status);
    	    }

    	    else if(result.getStatus() == ITestResult.FAILURE)
    	    {
    	         //Do something here
    	        System.out.println("Failed *****");
    	        String status = "Failed";
    	        exData.writeResultStatus(status);
    	    }
    	closeWindow();
   
}}
