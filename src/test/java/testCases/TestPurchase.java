package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.Authentication;
import pageObjects.BaseObject;
import pageObjects.HomePage;
import pageObjects.LayerCart;
import pageObjects.orderProcess.*;
import utils.SeleniumUtils;

import java.io.IOException;

public class TestPurchase extends BaseClass {

    private SeleniumUtils seleniumUtils = new SeleniumUtils(driver);

    @Test
    @Parameters("environment")
    public void TestBuyProduct(String environment) throws IOException {
        System.out.println("Test environment: " + environment);
        String username = "alphasense1554553347538@gmail.com";
        String password = "qwerty";
        try {
            BaseObject baseObject = new BaseObject(driver);
            Authentication authentication = baseObject.clickSignInButton();
            authentication.loginAsExistingUser(username, password);
            HomePage homePage = baseObject.clickLogoButton();

            homePage.hoverToFirstProduct();
            LayerCart layerCart = homePage.clickAddToCartFirstPopularProduct();
            ShoppingCartSummary shoppingCartSummary = layerCart.clickProceedToCheckedOut();
            Addresses addresses = shoppingCartSummary.clickProceedToCheckOutBtn();
            Shipping shipping = addresses.clickProceedToCheckOutBtn();
            Payment payment = shipping.agreeShippTermAndCheckout();

            OrderSummaryAndConfirmation orderSummary = payment.clickPayByBankWire();
            orderSummary.clickConfirmOrder();
            WebElement orderConfirmationText = orderSummary.getOrderConfirmationText();
            if (!orderConfirmationText.getText().equals("Your order on My Store is complete.")) {
                seleniumUtils.captureScreen(driver, "buyProduct");
                Assert.assertTrue(false);
            }
        } catch (Exception error) {
            Assert.assertTrue(false);
            seleniumUtils.captureScreen(driver, "unexpected_failure");
        }
    }
}
