package com.vtiger.comcast.business.gerenic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_page {
	WebDriver driver;
	public Contact_page(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createIcon;
	
	
	public WebElement getCreateIcon() {
		return createIcon;
	}

}
