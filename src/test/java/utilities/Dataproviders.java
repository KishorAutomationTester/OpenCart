package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path =  ".//testData//DDTest.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		int totRow = xlutil.getRowcount("Sheet1");
		int totCell = xlutil.getCellcount("Sheet1", 1);
		
		String loginData[][] = new String[totRow][totCell];
		for(int i=1;i<=totRow;i++)
		{
			for(int j=0;j<totCell;j++)
			{
				loginData[i-1][j] = xlutil.getCellData("Sheet1", i, j);				
			}
		}
		return loginData;
	}
	


}
