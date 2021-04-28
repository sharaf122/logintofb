package learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public ExcelDataProvider() {
		File src= new File("");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			XSSFWorkbook wb= new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("unable to read excel file"+e.getMessage());
		}
		
	}
	public String getStringData(int sheetIndex,int row,int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row,int column) {
		return wb.getSheet("sheetName").getRow(row).getCell(column).getStringCellValue();
	}
	public double getNumericData(String sheetName,int row, int column) {
		return wb.getSheet("sheetName").getRow(row).getCell(column).getNumericCellValue();
	}

}
