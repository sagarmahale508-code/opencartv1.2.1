package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageOjects.Home;
import pageOjects.My_Account;
import pageOjects.login_page;
import testBase.BaseClass;

public class TC_002_Login_Test extends BaseClass {
	
	

	@Test
	public void verify_login() {
		logger.info("*****Starting TC_002_Login_Test*****");
		//Home
		Home hm=new Home(driver);
		hm.clickMyAccount();
		hm.clickLogin();
		
		//Login
		login_page lp=new login_page(driver);
		lp.setemail(p.getProperty("loginemail"));
		lp.setpwd(p.getProperty("loginpwd"));
		lp.clickLoginl();
		
		//Myaccount
		My_Account mAccount=new My_Account(driver);
		boolean targetpage=mAccount.ismyaccountDisplayed();
		
		Assert.assertTrue(targetpage);
		
		logger.info("******** Finished TC_002_Login_Test*******");
	}
}
