package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util 
{
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public Util(String path)	
	{
		this.path = path;
	}
	
	public int getRowcount(String xlSheet) throws IOException
	{
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		int rowCount = ws.getLastRowNum();
		System.out.println("Total rows are" + " " +rowCount);		
		wb.close();
		fi.close();
		return rowCount;		
	}
	
	public int getCellcount(String xlSheet,int rowNum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		System.out.println("Total Cells are" + " " +cellCount);
		wb.close();
		fi.close();
		return cellCount;		
	}
	
	public String getCelldata(String xlSheet,int rowNum,int cellNum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(cellNum);
		String data;
		try
		{
			data = cell.toString();
			//DataFormatter formatter = new DataFormatter();
			//data = formatter.formatCellValue(cell);
		}catch (Exception e)
		{
			data = "";
		}		
		wb.close();
		fi.close();
		return data;
	}
	
	public void setCelldata(String xlSheet,int rowNum,int cellNum,String data) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		fo =new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();		
	}
	
	public void setCellbackgroundGreen(String xlSheet,int rowNum,int cellNum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(cellNum);
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}
	
	public void setCellbackgroundRed(String xlSheet,int rowNum,int cellNum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(cellNum);
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}
}
