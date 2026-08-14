package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;

public class LeaveTypesPage extends BasePage {
	
	public LeaveTypesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[text()='New Type']")
	private WebElement NewTypeButton;
	
	@FindBy(xpath = "//span[text()='Honeymoon']")
	private WebElement clickOnLeaveName;
	
	@FindBy(xpath = "(//span[text()='Goa Trip']/../../../../../..//*[local-name()='svg'])[4]")
	private WebElement ThreeDotIcon;
	
	@FindBy(xpath = "//span[text()='Delete']")
	private WebElement deleteIcon;
	
	@FindBy(xpath = "//button[text()='OK, Delete']")
	private WebElement OkDeleteButton;
	
	public void clickOnNewTypeButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(NewTypeButton));
			NewTypeButton.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", NewTypeButton);
		}
	}
	
	public void clickOnLeaveName() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(clickOnLeaveName));
			clickOnLeaveName.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", clickOnLeaveName);
			Thread.sleep(2000);
		}
	}
	public void clickOnThreeDotIcon() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ThreeDotIcon));
			ThreeDotIcon.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", ThreeDotIcon);
		}
	}
	
	public void clickOnDeleteIcon() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(deleteIcon));
			deleteIcon.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", deleteIcon);
		}
	}
	
	public void clickOnOkDeleteButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(OkDeleteButton));
			OkDeleteButton.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", OkDeleteButton);
		}
	}

}
