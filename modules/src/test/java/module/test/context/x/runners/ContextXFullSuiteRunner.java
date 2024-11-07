package module.test.context.x.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.qa.test.service.core.helper.RestAssuredBuilder;
import br.com.qa.test.service.core.runner.BaseRunner;
import module.test.context.x.helpers.AccountHelper;
import module.test.context.x.tests.AccountTests;
import module.test.context.x.tests.AuthenticationTests;
import module.test.context.x.tests.BalanceTests;
import module.test.context.x.tests.TransactionsTests;
import module.test.helpers.ContextConstants;

@RunWith(Suite.class)
@SuiteClasses({
	AccountTests.class,
	TransactionsTests.class,
	BalanceTests.class,
	AuthenticationTests.class })
public class ContextXFullSuiteRunner extends BaseRunner {
	
	@BeforeClass
	public static void suiteSetUpAll() {
		// System.out.println("Before suite");
		RestAssuredBuilder.setRestAssured(ContextConstants.PREFIX_CONTEXT_X, PROPERTIES);
		
		AccountHelper.generateAuthorization();
		AccountHelper.resetData();
	}

	@AfterClass
	public static void suiteTearDownAll() {
		// System.out.println("After suite");
	}

}
