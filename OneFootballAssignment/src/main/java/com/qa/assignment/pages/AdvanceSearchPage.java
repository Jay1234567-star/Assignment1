package com.qa.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.assignment.utils.Constants;
import com.qa.assignment.utils.ElementUtil;

public class AdvanceSearchPage {

private WebDriver driver;
private ElementUtil eleUtil;


private By advSearchBox = By.name("search");
private By advSearchIcon = By.id("searchButton");
private By advsearchdropdown = By.xpath("//span[@class = 'oo-ui-indicatorElement-indicator oo-ui-indicator-down']//parent::a[@role = 'button']/parent::span[@class='mw-advancedSearch-expandablePane-button oo-ui-widget oo-ui-widget-enabled oo-ui-buttonElement oo-ui-buttonElement-framed oo-ui-indicatorElement oo-ui-labelElement oo-ui-buttonWidget']/parent::div[@class='oo-ui-widget oo-ui-widget-enabled mw-advancedSearch-expandablePane-options']");

private By thesewordTextEntry = By.

public AdvanceSearchPage(WebDriver driver) {
	// TODO Auto-generated constructor stub

	this.driver = driver;
	eleUtil = new ElementUtil(driver);


}
	
public String getAdvanceSearchUrl(){
		   
	return eleUtil.waitForUrlContains(Constants.ADVANCE_SEARCH_PAGE_URL,Constants.DEFAULT_TIME_OUT);
	   
}
	
	
	
public void doAdvanceSearch() {
	
eleUtil.doClick(advsearchdropdown);
	
	
	
}





















}
