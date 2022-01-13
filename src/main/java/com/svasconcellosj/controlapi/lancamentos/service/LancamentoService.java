package com.svasconcellosj.controlapi.lancamentos.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svasconcellosj.controlapi.lancamentos.model.LancamentoModel;
import com.svasconcellosj.controlapi.lancamentos.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public List<LancamentoModel> buscaTodos() {
		return lancamentoRepository.findAll();
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
	
}
