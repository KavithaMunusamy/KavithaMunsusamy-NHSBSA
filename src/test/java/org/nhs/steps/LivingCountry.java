package org.nhs.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nhs.base.TestBase;
import org.nhs.steps.action.GetHelpAction;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LivingCountry extends TestBase{
	public Logger logger = LogManager.getLogger();

	private GetHelpAction getHelpAction = new GetHelpAction(driver);

	
	@When("^I choose my living country (.*)$")
	public void iChooseTheLivingCountry(String country) throws Throwable {
		getHelpAction.chooseLivingCountry(country,driver);
	}
	@When("^I attempt to proceed without choosing living country$")
	public void userProceedsWithoutChoosingLivingCountry(){	
		getHelpAction.chooseLivingCountry("",driver);
	}

	@Then("^I am able to proceed to next check with (.*) successfully$")
	public void verifyNavigateToNextCheck(String country) throws Throwable {
		getHelpAction.verifyNavigationFromLivingCtry(country);
	}
	
	@Then("^error message is displayed$")
	public void errorMessageIsDisplayed() throws Throwable {
		getHelpAction.verifyNavigationFromLivingCtry("");
	}

}
