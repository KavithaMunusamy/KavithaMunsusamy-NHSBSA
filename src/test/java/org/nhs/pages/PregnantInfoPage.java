package org.nhs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PregnantInfoPage extends PageBase {

	WebDriver driver;

	@CacheLookup
	@FindBy(id = "next-button")
	WebElement nextButton;

	
	@CacheLookup
	@FindBy(id = "radio-yes")
	WebElement pregNantYes;
	@CacheLookup
	@FindBy(id = "radio-no")
	WebElement pregnantNo;
	

	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * 
	 * @param driver
	 */
	public PregnantInfoPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}


	/**
	 * Action method to choose if GP in Scotland or Wales.
	 */
	/**
	 * Action method to choose if pregnant.
	 * @param isPregnant
	 */
	public void checkPregnantDetails(boolean isPregnant) {
		checkConditionAndProceed(isPregnant, pregNantYes, pregnantNo, driver, nextButton);

	}

}
