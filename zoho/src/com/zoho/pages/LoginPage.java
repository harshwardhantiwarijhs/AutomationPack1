
package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.BasePage;

public class LoginPage extends BasePage{
	
	@FindBy(id="username")
	private WebElement unTXB;
	
	@FindBy(name="pwd")
	private WebElement pwTXB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	final String xp="//span[contains(.,'invalid')]";
	@FindBy(xpath=xp)
	private WebElement errMsg;
	
	@FindBy(xpath="//nobr[contains(text(),'actiTIME')]")
	private WebElement actiTIMEVersion;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}

	public void setUserName(String un){
		unTXB.sendKeys(un);
	}
	
	public void setPassword(String pw){
		pwTXB.sendKeys(pw);
	}

	public void clickLogin(){
		loginBTN.click();
	}
	
	public void verifyErrMsgIsDisplayed(){
		verifyElementIsPresent(errMsg);
	}
	
	public String getVersion(){
		return actiTIMEVersion.getText();
	}
}//end of class






