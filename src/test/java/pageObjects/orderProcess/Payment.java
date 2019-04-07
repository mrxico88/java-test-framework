package pageObjects.orderProcess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class Payment {

    public WebDriver driver;
    private SeleniumUtils seleniumUtils;

    public Payment(WebDriver remoteDriver){
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
        seleniumUtils = new SeleniumUtils(driver);
    }

    @FindBy(css=".bankwire")
    private WebElement payByBankWire;

    public OrderSummaryAndConfirmation clickPayByBankWire(){
        seleniumUtils.clickElement(payByBankWire);
        return new OrderSummaryAndConfirmation(driver);
    }
}
