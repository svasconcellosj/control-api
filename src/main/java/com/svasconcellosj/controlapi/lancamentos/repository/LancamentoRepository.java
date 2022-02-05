package com.svasconcellosj.controlapi.lancamentos.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.svasconcellosj.controlapi.lancamentos.dto.LancamentoCategoriaEstatistica;
import com.svasconcellosj.controlapi.lancamentos.dto.LancamentoTipoEstatistica;
import com.svasconcellosj.controlapi.lancamentos.model.LancamentoModel;
import com.svasconcellosj.controlapi.lancamentos.repository.consult.LancamentoRepositoryQuery;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoModel, Long>, LancamentoRepositoryQuery {
	
	public Page<LancamentoModel> findByDescricaoLikeOrderByDescricao(String descricao, Pageable pageable);
	
	@Query(value = "SELECT new com.svasconcellosj.controlapi.lancamentos.dto.LancamentoTipoEstatistica(l.tipo, SUM(l.valor)) "
			+ "FROM LancamentoModel l WHERE l.dataPagamento >= :data_inicio AND l.dataPagamento < :data_fim GROUP BY l.tipo")
	public List<LancamentoTipoEstatistica> findByTipoGroupByTipo(@Param("data_inicio") LocalDate data_inicio, @Param("data_fim") LocalDate data_fim);
	
	@Query(value = "SELECT new com.svasconcellosj.controlapi.lancamentos.dto.LancamentoCategoriaEstatistica(l.idCategoria, SUM(l.valor)) "
			+ "FROM LancamentoModel l WHERE l.dataPagamento >=:data_inicio AND l.dataPagamento < :data_fim AND l.tipo = 'DESPESA' GROUP BY l.idCategoria")
	public List<LancamentoCategoriaEstatistica> findByCategoriaGroupByCategoria(@Param("data_inicio") LocalDate data_inicio, @Param("data_fim") LocalDate data_fim);

}
