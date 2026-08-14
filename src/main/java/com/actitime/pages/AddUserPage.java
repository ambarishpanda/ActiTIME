package com.actitime.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;
import com.actitime.utility.ExcelLibrary;

public class AddUserPage extends BasePage {

	public AddUserPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "createUserPanel_firstNameField")
	private WebElement enterFirstnameTextfield;
	
	@FindBy(id = "createUserPanel_lastNameField")
	private WebElement enterLastnameTextfield;
	
	@FindBy(id = "createUserPanel_emailField")
	private WebElement enterEmailidTextfield;
	
	@FindBy(xpath = "//div[text()='Save & Send Invitation']")
	private WebElement saveAndsendButton;
	
	@FindBy(xpath = "//div[@class='closeButton hideButton_panelContainer']")
	private WebElement crossIcon;
	
	public void enterdetails() throws IOException {
		wait.until(ExpectedConditions.visibilityOf(enterFirstnameTextfield));
		if(enterFirstnameTextfield.isDisplayed() && enterFirstnameTextfield.isEnabled()) {
//			enterFirstnameTextfield.sendKeys("Ambarish");
			enterFirstnameTextfield.sendKeys(ExcelLibrary.readData("user", 1, 0));
			System.out.println("enter firstname textfield is displayed and enabled");
		}
		else {
			System.out.println("enter firstname textfield isn't displayed and enabled");
		}
		wait.until(ExpectedConditions.visibilityOf(enterLastnameTextfield));
		if(enterLastnameTextfield.isDisplayed() && enterLastnameTextfield.isEnabled()) {
//			enterLastnameTextfield.sendKeys("panda");
			enterLastnameTextfield.sendKeys(ExcelLibrary.readData("user", 1, 1));
			System.out.println("enter lastname textfield is displayed and enabled");
		}
		else {
			System.out.println("enter lastname textfield isn't displayed and enabled");
		}
		wait.until(ExpectedConditions.visibilityOf(enterEmailidTextfield));
		if(enterEmailidTextfield.isDisplayed() && enterEmailidTextfield.isEnabled()) {
//			enterEmailidTextfield.sendKeys("ambarish@gmail.com");
			enterEmailidTextfield.sendKeys(ExcelLibrary.readData("user", 1, 3));
			System.out.println("enter email textfield is displayed and enabled");
		}
		else {
			System.out.println("enter email textfield isn't displayed and enabled");
		}
	}
	
	public void clickOnSave () throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(saveAndsendButton));
			saveAndsendButton.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", saveAndsendButton);
			Thread.sleep(3000);
		}
	}
	
	public void clickOnCrossIcon() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(crossIcon));
			crossIcon.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", crossIcon);
		}
	}
}
