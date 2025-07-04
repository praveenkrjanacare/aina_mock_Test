package com.aina.mobile.android.test.insertstrip;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aina.mobile.android.test.pageobjectmodule.AndroidPageObjectsAdmin;
import com.mobile.test.abstractpage.AbstractPageObjectMobile;
import com.mobile.test.config.MobileTestProperties;
import com.mobile.test.ui.util.Util;

public class InsertStripTest extends AbstractPageObjectMobile {
	AndroidPageObjectsAdmin pageObjectsAdmin;

	public InsertStripTest(String executionPlatform) {
		super();
	}

	@BeforeClass
	public void setup() {

		pageObjectsAdmin = new AndroidPageObjectsAdmin(getAndroidDriver());
		getAndroidDriver().manage().timeouts().implicitlyWait(MobileTestProperties.getImplicitWaitTimeOutSeconds());
	}

	@Test(description="connect the aina c mock device")
	public void TC_001() {
		//pageObjectsAdmin.insertStripModule.connectMockDevice();
	}
	


}
