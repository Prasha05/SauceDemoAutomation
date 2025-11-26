package com.saucedemo.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;
	static {
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Prasha\\eclipse-workspace\\SauceDemoAutomation\\src\\main\\resources\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file", e);
		}
	}

	private ConfigReader() {

	}

	public static String getProperty(String key) {
		String value = prop.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Key not found in config file" + key);
		}
		return value;
	}
}
