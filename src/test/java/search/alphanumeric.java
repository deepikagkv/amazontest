package search;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objectrepository.Amazonhomepage;
import resources.Baseclass;

public class alphanumeric extends Baseclass {
	
	
	

	public static WebDriver driver;
	
	@BeforeMethod
	public void launchpage() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
		  
	}
	
	@Test
	public void TC_AZ_serach_001() {
		
		Amazonhomepage sr=new Amazonhomepage(driver);
		sr.Searchbox().sendKeys("dee12");
		sr.searchbutton().click();
		
		
	}

}
