package qedge.feb22;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AllRowsData {

	public static void main(String[] args) throws Throwable {
		//get path of excel file
		FileInputStream fi = new FileInputStream("C://Dummy.xlsx");
		//get workbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		//get sheet from workbook
		XSSFSheet ws = wb.getSheet("Login");
		//count no of rows in sheet
		int rc = ws.getLastRowNum();
		System.out.println("no of rows are::" + rc);
		//iterate to get all row , column data
		for(int i=1;i<=rc;i++)
		{
			String username = ws.getRow(i).getCell(0).getStringCellValue();
			String password = ws.getRow(i).getCell(1).getStringCellValue();
			System.out.println(username+"    " + password);
		
		}
		fi.close();
		wb.close();
		

	}

}
