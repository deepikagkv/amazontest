package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Baseclass {
	
	public static WebDriver driver;
	
	public WebDriver initialisedriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\kruthi\\eclipse-workspace\\amazonPOM\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browsername=prop.getProperty("browser");
		System.out.println("We are in browser" +browsername);
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\kruthi\\Documents\\Selenium\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
		}
		else {
			System.out.println("need browser details");
		}
	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
		
}
