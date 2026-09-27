package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By checkoutButton =
            By.id("checkout");

    private By firstNameField =
            By.id("first-name");

    private By lastNameField =
            By.id("last-name");

    private By postalCodeField =
            By.id("postal-code");

    private By continueButton =
            By.id("continue");

    private By finishButton =
            By.id("finish");

    // SauceDemo validation error
    private By errorMessage =
            By.cssSelector("h3[data-test='error']");

    // Order confirmation
    private By confirmationMessage =
            By.cssSelector("[data-test='complete-header']");


    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(15)
                );
    }


    // Click Checkout from Cart
    public void clickCheckout() {

        // Make sure we are actually on the Cart page
        wait.until(
                ExpectedConditions.urlContains(
                        "cart.html"
                )
        );

        // Wait for Checkout button to exist
        WebElement checkout =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                checkoutButton
                        )
                );

        // Wait until it is visible
        wait.until(
                ExpectedConditions.visibilityOf(checkout)
        );

        // Scroll it into view
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});",
                        checkout
                );

        // Click
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        checkoutButton
                )
        ).click();

        // Confirm checkout step one loaded
        wait.until(
                ExpectedConditions.urlContains(
                        "checkout-step-one.html"
                )
        );

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        firstNameField
                )
        );
    }


    // Enter First Name
    public void enterFirstName(String firstName) {

        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                firstNameField
                        )
                );

        field.clear();

        if (!firstName.isEmpty()) {
            field.sendKeys(firstName);
        }
    }


    // Enter Last Name
    public void enterLastName(String lastName) {

        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                lastNameField
                        )
                );

        field.clear();

        if (!lastName.isEmpty()) {
            field.sendKeys(lastName);
        }
    }


    // Enter Postal Code
    public void enterPostalCode(String postalCode) {

        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                postalCodeField
                        )
                );

        field.clear();

        if (!postalCode.isEmpty()) {
            field.sendKeys(postalCode);
        }
    }


    // Enter customer details
    public void enterCustomerDetails(
            String firstName,
            String lastName,
            String postalCode) {

        enterFirstName(firstName);

        enterLastName(lastName);

        enterPostalCode(postalCode);
    }


    // Click Continue
    public void clickContinue() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        continueButton
                )
        ).click();
    }


    // Click Finish
    public void clickFinish() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        finishButton
                )
        ).click();
    }


    // Get validation error
    public String getErrorMessage() {

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        errorMessage
                )
        ).getText();
    }


    // Get order confirmation
    public String getConfirmationMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        confirmationMessage
                )
        ).getText();
    }
}