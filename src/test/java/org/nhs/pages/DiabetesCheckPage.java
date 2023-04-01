package org.nhs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiabetesCheckPage extends PageBase {

	WebDriver driver;

	@CacheLookup
	@FindBy(id = "next-button")
	WebElement nextButton;

	
	@CacheLookup
	@FindBy(id = "radio-yes")
	WebElement diabetes;
	@CacheLookup
	@FindBy(id = "radio-no")
	WebElement noDiabetes;
	

	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * 
	 * @param driver
	 */
	public DiabetesCheckPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	
	

	/**
	 * Action method to check whether diabetic
	 * @param hasDiabetes
	 */
	public void checkDiabeticDetails(boolean hasDiabetes) {
		checkConditionAndProceed(hasDiabetes, diabetes, noDiabetes, driver, nextButton);
	}

}
