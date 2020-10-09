package testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objectrepository.Amazonhomepage;
import resources.Baseclass;

public class responsive extends Baseclass {
	public static WebDriver driver;
	Actions a;
	static WebDriverWait wait;
	
	

	@Test
	public void productsearch() throws InterruptedException, IOException {
		
		driver=initialisedriver();
		long before=System.currentTimeMillis();
		driver.get("https://www.amazon.co.uk/");
		Amazonhomepage sr=new Amazonhomepage(driver);
		Boolean dispalyed=sr.Searchbox().isDisplayed();
		System.out.println("Search box is displayed to user  :"   +dispalyed);
		
		 a=new Actions(driver);
		 
		 a.moveToElement(sr.Searchbox()).click().build().perform();
		 System.out.println("User able to click in searchbox");
		 sr.Searchbox().sendKeys("fitbit");
		 sr.searchbutton().click();
		 try {
			
		 
		 Timeouts time=driver.manage().timeouts();
		 time.pageLoadTimeout(3,TimeUnit.MILLISECONDS);
		 
		 System.out.println(driver.getTitle());
		 }
		 catch(Exception e)
		 {
			 System.out.println(" error message" + e.getMessage());
		 }
		 
		
		long after=System.currentTimeMillis();
		
		long totaltime= after-before;
		System.out.println("total time taken is " + totaltime );
		
	}
		


	
	
	
	
}
