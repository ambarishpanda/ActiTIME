package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;

public class ListManagementPage extends BasePage {

	public ListManagementPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='Types of Work']")
	private WebElement typesOfWorkButton;

	@FindBy(xpath = "//span[text()='Leave Types']")
	private WebElement leaveTypeButton;
	
	@FindBy(xpath = "//*[local-name()='svg' and @class='components-Modal-closeIcon--KQNmTbOj']")
	private WebElement crossIcon;
	
	public void clickOnTypeOfWorkButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(typesOfWorkButton));
			typesOfWorkButton.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(typesOfWorkButton));
			js.executeScript("arguments[0].click()", typesOfWorkButton);
		}
	}	
	
	public void clickOnLeaveTypes() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(leaveTypeButton));
			leaveTypeButton.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(leaveTypeButton));
			js.executeScript("arguments[0].click()", leaveTypeButton);
		}
	}
	
	public void clickOnCrossIcon() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(crossIcon));
			crossIcon.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(crossIcon));
			js.executeScript("arguments[0].click()", crossIcon);
		}
	}
}
