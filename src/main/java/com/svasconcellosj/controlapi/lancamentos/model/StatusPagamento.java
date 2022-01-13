package com.svasconcellosj.controlapi.lancamentos.model;

public enum StatusPagamento {
	
	PAGO("PAGO"),
	APAGAR("A PAGAR");
	
	private final String statusPagamento;
	
	private StatusPagamento(String status) {
		this.statusPagamento = status;
	}
	
	public String getStatusPagamento() {
		return statusPagamento;
	}

}
