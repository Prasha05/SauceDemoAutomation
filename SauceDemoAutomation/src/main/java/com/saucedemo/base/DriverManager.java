package com.saucedemo.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.saucedemo.logging.LogHelper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public DriverManager() {

	}

	private static final Logger logger = LogHelper.getLogger(DriverManager.class);

	public static void initDriver(String browser) {
		if (driver.get() == null) {
//			String browser = ConfigReader.getProperty("browser").toLowerCase();
			try {
				logger.info("Initializing WebDriver for browser: " + browser);
				switch (browser.toLowerCase()) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--incognito");
					driver.set(new ChromeDriver(options));
					logger.info("Chrome browser launched successfully in incognito mode.");
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver.set(new FirefoxDriver());
					logger.info("Firefox browser launched successfully.");
					break;
				case "edge":
					System.out.println("Launching Edge browser...");
					WebDriverManager.edgedriver().setup();
					driver.set(new EdgeDriver());
					logger.info("Edge browser launched successfully.");
					break;

				default:
					logger.error("Invalid browser name provided: " + browser);
					throw new RuntimeException("Invalid browser name" + browser);
				}
				driver.get().manage().window().maximize();
				logger.info(browser + " window maximized successfully.");
			} catch (Exception e) {
				logger.error(
						"Error initializing WebDriver for browser: " + browser + " | Exception: " + e.getMessage());
				throw new RuntimeException("Failed to initialize WebDriver: " + e.getMessage());
			}
		}
	}

	public static WebDriver getDriver() {
		if (driver.get() == null) {
			logger.error("WebDriver is not initialized. Call initDriver() first.");
			throw new RuntimeException("WebDriver is not initialized. Call initDriver() first.");
		}
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			logger.info("Closing and quitting WebDriver instance...");
			driver.get().quit();
			driver.remove();
			logger.info("WebDriver closed and removed successfully.");
		}
	}
}
