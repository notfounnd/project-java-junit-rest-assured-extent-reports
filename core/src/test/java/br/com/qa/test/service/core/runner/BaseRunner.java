package br.com.qa.test.service.core.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.com.qa.test.service.core.report.BaseExtendReport;
import br.com.qa.test.service.core.report.ExtentReportInstance;
import br.com.qa.test.service.core.setup.ApplicationProperties;
import io.restassured.RestAssured;

public abstract class BaseRunner {

	protected static final ApplicationProperties PROPERTIES = new ApplicationProperties();
	protected static BaseExtendReport report = new BaseExtendReport(PROPERTIES, ExtentReportInstance.getInstance());

	@BeforeClass
	public static void baseRunnerSetUpAll() {
		// RestAssuredBuilder.setRestAssured(ScopeConstants.PREFIX, PROPERTIES);
	}

	@AfterClass
	public static void baseRunnerTearDownAll() {
		RestAssured.reset();
		report.getExtent().flush();
	}

}
