package com.mobile.test.config.screenshot;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BrowserScreenShot {

	static String timeStamp = null;
	static String screenshotFolderName = new String();
	
	/**
	 * To generate the screen shot folder
	 */
	static {
		screenshotFolderName = ScreenshotUtils.createFolder(new File("ScreenShots"), ScreenshotUtils.getReportName());
	}
	
	/**
	 * 
	 * @param methodName
	 *  capture screenshot with execution method name and time stamp
	 */
	public static String takeScreenShot(String methodName, WebDriver webDriver){
	
		File soruceFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		try {
			timeStamp = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
			String location = screenshotFolderName+"\\"+methodName+"_"+timeStamp+".png";
			FileUtils.copyFile(soruceFile, new File(location));
			 String path = "<img src=\"file://" + location + "\" alt=\"\"/>";
			return path;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return methodName+"_exception while capturing screenshot";
	}
}
