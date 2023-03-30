package com.hostaway.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
@Feature("Filters Tests")
public class FiltersTests {
	
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
		hostawayAutomation.homePage.reachPage();
		hostawayAutomation.homePage.clickOnSearchButton();
		hostawayAutomation.resultsPage.clickOnFilterButton();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	// ------- Tests on price inputs ------

	@Test(description = "Minimal price input displayed")
	@Description("Test description: Verify that minimal price input is displayed in filters form")
	public void minimalPriceInputDisplayed() {
		assertTrue(hostawayAutomation.filtersForm.isMinimalPriceInputDisplayed(), "Minimal price input is not displayed");
	}
	
	@Test(description = "Maximal price input displayed")
	@Description("Test description: Verify that maximal price input is displayed in filters form")
	public void maximalPriceInputDisplayed() {
		assertTrue(hostawayAutomation.filtersForm.isMaximalPriceInputDisplayed(), "Maximal price input is not displayed");
	}
	
	@Test(description = "Fill in the prices without having filled in the dates")
	@Description("Test description: Try to fill in the prices without having filled int the dates previously")
	public void fillInThePricesWithoutHavingFilledInTheDates() {
		hostawayAutomation.filtersForm.closeFiltersForm();
		hostawayAutomation.resultsPage.clearDatesIfSelected();
		hostawayAutomation.resultsPage.clickOnFilterButton();
		assertTrue(hostawayAutomation.filtersForm.isMinimalPriceInputDisabled(), "Minimal price input is not disabled");
		assertTrue(hostawayAutomation.filtersForm.isMaximalPriceInputDisabled(), "Maximal price input is not disabled");
		assertTrue(hostawayAutomation.filtersForm.isFillInDatesFirstSentenceDisplayed(), "Fill in dates first sentence is not displayed");
	}
	
	@Test(description = "Fill in the prices after having filled in the dates")
	@Description("Test description: Try to fill in the prices after having filled in the dates")
	public void fillInThePricesAfterHavingFilledInTheDates() {
		hostawayAutomation.filtersForm.closeFiltersForm();
		hostawayAutomation.resultsPage.selectAnAvailablePeriod();
		hostawayAutomation.resultsPage.clickOnFilterButton();
		assertTrue(hostawayAutomation.filtersForm.isMinimalPriceInputEnabled(), "Minimal price input is not enabled");
		assertTrue(hostawayAutomation.filtersForm.isMaximalPriceInputEnabled(), "Maximal price input is not enabled");
		assertFalse(hostawayAutomation.filtersForm.isFillInDatesFirstSentenceDisplayed(), "Fill in dates first sentence is displayed");
		hostawayAutomation.filtersForm.fillInMinimalPrice(100);
		hostawayAutomation.filtersForm.fillInMaximalPrice(200);
		assertEquals(hostawayAutomation.filtersForm.getMinimalPriceInputValue(), 100, "Minimal price input is not well filled");
		assertEquals(hostawayAutomation.filtersForm.getMaximalPriceInputValue(), 200, "Maximal price input is not well filled");
	}
	
	// ------- Tests on rooms and beds selectors -------
	
	@Test(description = "Rooms and beds selectors displayed")
	@Description("Test description: Verify that beds and rooms selectors are displayed")
	public void roomsAndBedsSelectorsDisplayed() {
		assertTrue(hostawayAutomation.filtersForm.areBedsAndRoomsSelectorsDisplayed(), "Beds and rooms selectors are not displayed");
	}
	
	@Test(description = "Select minimum number of beds")
	@Description("Test description: Select minimum number of beds and check the display")
	public void selectMinimumNumberOfBeds() {
		hostawayAutomation.filtersForm.selectMinimalNumberOfBeds();
		assertEquals(hostawayAutomation.filtersForm.getNumberOfSelectedBeds(), 0, "Number of selected beds is different from 0");
		assertTrue(hostawayAutomation.filtersForm.isDecreaseNumberOfBedsDisabled(), "Decrease number of beds is not disabled");
		assertTrue(hostawayAutomation.filtersForm.isIncreaseNumberOfBedsEnabled(), "Increase number of beds is not enabled");
	}
	
	@Test(description = "Select maximum number of beds")
	@Description("Test description: Select maximum number of beds and check the display")
	public void selectMaximumNumberOfBeds() {
		hostawayAutomation.filtersForm.selectMaximumNumberOfBeds();
		assertEquals(hostawayAutomation.filtersForm.getNumberOfSelectedBeds(), 10, "Number of selected beds is different from 10");
		assertTrue(hostawayAutomation.filtersForm.isIncreaseNumberOfBedsDisabled(), "Increase number of beds is not disabled");
		assertTrue(hostawayAutomation.filtersForm.isDecreaseNumberOfBedsEnabled(), "Decrease number of beds is not enabled");
	}
	
