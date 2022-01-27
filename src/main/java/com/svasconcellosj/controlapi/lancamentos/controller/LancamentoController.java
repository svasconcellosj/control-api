package com.svasconcellosj.controlapi.lancamentos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<LancamentoModel>> buscaLancamentos(Pageable pageable) {
		Page<LancamentoModel> lista = lancamentoService.buscaTodos(pageable);
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
	public ResponseEntity<List<LancamentoCategoriaEstatistica>> estatiscaPorCategoria() {
		LocalDate data = LocalDate.now();
		List<LancamentoCategoriaEstatistica> estatistica = lancamentoService.porCategoria(data);
		return new ResponseEntity<List<LancamentoCategoriaEstatistica>>(estatistica, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "estatisticas/por-tipo")
	public ResponseEntity<List<LancamentoTipoEstatistica>> estatisticaPorTipo() {
		LocalDate data = LocalDate.now();
		List<LancamentoTipoEstatistica> estatistica = lancamentoService.porTipo(data);
		return new ResponseEntity<List<LancamentoTipoEstatistica>>(estatistica, HttpStatus.OK);
	}
	
	
	//formas de ordenação
	
	@RequestMapping(method = RequestMethod.GET, value = "sortDescricao")
	public ResponseEntity<List<LancamentoModel>> findByOrderByDescricao() {
		List<LancamentoModel> lista = lancamentoService.findByOrderByDescricao();
		return new ResponseEntity<List<LancamentoModel>>(lista, HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.GET, value = "sort.Descricao")
	public ResponseEntity<List<LancamentoModel>> findBySortDescricao() {
		List<LancamentoModel> lista = lancamentoService.buscaTodos(Sort.by(Sort.Direction.ASC, "descricao"));
		return new ResponseEntity<List<LancamentoModel>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "sortTipoDescricao")
	public ResponseEntity<List<LancamentoModel>> findByOrderByTipoDescDescricaoAsc() {
		List<LancamentoModel> lista = lancamentoService.findByOrderByTipoDescDescricaoAsc();
		return new ResponseEntity<List<LancamentoModel>>(lista, HttpStatus.OK);
	}

}
