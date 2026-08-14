package com.actitime.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;
import com.actitime.utility.ExcelLibrary;


public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "username")
	private WebElement usernameTextBox;

	@FindBy(name = "pwd")
	private WebElement passwordTextBox;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	@FindBy(id = "toPasswordRecoveryPageLink")
	private WebElement ForgotYourPasswordHyperLink;

	@FindBy(id = "keepLoggedInCheckBox")
	private WebElement KeepMeLoggedInCheckBox;

	@FindBy(xpath = "//div[@class='atLogoImg']")
	private WebElement appLogo;

	@FindBy(xpath = "//div[@class='atLogoImg']")
	private WebElement appName;

	@FindBy(xpath = "//nobr[text()='actiTIME 2026']")
	private WebElement appVersion;

	@FindBy(xpath = "//a[text()='actiTIME Inc.']")
	private WebElement copyRightLink;

	public void loginProcess() throws IOException {
		wait.until(ExpectedConditions.visibilityOf(usernameTextBox));
		if (usernameTextBox.isDisplayed() && usernameTextBox.isEnabled()) {
			System.out.println("username element is displayed and enabled");
			usernameTextBox.sendKeys(ExcelLibrary.readData("login", 1, 0));
		} else {
			System.out.println("username textbox is not displayed or enabled");
		}

		wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
		if (passwordTextBox.isDisplayed() && passwordTextBox.isEnabled()) {
			System.out.println("password textbox is displayed and enabled");
			passwordTextBox.sendKeys(ExcelLibrary.readData("login", 1, 1));
		} else {
			System.out.println("password element is not displayed or enabled");
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(KeepMeLoggedInCheckBox));
			if (KeepMeLoggedInCheckBox.isDisplayed() && KeepMeLoggedInCheckBox.isEnabled()) {
				System.out.println("keepme logged in checkbox is displayed and enabled");
				KeepMeLoggedInCheckBox.click();
				wait.until(ExpectedConditions.elementToBeSelected(KeepMeLoggedInCheckBox));
				System.out.println("keepme loggedin checkbox is selected :" + KeepMeLoggedInCheckBox.isSelected());
			} else {
				System.out.println("keepmelogged in checkbox is not displayed or enabled");
			}
		} catch (Exception e) {
			if (KeepMeLoggedInCheckBox.isDisplayed() && KeepMeLoggedInCheckBox.isEnabled()) {
				js.executeScript("arguments[0].click()", KeepMeLoggedInCheckBox);
			} else {
				System.out.println("keepmelogged in checkbox is not displayed or enabled");
			}
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(loginButton));
			loginButton.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", loginButton);
		}
	}
}