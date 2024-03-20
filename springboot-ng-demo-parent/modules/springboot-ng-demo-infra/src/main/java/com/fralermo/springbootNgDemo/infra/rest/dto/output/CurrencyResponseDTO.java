package com.fralermo.springbootNgDemo.infra.rest.dto.output;

import lombok.Data;

@Data
public class CurrencyResponseDTO {
	private String iso;
	private String symbol;
}
