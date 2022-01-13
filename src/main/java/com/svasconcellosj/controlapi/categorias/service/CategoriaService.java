package com.svasconcellosj.controlapi.categorias.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.svasconcellosj.controlapi.categorias.model.CategoriaModel;
import com.svasconcellosj.controlapi.categorias.repository.CategoriaRepository;
import com.svasconcellosj.controlapi.categorias.repository.filter.CategoriaFilter;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public Page<CategoriaModel> buscaTodos(CategoriaFilter categoriaFilter, Pageable pageable) {
		return categoriaRepository.filtrar(categoriaFilter, pageable);
	}
	
	public CategoriaModel grava(CategoriaModel categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public CategoriaModel buscaId(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}
	
	public CategoriaModel altera(Long id, CategoriaModel categoria) {
		CategoriaModel categoriaModel = buscaId(id);
		if ( categoriaModel == null ) {
			return null;
		}
		BeanUtils.copyProperties(categoria, categoriaModel, "id");
		return grava(categoriaModel);
	}
	
	public void exclui(CategoriaModel categoria) {
		categoriaRepository.delete(categoria);
	}
}
