package testElement;
import org.testng.annotations.Test;
import Utilities.CommonAction;
import Utilities.ReadConfigProperty;
import Utilities.WaitUtility;
import Utilities.WebDriverManager;
import pageElements.BrandPages;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
@Listeners(Utilities.TestListener.class)
public class BrandTest extends WebDriverManager 
		{
		public static WebDriver driver;
		ReadConfigProperty objprop = new ReadConfigProperty();
		BrandPages objbrand;
		CommonAction objAction;
		WaitUtility wait;
		
		@DataProvider(name="logins")
		  public Object[][] getDataFromDataprovider(){
			  return new Object[][] 
			  	{
			          { "admin", "123456" }      
			  	};
		  }  
	  @Test(priority = 0,enabled =true,dataProvider ="logins")
	  public void loginSite(String id,String password)
	  {
		  objbrand.login(id,password);
		  String expected=objAction.getText(objbrand.home);
		  Assert.assertEquals(expected, "Home");	  
	   }
	  @Test(priority = 1,enabled=true,dataProvider ="logins")
	  public void verifying_the_addcancel_withoutadding_new_brand(String id, String password) throws InterruptedException 
	  {
		  objbrand.login(id,password);
		  objbrand.brandclick();
		  objbrand.addclick_cance("camera", "iphne");
		  String actual=objbrand.searchdatanodata("camera");
		  Assert.assertEquals("No matching records found",actual);
	  }
	  @Test(priority = 2,enabled=true,dataProvider ="logins")
	  public void adding_new_brand(String id, String password) throws InterruptedException
	  {
		  objbrand.login(id,password);
		  objbrand.brandclick();
		  String expected= objbrand.addclick("camera", "iphne");
		  Assert.assertEquals("Brand added successfully", expected);
		
	  }
	  @Test(priority = 3,enabled=true,dataProvider ="logins")
	  public void searching_already_existing_data_in_brand_table(String id, String password) throws InterruptedException
	  {
		  objbrand.login(id,password);
		  objbrand.brandclick();
		  String expected=objbrand.searchdata("camera"); 
		  Assert.assertEquals("camera", expected);
	  }
	  @Test(priority = 4,enabled=true,dataProvider ="logins")
	  public void searching_data_not_in_brand_table(String id, String password) throws InterruptedException
	  {
	  objbrand.login(id,password);
	  objbrand.brandclick();  
	  String actal=objbrand.searchdatanodata("camera1");
	  String expeted="No matching records found";
	  Assert.assertEquals(expeted,actal ); 
		
	  }
	  @Test(priority = 5,enabled=true,dataProvider ="logins")
	  public void editing_already_exisiting_data(String id, String password) throws InterruptedException
	  {
		  objbrand.login(id,password);
		  objbrand.brandclick();
		  objbrand.searchdata("camera");
		  String expected=objbrand.editclick("camera1234", "iphone");
		  String actual="Brand updated successfully";
		  Assert.assertEquals(actual, expected);
		  
	  }
	  @Test(priority =6,enabled=true,dataProvider ="logins")
	  public void trying_to_edit_data_without_clicking_edit_button(String id, String password) throws InterruptedException
	  {
		  objbrand.login(id,password);
		  objbrand.brandclick();
		  objbrand.editcloseclick( "camera12345");
		  String actual=objbrand.searchdatanodata("camera12345"); 
		  String expected="No matching records found";
		  Assert.assertEquals( expected,actual);	  
	  }
	  @Test(priority = 7,enabled=true,dataProvider ="logins")
	  public void verify_delete_cancel_button_without_clicking_ok_button(String id, String password) throws InterruptedException
	  {
		  objbrand.login(id,password);
		  objbrand.brandclick();
		  objbrand.searchdata("camera1234"); 
		  String actual= objbrand.deletecancel(); 
		  Assert.assertEquals( "camera1234",actual);
		  
	  }
	  @Test(priority = 8,enabled=true,dataProvider ="logins")
	  public void verify_delete_button_to_removedata(String id, String password) throws InterruptedException
	  {
		  objbrand.login(id,password);
		  objbrand.brandclick();
		  objbrand.searchdata("camera1234"); 
		  String actual=objbrand.deleteclick();
		  Assert.assertEquals( "No matching records found",actual);	   
	  }  
	  @BeforeMethod
	  @Parameters({"browser"})
	  public void beforeTest(@Optional String Browser)
	  {    
		    driver=launchBrowser(Browser, objprop.url);
		    objbrand=new BrandPages(driver);
		    objAction=new CommonAction();
		    wait=new WaitUtility(); 
		   
	  }

	  @AfterMethod
	  public void afterTest() 
	  {
		  driver.close();
	  }
  
}
