package com.saucedemo.io.operations;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class IO_Operations {

	WebDriver driver;

	public IO_Operations(WebDriver driver) {
		this.driver = driver;
	}

	public void sendData(By Loc, String variable) {
		driver.findElement(Loc).sendKeys(variable);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public boolean isElementPresent(By loc) {

		try {
			driver.findElement(loc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	public void selectoptionByText(By Loc, String VisibleText) {

		WebElement element = driver.findElement(Loc);

		Select select = new Select(element);
		select.deselectByVisibleText(VisibleText);

	}

	public int selectoptionByIndex(By Loc, int count) {

		WebElement element = driver.findElement(Loc);

		Select select = new Select(element);
		select.selectByIndex(count);
		return 0;

	}

	public void clickOnElement(By loc) {
		driver.findElement(loc).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
	
	public String GetText(By Loc) {
		try {
		return driver.findElement(Loc).getText();
		
		}catch (Error e) {
			throw new RuntimeErrorException(e);
		}
		
	}

}
