package Tests.TestsWithSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	@Test
	public void teste() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Filippini\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().window().setSize(new Dimension(1200,765));
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
}
