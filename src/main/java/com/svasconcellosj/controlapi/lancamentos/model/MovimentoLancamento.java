package com.svasconcellosj.controlapi.lancamentos.model;

public enum MovimentoLancamento {

	ADICIONAIS("ADICIONAIS"),
	EXTRAS("EXTRAS"),
	FIXAS("FIXAS"),
	INVESTIMENTOS("INVESTIMENTOS"),
	RECEITAS("RECEITAS"),
	VARIAVEIS("VARIÁVEIS");
	
	private final String descricao;

	MovimentoLancamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
