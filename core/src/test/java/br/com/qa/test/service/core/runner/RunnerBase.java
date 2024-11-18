package br.com.qa.test.service.core.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.com.qa.test.service.core.report.ExtentReportsBase;
import br.com.qa.test.service.core.report.ExtentReportsInstance;
import br.com.qa.test.service.core.setup.ApplicationProperties;
import io.restassured.RestAssured;

public abstract class RunnerBase {

	protected static final ApplicationProperties PROPERTIES = new ApplicationProperties();
	protected static ExtentReportsBase report = new ExtentReportsBase(PROPERTIES, ExtentReportsInstance.getInstance());

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
