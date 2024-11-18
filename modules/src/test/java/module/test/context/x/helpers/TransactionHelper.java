package module.test.context.x.helpers;

public class TransactionHelper {
	
	public static TransactionDTO getMovimentacaoValida() {
		TransactionDTO movimentacao = new TransactionDTO();
		
		movimentacao.setConta_id(AccountHelper.getIdContaPeloNome("Conta para movimentacoes"));
		movimentacao.setDescricao("Descrição da movimentação");
		movimentacao.setEnvolvido("Envolvido na movimentação");
		movimentacao.setTipo("REC");
		movimentacao.setData_transacao(DateHelper.getDataComDiferencaDias(-1));
		movimentacao.setData_pagamento(DateHelper.getDataComDiferencaDias(5));
		movimentacao.setValor(100f);
		movimentacao.setStatus(true);
		
		return movimentacao;
	}

}
