package Vtiger_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.comcast.business.gerenic.CreatenewOrganization;
import com.vtiger.comcast.business.gerenic.Home;
import com.vtiger.comcast.business.gerenic.Login;
import com.vtiger.comcast.business.gerenic.Organization;
import com.vtiger.comcast.business.gerenic.OrganizationInfo;
import com.vtiger.comcast.gereriUtility.ExeclUtility;
import com.vtiger.comcast.gereriUtility.FileUtilfiy;
import com.vtiger.comcast.gereriUtility.JavaUtility;
import com.vtiger.comcast.gereriUtility.WebDriverUtility;

public class CreateOrg_with_industry {
	public static void main(String[] args) throws Throwable {
		/**
		 * @author Pradeep G V 
		 * create object 
		 * 
		 */
		ExeclUtility elib = new ExeclUtility();
		FileUtilfiy flib = new FileUtilfiy();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		/**
		 * read common data
		 */
		String Browser = flib.getPropertykeyvalue("browser");
		String url = flib.getPropertykeyvalue("url");
		String username = flib.getPropertykeyvalue("username");
		String password = flib.getPropertykeyvalue("password");
		
		/*test data*/
		int randomInt = jlib.getRandomNumber();
		
		String orgName = elib.getDataFromExecl("sheet1", 1, 1)+randomInt;
		
		/*step 1 lunch the browser*/
		WebDriver driver = null; 
		if(Browser.equals(Browser))
		{
			driver = new ChromeDriver();
			
		}else if(Browser.equals(Browser))
		{
			driver = new FirefoxDriver();
		}
		
		//step 2 login to app
		driver.get(url);
		wlib.waitUntilPageLoad(driver);
		Login lp = new Login(driver);
		lp.loginToApp(username, password);
		
		//step 3 navigate to org
		Home hp = new Home(driver);
		hp.getOrganizationLnk().click();
		
		//step 4 navigate to organiztion page
		Organization org = new Organization(driver);
		org.getCreateorgIcon().click();
		

		//step 5 create org 
		CreatenewOrganization corg =new CreatenewOrganization(driver);
		corg.createOrg_with_Indurty(orgName);
	
		
		
		//step 6 verify the create org
		OrganizationInfo orginf = new OrganizationInfo(driver);
		String act_msg = orginf.getSuccesfullMsg().getText();
		if(act_msg.contentEquals(act_msg))
				{
			System.out.println("org is created successful    passed");
				}else {
					System.out.println("org is not created     failed ");
				}
		//step 7 logout
		
		
		hp.logout();
		
		
		// step 8 close the browser
		driver.close();
		
	}
}
