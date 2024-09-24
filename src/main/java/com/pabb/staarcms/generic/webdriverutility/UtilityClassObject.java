package com.pabb.staarcms.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	public static ThreadLocal<ExtentTest>test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver>sdriver=new ThreadLocal<WebDriver>();
	
	public static ExtentTest getText() {
		return test.get();
	}
	public static void setTest(ExtentTest actTest)
	{
		test.set(actTest);
	}
	public static WebDriver getDriver() {
		return sdriver.get();
	}
	public static void setDriver(WebDriver actDriver)
	{
		sdriver.set(actDriver);
	}
}
