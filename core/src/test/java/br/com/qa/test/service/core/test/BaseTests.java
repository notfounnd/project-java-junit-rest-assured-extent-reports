package br.com.qa.test.service.core.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import br.com.qa.test.service.core.report.ExtentReportInstance;
import br.com.qa.test.service.core.watcher.ExecutionWatcher;

public abstract class BaseTests {

	@Rule
	public ExecutionWatcher executionWatcher = new ExecutionWatcher(ExtentReportInstance.getInstance());
	
	@Before
	public void baseTestsSetUp() {
		// System.out.println("Before test base");
	}
	
	@After
	public void baseTestsTearDown() {
		// System.out.println("After test base");
	}
	
}
