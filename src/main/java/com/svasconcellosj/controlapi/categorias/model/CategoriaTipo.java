package com.svasconcellosj.controlapi.categorias.model;

public enum CategoriaTipo {
	
	RECEITA("Receita"),
	DESPESA("Despesa");
	
	private final String descricao;

	CategoriaTipo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescrocao() {
		return descricao;
	}
	
}
