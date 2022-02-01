package com.vtiger.comcast.contact.test;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.business.gerenic.Contact_info_page;
import com.vtiger.comcast.business.gerenic.Contact_page;
import com.vtiger.comcast.business.gerenic.CreatenewContactpage;
import com.vtiger.comcast.business.gerenic.CreatenewOrganization;
import com.vtiger.comcast.business.gerenic.Home;
import com.vtiger.comcast.business.gerenic.Login;
import com.vtiger.comcast.business.gerenic.Organization;
import com.vtiger.comcast.business.gerenic.OrganizationInfo;

import com.vtiger.comcast.gereriUtility.ExeclUtility;
import com.vtiger.comcast.gereriUtility.FileUtilfiy;
import com.vtiger.comcast.gereriUtility.JavaUtility;
import com.vtiger.comcast.gereriUtility.WebDriverUtility;
import com.vtiger.comcast.gereriUtility.basic_annotations;



public class Create_contact_Test extends basic_annotations {
	
	@Test(groups={"smokeTest"})
	public  void createContactTest() throws Throwable {
	
		
		/*test data*/
		int randomInt = jlib.getRandomNumber();
		
		String conname = elib.getDataFromExecl("sheet1", 1, 3)+randomInt;
		
		//step 3 navigate the contact
		
		Home hp = new Home(driver);
		hp.getContactsLnk().click();
		
		//step 4 create the conatact
		Contact_page cp = new Contact_page(driver);
		cp.getCreateIcon().click();
				
		//step 5 create new contact
		CreatenewContactpage cnp = new CreatenewContactpage(driver);
		cnp.getLastnameEdt().sendKeys(conname);
		cnp.getSaveBtn().click();
		
		//step 6 verify the contact 
		Contact_info_page coninfo = new Contact_info_page(driver);
		String act_msg = coninfo.getSuccesfullMsg().getText();
		if(act_msg.contentEquals(act_msg))
				{
			System.out.println("org is created successful    passed");
				}else {
					System.out.println("org is not created     failed ");
				}
	}
		
		@Test(groups={"regressionTest"})
		public void createContactWithOrg() throws Throwable {
		
			/*test data*/
			int randomInt = jlib.getRandomNumber();
			String orgName = elib.getDataFromExecl("sheet1", 1, 1)+randomInt;
			String conname = elib.getDataFromExecl("sheet1", 1, 3);
			
		Home hp = new Home(driver);
		hp.getOrganizationLnk().click();
		
		//step 4 navigate to organiztion page
		Organization org = new Organization(driver);
		org.getCreateorgIcon().click();
	
	//step 5 cteate the orga
		CreatenewOrganization corg =new CreatenewOrganization(driver);
		corg.createOrg(orgName);
		
		OrganizationInfo or = new OrganizationInfo(driver);
		wlib.waitforElementVisibility(driver, or.getSuccesfullMsg());
	//step 6 navigate to contact
			hp.getContactsLnk().click();
	
		//step 7 create the conatact
		Contact_page cp = new Contact_page(driver);
		cp.getCreateIcon().click();
		
		//step 8 create new contact
		CreatenewContactpage cnp = new CreatenewContactpage(driver);
		cnp.createcontact(conname, orgName);
		
		//step 9 verify the contact
		Contact_info_page cinfo = new Contact_info_page(driver);
		String actName = cinfo.getSuccesfullMsg().getText();
		System.out.println(conname);
		assertTrue(actName.contains(conname));
	
		String actname = cinfo.getOraname().getText();
		assertTrue(actname.trim().equals(orgName));
		
	}

}
