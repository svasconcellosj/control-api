package com.svasconcellosj.controlapi.lancamentos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.svasconcellosj.controlapi.lancamentos.model.TipoLancamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LancamentoTipoEstatistica {

	private TipoLancamento tipo;
	private LocalDate mes;
	private BigDecimal total;

}
