package com.fralermo.springbootNgDemo.infra.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Products")
@Getter @Setter
public class ProductEntity {

	@Id
	private Long productId;
	private String description;
	
//	@OneToMany
//	private List<PriceEntity> prices;
	
}
