package utilities; 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	public ExcelUtility(String path)	
	{
		this.path = path;
	}
	public int getRowcount(String sheet) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);		
		int rowCount = ws.getLastRowNum();		
		wb.close();
		fi.close();
		System.out.println(rowCount);
		return rowCount;		
	}
	public int getCellcount(String sheet, int rowNum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws= wb.getSheet(sheet);
		row = ws.getRow(rowNum);		 
		int cellCount = row.getLastCellNum();		
		wb.close();
		fi.close();
		System.out.println(cellCount);
		return cellCount;
	}
	
	public String getCellData(String sheet,int rowNum,int cellNum) throws IOException
	{
		String Data;
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);		
		row = ws.getRow(rowNum);		
		cell = row.getCell(cellNum);
		Data = cell.toString();
		/*DataFormatter formatter = new DataFormatter();
		try
		{		
		Data = formatter.formatCellValue(cell);		
		} catch(Exception e)
		{
			return Data ="";
		} */		
		wb.close();
		fi.close();
		return Data;
	}
	
	public void setCellData(String sheet,int rowNum,int cellNum,String data) throws IOException
	{
		File xfile = new File(path);
		if(!xfile.exists()) // if file not exists then create new file
		{
			wb = new XSSFWorkbook();
			fo = new FileOutputStream(xfile);
			wb.write(fo);
		}
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		if(wb.getSheetIndex(sheet)==-1)  //if sheet not exists then create new sheet
		   wb.createSheet(sheet);
		ws = wb.getSheet(sheet);
		if(ws.getRow(rowNum)==null) // if row not exists then create new row
		   ws.createRow(rowNum);	
		row = ws.getRow(rowNum);		
		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
}
