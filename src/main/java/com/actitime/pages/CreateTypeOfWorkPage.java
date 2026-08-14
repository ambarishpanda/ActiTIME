package com.actitime.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;
import com.actitime.utility.ExcelLibrary;

public class CreateTypeOfWorkPage extends BasePage {

	public CreateTypeOfWorkPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Enter name']")
	private WebElement enterNameTextfield;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveButton;

	public void enterNameTextfield() throws IOException {
		wait.until(ExpectedConditions.visibilityOf(enterNameTextfield));
		if (enterNameTextfield.isDisplayed() && enterNameTextfield.isEnabled()) {
//			enterNameTextfield.sendKeys("BRAZZERS");
			enterNameTextfield.sendKeys(ExcelLibrary.readData("work", 1, 0));
			System.out.println("entername textfield is displayed and enabled");
		} else {
			System.out.println("entername textfield isn't displayed and enabled");
		}
	}

	public void clickOnSaveButton() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.visibilityOf(saveButton));
			saveButton.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", saveButton);
			Thread.sleep(3000);
		}
	}
}
