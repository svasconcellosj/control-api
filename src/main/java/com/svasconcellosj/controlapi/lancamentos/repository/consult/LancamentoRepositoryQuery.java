package com.svasconcellosj.controlapi.lancamentos.repository.consult;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.svasconcellosj.controlapi.lancamentos.dto.LancamentoCategoriaEstatistica;
import com.svasconcellosj.controlapi.lancamentos.dto.LancamentoTipoEstatistica;
import com.svasconcellosj.controlapi.lancamentos.model.LancamentoModel;
import com.svasconcellosj.controlapi.lancamentos.repository.filter.LancamentoFilter;
import com.svasconcellosj.controlapi.lancamentos.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {
	
	public Page<LancamentoModel> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
	
	public List<LancamentoCategoriaEstatistica> porCategoria(LocalDate dataInicio, LocalDate dataFim);
	public List<LancamentoTipoEstatistica> porTipo(LocalDate mesReferencia);

}
