package com.saucedemo.tests;

import java.util.List;

import org.testng.annotations.Test;

import com.saucedemo.base.BaseTest;
import com.saucedemo.config.ConfigReader;
import com.saucedemo.utils.AssertUtils;
import com.saucedemo.utils.TestConstants;

public class ProductTests extends BaseTest {
	@Test(priority = 1)
	public void verifyProductListingAfterLogin() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		AssertUtils.assertEquals(pages.getProductsPage().getProductsPageTitle(), TestConstants.PageTitle.PRODUCTS,
				TestConstants.AssertError.PRODUCTS_PAGE_ERR_MSG);
		int count = pages.getProductsPage().getProductCount();
		AssertUtils.assertTrue(count > TestConstants.CartCount.NONE, TestConstants.AssertError.NO_PRODUCTS_ERR_MSG);
		List<String> names = pages.getProductsPage().getAllProductNames();
		System.out.println("Product names: " + names);
	}

	@Test(priority = 2)
	public void verifyAddToCart() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.BACKPACK);
		AssertUtils.assertEquals(pages.getProductsPage().getCartCount(), TestConstants.CartCount.ONE,
				TestConstants.AssertError.CART_ERR_MSG_ADD);
	}

	@Test(priority = 3)
	public void addMultipleProductToCart() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.BOLT_TSHIRT);
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.BIKE_LIGHT);
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.FLEECE_JACKET);
		AssertUtils.assertEquals(pages.getProductsPage().getCartCount(), TestConstants.CartCount.THREE,
				TestConstants.AssertError.CART_ERR_MSG_ADD);
	}

	@Test(priority = 4)
	public void removeProductFromCart() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.BACKPACK);
		pages.getProductsPage().removeProductFromCart(TestConstants.ProductName.BACKPACK);
		AssertUtils.assertEquals(pages.getProductsPage().getCartCount(), TestConstants.CartCount.NONE,
				TestConstants.AssertError.CART_ERR_MSG_REMOVE);
	}

	@Test(priority = 5)
	public void viewProductDetails() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getProductsPage().clickOnProduct(TestConstants.ProductName.ONESIE);
		pages.getProductDetailPage().verifyProductDetails(TestConstants.ProductName.ONESIE);
	}

	@Test(priority = 6)
	public void navigateBackFromProductDetails() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getProductsPage().clickOnProduct(TestConstants.ProductName.BACKPACK);
		pages.getProductDetailPage().clickBackToProducts();
		AssertUtils.assertEquals(pages.getProductsPage().getProductsPageTitle(), TestConstants.PageTitle.PRODUCTS,
				TestConstants.AssertError.PRODUCTS_PAGE_ERR_MSG);
	}
}
