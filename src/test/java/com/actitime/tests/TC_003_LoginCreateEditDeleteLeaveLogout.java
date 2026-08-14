package com.actitime.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.actitime.pages.CreateLeaveTypePage;
import com.actitime.pages.EditLeaveTypePage;
import com.actitime.pages.HomePage;
import com.actitime.pages.LeaveTypesPage;
import com.actitime.pages.ListManagementPage;
import com.actitime.utility.BaseTest;

public class TC_003_LoginCreateEditDeleteLeaveLogout extends BaseTest {

	@Test()
	public void createLeave() throws InterruptedException, IOException {
		ListManagementPage listmanagementPage = new ListManagementPage(driver);
		HomePage homePage = new HomePage(driver);
		homePage.ClickOnListManagement();
		listmanagementPage.clickOnLeaveTypes();
		LeaveTypesPage leavePage = new LeaveTypesPage(driver);
		leavePage.clickOnNewTypeButton();
		CreateLeaveTypePage createleave = new CreateLeaveTypePage(driver);
		createleave.enterName();
		createleave.clickOnSaveButton();
	}
	
	@Test(dependsOnMethods = "createLeave")
	public void editLeave() throws AWTException, InterruptedException, IOException {
		LeaveTypesPage leavepage = new LeaveTypesPage(driver);
		leavepage.clickOnLeaveName();
		EditLeaveTypePage editleave = new EditLeaveTypePage(driver);
		editleave.editLeaveName();
		editleave.clickOnSaveButton();
	}
	
	@Test(dependsOnMethods = "editLeave")
	public void deleteLeave() {	
		LeaveTypesPage leavepage = new LeaveTypesPage(driver);
		leavepage.clickOnThreeDotIcon();
		leavepage.clickOnDeleteIcon();
		leavepage.clickOnOkDeleteButton();
		ListManagementPage list = new ListManagementPage(driver);
		list.clickOnCrossIcon();
	}
}
