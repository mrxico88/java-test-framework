package utils.Listeners;

import com.aventstack.extentreports.*;
import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;
import testCases.BaseClass;
import utils.SeleniumUtils;

import java.io.IOException;


public class Listener extends BaseClass implements ITestListener {

    //Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Test Started");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Test Finished"));
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        try {
            String filePath = new SeleniumUtils(driver).captureScreen(driver, result.getName());
            test.get().log(Status.FAIL, result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
            test.get().log(Status.FAIL, "Screenshot: " + filePath);
        } catch (IOException e){
            System.out.println(e);
        }
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
}
