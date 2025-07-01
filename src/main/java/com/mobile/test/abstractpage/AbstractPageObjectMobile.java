package com.mobile.test.abstractpage;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.mobile.test.ui.config.webdriver.MobileDriverInitalization;

import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractPageObjectMobile {

	protected static AndroidDriver driver;

	//protected static AppiumServerManager appiumstarter;
		
	/**
	 * Get Android Driver
	 * 
	 * @return
	 */
	public AndroidDriver getAndroidDriver() {
		return driver;
	}

	
	@Parameters("deviceTestSet")
	@BeforeTest
	public void driverDefinition(@Optional("device1") String deviceTestSet) throws MalformedURLException {
		MobileDriverInitalization driverInit = new MobileDriverInitalization(deviceTestSet);
		//AppiumServerManager.startServer();
		driver = driverInit.getWebDriver();
	}

   
	@AfterTest
	public void quitDriver() {
		//AppiumServerManager.stopServer();

		//driver.quit();
	}

}
