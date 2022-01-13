package com.svasconcellosj.controlapi.categorias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.svasconcellosj.controlapi.categorias.model.CategoriaModel;
import com.svasconcellosj.controlapi.categorias.repository.consult.CategoriaRepositoryQuery;
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>, CategoriaRepositoryQuery {

}
