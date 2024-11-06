package module.test.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.qa.test.service.core.runner.BaseRunner;
import module.test.context.x.runner.ContextXFullSuiteRunner;
import module.test.context.y.runner.ContextYFullSuiteRunner;

@RunWith(Suite.class)
@SuiteClasses({
	ContextYFullSuiteRunner.class,
	ContextXFullSuiteRunner.class })
public class FullSuiteRunner extends BaseRunner {
	
	@BeforeClass
	public static void suiteSetUpAll() {
		// System.out.println("Before suite");
	}

	@AfterClass
	public static void suiteTearDownAll() {
		// System.out.println("After suite");
	}

}
