package com.Vtiger.generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String readStrDatafromExcel(String sheetname,int rownum,int cellnum) throws Throwable 
	
	{
		FileInputStream fis = new FileInputStream("../SDET-HYD-6/excelData.xlsx");
		
		String str= WorkbookFactory.create(fis).getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		return str;
	}
	
	public int readNumericDatafromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis =new FileInputStream("../SDET-HYD-6/excelData.xlsx");
		int value	=(int) WorkbookFactory.create(fis).getSheet(sheetname).getRow(rownum).getCell(cellnum).getNumericCellValue();
		return value;
	}
	
	public int getLastRow(String sheetname) throws Throwable
	{
		FileInputStream fis=new FileInputStream("../SDET-HYD-6/excelData.xlsx");
		int value2=(int) WorkbookFactory.create(fis).getSheet(sheetname).getLastRowNum();
		return value2;
	}
	
	

}
