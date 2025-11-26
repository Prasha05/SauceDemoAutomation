package com.saucedemo.tests;

import org.testng.annotations.Test;

import com.saucedemo.base.BaseTest;
import com.saucedemo.config.ConfigReader;
import com.saucedemo.utils.AssertUtils;
import com.saucedemo.utils.TestConstants;

public class CheckoutTests extends BaseTest {
	@Test(priority = 1)
	public void verifyCheckoutWithValidDetails() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.BIKE_LIGHT);
		pages.getCartPage().goToCartAndClickCheckout();
		pages.getCheckoutPage().enterPersonalInfoThenClickContinue("John", "Doe", "12345");
		AssertUtils.assertEquals(pages.getCheckoutOverviewPage().getCheckoutOverviewPageTitle(),
				TestConstants.PageTitle.CHECKOUT_OVERVIEW, TestConstants.AssertError.PAGE_TITLE_MISMATCH);
	}

	@Test(priority = 2)
	public void verifyCheckoutWithMissingFirstname() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.BIKE_LIGHT);
		pages.getCartPage().goToCartAndClickCheckout();
		pages.getCheckoutPage().enterPersonalInfoThenClickContinue("", "Doe", "12345");
		AssertUtils.assertEquals(pages.getCheckoutPage().getCheckoutErrorMessage(),
				TestConstants.UserInfoError.FIRSTNAME, TestConstants.AssertError.ERR_MSG_MISMATCH);
	}

	@Test(priority = 3)
	public void verifyCheckoutWithMissingZipcode() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.BIKE_LIGHT);
		pages.getCartPage().goToCartAndClickCheckout();
		pages.getCheckoutPage().enterPersonalInfoThenClickContinue("John", "Doe", "");
		AssertUtils.assertEquals(pages.getCheckoutPage().getCheckoutErrorMessage(), TestConstants.UserInfoError.ZIP,
				TestConstants.AssertError.ERR_MSG_MISMATCH);
	}

	@Test(priority = 4)
	public void verifyCancelCheckoutFromInfoPage() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.BIKE_LIGHT);
		pages.getCartPage().goToCartAndClickCheckout();
		pages.getCheckoutPage().clickCancel();
		AssertUtils.assertEquals(pages.getCartPage().getCartPageTitle(), TestConstants.PageTitle.CART,
				TestConstants.AssertError.PAGE_TITLE_MISMATCH);
	}

	@Test(priority = 5)
	public void verifyCompletePurchase() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getProductsPage().addProductToCart(TestConstants.ProductName.TSHIRT_RED);
		pages.getCartPage().goToCartAndClickCheckout();
		pages.getCheckoutPage().enterPersonalInfoThenClickContinue("Divya", "Divine", "10453");
		pages.getCheckoutOverviewPage().clickFinish();
		AssertUtils.assertEquals(pages.getConfirmationPage().getOrderConfirmationMessage(),
				TestConstants.ORDER_CONFIRM_MSG, TestConstants.AssertError.ORDER_CONFIRM_MSG_NOT_FOUND);
	}
}
