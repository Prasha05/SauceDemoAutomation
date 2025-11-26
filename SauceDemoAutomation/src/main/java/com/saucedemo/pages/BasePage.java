package com.saucedemo.pages;

import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.base.DriverManager;
import com.saucedemo.logging.LogHelper;

public class BasePage {

	protected WebDriver driver;
	private WebDriverWait wait;
	private static final Logger logger = LogHelper.getLogger(BasePage.class);

	public BasePage() {
		this.driver = DriverManager.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Waits for visibility of an element
	protected WebElement waitForVisibility(By locator) {
		logger.debug("Waiting for visibility of element: " + locator);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Clicks on an element
	protected void click(By locator) {
		try {
			WebElement element = waitForVisibility(locator);
			element.click();
			logger.info("Clicked on element: " + locator);
		} catch (Exception e) {
			logger.error("Failed to click on element: " + locator + " | Exception: " + e.getMessage());
			throw e;
		}
	}

	// Types text into an input field
	protected void type(By locator, String text) {
		try {
			WebElement element = waitForVisibility(locator);
			element.clear();
			element.sendKeys(text);
			logger.info("Entered text '" + text + "' into element: " + locator);
		} catch (Exception e) {
			logger.error("Failed to type text into element: " + locator + " | Exception: " + e.getMessage());
			throw e;
		}
	}

	// Gets visible text from element
	protected String getElementText(By locator) {
		String text = "";
		try {
			text = waitForVisibility(locator).getText();
			logger.debug("Fetched text from element: " + locator + " | Text: " + text);
		} catch (Exception e) {
			logger.error("Failed to fetch text from element: " + locator + " | Exception: " + e.getMessage());
			throw e;
		}
		return text;
	}

	// Returns list of elements
	protected List<WebElement> getElements(By locator) {
		try {
			waitForVisibility(locator);
			logger.debug("Fetching list of elements: " + locator);
			return driver.findElements(locator);
		} catch (Exception e) {
			logger.error("Failed to fetch elements list: " + locator + " | Exception: " + e.getMessage());
			throw e;
		}
	}

	// Checks if element is displayed
	protected boolean isDisplayed(By locator) {
		try {
			boolean visible = waitForVisibility(locator).isDisplayed();
			logger.debug("Element displayed: " + locator + " | Result: " + visible);
			return visible;
		} catch (Exception e) {
			logger.warn("Element not displayed or not found: " + locator);
			return false;
		}
	}

	// Clears cookies and storage
	public static void clearCookiesAndStorage() {
		try {
			LogHelper.getLogger(BasePage.class).info("Clearing browser cookies, local storage, and session storage.");
			DriverManager.getDriver().manage().deleteAllCookies();
			JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
			js.executeScript("window.localStorage.clear();");
			js.executeScript("window.sessionStorage.clear();");
			LogHelper.getLogger(BasePage.class).info("Successfully cleared browser data.");
		} catch (Exception e) {
			LogHelper.getLogger(BasePage.class).error("Failed to clear browser data. Exception: " + e.getMessage());
		}
	}
}
