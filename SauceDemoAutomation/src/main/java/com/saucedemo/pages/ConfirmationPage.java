package com.saucedemo.pages;

import org.openqa.selenium.By;
import com.saucedemo.logging.LogHelper;
import org.apache.logging.log4j.Logger;

public class ConfirmationPage extends BasePage {

	private static final Logger logger = LogHelper.getLogger(ConfirmationPage.class);

	private By orderConfirmation = By.xpath("//h2[text()='Thank you for your order!']");

	public String getOrderConfirmationMessage() {
		try {
			logger.info("Fetching order confirmation message...");
			String confirmationText = getElementText(orderConfirmation);
			logger.info("Order confirmation message retrieved successfully: {}", confirmationText);
			return confirmationText;
		} catch (Exception e) {
			logger.error("Error while fetching order confirmation message. Details: {}", e.getMessage());
			throw e;
		}
	}
}
