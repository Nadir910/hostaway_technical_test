package com.hostaway.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hostaway.abstraction.AbstractPage;

import io.qameta.allure.Step;

public class FiltersForm extends AbstractPage {
	
	@FindBy(xpath = "//div[text()='Price']/../..")
	private WebElement filtersForm;
	
	@FindBy(xpath = "//input[@placeholder='From']")
	private WebElement minimalPriceInput;
	
	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement maximalPriceInput;
	
	@FindBy(xpath = "//p[text()='To filter by price, please select dates']")
	private WebElement fillInDatesFirstSentence;
	
	@FindBy(xpath = "//div[text()='Filters']/following-sibling::button")
	private WebElement closeButton;
	
	@FindBy(xpath = "//div[text()='Beds']/following-sibling::div")
	private WebElement bedsSelector;
	
	@FindBy(xpath = "//div[text()='Beds']/following-sibling::div//span")
	private WebElement numberOfSelectedBeds;
	
	@FindBy(xpath = "//div[text()='Beds']/following-sibling::div//button[1]")
	private WebElement decreaseNumberOfBeds;
	
	@FindBy(xpath = "//div[text()='Beds']/following-sibling::div//button[2]")
	private WebElement increaseNumberOfBeds;
	
	@FindBy(xpath = "//div[text()='Bedrooms']/following-sibling::div")
	private WebElement bedroomsSelector;
	
	@FindBy(xpath = "//div[text()='Bedrooms']/following-sibling::div//span")
	private WebElement numberOfSelectedBedrooms;
	
	@FindBy(xpath = "//div[text()='Bedrooms']/following-sibling::div//button[1]")
	private WebElement decreaseNumberOfBedrooms;
	
	@FindBy(xpath = "//div[text()='Bedrooms']/following-sibling::div//button[2]")
	private WebElement increaseNumberOfBedrooms;
	
	@FindBy(xpath = "//div[text()='Bathrooms']/following-sibling::div")
	private WebElement bathroomsSelector;
	
	@FindBy(xpath = "//div[text()='Bathrooms']/following-sibling::div//span")
	private WebElement numberOfSelectedBathrooms;
	
	@FindBy(xpath = "//div[text()='Bathrooms']/following-sibling::div//button[1]")
	private WebElement decreaseNumberOfBathrooms;
	
	@FindBy(xpath = "//div[text()='Bathrooms']/following-sibling::div//button[2]")
	private WebElement increaseNumberOfBathrooms;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Beach front']/..")
	private WebElement beachFrontAmenity;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Beach front']/../input")
	private WebElement beachFrontAmenityInput;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Swimming pool']/..")
	private WebElement swimmingPoolAmenity;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Swimming pool']/../input")
	private WebElement swimmingPoolAmenityInput;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Free WiFi']/..")
	private WebElement freeWifiAmenity;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Free WiFi']/../input")
	private WebElement freeWifiAmenityInput;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Kitchen']/..")
	private WebElement kitchenAmenity;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Kitchen']/../input")
	private WebElement kitchenAmenityInput;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Air conditioning']/..")
	private WebElement airConditioningAmenity;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Air conditioning']/../input")
	private WebElement airConditioningAmenityInput;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Washing Machine']/..")
	private WebElement washingMachineAmenity;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Washing Machine']/../input")
	private WebElement washingMachineAmenityInput;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Pets allowed']/..")
	private WebElement petsAllowedAmenity;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Pets allowed']/../input")
	private WebElement petsAllowedAmenityInput;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Hot tub']/..")
	private WebElement hotTubAmenity;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Hot tub']/../input")
	private WebElement hotTubAmenityInput;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Street parking']/..")
	private WebElement streetParkingAmenity;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Street parking']/../input")
	private WebElement streetParkingAmenityInput;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Suitable for children']/..")
	private WebElement suitableForChildrenAmenity;
	
	@FindBy(xpath = "//div[text()='Price']/..//span[text()='Suitable for children']/../input")
	private WebElement suitableForChildrenAmenityInput;
	
	@FindBy(xpath = "//b[text()='Clear all']")
	private WebElement clearAllFilters;
	
	public FiltersForm(WebDriver driver) {
		super(driver);
	}
	
	@Step("Check that minimal price input is present")
	public boolean isMinimalPriceInputDisplayed() {
		return isElementPresent(minimalPriceInput);
	}
	
