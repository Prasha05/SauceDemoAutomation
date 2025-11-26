package com.saucedemo.reporting;

import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    private static final Map<Long, ExtentTest> testMap = new HashMap<>();

    private ExtentTestManager() {}

    public static synchronized void startTest(String testName) {
        ExtentTest test = ExtentManager.getInstance().createTest(testName);
        testMap.put(Thread.currentThread().getId(), test);
    }

    public static synchronized ExtentTest getTest() {
        return testMap.get(Thread.currentThread().getId());
    }

    public static synchronized void endTest() {
        ExtentManager.getInstance().flush();
    }
}
