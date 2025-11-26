package com.saucedemo.utils;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.saucedemo.logging.LogHelper;

public class AssertUtils {
	private static final Logger logger = LogHelper.getLogger(AssertUtils.class);

	private AssertUtils() {
	}

	public static void assertEquals(String actual, String expected, String message) {
		try {
			Assert.assertEquals(actual, expected, message);
			logger.info("[PASS] " + message + " | Expected: " + expected + " | Actual: " + actual);
		} catch (AssertionError e) {
			logger.error("[FAIL] " + message + " | Expected: " + expected + " | Actual: " + actual);
			throw e;
		}
	}

	public static void assertEquals(int actual, int expected, String message) {
		try {
			Assert.assertEquals(actual, expected, message);
			logger.info("[PASS] " + message + " | Expected: " + expected + " | Actual: " + actual);
		} catch (AssertionError e) {
			logger.error("[FAIL] " + message + " | Expected: " + expected + " | Actual: " + actual);
			throw e;
		}
	}

	public static void assertTrue(boolean condition, String message) {
		try {
			Assert.assertTrue(condition, message);
			logger.info("[PASS] " + message);
		} catch (AssertionError e) {
			logger.error("[FAIL] " + message + " | Condition evaluated to false.");
			throw e;
		}
	}
}
