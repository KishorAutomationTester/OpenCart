package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyAccount;
import pageObjects.homePage;
import testBase.Baseclass;
import utilities.Dataproviders;

public class tc_003_LoginDDTest extends Baseclass
{
	@Test (dataProvider = "LoginData", dataProviderClass = Dataproviders.class)
	public void verfiyLoginDDtest(String username,String pwd,String expStatus)
	{
		logger.info("************ tc_003_LoginDDTest ************");
		try
		{
		//Home Page	
		homePage hp = new homePage(driver);		
		hp.myAccountClicked();
		logger.info("My Account Link is Clicked");
		hp.LoginClicked();
		logger.info("Login Link is Clicked");
		//Login Page
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username Entered");
		lp.setPassword(pwd);
		logger.info("Password Entered");		
		lp.btnLoginClicked();
		logger.info("Login Button Clicked");
		Thread.sleep(3000);
		//MyAccount Page
		MyAccount macc = new MyAccount(driver);
		boolean status = macc.isMyAccountPageExist();
		
		if(expStatus.equalsIgnoreCase("Valid"))
		{
			if(status==true)
			{
				macc.clickLogoutLink();
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
			}
		}
		if(expStatus.equalsIgnoreCase("InValid"))
		{
			if(status==true)
			{
				macc.clickLogoutLink();
				Assert.assertTrue(false);
			}else
			{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****tc_003_LoginDDtest is Finished******");
	
	}
		

}
