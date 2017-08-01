package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import generics.BasePage;

public class LicensePage extends BasePage{
	
	//  "//b[contains(text(),'actiTIME')]"
	
	@FindBy(xpath="//nobr[text()='Product Edition:']/../../td[2]/b")
	private WebElement productEdition;
	
	public LicensePage(WebDriver driver) {
		super(driver);
	}
	
	public void verifyProductEdition(String eValue){
		String aValue=productEdition.getText();
		Assert.assertEquals(aValue, eValue);
	}

}
