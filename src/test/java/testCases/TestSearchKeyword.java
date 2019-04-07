package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utils.SeleniumUtils;

import java.io.IOException;
import java.util.List;

public class TestSearchKeyword extends BaseClass {

    private SeleniumUtils seleniumUtils = new SeleniumUtils(driver);

    @Test
    @Parameters("environment")
    public void TestSearch(String environment) throws IOException {
        System.out.println("Test environment: " + environment);
        String keyword = "Dress";
        try {
            HomePage homePage = new HomePage(driver);
            homePage.searchForKeyword(keyword);
            String text = homePage.getSearchCountText();
            List<WebElement> searchResultElements = homePage.getProductItems();
            int searchResultNumber = Integer.parseInt(text.replaceAll("\\D+", ""));
            Assert.assertEquals(searchResultNumber, searchResultElements.size());

            for(WebElement element : searchResultElements){
                String productName = element.findElement(By.cssSelector(".product-name")).getText();
                System.out.println("Product name for current product: " + productName );
                if(!productName.toLowerCase().contains(keyword.toLowerCase())){
                    System.out.println("ERROR: Search results don't contain search keyword: " + keyword);
                    seleniumUtils.captureScreen(driver, "search_test");
                    Assert.assertTrue(false);
                }
            }
        } catch (Exception e){
            seleniumUtils.captureScreen(driver, "search_test");
        }

    }
}
