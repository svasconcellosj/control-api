package com.svasconcellosj.controlapi.lancamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.svasconcellosj.controlapi.lancamentos.model.LancamentoModel;
import com.svasconcellosj.controlapi.lancamentos.service.LancamentoService;

@RestController
@RequestMapping(value = "/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LancamentoModel>> buscaLancamentos() {
		List<LancamentoModel> lista = lancamentoService.buscaTodos();
		return new ResponseEntity<List<LancamentoModel>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<LancamentoModel> gravaLancamento(@RequestBody LancamentoModel lancamento) {
		LancamentoModel lancamentoModel = lancamentoService.grava(lancamento);
		return new ResponseEntity<LancamentoModel>(lancamentoModel, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<LancamentoModel> buscaLancamento(@PathVariable Long id) {
		LancamentoModel lancamentoModel = lancamentoService.buscaId(id);
		return new ResponseEntity<LancamentoModel>(lancamentoModel, HttpStatus.OK);
	}	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<LancamentoModel> excluiLancamento(@PathVariable Long id) {
		LancamentoModel lancamentoModel = lancamentoService.buscaId(id);
		lancamentoService.excluir(lancamentoModel);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<LancamentoModel> alteraLancamento(@PathVariable Long id, @RequestBody LancamentoModel lancamento) {
		LancamentoModel lancamentoModel = lancamentoService.altera(id, lancamento);
		return new ResponseEntity<LancamentoModel>(lancamentoModel, HttpStatus.OK);		
	}

}
