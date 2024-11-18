package module.test.arch.tests;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "module.test.context")
public class ArchMethodTests {
	
	private static final String TEST_PACKAGE = "..tests";
	private static final String METHOD_SET_UP = "setUp";
	private static final String METHOD_TEAR_DOWN = "tearDown";
	private static final String METHOD_TEST_PREFIX = "should";
	
	@Before
	public void setUp() {
		// System.out.println("Before test");
	}

	@After
	public void tearDown() {
		// System.out.println("After test");
	}
	
	@ArchTest
	ArchRule methods_tests_shouldKeepTestNamingPrefixStandards = methods()
		.that().areDeclaredInClassesThat().resideInAPackage(TEST_PACKAGE)
		.and().haveNameNotContaining(METHOD_SET_UP)
		.and().haveNameNotContaining(METHOD_TEAR_DOWN)
		.should().haveNameStartingWith(METHOD_TEST_PREFIX)
		.as("Methods tests should keep test naming prefix standards")
		.because(String.format("\n\n> Method test should be named with %s prefix\n\n", METHOD_TEST_PREFIX));
	
	@ArchTest
	ArchRule methods_tests_shouldKeepTestAnnotationStandards = methods()
		.that().areDeclaredInClassesThat().resideInAPackage(TEST_PACKAGE)
		.and().haveNameStartingWith(METHOD_TEST_PREFIX)
		.should().beAnnotatedWith(Test.class)
		.as("Methods tests should keep test annotation standards")
		.because(String.format("\n\n> Method test should be annotated with @Test\n\n"));
	
	@ArchTest
	ArchRule methods_setup_shouldKeepBeforeAnnotationStandards = methods()
		.that().areDeclaredInClassesThat().resideInAPackage(TEST_PACKAGE)
		.and().areAnnotatedWith(Before.class)
		.should().haveName(METHOD_SET_UP)
		.as("Methods set up should keep before annotation standards")
		.because(String.format("\n\n> Method set up should be annotated with @Before\n\n"));
	
	@ArchTest
	ArchRule methods_teardown_shouldKeepAfterAnnotationStandards = methods()
		.that().areDeclaredInClassesThat().resideInAPackage(TEST_PACKAGE)
		.and().areAnnotatedWith(After.class)
		.should().haveName(METHOD_TEAR_DOWN)
		.as("Methods tear down should keep after annotation standards")
		.because(String.format("\n\n> Method tear down should be annotated with @After\n\n"));

}
