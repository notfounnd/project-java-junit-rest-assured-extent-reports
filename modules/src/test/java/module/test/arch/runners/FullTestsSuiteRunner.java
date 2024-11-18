package module.test.arch.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.qa.test.service.core.runner.RunnerBase;
import module.test.context.x.runners.ContextXFullSuiteRunner;
import module.test.context.y.runners.ContextYFullSuiteRunner;

@RunWith(Suite.class)
@SuiteClasses({
	ContextYFullSuiteRunner.class,
	ContextXFullSuiteRunner.class })
public class FullTestsSuiteRunner extends RunnerBase {
	
	@BeforeClass
	public static void suiteSetUpAll() {
		// System.out.println("Before suite");
	}

	@AfterClass
	public static void suiteTearDownAll() {
		// System.out.println("After suite");
	}

}
