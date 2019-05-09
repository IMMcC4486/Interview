package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavBar {

	public static WebElement getShop(WebDriver driver) {
		return driver.findElement(By.cssSelector("body > section > div > header > div.polaris-nav.polaris-nav-header-wrapper > div > ul:nth-child(3) > li:nth-child(1) > a"));
	}
	
	
}
