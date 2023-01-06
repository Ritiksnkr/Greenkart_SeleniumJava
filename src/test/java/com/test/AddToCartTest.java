package com.test;

import java.io.IOException; 

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.AddToCart;
import com.pages.FlightBookingPage;

import Utilities.ConfigFileReader;

public class AddToCartTest extends BaseClass {

	private static Logger logger = LogManager.getLogger(AddToCartTest.class);
	AddToCart ac;
	ConfigFileReader cr;

	public AddToCartTest() {
		super();
	}

	@BeforeMethod
	public void seTup() throws IOException {
		setup();
		ac = new AddToCart(null);
	}

	@Test(priority=6)
	public void addCart() {
		ac = new AddToCart(driver);
		ac.addtocart();
		logger.info("Item added to cart Successfully");
		String count = ac.ITEMcount.getText();
		Assert.assertEquals(count, "1");
	}

	@Test(priority=7)
	public void proceedToCheckout() throws InterruptedException {
		ac = new AddToCart(driver);
		ac.addtocart();
		Thread.sleep(2000);
		ac.clickCart();
		logger.info("Clicked on cart Successfully");
		Thread.sleep(2000);
		ac.proceedtoCheckout();
		logger.info("Proceed to Checkout Successfully");
		Thread.sleep(2000);
		ac.placeOrder();
		logger.info("Clicked on Place Order");
		Thread.sleep(2000);
		ac.chooseCountry(cr.getProperty("Country"));
		logger.info("Country selected Successfully");
		Thread.sleep(2000);
		ac.clickCheckBox();
		logger.info("Clicked on checkbox");
		Thread.sleep(2000);
		ac.proceed();
		logger.info("Order Placed Succesfully");
		Assert.assertEquals(driver.getTitle(), "GreenKart - veg and fruits kart");
	}

	@Test(priority=8)
	public void failedProceedToCheckout() throws InterruptedException {
		ac = new AddToCart(driver);
		ac.addtocart();
		Thread.sleep(2000);
		ac.clickCart();
		logger.info("Clicked on cart Successfully");
		Thread.sleep(2000);
		ac.proceedtoCheckout();
		logger.info("Proceed to Checkout Successfully");
		Thread.sleep(2000);
		ac.placeOrder();
		logger.info("Clicked on Place Order");
		Thread.sleep(2000);
		ac.chooseCountry(cr.getProperty("Country"));
		logger.info("Country selected Successfully");
		Thread.sleep(2000);
		ac.proceed();
		logger.info("Clicked on proceed");
		Assert.assertEquals(ac.FAILED.getText(), "Please accept Terms & Conditions - Require");
	}
	
	@Test(priority=9)
	public void applyValidPromocode() throws InterruptedException
	{
		ac = new AddToCart(driver);
		ac.addtocart();
		Thread.sleep(2000);
		ac.clickCart();
		logger.info("Clicked on cart Successfully");
		Thread.sleep(2000);
		ac.proceedtoCheckout();
		logger.info("Proceed to Checkout Successfully");
		Thread.sleep(2000);
		ac.enterPromoCode(cr.getProperty("Promocode"));
		logger.info("Entered Promocode");
		ac.applyPromo();
		logger.info("Promocode Applied Succesfully");
		Assert.assertEquals(ac.isPromoApplied.getText(), "Code applied ..!");
		
	}

}
