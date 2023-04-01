package org.nhs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClaimBenefitsPage  extends PageBase{

	WebDriver driver;

	@CacheLookup
	@FindBy(id = "next-button")
	WebElement nextButton;

	
	@CacheLookup
	@FindBy(id = "radio-yes")
	WebElement hasBenefits;
	@CacheLookup
	@FindBy(id = "radio-no")
	WebElement noBenefits;
	

	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * 
	 * @param driver
	 */
	public ClaimBenefitsPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	
	
	/**
	 * Action method to proceed to next page.
	 * @param hasClaimBenefits
	 */
	public void provideClaimDetails(boolean hasClaimBenefits) {
		checkConditionAndProceed(hasClaimBenefits, hasBenefits, noBenefits, driver, nextButton);
	}
	

}
