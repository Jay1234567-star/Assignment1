package com.qa.assignment.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.assignment.utils.ElementUtil;

public class AdvanceResultPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By resultList = By.xpath("//div[@class='mw-search-result-heading']/a");
	private List<WebElement> advSearchResultList;
	
	public AdvanceResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	private void initializeResultList() {
		if(advSearchResultList == null) {
			advSearchResultList = eleUtil.waitForElementsVisible(resultList, 5);
		}
	}

	public void verifySearchCountMoreThanZero() {
		initializeResultList();
		Assert.assertTrue(advSearchResultList.size() > 0);
		
	}
	
	public int getSearchDataListCount() {
		return eleUtil.waitForElementsVisible(resultList, 5).size();
		
	}
	
	public SearchInfoPage clickOnResultLink(String resultItem) {
		initializeResultList();
		for (WebElement e : advSearchResultList ) {
			String text = e.getText();
			System.out.println(" text Print : " + text);   
			if(text.equalsIgnoreCase(resultItem)) {
				e.click();
				break;
			}
		}
		return new SearchInfoPage(driver);
	}
}
