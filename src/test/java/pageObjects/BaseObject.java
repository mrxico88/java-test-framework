package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class BaseObject {

    private WebDriver driver;
    private SeleniumUtils seleniumUtils;

    public BaseObject(WebDriver remoteDriver){
        driver = remoteDriver;
        seleniumUtils = new SeleniumUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".header_user_info .login")
    private WebElement signInBtn;

    @FindBy(css=".header_user_info .logout")
    private WebElement signOutBtn;

    @FindBy(css=".logo")
    private WebElement logo;

    public Authentication clickSignInButton(){
        seleniumUtils.clickElement(signInBtn);
        return new Authentication(driver);
    }

    public Authentication clickSignOutButton(){
        seleniumUtils.clickElement(signOutBtn);
        return new Authentication(driver);
    }

    public HomePage clickLogoButton(){
        seleniumUtils.clickElement(logo);
        return new HomePage(driver);
    }

}
