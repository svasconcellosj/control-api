package com.svasconcellosj.controlapi.lancamentos.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.svasconcellosj.controlapi.categorias.model.CategoriaModel;
import com.svasconcellosj.controlapi.contas.model.ContaModel;

import lombok.Data;

@Entity
@Table(name = "lancamentos")
@Data
public class LancamentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 50)
	private String descricao;
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	@Column(name = "data_pagamento")
	private LocalDate dataPagamento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoriaModel idCategoria;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusPagamento statusPagamento;
	
	@Column(name = "qtd_repeticao")
	private int qtdRepeticao;
	
	private String observacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_conta")
	private ContaModel conta;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private MovimentoLancamento movimento;
	
}
