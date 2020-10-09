package search;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import objectrepository.Amazonhomepage;
import resources.Baseclass;

public class withoutttext extends Baseclass {
	
	
	

	public static WebDriver driver;
	public static Actions a;
	@BeforeMethod
	public void launchpage() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
		  
	}
	
	@Test
	public void TC_AZ_serach_001() {
		
		String title=driver.getTitle();
		Amazonhomepage sr=new Amazonhomepage(driver);
		sr.Searchbox().sendKeys("  ");
		sr.searchbutton().click();
		
		String newtitle=driver.getTitle();
		Assert.assertEquals(newtitle, title);
		System.out.println("Page title is not changed");
		System.out.println("User cannot see any prompt message");
		
	}

}
