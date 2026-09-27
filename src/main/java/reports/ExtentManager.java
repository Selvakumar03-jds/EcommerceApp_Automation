package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(
                            "reports/ExtentReport.html"
                    );

            reporter.config()
                    .setReportName(
                            "E-Commerce Automation Test Report"
                    );

            reporter.config()
                    .setDocumentTitle(
                            "Automation Test Execution Report"
                    );

            extent =
                    new ExtentReports();

            extent.attachReporter(reporter);

            extent.setSystemInfo(
                    "Application",
                    "SauceDemo"
            );

            extent.setSystemInfo(
                    "Automation Tool",
                    "Selenium WebDriver"
            );

            extent.setSystemInfo(
                    "Test Framework",
                    "TestNG"
            );

            extent.setSystemInfo(
                    "Browser",
                    "Chrome"
            );

            extent.setSystemInfo(
                    "Environment",
                    "QA"
            );
        }

        return extent;
    }
}