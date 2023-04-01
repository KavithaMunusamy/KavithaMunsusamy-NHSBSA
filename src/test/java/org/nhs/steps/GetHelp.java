package org.nhs.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nhs.base.TestBase;
import org.nhs.datamodel.EligibilityCheckOptions;
import org.nhs.steps.action.GetHelpAction;
import org.nhs.utils.Utility;
import org.nhs.utils.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetHelp extends TestBase{
	public Logger logger = LogManager.getLogger();

	private GetHelpAction getHelpAction;

	@Given("^I start the eligibity check$")
	public void iStartEligibilityCheck() throws Throwable {
		getHelpAction = new GetHelpAction(driver);
		getHelpAction.startCheckForHelp();
	}

	@When("^I select all the options (.*) for eligibility check$")
	public void iSelectAllEligibityCheckOptions(String fileName) {

		EligibilityCheckOptions eligiCheckOpts = (EligibilityCheckOptions) Utility.parseJson(fileName, EligibilityCheckOptions.class);
		logger.debug("obtained memberparticulars");
		getHelpAction = new GetHelpAction(eligiCheckOpts, driver);
		String country = eligiCheckOpts.getLivingCountry();

		getHelpAction.chooseLivingCountry(country, Driver.getDriver());

		if (country.equals("England") || country.equals("wales")) {
			getHelpAction.chooseGPScoOrWal("");
			getHelpAction.chooseDentalPrac(country, "");
			getHelpAction.enterDateOfBirth("");

			if (getHelpAction.chooseLiveWithPartner()) {
				// some more tests
			} else {
				if (getHelpAction.chooseClaimBenefits()) {
					// some more tests
				} else {
					getHelpAction.checkIfPregnant();
					getHelpAction.checkWarPension();
					if (getHelpAction.checkIfDiabetic()) {
						// some tests here
						getHelpAction.checkBloodSugarLevel();
						getHelpAction.checkIfInCareHome();
						getHelpAction.checkIfHaveSavings();

					} else {
						//some tests here
					}
				}
			}
		} else if (country.equals("Scotland")) {
			// some test here
		} else if (country.equals("Ni")) {
			// some test here
		}
	}

	@Then("^I am able to see the NHS help listed successfully$")
	public void iAbleToSeeNhsHelpList() throws Throwable {
		getHelpAction.verifyNhsHelpList();

	}

}
