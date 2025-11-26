package com.saucedemo.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.saucedemo.base.BaseTest;
import com.saucedemo.config.ConfigReader;
import com.saucedemo.utils.AssertUtils;
import com.saucedemo.utils.TestConstants;

public class CartTests extends BaseTest {
	@Test(priority = 1)
	public void verifyCartItems() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.BACKPACK);
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.BIKE_LIGHT);
		List<String> expectedProducts = Arrays.asList(TestConstants.ProductName.BACKPACK, TestConstants.ProductName.BIKE_LIGHT);
		pages.getCartPage().goToCartAndVerifySelectedProduct(expectedProducts);
	}

	@Test(priority = 2)
	public void removeItemFromCartPage() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.BIKE_LIGHT);
		pages.getCartPage().goToCartAndRemoveProductFromCart(TestConstants.ProductName.BIKE_LIGHT);
		AssertUtils.assertEquals(pages.getCartPage().getCartCount(), 0, TestConstants.AssertError.CART_ERR_MSG_REMOVE);
	}

	@Test(priority = 3)
	public void continueShoppingFromCart() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getCartPage().goToCartThenContinueShopping();
		AssertUtils.assertEquals(pages.getProductsPage().getProductsPageTitle(), TestConstants.PageTitle.PRODUCTS,
				TestConstants.AssertError.PRODUCTS_PAGE_ERR_MSG);
	}
}
