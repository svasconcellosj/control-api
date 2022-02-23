package com.svasconcellosj.controlapi.lancamentos.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.svasconcellosj.controlapi.contas.service.ContaService;
import com.svasconcellosj.controlapi.lancamentos.dto.LancamentoCategoriaEstatistica;
import com.svasconcellosj.controlapi.lancamentos.dto.LancamentoTipoEstatistica;
import com.svasconcellosj.controlapi.lancamentos.model.LancamentoModel;
import com.svasconcellosj.controlapi.lancamentos.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private ContaService contaService;

	
	public Page<LancamentoModel> buscaTodos(String descricao, Pageable pageable) {
		return lancamentoRepository.findByDescricaoLikeOrderByDataPagamentoDescTipoDescDescricaoAsc('%'+descricao+'%', pageable);
	}
	
	public LancamentoModel grava(LancamentoModel lancamento) {
		return lancamentoRepository.save(lancamento);
	}
	
	public LancamentoModel buscaId(Long id) {
		return lancamentoRepository.findById(id).orElse(null);
	}
	
	public void excluir(LancamentoModel lancamento) {
		lancamentoRepository.delete(lancamento);
	}
	
	public LancamentoModel altera(Long id, LancamentoModel lancamento) {
		LancamentoModel lancamentoModel = buscaId(id);
		BeanUtils.copyProperties(lancamento, lancamentoModel, "id");
		return grava(lancamentoModel);
	}
	
	public List<LancamentoCategoriaEstatistica> porCategoria(LocalDate dataInicio, LocalDate dataFim) {
		return lancamentoRepository.porCategoria(dataInicio, dataFim);
	}
	public List<LancamentoCategoriaEstatistica> findByCategoriaGroupByCategoria(LocalDate dataInicio, LocalDate dataFim) {
		return lancamentoRepository.findByCategoriaGroupByCategoria(dataInicio, dataFim);
	}
	
	public List<LancamentoTipoEstatistica> findByTipoGroupByTipo(LocalDate data_inicio, LocalDate data_fim) {
		return lancamentoRepository.findByTipoGroupByTipo(data_inicio,data_fim);
	}
	
	public Boolean temSaldo(Long conta, LancamentoModel lancamento) {
		Boolean status = true;
		BigDecimal valor = lancamento.getValor();
		String tipo = lancamento.getTipo().toString();
		if ( tipo == "DESPESA" ) {
			return contaService.temSaldo(conta, valor);
		}
		return status;
	}
	
}
