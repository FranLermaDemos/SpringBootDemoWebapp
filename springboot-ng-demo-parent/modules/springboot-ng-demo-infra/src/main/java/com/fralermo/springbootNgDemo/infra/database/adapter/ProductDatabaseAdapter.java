package com.fralermo.springbootNgDemo.infra.database.adapter;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fralermo.springbootNgDemo.application.ports.ProductPort;
import com.fralermo.springbootNgDemo.domain.entities.Product;
import com.fralermo.springbootNgDemo.infra.database.mapper.EntityMapper;
import com.fralermo.springbootNgDemo.infra.database.repository.ProductJPARepository;

@Service
public class ProductDatabaseAdapter implements ProductPort {
	
	private static EntityMapper mapper;

	static {
		mapper = Mappers.getMapper(EntityMapper.class);
	}
	
	@Autowired
	private ProductJPARepository productRepository;
	
	
	@Override
	public Optional<Product> findProduct(Long productId) {
		return this.productRepository.findById(productId).stream().map(x -> mapper.convertEntityProductToDomainProduct(x)).findAny();
	}
	
}
