package pageObjects.orderProcess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class Shipping {
    public WebDriver driver;
    private SeleniumUtils seleniumUtils;

    public Shipping(WebDriver remoteDriver){
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
        seleniumUtils = new SeleniumUtils(driver);
    }

    @FindBy(css="button[name='processCarrier']")
    private WebElement proceedToCheckoutBtn;

    @FindBy(css=".checker")
    private WebElement agreeTermCheckBox;

    public Payment agreeShippTermAndCheckout(){
        seleniumUtils.clickElement(agreeTermCheckBox);
        seleniumUtils.clickElement(proceedToCheckoutBtn);
        return new Payment(driver);
    }
}
