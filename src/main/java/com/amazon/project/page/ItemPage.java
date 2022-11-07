package com.amazon.project.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.project.selenium.*;
import com.amazon.project.utils.Log;


public class ItemPage  {

    private WebDriver driver;

    public ItemPage (WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1")
    private WebElement titleItemPage;

    @FindBy(xpath = "//h1[contains(text(),'About this item')]")
    private WebElement aboutThisItem;
    
    @FindBy(xpath = "//h1[contains(text(),'About this item')]/following-sibling::ul/descendant::span")
    private WebElement aboutThisItemDescription;
  
  

    public String getTitle() {
        return driver.getTitle();
    }
    
    public void validateAboutThisItemExists() {
    	boolean elementExists= SeleniumUtils.elementExists(driver,aboutThisItem, "About This Item Exists.");
    	assertTrue(elementExists, "About This Item Not Found.");
    }
    
    public void logAboutThisItemSection() {
    	WebElement ele = WaitElement.waitVisibilityOf(driver, aboutThisItemDescription);
    	Log.info(ele.getText());
    }
    
}
