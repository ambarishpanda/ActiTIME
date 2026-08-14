package com.actitime.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.actitime.pages.CreateTypeOfWorkPage;
import com.actitime.pages.EditTypeOfWorkPage;
import com.actitime.pages.HomePage;
import com.actitime.pages.ListManagementPage;
import com.actitime.pages.TypesOfWorkPage;
import com.actitime.utility.BaseTest;

public class TC_002_LoginCreateEditDeleteWorkLogout extends BaseTest {
	
	@Test()
	public void createWork() throws InterruptedException, IOException {
		ListManagementPage listmanagementPage = new ListManagementPage(driver);
		HomePage homePage = new HomePage(driver);
		homePage.ClickOnListManagement();
		listmanagementPage.clickOnTypeOfWorkButton();
		TypesOfWorkPage workPage = new TypesOfWorkPage(driver);
		workPage.clickOnNewTypeButton();
		CreateTypeOfWorkPage createWork=new CreateTypeOfWorkPage(driver);
		createWork.enterNameTextfield();
		createWork.clickOnSaveButton();
	}
	
	@Test(dependsOnMethods = "createWork")
	public void editWork() throws AWTException, InterruptedException, IOException {
		TypesOfWorkPage workPage = new TypesOfWorkPage(driver);
		workPage.clickOnWorkName();
		EditTypeOfWorkPage editWork = new EditTypeOfWorkPage(driver);
		editWork.editName();
		editWork.clickOnSaveButton();
	}

	@Test(dependsOnMethods = "editWork")
	public void deleteWork(){
		TypesOfWorkPage workPage = new TypesOfWorkPage(driver);
		workPage.clickOnCheckbox();
		workPage.clickOnDeleteButton();
		workPage.clickOnOkDeleteButton();
		ListManagementPage listmanagementPage = new ListManagementPage(driver);
		listmanagementPage.clickOnCrossIcon();

	}
}
