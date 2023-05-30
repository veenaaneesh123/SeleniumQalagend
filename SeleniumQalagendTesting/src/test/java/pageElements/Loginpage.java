package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonAction;
import Utilities.JavascriptUtility;
import Utilities.WaitUtility;

public class Loginpage extends CommonAction {
	WebDriver driver;
	WaitUtility wait=new WaitUtility();
	JavascriptUtility script=new JavascriptUtility();
	
	public Loginpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	} 
	@FindBy(xpath="//input[@id='username']")
	public WebElement username;
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement save;
	@FindBy(xpath="//strong[text()='These credentials do not match our records.']")
	public WebElement invaliddata;
	@FindBy(xpath="//li[@class='active']")
	public WebElement home;
	@FindBy(xpath="//button[text()='End tour']")
	public WebElement endTour;
	
	public String login(String value, String value2)	{
	
		username.sendKeys(value);
		password.sendKeys(value2);
		save.click();
		endTour.click();
		return getText(home);
		
	}
	public String loginfail(String value, String value2)	{
		
		username.sendKeys(value);
		password.sendKeys(value2);
		save.click();
		//endTour.click();
		return getText(invaliddata);
		
	}
}
