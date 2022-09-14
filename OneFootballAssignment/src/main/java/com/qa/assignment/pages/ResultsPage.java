package com.qa.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.assignment.utils.ElementUtil;

public class ResultsPage {

	private WebDriver driver ;
	private ElementUtil eleUtil;

	private By searchResult = By.xpath("//h1[@id ='firstHeading']/span");
	private By searchList = By.xpath("//ul[@class='mw-search-results']//a");
	private By searchIcon2 = By.id("searchButton");
	private By searchBox = By.name("search");

	public ResultsPage(WebDriver driver){
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String searchDataIsDisplayed() {
		WebElement searchData = eleUtil.waitForElementPresenceWithFluentWait(searchResult, 5000, 2);
		String ActualSearchData=searchData.getText();
		System.out.println("actual search data is" + ActualSearchData);

		return ActualSearchData;
	}

	public AdvanceSearchPage doClickOnSearchIcon() {
		System.out.println("Test");
		WebElement searchTextField =  eleUtil.getElement(searchBox);
		if(searchTextField != null) {
			searchTextField.clear();
			eleUtil.doClick(searchIcon2);
		}

		return new AdvanceSearchPage(driver);
	}

}
