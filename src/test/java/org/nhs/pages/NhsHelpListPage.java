package org.nhs.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NhsHelpListPage {

	WebDriver driver;


	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * 
	 * @param driver
	 */
	public NhsHelpListPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}


	
	public boolean hasNhsHelpList(ArrayList<String> nhsHelpList) {
		boolean hasHelpList = true;
		
		for(String nhsHelp :nhsHelpList) {
			if(!driver.findElement(By.cssSelector("span[text='"+nhsHelp+"']")).isDisplayed()) {
				hasHelpList= false;
				break;
			}
		}
		return hasHelpList;
	}

	
	

	
}
