package com.fralermo.springbootNgDemo.infra.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Brands")
@Data
public class BrandEntity {
	
	@Id
	private Long brandId;
	private String brandName;

}
