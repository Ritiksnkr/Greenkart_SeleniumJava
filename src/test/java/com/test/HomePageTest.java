package com.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import Utilities.ConfigFileReader;

public class HomePageTest extends BaseClass {
	private static Logger logger = LogManager.getLogger(HomePageTest.class);
	HomePage hp;
	ConfigFileReader cr;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void seTup() throws IOException {
		setup();
		hp = new HomePage(null);
	}

	@Test(priority=1)
	public void isLogoAvailable() {
		hp = new HomePage(driver);
		hp.LOGO.isDisplayed();
		logger.info("Logo is displayed");
	}

	@Test(priority=2)
	public void verifyTitle() {
		hp = new HomePage(driver);
		Assert.assertEquals(driver.getTitle(), "GreenKart - veg and fruits kart");
		logger.info("Title verified");
	}

	@Test(priority=3)
	public void verifyTitleFailed() {
		hp = new HomePage(driver);
		Assert.assertEquals(driver.getTitle(), "GreenKart - veg and fruits kar");
		logger.info("Title not verified");
	}

}
