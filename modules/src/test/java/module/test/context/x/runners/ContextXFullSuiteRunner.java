package module.test.context.x.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.qa.test.service.core.helper.RestAssuredBuilder;
import br.com.qa.test.service.core.runner.RunnerBase;
import module.test.arch.helpers.ContextConstantsHelper;
import module.test.context.x.helpers.AccountHelper;
import module.test.context.x.tests.AccountTests;
import module.test.context.x.tests.AuthenticationTests;
import module.test.context.x.tests.BalanceTests;
import module.test.context.x.tests.TransactionsTests;

@RunWith(Suite.class)
@SuiteClasses({
	AccountTests.class,
	TransactionsTests.class,
	BalanceTests.class,
	AuthenticationTests.class })
public class ContextXFullSuiteRunner extends RunnerBase {
	
	@BeforeClass
	public static void suiteSetUpAll() {
		// System.out.println("Before suite");
		RestAssuredBuilder.setRestAssured(ContextConstantsHelper.PREFIX_CONTEXT_X, PROPERTIES);
		
		AccountHelper.generateAuthorization();
		AccountHelper.resetData();
	}

	@AfterClass
	public static void suiteTearDownAll() {
		// System.out.println("After suite");
	}

}
