package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Amazonproductpage {
	public WebDriver driver;

	//always create the constructor and pass the driver
	//this give life to the driver which can be used in child class using object
		
		public Amazonproductpage(WebDriver driver)
		{
			this.driver=driver;
		}
		
		By searchbox = By.id("twotabsearchtextbox");
		By button    = By.xpath("//*[@id=\'nav-search\']/form/div[2]/div/input");
		By basket	 =By.xpath("//*[@id=\'nav-cart\']");
		By brand     = By.xpath("//*[@id='p_89-title']");
		By price     = By.xpath("//*[@id=\'p_36/138896031\']/span/a");
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
		public WebElement brand()
		{
			return driver.findElement(brand);
		}
		
		public WebElement price()
		{
			return driver.findElement(price);
		}
		
}
