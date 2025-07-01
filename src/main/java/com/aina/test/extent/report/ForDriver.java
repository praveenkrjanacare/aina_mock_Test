package com.aina.test.extent.report;

import com.mobile.test.abstractpage.AbstractPageObjectMobile;

public class ForDriver extends AbstractPageObjectMobile{

	public ForDriver() {
		super();
	}
	public <AndroidWebDriver> AndroidWebDriver getandroiddriver() {
		return (AndroidWebDriver) getAndroidDriver();
		
	}
}

