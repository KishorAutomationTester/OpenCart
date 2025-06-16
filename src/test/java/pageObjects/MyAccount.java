package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccount extends basePage {

	public MyAccount(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement linkLogout;
	
	public boolean isMyAccountPageExist()
	{
		try
		{
			return msgHeading.isDisplayed();
		}catch(Exception e)
		{
			return false;
		}		
	}
	public void clickLogoutLink()
	{
		linkLogout.click();
	}

}
