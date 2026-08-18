package com.actitime.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;
import com.actitime.utility.ExcelLibrary;

public class EditTypeOfWorkPage extends BasePage {
	
	public EditTypeOfWorkPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Enter name']")
	private WebElement editWorkName;
	
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveButton;
	
	public void editName() throws AWTException, IOException, InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(editWorkName));
		editWorkName.sendKeys(Keys.CONTROL,"a");
		editWorkName.sendKeys(Keys.BACK_SPACE);
		editWorkName.sendKeys(ExcelLibrary.readData("work", 1, 1));
	}
	
	public void clickOnSaveButton() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.visibilityOf(saveButton));
			saveButton.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(saveButton));
			js.executeScript("arguments[0].click()", saveButton);
			Thread.sleep(2000);
		}
	}
}
