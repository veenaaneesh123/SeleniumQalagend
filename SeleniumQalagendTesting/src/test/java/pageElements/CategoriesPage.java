package pageElements;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Utilities.CommonAction;
import Utilities.WaitUtility;

public class CategoriesPage extends CommonAction{
	WebDriver driver;
	WaitUtility objwait=new WaitUtility();

		public  CategoriesPage(WebDriver driver) {
			this.driver =driver;
			PageFactory.initElements(driver, this);
		}
	
		@FindBy(xpath="//a[@id='tour_step5_menu']")
		public WebElement products;
		
		@FindBy(xpath="//span[text()='Categories ']")
		public WebElement category;
		
		@FindBy(xpath="//div[text()='Category added successfully']")
		public WebElement Addmsg;	
		@FindBy(xpath="//td[text()='No matching records found']")
		//@FindBy(xpath="//table//tbody//tr//td[text()='No matching records found']")
		public WebElement nomatch;
		
		@FindBy(xpath="//div[text()='Category updated successfully']")
		public WebElement returnedit;
		
		@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
		public WebElement addclick;
		
		@FindBy(xpath="//input[@id='name']")
		public WebElement categoryname;
		
		@FindBy(xpath="//input[@id='short_code']")
		public WebElement categorycode;
		
		@FindBy(xpath="//button[@class='btn btn-primary']")
		public WebElement save;
		@FindBy(xpath="(//button[text()='Close'])[1]")
		public WebElement closeadd;
		
		@FindBy(xpath="//input[@class='form-control input-sm']")
		public WebElement search;
		
		@FindBy(xpath="//*[@id=\"category_table\"]/tbody/tr/td[2]")
		public WebElement returnsearch;
		@FindBy(xpath="//button[@class='btn btn-primary']")
		public WebElement updateclick;
		@FindBy(xpath="(//button[@class='btn btn-default'])[1]")
		public WebElement updateclose;
		//@FindBy(xpath="//button[@class='btn btn-xs btn-primary edit_category_button']")
		@FindBy(xpath="//*[@id=\"category_table\"]/tbody/tr/td[3]/button[1]")
		public WebElement edit;
		
		@FindBy(xpath="//button[@class='btn btn-xs btn-danger delete_category_button']")
		//@FindBy(xpath="//i[@class='glyphicon glyphicon-trash']")
		public WebElement delete;
		@FindBy(xpath="//button[@class='swal-button swal-button--cancel']")
		public WebElement deletecancel;
		@FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
		public WebElement deleteok;
		@FindBy(xpath="//div[text()='Category updated successfully']")
		public WebElement updatereturn;
		@FindBy(xpath="//div[text()='Category deleted successfully']")
		public WebElement deletereturn;
		
		public void product(){
			products.click();
			category.click();
		}
		public void categoryadd(String value1,String value2)
		{
			addclick.click();
			objwait.explicitWait_elementclick(driver, addclick, 10);		
			sendKeys(categoryname, value1);
			objwait.explicitWait_visible(driver, categoryname, 10);
			sendKeys(categorycode, value2);
			objwait.explicitWait_visible(driver, categorycode, 10);
			
		}
		public String catsave() {
			save.click();
			return getText(Addmsg);
		}
		public void catclose()
		{
			closeadd.click();
			
		}
		public String search(String value)
		{
			sendKeys(search, value);
			objwait.explicitWait_visible(driver, search, 10);
			return getText(nomatch);
		}
		public String search1(String value)
		{
			sendKeys(search, value);
			return getText(returnsearch);
		}
		public void search2(String value)
		{
			sendKeys(search, value);	
		}
		public void cat_edit(String value1,String value2){

			click(edit);
			objwait.explicitWait_elementclick(driver, addclick, 10);	
			categoryname.clear();
			sendKeys(categoryname, value1);
			objwait.explicitWait_visible(driver, categoryname, 10);
			categorycode.clear();
			sendKeys(categorycode, value2);
			objwait.explicitWait_visible(driver, categorycode, 10);
			}
		public void editcancel()
		{
			objwait.explicitWait_elementclick(driver, updateclose, 10);	
			updateclose.click();	
		}
		public String update()
		{
			objwait.explicitWait_elementclick(driver, updateclick, 10);	
			updateclick.click();
			return getText(updatereturn);	
		}	
		public String deletecancel() {
			delete.click();
			objwait.explicitWait_elementclick(driver, delete, 10);	
			deletecancel.click();
			objwait.explicitWait_elementclick(driver, deletecancel, 10);
			return getText(returnsearch);	
		}
		
		public String deleteok() {	
			objwait.explicitWait_elementclick(driver, delete, 10);	
			delete.click();
			objwait.explicitWait_elementclick(driver, deleteok, 10);
			deleteok.click();
			return getText(deletereturn);
		}
}

