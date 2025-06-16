package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass 
{
	public static WebDriver driver;
	public Properties p;
	public Logger logger;
	@BeforeClass (groups={"sanity","Regression","Master"}) 
	@Parameters({"browser","os"})
	public void Setup(String br,String operatingSystem) throws IOException
	{		
		logger = LogManager.getLogger(this.getClass());
		FileReader file = new FileReader("./src//test//resources/config.properties");
		p = new Properties();
		p.load(file);
		String hubUrl = "http://localhost:4444/wd/hub";
			
			if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
				{		
					DesiredCapabilities cap = new DesiredCapabilities();	
					//os
					if(operatingSystem.equalsIgnoreCase("windows"))
							{
								cap.setPlatform(Platform.WIN10);
							}
					else if(operatingSystem.equalsIgnoreCase("mac"))
							{
								cap.setPlatform(Platform.MAC);
							}
					else
							{
								System.out.println("No Matching os");
							}
					//browser	
					switch(br.toLowerCase())
					{
						case "chrome"  : cap.setBrowserName("chrome");
									     break;
						case "firefox" : cap.setBrowserName("firefox");
										 break;
						case "edge"	   : cap.setBrowserName("InternetExplorerDriver");
									     break;
						default 	   : System.out.println("Invalid browser name");  return; 			 
					}
					
					driver = new RemoteWebDriver(new URL(hubUrl),cap);
				}
			if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			{
					switch(br.toLowerCase())
						{
							case "chrome"  : driver = new ChromeDriver();
													 break;
							case "firefox" : driver = new FirefoxDriver();
													 break;
												
							case "Edge" : driver = new InternetExplorerDriver();				
													 break;
							default     : System.out.println("No Matching Browser"); return;						 
						}
			  }			
					
		driver.manage().deleteAllCookies();	
		driver.get(p.getProperty("appUrl"));
		//driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();			
	}
	 @AfterClass (groups={"sanity","Regression","Master"})
	 public void TearDown()
	{
		driver.quit();
	}
	 
	 public String randomString()
		{
			String generatedString = RandomStringUtils.randomAlphabetic(6);
			System.out.println(generatedString);
			return generatedString;
		}
		
	 public String randomNumber()
		{
			String generatedNumber = RandomStringUtils.randomAlphanumeric(6);
			System.out.println(generatedNumber);
			return generatedNumber;
		}
	 
	 public String captureScreen(String tname) throws IOException
	 {
		 String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		 File sourFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		 String targetFilePath = System.getProperty("user.dir")+"\\screenShots\\" + tname + "_" + timeStamp + ".jpg";
		 File targetFile = new File(targetFilePath);
		 sourFile.renameTo(targetFile);
		 return targetFilePath;
	 }
}
