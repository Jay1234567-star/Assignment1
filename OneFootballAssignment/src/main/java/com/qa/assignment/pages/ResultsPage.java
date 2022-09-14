package com.qa.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.assignment.utils.ElementUtil;

public class ResultsPage {
	

private WebDriver driver ;
private ElementUtil eleUtil;


private By searchData = By.xpath("//h1[@id ='firstHeading']/span");
private By searchList = By.xpath("//ul[@class='mw-search-results']//a");
private By searchIcon = By.id("searchButton");
private By searchBox = By.name("search");


public ResultsPage(WebDriver driver){
	this.driver = driver;
	eleUtil = new ElementUtil(driver); 		
	
}


public boolean searchDataIsDisplayed() {
	
 return	eleUtil.doIsDisplayed(searchData);
}

public AdvanceSearchPage doClickOnSearchIcon() {
	  WebElement searchTextField =  eleUtil.getElement(searchBox);
	  if(searchTextField != null) {
		  String SearchText = searchTextField.getText();
		  searchTextField.clear();
		  eleUtil.doClick(searchIcon);
	  }
 
 return new AdvanceSearchPage(driver);
}




}
