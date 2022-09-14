package com.qa.assignment.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
   public WebDriver	driver;	
   public Properties prop;
   public static String highlight;

   public WebDriver init_driver(Properties prop) {
	   
	   /** this method is used to initialize the driver using browser Name 
	    *  @Param browserName
	    *  @return this returns the web driver
	    * 
	    */
	   String browserName = prop.getProperty("browser").trim();
	   System.out.println("browser Name is :"+ browserName);
	   
	   if(browserName.equalsIgnoreCase("Chrome")) {
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
	   	}
	   
	   else if(browserName.equalsIgnoreCase("Firefox")){
		   WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();
	   }
	   else {
		   System.out.println("Please pass the correct brower Name"  + browserName);
	   }
	    
	   
	   driver.manage().deleteAllCookies();
	   driver.manage().window().maximize();
	   driver.get(prop.getProperty("url").trim());
	   return driver;
   } 

   public Properties init_prop(){
	   
	  prop = new Properties(); 
      try {
		FileInputStream ip = new FileInputStream("./src/test_resources/configue/configue.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return prop;
	  
   
   
   }

}
