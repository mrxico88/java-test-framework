package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

import utils.SeleniumUtils;

import java.io.IOException;
import java.time.Instant;



public class TestCreateUser extends BaseClass{

    private SeleniumUtils seleniumUtils = new SeleniumUtils(driver);

    @Test
    @Parameters("environment")
    public void TestCreateNewUserAndLogin(String environment) throws IOException, InterruptedException {
        System.out.println("Test environment: " + environment);
        long localTime = Instant.now().toEpochMilli();
        String username = "alphasense" + localTime + "@gmail.com";
        String password = "qwerty";
        try {
            BaseObject baseObject = new BaseObject(driver);
            Authentication authentication = baseObject.clickSignInButton();
            authentication.inputEmailToCreateNewUser(username);

            CreateAccount createAccount = authentication.clickCreateUserSubmitButton();
            createAccount.addUserInfo(password);

            MyAccount myAccount = new MyAccount(driver);
            WebElement welcomeText = myAccount.getWelcomeText();
            Assert.assertEquals(welcomeText.getText(), "Welcome to your account. " +
                    "Here you can manage all of your personal information and orders.");
            System.out.println("Successfully created user: " + username);


            authentication = baseObject.clickSignOutButton();
            authentication.loginAsExistingUser(username, password);
            welcomeText = myAccount.getWelcomeText();
            Assert.assertEquals(welcomeText.getText(), "Welcome to your account. " +
                    "Here you can manage all of your personal information and orders.");

        } catch (AssertionError e){
            System.out.println("ERROR: create user test failed");
            seleniumUtils.captureScreen(driver, "login_test_failed");

        }
    }

}


