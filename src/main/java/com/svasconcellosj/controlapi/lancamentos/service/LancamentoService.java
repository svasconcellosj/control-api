package com.svasconcellosj.controlapi.lancamentos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.svasconcellosj.controlapi.lancamentos.dto.LancamentoCategoriaEstatistica;
import com.svasconcellosj.controlapi.lancamentos.dto.LancamentoTipoEstatistica;
import com.svasconcellosj.controlapi.lancamentos.model.LancamentoModel;
import com.svasconcellosj.controlapi.lancamentos.repository.LancamentoRepository;
import com.svasconcellosj.controlapi.lancamentos.repository.filter.LancamentoFilter;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Page<LancamentoModel> buscaTodos(LancamentoFilter lancamentoFilter, Pageable pageable) {
		return lancamentoRepository.filtrar(lancamentoFilter, pageable);
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
	
	public List<LancamentoCategoriaEstatistica> porCategoria(LocalDate mesReferencia) {
		return lancamentoRepository.porCategoria(mesReferencia);
	}
	
	public List<LancamentoTipoEstatistica> porTipo(LocalDate mesReferencia) {
		return lancamentoRepository.porTipo(mesReferencia);
	}
	
}
