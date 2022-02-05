package com.svasconcellosj.controlapi.lancamentos.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.svasconcellosj.controlapi.lancamentos.dto.LancamentoCategoriaEstatistica;
import com.svasconcellosj.controlapi.lancamentos.dto.LancamentoTipoEstatistica;
import com.svasconcellosj.controlapi.lancamentos.model.LancamentoModel;
import com.svasconcellosj.controlapi.lancamentos.service.LancamentoService;

@RestController
@RequestMapping(value = "/lancamentos")
@CrossOrigin(maxAge = 10, origins = { "http://localhost:4200"} )
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<LancamentoModel>> buscaLancamentos(@RequestParam(value = "descricao", defaultValue = " ", required = false) String descricao, Pageable pageable) {
		Page<LancamentoModel> lista = lancamentoService.buscaTodos(descricao, pageable);
		return new ResponseEntity<Page<LancamentoModel>>(lista, HttpStatus.OK);
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

	@RequestMapping(method = RequestMethod.GET, value = "estatisticas/por-categoria")
	public ResponseEntity<List<LancamentoCategoriaEstatistica>> estatiscaPorCategorias(@RequestParam(value = "dataInicio", required = false) String dataInicio, @RequestParam(value = "dataFim", required = false) String dataFim) {
		LocalDate dataInicial = LocalDate.parse(dataInicio, formatoData);
		LocalDate dataFinal = LocalDate.parse(dataFim, formatoData);
		List<LancamentoCategoriaEstatistica> estatistica = lancamentoService.findByCategoriaGroupByCategoria(dataInicial, dataFinal);
		return new ResponseEntity<List<LancamentoCategoriaEstatistica>>(estatistica, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "estatisticas/por-tipo")
	public ResponseEntity<List<LancamentoTipoEstatistica>> estatisticaPorTipos(@RequestParam(value = "dataInicio", required = false) String dataInicio, @RequestParam(value = "dataFim", required = false) String dataFim) {
		LocalDate dataInicial = LocalDate.parse(dataInicio, formatoData);
		LocalDate dataFinal = LocalDate.parse(dataFim, formatoData);
		List<LancamentoTipoEstatistica> estatistica = lancamentoService.findByTipoGroupByTipo(dataInicial, dataFinal);
		return new ResponseEntity<List<LancamentoTipoEstatistica>>(estatistica, HttpStatus.OK);
	}

}