	@Test(description = "Select minimum number of bedrooms")
	@Description("Test description: Select minimum number of bedrooms and check the display")
	public void selectMinimumNumberOfBedrooms() {
		hostawayAutomation.filtersForm.selectMinimalNumberOfBedrooms();
		assertEquals(hostawayAutomation.filtersForm.getNumberOfSelectedBedrooms(), 0, "Number of selected bedrooms is different from 0");
		assertTrue(hostawayAutomation.filtersForm.isDecreaseNumberOfBedroomsDisabled(), "Decrease number of bedrooms is not disabled");
		assertTrue(hostawayAutomation.filtersForm.isIncreaseNumberOfBedroomsEnabled(), "Increase number of bedrooms is not enabled");
	}
	
	@Test(description = "Select maximum number of bedrooms")
	@Description("Test description: Select maximum number of bedrooms and check the display")
	public void selectMaximumNumberOfBedrooms() {
		hostawayAutomation.filtersForm.selectMaximumNumberOfBedrooms();
		assertEquals(hostawayAutomation.filtersForm.getNumberOfSelectedBedrooms(), 10, "Number of selected bedrooms is different from 10");
		assertTrue(hostawayAutomation.filtersForm.isIncreaseNumberOfBedroomsDisabled(), "Increase number of bedrooms is not disabled");
		assertTrue(hostawayAutomation.filtersForm.isDecreaseNumberOfBedroomsEnabled(), "Decrease number of bedrooms is not enabled");
	}
	
	@Test(description = "Select minimum number of bathrooms")
	@Description("Test description: Select minimum number of bathrooms and check the display")
	public void selectMinimumNumberOfBathrooms() {
		hostawayAutomation.filtersForm.selectMinimalNumberOfBathrooms();
		assertEquals(hostawayAutomation.filtersForm.getNumberOfSelectedBathrooms(), 0, "Number of selected bathrooms is different from 0");
		assertTrue(hostawayAutomation.filtersForm.isDecreaseNumberOfBathroomsDisabled(), "Decrease number of bathrooms is not disabled");
		assertTrue(hostawayAutomation.filtersForm.isIncreaseNumberOfBathroomsEnabled(), "Increase number of bathrooms is not enabled");
	}
	
	@Test(description = "Select maximum number of bathrooms")
	@Description("Test description: Select maximum number of bathrooms and check the display")
	public void selectMaximumNumberOfBathrooms() {
		hostawayAutomation.filtersForm.selectMaximumNumberOfBathrooms();
		assertEquals(hostawayAutomation.filtersForm.getNumberOfSelectedBathrooms(), 10, "Number of selected bathrooms is different from 10");
		assertTrue(hostawayAutomation.filtersForm.isIncreaseNumberOfBathroomsDisabled(), "Increase number of bathrooms is not disabled");
		assertTrue(hostawayAutomation.filtersForm.isDecreaseNumberOfBathroomsEnabled(), "Decrease number of bathrooms is not enabled");
	}
	
	// ------- Tests on amenities -------
	
	@Test(description = "All amenities displayed")
	@Description("Test description: Verify that all expected amenities are displayed")
	public void areAllAmenitiesDisplayed() {
		assertTrue(hostawayAutomation.filtersForm.areAllAmenitiesDisplayed(), "All amenities are not displayed");
	}
	