	@Step("Check that maximal price input is present")
	public boolean isMaximalPriceInputDisplayed() {
		return isElementPresent(maximalPriceInput);
	}
	
	@Step("Check that minimal price input is enabled")
	public boolean isMinimalPriceInputEnabled() {
		return minimalPriceInput.isEnabled();
	}
	
	@Step("Check that maximal price input is enabled")
	public boolean isMaximalPriceInputEnabled() {
		return maximalPriceInput.isEnabled();
	}
	
	@Step("Check that minimal price input is disabled")
	public boolean isMinimalPriceInputDisabled() {
		return !minimalPriceInput.isEnabled();
	}
	
	@Step("Check that maximal price input is disabled")
	public boolean isMaximalPriceInputDisabled() {
		return !maximalPriceInput.isEnabled();
	}
	
	@Step("Check if fill in dates first sentence is displayed or not")
	public boolean isFillInDatesFirstSentenceDisplayed() {
		return isElementPresent(fillInDatesFirstSentence);
	}
	
	@Step("Close filters form")
	public void closeFiltersForm() {
		closeButton.click();
	}
	
	@Step("Fill in the minimal price with minimal price: {0}")
	public void fillInMinimalPrice(int minimalPrice) {
		minimalPriceInput.sendKeys(Integer.toString(minimalPrice));
	}
	
	@Step("Fill in the maximal price with maximal price: {0}")
	public void fillInMaximalPrice(int maximalPrice) {
		maximalPriceInput.sendKeys(Integer.toString(maximalPrice));
	}
	
	@Step("Click on maximal price input")
	public void clickOnMaximalPriceInput() {
		maximalPriceInput.click();
	}
	
	@Step("Get minimal price input value")
	public int getMinimalPriceInputValue() {
		return Integer.valueOf(minimalPriceInput.getAttribute("value"));
	}
	
	@Step("Get maximal price input value")
	public int getMaximalPriceInputValue() {
		return Integer.valueOf(maximalPriceInput.getAttribute("value"));
	}
	
	@Step("Check that all beds and rooms selectors are displayed")
	public boolean areBedsAndRoomsSelectorsDisplayed() {
		return isElementPresent(bedsSelector) && isElementPresent(bedroomsSelector)
			&& isElementPresent(bathroomsSelector);
	}
	
	@Step("Get number of selected beds")
	public int getNumberOfSelectedBeds() {
		return Integer.valueOf(numberOfSelectedBeds.getText());
	}
	
	@Step("Select minimal number of beds")
	public void selectMinimalNumberOfBeds() {
		clickOnElementNTimes(decreaseNumberOfBeds, getNumberOfSelectedBeds());
	}
	
	@Step("Select maximum number of beds")
	public void selectMaximumNumberOfBeds() {
		int numberOfBedsToAdd = 10 - getNumberOfSelectedBeds();
		clickOnElementNTimes(increaseNumberOfBeds, numberOfBedsToAdd);
	}
	
	@Step("Verify that decrease number of beds is enabled")
	public boolean isDecreaseNumberOfBedsEnabled() {
		return decreaseNumberOfBeds.isEnabled();
	}
	
	@Step("Verify that decrease number of beds is disabled")
	public boolean isDecreaseNumberOfBedsDisabled() {
		return !decreaseNumberOfBeds.isEnabled();
	}
	
	@Step("Verify that increase number of beds is enabled")
	public boolean isIncreaseNumberOfBedsEnabled() {
		return increaseNumberOfBeds.isEnabled();
	}
	
	@Step("Verify that increase number of beds is disabled")
	public boolean isIncreaseNumberOfBedsDisabled() {
		return !increaseNumberOfBeds.isEnabled();
	}
	
	@Step("Get number of selected bedrooms")
	public int getNumberOfSelectedBedrooms() {
		return Integer.valueOf(numberOfSelectedBedrooms.getText());
	}
	
	@Step("Select minimal number of bedrooms")
	public void selectMinimalNumberOfBedrooms() {
		clickOnElementNTimes(decreaseNumberOfBedrooms, getNumberOfSelectedBedrooms());
	}
	
	@Step("Select maximum number of bedrooms")
	public void selectMaximumNumberOfBedrooms() {
		int numberOfBedroomsToAdd = 10 - getNumberOfSelectedBedrooms();
		clickOnElementNTimes(increaseNumberOfBedrooms, numberOfBedroomsToAdd);
	}
	
