package com.fralermo.springbootNgDemo.infra.rest.dto.output;

import lombok.Data;

@Data
public class ProductResponseDTO {
	private Long productId;
	private String description;
}
