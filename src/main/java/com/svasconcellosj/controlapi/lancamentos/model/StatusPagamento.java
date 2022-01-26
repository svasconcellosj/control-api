package com.svasconcellosj.controlapi.lancamentos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPagamento {
	
	PAGO("PAGO"),
	APAGAR("A PAGAR");
	
	private final String statusPagamento;

}
