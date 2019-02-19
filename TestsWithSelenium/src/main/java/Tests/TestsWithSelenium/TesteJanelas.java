package Tests.TestsWithSelenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteJanelas {
	@Test
	public void deveInteragirComJanelas() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Filippini\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Filippini/Downloads/campo-treinamento/componentes.html");	
		driver.manage().window().setSize(new Dimension(1200,765));
	
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("e agora?");
		
		
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Filippini\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Filippini/Downloads/campo-treinamento/componentes.html");	
		driver.manage().window().setSize(new Dimension(1200,765));
	
		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandles());
	}
}
