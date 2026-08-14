package com.actitime.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;
import com.actitime.utility.ExcelLibrary;

public class CreateLeaveTypePage extends BasePage {

	public CreateLeaveTypePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder='Enter name']")
	private WebElement enternameTextfield;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement saveButton;
	
	public void enterName() throws IOException {
		wait.until(ExpectedConditions.visibilityOf(enternameTextfield));
		if(enternameTextfield.isDisplayed() && enternameTextfield.isEnabled()) {
//			enternameTextfield.sendKeys("Honeymoon");
			enternameTextfield.sendKeys(ExcelLibrary.readData("leave", 1, 0));
			System.out.println("entername textfield is displayed and enabled");
		}
		else {
			System.out.println("entername textfield isn't displayed and enabled");
		}
	}
	public void clickOnSaveButton() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			saveButton.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", saveButton);
			Thread.sleep(2000);
		}
	}
}
