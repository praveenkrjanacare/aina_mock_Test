package com.mobile.test.ui.config.webdriver;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.mobile.test.ui.config.driver.BrowserType;
import com.mobile.test.ui.config.driver.webdriverdef.AndroidDrierDef;
import com.mobile.test.ui.config.system.GetSystemProperty;

import io.appium.java_client.android.AndroidDriver;

public class MobileDriverInitalization {

	private String testDeviceAndServerDetails;

	public MobileDriverInitalization(String testDeviceAndServerDetailsSet) {
		Reporter.log(testDeviceAndServerDetailsSet);
		testDeviceAndServerDetails = testDeviceAndServerDetailsSet;
		Reporter.log(testDeviceAndServerDetails);
	}

	/*
	 * launch driver based on run time parameters from pom.xml Default driver :
	 * Android
	 */
	public AndroidDriver getWebDriver() {
		if (BrowserType.Android.toString().equalsIgnoreCase(GetSystemProperty.getBrowserName().toString())) {
			AndroidDrierDef androidDriverDef = new AndroidDrierDef(testDeviceAndServerDetails);
			androidDriverDef.setWebDriver();
			return (AndroidDriver) androidDriverDef.getWebDriver();
		} else {
			AndroidDrierDef androidDriverDef = new AndroidDrierDef(testDeviceAndServerDetails);
			androidDriverDef.setWebDriver();
			return (AndroidDriver) androidDriverDef.getWebDriver();
		}
	}

	/*
	 * launch driver
	 */
	public WebDriver getWebDriver(String browserName) {
		if (BrowserType.Android.toString().equalsIgnoreCase(GetSystemProperty.getBrowserName().toString())) {
			AndroidDrierDef androidDriverDef = new AndroidDrierDef(testDeviceAndServerDetails);
			androidDriverDef.setWebDriver();
			return androidDriverDef.getWebDriver();
		} else {
			AndroidDrierDef androidDriverDef = new AndroidDrierDef(testDeviceAndServerDetails);
			androidDriverDef.setWebDriver();
			return androidDriverDef.getWebDriver();
		}
	}
}
