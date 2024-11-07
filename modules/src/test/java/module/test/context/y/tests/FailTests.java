package module.test.context.y.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.qa.test.service.core.helper.JsonBuilder;
import br.com.qa.test.service.core.test.BaseTests;

public class FailTests extends BaseTests {
	
	private static final String PATH = "register";
	
	@Before
	public void setUp() {
		// System.out.println("Before test");
	}
	
	@After
	public void tearDown() {
		// System.out.println("After test");
	}

	@Test
	public void shouldMatchSystemRegistrationSchema() throws Exception {
		JsonNode payload = JsonBuilder.readJsonFileObjectMapper("payload/system-register-success.json");
		InputStream schema = JsonBuilder.readJsonFileInputStream("schema/fail-system-register-schema.json");
		
		given()
			.body(payload)
		.when()
			.post(PATH)
		.then()
			.assertThat()
				.body(matchesJsonSchema(schema))
		;
	}
	
	@Test
	public void shouldReturnErrorInSystemRegistrationAttempting() throws Exception {
		JsonNode payload = JsonBuilder.readJsonFileObjectMapper("payload/system-register-error.json");
		
		given()
			.body(payload)
		.when()
			.post(PATH)
		.then()
			.assertThat()
				.statusCode(400)
				.body("error", equalTo("Wrong password"))
		;
	}
	
}
