package org.nhs.pages;

import org.nhs.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {

	

	/**
	 * Action method to proceed to next page.
	 */
	public void next(WebDriver driver, WebElement webElement) {

		Utility.waitForClickableElement(driver, webElement);
		webElement.click();
	}
	
	


	/**
	 * Action method to choose the radio option based on the condition - checkParamter
	 * @param checkParamter
	 * @param yesWebElement
	 * @param noWebElement
	 */
	public void checkConditionAndProceed(boolean checkParamter,  WebElement yesWebElement,  
			WebElement noWebElement, WebDriver driver, WebElement nextElement) {
		if(checkParamter) {
			yesWebElement.click();
		} else {
			noWebElement.click();
		}
		next(driver, nextElement);

	}
	


}
