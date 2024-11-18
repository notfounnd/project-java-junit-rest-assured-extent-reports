package module.test.context.x.tests;

import static io.restassured.RestAssured.given;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.qa.test.service.core.test.TestsBase;
import io.restassured.RestAssured;
import io.restassured.specification.FilterableRequestSpecification;

public class AuthenticationTests extends TestsBase {
	
	@Before
	public void setUp() {
		// System.out.println("Before test");
	}
	
	@After
	public void tearDown() {
		// System.out.println("After test");
	}
	
	@Test
	public void shouldNotAccessApiWithoutAuthorizationToken() {
		FilterableRequestSpecification filterableRequestSpecification = (FilterableRequestSpecification) RestAssured.requestSpecification;
		filterableRequestSpecification.removeHeader("Authorization");
		
		given()
		.when()
			.get("/contas")
		.then()
			.statusCode(401)
		;
	}
	
}
