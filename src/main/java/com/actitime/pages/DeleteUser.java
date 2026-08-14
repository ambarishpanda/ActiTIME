package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;

public class DeleteUser extends BasePage {
	
	public DeleteUser(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[text()='DELETE']")
	private WebElement deleteButton;

	public void deleteUser() {
		try {
			wait.until(ExpectedConditions.visibilityOf(deleteButton));
			deleteButton.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", deleteButton);
		}
		
		driver.switchTo().alert().accept();
	}
}
