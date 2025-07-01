package com.mobile.test.ui.config.system;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetSystemProperty {

	GetSystemProperty() {

	}

	private static Logger LOG = LoggerFactory.getLogger(GetSystemProperty.class);

	public static String getBrowserName() {
		String browser = System.getProperty(SystemProperties.BROWSER_NAME);
		if (browser == null) {
			return new String("chrome");
		}
		return new String(browser);
	}

	public static String getURL() {
		String url = System.getProperty(SystemProperties.URL);
		if (url == null) {
			return null;
		}
		return new String(url);
	}

	public static String getHeadLessExecution() {
		String headLessExecution = System.getProperty(SystemProperties.HEADLESS_EXECUTION);
		if (headLessExecution == null) {
			return new String("NO");
		}
		return new String(headLessExecution);
	}

	public static String getDeviceName() {
		String deviceName = System.getProperty(SystemProperties.DEVICE_NAME);
		if (deviceName == null) {
			return new String("");
		}
		return new String(deviceName);
	}

	public static String getPlatformName() {
		String platform = System.getProperty(SystemProperties.PLATFORM_NAME);
		if (platform == null) {
			return null;
		}
		return new String(platform);
	}

	public static String getMobileAppPath() {
		String appPath = System.getProperty(SystemProperties.APP_PATH);
		if (appPath == null) {
			return null;
		}
		return new String(appPath);
	}

	/**
	 * Required to hide or unhide keyboard for android making default value is true
	 * to hide the keyboard
	 * 
	 * @return
	 */
	public static String getUnicodeKeyboard() {
		String hideKeyboard = System.getProperty(SystemProperties.UNICODE_KEYBOARD);
		if (hideKeyboard == null) {
			return new String("YES");
		}
		return new String(hideKeyboard);
	}

	/**
	 * Required to Reset the app in the mobile making default not to reset
	 * 
	 * @return
	 */
	public static String getNoReset() {
		String noReset = System.getProperty(SystemProperties.NORESET);
		if (noReset == null) {
			return new String("YES");
		}
		return new String(noReset);
	}

	/**
	 * returning default local url if system property is null
	 * 
	 * @return
	 */
	public static URL getAppiumServerUrl() {
		String appiumServerURL = System.getProperty(SystemProperties.APPIUM_URL);
		if (appiumServerURL == null) {
			try {
				return new URL("http://0.0.0.0:4723/wd/hub");
			} catch (MalformedURLException e) {
				LOG.info("Appium Server URL is invalid");
			}
		}
		try {
			return new URL(appiumServerURL);
		} catch (MalformedURLException e) {
			LOG.info("Appium Server URL is invalid");
		}
		return null;
	}
}
