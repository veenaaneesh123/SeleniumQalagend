package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyExcelProvider {
	private static final String NUMERIC = null;
	private static final String STRING = null;
	public static FileInputStream f;
	public static XSSFWorkbook w;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	
		 public  static String[][] getExcelData(String fileName, String sheetName) throws IOException
		    {
		        String[][] data = null;
		        String value=null;
		        int num;
		        try 
		        {
		        int noOfRows = sheet.getPhysicalNumberOfRows();      
	            int noOfCols = row.getLastCellNum();
	            System.out.println(noOfCols+" "+noOfRows);
	            Cell cell;
	            data = new String[noOfRows][noOfCols];

	            for (int i = 1; i < noOfRows; i++) 
	            {
	                for (int j = 0; j < noOfCols; j++) 
	                {
	                    row = sheet.getRow(i);
	                    cell = row.getCell(j);
	                    switch (cell.getCellType())
	                    {
		        			case STRING:
		        				value = cell.getStringCellValue();
		        				break;
		        			case NUMERIC:
		        				num=(int) (cell.getNumericCellValue());
		        				value=String.valueOf(num);
		        				break;
		        			default:
		        				break;
	        			}
	                    
	                                                     	                    	                    
	                    data[i][j] = value;
	                }
	            }
	        }
	        catch (Exception e)
		        {
		            System.out.println("The exception is: " + e.getMessage());
		        }
	        return data;

}
		 public static void main(String arg[]) throws IOException
		 {
			 System.out.println(MyExcelProvider.getExcelData("C:\\Users\\Aneesh\\eclipse-workspace\\finalss\\projectframe-main (1)\\projectframe-main\\src\\test\\resources\\exceldata\\login.xlsx","sheet1"));
		 }
}