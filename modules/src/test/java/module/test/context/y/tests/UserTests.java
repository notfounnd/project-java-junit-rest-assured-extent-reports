package module.test.context.y.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.qa.test.service.core.helper.JsonBuilder;
import br.com.qa.test.service.core.test.TestsBase;

public class UserTests extends TestsBase {

	private static final String PATH = "users";
	private static final String PATH_VARIABLE = "users/2";
	private static final String PATH_VARIABLE_NOT_FOUND = "users/23";

	@Before
	public void setUp() {
		// System.out.println("Before test");
	}
	
	@After
	public void tearDown() {
		// System.out.println("After test");
	}

	@Test
	public void shouldMatchCreateUserSchema() throws Exception {
		InputStream payload = JsonBuilder.readJsonFileInputStream("payload/create-user-success");
		InputStream schema = JsonBuilder.readJsonFileInputStream("schema/create-user-schema");
		
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
	public void shouldGetEmptyResponseInUserSearch() throws Exception {
		given()
		.when()
			.get(PATH_VARIABLE_NOT_FOUND)
		.then()
			.assertThat()
				.statusCode(404)
				.body(equalTo("{}"))
		;
	}
	
	@Test
	public void shouldUpdateUserInfo() throws Exception {
		JsonNode payload = JsonBuilder.readJsonFileObjectMapper("payload/update-user-success");
		
		given()
			.body(payload)
		.when()
			.put(PATH_VARIABLE)
		.then()
			.assertThat()
				.body("name", equalTo("Rachel Green Geller"))
		;
	}
	
	@Test
	public void shouldGetUsersListPagination() {
		given()
			.param("page", 2)
		.when()
			.get(PATH)
		.then()
			.assertThat()
				.body(containsString("total_pages"))
		;
	}

}
