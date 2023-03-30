package com.hostaway.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hostaway.abstraction.AbstractPage;

import io.qameta.allure.Step;

public class AllListingsPage extends AbstractPage {
	
	@FindBy(xpath = "//h2[text()='Properties']/following-sibling::div/span/span")
	private WebElement numberOfResultsInsideLabel;
	
	@FindBy(xpath = "//a[contains(@href,'listings')]")
	private List<WebElement> results;
	
	public AllListingsPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Go to all listings page")
	public void reachPage() {
		driver.get("https://kamil-demo.alpinizm.uz/all-listings");
	}
	
	@Step("Get number of results displayed inside the label")
	public int getNumberOfResultsInsideLabel() {
		return Integer.valueOf(numberOfResultsInsideLabel.getText().replace("(", "").replace(")", ""));
	}
	
	@Step("Get number of returned results")
	public int getNumberOfResults() {
		scrollDownInsideDynamicLoadingPage();
		return Integer.valueOf(results.size());
	}

}
