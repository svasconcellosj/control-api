package com.svasconcellosj.controlapi.categorias.subcategorias.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.svasconcellosj.controlapi.categorias.model.CategoriaModel;

import lombok.Data;

@Entity
@Table(name = "subcategorias")
@Data
public class SubcategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	public String descricao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	public CategoriaModel idCategoria;

}
