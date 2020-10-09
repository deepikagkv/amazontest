package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Amazonloginpage {

	public WebDriver driver;
	
	public Amazonloginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	By email = By.name("email");
	By password = By.id("ap_password");
	By clickcontinue =By.id("continue");
	By signin =By.id("signInSubmit");
	By mouseover=By.id("nav-link-accountList");
	
	public WebElement Emailid() {
		return driver.findElement(email);
	}
	public WebElement Password() {
		return driver.findElement(password);
		
	}

	public WebElement Clickcontinue() {
		return driver.findElement(clickcontinue);
		
	}

	public WebElement Clicksignin() {
		return driver.findElement(signin);
		
	}
	
	
}
