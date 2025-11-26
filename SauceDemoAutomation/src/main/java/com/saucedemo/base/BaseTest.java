package com.saucedemo.base;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.saucedemo.config.ConfigReader;
import com.saucedemo.logging.LogHelper;
import com.saucedemo.pages.BasePage;
import com.saucedemo.utils.PageObjectManager;

public class BaseTest {
	protected PageObjectManager pages;
	private static final Logger logger = LogHelper.getLogger(BaseTest.class);
	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		logger.info("========== Starting Test Class: " + this.getClass().getSimpleName() + " ==========");
        DriverManager.initDriver(browser);  // handled logging internally
        pages = new PageObjectManager();
	}

	@BeforeMethod
	public void getAppUrl() {
		String url=ConfigReader.getProperty("baseUrl");
		logger.info("Navigating to application URL: "+url);		
		DriverManager.getDriver().get(url);
	}

	@AfterMethod
	public void clearCookies() {
		logger.info("Clearing cookies and local storage after test method...");
		BasePage.clearCookiesAndStorage();
	}

	@AfterClass
	public void tearDown() {
		logger.info("Ending Test Class: " + this.getClass().getSimpleName());
        DriverManager.quitDriver();  // handled logging internally
        logger.info("==============================================================");
	}
}
