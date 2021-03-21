package com.mypackage.POM;

import com.mypackage.Common.WaitOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {
	private final WebDriver webdriver;

	@FindBy(xpath = "//h1[contains(text(),'Sign-In')]")
	private WebElement signInHeader;

	@FindBy(xpath = "//*[@id=\"authportal-main-section\"][contains(text(),'Email or mobile phone number')]")
	private WebElement subHeaderEmail;

	@FindBy(xpath = "//*[@id=\"authportal-main-section\"][contains(text(),'Password')]")
	private WebElement subHeaderPassword;

	@FindBy(id = "ap_email")
	private WebElement emailField;

	@FindBy(id = "ap_password")
	private WebElement passwordField;

	@FindBy(id = "continue")
	private WebElement continueButton;

	@FindBy(id = "signInSubmit")
	private WebElement signInSubmit;


	public AmazonLoginPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public void ensureThePageIsLoaded() {
		WaitOperations.ensurePageIsLoaded(webdriver);
		WaitOperations.waitUntillVisibleAndClickable(webdriver, By.xpath("//h1[contains(text(),'Sign-In')]"));
		//WaitOperations.waitUntillVisibleAndClickable(webdriver, By.xpath("//*[@id=\"authportal-main-section\"][contains(text(),'Email or "
			//+ "mobile phone number')]"));
		WaitOperations.waitUntillVisibleAndClickable(webdriver, By.id("ap_email"));
		WaitOperations.waitUntillVisibleAndClickable(webdriver, By.id("continue"));

	}

	public AmazonLoginPage enterEmail(String arg0){
		WaitOperations.waitUntillVisibleAndClickable(webdriver, By.id("ap_email"));
		emailField.sendKeys(arg0);
		WaitOperations.waitUntillVisibleAndClickable(webdriver, By.id("continue"));
		continueButton.click();
		return this;
	}

	public AmazonMainPage enterPassword(String arg0){
		WaitOperations.ensurePageIsLoaded(webdriver);
		//WaitOperations.waitUntillVisibleAndClickable(webdriver, By.xpath("//*[@id=\"authportal-main-section\"][contains(text(),'Password')]"));
		WaitOperations.waitUntillVisibleAndClickable(webdriver, By.id("ap_password"));
		passwordField.sendKeys(arg0);
		WaitOperations.waitUntillVisibleAndClickable(webdriver, By.id("signInSubmit"));
		signInSubmit.click();
		return new AmazonMainPage(webdriver);
	}

	public void userShouldNotLogin() {
		WaitOperations.ensurePageIsLoaded(webdriver);
		WaitOperations.waitUntillVisibleAndClickable(webdriver, By.xpath("//h1[contains(text(),'Sign-In')]"));
		//WaitOperations.waitUntillVisibleAndClickable(webdriver, By.xpath("//*[@id=\"authportal-main-section\"][contains(text(),'Email or "
		//+ "mobile phone number')]"));
		WaitOperations.waitUntillVisibleAndClickable(webdriver, By.id("ap_password"));
		WaitOperations.waitUntillVisibleAndClickable(webdriver, By.id("signInSubmit"));

	}



}
