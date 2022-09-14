package com.qa.assignment.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.assignment.utils.Constants;

public class WikiPageTest extends BaseTest {




@Test
public void wikiPageTitleTest() {
	
	String title = wikipage.getWikiPageTitle();
	System.out.println("Wiki page tite is"  + title);
	Assert.assertEquals(title, Constants.WIKI_PAGE_TITLE);
	
}

@Test
public void wikiPageUrlTest() {
	
	String url= wikipage.getWikiPageUrl();
	System.out.println("Url is : "  + url);
	Assert.assertTrue(url.contains(Constants.WIKI_PAGE_URL));
}

@Test
public void  iSearchTextFieldPresent() {
	
	Assert.assertTrue(wikipage.iSSearchTextFieldPresent());
	
}

@DataProvider
public Object [][] userSearchData(){
	return new Object[][] {
		
		{"Euro","EuroBasket"},
		{"UK","UK Singles Chart"}
		
	};
	
}


@Test(dataProvider = "userSearchData")
public void searchTest(String SearchCategory,String mainSearchData) {
   resultPage = wikipage.searchFromSuggessions(SearchCategory,mainSearchData);
   
   Assert.assertTrue(resultPage.searchDataIsDisplayed());
}

}
