package com.zoho.tests;

import org.testng.annotations.Test;

import com.zoho.pages.EntertTimeTrackPage;
import com.zoho.pages.LicensePage;
import com.zoho.pages.LoginPage;

import generics.BaseTest;
import generics.UtilityLib;

public class VerifyVersion extends BaseTest{
	@Test(priority=3,groups={"smoke"})
	public void testVerifyVersion(){
		String un=UtilityLib.getCellValue(INPUT_PATH,"VerifyVersion",1,0);
		String pw=UtilityLib.getCellValue(INPUT_PATH,"VerifyVersion",1,1);
	
		//get the version present in login page
		LoginPage l=new LoginPage(driver);
		String version = l.getVersion();
		//enter valid user name
		l.setUserName(un);
		//enter valid password
		l.setPassword(pw);
		//click on login
		l.clickLogin();
		//click settings
		EntertTimeTrackPage e=new EntertTimeTrackPage(driver);
		e.clickSettings();
		//click Licenses
		e.clickLicenses();
		//verify that version & edition is same
		LicensePage lc=new LicensePage(driver);
		lc.verifyProductEdition(version);
		//click logout
		e.clickLogout();
	 }
}




