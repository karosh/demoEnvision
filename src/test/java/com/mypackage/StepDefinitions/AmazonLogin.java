package com.mypackage.StepDefinitions;

import com.mypackage.Common.Selenium;
import com.mypackage.POM.AmazonLoginPage;
import com.mypackage.POM.AmazonMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;



public class AmazonLogin {

	private AmazonMainPage amazonMainPage;
	private AmazonLoginPage amazonLoginPage;

	@Given("user enter the {string} URL")
	public void userEnterAmazonURL(String arg0) {
		this.amazonMainPage = Selenium.amazonmainPage("chrome").openAmazon(arg0);
	}

	@And("click on Sign in")
	public void clickOnSignIn() {
		this.amazonLoginPage = this.amazonMainPage.clickOnSignIn();
	}

	@Then("Amazon login page is opened")
	public void amazonLoginPageIsOpened() {
		this.amazonLoginPage.ensureThePageIsLoaded();
	}

	@When("user provides valid credentials as; {string}, {string}")
	public void userProvidesValidAnd(String arg0, String arg1) {
		this.amazonLoginPage.enterEmail(arg0);
		this.amazonMainPage = this.amazonLoginPage.enterPassword(arg1);
	}

	@Then("user should be able to login to Amazon")
	public void userShouldBeAbleToLoginToAmazon() {
		this.amazonMainPage.checkCustomerName();
	}


	@When("user provides invalid {string} and {string}")
	public void userProvidesInvalidAnd(String arg0, String arg1) {
		this.amazonLoginPage.enterEmail(arg0);
		this.amazonMainPage = this.amazonLoginPage.enterPassword(arg1);
	}

	@Then("user should not be able to login")
	public void userShouldNotBeAbleToLogin() {
		this.amazonLoginPage.userShouldNotLogin();


	}

	@And("user should see a {string} about invalid credentials")
	public void userShouldSeeAAboutInvalidCredentials(String arg0) {
	}
}
