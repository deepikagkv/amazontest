package testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectrepository.Amazonloginpage;
import resources.Baseclass;

public class logintestcase extends Baseclass {
	
	static WebDriver driver;
	
	@BeforeTest
	public void launch() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
	}
	
	
	@Test
	public void login() throws InterruptedException
	{
		//to direct to signin page
		Actions a=new Actions(driver);
		 a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).click().build().perform();
		  
		
		Amazonloginpage obj=new Amazonloginpage(driver);
		obj.Emailid().sendKeys("deepikagkv@gmail.com");
		Thread.sleep(3000);
		obj.Clickcontinue().click();
		obj.Password().sendKeys("deepu123");
		obj.Clicksignin().click();
		
	}
}
