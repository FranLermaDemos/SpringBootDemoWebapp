package com.fralermo.springbootNgDemo.infra.rest.dto.input;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class PriceRequestDTO {

	private Long productId;
	
	private String currencyISO;
	
	private Long brandId;
	
	private Long priority;
	
	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss+00:00", iso = ISO.DATE_TIME)
	private LocalDateTime startDate;
	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss+00:00", iso = ISO.DATE_TIME)
	private LocalDateTime endDate;
	
	private BigDecimal price;
	
}
