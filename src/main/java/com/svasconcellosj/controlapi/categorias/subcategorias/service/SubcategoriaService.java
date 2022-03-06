package com.svasconcellosj.controlapi.categorias.subcategorias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.svasconcellosj.controlapi.categorias.subcategorias.model.SubcategoriaModel;
import com.svasconcellosj.controlapi.categorias.subcategorias.repository.SubcategoriaRepository;

@Service
public class SubcategoriaService {

	@Autowired
	private SubcategoriaRepository subcategoriaRepository;
	
	public List<SubcategoriaModel> buscaTodos() {
		return subcategoriaRepository.findAll();
	}
	
	public Page<SubcategoriaModel> buscaPorIdCategoria(Long id, Pageable pageable) {
		return subcategoriaRepository.findByidCategoria(id, pageable);
	}
	
	public SubcategoriaModel grava(SubcategoriaModel subcategoriaModel) {
		return subcategoriaRepository.save(subcategoriaModel);
	}
	
	public SubcategoriaModel buscaId(Long id) {
		return subcategoriaRepository.findById(id).orElse(null);
	}
	
	public void altera() {}
	
	public void exclui(SubcategoriaModel subcategoriaModel) {
		subcategoriaRepository.delete(subcategoriaModel);
	}
}
