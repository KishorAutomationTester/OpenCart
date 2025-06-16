package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class acc_Registration extends basePage
{
	public acc_Registration(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_Fname;
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_Lname;
	@FindBy(xpath ="//input[@id='input-email']") WebElement txt_Email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_Telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_Password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_Cnfpassword;
	@FindBy(xpath="//label[normalize-space()='Yes']") WebElement chk_Options;
	@FindBy(xpath="//input[@name='agree']") WebElement chkPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_Submit;
	@FindBy(xpath="//*[@id='content']/h1") WebElement msgConfrimmsg;
	
	public void setFirstname(String fname)
	{
		txt_Fname.sendKeys(fname);
	}
	
	public void setLastname(String lname)
	{
		txt_Lname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	public void setTelephone(String tel)
	{
		txt_Telephone.sendKeys(tel);
	}
	public void setPassword(String pwd)
	{
		txt_Password.sendKeys(pwd);
	}
	public void setConfPassword(String cpwd)
	{
		txt_Cnfpassword.sendKeys(cpwd);
	}
	public void clickchkOption()
	{
		chk_Options.click();
	}
	
	public void clickchkPolicy()
	{
		chkPolicy.click();
	}
	public void click_Sumbit()
	{
		btn_Submit.click();
		
	/*	btn_Submit.submit();
		Actions act = new Actions(driver);
		act.moveToElement(btn_Submit).click().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn_Submit);
		btn_Submit.sendKeys(Keys.RETURN);
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.elementToBeClickable(btn_Submit)).click();
		
	*/
	}
	
	public String getConfrimmsg()
	{
		try
		{
			return (msgConfrimmsg.getText());
			
		} catch (Exception e)
		{
			return (e.getMessage());
		}
	}  
	
}
