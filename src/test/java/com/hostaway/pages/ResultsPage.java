package com.hostaway.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hostaway.abstraction.AbstractPage;

import io.qameta.allure.Step;

public class ResultsPage extends AbstractPage {
	
	@FindBy(xpath = "//span[text()='Filter']/..")
	private WebElement filterButton;
	
	@FindBy(xpath = "//div[text()='Check-in']/..")
	private WebElement checkInField;
	
	@FindBy(xpath = "//div[text()='Check-out']/..")
	private WebElement checkOutField;
	
	@FindBy(xpath = "//div[not(@disabled) and contains(@class,'CalendarDay')]")
	private List<WebElement> availableDays;
	
	@FindBy(xpath = "//span[text()='Clear dates']/..")
	private WebElement clearDatesButton;
	
	public ResultsPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Click on Filter button")
	public void clickOnFilterButton() {
		filterButton.click();
	}
	
	@Step("Select an available period")
	public void selectAnAvailablePeriod() {
		checkInField.click();
		availableDays.get(0).click();
		availableDays.get(1).click();
	}
	
	@Step("Clear dates selection if necessary")
	public void clearDatesIfSelected() {
		checkInField.click();
		if(isElementPresent(checkInField)) {
			clearDatesButton.click();
		}
	}

}
