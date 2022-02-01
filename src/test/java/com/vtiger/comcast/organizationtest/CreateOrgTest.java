package com.vtiger.comcast.organizationtest;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

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



public class CreateOrgTest extends basic_annotations {
	
	
	@Test(groups={"smokeTest"})
	public void createOrgTest() throws Throwable {
	
	/*test data*/
	int randomInt = jlib.getRandomNumber();
	
	String orgName = elib.getDataFromExecl("sheet1", 1, 1)+randomInt;
	
	
	//step 3 navigate to org
	Home hp = new Home(driver);
	hp.getOrganizationLnk().click();
	
	//step 4 navigate to organiztion page
	Organization org = new Organization(driver);
	org.getCreateorgIcon().click();
	

	//step 5 create org 
	CreatenewOrganization corg =new CreatenewOrganization(driver);
	corg.createOrg(orgName);

	
	
	//step 6 verify the create org
	OrganizationInfo orginf = new OrganizationInfo(driver);
	String act_msg = orginf.getSuccesfullMsg().getText();
	assertTrue(act_msg.contains(orgName));
	
	}
	
	@Test(groups ={"regressionTest"})
	public void createOrgWithIndu() throws Throwable {
	
		/*test data*/
		int randomInt = jlib.getRandomNumber();
		
		String orgName = elib.getDataFromExecl("sheet1", 1, 1)+randomInt;

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
	assertTrue(act_msg.contains(orgName));
	
	}
	
}