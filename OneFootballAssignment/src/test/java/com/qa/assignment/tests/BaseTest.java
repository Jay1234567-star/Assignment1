package com.qa.assignment.tests;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.*;
import com.qa.assignment.factory.DriverFactory;
import com.qa.assignment.pages.AdvanceResultPage;
import com.qa.assignment.pages.AdvanceSearchPage;
import com.qa.assignment.pages.ResultsPage;
import com.qa.assignment.pages.SearchInfoPage;
import com.qa.assignment.pages.WikiPage;


public class BaseTest {
	WebDriver driver ;
	DriverFactory df ; 
	Properties prop;

	WikiPage wikipage ;
	ResultsPage resultPage; 
	ResultsPage resultPage1;
	AdvanceSearchPage advSearchPage;
	AdvanceResultPage advResPage;
	SearchInfoPage searchInfoPage;

	@BeforeTest 
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();

		driver = df.init_driver(prop);
		wikipage = new WikiPage(driver);
		advSearchPage = new AdvanceSearchPage(driver);
		resultPage = new ResultsPage(driver);
		searchInfoPage = new SearchInfoPage(driver);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
