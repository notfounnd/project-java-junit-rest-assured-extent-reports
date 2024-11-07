package module.test.context.y.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.qa.test.service.core.helper.RestAssuredBuilder;
import br.com.qa.test.service.core.runner.BaseRunner;
import module.test.context.y.tests.FailTests;
import module.test.context.y.tests.UserTests;
import module.test.helpers.ContextConstants;

@RunWith(Suite.class)
@SuiteClasses({
	UserTests.class,
	FailTests.class })
public class ContextYPartialSuiteRunner extends BaseRunner {
	
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
