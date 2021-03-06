package com.svasconcellosj.controlapi.contas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.svasconcellosj.controlapi.contas.dto.ConsultaSaldos;
import com.svasconcellosj.controlapi.contas.model.ContaModel;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Long> {
	
	public List<ContaModel> findByOrderByDescricaoAsc();

	@Query(value = "SELECT new com.svasconcellosj.controlapi.contas.dto.ConsultaSaldos(SUM(c.saldo)) FROM ContaModel c")
	public ConsultaSaldos findSumSaldo();
}