	@Step("Verify that decrease number of bedrooms is enabled")
	public boolean isDecreaseNumberOfBedroomsEnabled() {
		return decreaseNumberOfBedrooms.isEnabled();
	}
	
	@Step("Verify that decrease number of bedrooms is disabled")
	public boolean isDecreaseNumberOfBedroomsDisabled() {
		return !decreaseNumberOfBedrooms.isEnabled();
	}
	
	@Step("Verify that increase number of bedrooms is enabled")
	public boolean isIncreaseNumberOfBedroomsEnabled() {
		return increaseNumberOfBedrooms.isEnabled();
	}
	
	@Step("Verify that increase number of bedrooms is disabled")
	public boolean isIncreaseNumberOfBedroomsDisabled() {
		return !increaseNumberOfBedrooms.isEnabled();
	}
	
	@Step("Get number of selected bathrooms")
	public int getNumberOfSelectedBathrooms() {
		return Integer.valueOf(numberOfSelectedBathrooms.getText());
	}
	
	@Step("Select minimal number of bathrooms")
	public void selectMinimalNumberOfBathrooms() {
		clickOnElementNTimes(decreaseNumberOfBathrooms, getNumberOfSelectedBathrooms());
	}
	
	@Step("Select maximum number of bathrooms")
	public void selectMaximumNumberOfBathrooms() {
		int numberOfBathroomsToAdd = 10 - getNumberOfSelectedBathrooms();
		clickOnElementNTimes(increaseNumberOfBathrooms, numberOfBathroomsToAdd);
	}
	
	@Step("Verify that decrease number of bathrooms is enabled")
	public boolean isDecreaseNumberOfBathroomsEnabled() {
		return decreaseNumberOfBathrooms.isEnabled();
	}
	
	@Step("Verify that decrease number of bathrooms is disabled")
	public boolean isDecreaseNumberOfBathroomsDisabled() {
		return !decreaseNumberOfBathrooms.isEnabled();
	}
	
	@Step("Verify that increase number of bathrooms is enabled")
	public boolean isIncreaseNumberOfBathroomsEnabled() {
		return increaseNumberOfBathrooms.isEnabled();
	}
	
	@Step("Verify that increase number of bathrooms is disabled")
	public boolean isIncreaseNumberOfBathroomsDisabled() {
		return !increaseNumberOfBathrooms.isEnabled();
	}
	
	@Step("Verify that all amenities are displayed")
	public boolean areAllAmenitiesDisplayed() {
		return isElementPresent(beachFrontAmenity) && isElementPresent(swimmingPoolAmenity)
			&& isElementPresent(freeWifiAmenity) && isElementPresent(kitchenAmenity)
				&& isElementPresent(airConditioningAmenity) && isElementPresent(washingMachineAmenity)
					&& isElementPresent(petsAllowedAmenity) && isElementPresent(hotTubAmenity)
						&& isElementPresent(streetParkingAmenity) && isElementPresent(suitableForChildrenAmenity);
	}
	
	@Step("Select beach front amenity")
	public void chooseBeachFrontAmenity() {
		if(!isBeachFrontAmenityInputSelected()) {
			beachFrontAmenity.click();
		}
	}
	
	@Step("Select swimming pool amenity")
	public void chooseSwimmingPoolAmenity() {
		if(!isSwimmingPoolAmenityInputSelected()) {
			swimmingPoolAmenity.click();
		}
	}
	
	@Step("Select free wifi amenity")
	public void chooseFreeWifiAmenity() {
		if(!isFreeWifiAmenityInputSelected()) {
			freeWifiAmenity.click();
		}
	}
	
	@Step("Select kitchen amenity")
	public void chooseKitchenAmenity() {
		if(!isKitchenAmenityInputSelected()) {
			kitchenAmenity.click();
		}
	}
	
	@Step("Select air conditioning amenity")
	public void chooseAirConditioningAmenity() {
		if(!isAirConditioningAmenityInputSelected()) {
			airConditioningAmenity.click();
		}
	}
	
	@Step("Select washing machine amenity")
	public void chooseWashingMachineAmenity() {
		if(!isWashingMachineAmenityInputSelected()) {
			washingMachineAmenity.click();
		}
	}
	
	@Step("Select pets allowed amenity")
	public void choosePetsAllowedAmenity() {
		if(!isPetsAllowedAmenityInputSelected()) {
			petsAllowedAmenity.click();			
		}
	}
	
