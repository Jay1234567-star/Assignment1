package com.qa.assignment.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ResultsPageTest extends BaseTest {

	@DataProvider
	public Object [][] AdvanceSearchData(){
		return new Object[][] {
			{"testing"},
			{"Java"}
		};
	}

	@Test(dataProvider = "AdvanceSearchData")
	public void advSearchTest (String searchDataName) {
		advSearchPage = resultPage.doClickOnSearchIcon();
		advResPage = advSearchPage.doAdvanceSearch(searchDataName);
		Assert.assertTrue(advResPage.getSearchDataListCount()>0);
		//advResPage.clickOnResultLink("Software testing");
	}



	@DataProvider
	public Object [][] selectSearchData(){
		return new Object[][] {
			{"testing","Software testing"},
			{"Java","Java"}
		};
	}


	@Test(dataProvider = "selectSearchData")
	public void clickOnSearchLink(String searchDataName,String searchLink) {
		advSearchPage = resultPage.doClickOnSearchIcon();
		advResPage = advSearchPage.doAdvanceSearch(searchDataName);
		advResPage.clickOnResultLink(searchLink);
		String ActualSearchData= searchInfoPage.searchDataIsDisplayed();
		Assert.assertEquals(ActualSearchData, searchLink);
	}
}
