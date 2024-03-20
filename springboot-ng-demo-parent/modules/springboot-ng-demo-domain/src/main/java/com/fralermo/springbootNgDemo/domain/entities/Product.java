package com.fralermo.springbootNgDemo.domain.entities;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Product {

	private Long productId;
	private String description;
	
}
