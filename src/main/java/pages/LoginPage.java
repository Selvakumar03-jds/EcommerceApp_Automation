package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By usernameField =
            By.id("user-name");

    private By passwordField =
            By.id("password");

    private By loginButton =
            By.id("login-button");

    private By errorMessage =
            By.cssSelector("[data-test='error']");


    public LoginPage(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );
    }


    public void enterUsername(String username) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        usernameField
                )
        ).clear();

        driver.findElement(usernameField)
                .sendKeys(username);
    }


    public void enterPassword(String password) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        passwordField
                )
        ).clear();

        driver.findElement(passwordField)
                .sendKeys(password);
    }


    public void clickLogin() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginButton
                )
        ).click();
    }


    public void login(
            String username,
            String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();

        /*
         * Login can have two outcomes:
         *
         * 1. Valid credentials
         *    -> inventory.html
         *
         * 2. Invalid credentials
         *    -> error message appears
         *
         * Therefore we must NOT always wait
         * for inventory.html.
         */
        wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.urlContains(
                                "inventory.html"
                        ),
                        ExpectedConditions.visibilityOfElementLocated(
                                errorMessage
                        )
                )
        );
    }


    public String getErrorMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        errorMessage
                )
        ).getText();
    }
}