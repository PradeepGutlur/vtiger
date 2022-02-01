package com.vtiger.comcast.business.gerenic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.gereriUtility.WebDriverUtility;

public class CreatenewContactpage extends WebDriverUtility{
	WebDriver driver;
	public CreatenewContactpage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orglookup;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrglookup() {
		return orglookup;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}
	public void createcontact(String contactName) {
		lastnameEdt.sendKeys(contactName);
		saveBtn.click();
	}
	
	
	public void createcontact(String contactName,String orgName ) {
		
		lastnameEdt.sendKeys(contactName);
		orglookup.click();
		switchToWindow(driver, "Accounts&action");
		Organization org = new Organization(driver);
		org.getSearchEtn().sendKeys(orgName);
		org.getSearchBtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
		
	}
	

}
