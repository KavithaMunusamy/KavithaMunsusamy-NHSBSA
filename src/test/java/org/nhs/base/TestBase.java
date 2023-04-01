package org.nhs.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nhs.constants.Constants;
import org.nhs.utils.Driver;
import org.nhs.utils.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;



public class TestBase {
	public static WebDriver driver = null;
	static String PROJECT_PATH = System.getProperty("user.dir");
	public Logger logger = LogManager.getLogger();
	String browser;

	public  void launchApplication() {
		driver = Driver.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.get(PropertiesConfiguration.getPropInstance().getPropertyValue(Constants.BASE_URL));
		
	}
	
		
}
