package com.fralermo.springbootNgDemo.infra.database.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Prices")
@Data
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long priceList;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity product;

	@ManyToOne
	@JoinColumn(name="brand_id")
	private BrandEntity brand;

	
	private Long priority;
	
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name="currency_iso")
	private CurrencyEntity currency;
	
}
