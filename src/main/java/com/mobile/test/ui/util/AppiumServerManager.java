package com.mobile.test.ui.util;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;

public  class AppiumServerManager {
    private static AppiumDriverLocalService service;

    public  static void startServer() throws MalformedURLException{
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//Admin//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("0.0.0.0")
                .usingPort(4723)
                .build();
        service.start();
        System.out.println("Appium server started on: " + service.getUrl().toString());
    }

    public static void stopServer() {
        if (service != null) {
            service.stop();
            System.out.println("Appium server stopped.");
        }
    }

	/*
	 * public static void main(String[] args) { AppiumServerManager
	 * appiumServerManager = new AppiumServerManager();
	 * appiumServerManager.startServer();
	 * 
	 * // Do something with the server...
	 * 
	 * appiumServerManager.stopServer(); }
	 */}
