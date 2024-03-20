package com.fralermo.springbootNgDemo.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Price {

	private Long priceList;
	
	private Product product;
	
	private Brand brand;

	
	private Long priority;
	
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	private BigDecimal price;
	
	private Currency currency;
	
}
