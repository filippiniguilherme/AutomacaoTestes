package Tests.TestsWithSelenium;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	@Test
	public void testeTextField() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Filippini\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Filippini/Downloads/campo-treinamento/componentes.html");	
		driver.manage().window().setSize(new Dimension(1200,765));
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Guilherme Filippini");
		Assert.assertEquals("Guilherme Filippini", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void deveInteragirComTextArea() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Filippini\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Filippini/Downloads/campo-treinamento/componentes.html");	
		driver.manage().window().setSize(new Dimension(1200,765));
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando");
		Assert.assertEquals("Testando", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Filippini\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Filippini/Downloads/campo-treinamento/componentes.html");	
		driver.manage().window().setSize(new Dimension(1200,765));
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Filippini\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Filippini/Downloads/campo-treinamento/componentes.html");	
		driver.manage().window().setSize(new Dimension(1200,765));
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.quit();
	}
	
	@Test
	public void deveInteragirComCombo() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Filippini\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Filippini/Downloads/campo-treinamento/componentes.html");	
		driver.manage().window().setSize(new Dimension(1200,765));
		WebElement element= driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Filippini\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Filippini/Downloads/campo-treinamento/componentes.html");	
		driver.manage().window().setSize(new Dimension(1200,765));
		WebElement element= driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		
		Assert.assertEquals(8,  options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")){
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
		driver.quit();
	}
	@Test
	public void deveVerificarValoresComboMultiplo() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Filippini\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Filippini/Downloads/campo-treinamento/componentes.html");	
		driver.manage().window().setSize(new Dimension(1200,765));
		WebElement element= driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement>allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		driver.quit();
	}
	@Test
	public void deveInteragirComBotoes() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Filippini\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Filippini/Downloads/campo-treinamento/componentes.html");	
		driver.manage().window().setSize(new Dimension(1200,765));
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
		
	}
}
