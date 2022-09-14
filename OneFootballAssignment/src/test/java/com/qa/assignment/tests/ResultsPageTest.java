package com.qa.assignment.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ResultsPageTest extends BaseTest {

	@Test
	public void advSearchTest () {
		advSearchPage = resultPage.doClickOnSearchIcon();
		advResPage = advSearchPage.doAdvanceSearch("testing");
		advResPage.clickOnResultLink("Software testing");
	}

}
