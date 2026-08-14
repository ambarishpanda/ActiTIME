package com.actitime.utility;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListeners implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts = (TakesScreenshot)BasePage.driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		if (result.getStatus()==2) {
			Reporter.log("testcases is failed",true);
		}
		Date date = Calendar.getInstance().getTime();
		String str = date.toString().replaceAll(":", "-");
		try {
			FileHandler.copy(file, new File("./failedScreenshot/" + str + ".png"));
		} catch (IOException e) {
			
		}
	}
}
