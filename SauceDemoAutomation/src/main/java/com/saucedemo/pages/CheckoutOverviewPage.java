package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.apache.logging.log4j.Logger;
import com.saucedemo.logging.LogHelper;

public class CheckoutOverviewPage extends BasePage {

	private static final Logger logger = LogHelper.getLogger(CheckoutOverviewPage.class);

	public CheckoutOverviewPage() {
		super();
	}

	private By checkoutOverviewPageTitle = By.xpath("//span[text()='Checkout: Overview']");
	private By finishButton = By.id("finish");
	private By cancelButton = By.id("cancel");

	public String getCheckoutOverviewPageTitle() {
		try {
			logger.info("Fetching Checkout Overview page title...");
			String title = getElementText(checkoutOverviewPageTitle);
			logger.info("Checkout Overview Page Title: {}", title);
			return title;
		} catch (Exception e) {
			logger.error("Failed to fetch Checkout Overview Page title. Error: {}", e.getMessage());
			throw e;
		}
	}

	public void clickFinish() {
		try {
			logger.info("Clicking Finish button on Checkout Overview page...");
			click(finishButton);
			logger.info("Clicked Finish button successfully.");
		} catch (Exception e) {
			logger.error("Failed to click Finish button. Error: {}", e.getMessage());
			throw e;
		}
	}

	public void clickCancel() {
		try {
			logger.info("Clicking Cancel button on Checkout Overview page...");
			click(cancelButton);
			logger.info("Clicked Cancel button successfully.");
		} catch (Exception e) {
			logger.error("Failed to click Cancel button. Error: {}", e.getMessage());
			throw e;
		}
	}
}
