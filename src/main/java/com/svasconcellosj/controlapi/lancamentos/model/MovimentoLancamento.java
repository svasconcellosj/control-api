package com.svasconcellosj.controlapi.lancamentos.model;

public enum MovimentoLancamento {

	RECEITAS("RECEITAS"),
	INVESTIMENTOS("INVESTIMENTOS"),
	FIXAS("FIXAS"),
	VARIAVEIS("VARIÁVEIS"),
	EXTRAS("EXTRAS"),
	ADICIONAIS("ADICIONAIS");
	
	private final String descricao;

	MovimentoLancamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
