package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TopDealsPage {
	WebDriver driver;

	public TopDealsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='#/offers']")
	public static WebElement TOPDEALS;

	@FindBy(xpath = "//select[@id='page-menu']")
	public static WebElement PAGESIZE;

	@FindBy(xpath = "//a[@aria-label='Next']")
	public static WebElement NEXT;

	public void clikTopDeals() {
		TOPDEALS.click();
	}

	public void selectPageSize() {
		Select pagesize = new Select(PAGESIZE);
		pagesize.selectByValue("10");
	}

	public void clickNext() {
		NEXT.click();
	}
}
