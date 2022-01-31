package com.svasconcellosj.controlapi.contas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.svasconcellosj.controlapi.contas.model.ContaModel;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Long> {

}
