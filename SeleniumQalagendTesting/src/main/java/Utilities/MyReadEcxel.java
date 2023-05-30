package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class MyReadEcxel {
	private static final String NUMERIC = null;
	private static final String STRING = null;
	public static FileInputStream f;
	public static XSSFWorkbook w;
	public static XSSFSheet s;

	public static  String readIntData(int i,int j,String sheet)
		{
			String value = null ;
			try {
				f=new FileInputStream("C:\\Users\\Aneesh\\eclipse-workspace\\finalss\\projectframe-main (1)\\projectframe-main\\src\\test\\resources\\exceldata\\Product.xlsx");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			try {
				w=new XSSFWorkbook(f);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			s=w.getSheet(sheet);
			Row r=s.getRow(i);
			Cell c=r.getCell(j);
			
			switch (c.getCellType()) 
			{
			case STRING:
				value = c.getStringCellValue();
				break;
			case NUMERIC:
				int a=(int)c.getNumericCellValue();
				value=String.valueOf(a);
				
				break;
			default:
				break;
			}
			return value;
			}
	public static void main(String arg[])
	{
		System.out.println(MyReadEcxel.readIntData(1,0,"addingproducts"));
	}
	}


