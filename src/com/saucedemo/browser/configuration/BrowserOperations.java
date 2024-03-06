package com.saucedemo.browser.configuration;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.xml.XmlMethodSelector;

import com.saucedemo.consts.Constants;
import com.saucedemo.fileconfiguration.FileReaderManager;

public class BrowserOperations {
	
	public WebDriver driver;
	WebDriverManager webdrivermanager;
	private String sTestCaseName;
	
	private String currentTestMethod;

	private int iTestCaseRow;
	
	@BeforeMethod
	public void setCurrentTestMethod(ITestContext context) {
        currentTestMethod = context.getName();
    }
	
	@BeforeClass
	public void OpenBrowser() {
		webdrivermanager = new WebDriverManager();
		driver = webdrivermanager.getDriver();
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
	}
}
