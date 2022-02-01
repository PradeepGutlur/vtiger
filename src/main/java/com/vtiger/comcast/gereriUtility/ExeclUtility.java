package com.vtiger.comcast.gereriUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*its developed using Apache poi libraries , which used to handle microsoft execl sheet 
 * @pradeep g v 
 * 
 */

 
public class ExeclUtility {
	 /*its used read the data from execl base don below argments
	  * @param sheetname 
	  * @param rowNum
	  * @param celNum
	  * @return Data
	  * @throws Throwable
	  * 
	  */
	public String getDataFromExecl(String sheetname, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./property/testcase.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	/*
	 * used to get the last used row nuber on specified sheet 
	 * @param sheetname 
	 * @return 
	 * @throw Throwable
	 */
	
	public int getRowcount(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./property/testcase.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();		
	}
	public void setDataExecl(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./property/testcase.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		FileOutputStream fos = new FileOutputStream("./property/testcase.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
