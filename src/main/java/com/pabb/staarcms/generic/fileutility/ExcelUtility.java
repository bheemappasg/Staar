package com.pabb.staarcms.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 *@author bheem 
 * this excelUtility class contains methods like getaDataFromExcel,getRoCount and setDataIntoExcel
 */
public class ExcelUtility {
	
	/* this method is used to get the data from excel */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\bheempaecplise\\pabbSTAARCMS\\TestData\\StaarCMs.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		String data = cell.getStringCellValue();
		return data;	
	}
	/*This method is used get row count of the excel sheet */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\bheempaecplise\\pabbSTAARCMS\\TestData\\StaarCMs.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		return rowcount;
	}
	 /*This method is used to set the data into the excel */
	public void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\bheempaecplise\\pabbSTAARCMS\\TestData\\StaarCMs.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet(sheetName);
				Row row = sheet.getRow(rowNum);
				Cell cell = row.createCell(cellNum);
				cell.setCellValue(data);
				
				FileOutputStream fos= new FileOutputStream("C:\\Users\\admin\\eclipse-workspace\\bheempaecplise\\pabbSTAARCMS\\TestData\\StaarCMs.xlsx");
				wb.write(fos);
				wb.close();
	}

}
