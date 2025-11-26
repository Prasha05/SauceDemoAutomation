package com.saucedemo.utils;

public class TestConstants {
	
	private TestConstants() {
	    throw new UnsupportedOperationException("Utility class");
	}

	public static class LoginError {
		public static final String INVALID_CREDENTIALS = "Epic sadface: Username and password do not match any user in this service";
		public static final String MISSING_USERNAME = "Epic sadface: Username is required";
		public static final String MISSING_PASSWORD = "Epic sadface: Password is required";
	}

	public static class PageTitle {
		public static final String PRODUCTS = "Products";
		public static final String CART = "Your Cart";
		public static final String CHECKOUT_USER_INFO = "Checkout: Your Information";
		public static final String CHECKOUT_OVERVIEW = "Checkout: Overview";
		public static final String CHECKOUT_COMPLETE = "Checkout: Complete!";
	}

	public static class AssertError {
		public static final String PAGE_TITLE_MISMATCH = "Page title mismatch.";
		public static final String ERR_MSG_MISMATCH = "Error message mismatch.";
		public static final String PRODUCTS_PAGE_ERR_MSG = "Products page is not displayed.";
		public static final String NO_PRODUCTS_ERR_MSG = "No Products found on the Page.";
		public static final String CART_ERR_MSG_ADD = "Cart count is not updated correctly after adding a product.";
		public static final String CART_ERR_MSG_REMOVE = "Cart count is not updated correctly after removing a product.";
		public static final String ORDER_CONFIRM_MSG_NOT_FOUND = "Order Confirmation Message not found.";
	}

	public static final String ORDER_CONFIRM_MSG = "Thank you for your order!";

	public static class ProductName {
		public static final String BACKPACK = "Sauce Labs Backpack";
		public static final String BIKE_LIGHT = "Sauce Labs Bike Light";
		public static final String BOLT_TSHIRT = "Sauce Labs Bolt T-Shirt";
		public static final String FLEECE_JACKET = "Sauce Labs Fleece Jacket";
		public static final String ONESIE = "Sauce Labs Onesie";
		public static final String TSHIRT_RED = "Test.allTheThings() T-Shirt (Red)";
	}

	public static class CartCount {
		public static final int NONE = 0;
		public static final int ONE = 1;
		public static final int TWO = 2;
		public static final int THREE = 3;
		public static final int FOUR = 4;
		public static final int FIVE = 5;
		public static final int SIX = 6;
	}

	public static class UserInfoError {
		public static final String FIRSTNAME = "Error: First Name is required";
		public static final String LASTNAME = "Error: Last Name is required";
		public static final String ZIP = "Error: Postal Code is required";
	}
}
