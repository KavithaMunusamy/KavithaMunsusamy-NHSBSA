package org.nhs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DentalPracticePage extends PageBase {

	WebDriver driver;

	@CacheLookup
	@FindBy(id = "next-button")
	WebElement nextButton;

	@CacheLookup
	@FindBy(id = "radio-england")
	WebElement dentalRegEng;
	@CacheLookup
	@FindBy(id = "radio-scotland")
	WebElement dentalRegSco;
	@CacheLookup
	@FindBy(id = "radio-wales")
	WebElement dentalRegWal;
	@CacheLookup
	@FindBy(id = "radio-nire")
	WebElement dentalRegNi;
	@CacheLookup
	@FindBy(id = "label-not-registered")
	WebElement dentalNotReg;
	

	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * 
	 * @param driver
	 */
	public DentalPracticePage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Action method to choose dental registration.
	 * @param country
	 */
	public void selectDentalReg(String country) {
		switch (country) {
		case "England":
			dentalRegEng.click();

			break;
		case "Scotland":
			dentalRegSco.click();

			break;
		case "Wales":
			dentalRegWal.click();
			break;
		case "NI":
			dentalRegNi.click();
			break;
		case "NotRegistered":
			dentalNotReg.click();

			break;

		default:
			break;
		}
		next(driver, nextButton);

	}

}
