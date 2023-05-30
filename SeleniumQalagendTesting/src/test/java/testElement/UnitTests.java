package testElement;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.CommonAction;
import Utilities.ReadConfigProperty;
import Utilities.WaitUtility;
import Utilities.WebDriverManager;
import pageElements.Loginpage;
import pageElements.UnitPages;
@Listeners(Utilities.TestListener.class)
public class UnitTests extends WebDriverManager{
	public WebDriver driver;
	UnitPages objunit;
	ReadConfigProperty objprop = new ReadConfigProperty();
	CommonAction objAction;
	WaitUtility wait;
	Loginpage objlogin;

  @Test(priority = 1,enabled =true)
  public void verifying_addunit_by_adding_data() {
	  objlogin.login("admin", "123456");
	  objunit.clickproduct();
	  objunit.addclick();
	  objunit.add_unit("vaniveena", "veena123");
	  objunit.save();
	  String Expected=objAction.getText(objunit.retunvalue);
	  Assert.assertEquals(Expected,"Unit added successfully");
  }
  @Test(priority = 2,enabled=true)
  public void verifying_addunit_close_button_without_saving_data() {
	  objlogin.login("admin", "123456");
	  objunit.clickproduct();
	  objunit.addclick();
	  objunit.add_unit("anju", "manju123");
	  objunit.close();
	  objunit.search("anju");
	  String expected=objAction.getText(objunit.firstvalue);
	  Assert.assertEquals(expected,"No matching records found");
  }
  @Test(priority = 3,enabled=true)
  public void verifying_search_by_applying_newdata_not_in_table() {
	  objlogin.login("admin", "123456");
	  objunit.clickproduct();
	  objunit.search("IVAAN");
	  String expected=objAction.getText(objunit.firstvalue);
	  Assert.assertEquals(expected,"No matching records found");  
  }
  @Test(priority = 4,enabled=true)
  public void verifying_search_by_applying_already_exicitingdata_in_table() {
	  objlogin.login("admin", "123456");
	  objunit.clickproduct();
	  objunit.search("vaniveena");
	  String expected=objAction.getText(objunit.data);
	  Assert.assertEquals(expected,"vaniveena");  
  }
  
  @Test(priority = 5,enabled=false)
  public void verifying_editbutton_by_updating_the_exiciting_data() {
	  objlogin.login("admin", "123456");
	  objunit.clickproduct();
	  objunit.search("vaniveena");
	  objunit.edit_unit("veenavani", "vani123");
	  objunit.updateclick();
	  String expected=objAction.getText(objunit.updatereturn);
	  Assert.assertEquals(expected,"Unit updated successfully");
  }
  @Test(priority =6,enabled=true)
  public void verify_delete_cancel_button_without_clicking_ok_button(){
	  objlogin.login("admin", "123456");
	  objunit.clickproduct();
	  objunit.search("veenavani");
	  objunit.deletecancel();
	  String expected=objAction.getText(objunit.searchindata);
	  Assert.assertEquals(expected, "veenavani");  
  }
  @Test(priority =7,enabled=true)
  public void verify_delete_button_to_removedata(){
	  objlogin.login("admin", "123456");
	  objunit.clickproduct();
	  objunit.search("veenavani");
	  objunit.delete();
	  objunit.search("veenavani");
	  String expected=objAction.getText(objunit.firstvalue);
	  Assert.assertEquals(expected,"No matching records found"); 
  }
  
  @BeforeMethod
  @Parameters({"browser"})
  public void beforemethod(@Optional String Browser)
  {
	  driver=launchBrowser(Browser, objprop.url);
	  objlogin=new Loginpage(driver);
	  objunit=new UnitPages(driver);
	  objAction=new CommonAction();
	  wait=new WaitUtility();
	 
  }
  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

  
   
}
