package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='search-keyword']")
	public WebElement SEARCHBOX;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SEARCHBTN;

	public void enterItemInSearchbox(String i) {
		SEARCHBOX.sendKeys(i);
	}

	public void clickSearchBtn() {
		SEARCHBTN.click();
	}

}
