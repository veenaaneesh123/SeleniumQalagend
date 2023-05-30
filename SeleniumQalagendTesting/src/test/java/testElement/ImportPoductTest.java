package testElement;

import org.testng.annotations.Test;

import Utilities.CommonAction;
import Utilities.ReadConfigProperty;
import Utilities.WaitUtility;
import Utilities.WebDriverManager;
import pageElements.ImportProductPage;
import pageElements.Loginpage;
import pageElements.ProductPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class ImportPoductTest extends WebDriverManager
	{
		//public static WebDriver driver;
		ReadConfigProperty objprop = new ReadConfigProperty();
		ImportProductPage objimportpage;
		CommonAction objAction;
		WaitUtility wait;
		ProductPage objproductPage;
		Loginpage objlogin;
		//static ExcelDataProvider objexcel;
//	@Test(priority = 0,enabled =true)
//		public void loginSite() throws InterruptedException
//
//		{
//			objproductPage.login();
//			 //objimportpage.login(value,valu1);
//			 Assert.assertEquals(driver.getTitle(),"Home - QAlegend");
//			
//		 }
	
  @Test(priority = 1)
  public void add_new_file() throws InterruptedException 
  {
	  objlogin.login("admin","123456");
	  objimportpage.productclick();
	  objimportpage.addfile();
	  objimportpage.choosinfFile();
	 // objimportpage.submitclick();
  }

  @BeforeTest
  @Parameters({"browser"})
  public void beforeTest(@Optional String Browser)
  
  {    
	    driver=launchBrowser(Browser, objprop.url);
	    objimportpage=new ImportProductPage(driver);
	    objlogin=new Loginpage(driver);
	    //objexcel=new ExcelDataProvider();
	    objproductPage=new ProductPage(driver);
	    objAction=new CommonAction();
	    wait=new WaitUtility();
	   
	  
  }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }
//  @DataProvider(name="logins")
//  public static  Object[][] getDataFromDataprovider() throws IOException{
//	  Object[][] newdata=objexcel.getExcelData("C:\\Users\\Aneesh\\eclipse-workspace\\finalss\\projectframe-main (1)\\projectframe-main\\src\\test\\resources\\exceldata\\login.xlsx","sheet1");
//	  	return newdata;
 // }
}
