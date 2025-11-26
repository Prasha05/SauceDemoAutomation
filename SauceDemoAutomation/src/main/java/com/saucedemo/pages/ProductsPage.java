package com.saucedemo.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.saucedemo.base.DriverManager;
import org.apache.logging.log4j.Logger;
import com.saucedemo.logging.LogHelper;

public class ProductsPage extends BasePage {

    private static final Logger logger = LogHelper.getLogger(ProductsPage.class);

    public ProductsPage() {}

    private By productsPageTitle = By.xpath("//span[@class='title']");
    private By productItems = By.xpath("//div[@class='inventory_item']");
    private By productNames = By.xpath("//div[@class='inventory_item_name ']");
    private By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");

    private String addToCart = "//div[@class='inventory_item'][.//div[text()='%s']]//button[text()='Add to cart']";
    private String remove = "//div[@class='inventory_item'][.//div[text()='%s']]//button[text()='Remove']";
    private String product = "//div[@class='inventory_item_name ' and text()='%s']";

    public String getProductsPageTitle() {
        try {
            String title = getElementText(productsPageTitle);
            logger.info("Products page title retrieved: {}", title);
            return title;
        } catch (Exception e) {
            logger.error("Failed to get Products page title. Details: {}", e.getMessage());
            throw e;
        }
    }

    public int getProductCount() {
        try {
            int count = DriverManager.getDriver().findElements(productItems).size();
            logger.info("Total products displayed on page: {}", count);
            return count;
        } catch (Exception e) {
            logger.error("Error getting product count. Details: {}", e.getMessage());
            throw e;
        }
    }

    public List<String> getAllProductNames() {
        try {
            List<WebElement> nameElements = driver.findElements(productNames);
            List<String> names = nameElements.stream()
                                             .map(WebElement::getText)
                                             .collect(Collectors.toList());
            logger.info("Fetched all product names: {}", names);
            return names;
        } catch (Exception e) {
            logger.error("Error fetching all product names. Details: {}", e.getMessage());
            throw e;
        }
    }

    public void addProductToCart(String productName) {
        try {
            By addToCartBtn = By.xpath(String.format(addToCart, productName));
            click(addToCartBtn);
            logger.info("Added product '{}' to cart successfully.", productName);
        } catch (Exception e) {
            logger.error("Failed to add product '{}' to cart. Details: {}", productName, e.getMessage());
            throw e;
        }
    }

    public void removeProductFromCart(String productName) {
        try {
            By removeBtn = By.xpath(String.format(remove, productName));
            click(removeBtn);
            logger.info("Removed product '{}' from cart successfully.", productName);
        } catch (Exception e) {
            logger.error("Failed to remove product '{}' from cart. Details: {}", productName, e.getMessage());
            throw e;
        }
    }

    public void clickOnProduct(String productName) {
        try {
            By productLink = By.xpath(String.format(product, productName));
            click(productLink);
            logger.info("Opened product details page for '{}'.", productName);
        } catch (Exception e) {
            logger.error("Failed to click on product '{}'. Details: {}", productName, e.getMessage());
            throw e;
        }
    }

    public int getCartCount() {
        try {
            if (isDisplayed(cartBadge)) {
                String countText = getElementText(cartBadge);
                int count = Integer.parseInt(countText);
                logger.info("Cart item count: {}", count);
                return count;
            } else {
                logger.info("Cart badge not displayed. Assuming count is 0.");
                return 0;
            }
        } catch (Exception e) {
            logger.error("Error retrieving cart count. Details: {}", e.getMessage());
            throw e;
        }
    }
}

//List<String> names = new ArrayList<>();
//for (WebElement element : nameElements) {
//    names.add(element.getText());
//}