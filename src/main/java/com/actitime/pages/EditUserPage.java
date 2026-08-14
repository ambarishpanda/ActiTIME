package com.actitime.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;
import com.actitime.utility.ExcelLibrary;

public class EditUserPage extends BasePage {
	
	public EditUserPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "(//input[@placeholder='First Name'])[2]")
	private WebElement firstnameTextfield;
	
	@FindBy(xpath = "(//input[@placeholder='Last Name'])[2]")
	private WebElement lastnameTextfield;
	
	@FindBy(xpath = "(//input[@placeholder='Username'])[1]")
	private WebElement usernameTextfield;
	
	@FindBy(xpath = "(//input[@placeholder='Email'])[2]")
	private WebElement emailTextfield;
	
	@FindBy(xpath = "//div[@class='edit_user_sliding_panel sliding_panel components_panelContainer components_panelContainer_open']//div[@class='hideButton_panelContainer']")
	private WebElement crossIcon;
	
	public void editUserDetails() throws IOException {
		
		wait.until(ExpectedConditions.visibilityOf(firstnameTextfield));
		firstnameTextfield.sendKeys(Keys.CONTROL, "a");
		if(firstnameTextfield.isDisplayed() && firstnameTextfield.isEnabled()) {
//			firstnameTextfield.sendKeys("Alicent");
			firstnameTextfield.sendKeys(ExcelLibrary.readData("user", 2, 0));
			System.out.println("enter firstname textfield is displayed and enabled");
		}
		else {
			System.out.println("enter firstname textfield isn't displayed and enabled");
		}
		wait.until(ExpectedConditions.visibilityOf(lastnameTextfield));
		lastnameTextfield.sendKeys(Keys.CONTROL, "a");
		if(lastnameTextfield.isDisplayed() && lastnameTextfield.isEnabled()) {
//			lastnameTextfield.sendKeys("Hightower");
			lastnameTextfield.sendKeys(ExcelLibrary.readData("user", 2, 1));
			System.out.println("enter lastname textfield is displayed and enabled");
		}
		else {
			System.out.println("enter lastname textfield isn't displayed and enabled");
		}
		wait.until(ExpectedConditions.visibilityOf(usernameTextfield));
		usernameTextfield.sendKeys(Keys.CONTROL, "a");
		if(usernameTextfield.isDisplayed() && usernameTextfield.isEnabled()) {
//			usernameTextfield.sendKeys("alicenthightower");
			usernameTextfield.sendKeys(ExcelLibrary.readData("user", 2, 2));
			System.out.println("enter email textfield is displayed and enabled");
		}
		else {
			System.out.println("enter email textfield isn't displayed and enabled");
		}
		wait.until(ExpectedConditions.visibilityOf(emailTextfield));
		emailTextfield.sendKeys(Keys.CONTROL, "a");
		if(emailTextfield.isDisplayed() && emailTextfield.isEnabled()) {
//			emailTextfield.sendKeys("alicent@gmail.com");
			emailTextfield.sendKeys(ExcelLibrary.readData("user", 2, 3));
			System.out.println("enter email textfield is displayed and enabled");
		}
		else {
			System.out.println("enter email textfield isn't displayed and enabled");
		}
		
		try {
			wait.until(ExpectedConditions.visibilityOf(crossIcon)).click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", crossIcon);
		}
	}
}
