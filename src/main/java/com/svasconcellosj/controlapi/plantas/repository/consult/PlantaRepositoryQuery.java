package com.svasconcellosj.controlapi.plantas.repository.consult;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.svasconcellosj.controlapi.plantas.model.PlantaModel;
import com.svasconcellosj.controlapi.plantas.repository.filter.PlantaFilter;

public interface PlantaRepositoryQuery {
	
	public Page<PlantaModel> filtrar(PlantaFilter plantaFilter, Pageable pageable);

}
