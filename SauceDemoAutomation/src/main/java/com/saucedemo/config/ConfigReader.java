package com.saucedemo.config;

import java.util.Properties;

public class ConfigReader {
	private static Properties prop;
	static {
		try {
			prop = new Properties();
			prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (Exception e) {
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
