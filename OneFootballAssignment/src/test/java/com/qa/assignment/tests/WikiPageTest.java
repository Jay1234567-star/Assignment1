package com.qa.assignment.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.assignment.utils.Constants;

public class WikiPageTest extends BaseTest {

	@Test(priority = 1)
	public void PageTitleTest() {

		String title = wikipage.getWikiPageTitle();
		System.out.println("Wiki page tite is"  + title);
		Assert.assertEquals(title, Constants.WIKI_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void wikiPageUrlTest() {

		String url= wikipage.getWikiPageUrl();
		System.out.println("Url is : "  + url);
		Assert.assertTrue(url.contains(Constants.WIKI_PAGE_URL));
	}

	@Test(priority = 3)
	public void  iSearchTextFieldPresent() {

		Assert.assertTrue(wikipage.iSSearchTextFieldPresent());

	}

	@DataProvider
	public Object [][] userSearchData(){
		return new Object[][] {

			{"Euro","EuroBasket"},
			{"UK","UK Singles Chart"},
			{"Testing","Testing effect"}

		};

	}

    
	@Test(dataProvider = "userSearchData", priority = 4)
	public void searchTest(String SearchCategory,String mainSearchData) {
		resultPage = wikipage.searchFromSuggessions(SearchCategory,mainSearchData);            
		String ActualSearchData=resultPage.searchDataIsDisplayed();

		Assert.assertEquals(ActualSearchData, mainSearchData);
	}

}
