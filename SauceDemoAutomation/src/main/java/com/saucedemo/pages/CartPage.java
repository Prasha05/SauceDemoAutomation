package com.saucedemo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.saucedemo.logging.LogHelper;
import com.saucedemo.utils.AssertUtils;

import org.apache.logging.log4j.Logger;

public class CartPage extends BasePage {

	private static final Logger logger = LogHelper.getLogger(CartPage.class);

	public CartPage() {
		super();
	}

	private By cartLink = By.xpath("//a[@data-test='shopping-cart-link']");
	private By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");
	private By cartPageTitle = By.xpath("//span[@class='title']");
	private By productTitle = By.xpath("//div[@data-test='inventory-item-name']");
	private By productDescription = By.xpath("//div[@data-test='inventory-item-desc']");
	private By productPrice = By.xpath("//div[@data-test='inventory-item-price']");
	private String remove = "//div[@class='cart_item'][.//div[text()='%s']]//button[text()='Remove']";
	private By continueShoppingButton = By.id("continue-shopping");
	private By checkOutButton = By.id("checkout");

	public String getCartPageTitle() {
		try {
			logger.info("Fetching Cart Page title...");
			String title = getElementText(cartPageTitle);
			logger.info("Cart Page Title: {}", title);
			return title;
		} catch (Exception e) {
			logger.error("Failed to fetch Cart Page title. Error: {}", e.getMessage());
			throw e;
		}
	}

	public void goToCartAndVerifySelectedProduct(List<String> expectedProductNames) {
		try {
			logger.info("Navigating to Cart and verifying selected products...");
			click(cartLink);
			List<WebElement> productElements = getElements(productTitle);
			List<String> actualProductNames = new ArrayList<>();
			for (WebElement product : productElements) {
				actualProductNames.add(product.getText().trim());
			}

			for (String expectedName : expectedProductNames) {
				AssertUtils.assertTrue(actualProductNames.contains(expectedName),
						"Cart does not contain expected product: " + expectedName);
				logger.info("Verified product present in cart: {}", expectedName);
			}
		} catch (Exception e) {
			logger.error("Failed to verify products in cart. Error: {}", e.getMessage());
			throw e;
		}
	}

	public void goToCartAndRemoveProductFromCart(String productName) {
		try {
			logger.info("Navigating to Cart to remove product: {}", productName);
			click(cartLink);
			By removeBtn = By.xpath(String.format(remove, productName));
			click(removeBtn);
			logger.info("Product removed successfully: {}", productName);
		} catch (Exception e) {
			logger.error("Failed to remove product '{}' from cart. Error: {}", productName, e.getMessage());
			throw e;
		}
	}

	public void goToCartAndClickCheckout() {
		try {
			logger.info("Navigating to Cart and clicking Checkout button...");
			click(cartLink);
			click(checkOutButton);
			logger.info("Clicked Checkout button successfully.");
		} catch (Exception e) {
			logger.error("Failed to click Checkout button. Error: {}", e.getMessage());
			throw e;
		}
	}

	public void goToCartThenContinueShopping() {
		try {
			logger.info("Navigating to Cart and clicking Continue Shopping...");
			click(cartLink);
			click(continueShoppingButton);
			logger.info("Clicked Continue Shopping button successfully.");
		} catch (Exception e) {
			logger.error("Failed to click Continue Shopping button. Error: {}", e.getMessage());
			throw e;
		}
	}

	public int getCartCount() {
		try {
			if (isDisplayed(cartBadge)) {
				String countText = getElementText(cartBadge).trim();
				int count = Integer.parseInt(countText);
				logger.info("Current cart count: {}", count);
				return count;
			} else {
				logger.info("Cart badge not visible — assuming cart is empty.");
				return 0;
			}
		} catch (Exception e) {
			logger.error("Failed to fetch cart count. Error: {}", e.getMessage());
			throw e;
		}
	}
}
