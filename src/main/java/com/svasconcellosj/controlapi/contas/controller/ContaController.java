package com.svasconcellosj.controlapi.contas.controller;

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

import com.svasconcellosj.controlapi.contas.dto.ConsultaSaldos;
import com.svasconcellosj.controlapi.contas.model.ContaModel;
import com.svasconcellosj.controlapi.contas.service.ContaService;

@RestController
@RequestMapping(value = "/contas")
@CrossOrigin(maxAge = 10, origins = { "http://localhost:4200"} )
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ContaModel>> pesquisaContas(Pageable pageable) {
		Page<ContaModel> lista = contaService.pesquisa(pageable);
		return new ResponseEntity<Page<ContaModel>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/lista")
	public ResponseEntity<List<ContaModel>> buscaContas() {
		List<ContaModel> lista = contaService.buscaTodos();
		return new ResponseEntity<List<ContaModel>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ContaModel> gravaConta(@Validated @RequestBody ContaModel conta) {
		ContaModel contaModel = contaService.grava(conta);
		return new ResponseEntity<ContaModel>(contaModel, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ContaModel> excluiConta(@PathVariable Long id) {
		ContaModel contaModel = contaService.buscaId(id);
		contaService.excli(contaModel);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ContaModel> buscaConta(@PathVariable Long id) {
		ContaModel contaModel = contaService.buscaId(id);
		return contaModel == null ?  new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<ContaModel>(contaModel, HttpStatus.OK);		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<ContaModel> alteraConta(@PathVariable Long id, @RequestBody ContaModel conta) {
		ContaModel contaModel = contaService.alterar(id, conta);
		return new ResponseEntity<ContaModel>(contaModel, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/total-saldos")
	public ResponseEntity<ConsultaSaldos> consultaSaldo() {
		ConsultaSaldos saldo = contaService.buscaTotalSaldos();
		return new ResponseEntity<ConsultaSaldos>(saldo, HttpStatus.OK);
	}

}
