package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private WebDriver driver;

    private WebDriverWait wait;


    // Page title
    private By productsTitle =
            By.className("title");


    // Add to cart - Sauce Labs Backpack
    private By backpackAddButton =
            By.id("add-to-cart-sauce-labs-backpack");


    // Add to cart - Sauce Labs Bike Light
    private By bikeLightAddButton =
            By.id("add-to-cart-sauce-labs-bike-light");


    // Cart icon
    private By cartIcon =
            By.className("shopping_cart_link");


    // Cart item count
    private By cartBadge =
            By.className("shopping_cart_badge");


    // Constructor
    public ProductsPage(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );
    }


    // Get page title
    public String getProductsTitle() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        productsTitle
                )
        ).getText();
    }


    // Add backpack
    public void addBackpackToCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        backpackAddButton
                )
        ).click();
    }


    // Add bike light
    public void addBikeLightToCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        bikeLightAddButton
                )
        ).click();
    }


    // Get cart count
    public int getCartCount() {

        String count =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                cartBadge
                        )
                ).getText();

        return Integer.parseInt(count);
    }


    // Open cart
    public void clickCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        cartIcon
                )
        ).click();
    }
}