	@Step("Select hot tub amenity")
	public void chooseHotTubAmenity() {
		if(!isHotTubAmenityInputSelected()) {
			hotTubAmenity.click();			
		}
	}
	
	@Step("Select street parking amenity")
	public void chooseStreetParkingAmenity() {
		if(!isStreetParkingAmenityInputSelected()) {
			streetParkingAmenity.click();			
		}
	}
	
	@Step("Select suitable for children amenity")
	public void chooseSuitableForChildrenAmenity() {
		if(!isSuitableForChildrenAmenityInputSelected()) {
			suitableForChildrenAmenity.click();			
		}
	}
	
	@Step("Verify that beach front amenity is selected")
	public boolean isBeachFrontAmenityInputSelected() {
		return beachFrontAmenityInput.isSelected();
	}
	
	@Step("Verify that beach front amenity is unselected")
	public boolean isBeachFrontAmenityInputUnselected() {
		return !beachFrontAmenityInput.isSelected();
	}
	
	@Step("Verify that swimming pool amenity is selected")
	public boolean isSwimmingPoolAmenityInputSelected() {
		return swimmingPoolAmenityInput.isSelected();
	}
	
	@Step("Verify that swimming pool amenity is unselected")
	public boolean isSwimmingPoolAmenityInputUnselected() {
		return !swimmingPoolAmenityInput.isSelected();
	}
	
	@Step("Verify that free wifi amenity is selected")
	public boolean isFreeWifiAmenityInputSelected() {
		return freeWifiAmenityInput.isSelected();
	}
	
	@Step("Verify that free wifi amenity is unselected")
	public boolean isFreeWifiAmenityInputUnselected() {
		return !freeWifiAmenityInput.isSelected();
	}
	
	@Step("Verify that kitchen amenity is selected")
	public boolean isKitchenAmenityInputSelected() {
		return kitchenAmenityInput.isSelected();
	}
	
	@Step("Verify that kitchen amenity is unselected")
	public boolean isKitchenAmenityInputUnselected() {
		return !kitchenAmenityInput.isSelected();
	}
	
	@Step("Verify that air conditioning amenity is selected")
	public boolean isAirConditioningAmenityInputSelected() {
		return airConditioningAmenityInput.isSelected();
	}
	
	@Step("Verify that air conditioning amenity is unselected")
	public boolean isAirConditioningAmenityInputUnselected() {
		return !airConditioningAmenityInput.isSelected();
	}
	
	@Step("Verify that washing machine amenity is selected")
	public boolean isWashingMachineAmenityInputSelected() {
		return washingMachineAmenityInput.isSelected();
	}
	
	@Step("Verify that washing machine amenity is unselected")
	public boolean isWashingMachineAmenityInputUnselected() {
		return !washingMachineAmenityInput.isSelected();
	}
	
	@Step("Verify that pets allowed amenity is selected")
	public boolean isPetsAllowedAmenityInputSelected() {
		return petsAllowedAmenityInput.isSelected();
	}
	
	@Step("Verify that pets allowed amenity is unselected")
	public boolean isPetsAllowedAmenityInputUnselected() {
		return !petsAllowedAmenityInput.isSelected();
	}
	
	@Step("Verify that hot tub amenity is selected")
	public boolean isHotTubAmenityInputSelected() {
		return hotTubAmenityInput.isSelected();
	}
	
	@Step("Verify that hot tub amenity is unselected")
	public boolean isHotTubAmenityInputUnselected() {
		return !hotTubAmenityInput.isSelected();
	}
	
	@Step("Verify that street parking amenity is selected")
	public boolean isStreetParkingAmenityInputSelected() {
		return streetParkingAmenityInput.isSelected();
	}
	
	@Step("Verify that street parking amenity is unselected")
	public boolean isStreetParkingAmenityInputUnselected() {
		return !streetParkingAmenityInput.isSelected();
	}
	
	@Step("Verify that suitable for children amenity is selected")
	public boolean isSuitableForChildrenAmenityInputSelected() {
		return suitableForChildrenAmenityInput.isSelected();
	}
	
	@Step("Verify that suitable for children amenity is unselected")
	public boolean isSuitableForChildrenAmenityInputUnselected() {
		return !suitableForChildrenAmenityInput.isSelected();
	}
	
	@Step("Clear all filters")
	public void clearAllFilters() {
		clearAllFilters.click();
	}

}
