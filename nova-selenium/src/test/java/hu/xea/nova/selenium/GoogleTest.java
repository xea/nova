package hu.xea.nova.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class GoogleTest {
	
	final WebDriver driver = new HtmlUnitDriver(true);
	
	@Test
	public void testIfGoogleExists() {
		
		driver.get("http://www.mvnrepository.com");
		
		System.out.println(driver.getTitle());
		By searchField = By.id("query");
		By submitButton = By.linkText("Search");
		driver.findElement(searchField).sendKeys("selenium");
		driver.findElement(submitButton).click();
		
		System.out.println(driver.getTitle());
	}

}
