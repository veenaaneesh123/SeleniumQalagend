package Utilities;
 import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataproviderUtility {
public static String userdir = System.getProperty("user.dir");

@DataProvider(name = "excelData")
public Object[][] excelDataProvider() throws IOException {

// We are creating an object from the excel sheet data by calling a method that
// reads data from the excel stored locally in our system
Object[][] arrObj = getExcelData(userdir + "\\src\\test\\resources\\exceldata\\login.xlsx", "Sheet1");
return arrObj;
}

// This method handles the excel - opens it and reads the data from the
// respective cells using a for-loop & returns it in the form of a string array
public String[][] getExcelData(String fileName, String sheetName) throws IOException
//public static void main(String args[])throws IOException
{
String[][] data = null;
String value = null;

// int num;
try {
FileInputStream fis = new FileInputStream(fileName);
XSSFWorkbook workbook = new XSSFWorkbook(fis);
XSSFSheet sheet = workbook.getSheet(sheetName);
XSSFRow row = sheet.getRow(0);
int noOfRows = sheet.getPhysicalNumberOfRows();
int noOfCols = row.getLastCellNum();
//System.out.println(noOfCols + " " + noOfRows);
data = new String[noOfRows - 1][noOfCols];
for (int i = 0; i < noOfRows - 1; i++) {
for (int j = 0; j < noOfCols; j++) {
DataFormatter df = new DataFormatter();
data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
}
}
for (String[] dataArr : data) {
//System.out.println(Arrays.toString(dataArr));
}
} catch (Exception e) {
System.out.println("The exception is: " + e.getMessage());
}

return data;
}

}

