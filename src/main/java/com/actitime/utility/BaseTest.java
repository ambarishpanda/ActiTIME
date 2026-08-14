package com.actitime.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.actitime.pages.HomePage;
import com.actitime.pages.LoginPage;

public class BaseTest extends BasePage
{
	@BeforeClass
	public void setup() throws IOException {
		Properties p = new Properties();
		Reporter.log("execution happening in : " +p.getProperty("environment"),true);
		driver = new ChromeDriver();
		Reporter.log("execution happening in : " +p.getProperty("browser"),true);
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream("./src/main/resources/config.properties");
		
		p.load(fis);
		driver.get(p.getProperty("url"));
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginProcess();
	}
	
	@AfterClass
	public void teardown() {
		HomePage homePage= new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}
}
