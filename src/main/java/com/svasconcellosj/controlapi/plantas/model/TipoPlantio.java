package com.svasconcellosj.controlapi.plantas.model;

public enum TipoPlantio {
	
	ESTAQUIA("Estaquia"),
	SEMENTE("Semente"),
	ALPORQUIA("Alporquia");
	
	private final String tipoPlantio;
	
	private TipoPlantio(String descricao) {
		this.tipoPlantio = descricao;
	}
	
	public String getTipoPlantio() {
		return tipoPlantio;
	}

}
