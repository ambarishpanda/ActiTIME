package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;

public class ListsOfUsersPage extends BasePage {

	
	public ListsOfUsersPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[text()='New User']")
	private WebElement newUserButton;
	
	@FindBy(xpath = "//span[text()='panda, Ambarish']")
	private WebElement UserName;
	
	@FindBy(xpath = "//span[text()='Hightower, Alicent']")
	private WebElement clickName;
	
	public void clickOnNewUserButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(newUserButton));
			newUserButton.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", newUserButton);
		}
	}
	
	public void clickOUserName() {
		try {
			wait.until(ExpectedConditions.visibilityOf(UserName));
			UserName.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(UserName));
			js.executeScript("arguments[0].click()", UserName);
		}
	}
	
	public void clickONameForDelete() {
		try {
			wait.until(ExpectedConditions.visibilityOf(clickName));
			clickName.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(clickName));
			js.executeScript("arguments[0].click()", clickName);
		}
	}
}
