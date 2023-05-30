package testElement;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.CommonAction;
import Utilities.MyReadEcxel;
import Utilities.ReadConfigProperty;
import Utilities.WebDriverManager;
import pageElements.BrandPages;
import pageElements.ProductPage;
@Listeners(Utilities.TestListener.class)
public class ProductTest extends WebDriverManager 
{
public static WebDriver driver;
ReadConfigProperty objprop = new ReadConfigProperty();
BrandPages objbrand;
CommonAction objAction;
ProductPage objproductpage;



@Test(priority = 0,enabled =true)
public void loginSite() throws InterruptedException{
	objproductpage.login(MyReadEcxel.readIntData(0,0, "loginsheet"),MyReadEcxel.readIntData(0,1, "loginsheet"));
	 String expected=objAction.getText(objbrand.home);
	  Assert.assertEquals(expected, "Home");	  
	
 }
@Test(priority = 1,enabled =true)
public void addProduct() throws InterruptedException
{
	objproductpage.productcick();
	objproductpage.addProduct(MyReadEcxel.readIntData(0,0,"addingproducts"));
	
}

@BeforeTest
  @Parameters({"browser"})
  public void beforeTest(@Optional String Browser)
  {    
	    driver=launchBrowser(Browser, objprop.url);
	    objproductpage=new ProductPage(driver);
	    objbrand=new BrandPages(driver);
	    objAction=new CommonAction();   
  }

  @AfterTest
  public void afterTest() {
	 driver.close();
  }
  
  
}
