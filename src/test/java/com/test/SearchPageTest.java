package com.test;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.SearchPage;

import Utilities.ConfigFileReader;

public class SearchPageTest extends BaseClass {

	private static Logger logger = LogManager.getLogger(SearchPageTest.class);
	SearchPage sp;
	ConfigFileReader cr;

	public SearchPageTest() {
		super();
	}

	@BeforeMethod
	public void seTup() throws IOException {
		setup();
		sp = new SearchPage(null);
	}

	@Test(priority=4)
	public void Search() throws Exception {
		sp = new SearchPage(driver);
		sp.enterItemInSearchbox(cr.getProperty("Item"));
		logger.info("entered item in searchbox");
		sp.clickSearchBtn();
		logger.info("clicked on search button");
		Thread.sleep(2000);
		logger.info("Searched Successfully");
		Assert.assertEquals(driver.getTitle(), "GreenKart - veg and fruits kart");

	}

}
