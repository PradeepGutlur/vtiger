package com.vtiger.comcast.gereriUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.vtiger.comcast.business.gerenic.Home;
import com.vtiger.comcast.business.gerenic.Login;

public class basic_annotations {
	

	public WebDriver driver = null;
	//public static WebDriver sdriver = null;
	
	public ExeclUtility elib = new ExeclUtility();
	public JavaUtility jlib = new JavaUtility();
	public FileUtilfiy flib = new FileUtilfiy();
	public WebDriverUtility wlib = new WebDriverUtility();
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configsBS() {
    System.out.println("====BD=====");

	}
	//@Parameters("browser")
    @BeforeClass(groups= {"smokeTest","regressionTest"})
    public void configBC() throws Throwable {
    	System.out.println("======launch the browser=====");
    	String Browser = flib.getPropertykeyvalue("browser");
    	
    
		if(Browser.equals(Browser))
		{
			driver = new ChromeDriver();
			
		}else if(Browser.equals(Browser))
		{
			driver = new FirefoxDriver();
		}
		//driver = sdriver;
    	
    }
   @BeforeMethod(groups={"smokeTest","regressionTest"})
   public void configBM() throws Throwable {
	   //common data
	   String url = flib.getPropertykeyvalue("url");
		String username = flib.getPropertykeyvalue("username");
		String password = flib.getPropertykeyvalue("password");
		
		driver.get(url);
		wlib.waitUntilPageLoad(driver);
	
		Login lp = new Login(driver);
		lp.loginToApp(username, password);
		
   }
   @AfterMethod(groups= {"smokeTest","regressionTest"})
   public void configAM() {
	 //logout
	   Home hp = new Home(driver);
	   hp.logout();
   }
   
   @AfterClass(groups= {"smokeTest","regressionTest"})
   public void configAC() {
	   driver.quit();
	   System.out.println("====close the browser====");
		
   }
   @AfterSuite(groups={"smokeTest","regressionTest"})
   public void configAS() {
	   System.out.println("=====close the DB=======");
   }
   @DataProvider
	public  Object[][] createwithdata() throws Throwable {
		ExeclUtility elib = new ExeclUtility();
		int rowcount = elib.getRowcount("Sheet2");
		Object[][] abjarr = new Object[rowcount][2];
		for(int i =0 ; i<rowcount; i++)
		{
		JavaUtility jlib = new JavaUtility();
			int radnum = jlib.getRandomNumber();
		  abjarr[i][0]= elib.getDataFromExecl("Sheet2", i, 0)+radnum;
		  abjarr[i][1]= elib.getDataFromExecl("Sheet2", i, 1);
			
		}
		return abjarr;
	
	}
   

}
