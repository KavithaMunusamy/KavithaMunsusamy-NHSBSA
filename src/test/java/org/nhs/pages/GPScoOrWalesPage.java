package org.nhs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GPScoOrWalesPage extends PageBase{

	WebDriver driver;

	@CacheLookup
	@FindBy(id = "next-button")
	WebElement nextButton;

	@CacheLookup
	@FindBy(id = "question-heading")
	WebElement quesHeading;
	@CacheLookup
	@FindBy(id = "radio-yes")
	WebElement gpScoWal;
	@CacheLookup
	@FindBy(id = "radio-no")
	WebElement gpNotScoWal;
	

	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * 
	 * @param driver
	 */
	public GPScoOrWalesPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}


	/**
	 * Action method to choose if GP in Scotland or Wales.
	 * @param isGpScoOrWal
	 */
	public void isGpScoOrWal(boolean isGpScoOrWal) {
		checkConditionAndProceed(isGpScoOrWal, gpScoWal, gpNotScoWal, driver, nextButton);
	}


}
