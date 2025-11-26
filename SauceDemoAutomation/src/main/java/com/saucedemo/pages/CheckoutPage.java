package com.saucedemo.pages;

import org.openqa.selenium.By;
import com.saucedemo.logging.LogHelper;
import org.apache.logging.log4j.Logger;

public class CheckoutPage extends BasePage {

	private static final Logger logger = LogHelper.getLogger(CheckoutPage.class);

	public CheckoutPage() {
		super();
	}

	private By firstNameField = By.id("first-name");
	private By lastNameField = By.id("last-name");
	private By zipCodeField = By.id("postal-code");
	private By continueButton = By.id("continue");
	private By cancelButton = By.id("cancel");
	private By error = By.xpath("//h3[@data-test='error']");
	private By pageTitle = By.xpath("//span[@class='title']");

	public void enterPersonalInfoThenClickContinue(String firstname, String lastname, String zip) {
		try {
			logger.info("Entering personal information: {}, {}, {}", firstname, lastname, zip);
			type(firstNameField, firstname);
			type(lastNameField, lastname);
			type(zipCodeField, zip);
			click(continueButton);
			logger.info("Clicked Continue button on Checkout Page successfully.");
		} catch (Exception e) {
			logger.error("Error while entering personal info or clicking Continue. Details: {}", e.getMessage());
			throw e;
		}
	}

	public String getCheckoutErrorMessage() {
		try {
			if (isDisplayed(error)) {
				String errorMessage = getElementText(error);
				logger.warn("Checkout error message displayed: {}", errorMessage);
				return errorMessage;
			} else {
				logger.info("No error message displayed on Checkout Page.");
				return null;
			}
		} catch (Exception e) {
			logger.error("Error while fetching checkout error message. Details: {}", e.getMessage());
			throw e;
		}
	}

	public void clickCancel() {
		try {
			logger.info("Clicking Cancel button on Checkout Page...");
			click(cancelButton);
			logger.info("Clicked Cancel button successfully.");
		} catch (Exception e) {
			logger.error("Error while clicking Cancel button. Details: {}", e.getMessage());
			throw e;
		}
	}
}
