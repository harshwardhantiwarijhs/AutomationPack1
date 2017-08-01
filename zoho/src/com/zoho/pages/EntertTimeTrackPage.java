package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generics.BasePage;

public class EntertTimeTrackPage extends BasePage {

	@FindBy(id="logoutLink")
	private WebElement logoutLNK;
	
//	"//div[contains(text(),'Settings') and @class='popup_menu_label']";
	final String xp1="(//div[contains(text(),'Settings')])[1]";
	@FindBy(xpath=xp1)
	private WebElement settings;
	
	@FindBy(linkText="Licenses")
	private WebElement licenses;
	
	public EntertTimeTrackPage(WebDriver driver) {
		super(driver);
	}

	public void clickLogout(){
		try 
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e) 
		{
			
		}
		logoutLNK.click();
	}
	
	public void clickSettings(){
		try 
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e) 
		{
		}
		settings.click();
	}
	
	public void clickLicenses(){
		licenses.click();
	}
} //end of class




