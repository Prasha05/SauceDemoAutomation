package com.saucedemo.tests;

import org.testng.annotations.Test;

import com.saucedemo.base.BaseTest;
import com.saucedemo.config.ConfigReader;
import com.saucedemo.utils.AssertUtils;
import com.saucedemo.utils.TestConstants;

public class LoginTests extends BaseTest {
	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		AssertUtils.assertEquals(pages.getProductsPage().getProductsPageTitle(), TestConstants.PageTitle.PRODUCTS,
				TestConstants.AssertError.PRODUCTS_PAGE_ERR_MSG);
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		pages.getLoginPage().login("invalid_user", "wrong_pass");
		AssertUtils.assertEquals(pages.getLoginPage().getErrorMessage(), TestConstants.LoginError.INVALID_CREDENTIALS,
				TestConstants.AssertError.ERR_MSG_MISMATCH);
	}

	@Test(priority = 3)
	public void verifyLoginWithEmptyUsername() {
		pages.getLoginPage().login("", ConfigReader.getProperty("password"));
		AssertUtils.assertEquals(pages.getLoginPage().getErrorMessage(), TestConstants.LoginError.MISSING_USERNAME,
				TestConstants.AssertError.ERR_MSG_MISMATCH);
	}

	@Test(priority = 4)
	public void verifyLoginWithEmptyPassword() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), "");
		AssertUtils.assertEquals(pages.getLoginPage().getErrorMessage(), TestConstants.LoginError.MISSING_PASSWORD,
				TestConstants.AssertError.ERR_MSG_MISMATCH);
	}

	@Test(priority = 5)
	public void verifyLoginWithBothFieldsEmpty() {
		pages.getLoginPage().login("", "");
		AssertUtils.assertEquals(pages.getLoginPage().getErrorMessage(), TestConstants.LoginError.MISSING_USERNAME,
				TestConstants.AssertError.ERR_MSG_MISMATCH);
	}
}
