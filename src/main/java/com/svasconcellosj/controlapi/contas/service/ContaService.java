package com.svasconcellosj.controlapi.contas.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.svasconcellosj.controlapi.contas.dto.ConsultaSaldos;
import com.svasconcellosj.controlapi.contas.model.ContaModel;
import com.svasconcellosj.controlapi.contas.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public Page<ContaModel> pesquisa(Pageable pageable) {
		return contaRepository.findAll(pageable);
	}
	
	public List<ContaModel> buscaTodos() {
		return contaRepository.findByOrderByDescricaoAsc();
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
	
	public Boolean temSaldo(Long id, BigDecimal valor) {
		Boolean status = true;
		ContaModel contaModel = buscaId(id);
		BigDecimal saldo = contaModel.getSaldo();
		if ( valor.compareTo(saldo) == 1) {
			status = false;
		}
		return status;
	}
	
	public ConsultaSaldos buscaTotalSaldos() {
		return contaRepository.findSumSaldo();
	}
	
	public ContaModel movimentaSaldo(ContaModel conta, BigDecimal novoSaldo) {
		ContaModel contaModel = buscaId(conta.getId());
		contaModel.setSaldo(novoSaldo);
		BeanUtils.copyProperties(conta, contaModel,"id");
		return grava(contaModel);
		
	}
	
}
