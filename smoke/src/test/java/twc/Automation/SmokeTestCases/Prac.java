/**
 * 
 */
package twc.Automation.SmokeTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


/**
 * @author Naresh
 *
 */
public class Prac {
	WebDriver driver;
	@Test
	public void test()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/macmini/Documents/chromedriver");
		driver=new ChromeDriver();	
		driver.get("https://www.google.com/");
		//WebElement element = 
		//using selenium
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("btnKoo"))));
		driver.findElement(By.name("btnKoo")).click();
		
		//using javascript executor 
//		WebElement element = driver.findElement(By.name("btnK"));
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", element);
		
		//by using Actions class
//		String name = "btnK";
//		String locator = name;
//	     WebElement el = driver.findElement( By.name( locator ) );
//	     Actions builder = new Actions(driver);
//	     builder.moveToElement( el ).click( el );
//	     builder.perform();
		
		
		
	}

}
