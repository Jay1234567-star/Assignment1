package com.qa.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.assignment.utils.ElementUtil;

public class SearchInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
 
   private By searchResult = By.xpath("//h1[@id ='firstHeading']/span");


public SearchInfoPage(WebDriver driver){
	this.driver = driver;
	eleUtil = new ElementUtil(driver);

}



public String searchDataIsDisplayed() {
	WebElement searchInfoData = eleUtil.waitForElementPresenceWithFluentWait(searchResult, 5000, 2);
	String ActualSearchData=searchInfoData.getText();
	System.out.println("actual search data is" + ActualSearchData);

	return ActualSearchData;
}

}