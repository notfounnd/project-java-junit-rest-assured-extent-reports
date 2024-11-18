package module.test.arch.tests;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

import br.com.qa.test.service.core.test.TestsBase;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "module.test")
public class ArchPackageTests extends TestsBase {
	
	private static final String HELPER_SUFFIX = "..helpers";
	private static final String RUNNER_SUFFIX = "..runners";
	private static final String TEST_SUFFIX = "..tests";

	@Before
	public void setUp() {
		// System.out.println("Before test");
	}

	@After
	public void tearDown() {
		// System.out.println("After test");
	}

	@ArchTest
	ArchRule packages_shouldKeepNamingSuffixStandards = classes()
		.should().resideInAPackage(HELPER_SUFFIX)
		.orShould().resideInAPackage(RUNNER_SUFFIX)
		.orShould().resideInAPackage(TEST_SUFFIX)
		.as("Packages should keep naming suffix standards")
		.because(String.format("\n\n> Helper module packages should be named with %s suffix", HELPER_SUFFIX))
		.because(String.format("\n> Runner module packages should be named with %s suffix", RUNNER_SUFFIX))
		.because(String.format("\n> Test module packages should be named with %s suffix\n\n", TEST_SUFFIX));

}
