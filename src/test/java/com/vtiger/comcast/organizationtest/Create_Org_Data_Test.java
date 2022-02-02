package com.vtiger.comcast.organizationtest;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.comcast.business.gerenic.CreatenewOrganization;
import com.vtiger.comcast.business.gerenic.Home;
import com.vtiger.comcast.business.gerenic.Login;
import com.vtiger.comcast.business.gerenic.Organization;
import com.vtiger.comcast.business.gerenic.OrganizationInfo;
import com.vtiger.comcast.gereriUtility.ExeclUtility;
import com.vtiger.comcast.gereriUtility.basic_annotations;

public class Create_Org_Data_Test extends basic_annotations {
	@Test(dataProvider="createwithdata")
	public void createorg(String orgName, String IndutrsyType) throws Throwable {

		//step 3 navigate to org
		Home hp = new Home(driver);
		hp.getOrganizationLnk().click();
		
		//step 4 navigate to organiztion page
		Organization org = new Organization(driver);
		org.getCreateorgIcon().click();
		
		CreatenewOrganization corg =new CreatenewOrganization(driver);
		corg.createOrg_with_Indurty(orgName, IndutrsyType);
		
		
		
		OrganizationInfo orginf = new OrganizationInfo(driver);
		String act_msg = orginf.getSuccesfullMsg().getText();
		assertTrue(act_msg.contains(orgName));
		
		
	}
	}


