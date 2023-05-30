package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonAction;
import Utilities.JavascriptUtility;
import Utilities.WaitUtility;

public class VariationsPage extends CommonAction
{
	WebDriver driver;
	WaitUtility wait=new WaitUtility();
	JavascriptUtility script=new JavascriptUtility();
	
	public VariationsPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement passwords;
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/form/div[4]/div/button")
	public WebElement login;
	@FindBy(xpath="//button[text()='End tour']")
	public WebElement endTour;
	@FindBy(xpath="//a[@id='tour_step5_menu']")
	public WebElement products;
	@FindBy(xpath="//span[text()='Variations']")
	public WebElement varient;
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	public WebElement addvarient;
	@FindBy(xpath="//input[@id='name']")
	public WebElement varientname;
	@FindBy(xpath="//input[@name='variation_values[]']")
	public WebElement addvalue;
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	public WebElement saveadd;
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	public WebElement addclose;
	
	public void login(String id, String password)
	{
		username.sendKeys(id);
		passwords.sendKeys(password);
		login.click();
		endTour.click();
	}
	
	public void variantclick(){
	products.click();
	varient.click();
	}
}
