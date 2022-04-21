package qedge.feb22;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static void main(String[] args) throws Throwable {
		// read path of excel file
		FileInputStream fi = new FileInputStream("C://Dummy.xlsx");
		//get workbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		//get sheet from workbook
		XSSFSheet ws = wb.getSheetAt(0);
		//count nof rows in sheet
		int rc = ws.getLastRowNum();
		System.out.println("no of columns are::"+ rc);
		//get any row first cell data
		String username = ws.getRow(9).getCell(0).getStringCellValue();
		String password = ws.getRow(6).getCell(1).getStringCellValue();
		System.out.println(username +"  " + password);
		fi.close();
		wb.close();

	}

}
