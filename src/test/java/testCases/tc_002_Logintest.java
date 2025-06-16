                             package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyAccount;
import pageObjects.homePage;
import testBase.Baseclass;

public class tc_002_Logintest extends Baseclass
{
	@Test (groups={"sanity","Master"})                       
	void verifyLogin()
	{
		logger.info("************ tc_002_Logintest Started ************");
		try
		{
		//Home Page	
		homePage hp = new homePage(driver);		
		hp.myAccountClicked();
		logger.info("My Account Link is Clicked");
		hp.LoginClicked();
		logger.info("Login Link is Clicked");
		Thread.sleep(3000);
		//Login Page
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(3000);
		lp.setUsername(p.getProperty("email"));
		logger.info("Username Entered");
		lp.setPassword(p.getProperty("password"));
		logger.info("Password Entered");		
		lp.btnLoginClicked();
		logger.info("Login Button Clicked");
		//MyAccount Page
		MyAccount macc = new MyAccount(driver);
		boolean status = macc.isMyAccountPageExist();
		Assert.assertTrue(status);		
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			Assert.fail();
		}
		
	}
	
}
