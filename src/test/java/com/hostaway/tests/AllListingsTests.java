package com.hostaway.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hostaway.abstraction.AbstractPage;
import com.hostaway.automation.HostawayAutomation;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("Regression Tests")
@Feature("All Listings Tests")
public class AllListingsTests {
	
	WebDriver driver;
	HostawayAutomation hostawayAutomation;
	AbstractPage abstractPage;
	
	@BeforeClass
	public void setup() {
		// Initialize driver
		final String driverLocation = "src/main/resources/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// Initialize pages
		hostawayAutomation = new HostawayAutomation(driver);
		abstractPage = new AbstractPage(driver);
		// Reach filters form
		hostawayAutomation.allListingsPage.reachPage();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test(description = "Right number of results displayed")
	@Description("Test description: check that the number of results displayed in the label corresponds to the number of results actually returned")
	public void rightNumberOfResultsDisplayed() {
		assertEquals(hostawayAutomation.allListingsPage.getNumberOfResultsInsideLabel(), 
			hostawayAutomation.allListingsPage.getNumberOfResults(),
				"The number of results returned does not match the number displayed in the label");
	}

}
