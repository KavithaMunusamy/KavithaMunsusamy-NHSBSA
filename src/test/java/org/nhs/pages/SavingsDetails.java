package org.nhs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavingsDetails extends PageBase {

	WebDriver driver;

	@CacheLookup
	@FindBy(id = "next-button")
	WebElement nextButton;

	
	@CacheLookup
	@FindBy(id = "radio-yes")
	WebElement savings;
	@CacheLookup
	@FindBy(id = "radio-no")
	WebElement noSavings;
	

	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * 
	 * @param driver
	 */
	public SavingsDetails(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Action method to choose whether have savings.
	 * @param hasSavings
	 */
	public void doHaveSavings(boolean hasSavings) {
		checkConditionAndProceed(hasSavings, savings, noSavings, driver, nextButton);

	}

}