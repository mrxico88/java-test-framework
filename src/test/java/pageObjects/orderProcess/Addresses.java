package pageObjects.orderProcess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.orderProcess.Shipping;
import utils.SeleniumUtils;

public class Addresses {
    public WebDriver driver;
    private SeleniumUtils seleniumUtils;

    public Addresses(WebDriver remoteDriver){
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
        seleniumUtils = new SeleniumUtils(driver);
    }

    @FindBy(css="button[name='processAddress']")
    private WebElement proceedToCheckoutBtn;

    public Shipping clickProceedToCheckOutBtn(){
        seleniumUtils.clickElement(proceedToCheckoutBtn);
        return new Shipping(driver);
    }
}
