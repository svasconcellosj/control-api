package com.svasconcellosj.controlapi.lancamentos.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class LancamentoFilter {

	private String descricao;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPagamentoDe;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPagamentoAte;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataPagamentoDe() {
		return dataPagamentoDe;
	}

	public void setDataPagamentoDe(LocalDate dataPagamentoDe) {
		this.dataPagamentoDe = dataPagamentoDe;
	}

	public LocalDate getDataPagamentoAte() {
		return dataPagamentoAte;
	}

	public void setDataPagamentoAte(LocalDate dataPagamentoAte) {
		this.dataPagamentoAte = dataPagamentoAte;
	}

}
