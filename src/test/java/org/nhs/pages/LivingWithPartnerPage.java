package org.nhs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LivingWithPartnerPage extends PageBase{

	WebDriver driver;

	@CacheLookup
	@FindBy(id = "next-button")
	WebElement nextButton;

	
	@CacheLookup
	@FindBy(id = "radio-yes")
	WebElement withPartner;
	@CacheLookup
	@FindBy(id = "radio-no")
	WebElement withoutPartner;
	

	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * 
	 * @param driver
	 */
	public LivingWithPartnerPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Action method to choose whether living with partner.
	 * @param doLiveWithPartner
	 */
	public void doLiveWithPartner(boolean doLiveWithPartner) {
		checkConditionAndProceed(doLiveWithPartner, withPartner, withoutPartner, driver, nextButton);

	}

}
