# E-Commerce Automation Framework

Selenium WebDriver automation framework for the SauceDemo e-commerce application using Java, TestNG and Maven.

## Tech Stack

- Java 17
- Selenium WebDriver
- TestNG
- Maven
- Chrome
- ExtentReports
- IntelliJ IDEA

## Test Coverage

| Module | Test Cases |
|---|---:|
| Login | 6 |
| Products | 3 |
| Cart | 3 |
| Checkout | 4 |
| **Total** | **16** |

### Login
- Valid login
- Invalid username
- Invalid password
- Empty username
- Empty password
- Locked user

### Products
- Verify Products page
- Add one product to cart
- Add multiple products to cart

### Cart
- Verify product in cart
- Remove product from cart
- Verify multiple products in cart

### Checkout
- Successful checkout
- Empty first name validation
- Empty last name validation
- Empty postal code validation

## Framework Structure

```text
ECommerceAutomation
├── pom.xml
├── testng.xml
├── README.md
├── reports/
│   ├── ExtentReport.html
│   ├── RTM_ECommerceAutomation.xlsx
│   ├── Test_Summary_Report.docx
│   └── Defect_Summary_Report.docx
├── screenshots/
├── src/
│   ├── main/java/
│   │   ├── pages/
│   │   ├── reports/
│   │   └── utils/
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   ├── listeners/
│       │   ├── tests/
│       │   └── testsupport/
│       └── resources/
│           └── config.properties
└── target/
```

## Design

The framework follows the Page Object Model (POM).

- **BaseTest** – WebDriver setup and teardown
- **Page classes** – UI locators and reusable page actions
- **Test classes** – Functional test scenarios and assertions
- **TestListener** – TestNG execution and failure handling
- **ExtentManager** – ExtentReports configuration
- **ScreenshotUtils** – Failure screenshot capture
- **ConfigReader** – Reads test configuration
- **testng.xml** – Test suite configuration

## Reporting

The framework generates an ExtentReports HTML report containing:

- Test execution status
- Test timestamps
- Environment information
- Passed/failed test details
- Failure exception details
- Failure screenshots

Additional QA artifacts are maintained in the `reports/` directory:

- Requirement Traceability Matrix (RTM)
- Test Summary Report
- Defect Summary Report

## Run the Tests

From the project root:

```bash
mvn clean test "-Dsurefire.suiteXmlFiles=testng.xml"
```

Or run the TestNG suite directly from IntelliJ IDEA.

## Configuration

Test configuration is stored in:

```text
src/test/resources/config.properties
```

Do not commit real credentials or secrets. For portfolio/demo use, keep only non-sensitive test configuration.

## Test Evidence

ExtentReports:

```text
reports/ExtentReport.html
```

Screenshots captured for failed tests:

```text
screenshots/failed/
```

## Notes

A temporary intentional-failure test was used during framework development to verify failure screenshot and ExtentReports handling. It should not be included in the final functional suite.

The final functional suite contains 16 automated test cases.
