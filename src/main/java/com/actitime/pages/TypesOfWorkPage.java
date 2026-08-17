package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;

public class TypesOfWorkPage extends BasePage {
	
	public TypesOfWorkPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[text()='New Type']")
	private WebElement NewTypeButton;
	
	@FindBy(xpath = "//span[text()='BRAZZERS']")
	private WebElement clickOnWorkName;
	
	@FindBy(xpath = "(//span[text()='Social Work']/../../../../../..//*[local-name()='svg'])[1]")
	private WebElement checkbox;
	
	@FindBy(xpath = "//div[@class='components-ItemListPage-BulkEditActions-triggerBody--uLs1DPdR'][normalize-space()='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//button[normalize-space()='OK, Delete']")
	private WebElement okdeleteButton;
		
	public void clickOnNewTypeButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(NewTypeButton));
			NewTypeButton.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(NewTypeButton));
			js.executeScript("arguments[0].click()", NewTypeButton);
		}
	}
	
	public void clickOnWorkName() throws InterruptedException {
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(clickOnWorkName));
			clickOnWorkName.click();
		} catch (Exception e) {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(clickOnWorkName));
			js.executeScript("arguments[0].click()", clickOnWorkName);
		}
	}
	
	public void clickOnCheckbox() {
		try {
			wait.until(ExpectedConditions.visibilityOf(checkbox));
			checkbox.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(checkbox));
			js.executeScript("arguments[0].click()", checkbox);
		}
	}
	
	public void clickOnDeleteButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(deleteButton));
			deleteButton.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(deleteButton));
			js.executeScript("arguments[0].click()", deleteButton);
		}
	}
	
	public void clickOnOkDeleteButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(okdeleteButton));
			okdeleteButton.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(okdeleteButton));
			js.executeScript("arguments[0].click()", okdeleteButton);
		}
	}
}