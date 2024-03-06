package com.saucedemo.browser.configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.saucedemo.fileconfiguration.FileReaderManager;

public class WebDriverManager {
	
	private WebDriver driver;
	private static BrowserType browserType;

	public WebDriverManager() {
		browserType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		
	}

	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {    
	         driver = createMyDriver();
	        	
	       
		   return driver;
	}



	private WebDriver createMyDriver() {
        switch (browserType) {	    
        case FIREFOX : driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	driver = new ChromeDriver();
    		break;
        case EDGE : driver = new EdgeDriver();
    		break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	

	

}
