package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;

    private WebDriverWait wait;


    // Page title
    private By cartTitle =
            By.className("title");


    // Backpack
    private By backpackItem =
            By.id("item_4_title_link");


    // Remove backpack
    private By removeBackpackButton =
            By.id("remove-sauce-labs-backpack");


    // Cart items
    private By cartItems =
            By.className("cart_item");


    public CartPage(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );
    }


    // Get cart title
    public String getCartTitle() {

        return wait.until(driver -> {

            try {

                return driver.findElement(cartTitle)
                        .getText();

            } catch (StaleElementReferenceException e) {

                return null;
            }

        });
    }


    // Check whether backpack exists
    public boolean isBackpackDisplayed() {

        return driver.findElements(backpackItem)
                .size() > 0;
    }


    // Remove backpack
    public void removeBackpack() {

        driver.findElement(removeBackpackButton)
                .click();
    }


    // Get number of cart items
    public int getCartItemCount() {

        return driver.findElements(cartItems)
                .size();
    }
}