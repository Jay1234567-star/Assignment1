package com.qa.assignment.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.assignment.utils.Constants;
import com.qa.assignment.utils.ElementUtil;

public class AdvanceSearchPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By advSearchBox = By.name("search");
	private By advSearchIcon = By.id("searchButton");
	private By advSearchdropdown = By.xpath("//span[@class='oo-ui-indicatorElement-indicator oo-ui-indicator-down']//parent::a[@role='button']/parent::span[@class='mw-advancedSearch-expandablePane-button oo-ui-widget oo-ui-widget-enabled oo-ui-buttonElement oo-ui-buttonElement-framed oo-ui-indicatorElement oo-ui-labelElement oo-ui-buttonWidget']/parent::div[@class='oo-ui-widget oo-ui-widget-enabled mw-advancedSearch-expandablePane-options']");

	private By thesewordTextEntry = By.xpath("//div[@id='advancedSearchField-plain']//child::input[@type ='text']");
	private By searchList = By.xpath("//div[@class='mw-search-result-heading']/a");
	private By searchButton = By.xpath("//button[@type = 'submit']");
	private By searchDataIsDisplayed = By.xpath("//p[@class = \"mw-search-exists\"]//a");

	public AdvanceSearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAdvanceSearchUrl(){
		return eleUtil.waitForUrlContains(Constants.ADVANCE_SEARCH_PAGE_URL,Constants.DEFAULT_TIME_OUT);
	}

	public AdvanceResultPage doAdvanceSearch(String value) {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		WebElement searchDropdown = eleUtil.waitForElementVisible(advSearchdropdown, 5000);	
		searchDropdown.click();

		WebElement theseWordField = eleUtil.waitForElementVisible(thesewordTextEntry, 5000);

		theseWordField.sendKeys(value);
		eleUtil.doClick(searchButton);
		
		return new AdvanceResultPage(driver);
	}
}
