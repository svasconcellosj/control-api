package com.svasconcellosj.controlapi.categorias.subcategorias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.svasconcellosj.controlapi.categorias.subcategorias.model.SubcategoriaModel;
import com.svasconcellosj.controlapi.categorias.subcategorias.service.SubcategoriaService;

@RestController
@RequestMapping(value = "/subcategorias")
@CrossOrigin(maxAge = 10, origins = { "http://localhost:4200"} )
public class SubcategoriaController {
	
	@Autowired
	private SubcategoriaService subcategoriaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/lista")
	public ResponseEntity<List<SubcategoriaModel>> buscaTodos() {
		List<SubcategoriaModel> lista = subcategoriaService.buscaTodos();
		return new ResponseEntity<List<SubcategoriaModel>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/categoria")
	public ResponseEntity<Page<SubcategoriaModel>> buscaPorIdCategoria(Long id, Pageable pageable) {
		Page<SubcategoriaModel> lista = subcategoriaService.buscaPorIdCategoria(id, pageable);
		return new ResponseEntity<Page<SubcategoriaModel>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SubcategoriaModel> gravaSubcategoria(@RequestBody SubcategoriaModel subcategoriaModel) {
		SubcategoriaModel subcategoria = subcategoriaService.grava(subcategoriaModel);
		return new ResponseEntity<SubcategoriaModel>(subcategoria, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<SubcategoriaModel> buscaSubcategoria(@PathVariable Long id) {
		SubcategoriaModel subcategoriaModel = subcategoriaService.buscaId(id);
		return subcategoriaModel == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<SubcategoriaModel>(subcategoriaModel, HttpStatus.OK);
	}
	
	public void altera() {}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<SubcategoriaModel> excluiSubcategoria(@PathVariable Long id) {
		SubcategoriaModel subcategoriaModel = subcategoriaService.buscaId(id);
		if ( subcategoriaModel == null ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		subcategoriaService.exclui(subcategoriaModel);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
