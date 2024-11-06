package module.test.context.x.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.qa.test.service.core.helper.RestAssuredBuilder;
import br.com.qa.test.service.core.runner.BaseRunner;
import module.test.context.x.helper.AccountHelper;
import module.test.context.x.test.AccountTests;
import module.test.context.x.test.AuthenticationTests;
import module.test.context.x.test.BalanceTests;
import module.test.context.x.test.TransactionsTests;
import module.test.helper.ContextConstants;

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
