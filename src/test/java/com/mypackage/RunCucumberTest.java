package com.mypackage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	plugin={"pretty:target/cucumber-htmlreport.text", "json:target/cucmber-report.json"},
	features = { "classpath:com.mypackage.features"}

)
public class RunCucumberTest {

}
//@CucumberOptions(plugin = {"pretty", "html:target/site/cucumber-pretty.html",
//	"json:target/cucumberresults.json", "de.monochromata.cucumber.report.PrettyReports:target/cucumber/results"})

/*
@Cucumber.Options(

	//glue = {"com.lebara.stepdefs","com.lebara.framework.main", "com.lebara.testrunner"},
	features = "C:/Users/sarthak.dayanand/Documents/WebRefreshTest/CukeAutomation/LebaraWebAutomationTest1/src/main/resources",
	format = {"pretty", "html:target/cucumber-html-report", "json-pretty:target/cucumber-report.json"},
	//tags = {"@UserJourney"}

)
*/


