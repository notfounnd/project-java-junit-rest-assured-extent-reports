package module.test.context.y.test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.qa.test.service.core.helper.JsonBuilder;
import br.com.qa.test.service.core.test.BaseTests;

public class RegisterTests extends BaseTests {

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
		InputStream payload = JsonBuilder.readJsonFileInputStream("payload/system-register-success.json");
		InputStream schema = JsonBuilder.readJsonFileInputStream("schema/system-register-schema.json");
		
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
		InputStream payload = JsonBuilder.readJsonFileInputStream("payload/system-register-error.json");
		
		given()
			.body(payload)
		.when()
			.post(PATH)
		.then()
			.assertThat()
				.statusCode(400)
				.body("error", equalTo("Missing password"))
		;
	}
		
}
