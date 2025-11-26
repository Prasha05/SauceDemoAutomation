package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.apache.logging.log4j.Logger;
import com.saucedemo.logging.LogHelper;

public class LoginPage extends BasePage {

    private static final Logger logger = LogHelper.getLogger(LoginPage.class);

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//h3[@data-test='error']");

    public LoginPage() {}

    public void enterUsername(String userName) {
        try {
            logger.info("Entering username: {}", userName);
            type(userNameField, userName);
        } catch (Exception e) {
            logger.error("Error entering username. Details: {}", e.getMessage());
            throw e;
        }
    }

    public void enterPassword(String password) {
        try {
            logger.info("Entering password");
            type(passwordField, password);
        } catch (Exception e) {
            logger.error("Error entering password. Details: {}", e.getMessage());
            throw e;
        }
    }

    public void clickLoginButton() {
        try {
            logger.info("Clicking on Login button...");
            click(loginButton);
        } catch (Exception e) {
            logger.error("Error clicking login button. Details: {}", e.getMessage());
            throw e;
        }
    }

    public Boolean isLoginButtonVisible() {
        try {
            boolean visible = isDisplayed(loginButton);
            logger.info("Login button visible: {}", visible);
            return visible;
        } catch (Exception e) {
            logger.error("Error checking Login button visibility. Details: {}", e.getMessage());
            throw e;
        }
    }

    public void login(String username, String password) {
        try {
            logger.info("Attempting login with username: {}", username);
            enterUsername(username);
            enterPassword(password);
            clickLoginButton();
            logger.info("Login attempted for user: {}", username);
        } catch (Exception e) {
            logger.error("Error during login attempt. Details: {}", e.getMessage());
            throw e;
        }
    }

    public String getErrorMessage() {
        try {
            String errorText = getElementText(errorMessage);
            logger.warn("Login error displayed: {}", errorText);
            return errorText;
        } catch (Exception e) {
            logger.error("Error fetching login error message. Details: {}", e.getMessage());
            throw e;
        }
    }
}
