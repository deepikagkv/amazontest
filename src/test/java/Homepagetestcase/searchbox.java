package Homepagetestcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objectrepository.Amazonhomepage;
import resources.Baseclass;

public class searchbox extends Baseclass {
	
	public static WebDriver driver;
	public static Actions a;
	@BeforeMethod
	public void launchpage() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
		  
	}
	
	@Test
	public void TC_AZ_Homepage_005() {
		
		Amazonhomepage sr=new Amazonhomepage(driver);
		Boolean dispalyed=sr.Searchbox().isDisplayed();
		System.out.println("Search box is displayed to user  :"   +dispalyed);
		
		 a=new Actions(driver);
		 
		 a.moveToElement(sr.Searchbox()).click().build().perform();
		 System.out.println("User able to click in searchbox");
		 
			
	}
	
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
}
