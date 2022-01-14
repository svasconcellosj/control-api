package com.svasconcellosj.controlapi.plantas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.svasconcellosj.controlapi.plantas.model.PlantaModel;
import com.svasconcellosj.controlapi.plantas.service.PlantaService;

@RestController
@RequestMapping(value = "/plantas")
@CrossOrigin(maxAge = 10, origins = "http://localhost:4200")
public class PlantaController {
	
	@Autowired
	private PlantaService plantaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PlantaModel>> buscaPlantas() {
		List<PlantaModel> lista = plantaService.buscaTodos();
		return new ResponseEntity<List<PlantaModel>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PlantaModel> gravaPlanta(@Validated @RequestBody PlantaModel planta) {
		PlantaModel plantaModel = plantaService.grava(planta);
		return new ResponseEntity<PlantaModel>(plantaModel, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<PlantaModel> buscaPlanta(@PathVariable Long id) {
		PlantaModel plantaModel = plantaService.buscaId(id);
		return plantaModel == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<PlantaModel>(plantaModel, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<PlantaModel> alteraPlanta(@PathVariable Long id, @RequestBody PlantaModel planta) {
		PlantaModel plantaModel = plantaService.altera(id, planta);
		return plantaModel == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<PlantaModel>(plantaModel, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<PlantaModel> excluiPlanta(@PathVariable Long id) {
		PlantaModel plantaModel = plantaService.buscaId(id);
		if ( plantaModel == null ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		plantaService.exclui(plantaModel);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
