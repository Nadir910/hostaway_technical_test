package com.hostaway.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hostaway.abstraction.AbstractPage;

import io.qameta.allure.Step;

public class HomePage extends AbstractPage {
	
	@FindBy(xpath = "//span[text()='Search']/..")
	private WebElement searchButton;


	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Go to Hostaway home page")
	public void reachPage() {
		driver.get("https://kamil-demo.alpinizm.uz/");
	}
	
	@Step("Click on Search button")
	public void clickOnSearchButton() {
		searchButton.click();
	}

}
