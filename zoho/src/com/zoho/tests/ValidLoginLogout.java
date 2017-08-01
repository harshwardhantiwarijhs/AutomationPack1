package com.zoho.tests;

import org.testng.annotations.Test;
import com.zoho.pages.EntertTimeTrackPage;
import com.zoho.pages.LoginPage;
import generics.BaseTest;
import generics.UtilityLib;

public class ValidLoginLogout extends BaseTest{
	@Test(priority=1,groups={"smoke","login"})
	public void testValidLoginLogout(){
		String un=UtilityLib.getCellValue(INPUT_PATH,"ValidLoginLogout",1,0);
		String pw=UtilityLib.getCellValue(INPUT_PATH,"ValidLoginLogout",1,1);
		String hp=UtilityLib.getCellValue(INPUT_PATH,"ValidLoginLogout",1,2);
		String lp=UtilityLib.getCellValue(INPUT_PATH,"ValidLoginLogout",1,3);
		//enter valid user name
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		//enter valid password
		l.setPassword(pw);
		//click on login
		l.clickLogin();
		//verify that home page..
		EntertTimeTrackPage e=new EntertTimeTrackPage(driver);
		e.verifyTitle(hp);
		//click logout
		e.clickLogout();
		//verify that login page...
		l.verifyTitle(lp);
	}
}
