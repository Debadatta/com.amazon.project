package com.amazon.project.tests;

import com.amazon.project.page.ItemPage;
import com.amazon.project.utils.BaseTest;
import com.aventstack.extentreports.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AmazonWebTests extends BaseTest {

	public static final Logger LOGGER = LogManager.getLogger();
	protected ItemPage itemPage;

	@Test
	public void shouldValidateTheAboutThisItem() throws InterruptedException {
		String title = homePage.getTitle();
		Assert.assertEquals(title,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		LOGGER.info("Title found: " + title);
		test.log(Status.PASS, "Navigated to the Amazon website");
		test.log(Status.PASS, "Title matched");
		homePage.clickHamburgerMenu();
		test.log(Status.PASS, "Hamburger Menu clicked.");
		
		homePage.clickTvAppliancesMenu();
		test.log(Status.PASS, "Tv Appliances Menu clicked.");
		
		homePage.clickTelevisionsMenu();
		test.log(Status.PASS, "Televisions Menu clicked.");
		
		homePage.clickBrandsSamsungMenu();	
		test.log(Status.PASS, "Samsung Brand selected.");
		
		homePage.clickHighToLowPriceSort();		
		test.log(Status.PASS, "Sorted with High toLow Price.");
		
		homePage.clickSecondHighestPricedItem();		
		test.log(Status.PASS, "Second Highest Price Item Selected.");
		
		homePage.switchToItemWindow();
		
		itemPage = new ItemPage(driver);
		String itemPageTitle = itemPage.getTitle();
		LOGGER.info("Item Page Title found: " + itemPageTitle);
		
		itemPage.validateAboutThisItemExists();
		
		itemPage.logAboutThisItemSection();
		test.log(Status.PASS, "About this Item Section description collected.");
	}
}
