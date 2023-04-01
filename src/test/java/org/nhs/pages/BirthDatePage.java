package org.nhs.pages;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nhs.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BirthDatePage extends PageBase {
	

	private static Logger logger = LogManager.getLogger(BirthDatePage.class);

	WebDriver driver;

	@CacheLookup
	@FindBy(id = "next-button")
	WebElement nextButton;

	@CacheLookup
	@FindBy(id = "dob-day")
	WebElement dobDay;
	@CacheLookup
	@FindBy(id = "dob-month")
	WebElement dobMonth;
	@CacheLookup
	@FindBy(id = "dob-year")
	WebElement dobYear;

	

	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * 
	 * @param driver
	 */
	public BirthDatePage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}



	/**
	 * Action method to choose dental registration.
	 */
	public boolean enterDob(String dateOfBirth) {
		boolean isCorrectDob = true;
		SimpleDateFormat formatter = new SimpleDateFormat(Constants.DD_MM_YYYY);
		try {
			formatter.parse(dateOfBirth);
			Calendar calendar = formatter.getCalendar();

			dobDay.sendKeys(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
			dobMonth.sendKeys(String.valueOf(calendar.get(Calendar.MONTH)+1));
			dobYear.sendKeys(String.valueOf(calendar.get(Calendar.YEAR)));
			next(driver,nextButton);
			
		} catch (ParseException e) {
			logger.debug(e.getMessage());
			isCorrectDob = false;
			
		}
		return isCorrectDob;

	}

}
