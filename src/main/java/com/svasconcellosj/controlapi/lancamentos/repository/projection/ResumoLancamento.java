package com.svasconcellosj.controlapi.lancamentos.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoLancamento {
    
	private Long codigo;
	private String descricao;
	private LocalDate dataPagamento;
	private BigDecimal valor;
	private String categoria;
	private String pessoa;
	
	public ResumoLancamento(Long codigo, String descricao, LocalDate dataPagamento,
			BigDecimal valor, String categoria, String pessoa) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.categoria = categoria;
		this.pessoa = pessoa;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

}