package com.saucedemo.tests;

import org.testng.annotations.Test;

import com.saucedemo.base.BaseTest;
import com.saucedemo.config.ConfigReader;
import com.saucedemo.utils.AssertUtils;

public class LogoutTest extends BaseTest {
	@Test(priority = 20)
	public void verifyLogout() {
		pages.getLoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		pages.getSideMenuPage().logout();
		AssertUtils.assertTrue(pages.getLoginPage().isLoginButtonVisible(), "Login button is not visible");
	}
}
