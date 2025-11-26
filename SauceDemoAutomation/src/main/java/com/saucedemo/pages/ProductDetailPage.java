package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.saucedemo.utils.AssertUtils;
import org.apache.logging.log4j.Logger;
import com.saucedemo.logging.LogHelper;

public class ProductDetailPage extends BasePage {

    private static final Logger logger = LogHelper.getLogger(ProductDetailPage.class);

    public ProductDetailPage() {}

    private By productTitle = By.xpath("//div[@data-test='inventory-item-name']");
    private By productDescription = By.xpath("//div[@data-test='inventory-item-desc']");
    private By productPrice = By.xpath("//div[@data-test='inventory-item-price']");
    private By addToCartButton = By.xpath("//button[text()='Add to cart']");
    private By removeButton = By.xpath("//button[text()='Remove']");
    private By backToProductsButton = By.id("back-to-products");

    public String getProductName() {
        try {
            String name = getElementText(productTitle);
            logger.info("Product name retrieved: {}", name);
            return name;
        } catch (Exception e) {
            logger.error("Error getting product name. Details: {}", e.getMessage());
            throw e;
        }
    }

    public String getProductDescription() {
        try {
            String desc = getElementText(productDescription);
            logger.info("Product description retrieved: {}", desc);
            return desc;
        } catch (Exception e) {
            logger.error("Error getting product description. Details: {}", e.getMessage());
            throw e;
        }
    }

    public String getProductPrice() {
        try {
            String price = getElementText(productPrice);
            logger.info("Product price retrieved: {}", price);
            return price;
        } catch (Exception e) {
            logger.error("Error getting product price. Details: {}", e.getMessage());
            throw e;
        }
    }

    public boolean isAddToCartButtonDisplayed() {
        try {
            boolean visible = isDisplayed(addToCartButton);
            logger.info("'Add to Cart' button visible: {}", visible);
            return visible;
        } catch (Exception e) {
            logger.error("Error checking Add to Cart button visibility. Details: {}", e.getMessage());
            throw e;
        }
    }

    public boolean isRemoveButtonDisplayed() {
        try {
            boolean visible = isDisplayed(removeButton);
            logger.info("'Remove' button visible: {}", visible);
            return visible;
        } catch (Exception e) {
            logger.error("Error checking Remove button visibility. Details: {}", e.getMessage());
            throw e;
        }
    }

    public boolean isBackToProductsButtonDisplayed() {
        try {
            boolean visible = isDisplayed(backToProductsButton);
            logger.info("'Back to Products' button visible: {}", visible);
            return visible;
        } catch (Exception e) {
            logger.error("Error checking Back to Products button visibility. Details: {}", e.getMessage());
            throw e;
        }
    }

    public void verifyProductDetails(String expectedName) {
        try {
            logger.info("Verifying product details for: {}", expectedName);
            String actualName = getProductName();
            String description = getProductDescription();
            String price = getProductPrice();

            AssertUtils.assertEquals(actualName, expectedName, "Product Name does not match");
            Assert.assertFalse(description.isEmpty(), "Product Description is Empty");
            AssertUtils.assertTrue(price != null && price.startsWith("$"), "Price format is invalid: " + price);

            boolean isAddToCartVisible = isAddToCartButtonDisplayed();
            boolean isRemoveVisible = isRemoveButtonDisplayed();

            AssertUtils.assertTrue(isAddToCartVisible || isRemoveVisible,
                    "Neither Add to Cart nor Remove button is displayed");
            AssertUtils.assertTrue(isBackToProductsButtonDisplayed(), "'Back to Products' button is not displayed.");

            logger.info("Product details verified successfully for: {}", expectedName);
        } catch (Exception e) {
            logger.error("Error verifying product details for '{}'. Details: {}", expectedName, e.getMessage());
            throw e;
        }
    }

    public void clickAddToCart() {
        try {
            logger.info("Clicking 'Add to Cart' button");
            click(addToCartButton);
        } catch (Exception e) {
            logger.error("Error clicking Add to Cart button. Details: {}", e.getMessage());
            throw e;
        }
    }

    public void clickRemoveFromCart() {
        try {
            logger.info("Clicking 'Remove' button");
            click(removeButton);
        } catch (Exception e) {
            logger.error("Error clicking Remove button. Details: {}", e.getMessage());
            throw e;
        }
    }

    public void clickBackToProducts() {
        try {
            logger.info("Clicking 'Back to Products' button");
            click(backToProductsButton);
        } catch (Exception e) {
            logger.error("Error clicking Back to Products button. Details: {}", e.getMessage());
            throw e;
        }
    }
}
