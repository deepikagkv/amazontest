package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Amazonhomepage {
	
public WebDriver driver;

//always create the constructor and pass the driver
//this give life to the driver which can be used in child class using object
	
	public Amazonhomepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By searchbox = By.id("twotabsearchtextbox");
	By button    = By.xpath("//*[@id=\'nav-search\']/form/div[2]/div/input");
	By basket	 =By.xpath("//*[@id=\'nav-cart\']");
	By signin	= By.id("nav-link-accountList");
	
	public WebElement Searchbox() {
		return driver.findElement(searchbox);
	}
	
	
	public WebElement searchbutton()
	{
		return driver.findElement(button);
	}
	

	public WebElement shoppingBasket()
	{
		return driver.findElement(basket);
	}
	public WebElement signintab()
	{
		return driver.findElement(signin);
	}
	
	
}
