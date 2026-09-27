package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    // TC_LOGIN_001
    @Test
    public void validLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        ProductsPage productsPage =
                new ProductsPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        String actualTitle =
                productsPage.getProductsTitle();

        Assert.assertEquals(
                actualTitle,
                "Products"
        );
    }


    // TC_LOGIN_002
    @Test
    public void invalidUsernameTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "invalid_user",
                ConfigReader.getProperty("password")
        );

        String error =
                loginPage.getErrorMessage();

        Assert.assertTrue(
                error.contains(
                        "Username and password do not match"
                )
        );
    }


    // TC_LOGIN_003
    @Test
    public void invalidPasswordTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                "wrong_password"
        );

        String error =
                loginPage.getErrorMessage();

        Assert.assertTrue(
                error.contains(
                        "Username and password do not match"
                )
        );
    }


    // TC_LOGIN_004
    @Test
    public void lockedUserTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "locked_out_user",
                ConfigReader.getProperty("password")
        );

        String error =
                loginPage.getErrorMessage();

        Assert.assertTrue(
                error.contains(
                        "locked out"
                )
        );
    }


    // TC_LOGIN_005
    @Test
    public void emptyUsernameTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "",
                ConfigReader.getProperty("password")
        );

        String error =
                loginPage.getErrorMessage();

        Assert.assertTrue(
                error.contains(
                        "Username is required"
                )
        );
    }


    // TC_LOGIN_006
    @Test
    public void emptyPasswordTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ""
        );

        String error =
                loginPage.getErrorMessage();

        Assert.assertTrue(
                error.contains(
                        "Password is required"
                )
        );
    }
}