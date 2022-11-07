package com.amazon.project.selenium;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.amazon.project.utils.Log;

public class SeleniumUtils {

    public static void clickUsingJs(WebDriver driver, WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    
    public static void scrollToElement(WebDriver driver, WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }
    
    public static void click(WebDriver driver, WebElement element, String message) {
		try {
			WebElement ele = WaitElement.waitVisibilityOf(driver,  element);
			ele.click();
			Log.info(message);
		} catch(Exception e) {
			Log.error("Element not found.");
		}
	}
    
    public static void scrollAndClick(WebDriver driver, WebElement element,String message) {
		try {
			//SeleniumUtils.scrollToElement( driver, element );
			WebElement ele = WaitElement.waitVisibilityOf(driver,  element);
			//ele.click();
			SeleniumUtils.clickUsingJs(driver, element);
			Log.info(message);
		} catch(Exception e) {
			Log.error("Element not found.");
		}
	}
        
    public static void select(WebDriver driver, WebElement element, String option) {
		try {
			WebElement ele = WaitElement.waitVisibilityOf(driver,  element);
			Select dropDown = new Select(ele);
			dropDown.selectByVisibleText(option);
			Log.info("Selectbox option clicked.");
		} catch (Exception e) {
			Log.error("Selectbox not found.");
		}
	}
    
    public static void switchToWindow(WebDriver driver) {
    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));        
    }
    
    public static boolean elementExists( WebDriver driver, WebElement element, String message ) {
    	WebElement ele=null;
    	try {
			ele = WaitElement.waitVisibilityOf(driver,  element);
    	} catch (Exception e) {
			Log.error("Element not found.");
		}
    	if(ele.isDisplayed())
    		Log.info(message);
    	return ele.isDisplayed();
    }
   

}