	@Test(description = "Select deselect amenities")
	@Description("Test description: Verify that selection and deselection of amenities works well")
	public void selectDeselectAllAmenities() {
		// Check that all amenities are not selected
		assertTrue(hostawayAutomation.filtersForm.isBeachFrontAmenityInputUnselected(), "Beach front amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isSwimmingPoolAmenityInputUnselected(), "Swimming pool amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isFreeWifiAmenityInputUnselected(), "Free wifi amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isKitchenAmenityInputUnselected(), "Kitchen amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isAirConditioningAmenityInputUnselected(), "Air conditioning amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isWashingMachineAmenityInputUnselected(), "Washing machine amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isPetsAllowedAmenityInputUnselected(), "Pets allowed amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isHotTubAmenityInputUnselected(), "Hot tub amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isStreetParkingAmenityInputUnselected(), "Street parking amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isSuitableForChildrenAmenityInputUnselected(), "Suitable for children amenity is selected");
		// Select all amenities
		hostawayAutomation.filtersForm.chooseBeachFrontAmenity();
		hostawayAutomation.filtersForm.chooseSwimmingPoolAmenity();
		hostawayAutomation.filtersForm.chooseFreeWifiAmenity();
		hostawayAutomation.filtersForm.chooseKitchenAmenity();
		hostawayAutomation.filtersForm.chooseAirConditioningAmenity();
		hostawayAutomation.filtersForm.chooseWashingMachineAmenity();
		hostawayAutomation.filtersForm.choosePetsAllowedAmenity();
		hostawayAutomation.filtersForm.chooseHotTubAmenity();
		hostawayAutomation.filtersForm.chooseStreetParkingAmenity();
		hostawayAutomation.filtersForm.chooseSuitableForChildrenAmenity();
		// Check that amenities selection works well
		assertTrue(hostawayAutomation.filtersForm.isBeachFrontAmenityInputSelected(), "Beach front amenity is not selected");
		assertTrue(hostawayAutomation.filtersForm.isSwimmingPoolAmenityInputSelected(), "Swimming pool amenity is not selected");
		assertTrue(hostawayAutomation.filtersForm.isFreeWifiAmenityInputSelected(), "Free wifi amenity is not selected");
		assertTrue(hostawayAutomation.filtersForm.isKitchenAmenityInputSelected(), "Kitchen amenity is not selected");
		assertTrue(hostawayAutomation.filtersForm.isAirConditioningAmenityInputSelected(), "Air conditioning amenity is not selected");
		assertTrue(hostawayAutomation.filtersForm.isWashingMachineAmenityInputSelected(), "Washing machine amenity is not selected");
		assertTrue(hostawayAutomation.filtersForm.isPetsAllowedAmenityInputSelected(), "Pets allowed amenity is not selected");
		assertTrue(hostawayAutomation.filtersForm.isHotTubAmenityInputSelected(), "Hot tub amenity is not selected");
		assertTrue(hostawayAutomation.filtersForm.isStreetParkingAmenityInputSelected(), "Street parking amenity is not selected");
		assertTrue(hostawayAutomation.filtersForm.isSuitableForChildrenAmenityInputSelected(), "Suitable for children amenity is not selected");
	}
	
	// ------- Clear all filters -------
	
	@Test(description = "Clear all filters")
	@Description("Test description: Verify that clear all filters button works well")
	public void clearAllFilters() {
		// Select a lot of filters
		hostawayAutomation.filtersForm.selectMaximumNumberOfBeds();
		hostawayAutomation.filtersForm.selectMaximumNumberOfBedrooms();
		hostawayAutomation.filtersForm.selectMaximumNumberOfBathrooms();
		hostawayAutomation.filtersForm.chooseBeachFrontAmenity();
		hostawayAutomation.filtersForm.chooseSwimmingPoolAmenity();
		hostawayAutomation.filtersForm.chooseFreeWifiAmenity();
		hostawayAutomation.filtersForm.chooseKitchenAmenity();
		hostawayAutomation.filtersForm.chooseAirConditioningAmenity();
		hostawayAutomation.filtersForm.chooseWashingMachineAmenity();
		hostawayAutomation.filtersForm.choosePetsAllowedAmenity();
		hostawayAutomation.filtersForm.chooseHotTubAmenity();
		hostawayAutomation.filtersForm.chooseStreetParkingAmenity();
		hostawayAutomation.filtersForm.chooseSuitableForChildrenAmenity();
		// Check that the filters are taken into account
		assertEquals(hostawayAutomation.filtersForm.getNumberOfSelectedBeds(), 10);
		assertEquals(hostawayAutomation.filtersForm.getNumberOfSelectedBedrooms(), 10);
		assertEquals(hostawayAutomation.filtersForm.getNumberOfSelectedBathrooms(), 10);
		assertTrue(hostawayAutomation.filtersForm.isBeachFrontAmenityInputSelected());
		assertTrue(hostawayAutomation.filtersForm.isSwimmingPoolAmenityInputSelected());
		assertTrue(hostawayAutomation.filtersForm.isFreeWifiAmenityInputSelected());
		assertTrue(hostawayAutomation.filtersForm.isKitchenAmenityInputSelected());
		assertTrue(hostawayAutomation.filtersForm.isAirConditioningAmenityInputSelected());
		assertTrue(hostawayAutomation.filtersForm.isWashingMachineAmenityInputSelected());
		assertTrue(hostawayAutomation.filtersForm.isPetsAllowedAmenityInputSelected());
		assertTrue(hostawayAutomation.filtersForm.isHotTubAmenityInputSelected());
		assertTrue(hostawayAutomation.filtersForm.isStreetParkingAmenityInputSelected());
		assertTrue(hostawayAutomation.filtersForm.isSuitableForChildrenAmenityInputSelected());
		// Clear all filters
		hostawayAutomation.filtersForm.clearAllFilters();
		// Check that clear all filters works as expected
		assertEquals(hostawayAutomation.filtersForm.getNumberOfSelectedBeds(), 0, "Number of selected beds is different from 0");
		assertEquals(hostawayAutomation.filtersForm.getNumberOfSelectedBedrooms(), 0, "Number of selected bedrooms is different from 0");
		assertEquals(hostawayAutomation.filtersForm.getNumberOfSelectedBathrooms(), 0, "Number of selected bathrooms is different from 0");
		assertTrue(hostawayAutomation.filtersForm.isBeachFrontAmenityInputUnselected(), "Beach front amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isSwimmingPoolAmenityInputUnselected(), "Swimming pool amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isFreeWifiAmenityInputUnselected(), "Free wifi amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isKitchenAmenityInputUnselected(), "Kitchen amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isAirConditioningAmenityInputUnselected(), "Air conditioning amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isWashingMachineAmenityInputUnselected(), "Washing machine amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isPetsAllowedAmenityInputUnselected(), "Pets allowed amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isHotTubAmenityInputUnselected(), "Hot tub amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isStreetParkingAmenityInputUnselected(), "Street parking amenity is selected");
		assertTrue(hostawayAutomation.filtersForm.isSuitableForChildrenAmenityInputUnselected(), "Suitable for children amenity is selected");
	}

}