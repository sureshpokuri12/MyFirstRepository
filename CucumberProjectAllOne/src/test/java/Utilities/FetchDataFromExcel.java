package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Constants.AllConstants;

public class FetchDataFromExcel {

	public static String getURL(int x,int y) throws FileNotFoundException,IOException
	{
		FileInputStream fis=new FileInputStream(AllConstants.ExcelPath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFCell cellvalue=sheet.getRow(x).getCell(y);	
		
		String returnValue_in_the_form_Of_String=cellvalue.toString();
		return returnValue_in_the_form_Of_String;
	}
	
}
