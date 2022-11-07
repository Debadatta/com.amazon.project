package com.amazon.project.utils;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.amazon.project.driver.DriverFactory;
import com.amazon.project.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.amazon.project.report.ReportListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import static com.amazon.project.utils.PropertyLoader.returnConfigValue;

@Listeners({ExtentITestListenerClassAdapter.class, ReportListener.class})
public abstract class BaseTest {

    protected static WebDriver driver;
    protected HomePage homePage;
    public static ExtentTest test;
    public static ExtentReports report;
    
    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void preCondition() {
        driver = new DriverFactory().createInstance();
        driver.manage().window().maximize();
        driver.get(returnConfigValue("url.base"));
        report = new ExtentReports();
        test = report.createTest("Amazon Web Automation Started");
        homePage = new HomePage(driver);       
    }

    @AfterMethod
    public void postCondition(){
    	report.flush();
        driver.quit();
    }
}