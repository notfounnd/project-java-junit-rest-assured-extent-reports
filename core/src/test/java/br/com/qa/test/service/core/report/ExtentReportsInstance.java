package br.com.qa.test.service.core.report;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReportsInstance {

	private static final ExtentReportsInstance INSTANCE = new ExtentReportsInstance();
	private ExtentReports extent = new ExtentReports();

	private ExtentReportsInstance() { }

	public static ExtentReports getInstance() {
		return INSTANCE.extent;
	}
}
