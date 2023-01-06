package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddToCart {

	WebDriver driver;

	public AddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]")
	public static WebElement ADDTOCART;

	@FindBy(xpath = "//tbody/tr[1]/td[3]/strong[1]")
	public static WebElement ITEMcount;

	@FindBy(xpath = "//img[@alt='Cart']")
	public static WebElement GOTObag;

	@FindBy(xpath = "//*[@id=\"root\"]/div/header/div/div[3]/div[2]/div[2]/button")
	public static WebElement ProceedToCheckout;
	
	@FindBy(xpath="//input[@class='promoCode']")
	public static WebElement PROMO;

	@FindBy(xpath = "//button[contains(text(),'Place Order')]")
	public static WebElement PLACEORDER;

	@FindBy(xpath = "//select[@style='width: 200px;']")
	public static WebElement COUNTRY;

	@FindBy(xpath = "//input[@type='checkbox']")
	public static WebElement checkBOX;
	
	@FindBy(xpath="//button[contains(text(),'Proceed')]")
	public static WebElement PROCEED;
	
	@FindBy(xpath="//b[contains(text(),'Please accept Terms & Conditions - Required')]")
	public static WebElement FAILED;
	
	@FindBy(xpath="//button[@class='promoBtn']")
	public static WebElement APPLY;
	
	@FindBy(xpath="//span[contains(text(),'Code applied ..!')]")
	public static WebElement isPromoApplied;

	public void addtocart() {
		ADDTOCART.click();
	}

	public void clickCart() {
		GOTObag.click();
	}

	public void proceedtoCheckout() {
		ProceedToCheckout.click();
	}
	
	public void enterPromoCode(String promo)
	{
		PROMO.sendKeys(promo);
	}
	
	public void applyPromo()
	{
		APPLY.click();
	}

	
	public void placeOrder() {
		PLACEORDER.click();
	}

	public void chooseCountry(String country) {
		Select cntry = new Select(COUNTRY);
		cntry.selectByValue(country);
	}

	public void clickCheckBox() {
		checkBOX.click();
	}
	
	public void proceed()
	{
		PROCEED.click();
	}
	
}

