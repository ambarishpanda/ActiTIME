package com.actitime.utility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected static WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	
	public BasePage()
	{
		
	}
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		this.js = (JavascriptExecutor)driver;
	}
}
