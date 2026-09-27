package listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import reports.ExtentManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();


    @Override
    public void onTestStart(
            ITestResult result) {

        ExtentTest test =
                ExtentManager
                        .getInstance()
                        .createTest(
                                result.getMethod()
                                        .getMethodName()
                        );

        extentTest.set(test);
    }


    @Override
    public void onTestSuccess(
            ITestResult result) {

        extentTest
                .get()
                .log(
                        Status.PASS,
                        "Test Passed"
                );
    }


    @Override
    public void onTestFailure(
            ITestResult result) {

        extentTest
                .get()
                .log(
                        Status.FAIL,
                        "Test Failed"
                );

        Object testClass =
                result.getInstance();

        if (testClass instanceof
                testsupport.WebDriverProvider) {

            WebDriver driver =
                    ((testsupport.WebDriverProvider)
                            testClass)
                            .getDriver();

            String screenshot =
                    ScreenshotUtils.captureScreenshot(
                            driver,
                            result.getMethod()
                                    .getMethodName()
                    );

            if (screenshot != null) {

                extentTest
                        .get()
                        .addScreenCaptureFromPath(
                                screenshot
                        );
            }
        }

        extentTest
                .get()
                .fail(
                        result.getThrowable()
                );
    }


    @Override
    public void onTestSkipped(
            ITestResult result) {

        extentTest
                .get()
                .log(
                        Status.SKIP,
                        "Test Skipped"
                );
    }


    @Override
    public void onFinish(
            org.testng.ITestContext context) {

        ExtentManager
                .getInstance()
                .flush();
    }
}