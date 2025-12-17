# SauceDemo Automation Framework

## Overview

This project is an end-to-end **test automation framework** built for the **SauceDemo (Swag Labs)** application. It is designed to demonstrate **real‑world automation testing practices** using **Java, Selenium WebDriver, TestNG, and Maven**, following a clean **Page Object Model (POM)** architecture. The framework also integrates **Extent Reports** for rich HTML reporting and **Log4j 2** for structured logging, with support for **parallel and cross‑browser execution**.

This project is created as a **portfolio-ready automation framework**, suitable for interviews and real project demonstrations.

---

## Key Features

* ✅ **Selenium WebDriver** – Browser automation
* ✅ **Java (OOP‑driven design)** – Maintainable and scalable code
* ✅ **TestNG** – Test execution, grouping, assertions, and parallel runs
* ✅ **Maven** – Dependency management and build automation
* ✅ **Page Object Model (POM)** – Clear separation of test logic and UI actions
* ✅ **ThreadLocal WebDriver** – Safe parallel execution
* ✅ **Extent Reports** – Interactive HTML reports with test status
* ✅ **Log4j 2** – Centralized logging across framework layers
* ✅ **WebDriverManager** – Automatic driver management
* ✅ **Cross‑Browser Testing** – Chrome & Firefox

---

## 📁 Project Structure

```
SauceDemoAutomation/
│
├── src/main/java/
│   └── com/saucedemo/
│       ├── base/              # BaseTest, DriverManager
│       ├── config/            # ConfigReader
│       ├── pages/             # Page Object classes
│       ├── reporting/         # Extent report listeners & managers
│       └── utils/             # Assertion utils, helpers
│
├── src/main/resources/
│   ├── config.properties      # Application & execution config
│   └── log4j2.xml              # Log4j configuration
│
├── src/test/java/
│   └── com/saucedemo/tests/    # TestNG test classes
│
├── testng.xml                  # Parallel & cross‑browser execution
├── pom.xml                     # Maven configuration
└── README.md
```

---

## Prerequisites

* **Java**: 17 or higher
* **Maven**: 3.8+
* **Eclipse / IntelliJ IDEA**
* **TestNG Plugin** (IDE)

> Browsers are handled automatically via **WebDriverManager**.

---

## Configuration

Update `config.properties`:

```
baseUrl=https://www.saucedemo.com/
browser=chrome
```

Browser can also be overridden via **TestNG XML parameters**.

---

## Test Execution

### Run via Maven

```
mvn clean test
```

### Run via TestNG

* Right‑click `testng.xml`
* Run as **TestNG Suite**

Parallel execution is enabled at:

* Test level
* Class level

---

## Reporting

### Extent Reports

* 📄 `test-output/ExtentReport.html`
* Includes:

  * Test steps
  * Pass / Fail / Skip status
  * Execution time

### TestNG Default Reports

* 📄 `test-output/index.html`

---

## Logging

* Implemented using **Log4j 2**
* Logs are generated at framework and page levels
* File‑based logging enabled

Example log usage:

```
INFO  Navigating to application URL
INFO  Clicking on Add to Cart button
ERROR Element not found
```

---

## Framework Highlights

* Centralized driver management using **ThreadLocal**
* Reusable BasePage methods
* Assertion abstraction via `AssertUtils`
* Clean separation of responsibilities
* Portfolio‑grade structure and naming

---

## Future Enhancements

* ✏️ API automation integration (REST Assured)
* 🔁 Retry analyzer for flaky tests
* 📊 Allure report integration
* 🚀 CI/CD pipeline (Jenkins / GitHub Actions)
* 🔐 Data‑driven testing support

---

## Author

**Prasanth Thanikachalam**
Automation Test Engineer | Selenium | Java | TestNG

🔗 LinkedIn: [https://www.linkedin.com/in/prasanth-thanikachalam](https://www.linkedin.com/in/prasanth-thanikachalam)

---

> ⚠️ This project is built as a **self‑learning and interview‑ready portfolio framework**, reflecting real‑time automation best practices used in industry.
