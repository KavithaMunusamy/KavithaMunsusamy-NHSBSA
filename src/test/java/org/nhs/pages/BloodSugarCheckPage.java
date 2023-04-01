package org.nhs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BloodSugarCheckPage extends PageBase {

	WebDriver driver;

	@CacheLookup
	@FindBy(id = "next-button")
	WebElement nextButton;

	
	@CacheLookup
	@FindBy(id = "radio-yes")
	WebElement stableSugarLevel;
	@CacheLookup
	@FindBy(id = "radio-no")
	WebElement unstableSugarLevel;
	

	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * 
	 * @param driver
	 */
	public BloodSugarCheckPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}



	/**
	 * Action method to choose if sugar level stable or not
	 */
	public void checkBloodSugarLevel(boolean hasStableSugalLevel) {
		checkConditionAndProceed(hasStableSugalLevel, stableSugarLevel, unstableSugarLevel, driver, nextButton);
		

	}

}
