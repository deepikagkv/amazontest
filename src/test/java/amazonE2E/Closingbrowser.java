package amazonE2E;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objectrepository.Amazonproductpage;
import resources.Baseclass;

public class Closingbrowser extends Baseclass {
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
	public void productsearch() throws InterruptedException 
		 {

		Amazonproductpage sr=new Amazonproductpage(driver);
		a=new Actions(driver);
		 a.moveToElement(sr.Searchbox()).click().build().perform();
		sr.Searchbox().sendKeys("fitbitversa");
		sr.searchbutton().click();
		wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Fitbit Versa Special Edition Health & Fitness Smartwatch with Heart Rate, Music & Swim Tracking, Charcoal")));
		
//search for specific product
		driver.findElement(By.linkText("Fitbit Versa Special Edition Health & Fitness Smartwatch with Heart Rate, Music & Swim Tracking, Charcoal")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3000)", "");
		
		
		
		
		Boolean check = false;

	    while (!check) {

	        try {
	            driver.getTitle();
	            Thread.sleep(200);
	        } catch (Exception e) {
	        	 System.out.println("Couldn't Connect Driver / Driver Closed" + e.getMessage());
	            //you can verify correct exception here ie not reachable, dead etc..
	            check = true;
	        }

	    }
		
//search for product detail
	       WebElement flag=driver.findElement(By.id("detail_bullets_id"));
	       js.executeScript("arguments[0].scrollIntoView();", flag);
	        System.out.println(flag.getText());
	        wait=new WebDriverWait(driver,2);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buy-now-button")));
		   js.executeScript("window.scrollBy(0,-2000)", "");

//scroll to click on buy now button
	       WebElement flag2=driver.findElement(By.id("buy-now-button"));
	       js.executeScript("arguments[0].scrollIntoView();", flag2);
	       flag2.click();
	       Thread.sleep(3000);
	      // driver.findElement(By.id("siNoCoverage-announce")).click();
//signin details must be asked
	       
		 }	
}
