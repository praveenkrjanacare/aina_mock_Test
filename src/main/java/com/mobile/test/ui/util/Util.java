package com.mobile.test.ui.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Util {

	public static 	AndroidDriver driver;
	public static void sleep(int milliSeconds) {
		try {
			System.out.println("waiting..." + milliSeconds + " ms");
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return - root directory path
	 */
	public static String getRootDirectoryPath() {
		return System.getProperty("user.dir");
	}

	public static String getRandomGenerateNumber(int length) {
		Random random = new Random();
		String randomNumber = new String();
		for (int size = 0; size < length; size++) {
			randomNumber = randomNumber + random.nextInt(9);
		}
		return randomNumber;
	}

	public static boolean waitForElementToLoad(AndroidDriver androidDriver, WebElement element, String sElementName) {
		try {

			WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();

			return false;
		} catch (NoSuchElementException e) {
			e.printStackTrace();

			return false;
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	/**
	 * Verify whether element is present or not
	 * 
	 * @param driver
	 * @param element
	 * @param waitTime
	 * @return boolean value (true/false) represent whether element is present or
	 *         not
	 */
	public static boolean isElementPresent(AndroidDriver driver, WebElement element, String sElementName) {

		boolean bFlag = false;
		try {
			waitForElementToLoad(driver, element, sElementName);
			if (element.isDisplayed() || element.isEnabled()) {
				bFlag = true;
			}
		} catch (NoSuchElementException e) {

		} catch (TimeoutException e) {
			e.printStackTrace();

		} catch (Exception e) {

		}
		return bFlag;
	}

	/**
	 * Command Runner using adb shell
	 * 
	 **/
	public static void commandRunner(String commands) {
		try {
			// Command to enable NFC
			String command = commands;

			// Execute the command
			Process process = Runtime.getRuntime().exec(command);

			// Read the output from the command
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			// Wait for the process to complete
			process.waitFor();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Explicit wait method for until element visible 
	 **/
	
    public void waitUntilElementVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	

}