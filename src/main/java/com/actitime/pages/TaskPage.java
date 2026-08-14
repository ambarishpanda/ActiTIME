package com.actitime.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;
import com.actitime.utility.ExcelLibrary;

public class TaskPage extends BasePage {
	public TaskPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='addNewButton']")
	private WebElement addNewButton;

	@FindBy(xpath = "//div[text()='New Customer']")
	private WebElement newCustomerButton;

	@FindBy(xpath = "//div[text()='Ambarish']/../..//div[@class='editButton']")
	private WebElement editButton;

	@FindBy(xpath = "(//div[@class='nameLabel'])[1]")
	private WebElement clickOnName;

	@FindBy(xpath = "//input[@placeholder='Enter Customer Name']")
	private WebElement EditName;

	@FindBy(xpath = "(//div[@class='actionButton'])[1]")
	private WebElement actionButton;

	@FindBy(xpath = "(//div[@class='deleteButton'])[1]")
	private WebElement clickonDelete;

	@FindBy(xpath = "//span[text()='Delete permanently']")
	private WebElement permanentDelete;

	public void clickOnAddNewButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(addNewButton));
			addNewButton.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", addNewButton);
		}
	}

	public void clickOnNewCustomerButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(newCustomerButton));
			newCustomerButton.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", newCustomerButton);
		}
	}

	public void clickOnEditButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", editButton);
		}
	}

	public void clickOnName() throws AWTException, InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(clickOnName));
			clickOnName.click();
			wait.until(ExpectedConditions.visibilityOf(EditName));
			EditName.clear();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", clickOnName);
			EditName.clear();
		}
//		EditName.sendKeys("Linkon");
		EditName.sendKeys(ExcelLibrary.readData("customer", 1, 1));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}

	public void deleteCustomerName() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(actionButton));
			actionButton.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", actionButton);
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(clickonDelete));
			clickonDelete.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", clickonDelete);
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(permanentDelete));
			permanentDelete.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", permanentDelete);
		}
	}
}