package org.myautomation.template.custom_listener;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

public class CustomListener implements ITestListener {
	
	WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Started: "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: "+result.getName());
		TakesScreenshot screen= (TakesScreenshot)driver;
		File srcFile= screen.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\ScreensFailed\\"+result.getTestName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("New Test Started:\nTestName: "+context.getName()+"\n Started on: "+context.getStartDate());
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Ended: \nTestName: "+context.getName()+"\n Finished on: "+context.getEndDate());
	}

}
