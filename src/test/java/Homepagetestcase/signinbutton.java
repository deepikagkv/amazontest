package Homepagetestcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objectrepository.Amazonhomepage;
import resources.Baseclass;

public class signinbutton extends Baseclass {

	
	public static WebDriver driver;
	public static Actions a;
	@BeforeMethod
	public void launchpage() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
		  
	}
	
	@Test
	public void TC_AZ_Homepage_001() {
		
		String title=driver.getTitle();
		System.out.println("User currently in homepage :"  +title);
		 Amazonhomepage sr=new Amazonhomepage(driver);
		  Boolean displayed=sr.signintab().isDisplayed();
		  System.out.println("User can see Signin on Homepage : "   +displayed);
		  sr.signintab().click();
		  
		  String newtitle=driver.getTitle();
		  
		  System.out.println("User currently in signin :"  +newtitle);
		  
		  
		  
		  
}
	
	@AfterMethod()
	public void teardown()
	{
	
	//driver.quit();
	}
}
