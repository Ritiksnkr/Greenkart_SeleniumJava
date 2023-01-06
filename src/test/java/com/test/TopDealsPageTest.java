package com.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.SearchPage;
import com.pages.TopDealsPage;

import Utilities.ConfigFileReader;

public class TopDealsPageTest extends BaseClass {

	private static Logger logger = LogManager.getLogger(SearchPageTest.class);
	TopDealsPage tdp;
	ConfigFileReader cr;

	public TopDealsPageTest() {
		super();
	}

	@BeforeMethod
	public void seTup() throws IOException {
		setup();
		tdp = new TopDealsPage(null);
	}

	@Test(priority=5)
	public void topDeals() throws InterruptedException {
		tdp = new TopDealsPage(driver);
		tdp.clikTopDeals();
		logger.info("Clicked on Top Deals");
		ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(1));
		Thread.sleep(2000);
		tdp.selectPageSize();
		logger.info("Page size selected");
		tdp.clickNext();
		logger.info("Clicked on next");
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tab2.get(0));
		Assert.assertEquals(driver.getTitle(), "GreenKart - veg and fruits kart");
	}
}
