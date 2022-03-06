package com.svasconcellosj.controlapi.categorias.subcategorias.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.svasconcellosj.controlapi.categorias.subcategorias.model.SubcategoriaModel;

@Repository
public interface SubcategoriaRepository extends JpaRepository<SubcategoriaModel, Long> {
	
	@Query("SELECT s FROM SubcategoriaModel s WHERE s.idCategoria.id = ?1")
	public Page<SubcategoriaModel> findByidCategoria(Long id, Pageable pageable);

}
