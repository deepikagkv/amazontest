package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.Baseclass;

public class basepagetest extends Baseclass {
	
	@Test
	public void firsttest() throws IOException
	{
		driver=initialisedriver();
		driver.get("https://www.amazon.co.uk/");
	}
}
