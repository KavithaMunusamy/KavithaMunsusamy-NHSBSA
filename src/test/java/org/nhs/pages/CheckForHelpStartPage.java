package org.nhs.pages;

import org.nhs.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckForHelpStartPage extends PageBase {

	WebDriver driver;

	@CacheLookup
	@FindBy(id = "next-button")
	WebElement nextButton;

	@CacheLookup
	@FindBy(id = "nhsuk-cookie-banner__link_accept_analytics")
	WebElement acceptCookiesElement;

	@CacheLookup
	@FindBy(id = "radio-england")
	WebElement livingCtryEng;

	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * 
	 * @param driver
	 */
	public CheckForHelpStartPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Action method to start the check for help.
	 */
	public void startCheck() {

		acceptCookies();
		Utility.waitForClickableElement(driver, nextButton);
		nextButton.click();
	}

	/**
	 * Action method to accept cookies.
	 */
	public void acceptCookies() {
		if (acceptCookiesElement.isDisplayed()) {
			acceptCookiesElement.click();
		}
	}

	/**
	 * Action method to choose living country.
	 */
	public void selectLivingCountryEng(String country) {
		switch (country) {
		case "England":
			livingCtryEng.click();
			
			break;
		case "Scotland":

			break;
		case "Wales":

			break;
		case "NI":

			break;

		default:
			break;
		}
		startCheck();

	}

}
