package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.actitime.utility.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='Tasks']")
	private WebElement tasks;

	@FindBy(xpath = "//span[text()='List Management']")
	private WebElement listMangement;
	
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement users;
	
	@FindBy(xpath = "//div[@class='pages-navigation-Popups-ProfilePopup-userProfileButton--A8YEuKGx']")
	private WebElement profile;
	
	@FindBy(xpath = "//div[text()='Logout']")
	private WebElement logoutLink;

	public void clickOnTask() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tasks));
			tasks.click();
			wait.until(ExpectedConditions.titleIs("actiTIME - Task List"));
			if (driver.getTitle().equals("actiTIME - Task List")) {
				System.out.println("navigated to task page");
				
			} else {
				System.out.println("not navigated to task page");
			}
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", tasks);
			if (driver.getTitle().equals("actiTIME - Task List")) {
				System.out.println("navigated to task page");
			} else {
				System.out.println("not navigated to task page");
			}
		}
	}

	public void ClickOnListManagement() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(listMangement));
			listMangement.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", listMangement);
		}
	}
	public void ClickOnUsers() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(users));
			users.click();
			wait.until(ExpectedConditions.titleIs("actiTIME - User List"));
			if (driver.getTitle().equals("actiTIME - User List")) {
				System.out.println("navigated to User page");
				
			} else {
				System.out.println("not navigated to User page");
			}
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", users);
			wait.until(ExpectedConditions.titleIs("actiTIME - User List"));
			if (driver.getTitle().equals("actiTIME - User List")) {
				System.out.println("navigated to User page");
				
			} else {
				System.out.println("not navigated to User page");
			}
		}
	}
	public void clickOnLogout() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(profile));
			profile.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", profile);
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
			logoutLink.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", logoutLink);
		}
	}
}