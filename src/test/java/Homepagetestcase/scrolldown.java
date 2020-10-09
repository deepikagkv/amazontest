package Homepagetestcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectrepository.Amazonhomepage;
import resources.Baseclass;

public class scrolldown extends Baseclass {

	public static WebDriver driver;
	public static Actions a;
	@BeforeMethod
	public void launchpage() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
		  
	}
	
	@Test
	public void TC_AZ_Homepage_006() {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		   System.out.println("User is able to scroll down till the end in homepage");
}
	@Test
	public void TC_AZ_Homepage_006_1() throws InterruptedException {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,1000)", "");
		   System.out.println("User is able to scroll down till the pixel in homepage");
		   Thread.sleep(3000);
		   js.executeScript("window.scrollBy(0,-350)", "");
		   System.out.println("User is able to scroll up in homepage");
		   
		   
}
	
	@Test
	public void TC_AZ_Homepage_006_2() {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,3000)", "");
	   	   
	       WebElement flag=driver.findElement(By.linkText("Bags"));
	       js.executeScript("arguments[0].scrollIntoView();", flag);
		  
		   System.out.println("User is able to scroll down till Text is found in homepage");
}
	@AfterMethod()
	public void teardown()
	{
	
	//driver.quit();
	}
}
