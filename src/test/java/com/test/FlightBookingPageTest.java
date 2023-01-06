package com.test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.FlightBookingPage;
import com.pages.SearchPage;

import Utilities.ConfigFileReader;

public class FlightBookingPageTest extends BaseClass {

	private static Logger logger = LogManager.getLogger(FlightBookingPageTest.class);
	FlightBookingPage fbp;
	ConfigFileReader cr;

	public FlightBookingPageTest() {
		super();
	}

	@BeforeMethod
	public void seTup() throws IOException {
		setup();
		fbp = new FlightBookingPage(null);
	}

	@Test(priority=10)
	public void flightBooking() throws InterruptedException {
		fbp = new FlightBookingPage(driver);
		fbp.clickFlightBooking();
		logger.info("Successfully Opened Flight Booking Page");
		Thread.sleep(3000);
		ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(1));
		Thread.sleep(2000);
		fbp.chooseCountry(cr.getProperty("Country"));
		logger.info("Country Selected");
		fbp.selectDepCity(cr.getProperty("departCity"));;
		logger.info("Departure City selected");
		Thread.sleep(2000);
		fbp.selectDepCity(cr.getProperty("arrivalCity"));
		logger.info("Arrival City selected");
		Thread.sleep(2000);
		fbp.selectDepartDate();
		logger.info("Depart Date selected");
		fbp.selectCurrency(cr.getProperty("Currency"));
		logger.info("Currency selected");
		fbp.search();
		logger.info("search Succesfully");
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(),
				"QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		logger.info("Assertion passed Successfully");
		driver.close();
		driver.switchTo().window(tab2.get(0));
	}

	@Test(priority=11)
	public void bookHotel() throws InterruptedException {
		fbp = new FlightBookingPage(driver);
		fbp.clickFlightBooking();
		logger.info("Successfully Opened Flight Booking Page");
		Thread.sleep(3000);
		ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(1));
		Thread.sleep(2000);
		fbp.chooseCountry(cr.getProperty("Country"));
		logger.info("Country Selected");
		Thread.sleep(2000);
		fbp.clickHotels();
		logger.info("Clicked on hotels");
		Thread.sleep(2000);
		fbp.destination(cr.getProperty("departCity"));
		logger.info("Depart city Selected");
		fbp.selectAdults(cr.getProperty("Adults"));
		logger.info("No. of Adults Selected");
		fbp.selectChild(cr.getProperty("Child"));
		logger.info("No. of child Selected");
		fbp.selectInfant(cr.getProperty("Infant"));
		logger.info("No. of infant Selected");
		fbp.clickSearch();
		logger.info("Search Succesfully");
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(),
				"QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		logger.info("Assertion passed Successfully");
		driver.close();
		driver.switchTo().window(tab2.get(0));
	}

	@Test(priority=12)
	public void holidayPackage() throws InterruptedException {

		fbp = new FlightBookingPage(driver);
		fbp.clickFlightBooking();
		logger.info("Successfully Opened Flight Booking Page");
		Thread.sleep(3000);
		ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(1));
		Thread.sleep(2000);
		fbp.chooseCountry(cr.getProperty("Country"));
		logger.info("Country Selected");
		Thread.sleep(2000);
		fbp.clickHolidayPackage();
		logger.info("clicked Holiday Package");
		fbp.destination_HolidayPackage(cr.getProperty("destination"));
		logger.info("Destination Entered");
		fbp.departure_HolidayPackage("departure");
		logger.info("Departure city entered");
		fbp.return_HolidayPackage("returnCity");
		logger.info("Return city entered");
		fbp.departDate_HolidayPackage();
		logger.info("Depart date entered");
		fbp.search_HolidayPackage();
		logger.info("Search Successfully");
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(),
				"QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		logger.info("Assertion passed Successfully");
		driver.close();
		driver.switchTo().window(tab2.get(0));

	}
}
