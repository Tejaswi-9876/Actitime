package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasklink;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement reportslink;
	
	@FindBy(xpath = "//div[.='Users']")
	private WebElement userlink;
	
	@FindBy(id = "logoutLink")
	private WebElement lgbtn;
	
	//initialaization
	public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);

	}

	//utilization
	public WebElement getTasklink() {
		return tasklink;
	}


	public WebElement getReportslink() {
		return reportslink;
	}


	public WebElement getUserlink() {
		return userlink;
	}


	public WebElement getLgbtn() {
		return lgbtn;
	}
	
}
