package com.svasconcellosj.controlapi.contas.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConsultaSaldos {
	
	private BigDecimal saldo;

}
