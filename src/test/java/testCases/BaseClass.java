package testCases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class BaseClass {

    public String baseUrl = "http://automationpractice.com/index.php";
    public static WebDriver driver;
    public static String downloadFilePath;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/drivers/chromedriver");
        downloadFilePath = System.getProperty("user.dir") + "/src/downloads";
        File fileDirectory = FileUtils.getFile(downloadFilePath);
        fileDirectory.mkdir();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", downloadFilePath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(cap);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void captureScreenshot(ITestResult testResult) throws IOException{
        if (testResult.getStatus() == ITestResult.FAILURE)
        {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE); // capture the screenshot file
            File target = new File(System.getProperty("user.dir") + "/screenshots/" + testResult.getName() + ".png");
            FileUtils.copyFile(source, target);
            System.out.println("screenshot catured");
        }
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }


}
