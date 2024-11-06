package module.test.context.y.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.qa.test.service.core.helper.RestAssuredBuilder;
import br.com.qa.test.service.core.runner.BaseRunner;
import module.test.context.y.test.FailTests;
import module.test.context.y.test.RegisterTests;
import module.test.context.y.test.UserTests;
import module.test.helper.ContextConstants;

@RunWith(Suite.class)
@SuiteClasses({
	UserTests.class,
	RegisterTests.class,
	FailTests.class })
public class ContextYFullSuiteRunner extends BaseRunner {
	
	@BeforeClass
	public static void suiteSetUpAll() {
		// System.out.println("Before suite");
		RestAssuredBuilder.setRestAssured(ContextConstants.PREFIX_CONTEXT_Y, PROPERTIES);
	}

	@AfterClass
	public static void suiteTearDownAll() {
		// System.out.println("After suite");
	}

}
