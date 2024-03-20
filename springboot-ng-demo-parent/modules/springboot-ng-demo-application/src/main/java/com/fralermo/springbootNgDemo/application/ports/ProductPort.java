package com.fralermo.springbootNgDemo.application.ports;

import java.util.Optional;

import com.fralermo.springbootNgDemo.domain.entities.Product;


public interface ProductPort {

	public Optional<Product> findProduct(Long productId);
	
}
