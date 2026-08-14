package com.actitime.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;
import com.actitime.utility.ExcelLibrary;

public class CreateNewCustomerPage extends BasePage {

	public CreateNewCustomerPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement EnterCustomerTextfield;

	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement CreateCustomerButton;

	public void EnterCustomerName() throws IOException {
		wait.until(ExpectedConditions.visibilityOf(EnterCustomerTextfield));
//		EnterCustomerTextfield.sendKeys("Ambarish");
		EnterCustomerTextfield.sendKeys(ExcelLibrary.readData("customer", 1, 0));
	}

	public void clickOnCreateCustomerButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CreateCustomerButton));
			CreateCustomerButton.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", CreateCustomerButton);
		}
	}
}