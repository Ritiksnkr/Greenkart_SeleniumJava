package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightBookingPage {

	WebDriver driver;

	public FlightBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//--------------------------------FLIGHT BOOKING-------------------------------------------------------------------------------------
	@FindBy(xpath = "//a[contains(text(),'Flight Booking')]")
	public static WebElement FlightBooking;

	@FindBy(xpath = "//span[contains(text(),'Flights') and @xpath='1']")
	public static WebElement FLIGHTS;

	@FindBy(xpath = "//input[@id='autosuggest']")
	public static WebElement COUNTRY;

	@FindBy(xpath = "//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")
	public static WebElement depCITY;

	@FindBy(xpath = "//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")
	public static WebElement arrCITY;

	@FindBy(xpath = "//input[@id='ctl00_mainContent_view_date1']")
	public static WebElement departDATE;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/a[1]")
	public static WebElement select_departDATE;

	@FindBy(xpath = "//select[@id='ctl00_mainContent_DropDownListCurrency']")
	public static WebElement CURRENCY;

	@FindBy(xpath = "//input[@name='ctl00$mainContent$btn_FindFlights']")
	public static WebElement SEARCH_FlighBooking;

//----------------------HOTELS BOOKING---------------------------------------------------------------------------------------------
	@FindBy(xpath = "//span[@style='position: relative; top: 3px;']")
	public static WebElement HOTELS;

	@FindBy(xpath = "//select[@id='ddl_Adult_MST']")
	public static WebElement ADULTS;

	@FindBy(xpath = "//select[@id='ddl_Child_MST']")
	public static WebElement CHILD;

	@FindBy(xpath = "//select[@id='ddl_Infant_MST']")
	public static WebElement INFANT;

	@FindBy(xpath = "//input[@id='ctl00_mainContent_ButtonSubmit_MST']")
	public static WebElement SEARCH;

	@FindBy(xpath = "//input[@id='ctl00_mainContent_txtOriginStation1_MST']")
	public static WebElement destinationCity;

//-------------------------HOLIDAY PACKAGE-----------------------------------------------------------------------------------------

	@FindBy(xpath = "//span[contains(text(),'Holiday Packages')]")
	public static WebElement HOLIDAYPACKAGE;

	@FindBy(xpath = "//input[@id='ctl00_mainContent_HolidayPackages_DropDownListPackage_CTXT']")
	public static WebElement DESTINATION;

	@FindBy(xpath = "//input[@id='ctl00_mainContent_HolidayPackages_DropDownListFrom_CTXT']")
	public static WebElement DEPARTURE;

	@FindBy(xpath = "//input[@id='ctl00_mainContent_HolidayPackages_DropDownListTo_CTXT']")
	public static WebElement RETURN;

	@FindBy(xpath = "//input[@name='ctl00$mainContent$HolidayPackages$TxtTravelDate']")
	public static WebElement DEPART_DATE;

	@FindBy(xpath = "//a[contains(text(),'19')]")
	public static WebElement select_DEPART_DATE;

	@FindBy(xpath = "//input[@id='btnFindHolidays']")
	public static WebElement search_HOLIDAYPACKAGE;

//-------------------------------------------------------------------------------------------------------------------------------
	public void clickHotels() {
		HOTELS.click();
	}

	public void destination(String dest) {
		destinationCity.sendKeys(dest);
	}

	public void selectAdults(String adlts) {
		Select adults = new Select(ADULTS);
		adults.selectByValue(adlts);
	}

	public void selectChild(String chld) {
		Select childs = new Select(CHILD);
		childs.selectByValue(chld);
	}

	public void selectInfant(String infnt) {
		Select infant = new Select(INFANT);
		infant.selectByValue(infnt);
	}

	public void clickSearch() {
		SEARCH.click();
	}

//-----------------------------------------------------------------------------------------------------------------------------------
	public void clickFlightBooking() {
		FlightBooking.click();
	}

	public void clickFlights() {
		FLIGHTS.click();
	}

	public void chooseCountry(String country) {
		COUNTRY.sendKeys(country);
	}

	public void selectDepCity(String departureCity) {
		depCITY.sendKeys(departureCity);
	}

	public void selectArrivalCity(String arrivalCity) {
		arrCITY.sendKeys(arrivalCity);
	}

	public void selectDepartDate() {

		departDATE.click();
		Actions act = new Actions(driver);
		act.moveToElement(select_departDATE).click().perform();
	}

	public void selectCurrency(String currency) {
		Select crr = new Select(CURRENCY);
		crr.selectByValue(currency);
	}

	public void search() {
		SEARCH_FlighBooking.click();
	}

//-----------------------------------------------------------------------------------------------------------------------------------
	public void clickHolidayPackage() {
		HOLIDAYPACKAGE.click();
	}

	public void destination_HolidayPackage(String dest) {
		DESTINATION.sendKeys(dest);
	}

	public void departure_HolidayPackage(String dep) {
		DEPARTURE.sendKeys(dep);
	}

	public void return_HolidayPackage(String ret) {
		RETURN.sendKeys(ret);
	}

	public void departDate_HolidayPackage() {
		DEPART_DATE.click();
		// select_DEPART_DATE.click();
		Actions act = new Actions(driver);
		act.moveToElement(select_DEPART_DATE).click().perform();
	}

	public void search_HolidayPackage() {
		search_HOLIDAYPACKAGE.click();
	}
}
