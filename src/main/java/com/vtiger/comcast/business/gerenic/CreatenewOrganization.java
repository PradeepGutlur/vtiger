package com.vtiger.comcast.business.gerenic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.gereriUtility.ExeclUtility;
import com.vtiger.comcast.gereriUtility.FileUtilfiy;
import com.vtiger.comcast.gereriUtility.JavaUtility;
import com.vtiger.comcast.gereriUtility.WebDriverUtility;

public class CreatenewOrganization {

	public CreatenewOrganization(WebDriver driver){
	
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement selectInd;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	
	

	public WebElement getSelectInd() {
		return selectInd;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
			
	}



	public void createOrg_with_Indurty(String orgName) {
		WebDriverUtility wdlib = new WebDriverUtility();
		orgNameEdt.sendKeys(orgName);
		wdlib.select(selectInd, "Construction");
		saveBtn.click();
		
		
	}
	
	
	
	
	

}
