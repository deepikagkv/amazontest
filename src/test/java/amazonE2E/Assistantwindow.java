package amazonE2E;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Baseclass;

public class Assistantwindow extends Baseclass {
	public static WebDriver driver;
	Actions a;
	static WebDriverWait wait;
	
	@Test
	public void launchpage() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1311.R5.TR12.TRC2.A0.H0.Xfitbit+.TRS0&_nkw=fitbit+charge+3&_sacat=0");
	}
}	

