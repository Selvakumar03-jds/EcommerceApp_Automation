package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailureScreenshotTest extends BaseTest {

    @Test
    public void intentionalFailureForScreenshotDemo() {

        driver.get("https://www.saucedemo.com/");

        String actualTitle =
                driver.getTitle();

        // Intentionally incorrect expectation
        Assert.assertEquals(
                actualTitle,
                "Wrong Title"
        );
    }
}