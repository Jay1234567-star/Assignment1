package com.qa.assignment.tests;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.*;
import com.qa.assignment.factory.DriverFactory;
import com.qa.assignment.pages.ResultsPage;
import com.qa.assignment.pages.WikiPage;


public class BaseTest {

WebDriver driver ;
DriverFactory df ; 
Properties prop;


WikiPage wikipage ;
ResultsPage resultPage; 
ResultsPage resultPage1;

@BeforeTest 
public void setup() {
	
	df = new DriverFactory();
	prop =df.init_prop();
	
	driver = df.init_driver(prop);
	wikipage = new WikiPage(driver);
	
}



@AfterTest

public void teardown() {
	driver.quit();
}


}
