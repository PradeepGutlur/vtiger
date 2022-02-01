package com.vtiger.comcast.business.gerenic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {
	
	
	public Organization(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgIcon;
	
	@FindBy(id="search_txt")
	private WebElement searchEtn;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	
	
	public WebElement getSearchEtn() {
		return searchEtn;
	}



	public WebElement getSearchBtn() {
		return searchBtn;
	}



	public WebElement getCreateorgIcon() {
		return createorgIcon;
	}

}
