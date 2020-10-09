package amazonE2E;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objectrepository.Amazonloginpage;
import objectrepository.Amazonproductpage;
import resources.Baseclass;

public class booksearch extends Baseclass {
	public static WebDriver driver;
	Actions a;
	static WebDriverWait wait;
	
	@BeforeMethod
	public void launchpage() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
		  
	}

	@Test
	public void productsearch() throws InterruptedException {
		
		Amazonproductpage sr=new Amazonproductpage(driver);
	//Mouse over to books	
		a=new Actions(driver);
		a.moveToElement(driver.findElement(By.linkText("Books"))).click().build().perform();
		wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Books")));
	
	//on books page	
		
		driver.findElement(By.linkText("Children's Books")).click();
		wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='merchandised-content']/div/div/div/h1")));
		String text=driver.findElement(By.xpath("//*[@id='merchandised-content']/div/div/div/h1")).getText();
		Assert.assertTrue(text.contains("Children's Books"));
		System.out.println("User selected  :" + text);
		
		
	//select toprated	
		driver.findElement(By.linkText("Top Rated")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,3000)", "");
	   	   
	    
	 //select specific book  
	   WebElement flag=driver.findElement(By.linkText("Giraffes Can't Dance"));
	   String bookselected=flag.getText();
	   System.out.println("Book selected is : "+ bookselected);
	   Thread.sleep(3000);
	    js.executeScript("arguments[0].scrollIntoView();", flag);
		flag.click();
		wait=new WebDriverWait(driver,2); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
		
	//no of items before adding to cart
		System.out.println("No of items in cart :" +sr.shoppingBasket().getText());
		
	 //Add to cart	
			driver.findElement(By.id("add-to-cart-button")).click();
			Assert.assertTrue(driver.getTitle().contains("Amazon.co.uk Shopping Basket"));
	

	//no of items after adding to cart
				System.out.println("No of items in cart :" +sr.shoppingBasket().getText());
				
	//click on proceed to checkout
		driver.findElement(By.id("hlb-ptc-btn-native")).click();	
		
		
     //user is on signin page		
		
		Amazonloginpage lg=new Amazonloginpage(driver);
		lg.Emailid().sendKeys("deepikagkv@gmail.com");
		lg.Clickcontinue().click();
		lg.Password().sendKeys("deepu123");
		lg.Clicksignin().click();
	
	
		
	String	payment=driver.getTitle();
	//user is on paymentpage
	//Assert.assertTrue(payment.contains("Place Your Order - Amazon.co.uk Checkout"));	
	
	System.out.println("User on final page: " + payment);
	}
	
/*@AfterMethod
	public void teardown()
	{
		driver.quit();
	}*/
	 

}
