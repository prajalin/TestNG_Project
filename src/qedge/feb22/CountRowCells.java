package qedge.feb22;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CountRowCells {

	public static void main(String[] args) throws Throwable {
		//read path of excel file
		FileInputStream fi = new FileInputStream("C://Dummy.xlsx");
		//get workbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		//get sheet from workbook
		XSSFSheet ws = wb.getSheet("Login");
		//get first row from sheet
		XSSFRow row = ws.getRow(0);
		//count no. of rows from sheet
		int rowcount = ws.getLastRowNum();
		System.out.println("no of rows are::"+rowcount);
		//count no. of columns from first row
		int cellcount = row.getLastCellNum();
		System.out.println("no of columns are::"+cellcount);
		fi.close();
		wb.close();
		

	}

}
