package com.svasconcellosj.controlapi.lancamentos.dto;

import java.math.BigDecimal;

import com.svasconcellosj.controlapi.categorias.model.CategoriaModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LancamentoCategoriaEstatistica {
	
	private CategoriaModel categoria;
	private BigDecimal total;
	
}
