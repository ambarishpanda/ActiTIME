package com.actitime.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.actitime.pages.CreateNewCustomerPage;
import com.actitime.pages.HomePage;
import com.actitime.pages.LoginPage;
import com.actitime.pages.TaskPage;
import com.actitime.utility.BaseTest;

public class TC_001_LoginCreateEditDeleteCustomerLogout extends BaseTest {

	@Test()
	public void createCustomer() throws IOException {
		HomePage homePage= new HomePage(driver);
		homePage.clickOnTask();
		TaskPage taskpage = new TaskPage(driver);
		taskpage.clickOnAddNewButton();
		taskpage.clickOnNewCustomerButton();
		CreateNewCustomerPage customerpage = new CreateNewCustomerPage(driver);
		customerpage.EnterCustomerName();
		customerpage.clickOnCreateCustomerButton();
	}

	@Test(dependsOnMethods = "createCustomer")
	public void editCustomer() throws AWTException, InterruptedException, IOException {
		TaskPage taskpage = new TaskPage(driver);
		taskpage.clickOnEditButton();
		taskpage.clickOnName();
	}

	@Test(dependsOnMethods = "editCustomer")
	public void deleteCustomer() {
		TaskPage taskpage = new TaskPage(driver);
		taskpage.deleteCustomerName();
	}
}