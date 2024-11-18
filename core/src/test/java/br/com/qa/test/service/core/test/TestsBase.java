package br.com.qa.test.service.core.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import br.com.qa.test.service.core.report.ExtentReportsInstance;
import br.com.qa.test.service.core.watcher.ExecutionWatcher;

public abstract class TestsBase {

	@Rule
	public ExecutionWatcher executionWatcher = new ExecutionWatcher(ExtentReportsInstance.getInstance());
	
	@Before
	public void baseTestsSetUp() {
		// System.out.println("Before test base");
	}
	
	@After
	public void baseTestsTearDown() {
		// System.out.println("After test base");
	}
	
}
