package org.nhs.steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/features"},
		glue= {"org.nhs.steps"},
		plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
		monochrome = true,
		dryRun = false,
		tags=("@helpChecker")
		)

public class TestRunner {
	

}
