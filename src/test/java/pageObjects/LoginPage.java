package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends basePage
{
	public LoginPage(WebDriver driver) 
	{
		super(driver);		
	}
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	public void setUsername(String username)
	{
		txtEmail.sendKeys(username);
	}
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);		
	}
	public void btnLoginClicked()
	{
		btnLogin.click();
	}

}
