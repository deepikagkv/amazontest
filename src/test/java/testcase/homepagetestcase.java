package testcase;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objectrepository.Amazonhomepage;
import objectrepository.Amazonloginpage;
import resources.Baseclass;

public class homepagetestcase extends Baseclass {
	
	public static WebDriver driver;
	public static Actions a;
	@BeforeMethod
	public void launchpage() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
		  
	}
	@Test
	public void searchbox() throws InterruptedException
	
	{
		//creating object of another class Amazonhomepage and passing driver,so that driver can be accesed on that methods
		  		
		 Amazonhomepage sr=new Amazonhomepage(driver);
		 Boolean dis=sr.Searchbox().isDisplayed();
		 System.out.println(dis);
			
		 a=new Actions(driver);
		 a.moveToElement(sr.Searchbox()).click().keyDown(Keys.SHIFT).sendKeys("smartwatches").click().build().perform();  
	     a.moveToElement(sr.searchbutton()).click().build().perform();
		    Thread.sleep(3000);
		    
		    Set<String> st=driver.getWindowHandles();
			Iterator<String> it= st.iterator();
			String parentid=it.next();
			String childid=it.next();  
			driver.switchTo().window(childid);
			 String title=driver.getTitle();
			System.out.println(title);
			Assert.assertTrue(title.contains("SMARTWATCHES"));
			System.out.println("Search is successful");
			
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	

}
