package Homepagetestcase;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Baseclass;

public class productclick extends Baseclass {

	public static WebDriver driver;
	public static Actions a;
	@BeforeMethod
	public void launchpage() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
		  
	}
	
	
	
	@Test
	public void TC_AZ_Homepage_005_2() {
		
		String initialtitle=driver.getTitle();
		System.out.println("User is in Homepage and Title is" + initialtitle );
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,5000)", "");
	   	   
	       WebElement flag=driver.findElement(By.xpath("//*[@id=\'GKNKmu6TPudmvFtutP34Vw\']/div[2]/div/ul/li[3]/span/a/img"));
	       js.executeScript("arguments[0].scrollIntoView();", flag);
	       flag.click();
		  
		   System.out.println("User is able to scroll down till Text is found in homepage");
		   
		   String aftertitle=driver.getTitle();
		   System.out.println("User currently in Page" + aftertitle);
		   
		  Assert.assertTrue(aftertitle.contains("Nintendo"));
	       WebElement rp=driver.findElement(By.xpath("//*[@id=\'merchandised-content\']/div[4]/div[1]/span"));
		  System.out.println("User able to view" + rp.getText());
		   
}
	@AfterMethod()
	public void teardown()
	{
	
	//driver.quit();
	}
}
