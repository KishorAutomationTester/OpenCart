package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.acc_Registration;
import pageObjects.homePage;
import testBase.Baseclass;

public class tc_001_Registration extends Baseclass
{	
	@Test  (groups={"Regression","Master"}) 
	void verifyAccountRegistration() throws InterruptedException
	{		
		logger.info("******** Starting tc_001_Registration ***********");
		try
		{
		homePage hp = new homePage(driver);
		Thread.sleep(3000);
		hp.myAccountClicked();
		logger.info("Clicked on My Account Link");
		hp.RegisterClicked();
		logger.info("Clicked on Register Link");
		acc_Registration regp = new acc_Registration(driver);
		logger.info("Providing Customer Registration details");
		regp.setFirstname(p.getProperty("userName"));
		regp.setLastname(randomString());
	 	regp.setEmail(randomString()+"@gmail.com");		
		regp.setTelephone(randomNumber());
		regp.setPassword(p.getProperty("pwd"));
		regp.setConfPassword(p.getProperty("pwd"));
		regp.clickchkOption();		
		regp.clickchkPolicy();
		regp.click_Sumbit();	
		String getMsg = regp.getConfrimmsg();
		System.out.println(getMsg);
		Assert.assertEquals(getMsg, "Your Account Has Been Created!");
		} catch(Exception e)
		{
			logger.error("Test Failed..");
			Assert.fail();
		}		
	}
		
}
