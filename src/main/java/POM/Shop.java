package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shop {
	
	public static WebElement getInternet(WebDriver driver) {
		return driver.findElement(By.cssSelector("body > section > div > main > div.x-dealfinder-wrapper > div:nth-child(2) > div > div.x-dealfinder__inner.x-content--wide > div > div.x-flex__col-xs-12.x-flex__col-lg-3.x-filters-main > div > div.x-filters-wrap > div.x-filters-wrap__inner > section > form > div > section.x-filters__primary > section:nth-child(2) > div > div:nth-child(2) > label"));
	}
	public static WebElement getTV(WebDriver driver) {
		return driver.findElement(By.cssSelector("body > section > div > main > div.x-dealfinder-wrapper > div:nth-child(2) > div > div.x-dealfinder__inner.x-content--wide > div > div.x-flex__col-xs-12.x-flex__col-lg-3.x-filters-main > div > div.x-filters-wrap > div.x-filters-wrap__inner > section > form > div > section.x-filters__primary > section:nth-child(2) > div > div:nth-child(3) > label"));
	}
	public static WebElement getPhone(WebDriver driver) {
		return driver.findElement(By.cssSelector("body > section > div > main > div.x-dealfinder-wrapper > div:nth-child(2) > div > div.x-dealfinder__inner.x-content--wide > div > div.x-flex__col-xs-12.x-flex__col-lg-3.x-filters-main > div > div.x-filters-wrap > div.x-filters-wrap__inner > section > form > div > section.x-filters__primary > section:nth-child(2) > div > div:nth-child(4) > label"));
	}
	public static WebElement getHomeSecurity(WebDriver driver) {
		return driver.findElement(By.cssSelector("body > section > div > main > div.x-dealfinder-wrapper > div:nth-child(2) > div > div.x-dealfinder__inner.x-content--wide > div > div.x-flex__col-xs-12.x-flex__col-lg-3.x-filters-main > div > div.x-filters-wrap > div.x-filters-wrap__inner > section > form > div > section.x-filters__primary > section:nth-child(2) > div > div:nth-child(5) > label"));
	}
	
	// search this for prices
	
	private static int priceExist(WebDriver driver, String price) {
		String priceChecker1 = "body > section > div > main > div.x-dealfinder-wrapper > div:nth-child(2) > div > div.x-dealfinder__inner.x-content--wide > div > div.x-flex__col-xs-12.x-flex__col-lg-9.x-offers-main > div.x-offercard-wrap > section:nth-child(";
		String priceChecker2 = ") > div.x-flex__col-xs-12.x-flex__col-md-4.x-flex__col-lg-3.x-ui-theme--grey.x-offercard__bottom > div > aside > div.x-flex-row.flush.center-xs.middle-xs > div > h2";
		int pricenum = 2;
		try {
			while (true) {
//				if(driver.findElement(By.partialLinkText("We can point you in the right direction")) != null) {
//					continue;
//				}
				WebElement e = driver.findElement(By.cssSelector(priceChecker1 + pricenum + priceChecker2));
				System.out.println("inner html : " + e.getAttribute("innerHTML"));
				System.out.println("    price  : " + price + " dollars per month\n");

				if (e.getAttribute("innerHTML").contains(price + " dollars per month")) {
					return pricenum;
				}
				pricenum++;
			}
		} catch (NoSuchElementException e) {
			// doesn't exist
		}
		return 0;
	}

	public static WebElement getPackageByPrice(WebDriver driver, String price) {
		int packageNum = priceExist(driver, price);
		if(packageNum != 0) {
			String uno = "body > section > div > main > div.x-dealfinder-wrapper > div:nth-child(2) > div > div.x-dealfinder__inner.x-content--wide > div > div.x-flex__col-xs-12.x-flex__col-lg-9.x-offers-main > div.x-offercard-wrap > section:nth-child(";
			String dos = ") > div.x-flex__col-xs-12.x-flex__col-md-4.x-flex__col-lg-3.x-ui-theme--grey.x-offercard__bottom > div > aside > div:nth-child(2) > div > div > form > button";
			return driver.findElement(By.cssSelector(uno + packageNum + dos));
		}
		System.out.println("package number : " + packageNum);
		return null;
	}

	public static WebElement getPackageStreetAddress(WebDriver driver) {
		return driver.findElement(By.cssSelector("#Address_SingleStreetAddress"));
	}
	
	public static WebElement getPackageStreetAddressContinue(WebDriver driver) {
		return driver.findElement(By.cssSelector("body > section.x-overlay.x-flex-row.center-xs.middle-xs._fade-in.x-overlay--localization > div.x-overlay-container.x-ui-theme--light.x-flex__col-xs-12.x-flex__col-md-10 > div > div > div.x-overlay-content-body > section > form > fieldset > div > div.x-flex-row.x-content.center-xs > div > button"));
	}
	
	public static WebElement firstitem(WebDriver driver) {
		return driver.findElement(By.cssSelector("#Address_SingleStreetAddress__results > li:nth-child(1) > button"));
	}


}
