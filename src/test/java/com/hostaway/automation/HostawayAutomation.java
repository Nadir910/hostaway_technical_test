package com.hostaway.automation;

import org.openqa.selenium.WebDriver;

import com.hostaway.pages.AllListingsPage;
import com.hostaway.pages.FiltersForm;
import com.hostaway.pages.HomePage;
import com.hostaway.pages.ResultsPage;

public class HostawayAutomation {
	
	public WebDriver driver;
	public HomePage homePage;
	public ResultsPage resultsPage;
	public FiltersForm filtersForm;
	public AllListingsPage allListingsPage;
	
	public HostawayAutomation(WebDriver driver) {
		this.driver = driver;
		homePage = new HomePage(driver);
		resultsPage = new ResultsPage(driver);
		filtersForm = new FiltersForm(driver);
		allListingsPage = new AllListingsPage(driver);
	}

}
