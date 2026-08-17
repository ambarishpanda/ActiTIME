package com.actitime.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;
import com.actitime.utility.ExcelLibrary;

public class EditLeaveTypePage extends BasePage {
	
	public EditLeaveTypePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder='Enter name']")
	private WebElement editLeaveTypeName;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement saveButton;
	
	public void editLeaveName() throws AWTException, IOException, InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(editLeaveTypeName));
		editLeaveTypeName.clear();
//		Robot robo = new Robot();
//		robo.keyPress(KeyEvent.VK_CONTROL);
//		robo.keyPress(KeyEvent.VK_A);
//		robo.keyRelease(KeyEvent.VK_CONTROL);
//		robo.keyRelease(KeyEvent.VK_A);
//		robo.keyPress(KeyEvent.VK_BACK_SPACE);
//		robo.keyRelease(KeyEvent.VK_BACK_SPACE);
//		editLeaveTypeName.sendKeys("Goa Trip");
		Thread.sleep(3000);
		editLeaveTypeName.sendKeys(ExcelLibrary.readData("leave", 1, 1));
	}
	
	public void clickOnSaveButton() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			saveButton.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			js.executeScript("arguments[0].click()", saveButton);
			Thread.sleep(3000);
		}
	}
}
