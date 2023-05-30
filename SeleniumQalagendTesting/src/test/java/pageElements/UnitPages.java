package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.CommonAction;
import Utilities.JavascriptUtility;
import Utilities.WaitUtility;

public class UnitPages extends CommonAction
{
	WebDriver driver;
	WaitUtility wait=new WaitUtility();
	JavascriptUtility script=new JavascriptUtility();
	
	public UnitPages(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@id='tour_step5_menu']")
	public WebElement products;
	@FindBy(xpath="//span[text()='Units']")
	public WebElement unit;
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	public WebElement add;
	@FindBy(xpath="//input[@id='actual_name']")
	public WebElement Name;
	@FindBy(xpath="//input[@id='short_name']")
	public WebElement shortname;
	@FindBy(id="allow_decimal")
	public WebElement Allow_decimal;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement Save;
	@FindBy(xpath = "//select[@id='allow_decimal']")
	public WebElement selects;
	@FindBy(xpath="//label//input[@class='form-control input-sm']")
	public WebElement search;
	@FindBy(xpath="//table//tbody//tr//td[1]")
	public WebElement tablevalue;
	@FindBy(xpath="//table//td[text()='No matching records found']")
	public WebElement firstvalue;
	@FindBy(xpath="//table//tbody//tr//td[text()='vaniveena']")
	public WebElement data;
	@FindBy(xpath="//div[text()='Unit added successfully']")
	public WebElement retunvalue;
	@FindBy(xpath="(//button[@class='btn btn-default'])[1]")
	public WebElement close;
	@FindBy(xpath="//table//tbody//td//button[@class='btn btn-xs btn-primary edit_unit_button']")
	public WebElement edit;
	@FindBy(xpath="//button[text()='Update']")
	public WebElement update;
	@FindBy (xpath="//div[text()='Unit updated successfully']")
	public WebElement updatereturn;
	@FindBy(xpath="//button[@class='btn btn-xs btn-danger delete_unit_button']")
	public WebElement delete;
	@FindBy(xpath = "//button[@class='swal-button swal-button--cancel']")
	public WebElement deletecancel;
	@FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger']")
	public WebElement deleteok;
	@FindBy(xpath="//*[@id=\"unit_table\"]/tbody/tr/td[1]")
	public WebElement searchindata;
	

	public void clickproduct(){
		products.click();
		unit.click();
	}
	public void addclick() {
		add.click();
	}
	public void add_unit(String value1,String value2){
		sendKeys(Name, value1);
		wait.explicitWait_visible(driver, Name, 10);
		sendKeys(shortname, value2);
		wait.explicitWait_visible(driver,shortname, 10);
		Select obj=new Select(Allow_decimal);
		obj.selectByIndex(1);	
	}
	public void save(){
	Save.click();
	}
	public void close(){
		close.click();
	}
	public void search(String value)  {
		sendKeys(search, value);
		wait.explicitWait_visible(driver, search, 20);
		//return tablevalue;
	}
	public void edit_unit(String value1,String value2)
	{
		edit.click();
		Name.clear();
		sendKeys(Name, value1);
		wait.explicitWait_visible(driver, Name, 10);
		shortname.clear();
		sendKeys(shortname, value2);
		wait.explicitWait_visible(driver,shortname, 10);
	}
	public void updateclick()
	{
		update.click();
	}
	public void deletecancel()
	{
		delete.click();
		deletecancel.click();
		wait.explicitWait_visible(driver,deletecancel , 10);	
	}
	public void delete()
	{
		delete.click();
		deleteok.click();
		wait.explicitWait_visible(driver,delete , 10);	
	}
}
