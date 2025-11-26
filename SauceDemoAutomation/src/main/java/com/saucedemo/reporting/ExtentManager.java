package com.saucedemo.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;

	private ExtentManager() {

	}

	public static ExtentReports getInstance() {
		if (extent == null) {
			String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
			sparkReporter.config().setReportName("SauceDemo Automation Report");
			sparkReporter.config().setDocumentTitle("Functional Test Results");
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Project", "SauceDemo");
			extent.setSystemInfo("Tester", "Prasanth Thanikachalam");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Java Version", System.getProperty("java.version"));

		}
		return extent;
	}
}
