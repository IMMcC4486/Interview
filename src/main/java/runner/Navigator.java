package runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.NavBar;
import POM.Shop;
import util.MakeDriver;

public class Navigator {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d = MakeDriver.getDriver();
		
		String XF = "http://www.xfinity.com";
		
		WebDriverWait wait = new WebDriverWait(d, 5);
		
		d.get(XF);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NavBar.getShop(d).click();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		Popup.checkForPopup

		Shop.getPhone(d).click();
		Shop.getTV(d).click();
		Shop.getPackageByPrice(d, "39.99").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#Address_SingleStreetAddress")));
		Shop.getPackageStreetAddress(d).sendKeys("123");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#Address_SingleStreetAddress__results > li:nth-child(1) > button")));
		Shop.firstitem(d).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > section.x-overlay.x-flex-row.center-xs.middle-xs._fade-in.x-overlay--localization > div.x-overlay-container.x-ui-theme--light.x-flex__col-xs-12.x-flex__col-md-10 > div > div > div.x-overlay-content-body > section > form > fieldset > div > div.x-flex-row.x-content.center-xs > div > button")));
		Shop.getPackageStreetAddressContinue(d).click();
		Thread.sleep(10000);
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		d.close();
		d.quit();
		
		
		
		
	}
	
}
