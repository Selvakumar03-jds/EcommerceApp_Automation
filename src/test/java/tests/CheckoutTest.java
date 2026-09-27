package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

    private CheckoutPage goToCheckout() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        ProductsPage productsPage =
                new ProductsPage(driver);

        productsPage.addBackpackToCart();

        productsPage.clickCart();

        CartPage cartPage =
                new CartPage(driver);

        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        checkoutPage.clickCheckout();

        return checkoutPage;
    }


    // TC_CHECKOUT_001
    @Test
    public void validCheckoutTest() {

        CheckoutPage checkoutPage =
                goToCheckout();

        checkoutPage.enterCustomerDetails(
                "Selva",
                "Kumar",
                "627001"
        );

        checkoutPage.clickContinue();

        checkoutPage.clickFinish();

        String confirmation =
                checkoutPage.getConfirmationMessage();

        Assert.assertEquals(
                confirmation,
                "Thank you for your order!"
        );
    }


    // TC_CHECKOUT_002
    @Test
    public void emptyFirstNameTest() {

        CheckoutPage checkoutPage =
                goToCheckout();

        checkoutPage.enterCustomerDetails(
                "",
                "Kumar",
                "627001"
        );

        checkoutPage.clickContinue();

        String error =
                checkoutPage.getErrorMessage();

        Assert.assertTrue(
                error.contains(
                        "First Name is required"
                )
        );
    }


    // TC_CHECKOUT_003
    @Test
    public void emptyLastNameTest() {

        CheckoutPage checkoutPage =
                goToCheckout();

        checkoutPage.enterCustomerDetails(
                "Selva",
                "",
                "627001"
        );

        checkoutPage.clickContinue();

        String error =
                checkoutPage.getErrorMessage();

        Assert.assertTrue(
                error.contains(
                        "Last Name is required"
                )
        );
    }


    // TC_CHECKOUT_004
    @Test
    public void emptyPostalCodeTest() {

        CheckoutPage checkoutPage =
                goToCheckout();

        checkoutPage.enterCustomerDetails(
                "Selva",
                "Kumar",
                ""
        );

        checkoutPage.clickContinue();

        String error =
                checkoutPage.getErrorMessage();

        Assert.assertTrue(
                error.contains(
                        "Postal Code is required"
                )
        );
    }
}
