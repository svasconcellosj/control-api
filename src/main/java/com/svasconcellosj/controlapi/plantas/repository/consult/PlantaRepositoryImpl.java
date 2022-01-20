package com.svasconcellosj.controlapi.plantas.repository.consult;

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

import com.svasconcellosj.controlapi.plantas.model.PlantaModel;
import com.svasconcellosj.controlapi.plantas.repository.filter.PlantaFilter;

public class PlantaRepositoryImpl implements PlantaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<PlantaModel> filtrar(PlantaFilter plantaFilter, Pageable pageable) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<PlantaModel> criteria = builder.createQuery(PlantaModel.class);
		Root<PlantaModel> root = criteria.from(PlantaModel.class);
		
		Predicate[] predicates = criarRestricoes(plantaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<PlantaModel> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(plantaFilter));
	}
	
	private Predicate[] criarRestricoes(PlantaFilter PlantaFilter, CriteriaBuilder builder,
			Root<PlantaModel> root) {
		List<Predicate> predicates = new ArrayList<>();

		//where descricao like '% campo %' 
		if(!ObjectUtils.isEmpty(PlantaFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get("nome")), "%" + PlantaFilter.getNome().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	

	private void adicionarRestricoesDePaginacao(TypedQuery<PlantaModel> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(PlantaFilter PlantaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<PlantaModel> root = criteria.from(PlantaModel.class);
		
		Predicate[] predicates = criarRestricoes(PlantaFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
}
