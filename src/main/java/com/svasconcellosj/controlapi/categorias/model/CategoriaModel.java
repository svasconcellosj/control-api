package com.svasconcellosj.controlapi.categorias.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "categorias")
@Data
public class CategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 40)
	private String descricao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CategoriaTipo tipo;
	
	@NotNull
	private Boolean status;
}
