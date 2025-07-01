package com.mobile.test.config;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.mobile.test.ui.util.ConstantParametersSetup;

public class MobileTestProperties {

	private final static Properties prop = new Properties();

	static {
		loadProperties();
	}

	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

	public static String getPropertyValue(String key, String defultValue) {
		return prop.getProperty(key, defultValue);
	}

	private static void loadProperties() {
		InputStream input = null;
		try {
			input = MobileTestProperties.class.getClassLoader().getResourceAsStream("mobile-test.properties");

			// load a properties file
			prop.load(input);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getAppiumURL() {
		return prop.getProperty("device1.android.appium");
	}

	/**
	 * Get platformName
	 * 
	 * @return
	 */
	public static String getPlatformName() {
		return prop.getProperty("device.android.platformName");
	}

	/**
	 * Get Platform Version
	 * 
	 * @return
	 */
	public static String getPlatformVersion() {
		return prop.getProperty("device1.android.platformVersion");
	}

	/**
	 * Get Device APK file location
	 * 
	 * @return
	 */
	public static String getApp() {
		return prop.getProperty("device.android.app");
	}

	/**
	 * Get device name <Using adb devices command or deice name from settings>
	 * 
	 * @return
	 */
	public static String getDeviceName() {
		return prop.getProperty("device1.android.deviceName");
	}

	/**
	 * Get App Package
	 * 
	 * @return
	 */
	public static String getAppPackage() {
		return prop.getProperty("device1.android.appPackage");
	}

	/**
	 * Get App Activity
	 * 
	 * @return
	 */
	public static String getAppActivity() {
		return prop.getProperty("device1.android.appActivity");
	}

	/**
	 * Get Automation Name, Default value is UIAutomator2
	 * 
	 * @return
	 */
	public static String getAutomationName() {
		return prop.getProperty("device1.android.automationName");
	}

	public static String getAppiumServer() {
		return prop.getProperty("device1.android.appium");
	}

	public static Duration getImplicitWaitTimeOutSeconds() {
		return Duration.ofSeconds(Integer.parseInt(prop.getProperty("test.implicit.wait.timeout.seconds", "60")));
	}

	/**
	 * Get All the Device1 details from Android test properties
	 * 
	 * @return
	 */
	public static Map<String, String> getFirstTestDeviceAndAppiumDetails() {
		Map<String, String> testDevicesDesiredCapabilites = new HashMap<String, String>();

		testDevicesDesiredCapabilites.put(ConstantParametersSetup.PLATFORMNAME, getPlatformName());
		testDevicesDesiredCapabilites.put(ConstantParametersSetup.PLATFORMVERSION, getPlatformVersion());
		testDevicesDesiredCapabilites.put(ConstantParametersSetup.DEVICENAME, getDeviceName());
		// testDevicesDesiredCapabilites.put(ConstantParametersSetup.APPPACKAGE
		// ,getAppPackage());
		// testDevicesDesiredCapabilites.put(ConstantParametersSetup.APPACTIVITY,
		// getAppActivity());
		testDevicesDesiredCapabilites.put(ConstantParametersSetup.APP, getApp());
		testDevicesDesiredCapabilites.put(ConstantParametersSetup.AUTOMATIONNAME, getAutomationName());
		testDevicesDesiredCapabilites.put(ConstantParametersSetup.APPIUM, getAppiumServer());

		return testDevicesDesiredCapabilites;
	}

	/**
	 * Get all Device2 details for Android
	 * 
	 * @return
	 */
	public static Map<String, String> getSecondTestDeviceAndAppiumDetails() {
		Map<String, String> testDevicesDesiredCapabilites = new HashMap<String, String>();

		testDevicesDesiredCapabilites.put(ConstantParametersSetup.PLATFORMNAME, getPlatformName());
		testDevicesDesiredCapabilites.put(ConstantParametersSetup.PLATFORMVERSION,
				prop.getProperty("device2.android.platformVersion"));
		testDevicesDesiredCapabilites.put(ConstantParametersSetup.DEVICENAME,
				prop.getProperty("device2.android.deviceName"));
		// testDevicesDesiredCapabilites.put(ConstantParametersSetup.APPPACKAGE ,
		// getAppPackage());
		// testDevicesDesiredCapabilites.put(ConstantParametersSetup.APPACTIVITY,
		// getAppActivity());
		testDevicesDesiredCapabilites.put(ConstantParametersSetup.APP, prop.getProperty("device2.android.app"));
		testDevicesDesiredCapabilites.put(ConstantParametersSetup.AUTOMATIONNAME, getAutomationName());
		testDevicesDesiredCapabilites.put(ConstantParametersSetup.APPIUM, prop.getProperty("device2.android.appium"));

		return testDevicesDesiredCapabilites;
	}

}
