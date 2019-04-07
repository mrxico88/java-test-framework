package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

import java.io.IOException;
import java.util.List;

public class HomePage{

    public WebDriver driver;
    private SeleniumUtils seleniumUtils;

    public HomePage(WebDriver remoteDriver){
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
        seleniumUtils = new SeleniumUtils(driver);
    }

    @FindBy(css=".header_user_info .login")
    private WebElement signIn;

    @FindBy(id="search_query_top")
    private WebElement inputSearch;

    @FindBy(css=".button-search")
    private WebElement submitSearchBtn;

    @FindBy(css=".heading-counter")
    private WebElement searchCountText;

    @FindBy(css="li.ajax_block_product")
    private List<WebElement> productItems;

    @FindBy(css="#homefeatured li:nth-child(1)")
    private WebElement firstProduct;

    @FindBy(css="#homefeatured li:nth-child(1) .ajax_add_to_cart_button")
    private WebElement firstProductAddToCartBtn;

    public void searchForKeyword(String keyword) {
        inputSearch.sendKeys(keyword);
        seleniumUtils.clickElement(submitSearchBtn, searchCountText);
    }

    public List<WebElement> getProductItems(){
        return productItems;
    }

    public String getSearchCountText(){
        String text = searchCountText.getText();
        return text;
    }

    public LayerCart clickAddToCartFirstPopularProduct(){
        seleniumUtils.clickElement(firstProductAddToCartBtn);
        return new LayerCart(driver);
    }

    public void hoverToFirstProduct(){
        Actions action = new Actions(driver);
        action.moveToElement(firstProduct).perform();
    }


}
