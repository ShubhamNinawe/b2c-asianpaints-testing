package com.b2c.asianpaints.Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fs = new FileInputStream(src);
			properties = new Properties();
			properties.load(fs);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		return url;
	}
	
	public String getChromePath() {
		String chromepath = properties.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath() {
		String firefoxpath = properties.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getValidPincode() {
		String validPincode = properties.getProperty("validPincode");
		return validPincode;
	} 
	
	public String getInvalidPincode() {
		String InvalidPincode = properties.getProperty("invalidPincode");
		return InvalidPincode;
	}

}
