package com.mobile.test.ui.config.driver;

import org.openqa.selenium.WebDriver;

public abstract class AbstractWebDriver {

	protected WebDriver _webDriver;

	protected AbstractWebDriver() {

	}

	abstract protected void setWebDriver();

	abstract protected WebDriver getWebDriver();

	public boolean isNull() {
		if (_webDriver != null) {
			return true;
		}
		return false;
	}
}
