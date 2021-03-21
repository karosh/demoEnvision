package com.mypackage.POM;

import com.mypackage.Common.WaitOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMainPage {

	private final WebDriver webdriver;

	public AmazonMainPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public AmazonMainPage openAmazon(String arg0) {
		this.webdriver.get(arg0);
		return this;
	}


	@FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"][contains(text(),'Hello, Sign in')]")
	private WebElement signInButton;


	@FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"][contains(text(),'Hello, Envision')]")
	private WebElement customerName;



	public AmazonLoginPage clickOnSignIn() {
		WaitOperations.ensurePageIsLoaded(webdriver);
		WaitOperations.waitUntillVisibleAndClickable(webdriver, By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"][contains(text(),'Hello, Sign in')]"));
		signInButton.click();

		return new AmazonLoginPage(webdriver);
	}

	public void checkCustomerName() {
		WaitOperations.ensurePageIsLoaded(webdriver);
		WaitOperations.waitUntillVisibleAndClickable(webdriver, By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"][contains(text(),'Hello, Envision')]"));

	}

}
