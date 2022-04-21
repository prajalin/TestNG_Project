package qedge.feb22;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWrite {

	public static void main(String[] args) throws Throwable {
		// read path of excel file
		FileInputStream fi = new FileInputStream("C://Dummy.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Login");
		int rc = ws.getLastRowNum();
		System.out.println("no of rows are::" + rc);
		//iterate rows to get all rows,column data
		for(int i=1;i<=rc;i++)
		{
			String username = ws.getRow(i).getCell(0).getStringCellValue();
			String password = ws.getRow(i).getCell(1).getStringCellValue();
			System.out.println(username + "   " + password);
			//create cell and write
			ws.getRow(i).createCell(2).setCellValue("pass");
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("");
		wb.write(fo);
		fo.close();
		wb.close();
		
		}

}
