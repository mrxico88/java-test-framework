package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IExecutionListener;

import java.io.File;
import java.io.IOException;

public class SeleniumUtils {

    public WebDriver driver;

    public SeleniumUtils(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void waitForElementToBeVisble(WebElement expected_element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(expected_element));
    }

    public void clickElement(WebElement target_element, WebElement expected_element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.visibilityOf(target_element));
            target_element.click();
            wait.until(ExpectedConditions.visibilityOf(expected_element));
        } catch (Exception e){
            System.out.println("Clicking element failed");
            try {
                this.captureScreen(driver, "click_element_failed");
            } catch (IOException ioe){
                System.out.println(ioe);
            }
        }
    }

    public void clickElement(WebElement target_element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.visibilityOf(target_element));
            target_element.click();
        } catch (Exception e){
            System.out.println("Clicking element failed");
            try {
                this.captureScreen(driver, "click_element_failed");
            } catch (IOException ioe){
                System.out.println(ioe);
            }
        }
    }

    public String captureScreen(WebDriver driver, String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/src/screenshots/" + screenshotName + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
        return target.getPath();
    }
}
