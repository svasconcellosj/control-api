package com.svasconcellosj.controlapi.plantas.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.svasconcellosj.controlapi.plantas.model.PlantaModel;
import com.svasconcellosj.controlapi.plantas.repository.PlantaRepository;
import com.svasconcellosj.controlapi.plantas.repository.filter.PlantaFilter;

@Service
public class PlantaService {

	@Autowired
	private PlantaRepository plantaRepository;
	
	public Page<PlantaModel> Pesquisar(PlantaFilter plantaFilter, Pageable pageable) {
		return plantaRepository.filtrar(plantaFilter, pageable);		
	}
	
	public List<PlantaModel> buscaTodos() {
		return plantaRepository.findAll();
	}
	
	public PlantaModel grava(PlantaModel planta) {
		return plantaRepository.save(planta);
	}
	
	public PlantaModel buscaId(Long id) {
		return plantaRepository.findById(id).orElse(null);
	}
	
	public void exclui(PlantaModel planta) {
		plantaRepository.delete(planta);
	}
	
	public PlantaModel altera(Long id, PlantaModel planta) {
		PlantaModel plantaModel = buscaId(id);
		if ( plantaModel == null ) {
			return null;
		}
		BeanUtils.copyProperties(planta, plantaModel, "id");
		return grava(plantaModel);
	}
	
}
