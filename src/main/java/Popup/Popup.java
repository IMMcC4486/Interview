package Popup;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Popup {

	
	public static void checkForPopUp(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		try {
		wait.until(ExpectedConditions.visibilityOf((WebElement) By.id("IPEinvL114714")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("no")));
		driver.findElement(By.id("no")).click();
		} catch (NoSuchElementException e) {
			// doesn't exist
		}
	
	}
}
