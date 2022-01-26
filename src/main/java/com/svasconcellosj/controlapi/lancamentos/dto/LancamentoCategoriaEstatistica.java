package com.svasconcellosj.controlapi.lancamentos.dto;

import java.math.BigDecimal;

import com.svasconcellosj.controlapi.categorias.model.CategoriaModel;

public class LancamentoCategoriaEstatistica {
	
	private CategoriaModel categoria;
	private BigDecimal total;
	
	public LancamentoCategoriaEstatistica(CategoriaModel categoria, BigDecimal total) {
		this.categoria = categoria;
		this.total = total;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
}
