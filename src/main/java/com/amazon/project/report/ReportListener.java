package com.amazon.project.report;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.amazon.project.utils.BaseTest;

public class ReportListener implements ITestListener {

    public void onTestSuccess(ITestResult result) {
        reportPrint();
    }

    public void onTestFailure(ITestResult result) {
        reportPrint();
    }

    private void reportPrint() {
        ExtentTestManager.getTest().addScreenCaptureFromBase64String(takeScreenshot());
    }

    private String takeScreenshot() {
        return ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
