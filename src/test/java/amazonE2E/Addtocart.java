package amazonE2E;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectrepository.Amazonhomepage;
import objectrepository.Amazonproductpage;
import resources.Baseclass;

public class Addtocart extends Baseclass {

	public static WebDriver driver;
	public static Actions a;
	
	@BeforeMethod
	public void launchpage() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
		  
	}
	
	@Test
	public void TC_AddtoBasket_001() throws InterruptedException {
		 Amazonproductpage sr=new Amazonproductpage(driver);
		 
		
			Boolean dispalyed=sr.Searchbox().isDisplayed();
			System.out.println("Search box is displayed to user  :"   +dispalyed);
			
			 a=new Actions(driver);
			 
			 a.moveToElement(sr.Searchbox()).click().sendKeys("smartwatches").click().build().perform();
			
			 a.moveToElement(sr.searchbutton()).click().build().perform();
			 
			System.out.println( driver.getTitle());
			 
			 
	       Thread.sleep(3000);
	       
	       JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,2000)", "");
		
			 a.moveToElement(sr.brand()).build().perform();
			
				try {
					WebElement fitbit=driver.findElement(By.linkText("Fitbit"));
			 fitbit.click();
			 }
		catch(org.openqa.selenium.StaleElementReferenceException e) {
			WebElement fitbit=driver.findElement(By.linkText("Fitbit"));
			 fitbit.click();
		}
			 			 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 			 
			 			
			 			js.executeScript("window.scrollBy(0,500)", "");
			 			WebElement price=sr.price();
			 		   js.executeScript("arguments[0].scrollIntoView();", price);
			 		   price.click();
			 
		
	}	  
			
	
/*@AfterMethod
	public void teardown()
	{
		driver.quit();
	}*/

}

