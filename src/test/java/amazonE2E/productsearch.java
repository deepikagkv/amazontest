package amazonE2E;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import objectrepository.Amazonproductpage;
import resources.Baseclass;

public class productsearch extends Baseclass {
	public static WebDriver driver;
	Actions a;
	static WebDriverWait wait;
	
	@BeforeMethod
	public void launchpage() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
		  
	}

	@Test
	public void productsearch() {
		
		Amazonproductpage sr=new Amazonproductpage(driver);
		 
		
		/*Boolean dispalyed=sr.Searchbox().isDisplayed();
		System.out.println("Search box is displayed to user  :"   +dispalyed);
		
		 a=new Actions(driver);
		 
		 a.moveToElement(sr.Searchbox()).click().sendKeys("smartwatches").click().build().perform();
		
		 a.moveToElement(sr.searchbutton()).click().build().perform();
		 
		
		WebElement searchtext=driver.findElement(By.linkText("smart watches"));
		assertNotNull(searchtext);*/
		
		driver.findElement(By.linkText("Today's Deals")).click();
		wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Today's Deals")));
		
		//Assert.assertTrue(driver.getTitle().equals(" Amazon UK Deals - Discover Our Daily Deals"));
		driver.findElement(By.id("101 5c3eb08a")).click();
		wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart")));
		
		
		driver.findElement(By.id("nav-cart")).click();
		wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-active-cart")));
		
		Assert.assertTrue(driver.getTitle().contains("Amazon.co.uk Shopping Basket"));
		
		
	}
	
/*@AfterMethod
	public void teardown()
	{
		driver.quit();
	}*/
	
}
