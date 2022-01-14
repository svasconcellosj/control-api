package com.svasconcellosj.controlapi.plantas.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "plantas")
@Data
public class PlantaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 30)
	private String nome;
	
	private String descricao;
	
	@NotNull
	@Column(name = "em_vaso")
	private Boolean emVaso;
	
	@Column(name = "tamanho_vaso")
	private String tamanhoVaso;
	
	@NotNull
	@Column(name = "tipo_plantio")
	private TipoPlantio tipoPlantio;
	
	@NotNull
	@Column(name = "data_plantio")
	private LocalDate dataPlantio;
	
	@Column(name = "data_germinacao")
	private LocalDate dataGerminacao;

	@Column(name = "qtd_rega_semana")
	private int qtdRegaSemana;
	
	@Column(name = "volume_rega")
	private int volumeRega;
	
	private String adubacao;
	
	private String observacao;
	
}
