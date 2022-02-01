package com.vtiger.comcast.business.gerenic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	//rule : create a sperate java class for ever page in a application
	WebDriver driver;
		public Home(WebDriver driver){
			this.driver= driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
		private WebElement organizationLnk;
		
		@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
		private WebElement contactsLnk;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement adminstatorImg;
		
		@FindBy(linkText="Sign Out")
		private WebElement signoutlnk;

		public WebElement getOrganizationLnk() {
			return organizationLnk;
		}

		public WebElement getContactsLnk() {
			return contactsLnk;
		}

		public WebElement getAdminstatorImg() {
			return adminstatorImg;
		}

		public WebElement getSignoutlnk() {
			return signoutlnk;
		}
		public void logout() {
			Actions act = new Actions(driver);
			act.moveToElement(adminstatorImg).perform();
			signoutlnk.click();
			
		}
		
		

}
