package testElement;

import org.testng.annotations.Test;
import Utilities.CommonAction;
import Utilities.ReadConfigProperty;
import Utilities.WebDriverManager;
import pageElements.Loginpage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
@Listeners(Utilities.TestListener.class)

public class LoginTest extends WebDriverManager 
{
public static WebDriver driver;
ReadConfigProperty objprop = new ReadConfigProperty();
Loginpage objLogin;
CommonAction objaction;

  @Test(priority = 0)
  public void applying_invalid_password_and_username_in_Login() {
	 // objLogin.login("admi", "12345");
	  String expecteddata="These credentials do not match our records.";
	  String actualdata=objLogin.loginfail("admi", "12345");
	  Assert.assertEquals(actualdata,expecteddata); 
  }
  @Test(priority = 1)
  public void applying_vaild_username_and_password_login() {
	  String actual= objLogin.login("admin", "123456");
	  //String expected=objaction.getText(objLogin.home);
	  System.out.println(actual);
	  Assert.assertEquals(actual, "Home");	  
  }

  @BeforeMethod
  @Parameters({"browser"})
  public void beforeMethod(@Optional String Browser) {
	  driver=launchBrowser(Browser,objprop.url);
	    objLogin=new Loginpage(driver);
	    objaction=new CommonAction();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
