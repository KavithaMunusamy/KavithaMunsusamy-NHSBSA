package org.nhs.utils;

import org.nhs.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    /**
     * returns the Singleton WebDriver for a whole session	
     * @return
     */
    public static WebDriver getDriver(){
    	

        if(driver == null){

            String browser = PropertiesConfiguration.getPropInstance().getPropertyValue(Constants.BROWSER);          
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
        			driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions fireFoxptions = new FirefoxOptions();
                    fireFoxptions.addArguments("--remote-allow-origins=*");
                    driver = new FirefoxDriver(fireFoxptions);
                    break;

            }
        }
        return driver;
    }

    
    /**
     * closes the WebDriver
     */
    public static void closure() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
