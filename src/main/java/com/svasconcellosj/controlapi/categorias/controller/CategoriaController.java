package com.svasconcellosj.controlapi.categorias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.svasconcellosj.controlapi.categorias.model.CategoriaModel;
import com.svasconcellosj.controlapi.categorias.repository.filter.CategoriaFilter;
import com.svasconcellosj.controlapi.categorias.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
@CrossOrigin(maxAge = 10, origins = { "http://localhost:4200"} )
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaModel>> buscaCategorias(CategoriaFilter categoriaFilter, Pageable pageable) {
		Page<CategoriaModel> cM = categoriaService.buscaTodas(categoriaFilter, pageable);
		return new ResponseEntity<Page<CategoriaModel>>(cM, HttpStatus.OK);		
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CategoriaModel> gravaCategoria(@Validated @RequestBody CategoriaModel categoria) {
		CategoriaModel categoriaModel = categoriaService.grava(categoria);
		return new ResponseEntity<CategoriaModel>(categoriaModel, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<CategoriaModel> buscaId(@PathVariable Long id) {
		CategoriaModel categoriaModel = categoriaService.buscaId(id);
		return categoriaModel == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<CategoriaModel>(categoriaModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<CategoriaModel> alteraCategoria(@PathVariable Long id,
			@RequestBody CategoriaModel categoria) {
		CategoriaModel categoriaModel = categoriaService.altera(id, categoria);
		return categoriaModel == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<CategoriaModel>(categoriaModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<CategoriaModel> exclui(@PathVariable Long id) {
		CategoriaModel categoriaModel = categoriaService.buscaId(id);
		if ( categoriaModel == null ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		categoriaService.exclui(categoriaModel);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/lista")
	public ResponseEntity<List<CategoriaModel>> listaCategorias() {
		List<CategoriaModel> lista = categoriaService.listaTodas();
		return new ResponseEntity<List<CategoriaModel>>(lista, HttpStatus.OK);
	}

}
