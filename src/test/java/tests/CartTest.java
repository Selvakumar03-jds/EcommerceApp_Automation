package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class CartTest extends BaseTest {

    private ProductsPage loginToApplication() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        return new ProductsPage(driver);
    }


    // TC_CART_001
    @Test
    public void verifyProductInCart() {

        ProductsPage productsPage =
                loginToApplication();

        productsPage.addBackpackToCart();

        productsPage.clickCart();

        CartPage cartPage =
                new CartPage(driver);

        Assert.assertEquals(
                cartPage.getCartTitle(),
                "Your Cart"
        );

        Assert.assertTrue(
                cartPage.isBackpackDisplayed(),
                "Backpack should be displayed in cart"
        );
    }


    // TC_CART_002
    @Test
    public void verifyRemoveProductFromCart() {

        ProductsPage productsPage =
                loginToApplication();

        productsPage.addBackpackToCart();

        productsPage.clickCart();

        CartPage cartPage =
                new CartPage(driver);

        Assert.assertTrue(
                cartPage.isBackpackDisplayed()
        );

        cartPage.removeBackpack();

        Assert.assertEquals(
                cartPage.getCartItemCount(),
                0,
                "Cart should be empty after removing product"
        );
    }


    // TC_CART_003
    @Test
    public void verifyMultipleProductsInCart() {

        ProductsPage productsPage =
                loginToApplication();

        productsPage.addBackpackToCart();

        productsPage.addBikeLightToCart();

        productsPage.clickCart();

        CartPage cartPage =
                new CartPage(driver);

        Assert.assertEquals(
                cartPage.getCartItemCount(),
                2,
                "Cart should contain two products"
        );
    }
}