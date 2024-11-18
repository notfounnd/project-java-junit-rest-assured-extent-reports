package module.test.arch.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.qa.test.service.core.runner.RunnerBase;
import module.test.arch.tests.ArchClassTests;
import module.test.arch.tests.ArchMethodTests;
import module.test.arch.tests.ArchPackageTests;

@RunWith(Suite.class)
@SuiteClasses({
	ArchPackageTests.class,
	ArchClassTests.class,
	ArchMethodTests.class})
public class ArchTestsSuiteRunner extends RunnerBase {

	@BeforeClass
	public static void suiteSetUpAll() {
		// System.out.println("Before suite");
	}

	@AfterClass
	public static void suiteTearDownAll() {
		// System.out.println("After suite");
	}

}
