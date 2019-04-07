package testCases;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestDownloadInvoice extends BaseClass{

    @Test
    @Parameters("environment")
    public void TestDownloadUserInvoice(String environment) throws InterruptedException, IOException {
        System.out.println("Test environment: " + environment);
        String username = "alphasense1554553347538@gmail.com";
        String password = "qwerty";

        BaseObject baseObject = new BaseObject(driver);
        Authentication authentication = baseObject.clickSignInButton();
        MyAccount myAccount = authentication.loginAsExistingUser(username, password);
        OrderHistory orderHistory = myAccount.clickOrderHistoryAndDetails();
        orderHistory.downloadPDFInvoice();
        Thread.sleep(10000);
        File file = new File(downloadFilePath);
        String file_name = Arrays.asList(file.list()).get(0);
        if(file_name.isEmpty()){
            Assert.assertTrue(false);
            System.out.println("ERROR: Invoice is not downloaded successfully!");
        }
        FileUtils.deleteDirectory(file);
    }
}
