package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class ProductTest extends BaseTest {

    private ProductsPage loginToApplication() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        return new ProductsPage(driver);
    }


    // TC_PRODUCT_001
    @Test
    public void verifyProductsPage() {

        ProductsPage productsPage =
                loginToApplication();

        Assert.assertEquals(
                productsPage.getProductsTitle(),
                "Products"
        );
    }


    // TC_PRODUCT_002
    @Test
    public void verifyAddProductToCart() {

        ProductsPage productsPage =
                loginToApplication();

        productsPage.addBackpackToCart();

        Assert.assertEquals(
                productsPage.getCartCount(),
                1
        );
    }


    // TC_PRODUCT_003
    @Test
    public void verifyMultipleProductsInCart() {

        ProductsPage productsPage =
                loginToApplication();

        productsPage.addBackpackToCart();

        productsPage.addBikeLightToCart();

        Assert.assertEquals(
                productsPage.getCartCount(),
                2
        );
    }
}
