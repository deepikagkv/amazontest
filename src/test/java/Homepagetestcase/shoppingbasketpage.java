package Homepagetestcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import objectrepository.Amazonhomepage;
import resources.Baseclass;

public class shoppingbasketpage extends Baseclass {

	
	public static WebDriver driver;
	public static Actions a;
	@BeforeMethod
	public void launchpage() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
		  
	}
	
	@Test
	public void TC_AZ_Homepage_004() {
		 Amazonhomepage sr=new Amazonhomepage(driver);
		
		 String hometitle=driver.getTitle();
		 System.out.println("User is in :"   +hometitle);
		 
		Boolean visibility=sr.shoppingBasket().isDisplayed();
		System.out.println("Shopping basket is visible to User on Homepage:    " +visibility);
		sr.shoppingBasket().click();
		System.out.println(sr.shoppingBasket().getText());
		
		String title=driver.getTitle();
		System.out.println("User is in :"  + title);
		Assert.assertTrue(title.contains("Shopping Basket"));
		
		WebElement message =driver.findElement(By.xpath("//*[@id=\'sc-active-cart\']/div/div[2]/div[1]/h2"));
		System.out.println("Message displayed to user :"  + message.getText());
		
	}
	

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
