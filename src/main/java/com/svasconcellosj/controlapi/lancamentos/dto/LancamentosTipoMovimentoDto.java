package com.svasconcellosj.controlapi.lancamentos.dto;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.svasconcellosj.controlapi.lancamentos.model.MovimentoLancamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LancamentosTipoMovimentoDto {
	

	@Enumerated(EnumType.STRING)
	private MovimentoLancamento movimento;
	
	private BigDecimal total;

}
