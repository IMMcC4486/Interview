package util;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeDriver {

	private static WebDriver driver;
	
	private MakeDriver() {}
	
	public static WebDriver getDriver() {
		if (driver == null) {
			// make
			File cd = new File("./src/main/resources/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",cd.getAbsolutePath());
			driver = new ChromeDriver();
		}
		
		return driver;
	}
	
}
