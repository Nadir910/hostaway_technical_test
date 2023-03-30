package com.hostaway.abstraction;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isElementPresent(WebElement element) {
		try {
			if(element.isDisplayed()) {
				return true;
			}
		} catch(NoSuchElementException e) {

		}
		return false;
	}
	
	public void clickOnElementNTimes(WebElement element, int numberOfClick) {
		for(int i=1; i<=numberOfClick; i++) {
			try {
				element.click();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void scrollDownInsideDynamicLoadingPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
		    long lastHeight=((Number)js.executeScript("return document.body.scrollHeight")).longValue();
		    while (true) {
		        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		        Thread.sleep(2000);

		        long newHeight = ((Number)js.executeScript("return document.body.scrollHeight")).longValue();
		        if (newHeight == lastHeight) {
		            break;
		        }
		        lastHeight = newHeight;
		    }
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}
	
}
