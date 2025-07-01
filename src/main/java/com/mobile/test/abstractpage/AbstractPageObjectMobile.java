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

	@BeforeSuite
    public void startEmulator() {
        try {
            // Check if emulator is already running
            Process checkProcess = Runtime.getRuntime().exec("/C://Users//Admin//AppData//Local//Android//Sdk//platform-tools//adb devices");
            boolean isRunning = new String(checkProcess.getInputStream().readAllBytes()).contains("emulator");

            if (!isRunning) {
                System.out.println("Starting Emulator...");
                ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C://Users//AdminAppData//Local//Android//Sdk//emulator", "emulator -avd Pixel_8_API_35");
                pb.start();
                Thread.sleep(40000); // wait for emulator to fully boot
            } else {
                System.out.println("Emulator already running.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
