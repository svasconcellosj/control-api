package com.svasconcellosj.controlapi.contas.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.svasconcellosj.controlapi.contas.model.ContaModel;
import com.svasconcellosj.controlapi.contas.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public Page<ContaModel> buscaTodos(Pageable pageable) {
		return contaRepository.findAll(pageable);
	}
	
	public ContaModel grava(ContaModel conta) {
		return contaRepository.save(conta);
	}
	
	public ContaModel buscaId(Long id) {
		return contaRepository.findById(id).orElse(null);
	}
	
	public void excli(ContaModel conta) {
		contaRepository.delete(conta);
	}
	
	
	public ContaModel alterar(Long id, ContaModel conta) {
		ContaModel contaModel = buscaId(id);
		BeanUtils.copyProperties(conta, contaModel,"id");
		return grava(contaModel);
	}
	
}
