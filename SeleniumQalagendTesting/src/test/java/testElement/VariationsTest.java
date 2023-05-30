package testElement;

import org.testng.annotations.Test;
import Utilities.CommonAction;
import Utilities.ExcelDataproviderUtility;
import Utilities.ReadConfigProperty;
import Utilities.WebDriverManager;
import pageElements.Loginpage;
import pageElements.VariationsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class VariationsTest extends WebDriverManager{
	public static WebDriver driver;
	ReadConfigProperty objprop = new ReadConfigProperty();
	VariationsPage objvary;
	CommonAction objAction;
	Loginpage objLogin ;
	ExcelDataproviderUtility objex;
	
  @Test(priority=1,enabled=true, dataProvider = "excelData",dataProviderClass=ExcelDataproviderUtility.class)
  public void login_using_exceldataProvider(String username,String password) {
	  objvary.login(username,password);
  }
  @BeforeMethod
  @Parameters({"browser"})
  public void beforeMethod(@Optional String Browser) {
	  driver=launchBrowser(Browser, objprop.url);
	  objvary=new VariationsPage(driver);
	  objex=new ExcelDataproviderUtility();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
