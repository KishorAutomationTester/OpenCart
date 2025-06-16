package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Util;

public class excelUtilitytest 
{

	public static void main(String[] args) throws IOException 
	{
		//WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");		
		//driver.manage().window().maximize();
		String path;
		/*
		String Filepath = System.getProperty("user.dir")+"\\testData\\ExcelUtiltest.xlsx";
		int rowCount = Util.getRowcount(Filepath, "sheet1");
		int cellCount = Util.getCellcount(Filepath, "sheet1", rowCount);
		System.out.println("Total Rows in Excel are " + rowCount);
		System.out.println("Total Cells in row are " + cellCount);
		for(int i=1;i<=rowCount;i++)
		{			
				String principleAmt = Util.getCelldata(Filepath, "sheet1", i, 0);	
				String rOI = Util.getCelldata(Filepath, "sheet1", i, 1);
				String period = Util.getCelldata(Filepath, "sheet1", i, 2);
				String freq = Util.getCelldata(Filepath, "sheet1", i, 3);
				String mValue = Util.getCelldata(Filepath, "sheet1", i, 4);
				String expectedValue = Util.getCelldata(Filepath, "sheet1", i, 5);
				
				System.out.println(principleAmt + " " + rOI + " " + period + " " + freq + " " + mValue + " " + expectedValue );
		}
		Util.setCelldata(Filepath, "sheet1", 1, 6, "Passed");
		*/
	}

}
