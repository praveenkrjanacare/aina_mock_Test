package com.aina.test.extent.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.mobile.test.config.screenshot.BrowserScreenShot;

public class GenerateExtentReport extends TDIPageObjectsAdmin implements ITestListener {
	ForDriver exconfig = new ForDriver();

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test : [" + result.getMethod().getMethodName() + "]"));
		// create teste with respective name
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getDescription());
		test.log(Status.PASS, "*** Test case : " + result.getMethod().getMethodName() + " is passed ***");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getDescription());
		test.log(Status.FAIL, "*** Test case : " + result.getMethod().getMethodName() + " is failed ***");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(
				BrowserScreenShot.takeScreenShot(result.getMethod().getMethodName(), exconfig.getandroiddriver()));	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getDescription());
		test.log(Status.SKIP, "*** Test case : " + result.getMethod().getMethodName() + " is skipped *** ");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		// setUp method call
		System.out.println("*** Test Suite " + context.getName() + " started ***");
		ExtentConfig.setupExtent();
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		// close extent report
		extent.flush();
	}

}
