package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class OrderHistory {
    private WebDriver driver;
    private SeleniumUtils seleniumUtils;

    public OrderHistory(WebDriver remoteDriver){
        driver = remoteDriver;
        seleniumUtils = new SeleniumUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="tr.first_item .icon-file-text")
    private WebElement firstOrderPDFInvoice;

    public void downloadPDFInvoice(){
        seleniumUtils.clickElement(firstOrderPDFInvoice);
    }

}
