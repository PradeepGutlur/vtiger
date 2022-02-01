package Vtiger_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.comcast.gereriUtility.ExeclUtility;
import com.vtiger.comcast.gereriUtility.FileUtilfiy;
import com.vtiger.comcast.gereriUtility.JavaUtility;
import com.vtiger.comcast.gereriUtility.WebDriverUtility;

public class Createorganization_dropdown {

	public static void main(String[] args) throws Throwable {
		
		//object Creation for lib
		FileUtilfiy flib = new FileUtilfiy();
		ExeclUtility elib = new ExeclUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wblib = new WebDriverUtility();
		
		int randomInt = jlib.getRandomNumber();
		//commom data
		String username = flib.getPropertykeyvalue("username");
		String password = flib.getPropertykeyvalue("password");
		String url = flib.getPropertykeyvalue("url");
		String browser = flib.getPropertykeyvalue("browser");
		
		//test script data
		String orgName = elib.getDataFromExecl("sheet1", 1, 1)+randomInt;
		//navigate
		WebDriver driver = null;
		
		if(browser.contentEquals(browser))
		{
			driver = new ChromeDriver();
		}
		else if(browser.contentEquals(browser)){
			driver= new FirefoxDriver();
		}
		
		driver.get(url);
		wblib.waitUntilPageLoad(driver);
		// step 1 login
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//create the organization 
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		WebElement ele = driver.findElement(By.name("industry"));
		wblib.select(ele, "Engineering");
		driver.findElement(By.name("button")).click();
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wblib.mouseover(driver, ele1);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

}
