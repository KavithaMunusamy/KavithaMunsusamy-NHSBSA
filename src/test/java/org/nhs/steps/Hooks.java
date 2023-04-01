package org.nhs.steps;

import org.nhs.base.TestBase;
import org.nhs.utils.Utility;
import org.nhs.utils.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void beforeEach() {
		new TestBase().launchApplication();
	}

	@After
	public void tearDown(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				Utility.takeScreenshot(TestBase.driver, scenario.getName());
			}
		} finally {
			Driver.closure();
		}
		
		
	}

}
