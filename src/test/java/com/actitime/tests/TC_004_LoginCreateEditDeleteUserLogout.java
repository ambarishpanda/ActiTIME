package com.actitime.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.actitime.pages.AddUserPage;
import com.actitime.pages.DeleteUser;
import com.actitime.pages.EditUserPage;
import com.actitime.pages.HomePage;
import com.actitime.pages.ListsOfUsersPage;
import com.actitime.utility.BaseTest;

public class TC_004_LoginCreateEditDeleteUserLogout extends BaseTest {
	
	@Test()
	public void createUser() throws InterruptedException, IOException {
		HomePage home = new HomePage(driver);
		home.ClickOnUsers();
		ListsOfUsersPage list = new ListsOfUsersPage(driver);
		list.clickOnNewUserButton();
		AddUserPage addUser = new AddUserPage(driver);
		addUser.enterdetails();
		addUser.clickOnSave();
		addUser.clickOnCrossIcon();
	}
	
	@Test(dependsOnMethods = "createUser")
	public void editUser() throws IOException {
		ListsOfUsersPage list = new ListsOfUsersPage(driver);
		list.clickOUserName();
		EditUserPage edit = new EditUserPage(driver);
		edit.editUserDetails();
	}
	
	@Test(dependsOnMethods = "editUser")
	public void deleteUser() {
		ListsOfUsersPage list = new ListsOfUsersPage(driver);
		list.clickONameForDelete();
		DeleteUser delete = new DeleteUser(driver);
		delete.deleteUser();
	}
}
