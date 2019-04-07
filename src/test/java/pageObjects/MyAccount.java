package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class MyAccount {

    private WebDriver driver;
    private SeleniumUtils seleniumUtils;

    public MyAccount(WebDriver remoteDriver){
        driver = remoteDriver;
        seleniumUtils = new SeleniumUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".account")
    private WebElement viewUserAccountButton;

    @FindBy(css=".info-account")
    private WebElement welcomeText;

    @FindBy(xpath = "//span[text()='Order history and details']")
    private WebElement orderHistoryAndDetails;

    public WebElement getWelcomeText(){
        return welcomeText;
    }

    public OrderHistory clickOrderHistoryAndDetails(){
        seleniumUtils.clickElement(orderHistoryAndDetails);
        return new OrderHistory(driver);
    }


}
