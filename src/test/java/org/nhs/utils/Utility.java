package org.nhs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nhs.datamodel.EligibilityCheckOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility Class having common reusable methods
 * 
 * @author Kavitha M
 *
 */
public class Utility {
	static Logger logger = LogManager.getLogger();
	static WebDriverWait wait;

	/**
	 * takes screenshot of the browser screen for a given scenario
	 * 
	 * @param driver
	 * @param scenarioName
	 */
	public static void takeScreenshot(WebDriver driver, String scenarioName) {

		((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	}

	public static FileInputStream getFile(String filename) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(filename));

		} catch (FileNotFoundException e) {
			logger.error("unable to load properties file:" + e.getMessage(), e);

		}
		return inputStream;
	}

	public static EligibilityCheckOptions parseJson(String fileName) {
		ObjectMapper objectMapper = new ObjectMapper();
		EligibilityCheckOptions memParticular = null;
		try {
			memParticular = objectMapper.readValue(getFile("./data/"+fileName), EligibilityCheckOptions.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memParticular;

	}
	
	public static <T> T parseJson(String fileName, Class<T> type) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			return objectMapper.readValue(getFile("./data/"+fileName), type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	
	/**
	 * waits for the element until it is clickable
	 * @param driver
	 * @param waitTimeInSeconds
	 * @param element
	 * @return
	 */
	public static WebElement waitForClickableElement(WebDriver driver, WebElement element) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
