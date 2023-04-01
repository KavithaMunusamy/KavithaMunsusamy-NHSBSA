package org.nhs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LivingCountryPage extends PageBase {

	WebDriver driver;

	@CacheLookup
	@FindBy(id = "next-button")
	WebElement nextButton;

	@CacheLookup
	@FindBy(id = "radio-england")
	WebElement livingCtryEng;
	@CacheLookup
	@FindBy(id = "radio-scotland")
	WebElement livingCtrySco;
	@CacheLookup
	@FindBy(id = "radio-wales")
	WebElement livingCtryWal;
	@CacheLookup
	@FindBy(id = "radio-nire")
	WebElement livingCtryNi;
	
	@CacheLookup
	@FindBy(xpath = "//li[@class='error-message']//descendant::span[text()='Select the country you live in']")
	WebElement errorMessage;
	
	

	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * 
	 * @param driver
	 */
	public LivingCountryPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
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
			livingCtrySco.click();

			break;
		case "Wales":
			livingCtryWal.click();
			break;
		case "NI":
			livingCtryNi.click();
			break;

		default:
			break;
		}
		next(driver, nextButton);

	}
	
	public boolean isErrMsgDisplayed() {
		return errorMessage.isDisplayed();
		
	}

}
