package com.browserOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.saucedemo.configurations.BrowserTypeReader;

public class WebDriverCreation {
	
	public static WebDriver getWebDriver() {
        String browserType = BrowserTypeReader.getBrowserType().toLowerCase();

        switch (browserType) {
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
                return new ChromeDriver();
            case "Edge":
            	return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
    }

	
	

}
