package com.svasconcellosj.controlapi.lancamentos.repository.consult;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.svasconcellosj.controlapi.lancamentos.model.LancamentoModel;
import com.svasconcellosj.controlapi.lancamentos.repository.filter.LancamentoFilter;
import com.svasconcellosj.controlapi.lancamentos.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {
	
	public Page<LancamentoModel> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);

}
