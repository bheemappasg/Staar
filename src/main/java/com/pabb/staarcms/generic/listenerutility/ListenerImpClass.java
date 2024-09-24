package com.pabb.staarcms.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pabb.staarcms.generic.baseutility.BaseClass;
import com.pabb.staarcms.generic.webdriverutility.UtilityClassObject;
/**
 *@author bheem
 *This class contains methods likes onStart,onFinish,onTeststart,onTestsuccessand and onTestfailure 
 * 
 */
public class ListenerImpClass  extends BaseClass implements ITestListener,ISuiteListener{
	  public static ExtentTest test;
		 public ExtentReports report;
	@Override
	/*This method is used for writing extentSparkeReporter and ExtentReports  */
	public void onStart(ISuite suite) {
	
		Reporter.log("report config");
		String sysTime= new Date().toString().replace(":","_").replace(" ","_");
		
		//spark report config
		ExtentSparkReporter spark=new  ExtentSparkReporter("./ExtentReport/report_"+sysTime+".html");
		spark.config().setDocumentTitle("CMC Test Suite Result");
		spark.config().setReportName("CMS Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information & create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log(" Report Backup ");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"===>start===>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("====="+ result.getMethod().getMethodName()+"===end====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"===>completed===>");
	}

	/*this method is used for take screen shot whenever test case get fail  */
	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot t =(TakesScreenshot)UtilityClassObject.getDriver();
		String filepath = t.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		 
		 test.addScreenCaptureFromBase64String(filepath, testName+"_"+time);
		 test.log(Status.FAIL, result.getMethod().getMethodName()+"===>failed===>");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}
	
	

}
