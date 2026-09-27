import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

public class FirstSeleniumTest {

    public static void main(String[] args) {

        System.out.println(
                "Browser: " +
                        ConfigReader.getProperty("browser")
        );

        System.out.println(
                "URL: " +
                        ConfigReader.getProperty("url")
        );

        System.out.println(
                "Username: " +
                        ConfigReader.getProperty("username")
        );

        WebDriver driver =
                new ChromeDriver();

        driver.manage()
                .window()
                .maximize();

        driver.get(
                ConfigReader.getProperty("url")
        );

        System.out.println(
                "Page Title: " +
                        driver.getTitle()
        );

        driver.quit();
    }
}
