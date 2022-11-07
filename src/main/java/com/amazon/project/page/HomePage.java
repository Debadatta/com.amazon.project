package com.amazon.project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.project.selenium.*;
import com.amazon.project.utils.Log;

public class HomePage  {

    private WebDriver driver;

    public HomePage (WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1")
    private WebElement titleWelcomePage;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private WebElement hamburgerMenu;

    
    @FindBy(xpath = "//div[contains(text(), 'TV, Appliances, Electronics')]/parent::a")
    private WebElement tvAppliancesMenu;
    
    @FindBy(xpath = "//a[contains(text(), 'Televisions')]")
    private WebElement televisionsMenu;
    
    @FindBy(xpath = "//span[starts-with(text(),'Brands')]/parent::div/following-sibling::ul/li[2]/span/descendant::span[contains(text(), 'Samsung')]/parent::a/div/label/input")
    private WebElement brandsSamsungMenu;
    
    @FindBy(xpath = "//form[@class='aok-inline-block a-spacing-none']/descendant::select")
    private WebElement priceSortFilterSelect;
  
    @FindBy(xpath = "//span[@data-component-type='s-search-results']/descendant::div[@data-component-type='s-search-result'][2]")
    private WebElement secondHighestPricedItem;
  


    public String getTitle() {
        return driver.getTitle();
    }

    public String getTextTitleWelcome() {
        return titleWelcomePage.getText();
    }
    
    public void clickHamburgerMenu() {
    	SeleniumUtils.click(driver, hamburgerMenu, "Hamburger Menu Clicked.");
    }
    
    public void clickTvAppliancesMenu() {
    	SeleniumUtils.click(driver, tvAppliancesMenu, "TV Appliances Menu Clicked.");
    }
    
    public void clickTelevisionsMenu() throws InterruptedException {
    	SeleniumUtils.click(driver, televisionsMenu, "Televisions Menu clicked.");
    }
    
    public void clickBrandsSamsungMenu() throws InterruptedException {
    	Thread.sleep(5);
    	SeleniumUtils.scrollAndClick(driver, brandsSamsungMenu, "Brands Menu Clicked.");
    }
    
    
    public void clickHighToLowPriceSort() throws InterruptedException {
    	Thread.sleep(2);
    	SeleniumUtils.select(driver, priceSortFilterSelect, "Price: High to Low");
    }
    
    public void clickSecondHighestPricedItem() throws InterruptedException {
    	SeleniumUtils.click(driver, secondHighestPricedItem, "Second highest priced item Clicked.");
    }

    public void switchToItemWindow() {
    	SeleniumUtils.switchToWindow(driver);
    	Log.info("Switched to Selected Item Page.");
    }
}
