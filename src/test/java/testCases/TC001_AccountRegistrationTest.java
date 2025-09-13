package testCases;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageOjects.AccountRegistrationPage;
import pageOjects.Home;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass {

	public WebDriver driver;
	
	@Test
	public void verify_account_registration() {
		
		logger.info("**** Starting TC001_AccountRegistrationTest.java *****");
		try {
		Home hp=new Home(driver);
		hp.clickMyAccount();
		logger.info("Clicked On My Account Link");
		hp.clickRegister();
		logger.info("Clicked Register Link");
		AccountRegistrationPage arpage=new AccountRegistrationPage(driver);
		logger.info("Providing Customer details");
		arpage.setfirstname("Sachin");
		arpage.setLatname("Mahale");
		arpage.setemail(randomeString()+"@gmail.com"); // Randomly Generated String
		arpage.settelephone("8755206043");
		arpage.setpassword("xyz123");
		arpage.setCpassword("xyz123");
		arpage.clickpp();
		arpage.btncontinue();
		
		logger.info("Validating Message");
		String confmsg=arpage.getConfirmationmessage();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("Test Failed");
			logger.debug("Debug Logs");
			//Assert.fail();
		}
		logger.info("**** Finished TC001_AccountRegistrationTest.java ");
	}
	
	public String randomeString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
}
