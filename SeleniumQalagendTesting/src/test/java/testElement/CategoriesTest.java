package testElement;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
import pageElements.BrandPages;
import pageElements.CategoriesPage;
import pageElements.Loginpage;
@Listeners(Utilities.TestListener.class)
public class CategoriesTest extends WebDriverManager 
{
public static WebDriver driver;
ReadConfigProperty objprop = new ReadConfigProperty();
WaitUtility objwait;
CommonAction objAction;
Loginpage objLogin ;
CategoriesPage objCategoriesPage;

	@Test(priority = 1,enabled =false)
	public  void verify_cancelbutton_in_addCategory_by_entering_the_data_without_saving()
	{
		objLogin.login("admin","123456");
		objCategoriesPage.product();
		objCategoriesPage.categoryadd("Elephantbaby","elephant1234");
		objCategoriesPage.catclose();
		String actual=objCategoriesPage.search("Elephant");
		Assert.assertEquals(actual,"No matching records found");
		  
	}
  @Test(priority = 2,enabled=true)
	public void verifying_categories_add_by_adding_data_in_Categories_Table() 
	{
	    objLogin.login("admin","123456");
	    objCategoriesPage.product();
	    objCategoriesPage.categoryadd("applecake", "cake123");
	    objCategoriesPage.catsave();
		String expected="Category added successfully";
		String actual=objAction.getText(objCategoriesPage.Addmsg);
	    Assert.assertEquals(actual, expected);		
	}
  @Test(priority = 3,enabled =false)
	public  void verify_table_by_entering_data_not_in_table(){
		objLogin.login("admin","123456");
		objCategoriesPage.product();
		String actual=objCategoriesPage.search("Mangocake");
		Assert.assertEquals(actual,"No matching records found");	  
	}
	@Test(priority = 4,enabled = false)
	public void verify_category_search_by_exicting_categoryname(){
		objLogin.login("admin","123456");
		objCategoriesPage.product();
		String expected= objCategoriesPage.search1("applecake");
		Assert.assertEquals(expected,"cake123");			
	}
	@Test(priority = 5,enabled =false )
	public void verify_category_edit_by_WithoutSaving_theupdating_details(){
		objLogin.login("admin","123456");
		objCategoriesPage.product();
		 objCategoriesPage.search1("applecake");
		 objCategoriesPage.cat_edit("apple", "cake");
		 objCategoriesPage.editcancel();
		String expected=objCategoriesPage.search1("applecake");
		Assert.assertEquals(expected,"cake123");			
	}
	@Test(priority = 6,enabled =true)
	public void verify_category_edit_by_updating_details(){
		objLogin.login("admin","123456");
		objCategoriesPage.product();
		 objCategoriesPage.search2("applecake");
		 objCategoriesPage.cat_edit("Mangoapple", "cake123");
		 String expected=objCategoriesPage.update(); 
		 Assert.assertEquals(expected,"Category updated successfully");			
	}
	@Test(priority = 7,enabled =false )
	public void verify_category_delete_by_useing_delete_cancel_Button(){
		 objLogin.login("admin","123456");
		 objCategoriesPage.product();
		 objCategoriesPage.search2("mangoapple");
		 String expected=objCategoriesPage.deletecancel();
		Assert.assertEquals(expected,"cake123");
	}
	@Test(priority = 8,enabled =true )
		public void verify_category_delete_by__removing_data()
		{
			 objLogin.login("admin","123456");
			 objCategoriesPage.product();
			 objCategoriesPage.search2("mangoapple");
			 objCategoriesPage.deleteok();
			 String actual=objCategoriesPage.search("mangoapple");
			 Assert.assertEquals(actual,"No matching records found");
		}
  @BeforeMethod
  @Parameters({"browser"})
  public void beforeTest(@Optional String Browser)
  {    
	    driver=launchBrowser(Browser, objprop.url);
	    objwait=new WaitUtility();
	    objCategoriesPage=new CategoriesPage(driver);
	    objLogin=new Loginpage(driver);
	    objAction=new CommonAction();
	   
  }

  @AfterMethod
  public void afterTest() 
  {
	  driver.close();
  }
}
