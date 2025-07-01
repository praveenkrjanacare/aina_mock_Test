package com.aina.test.extent.report;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentConfig extends TDIPageObjectsAdmin {

	public static ExtentReports setupExtent() {
		 SimpleDateFormat format= new SimpleDateFormat("_ddMMyy_HHmm");
		 Date date= new Date();
		 String actualdate = format.format(date);
		//String actualdate = TimeStamp.getTimeStamp();

		String reportpath = System.getProperty("user.dir") + "/test-output/extentreport" + actualdate + ".html";

		spark = new ExtentSparkReporter(reportpath);
		extent = new ExtentReports();
		extent.attachReporter(spark);
		spark.config().setDocumentTitle("Aina_B_APP_Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName(" Automation Report Aina Apk");
		//spark.config().setTimeStampFormat(actualdate);
		return extent;
	}

}
