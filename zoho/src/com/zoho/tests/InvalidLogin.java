package com.zoho.tests;

import org.testng.annotations.Test;

import com.zoho.pages.LoginPage;

import generics.BaseTest;
import generics.UtilityLib;

public class InvalidLogin extends BaseTest {
	@Test(priority=2,groups={"login"})
	public void testInvalidLogin() throws InterruptedException{
		int rc=UtilityLib.getRowCount(INPUT_PATH, "InvalidLogin");
		for(int i=1;i<=rc;i++){
		String un=UtilityLib.getCellValue(INPUT_PATH,"InvalidLogin",i,0);
		String pw=UtilityLib.getCellValue(INPUT_PATH,"InvalidLogin",i,1);
		//enter invalid user name
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		//enter invalid password
		l.setPassword(pw);
		//click on login
		l.clickLogin();
		//verify err msg displayed
		l.verifyErrMsgIsDisplayed();
		}
	}
}
