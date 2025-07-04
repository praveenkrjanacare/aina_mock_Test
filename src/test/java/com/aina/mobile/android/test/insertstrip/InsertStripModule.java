package com.aina.mobile.android.test.insertstrip;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mobile.test.ui.util.Util;

import io.appium.java_client.android.AndroidDriver;

public class InsertStripModule {
	AndroidDriver driver;

	public InsertStripModule(AndroidDriver driver) {
		this.driver = driver;
	}

	@FindBy(id="com.janacare.ainac.az:id/active_button")
	private WebElement letsGetStartedButtton;
	
	@FindBy(xpath="//*[@text='Creatinine']")
	private WebElement creatinineTestSelectButton ;
	
	
	@FindBy(xpath="//*[@text='Next']")
	private WebElement nextButton;

	@FindBy(id="android:id/button2")
	private WebElement noButton;
	
	@FindBy(id="com.janacare.ainac.az:id/button_connect")
	private WebElement connectButton;
	
	@FindBy(id="com.janacare.ainac.az:id/active_button")
	private WebElement continueButton;
	
	@FindBy(id="com.janacare.ainac.az:id/active_button")
	private WebElement scanQrCodeButton;
	

	/**
	 * Insert Test strip screen
	 **/

	@FindBy(id="com.janacare.ainab:id/text_view_header")
	private WebElement insertTestStripHeader;
	
	@FindBy(id="com.janacare.ainab:id/text_view_stepper")
	private WebElement insertTestStripstep;
	
	@FindBy(id="com.janacare.ainab:id/image_view_placeholder")
	private WebElement insertTestStripLogo;
	
	@FindBy(id="com.janacare.ainab:id/text_view_sub_text_one")
	private WebElement insertTestStripInstructionsmsgOne;
	
	@FindBy(id="com.janacare.ainab:id/text_view_sub_text_two")
	private WebElement insertTestStripInstructionsmsgTwo;
	
	@FindBy(id="com.janacare.ainab:id/text_view_sub_text_three")
	private WebElement insertTestStripInstructionsmsgThree;
	
	@FindBy(id="com.janacare.ainab:id/text_view_sub_bottom")
	private WebElement insertTestStripInstructionsmsg ;
	
	@FindBy(id="com.janacare.ainab:id/active_button")
	private WebElement insertTestStripNextButton;
	
	  public void verifyInsetTestStripScreen() {
	    	Assert.assertEquals(insertTestStripHeader.getText(), "Insert test strip", "Text does not match!");
			Assert.assertEquals(insertTestStripstep.getText(),"Step 2 of 4","Text does not match!");
			insertTestStripLogo.isDisplayed();
			Assert.assertEquals(insertTestStripInstructionsmsgOne.getText(), "Remove the test strip from pouch", "Text does not match!");
			Assert.assertEquals(insertTestStripInstructionsmsgTwo.getText(), "Insert test strip into the device","Text does not match!");
			Assert.assertEquals(insertTestStripInstructionsmsgThree.getText(), "Make sure strip is inserted completely with the arrows pointing towards device", "Text does not match!");
			Assert.assertEquals(insertTestStripInstructionsmsg.getText(),"You will be able to move to the next step when the strip is inserted correctly.","Text does not match!");
	    }
	
	
	public void nextButtonEnabled() {
		insertTestStripNextButton.isEnabled();
	}
	public void clickNextButton() {
		Util.waitForElementToLoad(driver, insertTestStripHeader, "30");
		insertTestStripNextButton.click();
	}
	
	public void connectMockDevice() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// 1. Wait and click "Let's get started" button
		WebElement letsBtn = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.id("com.janacare.ainac.az:id/active_button"))
		);
		letsBtn.click();

		// 2. Wait and click the creatinine test selection
		/*
		 * WebElement creatinineBtn = wait.until(ExpectedConditions
		 * .visibilityOfElementLocated(By.xpath(
		 * "com.janacare.ainac.az:id/creatinineTestSelectButton")));
		 * creatinineBtn.click();
		 */

		// Optional: replace fixed sleep with wait for next element
		// Util.sleep(2000);

		// 3. Wait and click "Next" button (first time)
		WebElement nextBtn1 = wait.until(
		    ExpectedConditions.elementToBeClickable(By.id("//*[@text='Creatinine']"))
		);
		nextBtn1.click();

		// Util.sleep(3000);

		// 4. Wait and click "Next" button (second time)
		/*
		 * WebElement nextBtn2 = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.id(
		 * "com.janacare.ainac.az:id/nextButton")) ); nextBtn2.click();
		 */
	//	noButton.click();
		//Util.sleep(2000);

		//connectButton.click();
	//	Util.sleep(2000);

	///	continueButton.click();
	}
}
