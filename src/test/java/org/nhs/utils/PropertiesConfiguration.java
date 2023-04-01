package org.nhs.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nhs.constants.Constants;



/**
 * Class to get the configuration from properties file
 * @author Kavitha M
 *
 */
public class PropertiesConfiguration {
	
	private static Logger logger = LogManager.getLogger(PropertiesConfiguration.class);
	
	private static PropertiesConfiguration propInstance = null;
	private Properties propFile =null;	

	/**
	 * Constructor to load the properties file
	 * @param fileName
	 */
	private PropertiesConfiguration(){
		propFile = new Properties();
		try {
			//InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
			propFile.load(Utility.getFile(Constants.CONFIG_FILE));
			logger.info("file loaded successfully", this);
		} catch (IOException e) {
			logger.error("unable to load properties file:" + e.getMessage(), e);
		}
		
	}
	
	public static PropertiesConfiguration getPropInstance() {
		if(null == propInstance) {
			propInstance = new PropertiesConfiguration();			
		}		
		return propInstance;
				//propConf.propFile.getProperty(propertyName);
	}
	
	public String getPropertyValue(String propertyName) {
		
		return propInstance.propFile.getProperty(propertyName);
	}
	
	
	

}
