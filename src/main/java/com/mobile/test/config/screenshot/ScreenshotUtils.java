package com.mobile.test.config.screenshot;


import java.io.File;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ScreenshotUtils {

	private static Logger LOG = LoggerFactory.getLogger(ScreenshotUtils.class); 
	private static SecureRandom random = new SecureRandom();
	private static String reportName = null;

	public static String createFolder(File FolderPath, String folderName) {
		boolean result = false;
		String sFilePath = "";
		try {
			if (!FolderPath.exists()) {
				FolderPath.mkdir();
			}
			if (FolderPath.isDirectory()) {
				File directory = new File(FolderPath.getAbsolutePath() + getOS() + folderName);
				if (directory.isDirectory()) {
					LOG.info("Screenshot Folder already exists");
					sFilePath = directory.getAbsolutePath();
				} else {
					result = directory.mkdirs();
					LOG.info("Screenshot Folder Path : " + result);
					Thread.sleep(1000L);
					if (result) {
						sFilePath = directory.getAbsolutePath();
					}
				}
			} else {
				LOG.info("Directory Path is not found while creating a folder");
				LOG.info(FolderPath.toString());
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return sFilePath;
	}

	/**
	 * Function to return random String
	 * 
	 * @param int
	 *            - length for the String to be returned
	 * @return random string with length equals to the parameter passed
	 */
	public static String getRandomString(int length) {
		String result = "";
		try {
			result = new BigInteger(Long.SIZE * length, random).toString(32);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return result.substring(0, length);
	}

	/**
	 * Function to get the Automation Execution Report's name
	 * 
	 * @return String name of automation execution report
	 */
	public static void setReportName() {
		try {
			if (reportName == null) {
				Calendar cal = Calendar.getInstance();
				reportName = "Images-" + cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) + 1) + "-"
						+ cal.get(Calendar.YEAR) + "_" + cal.get(Calendar.HOUR_OF_DAY) + "-" + cal.get(Calendar.MINUTE)
						+ "-" + cal.get(Calendar.SECOND) + "-" + cal.get(Calendar.MILLISECOND) + "_"
						+ ScreenshotUtils.getRandomString(5).toUpperCase();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	public static String getReportName() {
		setReportName();
		return reportName;
	}

	public static String getOS(){
		String os = System.getProperty("os.name");
		if(os.equalsIgnoreCase("windows")){
			return "\\";
		}else{
			return "/";
		}
	}
}
