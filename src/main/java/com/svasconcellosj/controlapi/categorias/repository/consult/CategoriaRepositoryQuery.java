package com.svasconcellosj.controlapi.categorias.repository.consult;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.svasconcellosj.controlapi.categorias.model.CategoriaModel;
import com.svasconcellosj.controlapi.categorias.repository.filter.CategoriaFilter;

public interface CategoriaRepositoryQuery {

	public Page<CategoriaModel> filtrar(CategoriaFilter categoriaFilter, Pageable pageable);
	
}
