package module.test.context.x.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.qa.test.service.core.test.TestsBase;
import module.test.context.x.helpers.AccountHelper;

public class BalanceTests extends TestsBase {
	
	@Before
	public void setUp() {
		// System.out.println("Before test");
	}
	
	@After
	public void tearDown() {
		// System.out.println("After test");
	}
	
	@Test
	public void shouldGetBalanceAccount() {
		Integer conta_id = AccountHelper.getIdContaPeloNome("Conta para saldo");
		
		given()
		.when()
			.get("/saldo")
		.then()
			.statusCode(200)
			.body("find{it.conta_id == " + conta_id + "}.saldo", is("534.00"))
		;
	}
	
}
