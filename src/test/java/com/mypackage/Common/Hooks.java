package com.mypackage.Common;


import io.cucumber.java.After;

public class Hooks {

	@After("@closeBrowser")
	public static void tearDown() {
		Selenium.closeOpenedDrivers();
	}
}
