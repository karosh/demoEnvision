package com.mypackage.Common;

import com.mypackage.POM.AmazonMainPage;
import com.google.common.base.Strings;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Selenium {

	private static String envGecko;
	private static String envChrome;
	private static WebDriver driver;
	private static ArrayList<WebDriver> drivers = new ArrayList<WebDriver>();


	static {
		System.getenv().entrySet()
			  .forEach(entry -> {
				  System.out.println(entry.getKey() + ":" + entry.getValue());
			  });
		envGecko = System.getenv("GECKO_BINARY_DRIVER");
		if (Strings.isNullOrEmpty(envGecko)) {
			System.err.println("GECKO_DRIVER_BINARY environmental variable should be set");
			System.exit(1);
		}

		envChrome = System.getenv("CHROME_DRIVER");
		if (Strings.isNullOrEmpty(envChrome)) {
			System.err.println("CHROME_DRIVER_BINARY environmental variable should be set");
			System.exit(1);
		}
	}

	public static WebDriver webdriver(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", envGecko);
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", envChrome);
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
			drivers.add(driver);

		}

		driver.manage().window().maximize();
		return driver;
	}

	public static AmazonMainPage amazonmainPage(String browser) {
		return new AmazonMainPage(webdriver(browser));
	}

	public static void closeOpenedDrivers() {
		for (WebDriver driver :
			drivers) {
			driver.close();
			System.out.println("Driver closed");
		}
		drivers.clear();
	}

}
