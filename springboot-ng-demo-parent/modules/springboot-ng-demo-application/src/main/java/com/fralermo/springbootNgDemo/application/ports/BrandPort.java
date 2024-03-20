package com.fralermo.springbootNgDemo.application.ports;

import java.util.List;
import java.util.Optional;

import com.fralermo.springbootNgDemo.domain.entities.Brand;

public interface BrandPort {
	
	public List<Brand> findAll();
	
	public Optional<Brand> findBrand(Long brandId);
	
}
