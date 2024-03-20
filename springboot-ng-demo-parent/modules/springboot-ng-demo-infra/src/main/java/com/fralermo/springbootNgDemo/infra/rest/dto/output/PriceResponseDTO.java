package com.fralermo.springbootNgDemo.infra.rest.dto.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class PriceResponseDTO {
	
	private Long priceList;
	
	private ProductResponseDTO product;
	
	private BrandResponseDTO brand;

	private Long priority;
	
	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss+00:00", iso = ISO.DATE_TIME)
	private LocalDateTime startDate;
	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss+00:00", iso = ISO.DATE_TIME)
	private LocalDateTime endDate;
	
	private BigDecimal price;
	
	private CurrencyResponseDTO currency;

}