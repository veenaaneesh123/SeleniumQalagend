package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonAction;
import Utilities.JavascriptUtility;
import Utilities.WaitUtility;

public class BrandPages extends CommonAction
	{
		WebDriver driver;
		WaitUtility wait=new WaitUtility();
		JavascriptUtility script=new JavascriptUtility();
		
		public BrandPages(WebDriver driver) {
			this.driver =driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="username")
		public WebElement username;
		
		@FindBy(id="password")
		public WebElement password;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/form/div[4]/div/button")
		public WebElement login;
		@FindBy(xpath="//button[text()='End tour']")
		public WebElement endTour;
		@FindBy(xpath="//a[@id='tour_step5_menu']")
		public WebElement products;
		
		@FindBy(xpath="//span[text()='Brands']")
		public WebElement brand;
		
		@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
		public WebElement add;
	
		@FindBy(xpath="(//input[@class='form-control'])[1]")
		public WebElement name1;
		
		@FindBy(xpath="(//input[@class='form-control'])[2]")
		public WebElement name2;
		
		@FindBy(xpath="//button[text()='Save']")
		public WebElement save;
		
		@FindBy(xpath="(//button[text()='Close'])[1]")
		public WebElement close;
		
		@FindBy(xpath="//div[text()='Brand added successfully']")
		public WebElement retunmsg;
		
		@FindBy(xpath="//table//td[text()='No matching records found']")
		public WebElement noreturn;
		
		@FindBy (xpath="//div[text()='Brand updated successfully']")
		public WebElement updatereturn;
		
		@FindBy(xpath="//input[@class='form-control input-sm']")
		public WebElement search;
		
		@FindBy(xpath="//*[@id=\"brands_table\"]/tbody/tr/td[1]")
		public WebElement searchinddata;
		
		@FindBy(xpath="//*[@id=\"brands_table\"]/tbody/tr/td[3]/button[1]")
		public WebElement edit;
		
		@FindBy(xpath="//*[@id=\"brands_table\"]/tbody/tr/td[3]/button[2]")
		public WebElement delete;
		
		@FindBy(xpath="//*[@id=\"brand_edit_form\"]/div[3]/button[1]")
		public WebElement update;
		
		@FindBy(xpath="(//button[text()='Close'])[1]")
		public WebElement updateclose;
		
		@FindBy(xpath="/html/body/div[4]/div/div[4]/div[1]/button")
		public WebElement deletecancel;
		
		@FindBy(xpath="//li[@class='active']")
		public WebElement home;
		
		@FindBy(xpath="/html/body/div[4]/div/div[4]/div[2]/button")
		public WebElement deleteok;
		public By searchs=By.xpath("//*[@id=\"brands_table_filter\"]/label/input");
		
		public void login(String id,String key)
			{
				sendKeys(username,id);
				sendKeys(password,key);
				click(login);
				click(endTour);		
			}
		public void brandclick() 
			{	wait.explicitWait_elementclick(driver, products,15);	
				click(products);
				wait.explicitWait_elementclick(driver, brand,25);	
				click(brand);
				
			}
		public String addclick_cance(String brandname,String shortname) throws InterruptedException
			{	
				wait.explicitWait_elementclick(driver, add,15);	
				click(add);
				sendKeys(name1, brandname);	
				sendKeys(name2, shortname);
				wait.explicitWait_elementclick(driver, save,15);
				click(close);
				return getText(searchinddata);			
			}

		public String addclick(String brandname,String shortname) throws InterruptedException
		{	
			wait.explicitWait_elementclick(driver, add,15);	
			click(add);
			sendKeys(name1, brandname);	
			sendKeys(name2, shortname);
			wait.explicitWait_elementclick(driver, save,15);
			click(save);
			return getText(retunmsg);
			
					
		}

	
		public String searchdata(String value) throws InterruptedException
			{
			wait.explicitWait_visible(driver, search, 10);
			search.clear();
			sendKeys(search, value);
			wait.explicitWait_visible(driver, search, 10);
			return getText(searchinddata);
			}
		
		public String searchdatanodata(String value) throws InterruptedException
		{
		wait.explicitWait_visible(driver, search, 10);
		search.clear();
		sendKeys(search, value);
		return getText(noreturn);
		}
		public String editclick(String name,String names) throws InterruptedException
		{
			click(edit);
			name1.clear();
			wait.explicitWait_visible(driver, name1, 10);
			sendKeys(name1, name);
			name2.clear();
			wait.explicitWait_visible(driver, name2, 10);
			sendKeys(name2, names);
			click(update);
			return getText(updatereturn);
			
		}
		public void editcloseclick(String name)
		{
			click(edit);
			name1.clear();
			sendKeys(name1, name);
			click(updateclose);	
			
		}
		public String deletecancel() throws InterruptedException
		{
			click(delete);
			click(deletecancel);
			return getText(searchinddata);
		}
		public String deleteclick() throws InterruptedException 
		{ 
			click(delete);
		    click(deleteok);
		    return getText(noreturn);
		   			
			
		
		}
}


