package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonAction;
import Utilities.ExcelDataProvider;
import Utilities.JavascriptUtility;
import Utilities.MyReadEcxel;
import Utilities.WaitUtility;

public class ImportProductPage extends CommonAction
{
	WebDriver driver;
	CommonAction objaction;
	WaitUtility wait=new WaitUtility();
	JavascriptUtility script=new JavascriptUtility();
	ExcelDataProvider objexcel;
	
	public ImportProductPage(WebDriver driver)
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
	
	//@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[5]/a/span")
	@FindBy(xpath="//span[text()='Import Products']")
	public WebElement importproduct;
	
	//@FindBy(xpath="//input[@name='products_csv']")
	@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div/div/div/form/div/div/div[1]/div/input")
	public WebElement choosefile;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div/div/div/form/div/div/div[2]/button")
	public WebElement submit;
	
	public void login(String value,String value1)
	{
		sendKeys(username,value);
		sendKeys(password,value1);
		click(login);
		click(endTour);
	}
	public void productclick()
	{
		click(products);
	}
	
	public void addfile() throws InterruptedException
	{
		click(importproduct);
		//click(choosefile);
	}
	public void choosinfFile()
	{
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/section[2]/div[1]/div/div/div/form/div/div/div[1]/div/input")).sendKeys("\"C:\\Users\\Aneesh\\Downloads\\Product.xlsx\"");
	}
	public void submitclick()
	{
		click(submit);
	}
}
