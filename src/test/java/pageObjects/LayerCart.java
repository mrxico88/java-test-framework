package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.orderProcess.ShoppingCartSummary;
import utils.SeleniumUtils;

public class LayerCart {

    public WebDriver driver;
    private SeleniumUtils seleniumUtils;

    public LayerCart(WebDriver remoteDriver){
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
        seleniumUtils = new SeleniumUtils(driver);
    }

    @FindBy(css="a[title='Proceed to checkout']")
    private WebElement proceedToCheckOutBtn;

    public ShoppingCartSummary clickProceedToCheckedOut(){
        seleniumUtils.clickElement(proceedToCheckOutBtn);
        return new ShoppingCartSummary(driver);
    }

}
