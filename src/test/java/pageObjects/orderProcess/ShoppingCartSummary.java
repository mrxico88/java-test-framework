package pageObjects.orderProcess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class ShoppingCartSummary {
    public WebDriver driver;
    private SeleniumUtils seleniumUtils;

    public ShoppingCartSummary(WebDriver remoteDriver){
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
        seleniumUtils = new SeleniumUtils(driver);
    }

    @FindBy(css=".standard-checkout")
    private WebElement proceedToCheckOutBtn;

    public Addresses clickProceedToCheckOutBtn(){
        seleniumUtils.clickElement(proceedToCheckOutBtn);
        return new Addresses(driver);
    }
}
