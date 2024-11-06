package br.com.qa.test.service.core.report;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReportInstance {

	private static final ExtentReportInstance INSTANCE = new ExtentReportInstance();
	private ExtentReports extent = new ExtentReports();

	private ExtentReportInstance() { }

	public static ExtentReports getInstance() {
		return INSTANCE.extent;
	}
}
