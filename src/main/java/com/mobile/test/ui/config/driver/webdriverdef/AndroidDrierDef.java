package com.mobile.test.ui.config.driver.webdriverdef;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.mobile.test.config.MobileTestProperties;
import com.mobile.test.ui.config.driver.AbstractWebDriver;
import com.mobile.test.ui.util.ConstantParametersSetup;
import com.mobile.test.ui.util.Util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDrierDef extends AbstractWebDriver {

	DesiredCapabilities des = new DesiredCapabilities();
	private String appiumURL;

	// capture required device details as desired capabilities from Android test
	// properties
	public AndroidDrierDef(String testDeviceAndServerDetails) {

		System.out.println(testDeviceAndServerDetails);
		Reporter.log(testDeviceAndServerDetails);

		if (null != testDeviceAndServerDetails && testDeviceAndServerDetails.equalsIgnoreCase("device1")) {
			Map<String, String> fristTestDetails = MobileTestProperties.getFirstTestDeviceAndAppiumDetails();
			des = getTestDeviceAndAppiumDetails(fristTestDetails);
			appiumURL = fristTestDetails.get(ConstantParametersSetup.APPIUM);
		} else if (null != testDeviceAndServerDetails && testDeviceAndServerDetails.equalsIgnoreCase("device2")) {
			Map<String, String> secondTestDetails = MobileTestProperties.getSecondTestDeviceAndAppiumDetails();
			des = getTestDeviceAndAppiumDetails(secondTestDetails);
			appiumURL = secondTestDetails.get(ConstantParametersSetup.APPIUM);
		} else {
			des.setCapability(MobileCapabilityType.PLATFORM_NAME, MobileTestProperties.getPlatformName());
			des.setCapability(MobileCapabilityType.PLATFORM_VERSION, MobileTestProperties.getPlatformVersion());
			des.setCapability(MobileCapabilityType.DEVICE_NAME, MobileTestProperties.getDeviceName());
			// des.setCapability(ConstantParametersSetup.APPPACKAGE
			// ,AndroidMobileTestProperties.getAppPackage());
			// des.setCapability(ConstantParametersSetup.APPACTIVITY,
			// AndroidMobileTestProperties.getAppActivity());
			des.setCapability(MobileCapabilityType.APP, MobileTestProperties.getApp());
			des.setCapability(MobileCapabilityType.AUTOMATION_NAME, MobileTestProperties.getAutomationName());
		}
		des.setCapability(ConstantParametersSetup.AUTOGRANTPERMISSIONS, true);
		// des.setCapability("waitForIdleTimeout", 5000);
		// des.setCapability(ConstantParametersSetup.UNICODEKEYBOARD, true);
		des.setCapability("newCommandTimeout", 60 * 5);
		des.setCapability(ConstantParametersSetup.RESETKEYBOARD, true);
		des.setCapability(ConstantParametersSetup.CLEARDEVICELOGONSTART, true);
		des.setCapability(AndroidMobileCapabilityType.SKIP_DEVICE_INITIALIZATION, true);
//		des.setCapability(MobileCapabilityType.NO_RESET, false);
//		des.setCapability(MobileCapabilityType.FULL_RESET, true);

	}

	@Override
	public void setWebDriver() {
		try {
		//	AppiumServerManager.
			System.out.println(des);
			System.out.println(appiumURL);
			
			_webDriver = new AndroidDriver(new URL(appiumURL), des);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public WebDriver getWebDriver() {
		if (isNull() == true) {
			return _webDriver;
		}
		return null;
	}

	private DesiredCapabilities getTestDeviceAndAppiumDetails(Map<String, String> testDevicesDesiredCapabilites) {

		DesiredCapabilities des = new DesiredCapabilities();

		des.setCapability(MobileCapabilityType.PLATFORM_NAME,
				testDevicesDesiredCapabilites.get(ConstantParametersSetup.PLATFORMNAME));
		des.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				testDevicesDesiredCapabilites.get(ConstantParametersSetup.PLATFORMVERSION));
		des.setCapability(MobileCapabilityType.DEVICE_NAME,
				testDevicesDesiredCapabilites.get(ConstantParametersSetup.DEVICENAME));
		// des.setCapability(ConstantParametersSetup.APPPACKAGE
		// ,testDevicesDesiredCapabilites.get(ConstantParametersSetup.APPPACKAGE));
		// des.setCapability(ConstantParametersSetup.APPACTIVITY,
		// testDevicesDesiredCapabilites.get(ConstantParametersSetup.APPACTIVITY));
		des.setCapability(MobileCapabilityType.APP, testDevicesDesiredCapabilites.get(ConstantParametersSetup.APP));
		des.setCapability(MobileCapabilityType.AUTOMATION_NAME,
				testDevicesDesiredCapabilites.get(ConstantParametersSetup.AUTOMATIONNAME));
		des.setCapability(ConstantParametersSetup.APPIUM,
				testDevicesDesiredCapabilites.get(ConstantParametersSetup.APPIUM));
		return des;
	}
}
