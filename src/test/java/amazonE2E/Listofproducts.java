package amazonE2E;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objectrepository.Amazonproductpage;
import resources.Baseclass;

public class Listofproducts  extends Baseclass {
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
	public void TC_productdlist_001() throws InterruptedException {
		
		Amazonproductpage sr=new Amazonproductpage(driver);
		Boolean dispalyed=sr.Searchbox().isDisplayed();
		System.out.println("Search box is displayed to user  :"   +dispalyed);
	
	//mouse over to searchbox	
		 a=new Actions(driver);
		 a.moveToElement(sr.Searchbox()).click().build().perform();
		 System.out.println("User able to click in searchbox");
		sr.Searchbox().sendKeys("fitbitversa");
		sr.searchbutton().click();
		wait=new WebDriverWait(driver,2);
		
		String text=driver.getTitle();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Fitbit Versa 2 Health and Fitness Smartwatch with Jabra 65t Wireless Earbuds")));
		//driver.findElement(By.linkText("Fitbit Versa 2 Health and Fitness Smartwatch with Jabra 65t Wireless Earbuds")).click();
	   
		Assert.assertTrue(text.contains("fitbitversa"));
		
	//Get list of all products matching to search  
		 List<WebElement> vs = driver.findElements(By.xpath("//div[@class='sg-row']"));
	        System.out.println("total no of value"+vs.size());
	        for (WebElement product : vs) {
	            System.out.println(product.getText());
	            System.out.println("<======================================>");}
		
	//need to check for no of products in page and output
	}

	 @AfterTest
	 public void teardown()
	 {
		 
	 }
}
