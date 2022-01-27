package com.svasconcellosj.controlapi.plantas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.svasconcellosj.controlapi.plantas.model.PlantaModel;
import com.svasconcellosj.controlapi.plantas.repository.consult.PlantaRepositoryQuery;

@Repository
public interface PlantaRepository extends JpaRepository<PlantaModel, Long>, PlantaRepositoryQuery {

}
