package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonAction;
import Utilities.ExcelReader;
import Utilities.MyReadEcxel;
import Utilities.WaitUtility;

public class ProductPage extends CommonAction
{
	WaitUtility objwait;	
	WebDriver driver;
	MyReadEcxel objexcel;
		public  ProductPage(WebDriver driver)
		{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	} 
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/form/div[4]/div/button")
	public WebElement login;
	
	@FindBy(xpath="//*[@id=\"step-0\"]/div[3]/button[3]")
	public WebElement endTour;
	
	@FindBy(xpath="//*[@id=\"tour_step5_menu\"]/span[1]")
	public WebElement products;
	
	@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[2]/a")
	public WebElement addproduct;
	
	@FindBy(xpath="//*[@id=\"name\"]")
	public WebElement productname;

	@FindBy(xpath="//*[@id=\"product_add_form\"]/div[1]/div/div/div[5]/div/span/span[1]/span/span[2]")
	public WebElement combobox1;
	
	@FindBy(xpath="//li[text()='cellphone']")
	//@FindBy(xpath="//*[@id=\"select2-category_id-container\"]")
	public WebElement cellphone;
	
	@FindBy(xpath="//*[@id=\"product_add_form\"]/div[1]/div/div/div[2]/div/div/span[2]/button/i")
	public WebElement brandicon;
	@FindBy(xpath="(//input[@id='name'])[1]")
	public WebElement brandname;
	
	@FindBy(xpath="//input[@id='description']")
	public WebElement shortname;
	
	@FindBy(xpath="/html/body/span/span/span[1]/input")
	public WebElement search;
	
	@FindBy(xpath="//*[@id=\"quick_add_brand_form\"]/div[3]/button[1]")
	public WebElement save;
	
	@FindBy(xpath="//*[@id=\"product_add_form\"]/div[1]/div/div/div[2]/div/div/span[1]/span[1]/span/span[2]/b")
	public WebElement combobox2;
	
	
	public void login(String value,String value1) throws InterruptedException 
	{
		sendKeys(username,value);
		sendKeys(password,value1);
		click(login);
		click(endTour);
	}
	
	public void productcick()
		{
			click(products);
			click(addproduct);
			
		}
	public void addProduct(String value1) throws InterruptedException
		{
		sendKeys(productname,value1);
		click(combobox1);
		Thread.sleep(2000);
		click(cellphone);
		
		
		}
	public void brandAdd(String value,String value1) throws InterruptedException
	{
		click(brandicon);
		Thread.sleep(2000);
		sendKeys(shortname,value);
		sendKeys(brandname,value1);
		click(save);	
	}
}
