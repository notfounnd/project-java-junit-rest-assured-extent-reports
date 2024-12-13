package module.test.context.x.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.qa.test.service.core.test.TestsBase;
import module.test.context.x.helpers.AccountHelper;
import module.test.context.x.helpers.DateHelper;
import module.test.context.x.helpers.TransactionDTO;
import module.test.context.x.helpers.TransactionHelper;

public class TransactionsTests extends TestsBase {
	
	@Before
	public void setUp() {
		// System.out.println("Before test");
	}
	
	@After
	public void tearDown() {
		// System.out.println("After test");
	}
	
	@Test
	public void shouldCreateTransaction() {
		TransactionDTO movimentacao = TransactionHelper.getMovimentacaoValida();
		
		given()
			.body(movimentacao)
		.when()
			.post("/transacoes")
		.then()
			.statusCode(201)
			.body("descricao", is("Descrição da movimentação"))
			.body("tipo", is("REC"))
			.body("valor", is("100.00"))
		;
	}
	
	@Test
	public void shouldValidateRequiredFieldsToCreateTransaction() {		
		given()
			.body("{}")
		.when()
			.post("/transacoes")
		.then()
			.statusCode(400)
			.body("$", hasSize(8))
			.body("msg", hasItems(
					"Data da Movimentação é obrigatório",
					"Data do pagamento é obrigatório",
					"Descrição é obrigatório",
					"Interessado é obrigatório",
					"Valor é obrigatório",
					"Valor deve ser um número",
					"Conta é obrigatório",
					"Situação é obrigatório"
					))
		;
	}
	
	@Test
	public void shouldNotCreateTransactionWithFutureDate() {
		TransactionDTO movimentacao = TransactionHelper.getMovimentacaoValida();
		movimentacao.setData_transacao(DateHelper.getDataComDiferencaDias(2));
		
		given()
			.body(movimentacao)
		.when()
			.post("/transacoes")
		.then()
			.statusCode(400)
			.body("$", hasSize(1))
			.body("msg", hasItem("Data da Movimentação deve ser menor ou igual à data atual"))
		;
	}
	
	@Test
	public void shouldDeleteTransaction() {
		Integer mov_id = AccountHelper.getIdMovimentacaoPelaDescricao("Movimentacao para exclusao");
		
		given()
			.pathParam("id", mov_id)
		.when()
			.delete("/transacoes/{id}")
		.then()
			.statusCode(204)
		;
	}
	
}
