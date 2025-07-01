package com.aina.mobile.android.test.pageobjectmodule;

import org.openqa.selenium.support.PageFactory;

import com.aina.mobile.android.test.insertstrip.InsertStripModule;
import io.appium.java_client.android.AndroidDriver;

public class AndroidPageObjectsAdmin {


	public InsertStripModule insertStripModule;
	
	
	public AndroidPageObjectsAdmin(AndroidDriver driver) {
	
		insertStripModule=new InsertStripModule(driver);
		
		PageFactory.initElements(driver, insertStripModule);
	
	}
}
