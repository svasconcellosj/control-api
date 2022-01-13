package com.svasconcellosj.controlapi.lancamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.svasconcellosj.controlapi.lancamentos.model.LancamentoModel;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoModel, Long> {

}
