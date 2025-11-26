package com.saucedemo.utils;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutOverviewPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.ConfirmationPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductDetailPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.pages.SideMenuPage;

public class PageObjectManager {
	private LoginPage loginPage;
	private ProductsPage productsPage;
	private ProductDetailPage productDetailPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	private CheckoutOverviewPage checkoutOverviewPage;
	private ConfirmationPage confirmationPage;
	private SideMenuPage sideMenuPage;

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}

	public ProductsPage getProductsPage() {
		if (productsPage == null) {
			productsPage = new ProductsPage();
		}
		return productsPage;
	}

	public ProductDetailPage getProductDetailPage() {
		if (productDetailPage == null) {
			productDetailPage = new ProductDetailPage();
		}
		return productDetailPage;
	}

	public CartPage getCartPage() {
		if (cartPage == null) {
			cartPage = new CartPage();
		}
		return cartPage;
	}

	public CheckoutPage getCheckoutPage() {
		if (checkoutPage == null) {
			checkoutPage = new CheckoutPage();
		}
		return checkoutPage;
	}

	public CheckoutOverviewPage getCheckoutOverviewPage() {
		if (checkoutOverviewPage == null) {
			checkoutOverviewPage = new CheckoutOverviewPage();
		}
		return checkoutOverviewPage;
	}

	public ConfirmationPage getConfirmationPage() {
		if (confirmationPage == null) {
			confirmationPage = new ConfirmationPage();
		}
		return confirmationPage;
	}

	public SideMenuPage getSideMenuPage() {
		if(sideMenuPage==null) {
			sideMenuPage=new SideMenuPage();
		}
		return sideMenuPage;
	}
}
