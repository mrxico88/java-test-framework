package pageObjects.orderProcess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class OrderSummaryAndConfirmation {

    public WebDriver driver;
    private SeleniumUtils seleniumUtils;

    public OrderSummaryAndConfirmation(WebDriver remoteDriver){
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
        seleniumUtils = new SeleniumUtils(driver);
    }

    @FindBy(xpath = "//span[text()='I confirm my order']")
    public WebElement confirmOrder;

    @FindBy(css=".cheque-indent")
    public WebElement orderConfirmationText;

    public void clickConfirmOrder(){
        seleniumUtils.clickElement(confirmOrder);
    }

    public WebElement getOrderConfirmationText(){
        return orderConfirmationText;
    }


}
