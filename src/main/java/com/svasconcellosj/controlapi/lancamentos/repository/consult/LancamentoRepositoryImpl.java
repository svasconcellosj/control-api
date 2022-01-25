package com.svasconcellosj.controlapi.lancamentos.repository.consult;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import com.svasconcellosj.controlapi.lancamentos.model.LancamentoModel;
import com.svasconcellosj.controlapi.lancamentos.repository.filter.LancamentoFilter;
import com.svasconcellosj.controlapi.lancamentos.repository.projection.ResumoLancamento;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	public Page<LancamentoModel> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<LancamentoModel> criteria = builder.createQuery(LancamentoModel.class);
		Root<LancamentoModel> root = criteria.from(LancamentoModel.class);
		
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<LancamentoModel> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
	}

	private Predicate[] criarRestricoes(LancamentoFilter lancamentoFilter, CriteriaBuilder builder,	Root<LancamentoModel> root) {
		List<Predicate> predicates = new ArrayList<>();

		//where descricao like '% campo %' 
		if(!ObjectUtils.isEmpty(lancamentoFilter.getDescricao())) {
			predicates.add(builder.like(builder.lower(root.get("descricao")), "%" + lancamentoFilter.getDescricao().toLowerCase() + "%"));
		}
		
		//where DataPagamentoDe >= 
		if (lancamentoFilter.getDataPagamentoDe() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("dataPagamento"), lancamentoFilter.getDataPagamentoDe()));
		}
		
		//where DataPagamentoAte <=
		if (lancamentoFilter.getDataPagamentoAte() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("dataPagamento"), lancamentoFilter.getDataPagamentoAte()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	@Override
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoLancamento> criteria = builder.createQuery(ResumoLancamento.class);
		Root<LancamentoModel> root = criteria.from(LancamentoModel.class);
		
		criteria.select(builder.construct(ResumoLancamento.class
				, root.get("id"), root.get("descricao")
				, root.get("dataVencimento"), root.get("dataPagamento")
				, root.get("valor"), root.get("status")
				, root.get("categoria").get("descricao")
				, root.get("pessoa").get("nome")));
		
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoLancamento> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(LancamentoFilter lancamentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<LancamentoModel> root = criteria.from(LancamentoModel.class);
		
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}