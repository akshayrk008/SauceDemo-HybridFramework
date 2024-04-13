package com.browserOperations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.saucedemo.configurations.ImplicitWaitTimeReader;
import com.saucedemo.configurations.URLReader;

public class BaseClass {
	
	public WebDriver driver = null;
	
	@BeforeClass
	public void openBrowser() {
		
		driver = WebDriverCreation.getWebDriver();
		driver.manage().window().maximize();
		driver.get(URLReader.getApplicationURL());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ImplicitWaitTimeReader.getImplicitWaitTime()));
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	

}
