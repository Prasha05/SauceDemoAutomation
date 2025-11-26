package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.apache.logging.log4j.Logger;
import com.saucedemo.logging.LogHelper;

public class SideMenuPage extends BasePage {

    private static final Logger logger = LogHelper.getLogger(SideMenuPage.class);

    public SideMenuPage() {}

    private By burgerMenuButton = By.id("react-burger-menu-btn");
    private By allItemsLink = By.id("inventory_sidebar_link");
    private By aboutLink = By.id("about_sidebar_link");
    private By logoutLink = By.id("logout_sidebar_link");
    private By resetAppStore = By.id("reset_sidebar_link");

    public void openMenu() {
        try {
            logger.info("Clicking on Burger Menu button to open side menu.");
            click(burgerMenuButton);
        } catch (Exception e) {
            logger.error("Failed to open side menu. Details: {}", e.getMessage());
            throw e;
        }
    }

    public void clickAllItems() {
        try {
            logger.info("Clicking 'All Items' link from side menu.");
            click(allItemsLink);
        } catch (Exception e) {
            logger.error("Failed to click 'All Items' link. Details: {}", e.getMessage());
            throw e;
        }
    }

    public void clickAbout() {
        try {
            logger.info("Clicking 'About' link from side menu.");
            click(aboutLink);
        } catch (Exception e) {
            logger.error("Failed to click 'About' link. Details: {}", e.getMessage());
            throw e;
        }
    }

    public void clickResetAppState() {
        try {
            logger.info("Clicking 'Reset App State' option from side menu.");
            click(resetAppStore);
        } catch (Exception e) {
            logger.error("Failed to reset app state. Details: {}", e.getMessage());
            throw e;
        }
    }

    public void logout() {
        try {
            logger.info("Attempting to logout via side menu.");
            click(burgerMenuButton);
            click(logoutLink);
            logger.info("Logout completed successfully.");
        } catch (Exception e) {
            logger.error("Logout failed. Details: {}", e.getMessage());
            throw e;
        }
    }
}
