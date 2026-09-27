package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testsupport.WebDriverProvider;
import utils.ConfigReader;

public class BaseTest implements WebDriverProvider {

    protected WebDriver driver;


    @BeforeMethod
    public void setUp() {

        String browser =
                ConfigReader.getProperty("browser");


        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else {

            throw new RuntimeException(
                    "Browser not supported: " + browser
            );
        }


        driver.manage()
                .window()
                .maximize();


        driver.get(
                ConfigReader.getProperty("url")
        );
    }


    @Override
    public WebDriver getDriver() {

        return driver;
    }


    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}

