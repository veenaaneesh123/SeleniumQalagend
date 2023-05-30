package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public void implicitWait(WebDriver driver,int seconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	public void implicitWait(WebDriver driver,Duration minutes)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(minutes.toMinutes()));
	}
	public WebElement explicitWait_elementPresence(WebDriver driver,By value,int minutes)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(minutes));
		return wait.until(ExpectedConditions.presenceOfElementLocated(value));
	}
	public WebElement explicitWait_elementvisibility(WebDriver driver,By value,int seconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(value));

	}
	public WebElement explicitWait_elementclick(WebDriver driver,WebElement value,int seconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds));
		return wait.until(ExpectedConditions.elementToBeClickable(value));

	}
	public WebElement explicitWait_visible(WebDriver driver,WebElement value,int seconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds));
		return wait.until(ExpectedConditions.visibilityOf(value));

	}
	

}
