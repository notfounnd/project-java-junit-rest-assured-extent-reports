package module.test.arch.tests;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

import br.com.qa.test.service.core.runner.RunnerBase;
import br.com.qa.test.service.core.test.TestsBase;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "module.test.context")
public class ArchClassTests {
	
	private static final String RUNNER_PACKAGE = "..runners";
	private static final String RUNNER_SUFFIX = "Runner";
	private static final String TEST_PACKAGE = "..tests";
	private static final String TEST_SUFFIX = "Tests";

	@Before
	public void setUp() {
		// System.out.println("Before test");
	}

	@After
	public void tearDown() {
		// System.out.println("After test");
	}

	@ArchTest
	ArchRule classes_runner_shouldKeepNamingSuffixStandards = classes()
		.that().resideInAPackage(RUNNER_PACKAGE)
		.should().haveSimpleNameEndingWith(RUNNER_SUFFIX)
		.as("Classes Runner should keep naming suffix standards")
		.because(String.format("\n\n> Class Runner should be named with %s suffix\n\n", RUNNER_SUFFIX));
	
	@ArchTest
	ArchRule classes_runner_shouldExtendsBaseRunnerClass = classes()
		.that().resideInAPackage(RUNNER_PACKAGE)
		.should().beAssignableTo(RunnerBase.class)
		.as("Classes Runner should extends BaseRunner class")
		.because(String.format("\n\n> Class Runner should extends BaseRunner class\n\n"));
	
	@ArchTest
	ArchRule classes_tests_shouldKeepNamingSuffixStandards = classes()
		.that().resideInAPackage(TEST_PACKAGE)
		.should().haveSimpleNameEndingWith(TEST_SUFFIX)
		.as("Classes Tests should keep naming suffix standards")
		.because(String.format("\n\n> Class tests should be named with %s suffix\n\n", TEST_SUFFIX));
	
	@ArchTest
	ArchRule classes_tests_shouldExtendsBaseTestClass = classes()
		.that().resideInAPackage(TEST_PACKAGE)
		.should().beAssignableTo(TestsBase.class)
		.as("Classes Tests should extends BaseTests class")
		.because(String.format("\n\n> Class Tests should extends BaseTests class\n\n"));

}
