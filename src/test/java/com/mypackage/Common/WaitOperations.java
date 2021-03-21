package com.mypackage.Common;

import static org.awaitility.Awaitility.await;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@Slf4j
public class WaitOperations {
	public static void waitUntillVisibleAndClickable(WebDriver webDriver, By by) {
		WaitOperations.ensurePageIsLoaded(webDriver);
		await()
			.atMost(40, TimeUnit.SECONDS)
			.until(() -> isVisibleAndClickable(webDriver, by));
	}

	public static void ensurePageIsLoaded(WebDriver webDriver) {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		await()
			.atMost(10, TimeUnit.SECONDS)
			.until(() -> {
				try {
					Boolean result = executor.executeScript("return document.readyState").toString().equalsIgnoreCase("complete");
					System.out.println("Page load result: {}" + result);
					return result;
				} catch (Exception e) {
					return false;
				}
			});
	}

	private static Boolean isVisibleAndClickable(WebDriver webDriver, By by) {
		try {
			return webDriver.findElement(by).isEnabled() &&
				webDriver.findElement(by).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static void forceClick(WebDriver webdriver, By xpath) {
		await()
			.atMost(10, TimeUnit.SECONDS)
			.until(() -> {
				try {
					webdriver.findElement(xpath)
							 .click();
					return true;
				} catch (Exception e) {
					return false;
				}
			});
	}
}
