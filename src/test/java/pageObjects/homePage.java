package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage
{
	public homePage(WebDriver driver) 
	{
		super(driver);		
	}
	@FindBy (xpath = "//span[normalize-space()='My Account']")
	WebElement link_MyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement link_Register;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement link_Login;
	
	public void myAccountClicked()
	{
		link_MyAccount.click();
	}
	public void RegisterClicked()
	{
		link_Register.click();
	}
	public void LoginClicked()
	{
		link_Login.click();
	}
}
