package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) {
		ExcelReader tr = new ExcelReader();
	System.out.println(tr.excelread());

	}

	public String excelread() {
		// TODO Auto-generated method stub
		FileInputStream file = null;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		String value = null;
		try {
			//file = new FileInputStream(new File("C:\\Users\\Aneesh\\eclipse-workspace\\finalss\\projectframe-main (1)\\projectframe-main\\src\\test\\resources\\exceldata\\Product.xlsx"));
			file = new FileInputStream(new File("src/test/resources/exceldata/Product.xlsx"));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			int noOfRows=sheet.getPhysicalNumberOfRows();
			XSSFCell cell = sheet.getRow(noOfRows-1).getCell(0);
			// Iterate through each rows one by one
//            Iterator<Row> rowIterator = sheet.ge
			switch (cell.getCellType()) {
			case STRING:
				value = cell.getStringCellValue();
				break;
			case NUMERIC:
				value = String.valueOf(cell.getNumericCellValue());
				break;
			default:
				break;
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;

	}
	

}
